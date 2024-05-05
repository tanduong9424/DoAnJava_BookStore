
package Dao;

import Dto.KHACHANG;
import Dto.TAIKHOAN;
import conDatabase.JDBCUtil;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;



public class KHACHHANGDAO implements DAOInterface<KHACHANG>{

	public static KHACHHANGDAO getInstance() {
		return new KHACHHANGDAO();
	}    
    
    @Override
    public int insert(KHACHANG  t) {
        int ketqua=0;
        try {
            Connection con=JDBCUtil.getConnection();
            String sql="INSERT INTO khachhang (hoten,diachi,email,dienthoai,tttk) VALUES (?,?,?,?,?)";
            PreparedStatement pst=con.prepareStatement(sql);
            pst.setString(1, t.getHoten());
            pst.setString(2, t.getDiachi());
            pst.setString(3, t.getEmail());
            pst.setInt(4, t.getDienthoai());
            pst.setBoolean(5, true);
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


            String sql="UPDATE khachhang SET hoten=?,diachi=?,email=?,dienthoai=?,tttk=? WHERE makh=?";
            PreparedStatement pst=con.prepareStatement(sql);
            pst.setString(1, t.getHoten());
            pst.setString(2, t.getDiachi());
            pst.setString(3, t.getEmail());
            pst.setInt(4, t.getDienthoai());
            pst.setBoolean(5, t.isTttk());
            pst.setInt(6, t.getMakh());
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
			
			String sql=" SELECT * FROM khachhang WHERE tttk=true";
			
			PreparedStatement pst=con.prepareStatement(sql);
			
			
			ResultSet rs=pst.executeQuery();
			while(rs.next()) {
				int makh=rs.getInt("makh");	
                                String hoten=rs.getString("hoten");	
                                String diachi=rs.getString("diachi");	
                                String email=rs.getString("email");	
                                int dienthoai=rs.getInt("dienthoai");	
                                boolean tttk=rs.getBoolean("tttk");	
				KHACHANG nv=new KHACHANG(makh,hoten,diachi,email,dienthoai,tttk);
				ketqua.add(nv);
			}
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.print("co loi xay ra, thuc hien cau lenh khong thanh cong o selectAll class KHACHANGDAO \n");
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
                String hoten=rs.getString("hoten");	
                String diachi=rs.getString("diachi");	
                String email=rs.getString("email");	
                int dienthoai=rs.getInt("dienthoai");	
                boolean tttk=rs.getBoolean("tttk");	
				KHACHANG nv=new KHACHANG(makh,hoten,diachi,email,dienthoai,tttk);
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
            
            String sql=" SELECT * FROM khachhang WHERE makh=? AND tttk=true";
            
            PreparedStatement pst=con.prepareStatement(sql);
			pst.setInt(1, t.getMakh());
            
            
            ResultSet rs=pst.executeQuery();
            while(rs.next()) {
                int makh=rs.getInt("makh");	
                String hoten=rs.getString("hoten");	
                String diachi=rs.getString("diachi");	
                String email=rs.getString("email");	
                int dienthoai=rs.getInt("dienthoai");	
                boolean tttk=rs.getBoolean("tttk");	
		KHACHANG nv=new KHACHANG(makh,hoten,diachi,email,dienthoai,tttk);
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
                                String hoten=rs.getString("hoten");	
                                String diachi=rs.getString("diachi");	
                                String email=rs.getString("email");	
                                int dienthoai=rs.getInt("dienthoai");	
                                boolean tttk=rs.getBoolean("tttk");	
				KHACHANG nv=new KHACHANG(makh,hoten,diachi,email,dienthoai,tttk);
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
    public ArrayList getIDkh(){
        ArrayList <Integer> ketqua=new ArrayList<Integer>();
        try {
            Connection con=JDBCUtil.getConnection();
            String sql="SELECT makh FROM khachhang WHERE tttk=true";
            PreparedStatement pst=con.prepareStatement(sql);
            ResultSet rs=pst.executeQuery();
            while(rs.next()){
                int id=rs.getInt("makh");
                ketqua.add(id);
            }
        }catch(SQLException e){
            System.out.print("co loi xay ra , thuc hien khong thanh cong getIDkh ow KHACHHANGDAO \n");
            e.printStackTrace();
        }
       return ketqua;
    }
    public KHACHANG SearchKHByID(TAIKHOAN t){
       KHACHANG kq=null;
        try{
            Connection con=JDBCUtil.getConnection();
            String sql="SELECT * FROM khachhang WHERE makh=? AND tttk=true";
            PreparedStatement pst=con.prepareStatement(sql);
            pst.setInt(1,t.getMAKH());
            
            ResultSet rs=pst.executeQuery();
            while(rs.next()){
                int ma=rs.getInt("makh");
                String name=rs.getString("hoten");
                String dchi=rs.getString("diachi");
                String email=rs.getString("email");
                int phone=rs.getInt("dienthoai");
                boolean tttk=rs.getBoolean("tttk");
                KHACHANG tmp=new KHACHANG(ma,name,dchi,email,phone,tttk);
                kq=tmp;
            }
        }catch(SQLException e){
            System.out.print("co loi xay ra , thuc hien khong thanh cong getIDkh ow KHACHHANGDAO \n");
            e.printStackTrace();
        }
        return kq;
    }
    public ArrayList<KHACHANG> timkiemNangCao(String input, String type) {
        ArrayList<KHACHANG> ketqua = new ArrayList<>();
        String sql;
        try {
            Connection con = JDBCUtil.getConnection();
            PreparedStatement pst = null;
            switch (type) {
                case "Mã Khách Hàng":
                    sql = "SELECT * FROM khachhang WHERE CAST(makh AS VARCHAR(20)) LIKE ? AND tttk=true";
                    pst = con.prepareStatement(sql);
                    pst.setString(1, "%" + input + "%");
                    break;
                case "Tên Khách Hàng":
                    sql = "SELECT * FROM khachhang WHERE LOWER(hoten) LIKE ? AND tttk=true";
                    pst = con.prepareStatement(sql);
                    pst.setString(1, "%" + input.toLowerCase() + "%");
                    break;
                case "Địa Chỉ":
                    sql = "SELECT * FROM khachhang WHERE LOWER(diachi) LIKE ? AND tttk=true";
                    pst = con.prepareStatement(sql);
                    pst.setString(1, "%" + input.toLowerCase() + "%");
                    break;
                case "Số Điện Thoại":
                    sql = "SELECT * FROM khachhang WHERE CAST(dienthoai AS VARCHAR(20)) LIKE ? AND tttk=true";
                    pst = con.prepareStatement(sql);
                    pst.setString(1, "%" + input + "%");
                    break;
                case "Email":
                    sql = "SELECT * FROM khachhang WHERE LOWER(email) LIKE ? AND tttk=true";
                    pst = con.prepareStatement(sql);
                    pst.setString(1, "%" + input.toLowerCase() + "%");
                    break;
            }
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                int makh = rs.getInt("makh");
                String hoten = rs.getString("hoten");
                String diachi = rs.getString("diachi");
                String email = rs.getString("email");
                int dienthoai = rs.getInt("dienthoai");
                boolean tttk = rs.getBoolean("tttk");
                KHACHANG khachHang = new KHACHANG(makh, hoten, diachi, email, dienthoai, tttk);
                ketqua.add(khachHang);
            }
            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            System.out.print("co loi o timkiemnangcao KHACHANGDAO\n");
            e.printStackTrace();
        }
        return ketqua;
    }
}
