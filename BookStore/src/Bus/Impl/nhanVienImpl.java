/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bus.Impl;

import Bus.NhanVien;
import Dao.NHANVIENDAO;
import Dto.KHACHANG;
import Dto.NHANVIEN;
import Dto.TAIKHOAN;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Admin
 */
public class nhanVienImpl implements NhanVien{

    NHANVIENDAO nhanVienDao = new NHANVIENDAO();
    
    @Override
    public Boolean themNhanVien(NHANVIEN taiKhoan) {
        return nhanVienDao.insert(taiKhoan)==0;
    }

    @Override
    public Boolean xoaNhanVien(NHANVIEN taiKhoan) {
        return nhanVienDao.delete(taiKhoan)==0;
    }

    @Override
    public Boolean suaNhanVien(NHANVIEN taiKhoan) {
        return nhanVienDao.update(taiKhoan)==0;
    }

    @Override
    public ArrayList<NHANVIEN> timKiem(String kieuTimKiem, String inputText) {
        ArrayList<NHANVIEN> result = new ArrayList<>();
        ArrayList<NHANVIEN> dsnv = nhanVienDao.selectAll();
        dsnv.forEach((nv) -> {
         switch (kieuTimKiem) {
            case "Mã Khách Hàng":
                if (String.valueOf(nv.getManv()).toLowerCase().contains(inputText.toLowerCase())) {
                    result.add(nv);
                }
                break;
            case "Tên Khách Hàng":
                if (nv.getHoten() != null && nv.getHoten().toLowerCase().contains(inputText.toLowerCase())) {
                    result.add(nv);
                }
                break;
            case "Địa Chỉ":
                if (nv.getDiachi() != null && nv.getDiachi().toLowerCase().contains(inputText.toLowerCase())) {
                    result.add(nv);
                }
                break;
            case "Số Điện Thoại":
                if (String.valueOf(nv.getDienthoai()).toLowerCase().contains(inputText.toLowerCase())) {
                    result.add(nv);
                }
                break;
            case "Email":
                if (nv.getEmail() != null && nv.getEmail().toLowerCase().contains(inputText.toLowerCase())) {
                    result.add(nv);
                }
                break;        
        }

        });

        return result;    }

    @Override
    public ArrayList<NHANVIEN> getAllTaiKhoan() {
        return nhanVienDao.selectAll();
    }

    @Override
    public Boolean themNhanVienCoTK(NHANVIEN nhanvien, TAIKHOAN tk) {
        return nhanVienDao.insertCOTK(nhanvien, tk)==0;    
    }
    @Override
    public NHANVIEN getByUsername(NHANVIEN nhanvien) {
        return nhanVienDao.selectByUsername(nhanvien);
    }

    public boolean xuatExcel() {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("danhSachKhachHang");
        
        XSSFRow row =null;
        Cell cell=null;
        
        String []colums ={"MNV","username","hoten","diachi","email","dienthoai","ngaytao","tttk"};
        row=sheet.createRow(0);
        for(int i =0;i<colums.length;i++){
            cell=row.createCell(i);
            cell.setCellValue(colums[i]);
        }
        ArrayList<NHANVIEN> danhsachnhanvien = nhanVienDao.selectAll();
        int rowNum = 1;
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        for (NHANVIEN nhanvien : danhsachnhanvien) {
            row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(nhanvien.getManv());
            row.createCell(1).setCellValue(nhanvien.getUsername());
            row.createCell(2).setCellValue(nhanvien.getHoten());
            row.createCell(3).setCellValue(nhanvien.getDiachi());
            row.createCell(4).setCellValue(nhanvien.getEmail());
            row.createCell(5).setCellValue(nhanvien.getDienthoai());
            if(nhanvien.getNgaytao()!=null){
                row.createCell(6).setCellValue(dateFormat.format(nhanvien.getNgaytao()));
            }
            row.createCell(7).setCellValue(nhanvien.isTttk());
        }
        try {
            File f = new File("excel/nhanvien.xlsx");
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
        return true;    }
}
