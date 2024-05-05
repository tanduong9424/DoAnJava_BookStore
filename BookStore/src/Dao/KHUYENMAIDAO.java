package Dao;

import Dto.KHUYENMAI;
import conDatabase.JDBCUtil;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import java.sql.Statement;

public class KHUYENMAIDAO implements DAOInterface<KHUYENMAI>{
    	public static KHUYENMAIDAO getInstance() {
		return new KHUYENMAIDAO();
	}

    @Override
        public int insert(KHUYENMAI t) {
            int ketqua = 0;
            try {
                java.time.LocalDate ngayHienTai = java.time.LocalDate.now();
                java.sql.Date ngayTao = java.sql.Date.valueOf(ngayHienTai);
                
                Connection con = JDBCUtil.getConnection();
                // Kiểm tra xem ngày bắt đầu có lớn hơn ngày kết thúc không
                if (t.getNgaybatdau().after(t.getNgayketthuc())) {
                    System.out.println("Ngày bắt đầu không thể lớn hơn ngày kết thúc. Không thể thêm khuyến mãi.");
                    return ketqua;
                }

                String sql = "INSERT INTO khuyenmai (ngaytao, ngaybatdau, ngayketthuc, tongtiencanthiet, phantramgiam,ISHIDDEN) VALUES (?, ?, ?, ?, ?,?)";
                PreparedStatement pst = con.prepareStatement(sql);
                pst.setDate(1, ngayTao);
                pst.setDate(2, t.getNgaybatdau());
                pst.setDate(3, t.getNgayketthuc());
                pst.setInt(4, t.getTongtiencanthiet());
                pst.setInt(5, t.getPhantramgiam());
                pst.setInt(6, 0);
                // Thực hiện executeUpdate() để thực hiện câu lệnh SQL INSERT
                ketqua = pst.executeUpdate();
                JDBCUtil.closeConnection(con);
            } catch (Exception e) {
                System.out.println("Có lỗi xảy ra, không thể insert phiếu nhập");
                e.printStackTrace();
            }
            return ketqua;
        }


    @Override
    public int update(KHUYENMAI t) {
		int ketqua = 0;
		try {
			Connection con = JDBCUtil.getConnection();
	
			// Kiểm tra xem có giá trị nào trong cột "makhuyenmai" của bảng "hoadon" giống với giá trị bạn đang cố gắng cập nhật không
			String sqlCheck = "SELECT * FROM hoadon WHERE makhuyenmai = ?";
			PreparedStatement pstCheck = con.prepareStatement(sqlCheck);
			pstCheck.setInt(1, t.getMakhuyenmai());
			ResultSet rs = pstCheck.executeQuery();
	
			if (rs.next()) {
				// Nếu có, in ra thông báo và trả về một giá trị ngay tại thời điểm đó mà không tiếp tục thực hiện các lệnh SQL tiếp theo
				System.out.println("Lĩnh vực đã tồn tại trong sản phẩm, không thể thay đổi.");
				return -1; // hoặc trả về một giá trị khác thích hợp
			}
	
			// Nếu không có giá trị nào giống, thực hiện cập nhật
			String sql = "UPDATE khuyenmai " + " SET " + " ngaytao=?,ngaybatdau=?,ngayketthuc=?,tongtiencanthiet=?,phantramgiam=?" + " WHERE makhuyenmai=? ";
	
			PreparedStatement pst = con.prepareStatement(sql);
	
			pst.setDate(1, t.getNgaytao());
            pst.setDate(2, t.getNgaybatdau());
            pst.setDate(3, t.getNgayketthuc());
            pst.setInt(4, t.getTongtiencanthiet());
            pst.setInt(5, t.getPhantramgiam());
			pst.setInt(6, t.getMakhuyenmai());
			
			ketqua = pst.executeUpdate();
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			System.out.print("\nCó lỗi xảy ra, thực hiện câu lệnh không thành công ở update() class LINHVUCDAO\n");
			e.printStackTrace();
		}
		return ketqua;
    }
    public int update_column(KHUYENMAI t,String column,String value) throws ParseException {
		int ketqua = 0;
		try {
			Connection con = JDBCUtil.getConnection();
	
			// Kiểm tra xem có giá trị nào trong cột "makhuyenmai" của bảng "hoadon" giống với giá trị bạn đang cố gắng cập nhật không
			String sqlCheck = "SELECT * FROM hoadon WHERE makhuyenmai = ?";
			PreparedStatement pstCheck = con.prepareStatement(sqlCheck);
			pstCheck.setInt(1, t.getMakhuyenmai());
			ResultSet rs = pstCheck.executeQuery();
	
			if (rs.next()) {
				// Nếu có, in ra thông báo và trả về một giá trị ngay tại thời điểm đó mà không tiếp tục thực hiện các lệnh SQL tiếp theo
				System.out.println("Lĩnh vực đã tồn tại trong sản phẩm, không thể thay đổi.");
				return -1; // hoặc trả về một giá trị khác thích hợp
			}
	
			// Nếu không có giá trị nào giống, thực hiện cập nhật
			String sql = "UPDATE khuyenmai " + " SET " + " ?=?" + " WHERE makhuyenmai=? ";
	
			PreparedStatement pst = con.prepareStatement(sql);
	
			pst.setString(1, column);
            if(column.equals("ngaytao") || column.equals("ngaybatdau") ||column.equals("ngayketthuc")){
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

				java.util.Date ngayUtil = sdf.parse(value); // Phân tích cú pháp chuỗi thành Date
				Date ngaySQL = new Date(ngayUtil.getTime()); // Chuyển đổi thành java.sql.Date
				pst.setDate(2, ngaySQL);
            }
            else if(column.equals("tongtiencanthiet")||column.equals("phantramgiam")){
                int value1=Integer.parseInt(value);
				pst.setInt(2, value1);
            }
			pst.setInt(3, t.getMakhuyenmai());
			
			ketqua = pst.executeUpdate();
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			System.out.print("\nCó lỗi xảy ra, thực hiện câu lệnh không thành công ở update() class LINHVUCDAO\n");
			e.printStackTrace();
		}
		return ketqua;
    }

    @Override
    public int delete(KHUYENMAI t) {
		int ketqua = 0;
		try {
			Connection con = JDBCUtil.getConnection();
	
			// Kiểm tra xem có giá trị nào trong cột "makhuyenmai" của bảng "hoadon" giống với giá trị bạn đang cố gắng cập nhật không
			String sqlCheck = "SELECT * FROM hoadon WHERE makhuyenmai = ?";
			PreparedStatement pstCheck = con.prepareStatement(sqlCheck);
			pstCheck.setInt(1, t.getMakhuyenmai());
			ResultSet rs = pstCheck.executeQuery();
	
			if (rs.next()) {
				// Nếu có, in ra thông báo và trả về một giá trị ngay tại thời điểm đó mà không tiếp tục thực hiện các lệnh SQL tiếp theo
				System.out.println("Lĩnh vực đã tồn tại trong sản phẩm, không thể xóa.");
				String sql = "UPDATE khuyenmai SET ISHIDDEN=true"  + " WHERE makhuyenmai=? ";
	
				PreparedStatement pst = con.prepareStatement(sql);
		
				pst.setInt(1, t.getMakhuyenmai());
		
				ketqua = pst.executeUpdate();
				JDBCUtil.closeConnection(con);
				return -1; // hoặc trả về một giá trị khác thích hợp
			}
	
			// Nếu không có giá trị nào giống, thực hiện cập nhật
			String sql = "DELETE FROM khuyenmai "  + " WHERE makhuyenmai=? ";
	
			PreparedStatement pst = con.prepareStatement(sql);
	
			pst.setInt(1, t.getMakhuyenmai());
	
			ketqua = pst.executeUpdate();
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			System.out.print("\nCó lỗi xảy ra, thực hiện câu lệnh không thành công ở update() class LINHVUCDAO\n");
			e.printStackTrace();
		}
		return ketqua;
    }

    @Override
    public ArrayList<KHUYENMAI> selectAll() {
		ArrayList<KHUYENMAI> ketqua=new ArrayList<KHUYENMAI>();
		try {
			Connection con=JDBCUtil.getConnection();
			
			String sql=" SELECT * FROM khuyenmai ";
			
			PreparedStatement pst=con.prepareStatement(sql);
			
			
			ResultSet rs=pst.executeQuery();
			while(rs.next()) {
				int makhuyenmai=rs.getInt("makhuyenmai");
                Date ngaytao=rs.getDate("ngaytao");
                Date ngaybatdau=rs.getDate("ngaybatdau");
                Date ngayketthuc=rs.getDate("ngayketthuc");
                int tongtiencanthiet=rs.getInt("tongtiencanthiet");
                int phantramgiam=rs.getInt("phantramgiam");
                boolean ISHIDDEN=rs.getBoolean("ISHIDDEN");
                KHUYENMAI km=new KHUYENMAI(makhuyenmai,ngaytao,ngaybatdau,ngayketthuc,tongtiencanthiet,phantramgiam,ISHIDDEN);
				ketqua.add(km);
			}
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.print("co loi xay ra, thuc hien cau lenh khong thanh cong o selectAll class LINHVUCDAO \n");
			e.printStackTrace();
		}
		return ketqua;
    }
    public ArrayList<KHUYENMAI> selectActivePromotionsToday() {
        ArrayList<KHUYENMAI> ketqua = new ArrayList<KHUYENMAI>();
        try {
            Connection con = JDBCUtil.getConnection();
            Date homNay = new Date(System.currentTimeMillis()); // Lấy ngày hôm nay

            String sql = "SELECT * FROM khuyenmai WHERE ngaybatdau <= ? AND ngayketthuc >= ? AND ISHIDDEN = false";
            
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setDate(1, homNay);
            pst.setDate(2, homNay);
            
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                int makhuyenmai = rs.getInt("makhuyenmai");
                Date ngaytao = rs.getDate("ngaytao");
                Date ngaybatdau = rs.getDate("ngaybatdau");
                Date ngayketthuc = rs.getDate("ngayketthuc");
                int tongtiencanthiet = rs.getInt("tongtiencanthiet");
                int phantramgiam = rs.getInt("phantramgiam");
                boolean ISHIDDEN = rs.getBoolean("ISHIDDEN");
                KHUYENMAI km = new KHUYENMAI(makhuyenmai, ngaytao, ngaybatdau, ngayketthuc, tongtiencanthiet, phantramgiam, ISHIDDEN);
                ketqua.add(km);
            }
            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            System.out.print("Có lỗi xảy ra, thực hiện câu lệnh không thành công ở selectActivePromotionsToday\n");
            e.printStackTrace();
        }
        return ketqua;
    }
    public ArrayList<KHUYENMAI> selectAllEXCEPTISHIDDEN() {
		ArrayList<KHUYENMAI> ketqua=new ArrayList<KHUYENMAI>();
		try {
			Connection con=JDBCUtil.getConnection();
			
			String sql=" SELECT * FROM khuyenmai WHERE ISHIDDEN=false";
			
			PreparedStatement pst=con.prepareStatement(sql);
			
			
			ResultSet rs=pst.executeQuery();
			while(rs.next()) {
				int makhuyenmai=rs.getInt("makhuyenmai");
                Date ngaytao=rs.getDate("ngaytao");
                Date ngaybatdau=rs.getDate("ngaybatdau");
                Date ngayketthuc=rs.getDate("ngayketthuc");
                int tongtiencanthiet=rs.getInt("tongtiencanthiet");
                int phantramgiam=rs.getInt("phantramgiam");
                boolean ISHIDDEN=rs.getBoolean("ISHIDDEN");
                KHUYENMAI km=new KHUYENMAI(makhuyenmai,ngaytao,ngaybatdau,ngayketthuc,tongtiencanthiet,phantramgiam,ISHIDDEN);
				ketqua.add(km);
			}
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.print("co loi xay ra, thuc hien cau lenh khong thanh cong o selectAll class LINHVUCDAO \n");
			e.printStackTrace();
		}
		return ketqua;
    }

    @Override
    public KHUYENMAI selectById(KHUYENMAI t) {
		KHUYENMAI ketqua=null;
		try {
			Connection con=JDBCUtil.getConnection();
			
			String sql=" SELECT * FROM khuyenmai WHERE makhuyenmai=?";
			
			PreparedStatement pst=con.prepareStatement(sql);
			pst.setInt(1, t.getMakhuyenmai());
			
			ResultSet rs=pst.executeQuery();
			while(rs.next()) {
				int makhuyenmai=rs.getInt("makhuyenmai");
                Date ngaytao=rs.getDate("ngaytao");
                Date ngaybatdau=rs.getDate("ngaybatdau");
                Date ngayketthuc=rs.getDate("ngayketthuc");
                int tongtiencanthiet=rs.getInt("tongtiencanthiet");
                int phantramgiam=rs.getInt("phantramgiam");
                boolean ISHIDDEN=rs.getBoolean("ISHIDDEN");
                KHUYENMAI km=new KHUYENMAI(makhuyenmai,ngaytao,ngaybatdau,ngayketthuc,tongtiencanthiet,phantramgiam,ISHIDDEN);
				ketqua=km;
			}
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.print("co loi xay ra, thuc hien cau lenh khong thanh cong o selectAll class LINHVUCDAO \n");
			e.printStackTrace();
		}
		return ketqua;
    }
 public KHUYENMAI selectByIdFromTo(KHUYENMAI t, String start, String end) {
    KHUYENMAI ketqua = null;
    try {
        Connection con = JDBCUtil.getConnection();
        String sql = "SELECT * FROM khuyenmai WHERE makhuyenmai = ? AND ngaytao BETWEEN ? AND ?";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setInt(1, t.getMakhuyenmai());
        pst.setString(2, start);
        pst.setString(3, end);
        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            int makhuyenmai = rs.getInt("makhuyenmai");
            Date ngaytao = rs.getDate("ngaytao");
            Date ngaybatdau = rs.getDate("ngaybatdau");
            Date ngayketthuc = rs.getDate("ngayketthuc");
            int tongtiencanthiet = rs.getInt("tongtiencanthiet");
            int phantramgiam = rs.getInt("phantramgiam");
            boolean ISHIDDEN = rs.getBoolean("ISHIDDEN");
            KHUYENMAI km = new KHUYENMAI(makhuyenmai, ngaytao, ngaybatdau, ngayketthuc, tongtiencanthiet, phantramgiam, ISHIDDEN);
            ketqua = km;
        }
        JDBCUtil.closeConnection(con);
    } catch (SQLException e) {
        System.out.print("Có lỗi xảy ra, thực hiện câu lệnh không thành công trong selectAll class LINHVUCDAO \n");
        e.printStackTrace();
    }
    return ketqua;
}


    @Override
    public ArrayList<KHUYENMAI> selectByCondition(String condition) {
		ArrayList<KHUYENMAI> ketqua=new ArrayList<KHUYENMAI>();
		try {
			Connection con=JDBCUtil.getConnection();
			
			String sql=" SELECT * FROM khuyenmai "+
					"WHERE "+condition;
			
			Statement pst=con.createStatement();
			
			
			ResultSet rs=pst.executeQuery(sql);
			while(rs.next()) {
		int makhuyenmai=rs.getInt("makhuyenmai");
                Date ngaytao=rs.getDate("ngaytao");
                Date ngaybatdau=rs.getDate("ngaybatdau");
                Date ngayketthuc=rs.getDate("ngayketthuc");
                int tongtiencanthiet=rs.getInt("tongtiencanthiet");
                int phantramgiam=rs.getInt("phantramgiam");
                boolean ISHIDDEN=rs.getBoolean("ISHIDDEN");
                KHUYENMAI km=new KHUYENMAI(makhuyenmai,ngaytao,ngaybatdau,ngayketthuc,tongtiencanthiet,phantramgiam,ISHIDDEN);
				ketqua.add(km);
			}
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.print("co loi xay ra, thuc hien cau lenh khong thanh cong o selectByCondition class LINHVUCDAO \n");
			e.printStackTrace();
		}
		return ketqua;
    }

    
}
