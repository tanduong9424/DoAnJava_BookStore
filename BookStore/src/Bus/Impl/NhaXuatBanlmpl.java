/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bus.Impl;

import Bus.NhaXuatBan;
import Dao.NHAXUATBANDAO;
import Dto.NHAXUATBAN;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class NhaXuatBanlmpl implements NhaXuatBan{

    @Override
    public void themNhaXuatBan(NHAXUATBAN t) {
        NHAXUATBANDAO.getInstance().insert(t);
    }

    @Override
    public void updateNhaXuatBan(NHAXUATBAN t) {
        NHAXUATBANDAO.getInstance().update(t);
    }

    @Override
    public void xoaNhaXuatBan(NHAXUATBAN t) {
        NHAXUATBANDAO.getInstance().delete(t);
    }

    @Override
    public void danhsachNHAXUATBAN(JComboBox model) {
        model.removeAllItems();
        ArrayList<NHAXUATBAN> result=NHAXUATBANDAO.getInstance().selectAll();
        for (NHAXUATBAN nxb : result) {
            String row = nxb.getTENNHAXUATBAN(); // Điều chỉnh dữ liệu tùy thuộc vào cách bạn muốn hiển thị
            model.addItem(row);
        }
    }
    
}