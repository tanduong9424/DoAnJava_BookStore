/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Bus;

import Dto.KHUYENMAI;
import javax.swing.JComboBox;

/**
 *
 * @author Admin
 */
public interface KhuyenMai {
    void danhsachKhuyenMai(JComboBox model);
    void addKhuyenMai(KHUYENMAI t);
    void deleteKhuyeMai(KHUYENMAI t);
    void updateKhuyenMai(KHUYENMAI t);
}
