/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Main.FrontEnd;
/**
 *
 * @author xuand
 */
public class KhachHangPanel extends javax.swing.JPanel {

    /**
     * Creates new form KhachHangPanel
     */
    public KhachHangPanel() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        XuatExcel = new javax.swing.JButton();
        NhapExcel = new javax.swing.JButton();
        Them = new javax.swing.JButton();
        Xoa = new javax.swing.JButton();
        Sua = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        ThongTinKhachHang = new javax.swing.JScrollPane();
        DataKhachHang = new javax.swing.JTable();
        PanelTimKiem9 = new javax.swing.JPanel();
        TimKiem9 = new javax.swing.JButton();
        ThuocTinhTimKiem9 = new javax.swing.JComboBox<>();
        GiaTriTimKiem9 = new javax.swing.JTextField();

        setBackground(new java.awt.Color(0, 153, 153));

        XuatExcel.setBackground(new java.awt.Color(204, 255, 204));
        XuatExcel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_ms_excel_30px.png"))); // NOI18N
        XuatExcel.setText("Xuất Excel");
        XuatExcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                XuatExcelActionPerformed(evt);
            }
        });

        NhapExcel.setBackground(new java.awt.Color(204, 255, 204));
        NhapExcel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_ms_excel_30px.png"))); // NOI18N
        NhapExcel.setText("Nhập Excel");
        NhapExcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NhapExcelActionPerformed(evt);
            }
        });

        Them.setBackground(new java.awt.Color(204, 255, 204));
        Them.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_add_30px.png"))); // NOI18N
        Them.setText("Thêm");
        Them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ThemActionPerformed(evt);
            }
        });

        Xoa.setBackground(new java.awt.Color(204, 255, 204));
        Xoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_support_30px.png"))); // NOI18N
        Xoa.setText("Xóa");
        Xoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                XoaActionPerformed(evt);
            }
        });

        Sua.setBackground(new java.awt.Color(204, 255, 204));
        Sua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_delete_30px_1.png"))); // NOI18N
        Sua.setText("Sửa");
        Sua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SuaActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(0, 204, 204));

        ThongTinKhachHang.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin Khách Hàng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI Black", 0, 12))); // NOI18N

        DataKhachHang.setBackground(new java.awt.Color(0, 204, 204));
        DataKhachHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã khách hàng", "Tên khách hàng", "Địa chỉ", "Số Điện Thoại", "Email"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        DataKhachHang.setRowSelectionAllowed(false);
        DataKhachHang.setShowGrid(true);
        ThongTinKhachHang.setViewportView(DataKhachHang);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(ThongTinKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 1027, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(49, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ThongTinKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        PanelTimKiem9.setBackground(new java.awt.Color(0, 153, 153));
        PanelTimKiem9.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tìm kiếm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI Black", 0, 14))); // NOI18N

        TimKiem9.setBackground(new java.awt.Color(0, 204, 204));
        TimKiem9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-magnifying-glass-30.png"))); // NOI18N
        TimKiem9.setBorder(null);
        TimKiem9.setContentAreaFilled(false);

        ThuocTinhTimKiem9.setBackground(new java.awt.Color(255, 255, 255));
        ThuocTinhTimKiem9.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mã Khách Hàng", "Tên Khách Hàng", "Địa Chỉ", "Số Điện Thoại", "Email" }));
        ThuocTinhTimKiem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ThuocTinhTimKiem9ActionPerformed(evt);
            }
        });

        GiaTriTimKiem9.setBackground(new java.awt.Color(255, 255, 255));
        GiaTriTimKiem9.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tất Cả", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI Black", 0, 10))); // NOI18N
        GiaTriTimKiem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GiaTriTimKiem9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelTimKiem9Layout = new javax.swing.GroupLayout(PanelTimKiem9);
        PanelTimKiem9.setLayout(PanelTimKiem9Layout);
        PanelTimKiem9Layout.setHorizontalGroup(
            PanelTimKiem9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelTimKiem9Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(ThuocTinhTimKiem9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(GiaTriTimKiem9, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(TimKiem9, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        PanelTimKiem9Layout.setVerticalGroup(
            PanelTimKiem9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelTimKiem9Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(PanelTimKiem9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(TimKiem9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(GiaTriTimKiem9)
                    .addComponent(ThuocTinhTimKiem9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(PanelTimKiem9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(XuatExcel)
                        .addGap(30, 30, 30)
                        .addComponent(NhapExcel))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(Them)
                        .addGap(30, 30, 30)
                        .addComponent(Xoa)
                        .addGap(30, 30, 30)
                        .addComponent(Sua)))
                .addContainerGap(372, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PanelTimKiem9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(XuatExcel)
                        .addComponent(NhapExcel)))
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Sua)
                    .addComponent(Xoa)
                    .addComponent(Them))
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void XuatExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_XuatExcelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_XuatExcelActionPerformed

    private void NhapExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NhapExcelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NhapExcelActionPerformed

    private void ThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ThemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ThemActionPerformed

    private void XoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_XoaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_XoaActionPerformed

    private void SuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SuaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SuaActionPerformed

    private void ThuocTinhTimKiem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ThuocTinhTimKiem9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ThuocTinhTimKiem9ActionPerformed

    private void GiaTriTimKiem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GiaTriTimKiem9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_GiaTriTimKiem9ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable DataKhachHang;
    private javax.swing.JTextField GiaTriTimKiem9;
    private javax.swing.JButton NhapExcel;
    private javax.swing.JPanel PanelTimKiem9;
    private javax.swing.JButton Sua;
    private javax.swing.JButton Them;
    private javax.swing.JScrollPane ThongTinKhachHang;
    private javax.swing.JComboBox<String> ThuocTinhTimKiem9;
    private javax.swing.JButton TimKiem9;
    private javax.swing.JButton Xoa;
    private javax.swing.JButton XuatExcel;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
