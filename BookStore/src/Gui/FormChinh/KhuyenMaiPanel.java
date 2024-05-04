/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Gui.FormChinh;

import Dto.KHUYENMAI;
import Gui.FormAdd.AddKhuyenMai;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import static org.apache.logging.log4j.util.Strings.isBlank;
import com.github.lgooddatepicker.components.DatePicker;
import java.util.ArrayList;
import Bus.Impl.KhuyenMailmpl;


/**
 *
 * @author DELL
 */
public class KhuyenMaiPanel extends javax.swing.JPanel {
    /**
     * Creates new form KhuyenMaiPanel
     */
    KhuyenMailmpl khuyenMailmpl = new KhuyenMailmpl();
    
    public KhuyenMaiPanel() {
        initComponents();
    }
    public void loadKhuyenMaiToTable(){
        DefaultTableModel model = (DefaultTableModel) DataKhuyenMai.getModel();
        model.setRowCount(0);

        try {
            System.out.print("hoạt động");
            ArrayList<KHUYENMAI> listKhuyenMai = khuyenMailmpl.getAllKM();

            for (KHUYENMAI khuyenmai : listKhuyenMai) {
                Object[] row = {khuyenmai.getMakhuyenmai(),khuyenmai.getNgaytao(),khuyenmai.getNgaybatdau(),khuyenmai.getNgayketthuc(),khuyenmai.getTongtiencanthiet(),khuyenmai.getPhantramgiam()};
                model.addRow(row);
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

        PanelTimKiem = new javax.swing.JPanel();
        search = new javax.swing.JButton();
        thuoctinh = new javax.swing.JComboBox<>();
        inputsearch = new javax.swing.JTextField();
        ChonNgay1 = new javax.swing.JButton();
        ChonNgay2 = new javax.swing.JButton();
        from = new javax.swing.JTextField();
        to = new javax.swing.JTextField();
        Them = new javax.swing.JButton();
        Xoa = new javax.swing.JButton();
        Sua = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        scroll1 = new javax.swing.JScrollPane();
        DataKhuyenMai = new javax.swing.JTable();

        setBackground(new java.awt.Color(0, 153, 153));
        setPreferredSize(new java.awt.Dimension(1250, 428));

        PanelTimKiem.setBackground(new java.awt.Color(0, 153, 153));
        PanelTimKiem.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tìm kiếm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI Black", 0, 14), new java.awt.Color(204, 255, 204))); // NOI18N

        search.setBackground(new java.awt.Color(0, 204, 204));
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
        thuoctinh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mã Khuyến Mãi", "Tổng tiền cần thiết", "% giảm" }));
        thuoctinh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                thuoctinhActionPerformed(evt);
            }
        });

        inputsearch.setBackground(new java.awt.Color(204, 255, 204));
        inputsearch.setForeground(new java.awt.Color(0, 51, 51));
        inputsearch.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tất Cả", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12), new java.awt.Color(0, 51, 51))); // NOI18N
        inputsearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputsearchActionPerformed(evt);
            }
        });

        ChonNgay1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_calendar_31_30px.png"))); // NOI18N
        ChonNgay1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ChonNgay1ActionPerformed(evt);
            }
        });

        ChonNgay2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_calendar_31_30px.png"))); // NOI18N
        ChonNgay2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ChonNgay2ActionPerformed(evt);
            }
        });

        from.setEditable(false);
        from.setBackground(new java.awt.Color(204, 255, 204));
        from.setForeground(new java.awt.Color(0, 51, 51));
        from.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Từ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(0, 51, 51))); // NOI18N
        from.setFocusable(false);
        from.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fromActionPerformed(evt);
            }
        });

        to.setEditable(false);
        to.setBackground(new java.awt.Color(204, 255, 204));
        to.setForeground(new java.awt.Color(0, 51, 51));
        to.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Đến", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(0, 51, 51))); // NOI18N
        to.setFocusable(false);

        javax.swing.GroupLayout PanelTimKiemLayout = new javax.swing.GroupLayout(PanelTimKiem);
        PanelTimKiem.setLayout(PanelTimKiemLayout);
        PanelTimKiemLayout.setHorizontalGroup(
            PanelTimKiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelTimKiemLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(thuoctinh, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(inputsearch, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(ChonNgay1)
                .addGap(5, 5, 5)
                .addComponent(from, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(ChonNgay2)
                .addGap(5, 5, 5)
                .addComponent(to, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        PanelTimKiemLayout.setVerticalGroup(
            PanelTimKiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelTimKiemLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(PanelTimKiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(search, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(inputsearch, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                    .addComponent(thuoctinh, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(to, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ChonNgay1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(from, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(ChonNgay2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        Them.setBackground(new java.awt.Color(204, 255, 204));
        Them.setForeground(new java.awt.Color(0, 51, 51));
        Them.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_add_30px.png"))); // NOI18N
        Them.setText("Thêm khuyến mãi");
        Them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ThemActionPerformed(evt);
            }
        });

        Xoa.setBackground(new java.awt.Color(204, 255, 204));
        Xoa.setForeground(new java.awt.Color(0, 51, 51));
        Xoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_delete_30px_1.png"))); // NOI18N
        Xoa.setText("Kết thúc khuyến mãi");
        Xoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                XoaActionPerformed(evt);
            }
        });

        Sua.setBackground(new java.awt.Color(204, 255, 204));
        Sua.setForeground(new java.awt.Color(0, 51, 51));
        Sua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_maintenance_30px.png"))); // NOI18N
        Sua.setText("Sửa Thông tin khuyến mãi");
        Sua.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                SuaAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        Sua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SuaActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(0, 204, 204));

        scroll1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông Tin Khuyến Mãi", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI Black", 0, 14), new java.awt.Color(0, 51, 51))); // NOI18N

        DataKhuyenMai.setAutoCreateRowSorter(true);
        DataKhuyenMai.setBackground(new java.awt.Color(204, 255, 204));
        DataKhuyenMai.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        DataKhuyenMai.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã khuyến mãi", "Ngày tạo", "Ngày bắt đầu", "Ngày kết thúc", "Tổng tiền cần thiết", "% giảm"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        DataKhuyenMai.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        DataKhuyenMai.setShowGrid(false);
        DataKhuyenMai.setShowHorizontalLines(true);
        DataKhuyenMai.setShowVerticalLines(true);
        scroll1.setViewportView(DataKhuyenMai);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scroll1, javax.swing.GroupLayout.PREFERRED_SIZE, 1232, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scroll1, javax.swing.GroupLayout.PREFERRED_SIZE, 517, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(PanelTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(Them, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Sua)))
                        .addGap(27, 27, 27)
                        .addComponent(Xoa))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PanelTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Them)
                            .addComponent(Xoa))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Sua)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) DataKhuyenMai.getModel();
        model.setRowCount(0);

        String kieuTimKiem = (String) thuoctinh.getSelectedItem();
        String inputText = inputsearch.getText();
        if (isBlank(inputText)) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập từ khóa cần tìm", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }
        /*ArrayList<NHANVIEN> tkList = nhanVienImpl1.timKiem(kieuTimKiem,inputText);
        for (NHANVIEN nhanVien : tkList) {
            Object[] row = {nhanVien.getManv(), nhanVien.getHoten(), nhanVien.getNgaytao(),nhanVien.getDiachi(),nhanVien.getDienthoai(),nhanVien.getEmail()};
            model.addRow(row);
        }*/
    }//GEN-LAST:event_searchActionPerformed

    private void thuoctinhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_thuoctinhActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_thuoctinhActionPerformed

    private void inputsearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputsearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputsearchActionPerformed

    private void ThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ThemActionPerformed
        // TODO add your handling code here:
        AddKhuyenMai x = new AddKhuyenMai();
        x.setVisible(true);
        x.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(java.awt.event.WindowEvent windowEvent) {
                loadKhuyenMaiToTable();
            }
        });
    }//GEN-LAST:event_ThemActionPerformed

    private void XoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_XoaActionPerformed
        // TODO add your handling code here:
        int selectedRowIdx = DataKhuyenMai.getSelectedRow();
        if (selectedRowIdx != -1) {
            Object value = DataKhuyenMai.getModel().getValueAt(selectedRowIdx, 0);
            int intValue = Integer.parseInt(value.toString());
            KHUYENMAI khuyenmai = new KHUYENMAI(intValue);
            khuyenMailmpl.deleteKhuyeMai(khuyenmai);
            loadKhuyenMaiToTable();
        }else{
            JOptionPane.showMessageDialog(this, "Vui Lòng Chọn tài khoản muốn xóa", "Lỗi", JOptionPane.INFORMATION_MESSAGE);

        }
    }//GEN-LAST:event_XoaActionPerformed

    private void SuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SuaActionPerformed
        // TODO add your handling code here:
        int selectedRowIdx = DataKhuyenMai.getSelectedRow();
//        if (selectedRowIdx != -1) {
//            EditKhuyenMai y = new EditKhuyenMai();
//            y.setVisible(true);
//            Object value = KhachHangtb.getModel().getValueAt(selectedRowIdx, 0);
//            String valueAsString = value.toString();
//            y.addThongTin(valueAsString);
//            y.addWindowListener(new java.awt.event.WindowAdapter() {
//                @Override
//                public void windowClosed(java.awt.event.WindowEvent windowEvent) {
//                    loadBooksToTable();
//                }
//            });
//        }else{
//            JOptionPane.showMessageDialog(this, "Vui Lòng Chọn tài khoản muốn Sửa", "Lỗi", JOptionPane.INFORMATION_MESSAGE);
//
//        }
    }//GEN-LAST:event_SuaActionPerformed

    private void ChonNgay1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ChonNgay1ActionPerformed
        // TODO add your handling code here:
        DatePicker datePicker = new DatePicker();
        datePicker.setDateToToday();//đặt mặc định là hôm nay
        datePicker.addDateChangeListener((dce) -> {
            from.setText(datePicker.getDateStringOrEmptyString());//set text cho cái textfiled from
        });
    JOptionPane.showMessageDialog(this, datePicker, "Chọn ngày bắt đầu", JOptionPane.PLAIN_MESSAGE);
    }//GEN-LAST:event_ChonNgay1ActionPerformed

    private void fromActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fromActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fromActionPerformed

    private void ChonNgay2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ChonNgay2ActionPerformed
        // TODO add your handling code here:
        DatePicker datePicker = new DatePicker();
        datePicker.setDateToToday();//đặt mặc định là hôm nay
        datePicker.addDateChangeListener((dce) -> {
            to.setText(datePicker.getDateStringOrEmptyString());//set text cho cái textfiled from
        });
    JOptionPane.showMessageDialog(this, datePicker, "Chọn ngày kết thúc", JOptionPane.PLAIN_MESSAGE);
    }//GEN-LAST:event_ChonNgay2ActionPerformed

    private void SuaAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_SuaAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_SuaAncestorAdded
    public void hide_button(){
        Them.setVisible(false);
        Xoa.setVisible(false);
        Sua.setVisible(false);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ChonNgay1;
    private javax.swing.JButton ChonNgay2;
    private javax.swing.JTable DataKhuyenMai;
    private javax.swing.JPanel PanelTimKiem;
    private javax.swing.JButton Sua;
    private javax.swing.JButton Them;
    private javax.swing.JButton Xoa;
    private javax.swing.JTextField from;
    private javax.swing.JTextField inputsearch;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane scroll1;
    private javax.swing.JButton search;
    private javax.swing.JComboBox<String> thuoctinh;
    private javax.swing.JTextField to;
    // End of variables declaration//GEN-END:variables
}
