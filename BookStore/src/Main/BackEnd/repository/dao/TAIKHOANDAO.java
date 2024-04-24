package Main.BackEnd.repository.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Main.BackEnd.repository.database.JDBCUtil;
import Main.BackEnd.repository.modal.TAIKHOAN;

public class TAIKHOANDAO implements DAOInterface<TAIKHOAN> {
	public static TAIKHOANDAO getInstance() {
		return new TAIKHOANDAO();
	}
//them tai khoan bat ky
	@Override
	public int insert(TAIKHOAN t) {
		int ketqua=0;
		try {
			Connection con=JDBCUtil.getConnection();
			String sql="INSERT INTO taikhoan (USERNAME,PASSWORD,ROLE) "+
			"VALUES (?,?,?)";
			PreparedStatement pst =con.prepareStatement(sql);
			pst.setString(1, t.getUSERNAME());
			pst.setString(2, t.getPASSWORD());
			pst.setString(3, t.getROLE());
                        ketqua=pst.executeUpdate();
		}
		catch (SQLException e){
			// TODO Auto-generated catch block
			System.out.print("co loi xay ra, thuc hien cau lenh khong thanh cong o insert() class TAIKHOANDAO \n");
			e.printStackTrace();
		}
		return 0;
	}
//them taikhoan user
	public int insertUser(TAIKHOAN t) {
		int ketqua=0;
		try {
			Connection con=JDBCUtil.getConnection();
			String sql="INSERT INTO taikhoan (USERNAME,PASSWORD,ROLE) "+
			"VALUES (?,?,?)";
			PreparedStatement pst =con.prepareStatement(sql);
			pst.setString(1, t.getUSERNAME());
			pst.setString(2, t.getPASSWORD());
			pst.setString(3, "USER");
		}
		catch (SQLException e){
			// TODO Auto-generated catch block
			System.out.print("co loi xay ra, thuc hien cau lenh khong thanh cong o insert() class TAIKHOANDAO \n");
			e.printStackTrace();
		}
		return 0;
	}
//them taikhoan nv
public int insertNV(TAIKHOAN t) {
	int ketqua=0;
	try {
		Connection con=JDBCUtil.getConnection();
		String sql="INSERT INTO taikhoan (USERNAME,PASSWORD,ROLE) "+
		"VALUES (?,?,?)";
		PreparedStatement pst =con.prepareStatement(sql);
		pst.setString(1, t.getUSERNAME());
		pst.setString(2, t.getPASSWORD());
		pst.setString(3, "NV");
	}
	catch (SQLException e){
		// TODO Auto-generated catch block
		System.out.print("co loi xay ra, thuc hien cau lenh khong thanh cong o insert() class TAIKHOANDAO \n");
		e.printStackTrace();
	}
	return 0;
}

	@Override
	public int update(TAIKHOAN t) {
		int ketqua=0;
		try {
			Connection con=JDBCUtil.getConnection();
			
			String sql="UPDATE  taikhoan  "+
					" SET "+
					" PASSWORD=?,"+
					" ROLE=?"+
					" WHERE USERNAME=?";
			
			PreparedStatement pst=con.prepareStatement(sql);
			
			pst.setString(1,t.getPASSWORD());
			pst.setString(2,t.getROLE());
			pst.setString(3,t.getUSERNAME());
			
			ketqua=pst.executeUpdate();
			System.out.print("thuc hien cau lenh "+sql+"\n");
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.print("\nco loi xay ra, thuc hien cau lenh khong thanh cong o update() class TAIKHOANDAO \n");
			e.printStackTrace();
		}
		return 0;
	}
	public int updateUSERNAME(TAIKHOAN t,String USERNAME) {
		int ketqua=0;
		try {
			Connection con=JDBCUtil.getConnection();
			TAIKHOAN tktest=new TAIKHOAN(USERNAME);
			TAIKHOAN kqtest=selectById(tktest);
			if(kqtest==null){
				String sql="UPDATE  taikhoan  "+
						" SET "+
						" USERNAME=?"+
						" WHERE USERNAME=?";
				
				PreparedStatement pst=con.prepareStatement(sql);
				
				pst.setString(1,USERNAME);
				pst.setString(2,t.getUSERNAME());
				
				ketqua=pst.executeUpdate();
				System.out.print("thuc hien cau lenh "+sql+"\n");
				JDBCUtil.closeConnection(con);
			}
			System.out.print("ĐÃ CÓ USERNAME NÀY TỒN TẠI");
			JDBCUtil.closeConnection(con);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.print("\nco loi xay ra, thuc hien cau lenh khong thanh cong o update() class TAIKHOANDAO \n");
			e.printStackTrace();
		}
		return 0;
	}
	public int updatePASSWORD(TAIKHOAN t) {
		int ketqua=0;
		try {
			Connection con=JDBCUtil.getConnection();
			
			String sql="UPDATE  taikhoan  "+
					" SET "+
					" PASSWORD=?"+
					" WHERE USERNAME=?";
			
			PreparedStatement pst=con.prepareStatement(sql);
			
			pst.setString(1,t.getPASSWORD());
			pst.setString(2,t.getUSERNAME());
			
			ketqua=pst.executeUpdate();
			System.out.print("thuc hien cau lenh "+sql+"\n");
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.print("\nco loi xay ra, thuc hien cau lenh khong thanh cong o update() class TAIKHOANDAO \n");
			e.printStackTrace();
		}
		return 0;
	}
	public int updateROLE(TAIKHOAN t) {
		int ketqua=0;
		try {
			Connection con=JDBCUtil.getConnection();
			
			String sql="UPDATE  taikhoan  "+
					" SET "+
					" ROLE=?"+
					" WHERE USERNAME=?";
			
			PreparedStatement pst=con.prepareStatement(sql);
			
			pst.setString(1,t.getPASSWORD());
			pst.setString(2,t.getROLE());
			
			ketqua=pst.executeUpdate();
			System.out.print("thuc hien cau lenh "+sql+"\n");
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.print("\nco loi xay ra, thuc hien cau lenh khong thanh cong o update() class TAIKHOANDAO \n");
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int delete(TAIKHOAN t) {
		int ketqua=0;
		try {
			Connection con=JDBCUtil.getConnection();
			
			String sql="DELETE from  taikhoan  "+
					" WHERE USERNAME=?";
			
			PreparedStatement pst=con.prepareStatement(sql);
			
			pst.setString(1,t.getUSERNAME());
			
			ketqua=pst.executeUpdate();
			System.out.print("thuc hien cau lenh "+sql+"\n");
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.print("\nco loi xay ra, thuc hien cau lenh khong thanh cong o update() class TAIKHOANDAO \n");
			e.printStackTrace();
		}
		return 0;
	}
//cho admin,hệ thống
	@Override
	public ArrayList<TAIKHOAN> selectAll() {
		ArrayList<TAIKHOAN> ketqua=new ArrayList<TAIKHOAN>();
		try {
			Connection con=JDBCUtil.getConnection();
			
			String sql=" SELECT * FROM taikhoan ";
			
			PreparedStatement pst=con.prepareStatement(sql);
			
			
			ResultSet rs=pst.executeQuery();
			while(rs.next()) {
				String USERNAME=rs.getString("USERNAME");
				String PASSWORD=rs.getString("PASSWORD");
				String ROLE=rs.getString("ROLE");
				TAIKHOAN taikhoan=new TAIKHOAN(USERNAME,PASSWORD,ROLE);
				ketqua.add(taikhoan);
			}
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.print("co loi xay ra, thuc hien cau lenh khong thanh cong o selectAll class TAIKHOANDAO \n");
			e.printStackTrace();
		}
		return ketqua;
	}
	

	@Override
	public TAIKHOAN selectById(TAIKHOAN t) {
		TAIKHOAN ketqua=null;
		try {
			Connection con=JDBCUtil.getConnection();
			
			String sql=" SELECT * FROM taikhoan "+
					"WHERE USERNAME=?";
			
			PreparedStatement pst=con.prepareStatement(sql);
			pst.setString(1,t.getUSERNAME());
			System.out.print("Đã thực thi câu lệnh"+sql);
			ResultSet rs=pst.executeQuery();
			while(rs.next()) {
				String USERNAME=rs.getString("USERNAME");
				String PASSWORD=rs.getString("PASSWORD");
				String ROLE=rs.getString("ROLE");
				TAIKHOAN taikhoan=new TAIKHOAN(USERNAME,PASSWORD,ROLE);
				ketqua=taikhoan;
			}
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.print("co loi xay ra, thuc hien cau lenh khong thanh cong o selectById class TAIKHOANDAO \n");
			e.printStackTrace();
		}
		return ketqua;
	}

	@Override
	public ArrayList<TAIKHOAN> selectByCondition(String condition) {
		ArrayList<TAIKHOAN> ketqua=new ArrayList<TAIKHOAN>();
		try {
			Connection con=JDBCUtil.getConnection();
			
			String sql=" SELECT * FROM taikhoan "+
					"WHERE "+condition;
			
			Statement pst=con.createStatement();
			
			
			ResultSet rs=pst.executeQuery(sql);
			while(rs.next()) {
				String USERNAME=rs.getString("USERNAME");
				String PASSWORD=rs.getString("PASSWORD");
				String ROLE=rs.getString("ROLE");
				TAIKHOAN taikhoan=new TAIKHOAN(USERNAME,PASSWORD,ROLE);
				ketqua.add(taikhoan);
			}
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.print("co loi xay ra, thuc hien cau lenh khong thanh cong o selectByCondition class TAIKHOANDAO \n");
			e.printStackTrace();
		}
		return ketqua;
	}

}
