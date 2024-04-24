/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Main.FrontEnd;

import Main.BackEnd.repository.dao.CHITIETHOADONDAO;
import Main.BackEnd.repository.dao.CHITIETPHIEUNHAPDAO;
import Main.BackEnd.repository.dao.HOADONDAO;
import Main.BackEnd.repository.dao.KHUYENMAIDAO;
import Main.BackEnd.repository.dao.PHIEUNHAPDAO;
import Main.BackEnd.repository.dao.SACHDAO;
import Main.BackEnd.repository.modal.CHITIETHOADON;
import Main.BackEnd.repository.modal.CHITIETPHIEUNHAP;
import Main.BackEnd.repository.modal.HOADON;
import Main.BackEnd.repository.modal.KHUYENMAI;
import Main.BackEnd.repository.modal.PHIEUNHAP;
import Main.BackEnd.repository.modal.SACH;
import Main.FrontEnd.FormAdd.AddNhaCungCap;
import Main.FrontEnd.FormAdd.AddSach;
import Main.FrontEnd.FormEdit.EditSach;
import java.awt.Image;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DELL
 */
public class NhapHangPanel extends javax.swing.JPanel {

    /**
     * Creates new form NhapHangPanel
     */int status=0;
       SACH sachclicked=null;
        public void loadBooksToTable() {
        DefaultTableModel model = (DefaultTableModel) Nhaptb.getModel();
        // Xóa tất cả các dòng cũ trong bảng trước khi load dữ liệu mới
        model.setRowCount(0);

        try {
            ArrayList<SACH> sachList = SACHDAO.getInstance().selectAllExceptISHIDDEN();

            for (SACH sach : sachList) {
                Object[] row = {sach.getMASACH(), sach.getTENSACH(),sach.getGIABIA(), sach.getTENNHAXUATBAN()};
                model.addRow(row);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
        public void loadPHIEUNHAPToTable() {
        DefaultTableModel model = (DefaultTableModel) PhieuNhaptb.getModel();
        // Xóa tất cả các dòng cũ trong bảng trước khi load dữ liệu mới
        model.setRowCount(0);

        try {
            System.out.print("hoạt động");
            ArrayList<PHIEUNHAP> hoadonList = PHIEUNHAPDAO.getInstance().selectAll();
            
            for (PHIEUNHAP hoadon : hoadonList) {             
                Object[] row = {hoadon.getMapn(),hoadon.getManv(),hoadon.getNoinhap(),hoadon.getNgaynhap(),hoadon.getTongtien()};
                model.addRow(row);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }    
    public void loadCHITIETPHIEUNHAPToTable(PHIEUNHAP t) {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        // Xóa tất cả các dòng cũ trong bảng trước khi load dữ liệu mới
        model.setRowCount(0);

        try {
            System.out.print("hoạt động");
            ArrayList<CHITIETPHIEUNHAP> chitiethoadonList = CHITIETPHIEUNHAPDAO.getInstance().selectAllByPHIEUNHAP(t);
            for (CHITIETPHIEUNHAP chitiethoadon : chitiethoadonList) {
                SACH sach=new SACH(chitiethoadon.getMASACH());
                SACH result=SACHDAO.getInstance().selectById(sach);
                Object[] row = {chitiethoadon.getMASACH(),result.getTENSACH(),result.getGIABIA(),chitiethoadon.getSoluong(),chitiethoadon.getTongtien()};
                model.addRow(row);
            }
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

    
    
    public NhapHangPanel() {
        initComponents();
        submit.setVisible(false);
        xoaspbtn.setVisible(false);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PhieuNhap = new javax.swing.JPanel();
        scroll1 = new javax.swing.JScrollPane();
        PhieuNhaptb = new javax.swing.JTable();
        inputsearch1 = new javax.swing.JTextField();
        Search = new javax.swing.JButton();
        DanhSachNhap = new javax.swing.JPanel();
        scroll2 = new javax.swing.JScrollPane();
        Nhaptb = new javax.swing.JTable();
        inputsearch2 = new javax.swing.JTextField();
        Search1 = new javax.swing.JButton();
        panelImg = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        SuaBtn1 = new javax.swing.JButton();
        XoaBtn1 = new javax.swing.JButton();
        addNewSach = new javax.swing.JButton();
        ChiTietHD = new javax.swing.JPanel();
        NhaCC = new javax.swing.JTextField();
        scroll3 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        submit = new javax.swing.JButton();
        xoaspbtn = new javax.swing.JButton();
        ThongTinNhapHangPanel = new javax.swing.JPanel();
        tongtien = new javax.swing.JLabel();
        maNhapHang = new javax.swing.JTextField();
        sum = new javax.swing.JTextField();
        nhacungcap = new javax.swing.JLabel();
        selectNCC = new javax.swing.JComboBox<>();
        addNewNCC = new javax.swing.JButton();
        SL = new javax.swing.JTextField();
        NV = new javax.swing.JTextField();
        ThemBtn = new javax.swing.JButton();
        XoaBtn = new javax.swing.JButton();

        setBackground(new java.awt.Color(0, 153, 153));
        setPreferredSize(new java.awt.Dimension(1250, 750));

        PhieuNhap.setBackground(new java.awt.Color(0, 204, 204));

        scroll1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Phiếu Nhập", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12), new java.awt.Color(0, 51, 51))); // NOI18N

        PhieuNhaptb.setAutoCreateRowSorter(true);
        PhieuNhaptb.setBackground(new java.awt.Color(204, 255, 204));
        PhieuNhaptb.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        PhieuNhaptb.setForeground(new java.awt.Color(0, 51, 51));
        PhieuNhaptb.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"PN1", "NV1", "Kim Đồng", "16-04-2024", "500000"},
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
                "Mã Phiếu Nhập", "Người Nhập", "Nhà Cung Cấp", "Ngày Lập", "Tổng tiền"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
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
        PhieuNhaptb.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        PhieuNhaptb.setShowGrid(true);
        PhieuNhaptb.setSurrendersFocusOnKeystroke(true);
        PhieuNhaptb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PhieuNhaptbMouseClicked(evt);
            }
        });
        scroll1.setViewportView(PhieuNhaptb);
        if (PhieuNhaptb.getColumnModel().getColumnCount() > 0) {
            PhieuNhaptb.getColumnModel().getColumn(0).setResizable(false);
            PhieuNhaptb.getColumnModel().getColumn(1).setResizable(false);
            PhieuNhaptb.getColumnModel().getColumn(2).setResizable(false);
            PhieuNhaptb.getColumnModel().getColumn(3).setResizable(false);
            PhieuNhaptb.getColumnModel().getColumn(4).setResizable(false);
        }

        inputsearch1.setBackground(new java.awt.Color(204, 255, 204));
        inputsearch1.setForeground(new java.awt.Color(0, 51, 51));
        inputsearch1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tìm Kiếm Phiếu Nhập", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12), new java.awt.Color(0, 51, 51))); // NOI18N
        inputsearch1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputsearch1ActionPerformed(evt);
            }
        });

        Search.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-magnifying-glass-30.png"))); // NOI18N
        Search.setToolTipText("Tìm kiếm");
        Search.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));
        Search.setBorderPainted(false);
        Search.setContentAreaFilled(false);
        Search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PhieuNhapLayout = new javax.swing.GroupLayout(PhieuNhap);
        PhieuNhap.setLayout(PhieuNhapLayout);
        PhieuNhapLayout.setHorizontalGroup(
            PhieuNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PhieuNhapLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(inputsearch1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Search)
                .addContainerGap(388, Short.MAX_VALUE))
            .addGroup(PhieuNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(PhieuNhapLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(scroll1, javax.swing.GroupLayout.PREFERRED_SIZE, 576, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        PhieuNhapLayout.setVerticalGroup(
            PhieuNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PhieuNhapLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PhieuNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(inputsearch1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Search))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(PhieuNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PhieuNhapLayout.createSequentialGroup()
                    .addContainerGap(61, Short.MAX_VALUE)
                    .addComponent(scroll1, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );

        DanhSachNhap.setBackground(new java.awt.Color(0, 204, 204));

        scroll2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông Tin Sách Nhập", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12), new java.awt.Color(0, 51, 51))); // NOI18N

        Nhaptb.setBackground(new java.awt.Color(204, 255, 204));
        Nhaptb.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        Nhaptb.setForeground(new java.awt.Color(0, 51, 51));
        Nhaptb.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"S1", "Doraemon",  new Long(25000), "Kim Đồng"},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Mã Sách", "Tên Sách", "Đơn giá", "Nhà Cung Cấp"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Long.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Nhaptb.setShowGrid(true);
        Nhaptb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                NhaptbMouseClicked(evt);
            }
        });
        scroll2.setViewportView(Nhaptb);
        if (Nhaptb.getColumnModel().getColumnCount() > 0) {
            Nhaptb.getColumnModel().getColumn(0).setResizable(false);
            Nhaptb.getColumnModel().getColumn(1).setResizable(false);
            Nhaptb.getColumnModel().getColumn(3).setResizable(false);
        }

        inputsearch2.setBackground(new java.awt.Color(204, 255, 204));
        inputsearch2.setForeground(new java.awt.Color(0, 51, 51));
        inputsearch2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tìm Kiếm Sách", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12), new java.awt.Color(0, 51, 51))); // NOI18N
        inputsearch2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputsearch2ActionPerformed(evt);
            }
        });

        Search1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-magnifying-glass-30.png"))); // NOI18N
        Search1.setToolTipText("Tìm kiếm");
        Search1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));
        Search1.setBorderPainted(false);
        Search1.setContentAreaFilled(false);
        Search1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Search1ActionPerformed(evt);
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
                .addGap(0, 0, 0)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        SuaBtn1.setBackground(new java.awt.Color(204, 255, 204));
        SuaBtn1.setForeground(new java.awt.Color(0, 51, 51));
        SuaBtn1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_wrench_30px.png"))); // NOI18N
        SuaBtn1.setText("Sửa");
        SuaBtn1.setToolTipText("Sửa hóa đơn nhập sai");
        SuaBtn1.setMaximumSize(new java.awt.Dimension(130, 37));
        SuaBtn1.setMinimumSize(new java.awt.Dimension(130, 37));
        SuaBtn1.setPreferredSize(new java.awt.Dimension(130, 37));
        SuaBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SuaBtn1ActionPerformed(evt);
            }
        });

        XoaBtn1.setBackground(new java.awt.Color(204, 255, 204));
        XoaBtn1.setForeground(new java.awt.Color(0, 51, 51));
        XoaBtn1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_delete_30px_1.png"))); // NOI18N
        XoaBtn1.setText("Xóa");
        XoaBtn1.setToolTipText("Xóa hóa đơn bị lỗi");
        XoaBtn1.setMaximumSize(new java.awt.Dimension(130, 37));
        XoaBtn1.setMinimumSize(new java.awt.Dimension(130, 37));
        XoaBtn1.setPreferredSize(new java.awt.Dimension(130, 37));
        XoaBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                XoaBtn1ActionPerformed(evt);
            }
        });

        addNewSach.setBackground(new java.awt.Color(204, 255, 204));
        addNewSach.setForeground(new java.awt.Color(0, 51, 51));
        addNewSach.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_add_30px.png"))); // NOI18N
        addNewSach.setText("Thêm sách mới");
        addNewSach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addNewSachActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout DanhSachNhapLayout = new javax.swing.GroupLayout(DanhSachNhap);
        DanhSachNhap.setLayout(DanhSachNhapLayout);
        DanhSachNhapLayout.setHorizontalGroup(
            DanhSachNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DanhSachNhapLayout.createSequentialGroup()
                .addGroup(DanhSachNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(DanhSachNhapLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(inputsearch2, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(Search1)
                        .addGap(0, 0, 0)
                        .addComponent(addNewSach)
                        .addGap(5, 5, 5)
                        .addComponent(SuaBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(XoaBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(scroll2))
                .addGap(0, 0, 0)
                .addComponent(panelImg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        DanhSachNhapLayout.setVerticalGroup(
            DanhSachNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DanhSachNhapLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(DanhSachNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panelImg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(DanhSachNhapLayout.createSequentialGroup()
                        .addGroup(DanhSachNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(DanhSachNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(Search1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(inputsearch2))
                            .addGroup(DanhSachNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(SuaBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(XoaBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(addNewSach, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(scroll2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        ChiTietHD.setBackground(new java.awt.Color(0, 204, 204));
        ChiTietHD.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Chi Tiết Phiếu Nhập", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12), new java.awt.Color(0, 51, 51))); // NOI18N
        ChiTietHD.setPreferredSize(new java.awt.Dimension(188, 188));

        NhaCC.setEditable(false);
        NhaCC.setBackground(new java.awt.Color(204, 255, 204));
        NhaCC.setForeground(new java.awt.Color(0, 51, 51));
        NhaCC.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nhà Cung Cấp", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12), new java.awt.Color(0, 51, 51))); // NOI18N
        NhaCC.setFocusable(false);

        jTable1.setBackground(new java.awt.Color(204, 255, 204));
        jTable1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jTable1.setForeground(new java.awt.Color(0, 51, 51));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
                {null, null, null, null, null}
            },
            new String [] {
                "Mã Sách", "Tên Sách", "Đơn Giá", "Số Lượng", "Thành Tiền"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setShowGrid(true);
        scroll3.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setResizable(false);
            jTable1.getColumnModel().getColumn(3).setResizable(false);
            jTable1.getColumnModel().getColumn(4).setResizable(false);
        }

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

        javax.swing.GroupLayout ChiTietHDLayout = new javax.swing.GroupLayout(ChiTietHD);
        ChiTietHD.setLayout(ChiTietHDLayout);
        ChiTietHDLayout.setHorizontalGroup(
            ChiTietHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ChiTietHDLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ChiTietHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scroll3, javax.swing.GroupLayout.DEFAULT_SIZE, 614, Short.MAX_VALUE)
                    .addGroup(ChiTietHDLayout.createSequentialGroup()
                        .addComponent(NhaCC, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(submit, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(xoaspbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        ChiTietHDLayout.setVerticalGroup(
            ChiTietHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ChiTietHDLayout.createSequentialGroup()
                .addGroup(ChiTietHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ChiTietHDLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(NhaCC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ChiTietHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(submit, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(xoaspbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scroll3, javax.swing.GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE)
                .addContainerGap())
        );

        ThongTinNhapHangPanel.setBackground(new java.awt.Color(0, 204, 204));
        ThongTinNhapHangPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông Tin Nhập Hàng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12), new java.awt.Color(0, 51, 51))); // NOI18N

        tongtien.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        tongtien.setForeground(new java.awt.Color(0, 51, 51));
        tongtien.setText("Tổng tiền (triệu VND)");

        maNhapHang.setEditable(false);
        maNhapHang.setBackground(new java.awt.Color(204, 255, 204));
        maNhapHang.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        maNhapHang.setForeground(new java.awt.Color(0, 51, 51));
        maNhapHang.setText("NH01");
        maNhapHang.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Mã Nhập Hàng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12), new java.awt.Color(0, 51, 51))); // NOI18N
        maNhapHang.setFocusable(false);
        maNhapHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maNhapHangActionPerformed(evt);
            }
        });

        sum.setEditable(false);
        sum.setBackground(new java.awt.Color(204, 255, 204));
        sum.setText("0");
        sum.setToolTipText("");
        sum.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        sum.setFocusable(false);
        sum.setName(""); // NOI18N
        sum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sumActionPerformed(evt);
            }
        });

        nhacungcap.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        nhacungcap.setForeground(new java.awt.Color(0, 51, 51));
        nhacungcap.setText("Nhà Cung Cấp");

        selectNCC.setForeground(new java.awt.Color(0, 51, 51));
        selectNCC.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        selectNCC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectNCCActionPerformed(evt);
            }
        });

        addNewNCC.setBackground(new java.awt.Color(204, 255, 204));
        addNewNCC.setForeground(new java.awt.Color(0, 51, 51));
        addNewNCC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_downloads_30px.png"))); // NOI18N
        addNewNCC.setText("Thêm nhà cung cấp mới");
        addNewNCC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addNewNCCActionPerformed(evt);
            }
        });

        SL.setBackground(new java.awt.Color(204, 255, 204));
        SL.setForeground(new java.awt.Color(0, 51, 51));
        SL.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Số Lượng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12), new java.awt.Color(0, 51, 51))); // NOI18N
        SL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SLActionPerformed(evt);
            }
        });

        NV.setEditable(false);
        NV.setBackground(new java.awt.Color(204, 255, 204));
        NV.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        NV.setForeground(new java.awt.Color(0, 51, 51));
        NV.setText("User");
        NV.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nhân Viên", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12), new java.awt.Color(0, 51, 51))); // NOI18N
        NV.setFocusable(false);

        ThemBtn.setBackground(new java.awt.Color(204, 255, 204));
        ThemBtn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        ThemBtn.setForeground(new java.awt.Color(0, 51, 51));
        ThemBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_add_30px.png"))); // NOI18N
        ThemBtn.setText("Thêm");
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
        XoaBtn.setText("Xóa");
        XoaBtn.setToolTipText("Xóa hóa đơn bị lỗi");
        XoaBtn.setMaximumSize(new java.awt.Dimension(130, 37));
        XoaBtn.setMinimumSize(new java.awt.Dimension(130, 37));
        XoaBtn.setPreferredSize(new java.awt.Dimension(130, 37));
        XoaBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                XoaBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ThongTinNhapHangPanelLayout = new javax.swing.GroupLayout(ThongTinNhapHangPanel);
        ThongTinNhapHangPanel.setLayout(ThongTinNhapHangPanelLayout);
        ThongTinNhapHangPanelLayout.setHorizontalGroup(
            ThongTinNhapHangPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ThongTinNhapHangPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ThongTinNhapHangPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ThongTinNhapHangPanelLayout.createSequentialGroup()
                        .addGroup(ThongTinNhapHangPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(ThongTinNhapHangPanelLayout.createSequentialGroup()
                                .addComponent(ThemBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(XoaBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(tongtien))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(ThongTinNhapHangPanelLayout.createSequentialGroup()
                        .addGroup(ThongTinNhapHangPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(SL, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(maNhapHang, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(NV, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(ThongTinNhapHangPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(ThongTinNhapHangPanelLayout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(sum, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(ThongTinNhapHangPanelLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(ThongTinNhapHangPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(addNewNCC)
                                    .addGroup(ThongTinNhapHangPanelLayout.createSequentialGroup()
                                        .addComponent(nhacungcap, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(selectNCC, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
        );
        ThongTinNhapHangPanelLayout.setVerticalGroup(
            ThongTinNhapHangPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ThongTinNhapHangPanelLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(ThongTinNhapHangPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(maNhapHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(ThongTinNhapHangPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(nhacungcap)
                        .addComponent(selectNCC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(7, 7, 7)
                .addGroup(ThongTinNhapHangPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addNewNCC, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addComponent(SL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addGroup(ThongTinNhapHangPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tongtien)
                    .addComponent(sum))
                .addGap(30, 30, 30)
                .addGroup(ThongTinNhapHangPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ThemBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(XoaBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(DanhSachNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ThongTinNhapHangPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(PhieuNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ChiTietHD, javax.swing.GroupLayout.PREFERRED_SIZE, 636, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(30, 30, 30))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(PhieuNhap, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ChiTietHD, javax.swing.GroupLayout.DEFAULT_SIZE, 363, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(DanhSachNhap, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ThongTinNhapHangPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void SearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchActionPerformed
        // TODO add your handling code here:
            // Lấy nội dung từ JTextField
    String searchText = inputsearch1.getText();
    loadPHIEUNHAPToTable();
    // Kiểm tra xem searchText có rỗng không
    if (searchText == null || searchText.trim().isEmpty()) {
        // Nếu rỗng, không làm gì cả và thoát phương thức
        return;
    }
    
    // Tạo một bảng tạm thời để lưu các dòng được lọc
    DefaultTableModel tempModel = new DefaultTableModel();
    tempModel.setColumnIdentifiers(new Object[]{"MAPHIEUNHAP","MANV","NHACUNGCAP","NGAYLAP","TONGTIEN"});
    
    // Kiểm tra xem dataHoadon có rỗng không
    if (PhieuNhaptb != null) {
        // Lặp qua từng dòng trong bảng dataHoadon
        for (int i = 0; i < PhieuNhaptb.getRowCount(); i++) {
            // Kiểm tra xem giá trị có phải là String không và không rỗng
    String maphieunhap = PhieuNhaptb.getValueAt(i, 0) != null ? PhieuNhaptb.getValueAt(i, 0).toString().trim() : "null";
    String manv = PhieuNhaptb.getValueAt(i, 1) != null ? PhieuNhaptb.getValueAt(i, 1).toString().trim() : "null";
    String nhacungcap = PhieuNhaptb.getValueAt(i, 2) != null ? PhieuNhaptb.getValueAt(i, 2).toString().trim() : "null";
    String ngaylap = PhieuNhaptb.getValueAt(i, 3) != null ? PhieuNhaptb.getValueAt(i, 3).toString().trim() : "null";
    String tongtien = PhieuNhaptb.getValueAt(i, 4) != null ? PhieuNhaptb.getValueAt(i, 4).toString().trim() : "null";

                // Kiểm tra xem nếu giá trị này chứa nội dung tìm kiếm
                if (maphieunhap.equalsIgnoreCase(searchText.trim()) || manv.equalsIgnoreCase(searchText.trim()) ||
                        nhacungcap.equalsIgnoreCase(searchText.trim()) || ngaylap.equalsIgnoreCase(searchText.trim())||
                        tongtien.equalsIgnoreCase(searchText.trim())) {
                    // Nếu có, thêm dòng này vào bảng tạm thời
                    Object[] row = {
                        PhieuNhaptb.getValueAt(i, 0),
                        PhieuNhaptb.getValueAt(i, 1),
                        PhieuNhaptb.getValueAt(i, 2), // TENKHACHHANG
                        PhieuNhaptb.getValueAt(i, 3), // NGAYLAP
                        PhieuNhaptb.getValueAt(i, 4), // Makhuyenmai
                    };
                    tempModel.addRow(row);
                }
        }
    }
    // Xóa toàn bộ dòng trong dataHoadon
    DefaultTableModel dataModel = (DefaultTableModel) PhieuNhaptb.getModel();
    dataModel.setRowCount(0);
    // Thêm các dòng từ DefaultTableModel tạm thời vào dataHoadon
    for (int i = 0; i < tempModel.getRowCount(); i++) {
        Object[] row = new Object[dataModel.getColumnCount()];
        for (int j = 0; j < dataModel.getColumnCount(); j++) {
            row[j] = tempModel.getValueAt(i, j);
        }
        dataModel.addRow(row);
    }
    }//GEN-LAST:event_SearchActionPerformed

    private void PhieuNhaptbMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PhieuNhaptbMouseClicked
        // TODO add your handling code here:
        int row = PhieuNhaptb.rowAtPoint(evt.getPoint());
        if (row >= 0) { // Chỉ xử lý khi chọn hàng hợp lệ
            String maPHIEUNHAPStr = PhieuNhaptb.getValueAt(row, 0).toString(); // Lấy giá trị của cột "Mã Hóa Đơn"
            int maPn = Integer.parseInt(maPHIEUNHAPStr); // Chuyển đổi thành số nguyên
            PHIEUNHAP hd = new PHIEUNHAP(maPn);
            loadCHITIETPHIEUNHAPToTable(hd);
        }

    }//GEN-LAST:event_PhieuNhaptbMouseClicked

    private void ThemBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ThemBtnActionPerformed
        // TODO add your handling code here:
        submit.setVisible(true);
        xoaspbtn.setVisible(true);
    }//GEN-LAST:event_ThemBtnActionPerformed

    private void XoaBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_XoaBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_XoaBtnActionPerformed

    private void maNhapHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maNhapHangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_maNhapHangActionPerformed

    private void sumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sumActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sumActionPerformed

    private void SLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SLActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SLActionPerformed

    private void addNewSachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addNewSachActionPerformed
        // TODO add your handling code here:
        AddSach x=new AddSach(this);
        x.setVisible(true);
    }//GEN-LAST:event_addNewSachActionPerformed

    private void Search1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Search1ActionPerformed
        // TODO add your handling code here:
                            // Lấy nội dung từ JTextField
    String searchText = inputsearch2.getText();
    loadBooksToTable();
    // Kiểm tra xem searchText có rỗng không
    if (searchText == null || searchText.trim().isEmpty()) {
        // Nếu rỗng, không làm gì cả và thoát phương thức
        return;
    }
    
    // Tạo một bảng tạm thời để lưu các dòng được lọc
    DefaultTableModel tempModel = new DefaultTableModel();
    tempModel.setColumnIdentifiers(new Object[]{"MASACH","TENSACH","DONGIA","NHACUNGCAP"});
    
    // Kiểm tra xem dataHoadon có rỗng không
    if (Nhaptb != null) {
        // Lặp qua từng dòng trong bảng dataHoadon
        for (int i = 0; i < Nhaptb.getRowCount(); i++) {
            // Kiểm tra xem giá trị có phải là String không và không rỗng
    String masach = Nhaptb.getValueAt(i, 0) != null ? Nhaptb.getValueAt(i, 0).toString().trim() : "null";
    String tensach = Nhaptb.getValueAt(i, 1) != null ? Nhaptb.getValueAt(i, 1).toString().trim() : "null";
    String dongia = Nhaptb.getValueAt(i, 2) != null ? Nhaptb.getValueAt(i, 2).toString().trim() : "null";
    String nhacungcap = Nhaptb.getValueAt(i, 3) != null ? Nhaptb.getValueAt(i, 3).toString().trim() : "null";

                // Kiểm tra xem nếu giá trị này chứa nội dung tìm kiếm
                if (masach.equalsIgnoreCase(searchText.trim()) || tensach.equalsIgnoreCase(searchText.trim()) ||
                        dongia.equalsIgnoreCase(searchText.trim()) || nhacungcap.equalsIgnoreCase(searchText.trim())) {
                    // Nếu có, thêm dòng này vào bảng tạm thời
                    Object[] row = {
                        Nhaptb.getValueAt(i, 0),
                        Nhaptb.getValueAt(i, 1),
                        Nhaptb.getValueAt(i, 2), // TENKHACHHANG
                        Nhaptb.getValueAt(i, 3), // NGAYLAP
                    };
                    tempModel.addRow(row);
                }
        }
    }
    // Xóa toàn bộ dòng trong dataHoadon
    DefaultTableModel dataModel = (DefaultTableModel) Nhaptb.getModel();
    dataModel.setRowCount(0);
    // Thêm các dòng từ DefaultTableModel tạm thời vào dataHoadon
    for (int i = 0; i < tempModel.getRowCount(); i++) {
        Object[] row = new Object[dataModel.getColumnCount()];
        for (int j = 0; j < dataModel.getColumnCount(); j++) {
            row[j] = tempModel.getValueAt(i, j);
        }
        dataModel.addRow(row);
    }
    }//GEN-LAST:event_Search1ActionPerformed

    private void inputsearch2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputsearch2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputsearch2ActionPerformed

    private void SuaBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SuaBtn1ActionPerformed
        // TODO add your handling code here:
        if(sachclicked!=null){
            EditSach y=new EditSach(this,sachclicked);
            y.setVisible(true);
        }

        
    }//GEN-LAST:event_SuaBtn1ActionPerformed

    private void XoaBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_XoaBtn1ActionPerformed
        // TODO add your handling code here:
        if(sachclicked!=null){
            SACHDAO.getInstance().delete(sachclicked);
            loadBooksToTable();
            System.out.println("da xoa thanh cong");
        }
    }//GEN-LAST:event_XoaBtn1ActionPerformed

    private void addNewNCCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addNewNCCActionPerformed
        // TODO add your handling code here:
        AddNhaCungCap x=new AddNhaCungCap();
        x.setVisible(true);
    }//GEN-LAST:event_addNewNCCActionPerformed

    private void selectNCCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectNCCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_selectNCCActionPerformed

    private void submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_submitActionPerformed

    private void xoaspbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_xoaspbtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_xoaspbtnActionPerformed

    private void NhaptbMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NhaptbMouseClicked
        // TODO add your handling code here:
        int row = Nhaptb.rowAtPoint(evt.getPoint());
        if (row >= 0) { // Chỉ xử lý khi chọn hàng hợp lệ
            if(status==0){
            String maHoaDonStr = Nhaptb.getValueAt(row, 0).toString(); // Lấy giá trị của cột "Mã Hóa Đơn"
            int maHoaDon = Integer.parseInt(maHoaDonStr); // Chuyển đổi thành số nguyên
            SACH hd = new SACH(maHoaDon);
            SACH result=SACHDAO.getInstance().selectById(hd);
            sachclicked=result;
            loadAnh(result);
            }
            else{
            String maHoaDonStr = Nhaptb.getValueAt(row, 0).toString(); // Lấy giá trị của cột "Mã Hóa Đơn"
            int maHoaDon = Integer.parseInt(maHoaDonStr); // Chuyển đổi thành số nguyên
            System.out.println("da nhap them sach"+maHoaDon);
            }
        }
    }//GEN-LAST:event_NhaptbMouseClicked

    private void inputsearch1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputsearch1ActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_inputsearch1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ChiTietHD;
    private javax.swing.JPanel DanhSachNhap;
    private javax.swing.JTextField NV;
    private javax.swing.JTextField NhaCC;
    private javax.swing.JTable Nhaptb;
    private javax.swing.JPanel PhieuNhap;
    private javax.swing.JTable PhieuNhaptb;
    private javax.swing.JTextField SL;
    private javax.swing.JButton Search;
    private javax.swing.JButton Search1;
    private javax.swing.JButton SuaBtn1;
    private javax.swing.JButton ThemBtn;
    private javax.swing.JPanel ThongTinNhapHangPanel;
    private javax.swing.JButton XoaBtn;
    private javax.swing.JButton XoaBtn1;
    private javax.swing.JButton addNewNCC;
    private javax.swing.JButton addNewSach;
    private javax.swing.JTextField inputsearch1;
    private javax.swing.JTextField inputsearch2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField maNhapHang;
    private javax.swing.JLabel nhacungcap;
    private javax.swing.JPanel panelImg;
    private javax.swing.JScrollPane scroll1;
    private javax.swing.JScrollPane scroll2;
    private javax.swing.JScrollPane scroll3;
    private javax.swing.JComboBox<String> selectNCC;
    private javax.swing.JButton submit;
    private javax.swing.JTextField sum;
    private javax.swing.JLabel tongtien;
    private javax.swing.JButton xoaspbtn;
    // End of variables declaration//GEN-END:variables
}
