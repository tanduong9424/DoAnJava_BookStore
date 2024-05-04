/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Bus;

import Dto.TAIKHOAN;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public interface TaiKhoan {
    Boolean themTaiKhoan(TAIKHOAN taiKhoan);
    Boolean xoaTaiKhoan(TAIKHOAN taiKhoan);
    Boolean suaTaiKhoan(TAIKHOAN taiKhoan);
    ArrayList<TAIKHOAN> timKiem(String kieuTimKiem,String inputText);
    ArrayList<TAIKHOAN> getAllTaiKhoan();
    TAIKHOAN checkDangNhapTK(String taiKhoan);
    Boolean checkDangNhapMK(TAIKHOAN taiKhoan,String input);
}
