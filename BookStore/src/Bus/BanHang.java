/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Bus;

import Dto.HOADON;
import Dto.KHACHANG;
import Dto.KHUYENMAI;
import Dto.NHANVIEN;
import Dto.SACH;
import Dto.TAIKHOAN;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public interface BanHang {
    void danhSachHoaDon(DefaultTableModel model);
    void danhSachSanPham(DefaultTableModel model);
    void timSanPham(javax.swing.JTable dataModel,String searchText,DefaultTableModel model);
    void timHoaDon(javax.swing.JTable dataModel,String searchText,DefaultTableModel model);
    void chiTietHoaDon(HOADON t,DefaultTableModel model,javax.swing.JTextField sum);
    void TaomoiChiTietHoaDon(DefaultTableModel dataModel,SACH t,int sl);
    void BoChiTietHoaDon(DefaultTableModel dataModel,int row);
    void TaoHoaDonDatabase(HOADON t,NHANVIEN nv,KHACHANG tk,KHUYENMAI km,DefaultTableModel dataModel);
    void XoaHoaDonDatabase(HOADON t);
    void danhsachKhachHang(JComboBox model);
    void HOANTHANHHOADON(HOADON t);
    void CHUAHOANTHANHHOADON(HOADON t);
}