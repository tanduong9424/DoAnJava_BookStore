/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Bus;

import Dto.KHACHANG;
import Dto.NHANVIEN;
import Dto.TAIKHOAN;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public interface NhanVien {
    Boolean themNhanVien(NHANVIEN taiKhoan);
    Boolean xoaNhanVien(NHANVIEN taiKhoan);
    Boolean suaNhanVien(NHANVIEN taiKhoan);
    ArrayList<NHANVIEN> timKiem(String text,String kieuTimKiem);
    ArrayList<NHANVIEN> getAllTaiKhoan();
    NHANVIEN getByID(NHANVIEN nhanvien);
    NHANVIEN getNamebyTk(TAIKHOAN t);
}