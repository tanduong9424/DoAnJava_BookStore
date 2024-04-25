/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Bus;


import Dto.KHACHANG;
import Dto.TAIKHOAN;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public interface khachHang {
    Boolean themKhachHang(KHACHANG khachang);
    Boolean themKhachHangCoTK(KHACHANG khachang,TAIKHOAN tk);
    Boolean xoaKhachHang(KHACHANG khachang);
    Boolean suaKhachHang(KHACHANG khachang);
    Boolean suaKhachHangCoTK(KHACHANG khachang,TAIKHOAN tk);
    ArrayList<KHACHANG> timKiem(String kieuTimKiem,String inputText);
    Boolean xuatExcel();
    KHACHANG getByUsername(TAIKHOAN t);
}
