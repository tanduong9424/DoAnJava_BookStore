package Main.BackEnd.repository.dao;

import Main.BackEnd.repository.dao.SACHDAO;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import Main.BackEnd.repository.database.JDBCUtil;
import Main.BackEnd.repository.modal.HOADON;
import Main.BackEnd.repository.modal.KHACHANG;
import Main.BackEnd.repository.modal.NHANVIEN;
import Main.BackEnd.repository.modal.SACH;
import Main.BackEnd.repository.modal.TAIKHOAN;

public class HOADONDAO implements DAOInterface<HOADON>{
	public static HOADONDAO getInstance() {
		return new HOADONDAO();
	}
//khi tao hoadon thi cung tao chitiethoadon
	@Override
	public int insert(HOADON t) {
		int ketqua=0;
		// try {
		// 	Connection con=JDBCUtil.getConnection();
		// 	String sql="INSERT INTO hoadon (MAHOADON,TENKHACHHAHNG,NGAYLAP,TONGTIEN) "+
		// 	"VALUES (?,?,?,?)";
		// 	PreparedStatement pst =con.prepareStatement(sql);
		// 	pst.setInt(1, t.getMAHOADON());
		// 	pst.setString(2, tk1.getUSERNAME());
		// 	pst.setDate(3, t.getNGAYLAP());
		// 	pst.setInt(4, t.getTONGTIEN());
			
		// }
		// catch (SQLException e){
		// 	// TODO Auto-generated catch block
		// 	System.out.print("co loi xay ra, thuc hien cau lenh khong thanh cong o insert() class HOADONDAO \n");
		// 	e.printStackTrace();
		// }
		return 0;
	}
	public int insertHOADONCOTKCOMAKM(HOADON t,TAIKHOAN tk,NHANVIEN nv) {
		int ketqua=0;
		try {
			Connection con=JDBCUtil.getConnection();
			String sql="INSERT INTO hoadon (TENKHACHHAHNG,manv,NGAYLAP,TONGTIEN,makhuyenmai,tthd) "+
			"VALUES (?,?,?,?,?,?)";
			PreparedStatement pst =con.prepareStatement(sql);
			pst.setString(1, tk.getUSERNAME());
			pst.setInt(2, nv.getManv());
			pst.setDate(3, t.getNGAYLAP());
			pst.setInt(4, t.getTONGTIEN());
			pst.setInt(5, t.getMakhuyenmai());
			pst.setBoolean(6, t.isTthd());
			ketqua=pst.executeUpdate();
			JDBCUtil.closeConnection(con);
		}
		catch (SQLException e){
			// TODO Auto-generated catch block
			System.out.print("co loi xay ra, thuc hien cau lenh khong thanh cong o insert() class HOADONDAO \n");
			e.printStackTrace();
		}
		return 0;
	}
	public int insertHOADONKHONGTKCOMAKM(HOADON t,KHACHANG kh,NHANVIEN nv) {
		int ketqua=0;
		try {
			Connection con=JDBCUtil.getConnection();
			String sql="INSERT INTO hoadon (manv,NGAYLAP,TONGTIEN,makhuyenmai,tthd) "+
			"VALUES (?,?,?,?,?)";
			PreparedStatement pst =con.prepareStatement(sql);
			pst.setInt(1, nv.getManv());
			pst.setDate(2, t.getNGAYLAP());
			pst.setInt(3, t.getTONGTIEN());
			pst.setInt(4, t.getMakhuyenmai());
			pst.setBoolean(5, t.isTthd());
			ketqua=pst.executeUpdate();
			JDBCUtil.closeConnection(con);
		}
		catch (SQLException e){
			// TODO Auto-generated catch block
			System.out.print("co loi xay ra, thuc hien cau lenh khong thanh cong o insert() class HOADONDAO \n");
			e.printStackTrace();
		}
		return 0;
	}
	public int insertHOADONCOTKKOMAKM(HOADON t,TAIKHOAN tk,NHANVIEN nv) {
		int ketqua=0;
		try {
			Connection con=JDBCUtil.getConnection();
			String sql="INSERT INTO hoadon (TENKHACHHAHNG,manv,NGAYLAP,TONGTIEN,tthd) "+
			"VALUES (?,?,?,?,?,?)";
			PreparedStatement pst =con.prepareStatement(sql);
			pst.setString(1, tk.getUSERNAME());
			pst.setInt(2, nv.getManv());
			pst.setDate(3, t.getNGAYLAP());
			pst.setInt(4, t.getTONGTIEN());
			pst.setBoolean(5, t.isTthd());
			ketqua=pst.executeUpdate();
			JDBCUtil.closeConnection(con);
		}
		catch (SQLException e){
			// TODO Auto-generated catch block
			System.out.print("co loi xay ra, thuc hien cau lenh khong thanh cong o insert() class HOADONDAO \n");
			e.printStackTrace();
		}
		return 0;
	}
	public int insertHOADONKHONGTKKOMAKM(HOADON t,KHACHANG kh,NHANVIEN nv) {
		int ketqua=0;
		try {
			Connection con=JDBCUtil.getConnection();
			String sql="INSERT INTO hoadon (manv,NGAYLAP,TONGTIEN,tthd) "+
			"VALUES (?,?,?,?)";
			PreparedStatement pst =con.prepareStatement(sql);
			pst.setInt(1, nv.getManv());
			pst.setDate(2, t.getNGAYLAP());
			pst.setInt(3, t.getTONGTIEN());
			pst.setBoolean(4, t.isTthd());
			ketqua=pst.executeUpdate();
			JDBCUtil.closeConnection(con);
		}
		catch (SQLException e){
			// TODO Auto-generated catch block
			System.out.print("co loi xay ra, thuc hien cau lenh khong thanh cong o insert() class HOADONDAO \n");
			e.printStackTrace();
		}
		return 0;
	}
// hoa don khong thay doi
	@Override
	public int update(HOADON t) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int updateHOANTHANH(HOADON t) {
		int ketqua=0;
		try {
			Connection con=JDBCUtil.getConnection();
			String sql="UPDATE hoadon SET tthd=? WHERE MAHOADON=? "+
			"VALUES (?,?)";
			PreparedStatement pst =con.prepareStatement(sql);
			pst.setBoolean(1, true);
			pst.setInt(2, t.getMAHOADON());
			ketqua=pst.executeUpdate();
			JDBCUtil.closeConnection(con);
		}
		catch (SQLException e){
			// TODO Auto-generated catch block
			System.out.print("co loi xay ra, thuc hien cau lenh khong thanh cong o insert() class HOADONDAO \n");
			e.printStackTrace();
		}
		return 0;
	}

//KHI XÓA THÌ CẦN LƯU Ý (TRẢ SỐ LƯỢNG SÁCH VỀ KHO + KIỂM TRA SÁCH ĐÓ CÓ ISHIDDEN KHÔNG ,NẾU CÓ THÌ KHÔNG CẦN TĂNG)
	@Override
	public int delete(HOADON t) {
		int ketqua=0;
		try {
			Connection con=JDBCUtil.getConnection();
			String sqlKho="SELECT MASACH,SOLUONG FROM hoadon,chitiethoadon "+
						"WHERE hoadon.MAHOADON=chitiethoadon.MAHOADON AND hoadon.MAHOADON=?";
			PreparedStatement pst1=con.prepareStatement(sqlKho);
			pst1.setInt(1, t.getMAHOADON());
			ResultSet rs=pst1.executeQuery();
			while(rs.next()) {
				int MASACH=rs.getInt("MASACH");
				int SOLUONG=rs.getInt("SOLUONG");
				SACH kho=new SACH(MASACH);
				SACHDAO.getInstance().thuhoiSACH(kho,SOLUONG);
			}
			
			
			
			String sql="DELETE from  hoadon  "+
					" WHERE MAHOADON=?";
			
			PreparedStatement pst=con.prepareStatement(sql);
			
			pst.setInt(1,t.getMAHOADON());
			
			ketqua=pst.executeUpdate();
			System.out.print("thuc hien cau lenh "+sql+"\n");
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.print("\nco loi xay ra, thuc hien cau lenh khong thanh cong o update() class HOADONDAO \n");
			e.printStackTrace();
		}
		return 0;
	}


	@Override
	public ArrayList<HOADON> selectAll() {
		ArrayList<HOADON> ketqua=new ArrayList<HOADON>();
		try {
			Connection con=JDBCUtil.getConnection();
			
			String sql=" SELECT * FROM hoadon ";
			
			PreparedStatement pst=con.prepareStatement(sql);
			
			
			ResultSet rs=pst.executeQuery();
			while(rs.next()) {
				int MAHOADON=rs.getInt("MAHOADON");
				String TENKHACHHANG=rs.getString("TENKHACHHANG");
				int manv=rs.getInt("manv");
				Date NGAYLAP=rs.getDate("NGAYLAP");
				int TONGTIEN=rs.getInt("TONGTIEN");
				int makhuyenmai=rs.getInt("makhuyenmai");
				boolean tthd=rs.getBoolean("tthd");
				HOADON hoadon=new HOADON(MAHOADON,TENKHACHHANG,manv,NGAYLAP,TONGTIEN,makhuyenmai,tthd);
				ketqua.add(hoadon);
			}
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.print("co loi xay ra, thuc hien cau lenh khong thanh cong o selectAll class HOADONDAO \n");
			e.printStackTrace();
		}
		return ketqua;
	}

	public ArrayList<HOADON> selectAllHOANTHANH() {
		ArrayList<HOADON> ketqua=new ArrayList<HOADON>();
		try {
			Connection con=JDBCUtil.getConnection();
			
			String sql=" SELECT * FROM hoadon WHERE tthd=true";
			
			PreparedStatement pst=con.prepareStatement(sql);
			
			
			ResultSet rs=pst.executeQuery();
			while(rs.next()) {
				int MAHOADON=rs.getInt("MAHOADON");
				String TENKHACHHANG=rs.getString("TENKHACHHANG");
				int manv=rs.getInt("manv");
				Date NGAYLAP=rs.getDate("NGAYLAP");
				int TONGTIEN=rs.getInt("TONGTIEN");
				int makhuyenmai=rs.getInt("makhuyenmai");
				boolean tthd=rs.getBoolean("tthd");
				HOADON hoadon=new HOADON(MAHOADON,TENKHACHHANG,manv,NGAYLAP,TONGTIEN,makhuyenmai,tthd);
				ketqua.add(hoadon);
			}
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.print("co loi xay ra, thuc hien cau lenh khong thanh cong o selectAll class HOADONDAO \n");
			e.printStackTrace();
		}
		return ketqua;
	}
	public ArrayList<HOADON> selectAllCHUAHOANTHANH() {
		ArrayList<HOADON> ketqua=new ArrayList<HOADON>();
		try {
			Connection con=JDBCUtil.getConnection();
			
			String sql=" SELECT * FROM hoadon WHERE tthd=false";
			
			PreparedStatement pst=con.prepareStatement(sql);
			
			
			ResultSet rs=pst.executeQuery();
			while(rs.next()) {
				int MAHOADON=rs.getInt("MAHOADON");
				String TENKHACHHANG=rs.getString("TENKHACHHANG");
				int manv=rs.getInt("manv");
				Date NGAYLAP=rs.getDate("NGAYLAP");
				int TONGTIEN=rs.getInt("TONGTIEN");
				int makhuyenmai=rs.getInt("makhuyenmai");
				boolean tthd=rs.getBoolean("tthd");
				HOADON hoadon=new HOADON(MAHOADON,TENKHACHHANG,manv,NGAYLAP,TONGTIEN,makhuyenmai,tthd);
				ketqua.add(hoadon);
			}
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.print("co loi xay ra, thuc hien cau lenh khong thanh cong o selectAll class HOADONDAO \n");
			e.printStackTrace();
		}
		return ketqua;
	}

	@Override
	public HOADON selectById(HOADON t) {
		HOADON ketqua=null;
		try {
			Connection con=JDBCUtil.getConnection();
			
			String sql=" SELECT * FROM hoadon "+
					"WHERE MAHOADON=?";
			PreparedStatement pst=con.prepareStatement(sql);
			pst.setInt(1,t.getMAHOADON());
			
			ResultSet rs=pst.executeQuery();
			while(rs.next()) {
				int MAHOADON=rs.getInt("MAHOADON");
				String TENKHACHHANG=rs.getString("TENKHACHHANG");
				int manv=rs.getInt("manv");
				Date NGAYLAP=rs.getDate("NGAYLAP");
				int TONGTIEN=rs.getInt("TONGTIEN");
				int makhuyenmai=rs.getInt("makhuyenmai");
				boolean tthd=rs.getBoolean("tthd");
				HOADON hoadon=new HOADON(MAHOADON,TENKHACHHANG,manv,NGAYLAP,TONGTIEN,makhuyenmai,tthd);
				ketqua=hoadon;
			}
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.print("co loi xay ra, thuc hien cau lenh khong thanh cong o selectAll class HOADONDAO \n");
			e.printStackTrace();
		}
		return ketqua;
	}

	@Override
	public ArrayList<HOADON> selectByCondition(String condition) {
		ArrayList<HOADON> ketqua=new ArrayList<HOADON>();
		try {
			Connection con=JDBCUtil.getConnection();
			
			String sql=" SELECT * FROM hoadon "+
					"WHERE "+condition;
			
			Statement pst=con.createStatement();
			
			
			ResultSet rs=pst.executeQuery(sql);
			while(rs.next()) {
				int MAHOADON=rs.getInt("MAHOADON");
				String TENKHACHHANG=rs.getString("TENKHACHHANG");
				int manv=rs.getInt("manv");
				Date NGAYLAP=rs.getDate("NGAYLAP");
				int TONGTIEN=rs.getInt("TONGTIEN");
				int makhuyenmai=rs.getInt("makhuyenmai");
				boolean tthd=rs.getBoolean("tthd");
				HOADON hoadon=new HOADON(MAHOADON,TENKHACHHANG,manv,NGAYLAP,TONGTIEN,makhuyenmai,tthd);
				ketqua.add(hoadon);
			}
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.print("co loi xay ra, thuc hien cau lenh khong thanh cong o selectByCondition class HOADONDAO \n");
			e.printStackTrace();
		}
		return ketqua;
	}
	public static boolean isnumber(String s) {
		String pattern="^\\d+";
		if(s.matches(pattern)) {
			return true;
		}
		return false;
	}

}
