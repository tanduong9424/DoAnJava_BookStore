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
    
    KHUYENMAIDAO khuyenmaidao = new KHUYENMAIDAO();
    @Override
    public void danhsachKhuyenMai(JComboBox model) {
        model.removeAllItems();
        ArrayList<KHUYENMAI> result=khuyenmaidao.selectActivePromotionsToday();
        for (KHUYENMAI tk : result) {
            String row = tk.toString(); // Điều chỉnh dữ liệu tùy thuộc vào cách bạn muốn hiển thị
            model.addItem(row);
        }
       }

    @Override
    public Boolean addKhuyenMai(KHUYENMAI t) {
        return khuyenmaidao.insert(t)==0;    
    }

    @Override
    public Boolean deleteKhuyeMai(KHUYENMAI t) {
        return khuyenmaidao.delete(t)==0;    
    }

    @Override
    public Boolean updateKhuyenMai(KHUYENMAI t) {
        return khuyenmaidao.update(t)==0;    
    }

    @Override
    public ArrayList<KHUYENMAI> getAllKM() {
        return khuyenmaidao.selectAll();  
    }
    
    
}
