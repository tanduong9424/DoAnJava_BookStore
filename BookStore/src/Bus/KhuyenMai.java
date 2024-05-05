/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Bus;

import Dto.KHUYENMAI;
import java.util.ArrayList;
import javax.swing.JComboBox;

/**
 *
 * @author Admin
 */
public interface KhuyenMai {
    void danhsachKhuyenMai(JComboBox model,int tongtien);
    Boolean addKhuyenMai(KHUYENMAI t);
    Boolean deleteKhuyeMai(KHUYENMAI t);
    Boolean updateKhuyenMai(KHUYENMAI t);
    ArrayList<KHUYENMAI> getAllKM();
    ArrayList<KHUYENMAI> timKiem(String kieuTimKiem,String inputText,String fromDate , String toDate);
}
