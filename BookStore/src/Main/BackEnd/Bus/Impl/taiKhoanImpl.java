/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main.BackEnd.Bus.Impl;

import Main.BackEnd.Bus.TaiKhoan;
import Main.BackEnd.repository.dao.KHACHHANGDAO;
import Main.BackEnd.repository.dao.TAIKHOANDAO;
import Main.BackEnd.repository.modal.KHACHANG;
import Main.BackEnd.repository.modal.TAIKHOAN;
import java.util.ArrayList;



/**
 *
 * @author Admin
 */
public class taiKhoanImpl implements TaiKhoan{
    TAIKHOANDAO taiKhoanDao = new TAIKHOANDAO();
    KHACHHANGDAO khachHangDao = new KHACHHANGDAO();

    @Override
    public Boolean themTaiKhoan(TAIKHOAN taiKhoan) {
        return taiKhoanDao.insert(taiKhoan)==0;
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
                    KHACHANG ketqua = khachHangDao.selectByUsername(new TAIKHOAN(tk.getUSERNAME()));
                    if(ketqua!=null){
                        if (ketqua.getHoten().toLowerCase().contains(inputText.toLowerCase())) {
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
