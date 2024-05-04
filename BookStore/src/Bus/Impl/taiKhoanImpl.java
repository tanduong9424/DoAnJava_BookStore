/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bus.Impl;

import Bus.TaiKhoan;
import Dao.KHACHHANGDAO;
import Dao.NHANVIENDAO;
import Dao.TAIKHOANDAO;
import Dto.KHACHANG;
import Dto.NHANVIEN;
import Dto.TAIKHOAN;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class taiKhoanImpl implements TaiKhoan {
    TAIKHOANDAO taiKhoanDao = new TAIKHOANDAO();
    KHACHHANGDAO khachHangDao = new KHACHHANGDAO();
    NHANVIENDAO nhanVienDao =new NHANVIENDAO();
    
    @Override
    public Boolean themTaiKhoan(TAIKHOAN taiKhoan) {
        return taiKhoanDao.insert(taiKhoan)==0;
    }
    
    @Override
    public TAIKHOAN checkDangNhapTK(String taiKhoan) {
        return taiKhoanDao.CheckTK(taiKhoan);
    }
    
    @Override
    public Boolean checkDangNhapMK(TAIKHOAN taiKhoan,String input) {
        return taiKhoanDao.CheckMK(taiKhoan,input);
    }
    
    @Override
    public Boolean xoaTaiKhoan(TAIKHOAN taiKhoan) {
         return taiKhoanDao.delete(taiKhoan)==0;
    }
    
    @Override
    public Boolean suaTaiKhoan(TAIKHOAN taiKhoan) {
        return taiKhoanDao.update(taiKhoan)==0;
    }

    @Override
    public ArrayList<TAIKHOAN> timKiem(String kieuTimKiem, String inputText) {
        ArrayList<TAIKHOAN> result = new ArrayList<>();
        ArrayList<TAIKHOAN> dstk = taiKhoanDao.selectAll();
        
        dstk.forEach((tk) -> {
            switch (kieuTimKiem) {
                case "Họ và Tên"://admin không có họ tên nên chỉ có nv,kh thôi
                   KHACHANG ketqua1 = khachHangDao.SearchKHByID(tk);//tạo mới 1 kh bằng tk.makh để lấy ra họ tên kh
                   NHANVIEN ketqua2 = nhanVienDao.SearchNVByID(tk);//tạo mơi 1 nv bằng tk.manv để lấy ra họ tên nv
                    if(ketqua1!=null){
                        if (ketqua1.getHoten().toLowerCase().contains(inputText.toLowerCase())) {//so sánh họ tên
                           result.add(tk);
                        }
                    }
                    else if(ketqua2!=null){
                      if (ketqua2.getHoten().toLowerCase().contains(inputText.toLowerCase())) {//so sánh họ tên
                           result.add(tk);
                       }
                   }
                    break;
                   
                case "Tên Tài Khoản":
                    if (tk.getUSERNAME().toLowerCase().contains(inputText.toLowerCase())) {//so sánh tên tài khảon
                        result.add(tk);
                    }
                    break;
                case "Chức Năng":
                    if (tk.getROLE().toLowerCase().contains(inputText.toLowerCase())) {//so sánh chức năng
                        result.add(tk);
                    }
                    break;       
            }
        });
        return result;    
    }
    
    @Override
    public ArrayList<TAIKHOAN> getAllTaiKhoan() {
        return taiKhoanDao.selectAll();    
    }
    
}
