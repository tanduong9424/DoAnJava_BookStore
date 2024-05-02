/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Gui.FormChinh;

import Bus.Impl.khachHangImpl;
import Bus.Impl.nhanVienImpl;
import Bus.Impl.taiKhoanImpl;
import Dao.TAIKHOANDAO;
import Dto.KHACHANG;
import Dto.NHANVIEN;
import Dto.TAIKHOAN;
import Gui.FormAdd.AddTaiKhoan;
import Gui.FormEdit.EditTaiKhoan;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import static org.apache.logging.log4j.util.Strings.isBlank;


/**
 *
 * @author DELL
 */
public class TaiKhoanPanel extends javax.swing.JPanel {
    
    taiKhoanImpl taiKhoanImpl = new taiKhoanImpl();
    nhanVienImpl nhanVienImpl1 = new nhanVienImpl();
    khachHangImpl khacHangImpl = new khachHangImpl();
    
    /**
     * Creates new form TaiKhoanPanel
     */
    public TaiKhoanPanel() {
        initComponents();
    }
    public void loadTaiKhoanToTable(){
        DefaultTableModel model = (DefaultTableModel) account.getModel();
        model.setRowCount(0);

        try {
            System.out.print("hoạt động");
            ArrayList<TAIKHOAN> listTaiKhoan = taiKhoanImpl.getAllTaiKhoan();

            for (TAIKHOAN taiKhoan : listTaiKhoan) {
                NHANVIEN nhanvien = nhanVienImpl1.getByID(new NHANVIEN(taiKhoan.getMANV()));
                KHACHANG khachhang = khacHangImpl.getByID(new KHACHANG(taiKhoan.getMAKH()));
                if(nhanvien!=null){
                    Object[] row = {nhanvien.getHoten(), taiKhoan.getUSERNAME(), taiKhoan.getPASSWORD(), taiKhoan.getROLE(), null};
                    model.addRow(row);
                }else{
                    if(khachhang!= null){
                        Object[] row = {khachhang.getHoten(), taiKhoan.getUSERNAME(), taiKhoan.getPASSWORD(), taiKhoan.getROLE(), null};
                        model.addRow(row);
                    }
                    else{
                        Object[] row = {null, taiKhoan.getUSERNAME(), taiKhoan.getPASSWORD(), taiKhoan.getROLE(),null};
                        model.addRow(row);
                    }
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Suabtn = new javax.swing.JButton();
        Xoabtn = new javax.swing.JButton();
        Thembtn = new javax.swing.JButton();
        PanelTimKiem = new javax.swing.JPanel();
        search = new javax.swing.JButton();
        thuoctinh = new javax.swing.JComboBox<>();
        inputsearch = new javax.swing.JTextField();
        detailAccount = new javax.swing.JPanel();
        scroll1 = new javax.swing.JScrollPane();
        account = new javax.swing.JTable();

        setBackground(new java.awt.Color(0, 153, 153));

        Suabtn.setBackground(new java.awt.Color(204, 255, 204));
        Suabtn.setForeground(new java.awt.Color(0, 51, 51));
        Suabtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_maintenance_30px.png"))); // NOI18N
        Suabtn.setText("Đổi Mật Khẩu");
        Suabtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SuabtnActionPerformed(evt);
            }
        });

        Xoabtn.setBackground(new java.awt.Color(204, 255, 204));
        Xoabtn.setForeground(new java.awt.Color(0, 51, 51));
        Xoabtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_delete_30px_1.png"))); // NOI18N
        Xoabtn.setText("Xóa Tài Khoản");
        Xoabtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                XoabtnActionPerformed(evt);
            }
        });

        Thembtn.setBackground(new java.awt.Color(204, 255, 204));
        Thembtn.setForeground(new java.awt.Color(0, 51, 51));
        Thembtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_add_30px.png"))); // NOI18N
        Thembtn.setText("Thêm Tài Khoản");
        Thembtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ThembtnActionPerformed(evt);
            }
        });

        PanelTimKiem.setBackground(new java.awt.Color(0, 153, 153));
        PanelTimKiem.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tìm kiếm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI Black", 0, 14), new java.awt.Color(204, 255, 204))); // NOI18N

        search.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-magnifying-glass-30.png"))); // NOI18N
        search.setBorder(null);
        search.setContentAreaFilled(false);
        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });

        thuoctinh.setBackground(new java.awt.Color(204, 255, 204));
        thuoctinh.setForeground(new java.awt.Color(0, 51, 51));
        thuoctinh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Họ và Tên", "Tên Tài Khoản", "Chức Năng" }));
        thuoctinh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                thuoctinhActionPerformed(evt);
            }
        });

        inputsearch.setBackground(new java.awt.Color(204, 255, 204));
        inputsearch.setForeground(new java.awt.Color(0, 51, 51));
        inputsearch.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Họ và Tên", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI Black", 0, 12), new java.awt.Color(0, 51, 51))); // NOI18N
        inputsearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputsearchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelTimKiemLayout = new javax.swing.GroupLayout(PanelTimKiem);
        PanelTimKiem.setLayout(PanelTimKiemLayout);
        PanelTimKiemLayout.setHorizontalGroup(
            PanelTimKiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelTimKiemLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(thuoctinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(inputsearch, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(search)
                .addGap(0, 0, 0))
        );
        PanelTimKiemLayout.setVerticalGroup(
            PanelTimKiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelTimKiemLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(PanelTimKiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(search, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(thuoctinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputsearch))
                .addGap(0, 0, 0))
        );

        detailAccount.setBackground(new java.awt.Color(0, 204, 204));

        scroll1.setBackground(new java.awt.Color(0, 204, 204));
        scroll1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, " Thông tin tài khoản truy cập hệ thống", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI Black", 0, 12), new java.awt.Color(0, 51, 51))); // NOI18N

        account.setBackground(new java.awt.Color(204, 255, 204));
        account.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        account.setForeground(new java.awt.Color(0, 0, 51));
        account.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Họ  và Tên", "Tên TK", "Mật khẩu", "Vai Trò"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        account.setShowGrid(true);
        scroll1.setViewportView(account);

        javax.swing.GroupLayout detailAccountLayout = new javax.swing.GroupLayout(detailAccount);
        detailAccount.setLayout(detailAccountLayout);
        detailAccountLayout.setHorizontalGroup(
            detailAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(detailAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(detailAccountLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(scroll1, javax.swing.GroupLayout.DEFAULT_SIZE, 1160, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        detailAccountLayout.setVerticalGroup(
            detailAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 604, Short.MAX_VALUE)
            .addGroup(detailAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(detailAccountLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(scroll1, javax.swing.GroupLayout.PREFERRED_SIZE, 518, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(80, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(PanelTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Thembtn)
                .addGap(30, 30, 30)
                .addComponent(Xoabtn)
                .addGap(30, 30, 30)
                .addComponent(Suabtn)
                .addGap(400, 400, 400))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(detailAccount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Thembtn)
                            .addComponent(Xoabtn)
                            .addComponent(Suabtn)))
                    .addComponent(PanelTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(detailAccount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void SuabtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SuabtnActionPerformed
        // TODO add your handling code here:
        
        int selectedRowIdx = account.getSelectedRow();
        if (selectedRowIdx != -1) {
            EditTaiKhoan y = new EditTaiKhoan();
            y.setVisible(true);
            Object role = account.getValueAt(selectedRowIdx, 3);
           
            Object value = account.getModel().getValueAt(selectedRowIdx, 1);
            String valueAsString = value.toString();
            y.addThongTin(valueAsString);
            y.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosed(java.awt.event.WindowEvent windowEvent) {
                    loadTaiKhoanToTable();
                }
            });
        }else{
            JOptionPane.showMessageDialog(this, "Vui Lòng Chọn tài khoản muốn Sửa", "Lỗi", JOptionPane.INFORMATION_MESSAGE);

        }
    }//GEN-LAST:event_SuabtnActionPerformed

    private void XoabtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_XoabtnActionPerformed
        // TODO add your handling code here:
        int selectedRowIdx = account.getSelectedRow();
        if (selectedRowIdx != -1) { 
            Object value = account.getModel().getValueAt(selectedRowIdx, 1); 
            TAIKHOAN taikhoan = new TAIKHOAN(value.toString());
            int confirmResult = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn xóa không?", "Xác nhận xóa", JOptionPane.YES_NO_OPTION);
            if (confirmResult == JOptionPane.YES_OPTION) {
                taiKhoanImpl.xoaTaiKhoan(taikhoan);
            loadTaiKhoanToTable();
            }
            
        }else{
            JOptionPane.showMessageDialog(this, "Vui Lòng Chọn tài khoản muốn xóa", "Lỗi", JOptionPane.INFORMATION_MESSAGE);

        }
    }//GEN-LAST:event_XoabtnActionPerformed

    private void ThembtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ThembtnActionPerformed
        // TODO add your handling code here:
        AddTaiKhoan x=new AddTaiKhoan();
        x.setVisible(true);
        x.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(java.awt.event.WindowEvent windowEvent) {
                loadTaiKhoanToTable();
            }
        });
    }//GEN-LAST:event_ThembtnActionPerformed

    private void thuoctinhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_thuoctinhActionPerformed
        // TODO add your handling code here:
        String title=(String) thuoctinh.getSelectedItem(); 
        inputsearch.setBorder(javax.swing.BorderFactory.createTitledBorder(null, title, javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI Black", 0, 12), new java.awt.Color(0, 51, 51)));
        inputsearch.setText("");
        loadTaiKhoanToTable();
    }//GEN-LAST:event_thuoctinhActionPerformed

    private void inputsearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputsearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputsearchActionPerformed

    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed
        String kieuTimKiem = (String) thuoctinh.getSelectedItem();
        String inputText = inputsearch.getText();
        inputsearch.setText("");
        if (isBlank(inputText)) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập từ khóa cần tìm", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }
        else{
            DefaultTableModel model = (DefaultTableModel) account.getModel();
            model.setRowCount(0);
            
            ArrayList<TAIKHOAN> tkList = taiKhoanImpl.timKiem(kieuTimKiem,inputText);
            //trả về 1 list tài khoản chứa thông tin tìm kiếm theo kiểu tìm kiếm
            for (TAIKHOAN taiKhoan : tkList) {
            //duyệt list, tìm nhân viên/khách hàng/admin ứng với username được lọc ra
                NHANVIEN nhanvien = nhanVienImpl1.getNamebyTk(taiKhoan);
                KHACHANG khachhang = khacHangImpl.getNamebyTk(taiKhoan);
                //TAIKHOAN admin = taiKhoanImpl.getByUsername(taiKhoan);
                
                if(nhanvien!=null){
                    Object[] row = {nhanvien.getHoten(), taiKhoan.getUSERNAME(), taiKhoan.getPASSWORD(), taiKhoan.getROLE()};
                    model.addRow(row);
                }
                else if (khachhang!=null){
                    Object[] row = {khachhang.getHoten(), taiKhoan.getUSERNAME(), taiKhoan.getPASSWORD(), taiKhoan.getROLE()};
                    model.addRow(row);
                }
                else if (taiKhoan!=null){
                    Object[] row = {null, taiKhoan.getUSERNAME(), taiKhoan.getPASSWORD(), taiKhoan.getROLE()};
                    model.addRow(row);
                }
                
            }
    }//GEN-LAST:event_searchActionPerformed

    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelTimKiem;
    private javax.swing.JButton Suabtn;
    private javax.swing.JButton Thembtn;
    private javax.swing.JButton Xoabtn;
    private javax.swing.JTable account;
    private javax.swing.JPanel detailAccount;
    private javax.swing.JTextField inputsearch;
    private javax.swing.JScrollPane scroll1;
    private javax.swing.JButton search;
    private javax.swing.JComboBox<String> thuoctinh;
    // End of variables declaration//GEN-END:variables
}
