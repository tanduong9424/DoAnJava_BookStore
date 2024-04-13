/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GiaoDienLogin;

import java.awt.Component;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/**
 *
 * @author DELL
 */
public class login extends javax.swing.JFrame {

    /**
     * Creates new form login
     */
    public login() {
        initComponents();
        this.setTitle("Đăng nhập");
        ImageIcon logo = new ImageIcon(getClass().getResource("/giaodienchuan/images/icons8_windows_phone_store_30px.png"));
        setIconImage(logo.getImage());
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

        lbAva = new javax.swing.JLabel();
        plDangNhap = new javax.swing.JPanel();
        btnDangNhap = new javax.swing.JButton();
        plInput = new javax.swing.JPanel();
        txTenDangNhap = new javax.swing.JTextField();
        lbImgPass = new javax.swing.JLabel();
        lbImgUser = new javax.swing.JLabel();
        txMatKhau = new javax.swing.JPasswordField();
        plHeader = new javax.swing.JPanel();
        lbHeader = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lbAva.setBackground(new java.awt.Color(204, 255, 204));
        lbAva.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbAva.setIcon(new javax.swing.ImageIcon(getClass().getResource("/giaodienchuan/images/icons8_commercial_development_management_64px.png"))); // NOI18N

        btnDangNhap.setBackground(new java.awt.Color(0, 255, 153));
        btnDangNhap.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnDangNhap.setForeground(new java.awt.Color(10, 10, 10));
        btnDangNhap.setText("ĐĂNG NHẬP");
        btnDangNhap.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.white, java.awt.Color.darkGray));
        btnDangNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDangNhapActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout plDangNhapLayout = new javax.swing.GroupLayout(plDangNhap);
        plDangNhap.setLayout(plDangNhapLayout);
        plDangNhapLayout.setHorizontalGroup(
            plDangNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnDangNhap, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        plDangNhapLayout.setVerticalGroup(
            plDangNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnDangNhap, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );

        plInput.setBackground(new java.awt.Color(255, 255, 204));

        txTenDangNhap.setBackground(new java.awt.Color(102, 255, 204));
        txTenDangNhap.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txTenDangNhap.setForeground(new java.awt.Color(0, 0, 0));
        txTenDangNhap.setCaretColor(new java.awt.Color(0, 0, 255));
        txTenDangNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txTenDangNhapActionPerformed(evt);
            }
        });

        lbImgPass.setIcon(new javax.swing.ImageIcon(getClass().getResource("/giaodienchuan/images/icons8_password_40px.png"))); // NOI18N

        lbImgUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/giaodienchuan/images/icons8_circled_user_male_skin_type_1_2_40px.png"))); // NOI18N

        txMatKhau.setBackground(new java.awt.Color(0, 255, 204));
        txMatKhau.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txMatKhau.setForeground(new java.awt.Color(0, 0, 0));
        txMatKhau.setCaretColor(new java.awt.Color(0, 0, 204));
        txMatKhau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txMatKhauActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout plInputLayout = new javax.swing.GroupLayout(plInput);
        plInput.setLayout(plInputLayout);
        plInputLayout.setHorizontalGroup(
            plInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(plInputLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(plInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbImgPass)
                    .addComponent(lbImgUser, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(plInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txTenDangNhap)
                    .addComponent(txMatKhau, javax.swing.GroupLayout.DEFAULT_SIZE, 342, Short.MAX_VALUE))
                .addContainerGap())
        );
        plInputLayout.setVerticalGroup(
            plInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, plInputLayout.createSequentialGroup()
                .addGroup(plInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(plInputLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbImgUser, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(plInputLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(txTenDangNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)))
                .addGroup(plInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbImgPass, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txMatKhau, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44))
        );

        plHeader.setBackground(new java.awt.Color(204, 255, 204));

        lbHeader.setBackground(new java.awt.Color(0, 255, 153));
        lbHeader.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lbHeader.setForeground(new java.awt.Color(0, 0, 51));
        lbHeader.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbHeader.setText("QUẢN LÝ CỬA HÀNG SÁCH");

        javax.swing.GroupLayout plHeaderLayout = new javax.swing.GroupLayout(plHeader);
        plHeader.setLayout(plHeaderLayout);
        plHeaderLayout.setHorizontalGroup(
            plHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(plHeaderLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbHeader, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
                .addContainerGap())
        );
        plHeaderLayout.setVerticalGroup(
            plHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(plHeaderLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbHeader, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(plDangNhap, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(plHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(plInput, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lbAva, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(plHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbAva)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(plInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(plDangNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDangNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDangNhapActionPerformed
        String tentk = txTenDangNhap.getText();
        String mk = txMatKhau.getText();
        GiaoDienChuan x=new GiaoDienChuan();
            x.setVisible(true);
            JFrame currentFrame = (JFrame) SwingUtilities.getWindowAncestor((Component) evt.getSource());
            currentFrame .dispose();
        /*if(tentk.equals("admin") && mk.equals("admin")){
            GiaoDienChuan x=new GiaoDienChuan();
            x.setVisible(true);
            JFrame currentFrame = (JFrame) SwingUtilities.getWindowAncestor((Component) evt.getSource());
            currentFrame .dispose();
        }*/
            
                    
        //QuanLyTaiKhoanBUS qltk = new QuanLyTaiKhoanBUS();
        //TaiKhoan tk = qltk.getTaiKhoan(tentk);

        /*if (tk != null) {
            // check xem nhân viên của tài khoản này có bị khóa (Ẩn) hay không
            NhanVien nv = new QuanLyNhanVienBUS().getNhanVien(tk.getMaNV());
            if (nv.getTrangThai() == 1) {
                JOptionPane.showMessageDialog(this, "Tài khoản này đã bị khóa, do chủ nhân tài khoản này đã bị ẨN khỏi hệ thống!");
                return;
            }

            // check password
            if (tk.getPassword().equals(mk)) {
                taiKhoanLogin = tk;
                nhanVienLogin = nv;
                quyenLogin = new QuanLyQuyenBUS().getQuyen(taiKhoanLogin.getMaQuyen());

                // Đăng nhập thành công
                /*if (rbNhoMatKhau.isSelected()) {
                    // nếu giữ đăng nhập thì lưu tài khoản đăng nhập vào file
                    new WorkWithFile(saveFileName).write(taiKhoanLogin.getUsername() + " " + taiKhoanLogin.getPassword());
                } else {
                    // nếu không thì xóa mọi dữ liệu trong file
                    new WorkWithFile(saveFileName).write("");
                }

                new GiaoDienChuan().setVisible(true);
                this.dispose();

            } else {
                JOptionPane.showMessageDialog(this, "Sai mật khẩu!");
                txMatKhau.requestFocus();
            }

        } else {
            JOptionPane.showMessageDialog(this, "Sai tên đăng nhập!");
            txTenDangNhap.requestFocus();
        }*/
    }//GEN-LAST:event_btnDangNhapActionPerformed

    private void txTenDangNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txTenDangNhapActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txTenDangNhapActionPerformed

    private void txMatKhauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txMatKhauActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txMatKhauActionPerformed

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
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDangNhap;
    private javax.swing.JLabel lbAva;
    private javax.swing.JLabel lbHeader;
    private javax.swing.JLabel lbImgPass;
    private javax.swing.JLabel lbImgUser;
    private javax.swing.JPanel plDangNhap;
    private javax.swing.JPanel plHeader;
    private javax.swing.JPanel plInput;
    private javax.swing.JPasswordField txMatKhau;
    private javax.swing.JTextField txTenDangNhap;
    // End of variables declaration//GEN-END:variables
}
