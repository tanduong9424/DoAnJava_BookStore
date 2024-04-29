/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Bus;

import Dto.NHAXUATBAN;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public interface NhaXuatBan {
    void themNhaXuatBan(NHAXUATBAN t);
    void updateNhaXuatBan(NHAXUATBAN t);
    void xoaNhaXuatBan(NHAXUATBAN t);
    void danhsachNHAXUATBAN(JComboBox model);
}