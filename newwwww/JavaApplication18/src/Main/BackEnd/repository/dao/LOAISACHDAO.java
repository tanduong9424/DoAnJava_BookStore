package Main.BackEnd.repository.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import Main.BackEnd.repository.database.JDBCUtil;
import Main.BackEnd.repository.modal.LOAISACH;

public class LOAISACHDAO implements DAOInterface<LOAISACH>{
	public static LOAISACHDAO getInstance() {
		return new LOAISACHDAO();
	}
	
	@Override
	public int insert(LOAISACH t) {
		int ketqua=0;
		try {
			Connection con=JDBCUtil.getConnection();
			if(checkLOAISACH(t)==true) {
				String sql="UPDATE  loaisach  "+
						" SET "+
						" ISHIDDEN=false"+
						" WHERE TENLOAISACH=?";
				
				PreparedStatement pst=con.prepareStatement(sql);
				
				pst.setString(1,t.getTENLOAISACH());
				
				
				ketqua=pst.executeUpdate();
				System.out.print("thuc hien cau lenh "+sql+"\n");	
			}
			else {				
				String sql="INSERT INTO loaisach (TENLOAISACH,ISHIDDEN) "+
						" VALUES (?,?)";
				
				PreparedStatement pst=con.prepareStatement(sql);
				
				pst.setString(1,t.getTENLOAISACH());
				pst.setBoolean(2,false);
				
				ketqua=pst.executeUpdate();
				System.out.print("thuc hien cau lenh"+sql+"\n");
				JDBCUtil.closeConnection(con);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.print("co loi xay ra, thuc hien cau lenh khong thanh cong o insert() class LOAISACH \n");
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int update(LOAISACH t) {
		int ketqua = 0;
		try {
			Connection con = JDBCUtil.getConnection();
	
			// Kiểm tra xem có giá trị nào trong cột "TENLOAISACH" của bảng "sach" giống với giá trị bạn đang cố gắng cập nhật không
			String sqlCheck = "SELECT * FROM sach WHERE TENLOAISACH = ?";
			PreparedStatement pstCheck = con.prepareStatement(sqlCheck);
			pstCheck.setString(1, t.getTENLOAISACH());
			ResultSet rs = pstCheck.executeQuery();
	
			if (rs.next()) {
				// Nếu có, in ra thông báo và trả về một giá trị ngay tại thời điểm đó mà không tiếp tục thực hiện các lệnh SQL tiếp theo
				System.out.println("Lĩnh vực đã tồn tại trong sản phẩm, không thể thay đổi.");
				return -1; // hoặc trả về một giá trị khác thích hợp
			}
	
			// Nếu không có giá trị nào giống, thực hiện cập nhật
			String sql = "UPDATE loaisach " + " SET " + " TENLOAISACH=?" + " WHERE TENLOAISACH=?";
	
			PreparedStatement pst = con.prepareStatement(sql);
	
			pst.setString(1, t.getTENLOAISACH());
			pst.setString(2, t.getTENLOAISACH());
	
			ketqua = pst.executeUpdate();
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			System.out.print("\nCó lỗi xảy ra, thực hiện câu lệnh không thành công ở update() class LINHVUCDAO\n");
			e.printStackTrace();
		}
		return ketqua;
	}

	@Override
	public int delete(LOAISACH t) {
		int ketqua = 0;
		try {
			Connection con = JDBCUtil.getConnection();
	
			// Kiểm tra xem có giá trị nào trong cột "TENLOAISACH" của bảng "sach" giống với giá trị bạn đang cố gắng cập nhật không
			String sqlCheck = "SELECT * FROM sach WHERE TENLOAISACH = ?";
			PreparedStatement pstCheck = con.prepareStatement(sqlCheck);
			pstCheck.setString(1, t.getTENLOAISACH());
			ResultSet rs = pstCheck.executeQuery();
	
			if (rs.next()) {
				// Nếu có, in ra thông báo và trả về một giá trị ngay tại thời điểm đó mà không tiếp tục thực hiện các lệnh SQL tiếp theo
				System.out.println("Lĩnh vực đã tồn tại trong sản phẩm, không thể xóa.");
				return -1; // hoặc trả về một giá trị khác thích hợp
			}
	
			// Nếu không có giá trị nào giống, thực hiện cập nhật
			String sql = "DELETE linhvuc "  + " WHERE TENLOAISACH=? ";
	
			PreparedStatement pst = con.prepareStatement(sql);
	
			pst.setString(1, t.getTENLOAISACH());
	
			ketqua = pst.executeUpdate();
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			System.out.print("\nCó lỗi xảy ra, thực hiện câu lệnh không thành công ở update() class LINHVUCDAO\n");
			e.printStackTrace();
		}
		return ketqua;
}

	@Override
	public ArrayList<LOAISACH> selectAll() {
		ArrayList<LOAISACH> ketqua=new ArrayList<LOAISACH>();
		try {
			Connection con=JDBCUtil.getConnection();
			
			String sql=" SELECT * FROM loaisach ";
			
			PreparedStatement pst=con.prepareStatement(sql);
			
			
			ResultSet rs=pst.executeQuery();
			while(rs.next()) {
				String TEN=rs.getString("TENLOAISACH");
				boolean ISHIDDEN=rs.getBoolean("ISHIDDEN");
				LOAISACH LOAISACH=new LOAISACH(TEN,ISHIDDEN);
				ketqua.add(LOAISACH);
			}
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.print("co loi xay ra, thuc hien cau lenh khong thanh cong o selectAll class LOAISACH \n");
			e.printStackTrace();
		}
		return ketqua;
	}
//	dùng khi cần cho chọn lĩnh vực liên quan đến các table khác trong database
	public ArrayList<LOAISACH> selectAllExceptISHIDDEN() {
		ArrayList<LOAISACH> ketqua=new ArrayList<LOAISACH>();
		try {
			Connection con=JDBCUtil.getConnection();
			
			String sql=" SELECT * FROM loaisach "+
					"WHERE ISHIDDEN=false";
			
			PreparedStatement pst=con.prepareStatement(sql);
			
			
			ResultSet rs=pst.executeQuery();
			while(rs.next()) {
				String TEN=rs.getString("TENLOAISACH");
				boolean ISHIDDEN=rs.getBoolean("ISHIDDEN");
				LOAISACH LOAISACH=new LOAISACH(TEN,ISHIDDEN);
				ketqua.add(LOAISACH);
			}
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.print("co loi xay ra, thuc hien cau lenh khong thanh cong o selectAllExceptISHIDDEN class LOAISACH \n");
			e.printStackTrace();
		}
		return ketqua;
	}

	@Override
	public LOAISACH selectById(LOAISACH t) {
		LOAISACH ketqua=null;
		try {
			Connection con=JDBCUtil.getConnection();
			
			String sql=" SELECT * FROM loaisach "+
					"WHERE ISHIDDEN=false AND TENLOAISACH=?";
			
			PreparedStatement pst=con.prepareStatement(sql);
			pst.setString(1,t.getTENLOAISACH());
			System.out.print("Đã thực thi câu lệnh"+sql);
			ResultSet rs=pst.executeQuery();
			while(rs.next()) {
				String TEN=rs.getString("TENLOAISACH");
				boolean ISHIDDEN=rs.getBoolean("ISHIDDEN");
				LOAISACH LOAISACH=new LOAISACH(TEN,ISHIDDEN);
				ketqua=LOAISACH;
			}
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.print("co loi xay ra, thuc hien cau lenh khong thanh cong o selectById class LOAISACH \n");
			e.printStackTrace();
		}
		return ketqua;
	}

	@Override
	public ArrayList<LOAISACH> selectByCondition(String condition) {
		ArrayList<LOAISACH> ketqua=new ArrayList<LOAISACH>();
		try {
			Connection con=JDBCUtil.getConnection();
			
			String sql=" SELECT * FROM loaisach "+
					"WHERE "+condition;
			
			Statement pst=con.createStatement();
			
			
			ResultSet rs=pst.executeQuery(sql);
			while(rs.next()) {
				String TEN=rs.getString("TENLOAISACH");
				boolean ISHIDDEN=rs.getBoolean("ISHIDDEN");
				LOAISACH LOAISACH=new LOAISACH(TEN,ISHIDDEN);
				ketqua.add(LOAISACH);
			}
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.print("co loi xay ra, thuc hien cau lenh khong thanh cong o selectByCondition class LOAISACH \n");
			e.printStackTrace();
		}
		return ketqua;
	}
	public ArrayList<LOAISACH> selectByConditionExceptISHIDDEN(String condition) {
		ArrayList<LOAISACH> ketqua=new ArrayList<LOAISACH>();
		try {
			Connection con=JDBCUtil.getConnection();
			
			String sql=" SELECT * FROM loaisach "+
					"WHERE "+condition;
			
			Statement pst=con.createStatement();
			
			
			ResultSet rs=pst.executeQuery(sql);
			while(rs.next()) {
				String TEN=rs.getString("TENLOAISACH");
				boolean ISHIDDEN=rs.getBoolean("ISHIDDEN");
				LOAISACH LOAISACH=new LOAISACH(TEN,ISHIDDEN);
				ketqua.add(LOAISACH);
			}
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.print("co loi xay ra, thuc hien cau lenh khong thanh cong o selectByCondition class LOAISACH \n");
			e.printStackTrace();
		}
		return ketqua;
	}
	public static boolean checkLOAISACH(LOAISACH t) {
		ArrayList<LOAISACH> list=LOAISACHDAO.getInstance().selectAll();
		for(LOAISACH LOAISACH:list) {
			if(LOAISACH.getTENLOAISACH().toString().equals(t.getTENLOAISACH().toString())) {
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
