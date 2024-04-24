package Dao;

import Dto.CHITIETHOADON;
import Dto.HOADON;
import conDatabase.JDBCUtil;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class CHITIETHOADONDAO implements DAOInterface<CHITIETHOADON>{
	public static CHITIETHOADONDAO getInstance() {
		return new CHITIETHOADONDAO();
	}
//da co mahoadon tu hoadon khi tao ra hoadon
	@Override
	public int insert(CHITIETHOADON t) {
		int ketqua=0;
		try {
			Connection con=JDBCUtil.getConnection();
			String sql="INSERT INTO chitiethoadon (MAHOADON,MASACH,SOLUONG,GIATIEN,THANHTIEN) "+
					" VALUES (?,?,?,?,?)";
			
			PreparedStatement pst=con.prepareStatement(sql);
			pst.setInt(1, t.getMAHOADON());
			pst.setInt(2, t.getMASACH());
			pst.setInt(3, t.getSOLUONG());
			pst.setInt(4, t.getGIATIEN());
			pst.setInt(5, t.getTHANHTIEN());
			ketqua=pst.executeUpdate();
			System.out.print("thuc hien cau lenh"+sql+"\n");
			System.out.print("them CHITIETHOADON thanh cong");
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.print("co loi xay ra, thuc hien cau lenh khong thanh cong o insert() class CHITIETHOADONDAO \n");
			e.printStackTrace();
		}
		return ketqua;
	}

	@Override
	public int update(CHITIETHOADON t) {
		return 0;
	}

	@Override
	public int delete(CHITIETHOADON t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<CHITIETHOADON> selectAll() {
		ArrayList<CHITIETHOADON> ketqua=new ArrayList<CHITIETHOADON>();
		try {
			Connection con=JDBCUtil.getConnection();
			String sql="SELECT * FROM chitiethoadon";
			
			PreparedStatement pst=con.prepareStatement(sql);
			ResultSet rs=pst.executeQuery();
			while(rs.next()) {
				int MAHOADON=rs.getInt("MAHOADON");
				int MASACH=rs.getInt("MASACH");
				int SOLUONG=rs.getInt("SOLUONG");
				int GIATIEN=rs.getInt("GIATIEN");
				int THANHTIEN=rs.getInt("THANHTIEN");
				CHITIETHOADON ct=new CHITIETHOADON(MAHOADON,MASACH,GIATIEN,THANHTIEN,SOLUONG);
				ketqua.add(ct);
			}
			JDBCUtil.closeConnection(con);
		}
		catch(Exception e) {
			// TODO Auto-generated catch block
			System.out.print("co loi xay ra, thuc hien cau lenh khong thanh cong o selectAll class CHITIETHOADONDAO \n");
			e.printStackTrace();
		}
		return ketqua;
	}

	@Override
	public CHITIETHOADON selectById(CHITIETHOADON t) {
		CHITIETHOADON ketqua=null;
		try {
			Connection con=JDBCUtil.getConnection();
			String sql=" SELECT * FROM chitiethoadon "+
					"WHERE MAHOADON=?";
			PreparedStatement pst=con.prepareStatement(sql);
			pst.setInt(1,t.getMAHOADON());
			
			ResultSet rs=pst.executeQuery();
			while(rs.next()) {
				int MAHOADON=rs.getInt("MAHOADON");
				int MASACH=rs.getInt("MASACH");
				int SOLUONG=rs.getInt("SOLUONG");
				int GIATIEN=rs.getInt("GIATIEN");
				int THANHTIEN=rs.getInt("THANHTIEN");
				CHITIETHOADON ct=new CHITIETHOADON(MAHOADON,MASACH,GIATIEN,THANHTIEN,SOLUONG);
				ketqua=ct;
			}
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.print("co loi xay ra, thuc hien cau lenh khong thanh cong o selectAll class CHITIETHOADONDAO \n");
			e.printStackTrace();
		}
		return ketqua;
	}
	public ArrayList<CHITIETHOADON> selectByIDHOADON(HOADON t) {
		ArrayList<CHITIETHOADON> ketqua=new ArrayList<CHITIETHOADON>();
		try {
			Connection con=JDBCUtil.getConnection();
			String sql=" SELECT * FROM chitiethoadon "+
					"WHERE MAHOADON=?";
			PreparedStatement pst=con.prepareStatement(sql);
			pst.setInt(1,t.getMAHOADON());
			
			ResultSet rs=pst.executeQuery();
			while(rs.next()) {
				int MAHOADON=rs.getInt("MAHOADON");
				int MASACH=rs.getInt("MASACH");
				int SOLUONG=rs.getInt("SOLUONG");
				int GIATIEN=rs.getInt("GIATIEN");
				int THANHTIEN=rs.getInt("THANHTIEN");
				CHITIETHOADON ct=new CHITIETHOADON(MAHOADON,MASACH,GIATIEN,THANHTIEN,SOLUONG);
				ketqua.add(ct);
			}
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.print("co loi xay ra, thuc hien cau lenh khong thanh cong o selectAll class CHITIETHOADONDAO \n");
			e.printStackTrace();
		}
		return ketqua;
	}

	@Override
	public ArrayList<CHITIETHOADON> selectByCondition(String condition) {
		ArrayList<CHITIETHOADON> ketqua=new ArrayList<CHITIETHOADON>();
		try {
			Connection con=JDBCUtil.getConnection();
			
			String sql=" SELECT * FROM chitiethoadon "+
					"WHERE "+condition;
			
			Statement pst=con.createStatement();
			
			
			ResultSet rs=pst.executeQuery(sql);
			while(rs.next()) {
				int MAHOADON=rs.getInt("MAHOADON");
				int MASACH=rs.getInt("MASACH");
				int SOLUONG=rs.getInt("SOLUONG");
				int GIATIEN=rs.getInt("GIATIEN");
				int THANHTIEN=rs.getInt("THANHTIEN");
				CHITIETHOADON ct=new CHITIETHOADON(MAHOADON,MASACH,GIATIEN,THANHTIEN,SOLUONG);
				ketqua.add(ct);
			}
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.print("co loi xay ra, thuc hien cau lenh khong thanh cong o selectByCondition class CHITIETHOADONDAO \n");
			e.printStackTrace();
		}
		return ketqua;
	}

}
