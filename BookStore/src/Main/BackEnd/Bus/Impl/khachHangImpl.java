/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main.BackEnd.Bus.Impl;

import Main.BackEnd.Bus.khachHang;
import Main.BackEnd.repository.dao.KHACHHANGDAO;
import Main.BackEnd.repository.dao.TAIKHOANDAO;
import Main.BackEnd.repository.modal.KHACHANG;
import Main.BackEnd.repository.modal.TAIKHOAN;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class khachHangImpl implements khachHang{

    KHACHHANGDAO khachHangDao = new KHACHHANGDAO();
    TAIKHOANDAO taiKhoanDao = new TAIKHOANDAO();
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
    public KHACHANG timKiemMaKhachHang(KHACHANG khachang) {
        return khachHangDao.selectById(khachang);
    }

    @Override
    public Boolean themKhachHangCoTK(KHACHANG khachang,TAIKHOAN tk) {
        //Kiem Tra tk Ton Tai
        
        return khachHangDao.insertCOTK(khachang,tk)==0;    
    }

    @Override
    public Boolean suaKhachHangCoTK(KHACHANG khachang, TAIKHOAN tk) {
        return khachHangDao.updateCOTK(khachang,tk)==0;    
    }
    
    @Override
    public String xuatExcel() {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("danhSachKhachHang");
        
        XSSFRow row =null;
        Cell cell=null;
        
        String []colums ={"MKH","username","hoten","diachi","email","dienthoai","ngaytao","tttk"};
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
            row.createCell(1).setCellValue(khachHang.getUsername());
            row.createCell(2).setCellValue(khachHang.getHoten());
            row.createCell(3).setCellValue(khachHang.getDiachi());
            row.createCell(4).setCellValue(khachHang.getEmail());
            row.createCell(5).setCellValue(khachHang.getDienthoai());
            if(khachHang.getNgaytao()!=null){
                row.createCell(6).setCellValue(dateFormat.format(khachHang.getNgaytao()));
            }
            row.createCell(7).setCellValue(khachHang.isTttk());
        }
        try {
            File f = new File("excel/danhsach.xlsx");
            FileOutputStream fis;
            fis = new FileOutputStream(f);
            workbook.write(fis);
            fis.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return "";
    }
    
}
