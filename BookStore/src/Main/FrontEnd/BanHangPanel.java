/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Main.FrontEnd;

import Main.BackEnd.repository.dao.CHITIETHOADONDAO;
import Main.BackEnd.repository.dao.HOADONDAO;
import Main.BackEnd.repository.dao.KHUYENMAIDAO;
import Main.BackEnd.repository.dao.SACHDAO;
import Main.BackEnd.repository.modal.CHITIETHOADON;
import Main.BackEnd.repository.modal.HOADON;
import Main.BackEnd.repository.modal.KHUYENMAI;
import Main.FrontEnd.FormAdd.AddKhachHang;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;
import Main.BackEnd.repository.modal.SACH;
import java.awt.Image;


/**
 *
 * @author DELL
 */
public class BanHangPanel extends javax.swing.JPanel {
    int status=0;
    /**
     * Creates new form BanHangPanel
     */
    public BanHangPanel() {
        initComponents();
        submit.setVisible(false);
        xoaspbtn.setVisible(false);
    }
    public void loadBooksToTable() {
        DefaultTableModel model = (DefaultTableModel) Sachtb.getModel();
        // Xóa tất cả các dòng cũ trong bảng trước khi load dữ liệu mới
        model.setRowCount(0);

        try {
            System.out.print("hoạt động");
            ArrayList<SACH> sachList = SACHDAO.getInstance().selectAllExceptISHIDDEN();

            for (SACH sach : sachList) {
                Object[] row = {sach.getMASACH(), sach.getTENSACH(), sach.getSOLUONG(), sach.getGIABIA(), sach.getTENNHAXUATBAN()};
                model.addRow(row);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public void loadHOADONToTable() {
        DefaultTableModel model = (DefaultTableModel) dataHoadon.getModel();
        // Xóa tất cả các dòng cũ trong bảng trước khi load dữ liệu mới
        model.setRowCount(0);

        try {
            System.out.print("hoạt động");
            ArrayList<HOADON> hoadonList = HOADONDAO.getInstance().selectAllHOANTHANH();
            
            for (HOADON hoadon : hoadonList) {
                int makhuyenmai=0;
                int phantramgiam=0;
                    makhuyenmai=hoadon.getMakhuyenmai();
                    KHUYENMAI km=KHUYENMAIDAO.getInstance().selectById(new KHUYENMAI(hoadon.getMakhuyenmai()));
                    if(km!=null){
                        phantramgiam=km.getPhantramgiam();
                    }                
                Object[] row = {hoadon.getMAHOADON(),hoadon.getManv(),hoadon.getTENTAIKHOAN(),hoadon.getNGAYLAP(),makhuyenmai,phantramgiam,hoadon.getTONGTIEN()};
                model.addRow(row);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }    
    public void loadCHITIETHOADONToTable(HOADON t) {
        DefaultTableModel model = (DefaultTableModel) selectedSach.getModel();
        // Xóa tất cả các dòng cũ trong bảng trước khi load dữ liệu mới
        model.setRowCount(0);

        try {
            System.out.print("hoạt động");
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
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }  
    
public ImageIcon resizeImage(ImageIcon icon, int maxWidth, int maxHeight) {
    Image image = icon.getImage();
    int width = image.getWidth(null);
    int height = image.getHeight(null);
    
    // Kiểm tra kích thước của hình ảnh và điều chỉnh nếu cần
    if (width > maxWidth || height > maxHeight) {
        double scale = Math.min((double) maxWidth / width, (double) maxHeight / height);
        width = (int) (width * scale);
        height = (int) (height * scale);
        
        // Thay đổi kích thước hình ảnh
        image = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
    }
    
    // Tạo ImageIcon mới với kích thước đã được điều chỉnh
    return new ImageIcon(image);
}
public void loadAnh(SACH t) {
    String url = t.getIMAGE(); // Lấy đường dẫn ảnh từ đối tượng SACH
    
    try {
        if(url !=null){
            // Tạo một đối tượng ImageIcon từ đường dẫn ảnh
            ImageIcon icon = new ImageIcon(url);

            // Đặt hình ảnh lên jLabel1
            ImageIcon result=resizeImage(icon,180,273);
            jLabel1.setIcon(result);
        }
         else {
            jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/doraemon.jpg")));
        }        
    } catch (Exception ex) {
        // Nếu có lỗi xảy ra, in ra thông báo lỗi
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

        selectKH = new javax.swing.ButtonGroup();
        HoaDon = new javax.swing.JPanel();
        search1 = new javax.swing.JButton();
        searchHoaDon = new javax.swing.JTextField();
        scroll1 = new javax.swing.JScrollPane();
        dataHoadon = new javax.swing.JTable();
        DanhSachSP = new javax.swing.JPanel();
        scroll22 = new javax.swing.JScrollPane();
        Sachtb = new javax.swing.JTable();
        search2 = new javax.swing.JButton();
        searchSach = new javax.swing.JTextField();
        panelImg = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        ThongTinBanHang = new javax.swing.JPanel();
        ttKH = new javax.swing.JLabel();
        maHD = new javax.swing.JLabel();
        NhaptenKH = new javax.swing.JTextField();
        ttNV = new javax.swing.JLabel();
        Chuacotaikhoan = new javax.swing.JRadioButton();
        Dacotaikhoan = new javax.swing.JRadioButton();
        maHDtext = new javax.swing.JTextField();
        comboxKH = new javax.swing.JComboBox<>();
        nv = new javax.swing.JTextField();
        newKH = new javax.swing.JButton();
        ThemBtn = new javax.swing.JButton();
        XoaBtn = new javax.swing.JButton();
        ChiTietHD = new javax.swing.JPanel();
        tongtien = new javax.swing.JLabel();
        sum = new javax.swing.JTextField();
        scroll3 = new javax.swing.JScrollPane();
        selectedSach = new javax.swing.JTable();
        xoaspbtn = new javax.swing.JButton();
        submit = new javax.swing.JButton();

        setBackground(new java.awt.Color(0, 153, 153));
        setPreferredSize(new java.awt.Dimension(1250, 750));

        HoaDon.setBackground(new java.awt.Color(0, 204, 204));

        search1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-magnifying-glass-30.png"))); // NOI18N
        search1.setToolTipText("Tìm kiếm");
        search1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));
        search1.setBorderPainted(false);
        search1.setContentAreaFilled(false);
        search1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search1ActionPerformed(evt);
            }
        });

        searchHoaDon.setBackground(new java.awt.Color(204, 255, 204));
        searchHoaDon.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tìm Kiếm Hóa Đơn", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12), new java.awt.Color(0, 51, 51))); // NOI18N
        searchHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchHoaDonActionPerformed(evt);
            }
        });

        scroll1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Hóa đơn", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12), new java.awt.Color(0, 51, 51))); // NOI18N

        dataHoadon.setAutoCreateRowSorter(true);
        dataHoadon.setBackground(new java.awt.Color(204, 255, 204));
        dataHoadon.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        dataHoadon.setForeground(new java.awt.Color(0, 51, 51));
        dataHoadon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"HD1", "NV1", "KH1", "20-03-2024", null, null,  new Integer(300000)},
                {"HD2", "NV2", "KH2", "30-03-2023", null, null,  new Integer(320000)},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã Hóa Đơn", "Mã Nhân Viên", "Tên Tài Khoản", "Ngày lập", "Mã khuyế mãi", "% giảm giá", "Tổng tiền"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        dataHoadon.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        dataHoadon.setShowGrid(true);
        dataHoadon.setSurrendersFocusOnKeystroke(true);
        dataHoadon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dataHoadonMouseClicked(evt);
            }
        });
        scroll1.setViewportView(dataHoadon);

        javax.swing.GroupLayout HoaDonLayout = new javax.swing.GroupLayout(HoaDon);
        HoaDon.setLayout(HoaDonLayout);
        HoaDonLayout.setHorizontalGroup(
            HoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(HoaDonLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(scroll1, javax.swing.GroupLayout.PREFERRED_SIZE, 455, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(HoaDonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(searchHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(search1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        HoaDonLayout.setVerticalGroup(
            HoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, HoaDonLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(HoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(search1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addComponent(scroll1, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        DanhSachSP.setBackground(new java.awt.Color(0, 204, 204));

        scroll22.setBackground(new java.awt.Color(0, 204, 204));
        scroll22.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Danh Sách Sản Phẩm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12), new java.awt.Color(0, 51, 51))); // NOI18N

        Sachtb.setBackground(new java.awt.Color(204, 255, 204));
        Sachtb.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        Sachtb.setForeground(new java.awt.Color(0, 51, 51));
        Sachtb.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"S1", "Doraemon",  new Integer(20),  new Long(25000), "Kim Đồng"},
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
                "Mã Sách", "Tên Sách", "Số Lượng Còn Lại", "Đơn giá", "Nhà Xuất Bản"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Long.class, java.lang.String.class
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
        Sachtb.setShowGrid(true);
        Sachtb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SachtbMouseClicked(evt);
            }
        });
        scroll22.setViewportView(Sachtb);
        if (Sachtb.getColumnModel().getColumnCount() > 0) {
            Sachtb.getColumnModel().getColumn(0).setResizable(false);
            Sachtb.getColumnModel().getColumn(1).setResizable(false);
            Sachtb.getColumnModel().getColumn(2).setResizable(false);
            Sachtb.getColumnModel().getColumn(3).setResizable(false);
            Sachtb.getColumnModel().getColumn(4).setResizable(false);
        }

        search2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-magnifying-glass-30.png"))); // NOI18N
        search2.setToolTipText("Tìm kiếm");
        search2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));
        search2.setBorderPainted(false);
        search2.setContentAreaFilled(false);
        search2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search2ActionPerformed(evt);
            }
        });

        searchSach.setBackground(new java.awt.Color(204, 255, 204));
        searchSach.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tìm Kiếm Sách", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12), new java.awt.Color(0, 51, 51))); // NOI18N
        searchSach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchSachActionPerformed(evt);
            }
        });

        panelImg.setBackground(new java.awt.Color(204, 255, 204));
        panelImg.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Ảnh minh họa", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12), new java.awt.Color(0, 51, 51))); // NOI18N

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/doraemon.jpg"))); // NOI18N

        javax.swing.GroupLayout panelImgLayout = new javax.swing.GroupLayout(panelImg);
        panelImg.setLayout(panelImgLayout);
        panelImgLayout.setHorizontalGroup(
            panelImgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelImgLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(0, 0, 0))
        );
        panelImgLayout.setVerticalGroup(
            panelImgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelImgLayout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout DanhSachSPLayout = new javax.swing.GroupLayout(DanhSachSP);
        DanhSachSP.setLayout(DanhSachSPLayout);
        DanhSachSPLayout.setHorizontalGroup(
            DanhSachSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DanhSachSPLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(DanhSachSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DanhSachSPLayout.createSequentialGroup()
                        .addComponent(searchSach, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(search2)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(DanhSachSPLayout.createSequentialGroup()
                        .addComponent(scroll22, javax.swing.GroupLayout.DEFAULT_SIZE, 443, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelImg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        DanhSachSPLayout.setVerticalGroup(
            DanhSachSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DanhSachSPLayout.createSequentialGroup()
                .addGroup(DanhSachSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(DanhSachSPLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(panelImg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(DanhSachSPLayout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addGroup(DanhSachSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(searchSach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(search2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(scroll22, javax.swing.GroupLayout.DEFAULT_SIZE, 323, Short.MAX_VALUE)))
                .addContainerGap())
        );

        ThongTinBanHang.setBackground(new java.awt.Color(0, 204, 204));
        ThongTinBanHang.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông Tin Bán Hàng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12), new java.awt.Color(0, 51, 51))); // NOI18N
        ThongTinBanHang.setForeground(new java.awt.Color(0, 51, 51));
        ThongTinBanHang.setFocusable(false);

        ttKH.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        ttKH.setForeground(new java.awt.Color(0, 51, 51));
        ttKH.setText("Khách Hàng Mua");

        maHD.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        maHD.setForeground(new java.awt.Color(0, 51, 51));
        maHD.setText("Mã Hóa Đơn");

        NhaptenKH.setBackground(new java.awt.Color(204, 255, 204));
        NhaptenKH.setForeground(new java.awt.Color(0, 51, 51));
        NhaptenKH.setText("Nhập tên Khách Hàng");
        NhaptenKH.setEnabled(false);
        NhaptenKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NhaptenKHActionPerformed(evt);
            }
        });

        ttNV.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        ttNV.setForeground(new java.awt.Color(0, 51, 51));
        ttNV.setText("Nhân Viên");

        selectKH.add(Chuacotaikhoan);
        Chuacotaikhoan.setForeground(new java.awt.Color(0, 51, 51));
        Chuacotaikhoan.setText("Chưa có tài khoản");
        Chuacotaikhoan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ChuacotaikhoanActionPerformed(evt);
            }
        });

        selectKH.add(Dacotaikhoan);
        Dacotaikhoan.setForeground(new java.awt.Color(0, 51, 51));
        Dacotaikhoan.setText("Đã có tài khoản");
        Dacotaikhoan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DacotaikhoanActionPerformed(evt);
            }
        });

        maHDtext.setEditable(false);
        maHDtext.setBackground(new java.awt.Color(204, 255, 204));
        maHDtext.setForeground(new java.awt.Color(0, 51, 51));
        maHDtext.setText("HD01");
        maHDtext.setFocusable(false);
        maHDtext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maHDtextActionPerformed(evt);
            }
        });

        comboxKH.setBackground(new java.awt.Color(204, 255, 204));
        comboxKH.setForeground(new java.awt.Color(0, 51, 51));
        comboxKH.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Khách hàng 1", "Khách hàng 2", "Khách hàng 3", "Khách hàng4", " " }));
        comboxKH.setEnabled(false);
        comboxKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboxKHActionPerformed(evt);
            }
        });

        nv.setEditable(false);
        nv.setBackground(new java.awt.Color(204, 255, 204));
        nv.setForeground(new java.awt.Color(0, 51, 51));
        nv.setText("User");
        nv.setFocusable(false);
        nv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nvActionPerformed(evt);
            }
        });

        newKH.setBackground(new java.awt.Color(204, 255, 204));
        newKH.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        newKH.setForeground(new java.awt.Color(0, 51, 51));
        newKH.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_user_30px.png"))); // NOI18N
        newKH.setText("Thêm Mới Khách Hàng");
        newKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newKHActionPerformed(evt);
            }
        });

        ThemBtn.setBackground(new java.awt.Color(204, 255, 204));
        ThemBtn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        ThemBtn.setForeground(new java.awt.Color(0, 51, 51));
        ThemBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_add_30px.png"))); // NOI18N
        ThemBtn.setText("Thêm Hóa Đơn");
        ThemBtn.setToolTipText("Thêm mới hóa đơn bán hàng");
        ThemBtn.setHideActionText(true);
        ThemBtn.setMaximumSize(new java.awt.Dimension(130, 37));
        ThemBtn.setMinimumSize(new java.awt.Dimension(130, 37));
        ThemBtn.setPreferredSize(new java.awt.Dimension(130, 37));
        ThemBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ThemBtnActionPerformed(evt);
            }
        });

        XoaBtn.setBackground(new java.awt.Color(204, 255, 204));
        XoaBtn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        XoaBtn.setForeground(new java.awt.Color(0, 51, 51));
        XoaBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_delete_30px_1.png"))); // NOI18N
        XoaBtn.setText("Xóa Hóa Đơn");
        XoaBtn.setToolTipText("Xóa hóa đơn bị lỗi");
        XoaBtn.setMaximumSize(new java.awt.Dimension(130, 37));
        XoaBtn.setMinimumSize(new java.awt.Dimension(130, 37));
        XoaBtn.setPreferredSize(new java.awt.Dimension(130, 37));
        XoaBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                XoaBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ThongTinBanHangLayout = new javax.swing.GroupLayout(ThongTinBanHang);
        ThongTinBanHang.setLayout(ThongTinBanHangLayout);
        ThongTinBanHangLayout.setHorizontalGroup(
            ThongTinBanHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ThongTinBanHangLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(ThongTinBanHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ThongTinBanHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(ThongTinBanHangLayout.createSequentialGroup()
                            .addGroup(ThongTinBanHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(Dacotaikhoan, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(ttKH, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(Chuacotaikhoan))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(ThongTinBanHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(NhaptenKH)
                                .addComponent(comboxKH, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(ThongTinBanHangLayout.createSequentialGroup()
                            .addGroup(ThongTinBanHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(ttNV, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(maHD, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(44, 44, 44)
                            .addGroup(ThongTinBanHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(nv)
                                .addComponent(maHDtext))))
                    .addComponent(newKH)
                    .addGroup(ThongTinBanHangLayout.createSequentialGroup()
                        .addComponent(ThemBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(XoaBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(165, Short.MAX_VALUE))
        );
        ThongTinBanHangLayout.setVerticalGroup(
            ThongTinBanHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ThongTinBanHangLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ThongTinBanHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(maHD)
                    .addComponent(maHDtext, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ThongTinBanHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ttNV)
                    .addComponent(nv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ttKH)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ThongTinBanHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Dacotaikhoan)
                    .addComponent(comboxKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ThongTinBanHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Chuacotaikhoan)
                    .addComponent(NhaptenKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(newKH, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(ThongTinBanHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ThemBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(XoaBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        ChiTietHD.setBackground(new java.awt.Color(0, 204, 204));
        ChiTietHD.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Chi Tiết Hóa Đơn", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12), new java.awt.Color(0, 51, 51))); // NOI18N
        ChiTietHD.setFocusable(false);

        tongtien.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        tongtien.setForeground(new java.awt.Color(0, 51, 51));
        tongtien.setText("Tổng tiền (VND)");

        sum.setEditable(false);
        sum.setBackground(new java.awt.Color(204, 255, 204));
        sum.setFocusable(false);

        scroll3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Danh Sách Sản Phẩm Đã Chọn", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12), new java.awt.Color(0, 51, 51))); // NOI18N

        selectedSach.setBackground(new java.awt.Color(204, 255, 204));
        selectedSach.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        selectedSach.setForeground(new java.awt.Color(0, 51, 51));
        selectedSach.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"S1", "Doraemon", "2", "25000", "45000"},
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
                "Mã Sách", "Tên Sách", "Số Lượng", "Đơn Giá", "Thành Tiền"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        selectedSach.setShowGrid(true);
        scroll3.setViewportView(selectedSach);
        if (selectedSach.getColumnModel().getColumnCount() > 0) {
            selectedSach.getColumnModel().getColumn(0).setResizable(false);
            selectedSach.getColumnModel().getColumn(1).setResizable(false);
            selectedSach.getColumnModel().getColumn(2).setResizable(false);
            selectedSach.getColumnModel().getColumn(3).setResizable(false);
            selectedSach.getColumnModel().getColumn(4).setResizable(false);
        }

        xoaspbtn.setBackground(new java.awt.Color(204, 255, 204));
        xoaspbtn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        xoaspbtn.setForeground(new java.awt.Color(0, 51, 51));
        xoaspbtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_delete_30px_1.png"))); // NOI18N
        xoaspbtn.setText("Xóa Sản Phẩm");
        xoaspbtn.setToolTipText("Xóa hóa đơn bị lỗi");
        xoaspbtn.setMaximumSize(new java.awt.Dimension(130, 37));
        xoaspbtn.setMinimumSize(new java.awt.Dimension(130, 37));
        xoaspbtn.setPreferredSize(new java.awt.Dimension(130, 37));
        xoaspbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                xoaspbtnActionPerformed(evt);
            }
        });

        submit.setBackground(new java.awt.Color(204, 255, 204));
        submit.setForeground(new java.awt.Color(0, 51, 51));
        submit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_ok_30px.png"))); // NOI18N
        submit.setText("Hoàn tất");
        submit.setToolTipText("Thêm mới hóa đơn bán hàng");
        submit.setHideActionText(true);
        submit.setMaximumSize(new java.awt.Dimension(130, 37));
        submit.setMinimumSize(new java.awt.Dimension(130, 37));
        submit.setPreferredSize(new java.awt.Dimension(130, 37));
        submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ChiTietHDLayout = new javax.swing.GroupLayout(ChiTietHD);
        ChiTietHD.setLayout(ChiTietHDLayout);
        ChiTietHDLayout.setHorizontalGroup(
            ChiTietHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ChiTietHDLayout.createSequentialGroup()
                .addComponent(scroll3, javax.swing.GroupLayout.PREFERRED_SIZE, 699, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
            .addGroup(ChiTietHDLayout.createSequentialGroup()
                .addGroup(ChiTietHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ChiTietHDLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(tongtien)
                        .addGap(18, 18, 18)
                        .addComponent(sum, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ChiTietHDLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(submit, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(xoaspbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(377, 377, 377))
        );
        ChiTietHDLayout.setVerticalGroup(
            ChiTietHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ChiTietHDLayout.createSequentialGroup()
                .addGroup(ChiTietHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(xoaspbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(submit, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addComponent(scroll3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(ChiTietHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tongtien)
                    .addComponent(sum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(DanhSachSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ThongTinBanHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(HoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(ChiTietHD, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addContainerGap(58, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(HoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ChiTietHD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(DanhSachSP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ThongTinBanHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void search1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search1ActionPerformed
    // Lấy nội dung từ JTextField
    String searchText = searchHoaDon.getText();
    loadHOADONToTable();
    // Kiểm tra xem searchText có rỗng không
    if (searchText == null || searchText.trim().isEmpty()) {
        // Nếu rỗng, không làm gì cả và thoát phương thức
        return;
    }
    
    // Tạo một bảng tạm thời để lưu các dòng được lọc
    DefaultTableModel tempModel = new DefaultTableModel();
    tempModel.setColumnIdentifiers(new Object[]{"MAHOADON", "Manv", "TENTAIKHOAN", "NGAYLAP", "Makhuyenmai", "Phantramgiam", "TONGTIEN"});
    
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

                // Kiểm tra xem nếu giá trị này chứa nội dung tìm kiếm
                if (mahoadon.equalsIgnoreCase(searchText.trim()) || manv.equalsIgnoreCase(searchText.trim()) ||
                        makh.equalsIgnoreCase(searchText.trim()) || ngaylap.equalsIgnoreCase(searchText.trim())||
                        makm.equalsIgnoreCase(searchText.trim()) || phantramgiam.equalsIgnoreCase(searchText.trim())||
                        tongtien.equalsIgnoreCase(searchText.trim())) {
                    // Nếu có, thêm dòng này vào bảng tạm thời
                    Object[] row = {
                        dataHoadon.getValueAt(i, 0),
                        dataHoadon.getValueAt(i, 1),
                        dataHoadon.getValueAt(i, 2), // TENKHACHHANG
                        dataHoadon.getValueAt(i, 3), // NGAYLAP
                        dataHoadon.getValueAt(i, 4), // Makhuyenmai
                        dataHoadon.getValueAt(i, 5), // Phantramgiam
                        dataHoadon.getValueAt(i, 6)  // TONGTIEN;
                    };
                    tempModel.addRow(row);
                }
        }
    }
    // Xóa toàn bộ dòng trong dataHoadon
    DefaultTableModel dataModel = (DefaultTableModel) dataHoadon.getModel();
    dataModel.setRowCount(0);
    // Thêm các dòng từ DefaultTableModel tạm thời vào dataHoadon
    for (int i = 0; i < tempModel.getRowCount(); i++) {
        Object[] row = new Object[dataModel.getColumnCount()];
        for (int j = 0; j < dataModel.getColumnCount(); j++) {
            row[j] = tempModel.getValueAt(i, j);
        }
        dataModel.addRow(row);
    }
    }//GEN-LAST:event_search1ActionPerformed

    private void dataHoadonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dataHoadonMouseClicked
        // TODO add your handling code here:
        int row = dataHoadon.rowAtPoint(evt.getPoint());
        if (row >= 0) { // Chỉ xử lý khi chọn hàng hợp lệ
            String maHoaDonStr = dataHoadon.getValueAt(row, 0).toString(); // Lấy giá trị của cột "Mã Hóa Đơn"
            int maHoaDon = Integer.parseInt(maHoaDonStr); // Chuyển đổi thành số nguyên
            HOADON hd = new HOADON(maHoaDon);
            loadCHITIETHOADONToTable(hd);
        }

    }//GEN-LAST:event_dataHoadonMouseClicked

    private void NhaptenKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NhaptenKHActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NhaptenKHActionPerformed

    private void ChuacotaikhoanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ChuacotaikhoanActionPerformed
        // TODO add your handling code here:
        if(Chuacotaikhoan.isSelected()){
            comboxKH.setEnabled(false);
            NhaptenKH.setEnabled(true);
            NhaptenKH.setText("");

        }
    }//GEN-LAST:event_ChuacotaikhoanActionPerformed

    private void DacotaikhoanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DacotaikhoanActionPerformed
        // TODO add your handling code here:
        if(Dacotaikhoan.isSelected()){
            comboxKH.setEnabled(true);
            NhaptenKH.setEnabled(false);
            NhaptenKH.setText("Nhập tên Khách Hàng");
        }
    }//GEN-LAST:event_DacotaikhoanActionPerformed

    private void maHDtextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maHDtextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_maHDtextActionPerformed

    private void comboxKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboxKHActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboxKHActionPerformed

    private void nvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nvActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nvActionPerformed

    private void newKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newKHActionPerformed
        // TODO add your handling code here:
        AddKhachHang x=new AddKhachHang();
        x.setVisible(true);
    }//GEN-LAST:event_newKHActionPerformed

    private void ThemBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ThemBtnActionPerformed
        // TODO add your handling code here:
        submit.setVisible(true);
        xoaspbtn.setVisible(true);
        DefaultTableModel model = (DefaultTableModel) selectedSach.getModel();
        // Xóa tất cả các dòng cũ trong bảng trước khi load dữ liệu mới
        model.setRowCount(0);
        status=1;
        System.out.println(status);

    }//GEN-LAST:event_ThemBtnActionPerformed

    private void XoaBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_XoaBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_XoaBtnActionPerformed

    private void search2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search2ActionPerformed
        // TODO add your handling code here:
                // Lấy nội dung từ JTextField
        String searchText = searchSach.getText();
        loadBooksToTable();
        System.out.println("co bam tim sach");
        // Kiểm tra xem searchText có rỗng không
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
        DefaultTableModel dataModel = (DefaultTableModel) Sachtb.getModel();
        dataModel.setRowCount(0);
        // Thêm các dòng từ DefaultTableModel tạm thời vào dataHoadon
        for (int i = 0; i < tempModel.getRowCount(); i++) {
            Object[] row = new Object[dataModel.getColumnCount()];
            for (int j = 0; j < dataModel.getColumnCount(); j++) {
                row[j] = tempModel.getValueAt(i, j);
            }
            dataModel.addRow(row);
        }
    }//GEN-LAST:event_search2ActionPerformed

    private void xoaspbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_xoaspbtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_xoaspbtnActionPerformed

    private void submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitActionPerformed
        // TODO add your handling code here:
        submit.setVisible(false);
        xoaspbtn.setVisible(false);
        status=0;
    }//GEN-LAST:event_submitActionPerformed

    private void searchSachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchSachActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchSachActionPerformed

    private void SachtbMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SachtbMouseClicked
        // TODO add your handling code here:
                // TODO add your handling code here:
        int row = Sachtb.rowAtPoint(evt.getPoint());
        if (row >= 0) { // Chỉ xử lý khi chọn hàng hợp lệ
            if(status==0){
            String maHoaDonStr = Sachtb.getValueAt(row, 0).toString(); // Lấy giá trị của cột "Mã Hóa Đơn"
            int maHoaDon = Integer.parseInt(maHoaDonStr); // Chuyển đổi thành số nguyên
            SACH hd = new SACH(maHoaDon);
            SACH result=SACHDAO.getInstance().selectById(hd);
            loadAnh(result);
            }
            else{
            String maHoaDonStr = Sachtb.getValueAt(row, 0).toString(); // Lấy giá trị của cột "Mã Hóa Đơn"
            int maHoaDon = Integer.parseInt(maHoaDonStr); // Chuyển đổi thành số nguyên
            System.out.println("da them sach vao chi tiet hoa don "+maHoaDon);
            }
        }

    }//GEN-LAST:event_SachtbMouseClicked

    private void searchHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchHoaDonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchHoaDonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ChiTietHD;
    private javax.swing.JRadioButton Chuacotaikhoan;
    private javax.swing.JRadioButton Dacotaikhoan;
    private javax.swing.JPanel DanhSachSP;
    private javax.swing.JPanel HoaDon;
    private javax.swing.JTextField NhaptenKH;
    private javax.swing.JTable Sachtb;
    private javax.swing.JButton ThemBtn;
    private javax.swing.JPanel ThongTinBanHang;
    private javax.swing.JButton XoaBtn;
    private javax.swing.JComboBox<String> comboxKH;
    private javax.swing.JTable dataHoadon;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel maHD;
    private javax.swing.JTextField maHDtext;
    private javax.swing.JButton newKH;
    private javax.swing.JTextField nv;
    private javax.swing.JPanel panelImg;
    private javax.swing.JScrollPane scroll1;
    private javax.swing.JScrollPane scroll22;
    private javax.swing.JScrollPane scroll3;
    private javax.swing.JButton search1;
    private javax.swing.JButton search2;
    private javax.swing.JTextField searchHoaDon;
    private javax.swing.JTextField searchSach;
    private javax.swing.ButtonGroup selectKH;
    private javax.swing.JTable selectedSach;
    private javax.swing.JButton submit;
    private javax.swing.JTextField sum;
    private javax.swing.JLabel tongtien;
    private javax.swing.JLabel ttKH;
    private javax.swing.JLabel ttNV;
    private javax.swing.JButton xoaspbtn;
    // End of variables declaration//GEN-END:variables
}
