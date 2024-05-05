/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bus.Impl;

import Bus.khachHang;
import Dao.KHACHHANGDAO;
import Dto.KHACHANG;
import Dto.TAIKHOAN;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class khachHangImpl implements khachHang{

    KHACHHANGDAO khachHangDao = new KHACHHANGDAO();
    

    
    @Override
    public Boolean themKhachHang(KHACHANG khachang) {
        return khachHangDao.insert(khachang)==0;
    }
    
    @Override
    public Boolean suaKhachHang(KHACHANG khachang) {
        return khachHangDao.update(khachang)==0;
    }

   @Override
    public Boolean xoaKhachHang(KHACHANG khachang) {
         return khachHangDao.delete(khachang)==0;
    }   
    @Override
    public KHACHANG getByID(KHACHANG khachang) {
        return khachHangDao.selectById(khachang);
    }
    @Override
    public KHACHANG getNamebyTk(TAIKHOAN t) {
        return khachHangDao.SearchKHByID(t);
    }
   @Override
    public ArrayList<KHACHANG> timKiem(String text,String kieuTimKiem) {
        ArrayList<KHACHANG> result = khachHangDao.timkiemNangCao(text,kieuTimKiem);
        return result;    
    }   

    @Override
    public Boolean xuatExcel() {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("danhSachKhachHang");
        
        XSSFRow row =null;
        Cell cell=null;
        
        String []colums ={"MKH","hoten","diachi","email","dienthoai","ngaytao","tttk"};
        row=sheet.createRow(0);
        for(int i =0;i<colums.length;i++){
            cell=row.createCell(i);
            cell.setCellValue(colums[i]);
        }
        ArrayList<KHACHANG> danhSachKhachHang = khachHangDao.selectAll();
        int rowNum = 1;
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        for (KHACHANG khachHang : danhSachKhachHang) {
            row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(khachHang.getMakh());
            row.createCell(1).setCellValue(khachHang.getHoten());
            row.createCell(2).setCellValue(khachHang.getDiachi());
            row.createCell(3).setCellValue(khachHang.getEmail());
            row.createCell(4).setCellValue(khachHang.getDienthoai());
            row.createCell(5).setCellValue(khachHang.isTttk());
        }
        try {
            File f = new File("excel/khachhang.xlsx");
            FileOutputStream fis;
            fis = new FileOutputStream(f);
            workbook.write(fis);
            fis.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            return false;

        } catch (IOException ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public ArrayList<KHACHANG> selectAll() {
        return khachHangDao.selectAll();
    }
        
}