/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Bus;

import Dto.PHIEUNHAP;
import Dto.SACH;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public interface NhapHang {
    public void NhapSach(SACH t);
    public void SuaSach(SACH t);
    public void XoaSach(SACH t);
    void danhSachSanPham(DefaultTableModel model);
    void danhSachPhieuNhap(DefaultTableModel model);
    void danhSachChiTietPhieuNhap(DefaultTableModel model,PHIEUNHAP t);
    void themPhieuNhap(PHIEUNHAP t);
    void xoaPhieuNhap(PHIEUNHAP t);
}
