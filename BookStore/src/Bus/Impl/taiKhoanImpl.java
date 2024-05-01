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
    public TAIKHOAN checkDangNhap(TAIKHOAN taiKhoan) {
        return taiKhoanDao.selectByAccount(taiKhoan);
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
                case "Họ và Tên":
                    KHACHANG ketqua1 = khachHangDao.selectByUsername(new KHACHANG(tk.getUSERNAME()));
                    if(ketqua1!=null){
                        if (ketqua1.getHoten().toLowerCase().contains(inputText.toLowerCase())) {
                            result.add(tk);
                        }
                    }
                    NHANVIEN ketqua2 = nhanVienDao.selectByUsername(new NHANVIEN(tk.getUSERNAME()));
                    if(ketqua2!=null){
                        if (ketqua2.getHoten().toLowerCase().contains(inputText.toLowerCase())) {
                            result.add(tk);
                        }
                    }
                    break;
                   
                    
                case "Tên Tài Khoản":
                    if (tk.getUSERNAME().toLowerCase().contains(inputText.toLowerCase())) {
                        result.add(tk);
                    }
                    break;
                case "Chức Năng":
                    if (tk.getROLE().toLowerCase().contains(inputText.toLowerCase())) {
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
