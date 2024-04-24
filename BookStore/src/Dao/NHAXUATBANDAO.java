package Dao;

import Dto.NHAXUATBAN;
import conDatabase.JDBCUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;



public class NHAXUATBANDAO implements DAOInterface<NHAXUATBAN> {
	public static NHAXUATBANDAO getInstance() {
		return new NHAXUATBANDAO();
	}
	
	@Override
	public int insert(NHAXUATBAN t) {
		int ketqua=0;
		try {
			Connection con=JDBCUtil.getConnection();
			if(checkNHAXUATBAN(t)==true) {
				String sql="UPDATE  nhaxuatban  "+
						" SET "+
						" ISHIDDEN=false"+
						" WHERE TENNHAXUATBAN=? AND ISHIDDEN=true";
				
				PreparedStatement pst=con.prepareStatement(sql);
				
				pst.setString(1,t.getTENNHAXUATBAN());
				
				
				ketqua=pst.executeUpdate();
				System.out.print("thuc hien cau lenh "+sql+"\n");	
			}
			else {				
				String sql="INSERT INTO nhaxuatban (TENNHAXUATBAN,ISHIDDEN) "+
						" VALUES (?,?)";
				
				PreparedStatement pst=con.prepareStatement(sql);
				
				pst.setString(1,t.getTENNHAXUATBAN());
				pst.setBoolean(2,false);
				
				ketqua=pst.executeUpdate();
				System.out.print("thuc hien cau lenh"+sql+"\n");
				JDBCUtil.closeConnection(con);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.print("co loi xay ra, thuc hien cau lenh khong thanh cong o insert() class NHAXUATBAN \n");
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int update(NHAXUATBAN t) {
		int ketqua = 0;
		try {
			Connection con = JDBCUtil.getConnection();
	
			// Kiểm tra xem có giá trị nào trong cột "TENNHAXUATBAN" của bảng "sach" giống với giá trị bạn đang cố gắng cập nhật không
			String sqlCheck = "SELECT * FROM sach WHERE TENNHAXUATBAN = ?";
			PreparedStatement pstCheck = con.prepareStatement(sqlCheck);
			pstCheck.setString(1, t.getTENNHAXUATBAN());
			ResultSet rs = pstCheck.executeQuery();
	
			if (rs.next()) {
				// Nếu có, in ra thông báo và trả về một giá trị ngay tại thời điểm đó mà không tiếp tục thực hiện các lệnh SQL tiếp theo
				System.out.println("Lĩnh vực đã tồn tại trong sản phẩm, không thể thay đổi.");
				return -1; // hoặc trả về một giá trị khác thích hợp
			}
	
			// Nếu không có giá trị nào giống, thực hiện cập nhật
			String sql = "UPDATE nhaxuatban " + " SET " + " TENNHAXUATBAN=?" + " WHERE TENNHAXUATBAN=?";
	
			PreparedStatement pst = con.prepareStatement(sql);
	
			pst.setString(1, t.getTENNHAXUATBAN());
			pst.setString(2, t.getTENNHAXUATBAN());
	
			ketqua = pst.executeUpdate();
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			System.out.print("\nCó lỗi xảy ra, thực hiện câu lệnh không thành công ở update() class LINHVUCDAO\n");
			e.printStackTrace();
		}
		return ketqua;
	}

	@Override
	public int delete(NHAXUATBAN t) {
		int ketqua = 0;
		try {
			Connection con = JDBCUtil.getConnection();
	
			// Kiểm tra xem có giá trị nào trong cột "TENNHAXUATBAN" của bảng "sach" giống với giá trị bạn đang cố gắng cập nhật không
			String sqlCheck = "SELECT * FROM sach WHERE TENNHAXUATBAN = ?";
			PreparedStatement pstCheck = con.prepareStatement(sqlCheck);
			pstCheck.setString(1, t.getTENNHAXUATBAN());
			ResultSet rs = pstCheck.executeQuery();
	
			if (rs.next()) {
				// Nếu có, in ra thông báo và trả về một giá trị ngay tại thời điểm đó mà không tiếp tục thực hiện các lệnh SQL tiếp theo
				System.out.println("Lĩnh vực đã tồn tại trong sản phẩm, không thể xóa.");
				return -1; // hoặc trả về một giá trị khác thích hợp
			}
	
			// Nếu không có giá trị nào giống, thực hiện cập nhật
			String sql = "DELETE nhaxuatban "  + " WHERE TENNHAXUATBAN=? ";
	
			PreparedStatement pst = con.prepareStatement(sql);
	
			pst.setString(1, t.getTENNHAXUATBAN());
	
			ketqua = pst.executeUpdate();
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			System.out.print("\nCó lỗi xảy ra, thực hiện câu lệnh không thành công ở update() class LINHVUCDAO\n");
			e.printStackTrace();
		}
		return ketqua;
}

	@Override
	public ArrayList<NHAXUATBAN> selectAll() {
		ArrayList<NHAXUATBAN> ketqua=new ArrayList<NHAXUATBAN>();
		try {
			Connection con=JDBCUtil.getConnection();
			
			String sql=" SELECT * FROM nhaxuatban ";
			
			PreparedStatement pst=con.prepareStatement(sql);
			
			
			ResultSet rs=pst.executeQuery();
			while(rs.next()) {
				String TEN=rs.getString("TENNHAXUATBAN");
				boolean ISHIDDEN=rs.getBoolean("ISHIDDEN");
				NHAXUATBAN NHAXUATBAN=new NHAXUATBAN(TEN,ISHIDDEN);
				ketqua.add(NHAXUATBAN);
			}
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.print("co loi xay ra, thuc hien cau lenh khong thanh cong o selectAll class NHAXUATBAN \n");
			e.printStackTrace();
		}
		return ketqua;
	}
//	dùng khi cần cho chọn lĩnh vực liên quan đến các table khác trong database
	public ArrayList<NHAXUATBAN> selectAllExceptISHIDDEN() {
		ArrayList<NHAXUATBAN> ketqua=new ArrayList<NHAXUATBAN>();
		try {
			Connection con=JDBCUtil.getConnection();
			
			String sql=" SELECT * FROM nhaxuatban "+
					"WHERE ISHIDDEN=false";
			
			PreparedStatement pst=con.prepareStatement(sql);
			
			
			ResultSet rs=pst.executeQuery();
			while(rs.next()) {
				String TEN=rs.getString("TENNHAXUATBAN");
				boolean ISHIDDEN=rs.getBoolean("ISHIDDEN");
				NHAXUATBAN NHAXUATBAN=new NHAXUATBAN(TEN,ISHIDDEN);
				ketqua.add(NHAXUATBAN);
			}
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.print("co loi xay ra, thuc hien cau lenh khong thanh cong o selectAllExceptISHIDDEN class NHAXUATBAN \n");
			e.printStackTrace();
		}
		return ketqua;
	}

	@Override
	public NHAXUATBAN selectById(NHAXUATBAN t) {
		NHAXUATBAN ketqua=null;
		try {
			Connection con=JDBCUtil.getConnection();
			
			String sql=" SELECT * FROM nhaxuatban "+
					"WHERE TENNHAXUATBAN=?";
			
			PreparedStatement pst=con.prepareStatement(sql);
			pst.setString(1,t.getTENNHAXUATBAN());
			System.out.print("Đã thực thi câu lệnh"+sql);
			ResultSet rs=pst.executeQuery();
			while(rs.next()) {
				String TEN=rs.getString("TENNHAXUATBAN");
				boolean ISHIDDEN=rs.getBoolean("ISHIDDEN");
				NHAXUATBAN NHAXUATBAN=new NHAXUATBAN(TEN,ISHIDDEN);
				ketqua=NHAXUATBAN;
			}
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.print("co loi xay ra, thuc hien cau lenh khong thanh cong o selectById class NHAXUATBAN \n");
			e.printStackTrace();
		}
		return ketqua;
	}

	@Override
	public ArrayList<NHAXUATBAN> selectByCondition(String condition) {
		ArrayList<NHAXUATBAN> ketqua=new ArrayList<NHAXUATBAN>();
		try {
			Connection con=JDBCUtil.getConnection();
			
			String sql=" SELECT * FROM nhaxuatban "+
					"WHERE "+condition;
			
			Statement pst=con.createStatement();
			
			
			ResultSet rs=pst.executeQuery(sql);
			while(rs.next()) {
				String TEN=rs.getString("TENNHAXUATBAN");
				boolean ISHIDDEN=rs.getBoolean("ISHIDDEN");
				NHAXUATBAN NHAXUATBAN=new NHAXUATBAN(TEN,ISHIDDEN);
				ketqua.add(NHAXUATBAN);
			}
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.print("co loi xay ra, thuc hien cau lenh khong thanh cong o selectByCondition class NHAXUATBAN \n");
			e.printStackTrace();
		}
		return ketqua;
	}

	public static boolean checkNHAXUATBAN(NHAXUATBAN t) {
		ArrayList<NHAXUATBAN> list=NHAXUATBANDAO.getInstance().selectAll();
		for(NHAXUATBAN NHAXUATBAN:list) {
			if(NHAXUATBAN.getTENNHAXUATBAN().toString().equals(t.getTENNHAXUATBAN().toString())) {
				return true;
			}
		}
		return false;
	}
	public static boolean isnumber(String s) {
		String pattern="^\\d+";
		if(s.matches(pattern)) {
			return true;
		}
		return false;
	}
}
