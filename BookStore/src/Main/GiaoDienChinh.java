/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Main;


import Dto.NHANVIEN;
import Gui.FormChinh.*;
import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.JOptionPane;

/**
 *
 * @author DELL
 */
public class GiaoDienChinh extends javax.swing.JFrame {

    /**
     * Creates new form GiaoDienChinh
     */
    NHANVIEN nv;
    public GiaoDienChinh(NHANVIEN nv) {
        this.setUndecorated(true);
        initComponents();
        this.setLocationRelativeTo(null);
        this.nv=nv;
    }
        public GiaoDienChinh() {
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

        NavBar = new javax.swing.ButtonGroup();
        Header = new javax.swing.JPanel();
        cauchao = new javax.swing.JLabel();
        Title = new javax.swing.JLabel();
        logout = new javax.swing.JButton();
        exit = new javax.swing.JButton();
        Left = new javax.swing.JPanel();
        BanHang = new javax.swing.JLabel();
        NhapHang = new javax.swing.JLabel();
        TaiKhoan = new javax.swing.JLabel();
        NhanVien = new javax.swing.JLabel();
        KhachHang = new javax.swing.JLabel();
        KhuyenMai = new javax.swing.JLabel();
        ThongKe = new javax.swing.JLabel();
        Middle = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        Header.setBackground(new java.awt.Color(0, 51, 51));
        Header.setPreferredSize(new java.awt.Dimension(1400, 50));

        cauchao.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        cauchao.setForeground(new java.awt.Color(204, 255, 204));
        cauchao.setText("Hello USER");

        Title.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        Title.setForeground(new java.awt.Color(204, 255, 204));
        Title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Title.setText("Cửa Hàng Bán Sách");
        Title.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        logout.setBackground(new java.awt.Color(0, 51, 51));
        logout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_exit_30px.png"))); // NOI18N
        logout.setBorder(null);
        logout.setContentAreaFilled(false);
        logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutActionPerformed(evt);
            }
        });

        exit.setBackground(new java.awt.Color(0, 51, 51));
        exit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_cancel_30px_1.png"))); // NOI18N
        exit.setBorder(null);
        exit.setContentAreaFilled(false);
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout HeaderLayout = new javax.swing.GroupLayout(Header);
        Header.setLayout(HeaderLayout);
        HeaderLayout.setHorizontalGroup(
            HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HeaderLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(cauchao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(logout)
                .addGap(456, 456, 456)
                .addComponent(Title)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 1081, Short.MAX_VALUE)
                .addComponent(exit)
                .addContainerGap())
        );
        HeaderLayout.setVerticalGroup(
            HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HeaderLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(cauchao)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(HeaderLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(exit, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                    .addComponent(Title, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(HeaderLayout.createSequentialGroup()
                        .addComponent(logout)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        getContentPane().add(Header, java.awt.BorderLayout.PAGE_START);

        Left.setBackground(new java.awt.Color(0, 51, 51));
        Left.setPreferredSize(new java.awt.Dimension(150, 750));
        Left.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 0, 0));

        BanHang.setBackground(new java.awt.Color(0, 51, 51));
        BanHang.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        BanHang.setForeground(new java.awt.Color(255, 255, 204));
        BanHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_small_business_30px_3.png"))); // NOI18N
        BanHang.setText("Bán Hàng");
        BanHang.setOpaque(true);
        BanHang.setPreferredSize(new java.awt.Dimension(150, 75));
        BanHang.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                BanHangMouseMoved(evt);
            }
        });
        BanHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BanHangMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BanHangMouseExited(evt);
            }
        });
        Left.add(BanHang);

        NhapHang.setBackground(new java.awt.Color(0, 51, 51));
        NhapHang.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        NhapHang.setForeground(new java.awt.Color(204, 255, 204));
        NhapHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_downloads_30px.png"))); // NOI18N
        NhapHang.setText("Nhập Hàng");
        NhapHang.setOpaque(true);
        NhapHang.setPreferredSize(new java.awt.Dimension(150, 75));
        NhapHang.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                NhapHangMouseMoved(evt);
            }
        });
        NhapHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                NhapHangMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                NhapHangMouseExited(evt);
            }
        });
        Left.add(NhapHang);

        TaiKhoan.setBackground(new java.awt.Color(0, 51, 51));
        TaiKhoan.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        TaiKhoan.setForeground(new java.awt.Color(204, 255, 204));
        TaiKhoan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-account-30.png"))); // NOI18N
        TaiKhoan.setText("Tài Khoản");
        TaiKhoan.setOpaque(true);
        TaiKhoan.setPreferredSize(new java.awt.Dimension(150, 75));
        TaiKhoan.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                TaiKhoanMouseMoved(evt);
            }
        });
        TaiKhoan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TaiKhoanMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                TaiKhoanMouseExited(evt);
            }
        });
        Left.add(TaiKhoan);

        NhanVien.setBackground(new java.awt.Color(0, 51, 51));
        NhanVien.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        NhanVien.setForeground(new java.awt.Color(204, 255, 204));
        NhanVien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_assistant_30px.png"))); // NOI18N
        NhanVien.setText("Nhân Viên");
        NhanVien.setOpaque(true);
        NhanVien.setPreferredSize(new java.awt.Dimension(150, 75));
        NhanVien.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                NhanVienMouseMoved(evt);
            }
        });
        NhanVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                NhanVienMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                NhanVienMouseExited(evt);
            }
        });
        Left.add(NhanVien);

        KhachHang.setBackground(new java.awt.Color(0, 51, 51));
        KhachHang.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        KhachHang.setForeground(new java.awt.Color(204, 255, 204));
        KhachHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_circled_user_male_30px.png"))); // NOI18N
        KhachHang.setText("Khách Hàng");
        KhachHang.setOpaque(true);
        KhachHang.setPreferredSize(new java.awt.Dimension(150, 75));
        KhachHang.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                KhachHangMouseMoved(evt);
            }
        });
        KhachHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                KhachHangMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                KhachHangMouseExited(evt);
            }
        });
        Left.add(KhachHang);

        KhuyenMai.setBackground(new java.awt.Color(0, 51, 51));
        KhuyenMai.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        KhuyenMai.setForeground(new java.awt.Color(204, 255, 204));
        KhuyenMai.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_us_dollar_30px.png"))); // NOI18N
        KhuyenMai.setText("Khuyến Mãi");
        KhuyenMai.setOpaque(true);
        KhuyenMai.setPreferredSize(new java.awt.Dimension(150, 75));
        KhuyenMai.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                KhuyenMaiMouseMoved(evt);
            }
        });
        KhuyenMai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                KhuyenMaiMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                KhuyenMaiMouseExited(evt);
            }
        });
        Left.add(KhuyenMai);

        ThongKe.setBackground(new java.awt.Color(0, 51, 51));
        ThongKe.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        ThongKe.setForeground(new java.awt.Color(204, 255, 204));
        ThongKe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_bar_chart_30px.png"))); // NOI18N
        ThongKe.setText("Thống Kê");
        ThongKe.setOpaque(true);
        ThongKe.setPreferredSize(new java.awt.Dimension(150, 75));
        ThongKe.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                ThongKeMouseMoved(evt);
            }
        });
        ThongKe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ThongKeMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ThongKeMouseExited(evt);
            }
        });
        Left.add(ThongKe);

        getContentPane().add(Left, java.awt.BorderLayout.LINE_START);

        Middle.setLayout(new java.awt.CardLayout());

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));

        jLabel1.setFont(new java.awt.Font("Palatino Linotype", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 0, 0));
        jLabel1.setText("Chào mừng đến với phần mềm quản lý cửa hàng bán sách ");

        jLabel2.setFont(new java.awt.Font("Palatino Linotype", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 0, 0));
        jLabel2.setText("Vui lòng chọn thao tác");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(153, 153, 153)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 967, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(411, 411, 411)
                        .addComponent(jLabel2)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(181, 181, 181)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addContainerGap(463, Short.MAX_VALUE))
        );

        Middle.add(jPanel1, "card2");

        getContentPane().add(Middle, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents
            KhuyenMaiPanel khuyenmai = new KhuyenMaiPanel();
            BanHangPanel banhang = new BanHangPanel();
    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed
        // TODO add your handling code here:
        int confirmResult = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn thoát không?", "Xác nhận thoát", JOptionPane.YES_NO_OPTION);
        if (confirmResult == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_exitActionPerformed

    private void BanHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BanHangMouseClicked
        // TODO add your handling code here:
        Title.setText("Bán Hàng");
        banhang.loadBooksToTable();//load hoadon và sách
        banhang.loadHOADONToTable();
        banhang.loadKhachHang();
        banhang.loadNhanVien(nv);
        banhang.loadKhuyenMai();//kết thúc
        Middle.add(banhang, "banhang");
        CardLayout cardLayout = (CardLayout) Middle.getLayout();
        cardLayout.show(Middle, "banhang");
    }//GEN-LAST:event_BanHangMouseClicked

    private void NhapHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NhapHangMouseClicked
        // TODO add your handling code here:
        Title.setText("Nhập Hàng");
        NhapHangPanel nhaphang = new NhapHangPanel();
        Middle.add(nhaphang, "nhaphang");
        CardLayout cardLayout = (CardLayout) Middle.getLayout();
        cardLayout.show(Middle, "nhaphang");
        nhaphang.loadBooksToTable();
        nhaphang.loadPHIEUNHAPToTable();
        nhaphang.loadNCC();
        nhaphang.loadNhanVien(nv);
    }//GEN-LAST:event_NhapHangMouseClicked

    private void TaiKhoanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TaiKhoanMouseClicked
        // TODO add your handling code here:
        Title.setText("Tài Khoản");
        TaiKhoanPanel taikhoan = new TaiKhoanPanel();
        Middle.add(taikhoan, "taikhoan");
        CardLayout cardLayout = (CardLayout) Middle.getLayout();
        cardLayout.show(Middle, "taikhoan");
        taikhoan.loadTaiKhoanToTable();
    }//GEN-LAST:event_TaiKhoanMouseClicked

    private void NhanVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NhanVienMouseClicked
        // TODO add your handling code here:
        Title.setText("Nhân Viên");
        NhanVienPanel nhanvien = new NhanVienPanel();
        Middle.add(nhanvien, "nhanvien");
        CardLayout cardLayout = (CardLayout) Middle.getLayout();
        cardLayout.show(Middle, "nhanvien");
        nhanvien.loadNhanVienToTable();
    }//GEN-LAST:event_NhanVienMouseClicked

    private void KhachHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_KhachHangMouseClicked
        // TODO add your handling code here:
        Title.setText("Khách Hàng");
        KhachHangPanel khachhang = new KhachHangPanel();
        Middle.add(khachhang, "khachhang");
        CardLayout cardLayout = (CardLayout) Middle.getLayout();
        cardLayout.show(Middle, "khachhang");
        khachhang.loadKhachHangToTable();
    }//GEN-LAST:event_KhachHangMouseClicked

    private void ThongKeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ThongKeMouseClicked
        // TODO add your handling code here:
        Title.setText("Thống Kê");
        ThongKePanel thongke = new ThongKePanel();
        Middle.add(thongke, "thongke");
        CardLayout cardLayout = (CardLayout) Middle.getLayout();
        cardLayout.show(Middle, "thongke");
    }//GEN-LAST:event_ThongKeMouseClicked

    private void BanHangMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BanHangMouseMoved
        // TODO add your handling code here:
        BanHang.setBackground(new Color(255,255,255));
        BanHang.setForeground(new Color(204,0,51));
    }//GEN-LAST:event_BanHangMouseMoved

    private void BanHangMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BanHangMouseExited
        // TODO add your handling code here:
        BanHang.setBackground(new Color(0,51,51));
        BanHang.setForeground(new Color(204,255,204));
    }//GEN-LAST:event_BanHangMouseExited

    private void NhapHangMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NhapHangMouseExited
        // TODO add your handling code here:
        NhapHang.setBackground(new Color(0,51,51));
        NhapHang.setForeground(new Color(204,255,204));
    }//GEN-LAST:event_NhapHangMouseExited

    private void NhapHangMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NhapHangMouseMoved
        // TODO add your handling code here:
        NhapHang.setBackground(new Color(255,255,255));
        NhapHang.setForeground(new Color(204,0,51));
    }//GEN-LAST:event_NhapHangMouseMoved

    private void TaiKhoanMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TaiKhoanMouseExited
        // TODO add your handling code here:
        TaiKhoan.setBackground(new Color(0,51,51));
        TaiKhoan.setForeground(new Color(204,255,204));
    }//GEN-LAST:event_TaiKhoanMouseExited

    private void TaiKhoanMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TaiKhoanMouseMoved
        // TODO add your handling code here:
        TaiKhoan.setBackground(new Color(255,255,255));
        TaiKhoan.setForeground(new Color(204,0,51));
    }//GEN-LAST:event_TaiKhoanMouseMoved

    private void NhanVienMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NhanVienMouseExited
        // TODO add your handling code here:
        NhanVien.setBackground(new Color(0,51,51));
        NhanVien.setForeground(new Color(204,255,204));
    }//GEN-LAST:event_NhanVienMouseExited

    private void NhanVienMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NhanVienMouseMoved
        // TODO add your handling code here:
        NhanVien.setBackground(new Color(255,255,255));
        NhanVien.setForeground(new Color(204,0,51));
    }//GEN-LAST:event_NhanVienMouseMoved

    private void KhachHangMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_KhachHangMouseExited
        // TODO add your handling code here:
        KhachHang.setBackground(new Color(0,51,51));
        KhachHang.setForeground(new Color(204,255,204));
    }//GEN-LAST:event_KhachHangMouseExited

    private void KhachHangMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_KhachHangMouseMoved
        // TODO add your handling code here:
        KhachHang.setBackground(new Color(255,255,255));
        KhachHang.setForeground(new Color(204,0,51));
    }//GEN-LAST:event_KhachHangMouseMoved

    private void ThongKeMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ThongKeMouseMoved
        // TODO add your handling code here
        ThongKe.setBackground(new Color(255,255,255));
        ThongKe.setForeground(new Color(204,0,51));
    }//GEN-LAST:event_ThongKeMouseMoved

    private void ThongKeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ThongKeMouseExited
        // TODO add your handling code here:
        ThongKe.setBackground(new Color(0,51,51));
        ThongKe.setForeground(new Color(204,255,204));
    }//GEN-LAST:event_ThongKeMouseExited

    private void KhuyenMaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_KhuyenMaiMouseClicked
        // TODO add your handling code here:
        Title.setText("Khuyến Mãi");
        Middle.add(khuyenmai, "khuyenmai");
        CardLayout cardLayout = (CardLayout) Middle.getLayout();
        cardLayout.show(Middle, "khuyenmai");
    }//GEN-LAST:event_KhuyenMaiMouseClicked

    private void KhuyenMaiMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_KhuyenMaiMouseMoved
        // TODO add your handling code here:
        KhuyenMai.setBackground(new Color(255,255,255));
        KhuyenMai.setForeground(new Color(204,0,51));
    }//GEN-LAST:event_KhuyenMaiMouseMoved

    private void KhuyenMaiMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_KhuyenMaiMouseExited
        // TODO add your handling code here:
        KhuyenMai.setBackground(new Color(0,51,51));
        KhuyenMai.setForeground(new Color(204,255,204));
    }//GEN-LAST:event_KhuyenMaiMouseExited

    private void logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutActionPerformed
        // TODO add your handling code here:
        this.dispose();
        GiaoDienLogin x=new GiaoDienLogin();
        x.setVisible(true);
    }//GEN-LAST:event_logoutActionPerformed
    public void display(String role){
        if(role.equals("Nhân Viên")){
            TaiKhoan.setVisible(false);
            ThongKe.setVisible(false);
        }
        else if(role.equals("Khách Hàng")){
            NhapHang.setVisible(false);
            TaiKhoan.setVisible(false);
            ThongKe.setVisible(false);
            NhanVien.setVisible(false);
            KhachHang.setVisible(false);
            khuyenmai.hide_button();
            banhang.hide_button();
        }
    }
    public void setCauchao(String name){
        cauchao.setText("Hello "+name);
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
            java.util.logging.Logger.getLogger(GiaoDienChinh.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GiaoDienChinh.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GiaoDienChinh.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GiaoDienChinh.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GiaoDienChinh().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BanHang;
    private javax.swing.JPanel Header;
    private javax.swing.JLabel KhachHang;
    private javax.swing.JLabel KhuyenMai;
    private javax.swing.JPanel Left;
    private javax.swing.JPanel Middle;
    private javax.swing.ButtonGroup NavBar;
    private javax.swing.JLabel NhanVien;
    private javax.swing.JLabel NhapHang;
    private javax.swing.JLabel TaiKhoan;
    private javax.swing.JLabel ThongKe;
    private javax.swing.JLabel Title;
    private javax.swing.JLabel cauchao;
    private javax.swing.JButton exit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton logout;
    // End of variables declaration//GEN-END:variables
}
