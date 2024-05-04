/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bus.Impl;

import Bus.NhapHang;
import Dao.CHITIETPHIEUNHAPDAO;
import Dao.PHIEUNHAPDAO;
import Dao.SACHDAO;
import Dto.CHITIETPHIEUNHAP;
import Dto.NHANVIEN;
import Dto.PHIEUNHAP;
import Dto.SACH;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class NhapHanglmpl implements NhapHang{

    @Override
    public void NhapSach(SACH t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void SuaSach(SACH t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void XoaSach(SACH t) {
        if(t!=null){
            SACHDAO.getInstance().delete(t);
            System.out.println("da xoa thanh cong");
        }
    }

    @Override
    public void danhSachSanPham(DefaultTableModel model) {
            ArrayList<SACH> sachList = SACHDAO.getInstance().selectAllExceptISHIDDEN();

            for (SACH sach : sachList) {
                Object[] row = {sach.getMASACH(), sach.getTENSACH(),sach.getGIABIA(), sach.getTENNHAXUATBAN()};
                model.addRow(row);
            }
    }

    @Override
    public void danhSachPhieuNhap(DefaultTableModel model) {
            ArrayList<PHIEUNHAP> hoadonList = PHIEUNHAPDAO.getInstance().selectAll();
            
            for (PHIEUNHAP hoadon : hoadonList) {             
                Object[] row = {hoadon.getMapn(),hoadon.getManv(),hoadon.getNoinhap(),hoadon.getNgaynhap(),hoadon.getTongtien()};
                model.addRow(row);
            }
    }

    @Override
    public void danhSachChiTietPhieuNhap(DefaultTableModel model, PHIEUNHAP t) {
            ArrayList<CHITIETPHIEUNHAP> chitiethoadonList = CHITIETPHIEUNHAPDAO.getInstance().selectAllByPHIEUNHAP(t);
            for (CHITIETPHIEUNHAP chitiethoadon : chitiethoadonList) {
                SACH sach=new SACH(chitiethoadon.getMASACH());
                SACH result=SACHDAO.getInstance().selectById(sach);
                Object[] row = {chitiethoadon.getMASACH(),result.getTENSACH(),result.getGIABIA(),chitiethoadon.getSoluong(),chitiethoadon.getTongtien()};
                model.addRow(row);
            }
    }



    @Override
    public void xoaPhieuNhap(PHIEUNHAP t) {
      PHIEUNHAPDAO.getInstance().delete(t);
    }

    @Override
    public void PhieuNhapDatabase(PHIEUNHAP t, NHANVIEN nv, DefaultTableModel dataModel) {
                int kq=PHIEUNHAPDAO.getInstance().insertCONOINHAP(t, nv);
//        thêm các trường hợp có tài khoản và có mã khuyến mãi
        if(kq!=0){         
        PHIEUNHAP hd=new PHIEUNHAP(kq);
        PHIEUNHAP result=PHIEUNHAPDAO.getInstance().selectById(hd);
        for(int i=0;i<dataModel.getRowCount();i++){
            int masach=(int) dataModel.getValueAt(i, 0);
            int giatien=(int) dataModel.getValueAt(i, 2);
            int sl=(int) dataModel.getValueAt(i, 3);
            int tongtien=(int) dataModel.getValueAt(i, 4);
            CHITIETPHIEUNHAP ct=new CHITIETPHIEUNHAP(result.getMapn(),masach,giatien,sl,tongtien);
            CHITIETPHIEUNHAPDAO.getInstance().insert(ct);
            SACH sach=new SACH(masach);
            SACHDAO.getInstance().thuhoiSACH(sach, sl);
        }
        }
    }

    @Override
    public void TaoChiTietPhieuNhap(DefaultTableModel dataModel, SACH t, int sl) {
        Object[] row={t.getMASACH(),t.getTENSACH(),t.getGIABIA(),sl,t.getGIABIA()*sl};
        dataModel.addRow(row);
    }

    @Override
    public void BoChiTietHoaDon(DefaultTableModel dataModel, int row) {
        System.out.println("da xoa "+row);
        dataModel.removeRow(row);
    }
    
}
