/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bus.Impl;

import Bus.KhuyenMai;
import Dao.KHUYENMAIDAO;
import Dto.KHUYENMAI;
import java.util.ArrayList;
import javax.swing.JComboBox;

/**
 *
 * @author Admin
 */
public class KhuyenMailmpl implements KhuyenMai{

    @Override
    public void danhsachKhuyenMai(JComboBox model) {
        model.removeAllItems();
        ArrayList<KHUYENMAI> result=KHUYENMAIDAO.getInstance().selectActivePromotionsToday();
        for (KHUYENMAI tk : result) {
            String row = tk.toString(); // Điều chỉnh dữ liệu tùy thuộc vào cách bạn muốn hiển thị
            model.addItem(row);
        }
       }

    @Override
    public void addKhuyenMai(KHUYENMAI t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void deleteKhuyeMai(KHUYENMAI t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void updateKhuyenMai(KHUYENMAI t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
