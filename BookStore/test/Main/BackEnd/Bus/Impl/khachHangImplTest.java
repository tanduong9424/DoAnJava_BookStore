/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Main.BackEnd.Bus.Impl;

import Main.BackEnd.repository.modal.KHACHANG;
import org.junit.Test;
import Main.BackEnd.repository.database.JDBCUtil;
import Main.BackEnd.repository.modal.TAIKHOAN;
import java.sql.Connection;

/**
 *
 * @author Admin
 */
public class khachHangImplTest {
    khachHangImpl instance = new khachHangImpl();
    
    public khachHangImplTest() {
        
    }
    @Test
    public void ketNoiMysql() {
       Connection con=JDBCUtil.getConnection();
    }
    @Test
    public void testThemKhachHang() {
        java.util.Date birthDate = new java.util.Date(System.currentTimeMillis()); 
        java.sql.Date sqlBirthDate = new java.sql.Date(birthDate.getTime());
        KHACHANG khachang = new KHACHANG(1, "dao3", "dao3333", "dao", "dao@gma.com", 837002627, sqlBirthDate,true);
        instance.themKhachHang(khachang);
    }
    @Test
    public void testThemKhachHangCOTK() {
        java.util.Date birthDate = new java.util.Date(System.currentTimeMillis()); 
        java.sql.Date sqlBirthDate = new java.sql.Date(birthDate.getTime());
        KHACHANG khachang = new KHACHANG(1, "dao3", "dao3333", "dao", "dao@gma.com", 837002627, sqlBirthDate,true);
        TAIKHOAN taikhoan = new TAIKHOAN("huy");
        instance.themKhachHangCoTK(khachang,taikhoan);
    }
    @Test
    public void testXuatExcel() {
        instance.xuatExcel();
    }


    @Test
    public void testSuaKhachHang() {
        java.util.Date birthDate = new java.util.Date(System.currentTimeMillis()); 
        java.sql.Date sqlBirthDate = new java.sql.Date(birthDate.getTime());
        KHACHANG khachang = new KHACHANG(1, "dao33333333", "daonek", "dao", "dao@gma.com", 837002627, sqlBirthDate,true);
        instance.suaKhachHang(khachang);
    }

    @Test
    public void testXoaKhachHang() {
        java.util.Date birthDate = new java.util.Date(System.currentTimeMillis()); 
        java.sql.Date sqlBirthDate = new java.sql.Date(birthDate.getTime());
        KHACHANG khachang = new KHACHANG(1, "dao33333333", "daonek", "dao", "dao@gma.com", 837002627, sqlBirthDate,true);
        instance.xoaKhachHang(khachang);
    }

    @Test
    public void testTimKiemMaKhachHang() {
        java.util.Date birthDate = new java.util.Date(System.currentTimeMillis()); 
        java.sql.Date sqlBirthDate = new java.sql.Date(birthDate.getTime());
        KHACHANG khachang = new KHACHANG(1, "dao33333333", "daonek", "dao", "dao@gma.com", 837002627, sqlBirthDate,true);
        
    }
    
}
