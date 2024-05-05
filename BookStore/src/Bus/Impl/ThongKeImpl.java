package Bus.Impl;

import Dao.DAOInterface;
import Dao.HOADONDAO;
import Dao.HOADONDAO;
import Dao.HOADONDAO;
import Dao.KHACHHANGDAO;
import Dao.KHUYENMAIDAO;
import Dao.NHANVIENDAO;
import Dto.HOADON;
import Dto.KHACHANG;
import Dto.KHUYENMAI;
import Dto.NHANVIEN;
import conDatabase.JDBCUtil;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import static org.apache.logging.log4j.util.Strings.isBlank;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

public class ThongKeImpl {
    
    public void DanhSachHoaDon(DefaultTableModel model) {
            ArrayList<HOADON> hoadonList = HOADONDAO.getInstance().selectAll();
            for (HOADON hoadon : hoadonList) {
               
                int makh = hoadon.getmakh(); 
                System.out.print(makh);
                KHACHANG hihi = new KHACHANG(makh);
                KHACHANG result = KHACHHANGDAO.getInstance().selectById(hihi);
                String hoten;
                if(result==null){
                    hoten="";
                }
                else{
                    hoten=result.getHoten();    
                }
                Object[] row = {hoadon.getMAHOADON(),hoadon.getManv(),hoadon.getmakh(),hoten,hoadon.getNGAYLAP(),hoadon.getTONGTIEN()};
                model.addRow(row);

                    }                
            }
    public void loadChiTieu(javax.swing.JTextField t,KHACHANG tt){
        
        int ketqua = HOADONDAO.getInstance().selectMaKHChitieu(tt);
        t.setText(ketqua+""); 
    }
    public void loadDoanhThu(javax.swing.JTextField t,NHANVIEN tt){
        
        int ketqua = HOADONDAO.getInstance().selectMaNVDoanhthu(tt);
        t.setText(ketqua+""); 
    }
    public void loadTongTien(javax.swing.JTextField t){
        int ketqua=HOADONDAO.getInstance().selectTongTien();
        t.setText(ketqua+"");
    }
    public void loadHoaDonMax(DefaultTableModel model, String nhapngay1MAX, String nhapngay2MAX){
        HOADON ketqua=HOADONDAO.getInstance().selectHoaDonMax(nhapngay1MAX,nhapngay2MAX);
        if (ketqua!= null){
            int makh = ketqua.getmakh(); 
            System.out.print(makh);
            KHACHANG hihi = new KHACHANG(makh);
            KHACHANG result = KHACHHANGDAO.getInstance().selectById(hihi);
            String hoten;
                if(result!=null){
                    hoten=result.getHoten();
                }
                else{
                    hoten="";
                }
            Object[] row = {ketqua.getMAHOADON(),ketqua.getManv(),hoten,ketqua.getNGAYLAP(),ketqua.getTONGTIEN()};
            model.addRow(row);
        }
        else{
            ArrayList<HOADON> hoadonList = HOADONDAO.getInstance().selectHoaDonMax2();
            for (HOADON hoadon : hoadonList) {
               
                int makh = hoadon.getmakh(); 
                System.out.print(makh);
                KHACHANG hihi = new KHACHANG(makh);
                KHACHANG result = KHACHHANGDAO.getInstance().selectById(hihi);
                String hoten;
                if(result!=null){
                    hoten=result.getHoten();
                }
                else{
                    hoten="";
                }
                Object[] row = {hoadon.getMAHOADON(),hoadon.getManv(),hoten,hoadon.getNGAYLAP(),hoadon.getTONGTIEN()};
                model.addRow(row);

                    } 
        }    
    }
    public void loadHoaDonTB(javax.swing.JTextField t, String nhapngay1TB, String nhapngay2TB){
        
        if (isBlank(nhapngay1TB) || isBlank(nhapngay2TB) || nhapngay1TB=="" || nhapngay1TB==null || nhapngay2TB=="" || nhapngay2TB==null){
            System.out.println("th1");
            double ketqua=HOADONDAO.getInstance().selectHoaDonTB2();
            t.setText(ketqua+"");
            
        }
        else{
            System.out.println("th2");
            double ketqua=HOADONDAO.getInstance().selectHoaDonTB(nhapngay1TB,nhapngay2TB);
            t.setText(ketqua+"");
        }    
    }
    public static ArrayList<Integer> thongketheotuansum(int month) {
        ArrayList<Integer> ketqua = new ArrayList<>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            con = JDBCUtil.getConnection();
            // Xây dựng câu truy vấn SQL
            String sql = "SELECT TONGTIEN, NGAYLAP FROM hoadon WHERE MONTH(NGAYLAP) = ? AND tthd = 1";
            ps = con.prepareStatement(sql);
            ps.setInt(1, month);
            rs = ps.executeQuery();

            // Khởi tạo mảng chứa tổng tiền của 4 tuần
            int[] tongTienTuan = new int[4];

            while (rs.next()) {
                // Lấy ngày lập hóa đơn
                Date ngayLap = rs.getDate("NGAYLAP");
                Calendar cal = Calendar.getInstance();
                cal.setTime(ngayLap);

                int dayOfMonth = cal.get(Calendar.DAY_OF_MONTH);
                int weekOfMonth;

                // Phân loại ngày vào tuần tương ứng
                if (dayOfMonth >= 1 && dayOfMonth <= 7) {
                    weekOfMonth = 1;
                } else if (dayOfMonth >= 8 && dayOfMonth <= 14) {
                    weekOfMonth = 2;
                } else if (dayOfMonth >= 15 && dayOfMonth <= 21) {
                    weekOfMonth = 3;
                } else {
                    weekOfMonth = 4;
                }

                // Phân loại hóa đơn vào tuần tương ứng và tính tổng tiền
                int tongTien = rs.getInt("TONGTIEN");
                tongTienTuan[weekOfMonth - 1] += tongTien;
            }

            // Thêm tổng tiền của từng tuần vào mảng kết quả
            for (int i = 0; i < 4; i++) {
                ketqua.add(tongTienTuan[i]);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.closeConnection(con);
        }
        return ketqua;
    }

public static ArrayList<Integer> thongketheotuantrungbinh(int month) {
    ArrayList<Integer> ketqua = new ArrayList<>();
    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    try {
        con = JDBCUtil.getConnection();
        String sql = "SELECT TONGTIEN, NGAYLAP FROM hoadon WHERE MONTH(NGAYLAP) = ? AND tthd = 1";
        ps = con.prepareStatement(sql);
        ps.setInt(1, month);
        rs = ps.executeQuery();

        int[] tongTienTuanInt = new int[4];
        int[] soLuongHoaDonTuan = new int[4];
        int currentWeek = -1;
        int tongTienTuanHienTai = 0;
        int soLuongHoaDonTuanHienTai = 0;

        while (rs.next()) {
            Date ngayLap = rs.getDate("NGAYLAP");
            Calendar cal = Calendar.getInstance();
            cal.setTime(ngayLap);
            int weekOfMonth = cal.get(Calendar.WEEK_OF_MONTH);

            if (weekOfMonth != currentWeek) {
                if (currentWeek != -1) {
                    int trungBinhTuan = soLuongHoaDonTuanHienTai > 0 ? tongTienTuanHienTai / soLuongHoaDonTuanHienTai : 0;
                    ketqua.add(trungBinhTuan);
                }

                currentWeek = weekOfMonth;
                tongTienTuanHienTai = 0;
                soLuongHoaDonTuanHienTai = 0;
            }

            int tongTien = rs.getInt("TONGTIEN");
            tongTienTuanHienTai += tongTien;
            soLuongHoaDonTuanHienTai++;
        }

        if (currentWeek != -1) {
            int trungBinhTuan = soLuongHoaDonTuanHienTai > 0 ? tongTienTuanHienTai / soLuongHoaDonTuanHienTai : 0;
            ketqua.add(trungBinhTuan);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        JDBCUtil.closeConnection(con);
    }
    return ketqua;
}

public static ArrayList<Integer> thongketheotuanmax(int month) {
    ArrayList<Integer> ketqua = new ArrayList<>();
    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    try {
        con = JDBCUtil.getConnection();
        String sql = "SELECT TONGTIEN, NGAYLAP FROM hoadon WHERE MONTH(NGAYLAP) = ? AND tthd = 1";
        ps = con.prepareStatement(sql);
        ps.setInt(1, month);
        rs = ps.executeQuery();

        int[] maxTongTienTuan = new int[4];
        int currentWeek = -1;

        while (rs.next()) {
            Date ngayLap = rs.getDate("NGAYLAP");
            Calendar cal = Calendar.getInstance();
            cal.setTime(ngayLap);
            int weekOfMonth = cal.get(Calendar.WEEK_OF_MONTH);

            if (weekOfMonth != currentWeek) {
                if (currentWeek != -1) {
                    ketqua.add(maxTongTienTuan[currentWeek - 1]);
                }

                currentWeek = weekOfMonth;
                maxTongTienTuan[currentWeek - 1] = Integer.MIN_VALUE;
            }

            int tongTien = rs.getInt("TONGTIEN");
            if (tongTien > maxTongTienTuan[currentWeek - 1]) {
                maxTongTienTuan[currentWeek - 1] = tongTien;
            }
        }

        if (currentWeek != -1) {
            ketqua.add(maxTongTienTuan[currentWeek - 1]);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        JDBCUtil.closeConnection(con);
    }
    return ketqua;
}

public static ArrayList<Integer> thongketheotuanmin(int month) {
    ArrayList<Integer> ketqua = new ArrayList<>();
    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    try {
        con = JDBCUtil.getConnection();
        String sql = "SELECT TONGTIEN, NGAYLAP FROM hoadon WHERE MONTH(NGAYLAP) = ? AND tthd = 1";
        ps = con.prepareStatement(sql);
        ps.setInt(1, month);
        rs = ps.executeQuery();

        int[] minTongTienTuan = new int[4];
        int currentWeek = -1;

        while (rs.next()) {
            Date ngayLap = rs.getDate("NGAYLAP");
            Calendar cal = Calendar.getInstance();
            cal.setTime(ngayLap);
            int weekOfMonth = cal.get(Calendar.WEEK_OF_MONTH);

            if (weekOfMonth != currentWeek) {
                if (currentWeek != -1) {
                    ketqua.add(minTongTienTuan[currentWeek - 1]);
                }

                currentWeek = weekOfMonth;
                minTongTienTuan[currentWeek - 1] = Integer.MAX_VALUE;
            }

            int tongTien = rs.getInt("TONGTIEN");
            if (tongTien < minTongTienTuan[currentWeek - 1]) {
                minTongTienTuan[currentWeek - 1] = tongTien;
            }
        }

        if (currentWeek != -1) {
            ketqua.add(minTongTienTuan[currentWeek - 1]);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        JDBCUtil.closeConnection(con);
    }
    return ketqua;
}
public static ArrayList<Integer> thongketheotuancount(int month) {
    ArrayList<Integer> ketqua = new ArrayList<>();
    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    try {
        con = JDBCUtil.getConnection();
        String sql = "SELECT COUNT(*) AS COUNT, NGAYLAP FROM hoadon WHERE MONTH(NGAYLAP) = ? AND tthd = 1 GROUP BY WEEK(NGAYLAP)";
        ps = con.prepareStatement(sql);
        ps.setInt(1, month);
        rs = ps.executeQuery();

        int[] soLuongHoaDonTuan = new int[4]; // or [5] if weeks are from 1 to 5
        int currentWeek = -1;

        while (rs.next()) {
            Date ngayLap = rs.getDate("NGAYLAP");
            Calendar cal = Calendar.getInstance();
            cal.setTime(ngayLap);
            int weekOfMonth = cal.get(Calendar.WEEK_OF_MONTH);

            if (weekOfMonth != currentWeek) {
                if (currentWeek != -1) {
                    ketqua.add(soLuongHoaDonTuan[currentWeek - 1]);
                }

                currentWeek = weekOfMonth;
                soLuongHoaDonTuan[currentWeek - 1] = 0;
            }

            soLuongHoaDonTuan[currentWeek - 1] += rs.getInt("COUNT");
        }

        if (currentWeek != -1) {
            ketqua.add(soLuongHoaDonTuan[currentWeek - 1]);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        JDBCUtil.closeConnection(con);
    }
    return ketqua;
}
    public static ArrayList<Double> thongketheothangsum(int year) {
        ArrayList<Double> ketqua = new ArrayList<>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            con = JDBCUtil.getConnection();
            // Xây dựng câu truy vấn SQL
            String sql = "SELECT SUM(TONGTIEN) AS TONGTIEN, MONTH(NGAYLAP) AS THANG FROM hoadon WHERE YEAR(NGAYLAP) = ? AND tthd = 1 GROUP BY MONTH(NGAYLAP)";
            ps = con.prepareStatement(sql);
            ps.setInt(1, year);
            rs = ps.executeQuery();

            // Khởi tạo mảng chứa tổng tiền của các tháng trong năm
            double[] tongTienThang = new double[12];

            while (rs.next()) {
                // Lấy tổng tiền và tháng từ kết quả truy vấn
                double tongTien = rs.getDouble("TONGTIEN");
                int thang = rs.getInt("THANG");

                // Ánh xạ tổng tiền vào vị trí tương ứng trong mảng
                // Cần trừ đi 1 vì tháng được trả về từ cơ sở dữ liệu là từ 1 đến 12
                // Nhưng trong mảng, tháng được đánh số từ 0 đến 11
                tongTienThang[thang - 1] = tongTien;
            }

            // Thêm tổng tiền của từng tháng vào mảng kết quả
            for (int i = 0; i < 12; i++) {
                ketqua.add(tongTienThang[i]);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.closeConnection(con);
        }
        return ketqua;
    }





    public static ArrayList<Integer> thongketheothangaverage(int n) {
        ArrayList<HOADON> danhSachHoaDon = HOADONDAO.getInstance().selectAll();
        ArrayList<Integer> ketqua = new ArrayList<>();

        // Tạo một bảng băm để lưu trữ tổng tiền của mỗi tháng
        Map<Integer, Integer> tongTienTheoThang = new HashMap<>();
        Map<Integer, Integer> soLuongHoaDonTheoThang = new HashMap<>();

        // Tính tổng tiền của mỗi hóa đơn và số lượng hóa đơn của mỗi tháng
        for (HOADON hoaDon : danhSachHoaDon) {
            int thang = hoaDon.getNGAYLAP().getMonth() + 1; // Lấy tháng từ ngày lập hóa đơn và cộng thêm 1
            int tongTien = hoaDon.getTONGTIEN();

            // Nếu đã có tổng tiền của tháng này thì cộng thêm vào, nếu chưa có thì tạo mới
            tongTienTheoThang.put(thang, tongTienTheoThang.getOrDefault(thang, 0) + tongTien);
            soLuongHoaDonTheoThang.put(thang, soLuongHoaDonTheoThang.getOrDefault(thang, 0) + 1);
        }

        // Tính trung bình TONGTIEN của mỗi tháng và thêm vào danh sách kết quả
        for (int thang = 1; thang <= 12; thang++) { // Giả sử dữ liệu trong năm chỉ từ tháng 1 đến tháng 12
            int tongTienThang = tongTienTheoThang.getOrDefault(thang, 0);
            int soLuongHoaDon = soLuongHoaDonTheoThang.getOrDefault(thang, 1); // Tránh chia cho 0
            int average = soLuongHoaDon > 0 ? tongTienThang / soLuongHoaDon : 0;
            ketqua.add(average);
        }

        return ketqua;
    }
    public static ArrayList<Integer> thongketheothangcount() {
        ArrayList<HOADON> danhSachHoaDon = HOADONDAO.getInstance().selectAll();
        ArrayList<Integer> ketqua = new ArrayList<>();

        // Tạo một bảng băm để lưu trữ số lượng hóa đơn của mỗi tháng
        Map<Integer, Integer> soLuongHoaDonTheoThang = new HashMap<>();

        // Đếm số lượng hóa đơn của mỗi tháng
        for (HOADON hoaDon : danhSachHoaDon) {
            int thang = hoaDon.getNGAYLAP().getMonth(); // Lấy tháng từ ngày lập hóa đơn
            soLuongHoaDonTheoThang.put(thang, soLuongHoaDonTheoThang.getOrDefault(thang, 0) + 1);
        }

        // Lấy số lượng hóa đơn của mỗi tháng từ bảng băm và thêm vào danh sách kết quả
        for (int thang = 1; thang <= 12; thang++) { // Giả sử dữ liệu trong năm chỉ từ tháng 1 đến tháng 12
            int soLuongHoaDon = soLuongHoaDonTheoThang.getOrDefault(thang, 0);
            ketqua.add(soLuongHoaDon);
        }

        return ketqua;
    }
    public static ArrayList<Integer> thongketheothangmax() {
        ArrayList<HOADON> danhSachHoaDon = HOADONDAO.getInstance().selectAll();
        ArrayList<Integer> ketqua = new ArrayList<>();

        // Tạo một bảng băm để lưu trữ tổng tiền lớn nhất của mỗi tháng
        Map<Integer, Integer> tongTienMaxTheoThang = new HashMap<>();

        // Tìm tổng tiền lớn nhất của mỗi tháng
        for (HOADON hoaDon : danhSachHoaDon) {
            int thang = hoaDon.getNGAYLAP().getMonth(); // Lấy tháng từ ngày lập hóa đơn
            int tongTien = hoaDon.getTONGTIEN();

            // Nếu đã có tổng tiền lớn nhất của tháng này thì so sánh và cập nhật, nếu chưa có thì tạo mới
            int tongTienMaxThang = tongTienMaxTheoThang.getOrDefault(thang, Integer.MIN_VALUE);
            tongTienMaxTheoThang.put(thang, Math.max(tongTien, tongTienMaxThang));
        }

        // Lấy tổng tiền lớn nhất của mỗi tháng từ bảng băm và thêm vào danh sách kết quả
        for (int thang = 1; thang <= 12; thang++) { // Giả sử dữ liệu trong năm chỉ từ tháng 1 đến tháng 12
            int tongTienMaxThang = tongTienMaxTheoThang.getOrDefault(thang, 0);
            ketqua.add(tongTienMaxThang);
        }

        return ketqua;
    }
    public static  ArrayList<Integer> thongketheothangmin(){
        ArrayList<HOADON> danhSachHoaDon = HOADONDAO.getInstance().selectAll();
        ArrayList<Integer> ketqua = new ArrayList<>();

        // Tạo một bảng băm để lưu trữ tổng tiền lớn nhất của mỗi tháng
        Map<Integer, Integer> tongTienminTheoThang = new HashMap<>();

        // Tìm tổng tiền lớn nhất của mỗi tháng
        for (HOADON hoaDon : danhSachHoaDon) {
            int thang = hoaDon.getNGAYLAP().getMonth(); // Lấy tháng từ ngày lập hóa đơn
            int tongTien = hoaDon.getTONGTIEN();

            // Nếu đã có tổng tiền lớn nhất của tháng này thì so sánh và cập nhật, nếu chưa có thì tạo mới
            int tongTienminThang = tongTienminTheoThang.getOrDefault(thang, Integer.MIN_VALUE);
            tongTienminTheoThang.put(thang, Math.min(tongTien, tongTienminThang));
        }

        // Lấy tổng tiền lớn nhất của mỗi tháng từ bảng băm và thêm vào danh sách kết quả
        for (int thang = 1; thang <= 12; thang++) { // Giả sử dữ liệu trong năm chỉ từ tháng 1 đến tháng 12
            int tongTienminThang = tongTienminTheoThang.getOrDefault(thang, 0);
            ketqua.add(tongTienminThang);
        }

        return ketqua;
    }


   // vẽ biểu đồ tuần
    public static void drawcharttheotuan() {
        // Yêu cầu người dùng nhập tháng
        String input = JOptionPane.showInputDialog(null, "Nhập tháng (1-12):");
        
        // Kiểm tra xem người dùng đã nhập hay chưa
        if (input != null && !input.isEmpty()) {
            try {
                int month = Integer.parseInt(input);
                if (month >= 1 && month <= 12) {
                    // Thống kê và vẽ biểu đồ cho 4 tuần trong tháng đã chọn
                    drawChartForWeeksInMonth(month);
                } else {
                    JOptionPane.showMessageDialog(null, "Tháng không hợp lệ!");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Vui lòng nhập số nguyên!");
            }
        }
    }

    private static void drawChartForWeeksInMonth(int month) {
        // Thống kê và vẽ biểu đồ cho 4 tuần trong tháng đã chọn
        ChartPanel chartPanel = new ChartPanel(createChartForWeeksInMonth(month));
        chartPanel.setPreferredSize(new java.awt.Dimension(560, 367));
        JFrame frame = new JFrame();
        frame.add(chartPanel);
        frame.setTitle("BIỂU ĐỒ DOANH THU TUẦN TRONG THÁNG " + month);
        frame.setSize(600, 400);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
    }

    private static JFreeChart createChartForWeeksInMonth(int month) {
        JFreeChart barChart = ChartFactory.createBarChart(
                "BIỂU ĐỒ THỐNG KÊ DOANH THU TUẦN TRONG THÁNG " + month,
                "TUẦN", "DOANH THU",
                createDatasetForWeeksInMonth(month), PlotOrientation.VERTICAL, false, false, false);
        return barChart;
    }

    private static CategoryDataset createDatasetForWeeksInMonth(int month) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        // Thống kê doanh thu cho 4 tuần trong tháng đã chọn
        ArrayList<Integer> doanhThuTheoTuan = thongketheotuansum(month);
        for (int i = 0; i < doanhThuTheoTuan.size(); i++) {
            dataset.addValue(doanhThuTheoTuan.get(i), "Doanh thu", "Tuần " + (i + 1));
        }
        return dataset;
    }
    // vẽ biểu đồ tháng
    public static void drawcharttheothang() {
        // Lấy tháng hiện tại
        Calendar calendar = Calendar.getInstance();
        int currentMonth = calendar.get(Calendar.MONTH) + 1; // Tháng được đánh số từ 0

        // Nếu hiện tại đang là tháng 6, thì chỉ thống kê từ tháng 1 đến tháng 5
        int endMonth = currentMonth - 1;

        // Thống kê và vẽ biểu đồ trung bình cho các tháng
        drawChartForMonths(endMonth);
    }

    public static void drawChartForMonths(int endMonth) {
        // Thống kê và vẽ biểu đồ cho trung bình các tháng
        ChartPanel chartPanel = new ChartPanel(createChartForMonths(endMonth));
        chartPanel.setPreferredSize(new java.awt.Dimension(560, 367));
        JFrame frame = new JFrame();
        frame.add(chartPanel);
        frame.setTitle("BIỂU ĐỒ DOANH THU TRUNG BÌNH CÁC THÁNG");
        frame.setSize(1000, 500);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
    }

    private static JFreeChart createChartForMonths(int endMonth) {
        JFreeChart barChart = ChartFactory.createBarChart(
                "BIỂU ĐỒ THỐNG KÊ DOANH THU TRUNG BÌNH CÁC THÁNG",
                "THÁNG", "DOANH THU",
                createDatasetForMonths(endMonth), PlotOrientation.VERTICAL, false, false, false);
        return barChart;
    }

    private static CategoryDataset createDatasetForMonths(int endMonth) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        // Thống kê doanh thu trung bình cho các tháng
        ArrayList<Integer> doanhThuTrungBinhTheoThang = thongketheothangaverage(endMonth);
        for (int i = 0; i < doanhThuTrungBinhTheoThang.size(); i++) {
            dataset.addValue(doanhThuTrungBinhTheoThang.get(i), "Doanh thu trung bình", "Tháng " + (i + 1));
        }
        return dataset;
    }

}

