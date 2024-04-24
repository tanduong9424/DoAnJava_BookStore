package Dao;

import Dto.HOADON;
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
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

public class THONGKE {
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
                int weekOfMonth = cal.get(Calendar.WEEK_OF_MONTH);

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

    public static ArrayList<Double> thongketheotuantrungbinh(int month) {
        ArrayList<Double> ketqua = new ArrayList<>();
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

            // Khởi tạo mảng chứa tổng tiền và số lượng hóa đơn của 4 tuần
            double[] tongTienTuan = new double[4];
            int[] soLuongHoaDonTuan = new int[4];

            int currentWeek = -1; // Tuần hiện tại
            double tongTienTuanHienTai = 0; // Tổng tiền của tuần hiện tại
            int soLuongHoaDonTuanHienTai = 0; // Số lượng hóa đơn của tuần hiện tại

            while (rs.next()) {
                // Lấy ngày lập hóa đơn
                Date ngayLap = rs.getDate("NGAYLAP");
                Calendar cal = Calendar.getInstance();
                cal.setTime(ngayLap);
                int weekOfMonth = cal.get(Calendar.WEEK_OF_MONTH);

                // Nếu đã qua tuần mới
                if (weekOfMonth != currentWeek) {
                    // Tính trung bình của tuần trước (nếu có)
                    if (currentWeek != -1) {
                        double trungBinhTuan = tongTienTuanHienTai / soLuongHoaDonTuanHienTai;
                        ketqua.add(trungBinhTuan);
                    }

                    // Cập nhật tuần mới
                    currentWeek = weekOfMonth;
                    tongTienTuanHienTai = 0;
                    soLuongHoaDonTuanHienTai = 0;
                }

                // Cộng tổng tiền và số lượng hóa đơn cho tuần hiện tại
                double tongTien = rs.getDouble("TONGTIEN");
                tongTienTuanHienTai += tongTien;
                soLuongHoaDonTuanHienTai++;
            }

            // Tính trung bình của tuần cuối cùng (nếu có)
            if (currentWeek != -1) {
                double trungBinhTuan = tongTienTuanHienTai / soLuongHoaDonTuanHienTai;
                ketqua.add(trungBinhTuan);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.closeConnection(con);;
        }
        return ketqua;
    }
    public static  ArrayList<Integer> thongketheotuancount(int month){
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

            // Khởi tạo mảng chứa số lượng hóa đơn của 4 tuần
            int[] soLuongHoaDonTuan = new int[4];
            int currentWeek = -1; // Tuần hiện tại

            while (rs.next()) {
                // Lấy ngày lập hóa đơn
                Date ngayLap = rs.getDate("NGAYLAP");
                Calendar cal = Calendar.getInstance();
                cal.setTime(ngayLap);
                int weekOfMonth = cal.get(Calendar.WEEK_OF_MONTH);

                // Nếu đã qua tuần mới
                if (weekOfMonth != currentWeek) {
                    // Thêm số lượng hóa đơn của tuần trước (nếu có)
                    if (currentWeek != -1) {
                        ketqua.add(soLuongHoaDonTuan[currentWeek - 1]);
                    }

                    // Cập nhật tuần mới
                    currentWeek = weekOfMonth;
                    soLuongHoaDonTuan[currentWeek - 1] = 0; // Reset số lượng hóa đơn của tuần mới
                }

                // Tăng số lượng hóa đơn của tuần hiện tại
                soLuongHoaDonTuan[currentWeek - 1]++;
            }

            // Thêm số lượng hóa đơn của tuần cuối cùng (nếu có)
            if (currentWeek != -1) {
                ketqua.add(soLuongHoaDonTuan[currentWeek - 1]);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.closeConnection(con);;
        }
        return ketqua;
    }
    public static  ArrayList<Double> thongketheotuanmax(int month){
        ArrayList<Double> ketqua = new ArrayList<>();
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

            // Khởi tạo mảng chứa giá trị TONGTIEN cao nhất của 4 tuần
            double[] maxTongTienTuan = new double[4];
            int currentWeek = -1; // Tuần hiện tại

            while (rs.next()) {
                // Lấy ngày lập hóa đơn
                Date ngayLap = rs.getDate("NGAYLAP");
                Calendar cal = Calendar.getInstance();
                cal.setTime(ngayLap);
                int weekOfMonth = cal.get(Calendar.WEEK_OF_MONTH);

                // Nếu đã qua tuần mới
                if (weekOfMonth != currentWeek) {
                    // Thêm giá trị TONGTIEN cao nhất của tuần trước (nếu có)
                    if (currentWeek != -1) {
                        ketqua.add(maxTongTienTuan[currentWeek - 1]);
                    }

                    // Cập nhật tuần mới
                    currentWeek = weekOfMonth;
                    maxTongTienTuan[currentWeek - 1] = Double.MIN_VALUE; // Reset giá trị TONGTIEN cao nhất của tuần mới
                }

                // So sánh và cập nhật giá trị TONGTIEN cao nhất của tuần
                double tongTien = rs.getDouble("TONGTIEN");
                if (tongTien > maxTongTienTuan[currentWeek - 1]) {
                    maxTongTienTuan[currentWeek - 1] = tongTien;
                }
            }

            // Thêm giá trị TONGTIEN cao nhất của tuần cuối cùng (nếu có)
            if (currentWeek != -1) {
                ketqua.add(maxTongTienTuan[currentWeek - 1]);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.closeConnection(con);;
        }
        return ketqua;

    }
    public static  ArrayList<Double> thongketheotuanmin(int month){
        ArrayList<Double> ketqua = new ArrayList<>();
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

            // Khởi tạo mảng chứa giá trị TONGTIEN cao nhất của 4 tuần
            double[] minTongTienTuan = new double[4];
            int currentWeek = -1; // Tuần hiện tại

            while (rs.next()) {
                // Lấy ngày lập hóa đơn
                Date ngayLap = rs.getDate("NGAYLAP");
                Calendar cal = Calendar.getInstance();
                cal.setTime(ngayLap);
                int weekOfMonth = cal.get(Calendar.WEEK_OF_MONTH);

                // Nếu đã qua tuần mới
                if (weekOfMonth != currentWeek) {
                    // Thêm giá trị TONGTIEN thấp nhất của tuần trước (nếu có)
                    if (currentWeek != -1) {
                        ketqua.add(minTongTienTuan[currentWeek - 1]);
                    }

                    // Cập nhật tuần mới
                    currentWeek = weekOfMonth;
                    minTongTienTuan[currentWeek - 1] = Double.MAX_VALUE; // Reset giá trị TONGTIEN thấp nhất của tuần mới
                }

                // So sánh và cập nhật giá trị TONGTIEN cao nhất của tuần
                double tongTien = rs.getDouble("TONGTIEN");
                if (tongTien < minTongTienTuan[currentWeek - 1]) {
                    minTongTienTuan[currentWeek - 1] = tongTien;
                }
            }

            // Thêm giá trị TONGTIEN cao nhất của tuần cuối cùng (nếu có)
            if (currentWeek != -1) {
                ketqua.add(minTongTienTuan[currentWeek - 1]);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.closeConnection(con);;
        }
        return ketqua;
    }
    public static  ArrayList<Integer> thongketheothangsum(){
        ArrayList<HOADON> danhSachHoaDon=HOADONDAO.getInstance().selectAll();
        ArrayList<Integer> ketqua = new ArrayList<>();

        // Tạo một bảng băm để lưu trữ tổng tiền của mỗi tháng
        Map<Integer, Integer> tongTienTheoThang = new HashMap<>();

        // Tính tổng tiền của mỗi hóa đơn và lưu vào bảng băm
        for (HOADON hoaDon : danhSachHoaDon) {
            int thang = hoaDon.getNGAYLAP().getMonth(); // Lấy tháng từ ngày lập hóa đơn
            int tongTien = hoaDon.getTONGTIEN();
            
            // Nếu đã có tổng tiền của tháng này thì cộng thêm vào, nếu chưa có thì tạo mới
            tongTienTheoThang.put(thang, tongTienTheoThang.getOrDefault(thang, 0) + tongTien);
        }

        // Lấy tổng tiền của mỗi tháng từ bảng băm và thêm vào danh sách kết quả
        for (int thang = 1; thang <= 12; thang++) { // Giả sử dữ liệu trong năm chỉ từ tháng 1 đến tháng 12
            int tongTienThang = tongTienTheoThang.getOrDefault(thang, 0);
            ketqua.add(tongTienThang);
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
            int thang = hoaDon.getNGAYLAP().getMonth(); // Lấy tháng từ ngày lập hóa đơn
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


    // vẽ
    public static JFreeChart createChart() {
        JFreeChart barChart = ChartFactory.createBarChart(
                "BIỂU ĐỒ THỐNG KÊ DOANH THU THEO TUẦN",
                "TUẦN", "DOANH THU",
                createDataset(), PlotOrientation.VERTICAL, false, false, false);
        return barChart;
    }

    private static CategoryDataset createDataset() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        // Thay đổi month thành tháng mà bạn muốn thống kê
        int month = 4; // ví dụ tháng 4
        ArrayList<Integer> doanhThuTheoTuan = thongketheotuansum(month);

        // Thêm dữ liệu vào dataset
        for (int i = 0; i < doanhThuTheoTuan.size(); i++) {
            dataset.addValue(doanhThuTheoTuan.get(i), "Doanh thu", "Tuần " + (i + 1));
        }
        return dataset;
    }
    public static void drawcharttheotuan(){
        ChartPanel chartPanel = new ChartPanel(createChart());
        chartPanel.setPreferredSize(new java.awt.Dimension(560, 367));
        JFrame frame = new JFrame();
        frame.add(chartPanel);
        frame.setTitle("BIỂU ĐỒ DOANH THU");
        frame.setSize(600, 400);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
    }
    
}

/*
public static void main(String[] args) {
        ChartPanel chartPanel = new ChartPanel(createChart());
        chartPanel.setPreferredSize(new java.awt.Dimension(560, 367));
        JFrame frame = new JFrame();
        frame.add(chartPanel);
        frame.setTitle("Biểu đồ JFreeChart trong Java Swing");
        frame.setSize(600, 400);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
    }
*/

