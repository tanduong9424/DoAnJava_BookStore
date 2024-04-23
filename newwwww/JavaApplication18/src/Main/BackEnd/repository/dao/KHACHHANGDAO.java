package Main.BackEnd.repository.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Main.BackEnd.repository.database.JDBCUtil;
import Main.BackEnd.repository.modal.KHACHANG;
import Main.BackEnd.repository.modal.TAIKHOAN;

public class KHACHHANGDAO implements DAOInterface<KHACHANG>{

    @Override
    public int insert(KHACHANG  t) {
        int ketqua=0;
        try {
            Connection con=JDBCUtil.getConnection();
            String sql="INSERT INTO khachhang (hoten,diachi,email,dienthoai,ngaytao,tttk) VALUES (?,?,?,?,?,?)";
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

    public int insertCOTK(KHACHANG t,TAIKHOAN tk) {
        int ketqua=0;
        try {
            Connection con=JDBCUtil.getConnection();
            String sql="INSERT INTO khachhang (username,hoten,diachi,email,dienthoai,ngaytao,tttk) VALUES (?,?,?,?,?,?,?)";
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
    public int update(KHACHANG  t) {
        int ketqua=0;
        try {
            Connection con=JDBCUtil.getConnection();


            String sql="UPDATE khachhang SET hoten=?,diachi=?,email=?,dienthoai=?,ngaytao=?,tttk=? WHERE makh=?";
            PreparedStatement pst=con.prepareStatement(sql);
            pst.setString(1, t.getHoten());
            pst.setString(2, t.getDiachi());
            pst.setString(3, t.getEmail());
            pst.setInt(4, t.getDienthoai());
            pst.setDate(5, t.getNgaytao());
            pst.setBoolean(6, t.isTttk());
            pst.setInt(7, t.getMakh());
            ketqua=pst.executeUpdate();
			JDBCUtil.closeConnection(con);

        } catch (Exception e) {
            System.out.println("có lỗi xảy ra, không thể insert nhân viên");
            e.printStackTrace();
        }
        return ketqua;
    }

    public int updateCOTK(KHACHANG t,TAIKHOAN tk) {
        int ketqua=0;
        try {
            Connection con=JDBCUtil.getConnection();


            String sql="UPDATE nhanvien SET username=?,hoten=?,diachi=?,email=?,dienthoai=?,ngaytao=?,tttk=? WHERE manv=?";
            PreparedStatement pst=con.prepareStatement(sql);
            pst.setString(1, tk.getUSERNAME());
            pst.setString(2, t.getHoten());
            pst.setString(3, t.getDiachi());
            pst.setString(4, t.getEmail());
            pst.setInt(5, t.getDienthoai());
            pst.setDate(6, t.getNgaytao());
            pst.setBoolean(7, t.isTttk());
            pst.setInt(8, t.getMakh());
            ketqua=pst.executeUpdate();
			JDBCUtil.closeConnection(con);

        } catch (Exception e) {
            System.out.println("có lỗi xảy ra, không thể insert nhân viên");
            e.printStackTrace();
        }
        return ketqua;
    }

    @Override
    public int delete(KHACHANG  t) {
        int ketqua=0;
        try {
        Connection con=JDBCUtil.getConnection();

        String sql="DELETE from khachhang WHERE makh=?";
        PreparedStatement pst=con.prepareStatement(sql);
        pst.setInt(1, t.getMakh());
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
        ArrayList<KHACHANG> ketqua=new ArrayList<KHACHANG>();
		try {
			Connection con=JDBCUtil.getConnection();
			
			String sql=" SELECT * FROM khachhang ";
			
			PreparedStatement pst=con.prepareStatement(sql);
			
			
			ResultSet rs=pst.executeQuery();
			while(rs.next()) {
				int makh=rs.getInt("makh");	
                String username=rs.getString("username");	
                String hoten=rs.getString("hoten");	
                String diachi=rs.getString("diachi");	
                String email=rs.getString("email");	
                int dienthoai=rs.getInt("dienthoai");	
                Date ngaytao=rs.getDate("ngaytao");	
                boolean tttk=rs.getBoolean("tttk");	
				KHACHANG nv=new KHACHANG(makh,username,hoten,diachi,email,dienthoai,ngaytao,tttk);
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

        //KHÁCH HÀNG còn hoạt động
        public ArrayList selectAllEXCEPT_TTTK_FALSE() {
            ArrayList<KHACHANG> ketqua=new ArrayList<KHACHANG>();
            try {
                Connection con=JDBCUtil.getConnection();
                
                String sql=" SELECT * FROM khachhang WHERE tttk=true ";
                
                PreparedStatement pst=con.prepareStatement(sql);
                
                
                ResultSet rs=pst.executeQuery();
                while(rs.next()) {
                    int makh=rs.getInt("makh");	
                    String username=rs.getString("username");	
                    String hoten=rs.getString("hoten");	
                    String diachi=rs.getString("diachi");	
                    String email=rs.getString("email");	
                    int dienthoai=rs.getInt("dienthoai");	
                    Date ngaytao=rs.getDate("ngaytao");	
                    boolean tttk=rs.getBoolean("tttk");	
                    KHACHANG nv=new KHACHANG(makh,username,hoten,diachi,email,dienthoai,ngaytao,tttk);
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
    public KHACHANG selectById(KHACHANG t) {
        KHACHANG ketqua=null;
        try {
            Connection con=JDBCUtil.getConnection();
            
            String sql=" SELECT * FROM khachhang WHERE makh=? ";
            
            PreparedStatement pst=con.prepareStatement(sql);
			pst.setInt(1, t.getMakh());
            
            
            ResultSet rs=pst.executeQuery();
            while(rs.next()) {
                int makh=rs.getInt("makh");	
                String username=rs.getString("username");	
                String hoten=rs.getString("hoten");	
                String diachi=rs.getString("diachi");	
                String email=rs.getString("email");	
                int dienthoai=rs.getInt("dienthoai");	
                Date ngaytao=rs.getDate("ngaytao");	
                boolean tttk=rs.getBoolean("tttk");	
                KHACHANG nv=new KHACHANG(makh,username,hoten,diachi,email,dienthoai,ngaytao,tttk);
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
		ArrayList<KHACHANG> ketqua=new ArrayList<KHACHANG>();
		try {
			Connection con=JDBCUtil.getConnection();
			
			String sql=" SELECT * FROM khachhang "+
					"WHERE "+condition;
			
			PreparedStatement pst=con.prepareStatement(sql);
			
			
			ResultSet rs=pst.executeQuery();
			while(rs.next()) {
                int makh=rs.getInt("makh");	
                String username=rs.getString("username");	
                String hoten=rs.getString("hoten");	
                String diachi=rs.getString("diachi");	
                String email=rs.getString("email");	
                int dienthoai=rs.getInt("dienthoai");	
                Date ngaytao=rs.getDate("ngaytao");	
                boolean tttk=rs.getBoolean("tttk");	
                KHACHANG nv=new KHACHANG(makh,username,hoten,diachi,email,dienthoai,ngaytao,tttk);
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
