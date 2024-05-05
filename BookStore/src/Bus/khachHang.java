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
    Boolean xoaKhachHang(KHACHANG khachang);
    Boolean suaKhachHang(KHACHANG khachang);
    ArrayList<KHACHANG> timKiem(String text,String kieuTimKiem);
    Boolean xuatExcel();
    ArrayList<KHACHANG> selectAll();
    KHACHANG getByID(KHACHANG khachang);
    KHACHANG getNamebyTk(TAIKHOAN t);
}
