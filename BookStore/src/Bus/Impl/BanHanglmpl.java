/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bus.Impl;

import Bus.BanHang;
import Dao.CHITIETHOADONDAO;
import Dao.HOADONDAO;
import Dao.KHACHHANGDAO;
import Dao.KHUYENMAIDAO;
import Dao.NHAXUATBANDAO;
import Dao.SACHDAO;
import Dao.TAIKHOANDAO;
import Dto.CHITIETHOADON;
import Dto.HOADON;
import Dto.KHACHANG;
import Dto.KHUYENMAI;
import Dto.NHANVIEN;
import Dto.NHAXUATBAN;
import Dto.SACH;
import Dto.TAIKHOAN;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class BanHanglmpl implements BanHang{

    @Override
    public void danhSachHoaDon(DefaultTableModel model) {
            ArrayList<HOADON> hoadonList = HOADONDAO.getInstance().selectAll();
            for (HOADON hoadon : hoadonList) {
                int makhuyenmai=0;
                int phantramgiam=0;
                    makhuyenmai=hoadon.getMakhuyenmai();
                    KHUYENMAI km=KHUYENMAIDAO.getInstance().selectById(new KHUYENMAI(hoadon.getMakhuyenmai()));
                    if(km!=null){
                        phantramgiam=km.getPhantramgiam();
                    }                
                Object[] row = {hoadon.getMAHOADON(),hoadon.getManv(),hoadon.getmakh(),hoadon.getNGAYLAP(),makhuyenmai,phantramgiam,hoadon.getTONGTIEN(),hoadon.isTthd()};
                model.addRow(row);
            }
    }

    @Override
    public void danhSachSanPham(DefaultTableModel model) {
            ArrayList<SACH> sachList = SACHDAO.getInstance().selectAllExceptISHIDDEN();

            for (SACH sach : sachList) {
                Object[] row = {sach.getMASACH(), sach.getTENSACH(), sach.getSOLUONG(), sach.getGIABIA(), sach.getTENNHAXUATBAN()};
                model.addRow(row);
            }
    }

    @Override
    public void timSanPham(javax.swing.JTable Sachtb,String searchText,DefaultTableModel dataModel) {
                if (searchText == null || searchText.trim().isEmpty()) {
            // Nếu rỗng, không làm gì cả và thoát phương thức
            return;
        }

        // Tạo một bảng tạm thời để lưu các dòng được lọc
        DefaultTableModel tempModel = new DefaultTableModel();
        tempModel.setColumnIdentifiers(new Object[]{"MaSach","TenSach","Soluong","DonGia","NhaXB"});

        // Kiểm tra xem dataHoadon có rỗng không
        if (Sachtb != null) {
            // Lặp qua từng dòng trong bảng dataHoadon
            for (int i = 0; i < Sachtb.getRowCount(); i++) {
                // Kiểm tra xem giá trị có phải là String không và không rỗng
                String mahoadon = Sachtb.getValueAt(i, 0).toString().trim();
                String tensach=Sachtb.getValueAt(i,1).toString().trim();
                String soluong=Sachtb.getValueAt(i,2).toString().trim();
                String dongia=Sachtb.getValueAt(i,3).toString().trim();
                String nhaxb=Sachtb.getValueAt(i,4).toString().trim();
                // Kiểm tra xem nếu giá trị này chứa nội dung tìm kiếm
                if (mahoadon.equalsIgnoreCase(searchText.trim()) || tensach.equalsIgnoreCase(searchText.trim())||
                        soluong.equalsIgnoreCase(searchText.trim()) || dongia.equalsIgnoreCase(searchText.trim())||
                        nhaxb.equalsIgnoreCase(searchText.trim())) {
                    // Nếu có, thêm dòng này vào bảng tạm thời
                    Object[] row = {
                        Sachtb.getValueAt(i, 0),
                        Sachtb.getValueAt(i, 1),
                        Sachtb.getValueAt(i, 2), 
                        Sachtb.getValueAt(i, 3), 
                        Sachtb.getValueAt(i, 4), 
                    };
                    tempModel.addRow(row);
                }
            }
        }
        // Xóa toàn bộ dòng trong dataHoadon
        dataModel.setRowCount(0);
        // Thêm các dòng từ DefaultTableModel tạm thời vào dataHoadon
        for (int i = 0; i < tempModel.getRowCount(); i++) {
            Object[] row = new Object[dataModel.getColumnCount()];
            for (int j = 0; j < dataModel.getColumnCount(); j++) {
                row[j] = tempModel.getValueAt(i, j);
            }
            dataModel.addRow(row);
        }
    }

    @Override
    public void chiTietHoaDon(HOADON t,DefaultTableModel model,javax.swing.JTextField sum) {
            ArrayList<CHITIETHOADON> chitiethoadonList = CHITIETHOADONDAO.getInstance().selectByIDHOADON(t);
            int tongtien=0;
            for (CHITIETHOADON chitiethoadon : chitiethoadonList) {
                SACH sach=new SACH(chitiethoadon.getMASACH());
                SACH result=SACHDAO.getInstance().selectById(sach);
                Object[] row = {chitiethoadon.getMASACH(),result.getTENSACH(),chitiethoadon.getSOLUONG(),chitiethoadon.getGIATIEN(),chitiethoadon.getTHANHTIEN()};
                model.addRow(row);
                tongtien+=chitiethoadon.getTHANHTIEN();
            }
            sum.setText(""+tongtien);
    }

    @Override
    public void timHoaDon(javax.swing.JTable dataHoadon,String searchText,DefaultTableModel dataModel) {
        if (searchText == null || searchText.trim().isEmpty()) {
            return;
    }
    
    // Tạo một bảng tạm thời để lưu các dòng được lọc
    DefaultTableModel tempModel = new DefaultTableModel();
    tempModel.setColumnIdentifiers(new Object[]{"MAHOADON", "Manv", "TENTAIKHOAN", "NGAYLAP", "Makhuyenmai", "Phantramgiam", "TONGTIEN","tttk"});
    
    // Kiểm tra xem dataHoadon có rỗng không
    if (dataHoadon != null) {
        // Lặp qua từng dòng trong bảng dataHoadon
        for (int i = 0; i < dataHoadon.getRowCount(); i++) {
            // Kiểm tra xem giá trị có phải là String không và không rỗng
String mahoadon = dataHoadon.getValueAt(i, 0) != null ? dataHoadon.getValueAt(i, 0).toString().trim() : "null";
String manv = dataHoadon.getValueAt(i, 1) != null ? dataHoadon.getValueAt(i, 1).toString().trim() : "null";
String makh = dataHoadon.getValueAt(i, 2) != null ? dataHoadon.getValueAt(i, 2).toString().trim() : "null";
String ngaylap = dataHoadon.getValueAt(i, 3) != null ? dataHoadon.getValueAt(i, 3).toString().trim() : "null";
String makm = dataHoadon.getValueAt(i, 4) != null ? dataHoadon.getValueAt(i, 4).toString().trim() : "null";
String phantramgiam = dataHoadon.getValueAt(i, 5) != null ? dataHoadon.getValueAt(i, 5).toString().trim() : "null";
String tongtien = dataHoadon.getValueAt(i, 6) != null ? dataHoadon.getValueAt(i, 6).toString().trim() : "null";
String tttk=dataHoadon.getValueAt(i, 7) != null ? dataHoadon.getValueAt(i, 7).toString().trim() : "null";

                // Kiểm tra xem nếu giá trị này chứa nội dung tìm kiếm
                if (mahoadon.equalsIgnoreCase(searchText.trim()) || manv.equalsIgnoreCase(searchText.trim()) ||
                        makh.equalsIgnoreCase(searchText.trim()) || ngaylap.equalsIgnoreCase(searchText.trim())||
                        makm.equalsIgnoreCase(searchText.trim()) || phantramgiam.equalsIgnoreCase(searchText.trim())||
                        tongtien.equalsIgnoreCase(searchText.trim()) || tttk.equalsIgnoreCase(searchText.trim())) {
                    // Nếu có, thêm dòng này vào bảng tạm thời
                    Object[] row = {
                        dataHoadon.getValueAt(i, 0),
                        dataHoadon.getValueAt(i, 1),
                        dataHoadon.getValueAt(i, 2), // TENKHACHHANG
                        dataHoadon.getValueAt(i, 3), // NGAYLAP
                        dataHoadon.getValueAt(i, 4), // Makhuyenmai
                        dataHoadon.getValueAt(i, 5), // Phantramgiam
                        dataHoadon.getValueAt(i, 6),  // TONGTIEN;
                        dataHoadon.getValueAt(i, 7)
                    };
                    tempModel.addRow(row);
                }
        }
    }
    dataModel.setRowCount(0);
    // Thêm các dòng từ DefaultTableModel tạm thời vào dataHoadon
    for (int i = 0; i < tempModel.getRowCount(); i++) {
        Object[] row = new Object[dataModel.getColumnCount()];
        for (int j = 0; j < dataModel.getColumnCount(); j++) {
            row[j] = tempModel.getValueAt(i, j);
        }
        dataModel.addRow(row);
    }
    
}

    @Override
    public void TaomoiChiTietHoaDon(DefaultTableModel dataModel, SACH t, int sl) {
        Object[] row={t.getMASACH(),t.getTENSACH(),sl,t.getGIABIA(),t.getGIABIA()*sl};
        dataModel.addRow(row);
    }
//chưa xong
    @Override
    public void TaoHoaDonDatabase(HOADON t,NHANVIEN nv,KHACHANG tk,KHUYENMAI km,DefaultTableModel dataModel) {
        
        
        int kq=0;
        if(km!=null){
            KHUYENMAI resultkm=KHUYENMAIDAO.getInstance().selectById(km);
            kq=HOADONDAO.getInstance().insertHOADONCOTKCOMAKM(t,tk,resultkm,nv);
        }
        else{
            kq=HOADONDAO.getInstance().insertHOADONCOTKKOMAKM(t, tk, nv);
        }
        
//        thêm các trường hợp có tài khoản và có mã khuyến mãi
        if(kq!=0){         
        HOADON hd=new HOADON(kq);
        HOADON result=HOADONDAO.getInstance().selectById(hd);
        for(int i=0;i<dataModel.getRowCount();i++){
            int masach=(int) dataModel.getValueAt(i, 0);
            int sl=(int) dataModel.getValueAt(i, 2);
            int giatien=(int) dataModel.getValueAt(i, 3);
            int tongtien=(int) dataModel.getValueAt(i, 4);
            CHITIETHOADON ct=new CHITIETHOADON(result.getMAHOADON(),masach,giatien,tongtien,sl);
            CHITIETHOADONDAO.getInstance().insert(ct);
        }
        }
    }

    @Override
    public void BoChiTietHoaDon(DefaultTableModel dataModel, int row) {
        dataModel.removeRow(row);
    }

    @Override
    public void XoaHoaDonDatabase(HOADON t) {
        HOADON result=HOADONDAO.getInstance().selectById(t);
        HOADONDAO.getInstance().delete(result);
    }

    @Override
    public void danhsachKhachHang(JComboBox model) {
        model.removeAllItems();
        ArrayList<KHACHANG> result=KHACHHANGDAO.getInstance().selectAll();
        for (KHACHANG tk : result) {
            String row = tk.toString(); // Điều chỉnh dữ liệu tùy thuộc vào cách bạn muốn hiển thị
            model.addItem(row);
        }
    }

    @Override
    public void HOANTHANHHOADON(HOADON t) {
        if(t.isTthd()==false){
            HOADONDAO.getInstance().updateHOANTHANH(t);
            HOADONDAO.getInstance().XacNhanHoaDon(t);
        } 
    }

    @Override
    public void CHUAHOANTHANHHOADON(HOADON t) {
        HOADONDAO.getInstance().updateCHUAHOANTHANH(t);
    }


}
