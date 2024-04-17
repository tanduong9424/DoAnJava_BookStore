package Main.BackEnd.repository.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Main.BackEnd.repository.database.JDBCUtil;
import Main.BackEnd.repository.modal.NHANVIEN;
import Main.BackEnd.repository.modal.TAIKHOAN;

public class NHANVIENDAO implements DAOInterface<NHANVIEN>{

    @Override
    //không có tài khoản
    public int insert(NHANVIEN t) {
        int ketqua=0;
        try {
            Connection con=JDBCUtil.getConnection();
            String sql="INSERT INTO nhanvien (hoten,diachi,email,dienthoai,ngaytao,tttk) VALUES (?,?,?,?,?,?)";
            PreparedStatement pst=con.prepareStatement(sql);
            pst.setString(1, t.getHoten());
            pst.setString(2, t.getDiachi());
            pst.setString(3, t.getEmail());
            pst.setInt(4, t.getDienthoai());
            pst.setDate(5, t.getNgaytao());
            pst.setBoolean(6, t.isTttk());
            ketqua=pst.executeUpdate();
			JDBCUtil.closeConnection(con);

        } catch (Exception e) {
            System.out.println("có lỗi xảy ra, không thể insert nhân viên");
            e.printStackTrace();
        }
        return ketqua;
    }

    //có tài khoản
    public int insertCOTK(NHANVIEN t,TAIKHOAN tk) {
        int ketqua=0;
        try {
            Connection con=JDBCUtil.getConnection();
            String sql="INSERT INTO nhanvien (username,hoten,diachi,email,dienthoai,ngaytao,tttk) VALUES (?,?,?,?,?,?,?)";
            PreparedStatement pst=con.prepareStatement(sql);
            pst.setString(1, tk.getUSERNAME());
            pst.setString(2, t.getHoten());
            pst.setString(3, t.getDiachi());
            pst.setString(4, t.getEmail());
            pst.setInt(5, t.getDienthoai());
            pst.setDate(6, t.getNgaytao());
            pst.setBoolean(7, t.isTttk());
            ketqua=pst.executeUpdate();
			JDBCUtil.closeConnection(con);

        } catch (Exception e) {
            System.out.println("có lỗi xảy ra, không thể insert nhân viên");
            e.printStackTrace();
        }
        return ketqua;
    }

    @Override
    public int update(NHANVIEN t) {
        int ketqua=0;
        try {
            Connection con=JDBCUtil.getConnection();

            String sqlCheck = "SELECT * FROM hoadon WHERE manv = ?";
			PreparedStatement pstCheck = con.prepareStatement(sqlCheck);
			pstCheck.setInt(1, t.getManv());
			ResultSet rs = pstCheck.executeQuery();
	
			if (rs.next()) {
				// Nếu có, in ra thông báo và trả về một giá trị ngay tại thời điểm đó mà không tiếp tục thực hiện các lệnh SQL tiếp theo
				System.out.println("NHÂN VIÊN đã tồn tại trong hóa đơn, không thể thay đổi.");
                String sql="UPDATE nhanvien SET tttk=? WHERE manv=?";
                PreparedStatement pst=con.prepareStatement(sql);
                pst.setBoolean(1, false);
                pst.setInt(2, t.getManv());
                ketqua=pst.executeUpdate();
                JDBCUtil.closeConnection(con);

				return -1; // hoặc trả về một giá trị khác thích hợp
			}

            String sql="UPDATE nhanvien SET hoten=?,diachi=?,email=?,dienthoai=?,ngaytao=?,tttk=? WHERE manv=?";
            PreparedStatement pst=con.prepareStatement(sql);
            pst.setString(1, t.getHoten());
            pst.setString(2, t.getDiachi());
            pst.setString(3, t.getEmail());
            pst.setInt(4, t.getDienthoai());
            pst.setDate(5, t.getNgaytao());
            pst.setBoolean(6, t.isTttk());
            pst.setInt(7, t.getManv());
            ketqua=pst.executeUpdate();
			JDBCUtil.closeConnection(con);

        } catch (Exception e) {
            System.out.println("có lỗi xảy ra, không thể insert nhân viên");
            e.printStackTrace();
        }
        return ketqua;
    }
    //có tài khoản
    public int updateCOTK(NHANVIEN t,TAIKHOAN tk) {
        int ketqua=0;
        try {
            Connection con=JDBCUtil.getConnection();
            String sqlCheck = "SELECT * FROM hoadon WHERE manv = ?";
			PreparedStatement pstCheck = con.prepareStatement(sqlCheck);
			pstCheck.setInt(1, t.getManv());
			ResultSet rs = pstCheck.executeQuery();
	
			if (rs.next()) {
				// Nếu có, in ra thông báo và trả về một giá trị ngay tại thời điểm đó mà không tiếp tục thực hiện các lệnh SQL tiếp theo
				System.out.println("NHÂN VIÊN đã tồn tại trong hóa đơn, không thể thay đổi.");
                String sql="UPDATE nhanvien SET tttk=? WHERE manv=?";
                PreparedStatement pst=con.prepareStatement(sql);
                pst.setBoolean(1, false);
                pst.setInt(2, t.getManv());
                ketqua=pst.executeUpdate();
                JDBCUtil.closeConnection(con);

				return -1; // hoặc trả về một giá trị khác thích hợp
			}


            String sql="UPDATE nhanvien SET username=?,hoten=?,diachi=?,email=?,dienthoai=?,ngaytao=?,tttk=? WHERE manv=?";
            PreparedStatement pst=con.prepareStatement(sql);
            pst.setString(1, tk.getUSERNAME());
            pst.setString(2, t.getHoten());
            pst.setString(3, t.getDiachi());
            pst.setString(4, t.getEmail());
            pst.setInt(5, t.getDienthoai());
            pst.setDate(6, t.getNgaytao());
            pst.setBoolean(7, t.isTttk());
            pst.setInt(8, t.getManv());
            ketqua=pst.executeUpdate();
			JDBCUtil.closeConnection(con);

        } catch (Exception e) {
            System.out.println("có lỗi xảy ra, không thể insert nhân viên");
            e.printStackTrace();
        }
        return ketqua;
    }

    @Override
    public int delete(NHANVIEN t) {
        int ketqua=0;
        try {
            Connection con=JDBCUtil.getConnection();

            String sqlCheck = "SELECT * FROM hoadon WHERE manv = ?";
			PreparedStatement pstCheck = con.prepareStatement(sqlCheck);
			pstCheck.setInt(1, t.getManv());
			ResultSet rs = pstCheck.executeQuery();
	
			if (rs.next()) {
				// Nếu có, in ra thông báo và trả về một giá trị ngay tại thời điểm đó mà không tiếp tục thực hiện các lệnh SQL tiếp theo
				System.out.println("NHÂN VIÊN đã tồn tại trong hóa đơn, không thể xóa.");
                String sql="UPDATE nhanvien SET tttk=? WHERE manv=?";
                PreparedStatement pst=con.prepareStatement(sql);
                pst.setBoolean(1, false);
                pst.setInt(2, t.getManv());
                ketqua=pst.executeUpdate();
                JDBCUtil.closeConnection(con);

				return -1; // hoặc trả về một giá trị khác thích hợp
			}

            String sql="DELETE from nhanvien WHERE manv=?";
            PreparedStatement pst=con.prepareStatement(sql);
            pst.setInt(1, t.getManv());
            ketqua=pst.executeUpdate();
			JDBCUtil.closeConnection(con);

        } catch (Exception e) {
            System.out.println("có lỗi xảy ra, không thể insert nhân viên");
            e.printStackTrace();
        }
        return ketqua;
    }

    @Override
    public ArrayList selectAll() {
        ArrayList<NHANVIEN> ketqua=new ArrayList<NHANVIEN>();
		try {
			Connection con=JDBCUtil.getConnection();
			
			String sql=" SELECT * FROM nhanvien ";
			
			PreparedStatement pst=con.prepareStatement(sql);
			
			
			ResultSet rs=pst.executeQuery();
			while(rs.next()) {
				int manv=rs.getInt("manv");	
                String username=rs.getString("username");	
                String hoten=rs.getString("hoten");	
                String diachi=rs.getString("diachi");	
                String email=rs.getString("email");	
                int dienthoai=rs.getInt("dienthoai");	
                Date ngaytao=rs.getDate("ngaytao");	
                boolean tttk=rs.getBoolean("tttk");	
				NHANVIEN nv=new NHANVIEN(manv,username,hoten,diachi,email,dienthoai,ngaytao,tttk);
				ketqua.add(nv);
			}
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.print("co loi xay ra, thuc hien cau lenh khong thanh cong o selectAll class HOADONDAO \n");
			e.printStackTrace();
		}
		return ketqua;
    }
    //nhân viên còn hoạt động
    public ArrayList selectAllEXCEPT_TTTK_FALSE() {
        ArrayList<NHANVIEN> ketqua=new ArrayList<NHANVIEN>();
		try {
			Connection con=JDBCUtil.getConnection();
			
			String sql=" SELECT * FROM nhanvien WHERE tttk=true ";
			
			PreparedStatement pst=con.prepareStatement(sql);
			
			
			ResultSet rs=pst.executeQuery();
			while(rs.next()) {
				int manv=rs.getInt("manv");	
                String username=rs.getString("username");	
                String hoten=rs.getString("hoten");	
                String diachi=rs.getString("diachi");	
                String email=rs.getString("email");	
                int dienthoai=rs.getInt("dienthoai");	
                Date ngaytao=rs.getDate("ngaytao");	
                boolean tttk=rs.getBoolean("tttk");	
				NHANVIEN nv=new NHANVIEN(manv,username,hoten,diachi,email,dienthoai,ngaytao,tttk);
				ketqua.add(nv);
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
    public NHANVIEN selectById(NHANVIEN t) {
        NHANVIEN ketqua=null;
		try {
			Connection con=JDBCUtil.getConnection();
			
			String sql=" SELECT * FROM nhanvien WHERE manv=? ";
			
			PreparedStatement pst=con.prepareStatement(sql);
			pst.setInt(1, t.getManv());
			
			ResultSet rs=pst.executeQuery();
			while(rs.next()) {
				int manv=rs.getInt("manv");	
                String username=rs.getString("username");	
                String hoten=rs.getString("hoten");	
                String diachi=rs.getString("diachi");	
                String email=rs.getString("email");	
                int dienthoai=rs.getInt("dienthoai");	
                Date ngaytao=rs.getDate("ngaytao");	
                boolean tttk=rs.getBoolean("tttk");	
				NHANVIEN nv=new NHANVIEN(manv,username,hoten,diachi,email,dienthoai,ngaytao,tttk);
				ketqua=nv;
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
    public ArrayList selectByCondition(String condition) {
		ArrayList<NHANVIEN> ketqua=new ArrayList<NHANVIEN>();
		try {
			Connection con=JDBCUtil.getConnection();
			
			String sql=" SELECT * FROM nhanvien "+
					"WHERE "+condition;
			
			PreparedStatement pst=con.prepareStatement(sql);
			
			
			ResultSet rs=pst.executeQuery();
			while(rs.next()) {
				int manv=rs.getInt("manv");	
                String username=rs.getString("username");	
                String hoten=rs.getString("hoten");	
                String diachi=rs.getString("diachi");	
                String email=rs.getString("email");	
                int dienthoai=rs.getInt("dienthoai");	
                Date ngaytao=rs.getDate("ngaytao");	
                boolean tttk=rs.getBoolean("tttk");	
				NHANVIEN nv=new NHANVIEN(manv,username,hoten,diachi,email,dienthoai,ngaytao,tttk);
				ketqua.add(nv);
			}
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.print("co loi xay ra, thuc hien cau lenh khong thanh cong o selectAll class HOADONDAO \n");
			e.printStackTrace();
		}
		return ketqua;
    }
    
}
