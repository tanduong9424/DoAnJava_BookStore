/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Main.FrontEnd.FormNhapSL;

import Bus.Impl.BanHanglmpl;
import Bus.Impl.NhapHanglmpl;
import Dto.SACH;
import Gui.FormChinh.NhapHangPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DELL
 */
public class PanelNhapSL_NhapHang extends javax.swing.JFrame {

    /**
     * Creates new form FrameNhapSL
     */
    javax.swing.JTable jTable1;
    NhapHangPanel nhaphang;
    String masach;
    String tensach;
    String dongia;
    String NCC;
    public PanelNhapSL_NhapHang(NhapHangPanel nhaphang,javax.swing.JTable jTable1,String masach,String tensach,String dongia,String NCC) {
        this.setUndecorated(true);
        initComponents();
        this.setLocationRelativeTo(null);
        this.nhaphang=nhaphang;
        this.jTable1=jTable1;
        this.masach=masach;
        this.tensach=tensach;
        this.dongia=dongia;
        this.NCC=NCC;
    }

    public PanelNhapSL_NhapHang() {
        this.setUndecorated(true);
        initComponents();
        this.setLocationRelativeTo(null);

    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelNhapSL = new javax.swing.JPanel();
        mid = new javax.swing.JPanel();
        MaSach = new javax.swing.JTextField();
        TenSach = new javax.swing.JTextField();
        DonGia = new javax.swing.JTextField();
        NXB = new javax.swing.JTextField();
        inputSL = new javax.swing.JTextField();
        Lable1 = new javax.swing.JLabel();
        Label2 = new javax.swing.JLabel();
        exit = new javax.swing.JLabel();
        bot = new javax.swing.JPanel();
        submitbtn = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        PanelNhapSL.setLayout(new java.awt.BorderLayout());

        mid.setBackground(new java.awt.Color(51, 255, 255));

        MaSach.setEditable(false);
        MaSach.setBackground(new java.awt.Color(204, 255, 204));
        MaSach.setForeground(new java.awt.Color(0, 51, 51));
        MaSach.setText("S1");
        MaSach.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Mã Sách", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12), new java.awt.Color(0, 51, 51))); // NOI18N
        MaSach.setFocusable(false);

        TenSach.setEditable(false);
        TenSach.setBackground(new java.awt.Color(204, 255, 204));
        TenSach.setForeground(new java.awt.Color(0, 51, 51));
        TenSach.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tên Sách", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12), new java.awt.Color(0, 51, 51))); // NOI18N
        TenSach.setFocusable(false);

        DonGia.setBackground(new java.awt.Color(204, 255, 204));
        DonGia.setForeground(new java.awt.Color(0, 51, 51));
        DonGia.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Đơn Giá", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12), new java.awt.Color(0, 51, 51))); // NOI18N
        DonGia.setRequestFocusEnabled(false);

        NXB.setBackground(new java.awt.Color(204, 255, 204));
        NXB.setForeground(new java.awt.Color(0, 51, 51));
        NXB.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nhà Cung Cấp", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12), new java.awt.Color(0, 51, 51))); // NOI18N
        NXB.setFocusable(false);

        inputSL.setBackground(new java.awt.Color(204, 255, 204));
        inputSL.setForeground(new java.awt.Color(0, 51, 51));
        inputSL.setBorder(null);
        inputSL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputSLActionPerformed(evt);
            }
        });

        Lable1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Lable1.setForeground(new java.awt.Color(0, 51, 51));
        Lable1.setText("Thông tin sách bạn vừa chọn:");

        Label2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Label2.setForeground(new java.awt.Color(0, 51, 51));
        Label2.setText("Nhập Số Lượng");

        exit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_cancel_30px_1.png"))); // NOI18N
        exit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exitMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout midLayout = new javax.swing.GroupLayout(mid);
        mid.setLayout(midLayout);
        midLayout.setHorizontalGroup(
            midLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(midLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(midLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Label2)
                    .addGroup(midLayout.createSequentialGroup()
                        .addComponent(MaSach, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(TenSach, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(midLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(midLayout.createSequentialGroup()
                            .addComponent(Lable1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(exit, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(midLayout.createSequentialGroup()
                            .addGroup(midLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(inputSL, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(midLayout.createSequentialGroup()
                                    .addComponent(DonGia, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(NXB, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGap(17, 17, 17))))
                .addGap(3, 3, 3))
        );
        midLayout.setVerticalGroup(
            midLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(midLayout.createSequentialGroup()
                .addGroup(midLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(exit)
                    .addGroup(midLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(Lable1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(midLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(MaSach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TenSach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(midLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NXB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DonGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addComponent(Label2)
                .addGap(18, 18, 18)
                .addComponent(inputSL, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(129, Short.MAX_VALUE))
        );

        PanelNhapSL.add(mid, java.awt.BorderLayout.CENTER);

        submitbtn.setBackground(new java.awt.Color(255, 255, 255));
        submitbtn.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        submitbtn.setForeground(new java.awt.Color(0, 51, 51));
        submitbtn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        submitbtn.setText("Xác Nhận");
        submitbtn.setOpaque(true);
        submitbtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                submitbtnMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout botLayout = new javax.swing.GroupLayout(bot);
        bot.setLayout(botLayout);
        botLayout.setHorizontalGroup(
            botLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(submitbtn, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        botLayout.setVerticalGroup(
            botLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(submitbtn, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
        );

        PanelNhapSL.add(bot, java.awt.BorderLayout.PAGE_END);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(PanelNhapSL, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 396, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(PanelNhapSL, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void submitbtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_submitbtnMouseClicked
        // TODO add your handling code here:
        DefaultTableModel dataModel=(DefaultTableModel) this.jTable1.getModel();
        int sl=Integer.parseInt(inputSL.getText());
        int masach=Integer.parseInt(this.masach);
        int gia=Integer.parseInt(DonGia.getText());
        SACH t=new SACH(masach,this.tensach,this.NCC,gia);
        NhapHanglmpl banhang=new NhapHanglmpl();
        banhang.TaoChiTietPhieuNhap(dataModel, t, sl);
        this.nhaphang.loadtongtien();
        this.dispose();

    }//GEN-LAST:event_submitbtnMouseClicked

    private void exitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitMouseClicked
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_exitMouseClicked

    private void inputSLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputSLActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputSLActionPerformed
    
    public void setThongTinPanel(String s1,String s2,String s3,String s4){
        this.MaSach.setText(s1);
        this.TenSach.setText(s2);
        this.DonGia.setText(s3);
        this.NXB.setText(s4);
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PanelNhapSL_NhapHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PanelNhapSL_NhapHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PanelNhapSL_NhapHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PanelNhapSL_NhapHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PanelNhapSL_NhapHang().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField DonGia;
    private javax.swing.JLabel Label2;
    private javax.swing.JLabel Lable1;
    private javax.swing.JTextField MaSach;
    private javax.swing.JTextField NXB;
    private javax.swing.JPanel PanelNhapSL;
    private javax.swing.JTextField TenSach;
    private javax.swing.JPanel bot;
    private javax.swing.JLabel exit;
    private javax.swing.JTextField inputSL;
    private javax.swing.JPanel mid;
    private javax.swing.JLabel submitbtn;
    // End of variables declaration//GEN-END:variables
}
