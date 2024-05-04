package Dao;

import Dto.TAIKHOAN;
import conDatabase.JDBCUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class TAIKHOANDAO implements DAOInterface<TAIKHOAN> {
    public static TAIKHOANDAO getInstance() {
            return new TAIKHOANDAO();
    }

    @Override
    public int insert(TAIKHOAN t) {
        int ketqua=0;
        String sql;
        try {
            Connection con=JDBCUtil.getConnection();
            PreparedStatement pst=null;
            switch (t.getROLE()) {
                case "Nhân Viên":
                    sql="INSERT INTO taikhoan (USERNAME,PASSWORD,ROLE,manv) "+"VALUES (?,?,?,?)";
                    pst = con.prepareStatement(sql);
                    pst.setString(1, t.getUSERNAME());
                    pst.setString(2, t.getPASSWORD());
                    pst.setString(3, t.getROLE());
                    pst.setInt(4,t.getMANV());
                    break;
                case "Khách Hàng":
                    sql="INSERT INTO taikhoan (USERNAME,PASSWORD,ROLE,makh) "+"VALUES (?,?,?,?)";
                    pst =con.prepareStatement(sql);
                    pst.setString(1, t.getUSERNAME());
                    pst.setString(2, t.getPASSWORD());
                    pst.setString(3, t.getROLE());
                    pst.setInt(4,t.getMAKH());
                    break;
                case "Quản Trị Viên":
                    sql="INSERT INTO taikhoan (USERNAME,PASSWORD,ROLE) "+"VALUES (?,?,?)";
                    pst =con.prepareStatement(sql);
                    pst.setString(1, t.getUSERNAME());
                    pst.setString(2, t.getPASSWORD());
                    pst.setString(3, t.getROLE());
                    break;   
            }
            ketqua=pst.executeUpdate();
            JDBCUtil.closeConnection(con);
        }
        catch (SQLException e){
            System.out.print("co loi xay ra, thuc hien cau lenh khong thanh cong o insert() class TAIKHOANDAO \n");
            e.printStackTrace();
            ketqua=1;
        }
        return 0;
    }

    @Override
    public int update(TAIKHOAN t) {
        int ketqua=0;
        try {
            Connection con=JDBCUtil.getConnection();
            String sql = "UPDATE taikhoan SET PASSWORD=? WHERE USERNAME=?";

            PreparedStatement pst=con.prepareStatement(sql);
            pst.setString(1,t.getPASSWORD());
            pst.setString(2,t.getUSERNAME());

            ketqua=pst.executeUpdate();
            System.out.print("thuc hien cau lenh "+sql+"\n");
            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            System.out.print("\nco loi xay ra, thuc hien cau lenh khong thanh cong o update() class TAIKHOANDAO \n");
            e.printStackTrace();
            ketqua=1;
        }
        return ketqua;
    }

    @Override
    public int delete(TAIKHOAN t) {
        int ketqua=0;
        try {
            Connection con=JDBCUtil.getConnection();
            String sql="DELETE from  taikhoan  "+" WHERE USERNAME=?";
            PreparedStatement pst=con.prepareStatement(sql);
            pst.setString(1,t.getUSERNAME());
            ketqua=pst.executeUpdate();
            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            System.out.print("\nco loi xay ra, thuc hien cau lenh khong thanh cong o delete() class TAIKHOANDAO \n");
            e.printStackTrace();
            ketqua=1;
        }
        return ketqua;
    }
    
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
                int makh=rs.getInt("makh");
                int manv=rs.getInt("manv");
                TAIKHOAN taikhoan=new TAIKHOAN(USERNAME,PASSWORD,manv,makh,ROLE);
                ketqua.add(taikhoan);
            }
            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            System.out.print("co loi xay ra, thuc hien cau lenh khong thanh cong o selectAll class TAIKHOANDAO \n");
            e.printStackTrace();
        }
        return ketqua;
    }

    @Override
    public TAIKHOAN selectById(TAIKHOAN t) {//không sử dụng, chỉ cho có interface DAOInteface thôi
        TAIKHOAN ketqua=null;
        try {
            Connection con=JDBCUtil.getConnection();
            String sql=" SELECT * FROM taikhoan "+" WHERE USERNAME=?";
            PreparedStatement pst=con.prepareStatement(sql);
            pst.setString(1,t.getUSERNAME());
            ResultSet rs=pst.executeQuery();
            while(rs.next()) {
                String USERNAME=rs.getString("USERNAME");
                String PASSWORD=rs.getString("PASSWORD");
                String ROLE=rs.getString("ROLE");
                int makh=rs.getInt("makh");
                int manv=rs.getInt("manv");
                TAIKHOAN taikhoan=new TAIKHOAN(USERNAME,PASSWORD,manv,makh,ROLE);
                ketqua=taikhoan;
            }
            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
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
            String sql=" SELECT * FROM taikhoan "+" WHERE "+condition;
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
            System.out.print("co loi xay ra, thuc hien cau lenh khong thanh cong o selectByCondition class TAIKHOANDAO \n");
            e.printStackTrace();
        }
        return ketqua;
    }

    public TAIKHOAN selectByUsername(TAIKHOAN t) {
        TAIKHOAN ketqua=null;
        try {
            Connection con=JDBCUtil.getConnection();
            String sql=" SELECT * FROM taikhoan WHERE USERNAME=? ";
            PreparedStatement pst=con.prepareStatement(sql);
            pst.setString(1, t.getUSERNAME());
            ResultSet rs=pst.executeQuery();
            while(rs.next()) {
                String USERNAME=rs.getString("USERNAME");
                String PASSWORD=rs.getString("PASSWORD");
                String ROLE=rs.getString("ROLE");
                int makh=rs.getInt("makh");
                int manv=rs.getInt("manv");
                TAIKHOAN taikhoan=new TAIKHOAN(USERNAME,PASSWORD,manv,makh,ROLE);
                TAIKHOAN tk=new TAIKHOAN(USERNAME,PASSWORD,ROLE);
                ketqua=tk;
            }
            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            System.out.print("co loi xay ra, thuc hien cau lenh khong thanh cong o selectByusername class NHANVIENDAO \n");
            e.printStackTrace();
        }
        return ketqua;
    }


    public TAIKHOAN CheckTK(String tk) {//dể đăng nhập
        TAIKHOAN ketqua=null;
        try {
            Connection con=JDBCUtil.getConnection();
            String sql=" SELECT * FROM taikhoan WHERE USERNAME=?";
            PreparedStatement pst=con.prepareStatement(sql);
            pst.setString(1, tk);
            ResultSet rs=pst.executeQuery();
            while(rs.next()) {
                String USERNAME=rs.getString("USERNAME");
                String PASSWORD=rs.getString("PASSWORD");
                String ROLE=rs.getString("ROLE");
                int makh=rs.getInt("makh");
                int manv=rs.getInt("manv");
                TAIKHOAN tk_new=new TAIKHOAN(USERNAME,PASSWORD,manv,makh,ROLE);
                ketqua=tk_new;
            }
            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            System.out.print("co loi xay ra, thuc hien cau lenh khong thanh cong o CheckTk class TAIKHOANDAO \n");
            e.printStackTrace();
        }
        return ketqua;
    }
    
    public Boolean CheckMK(TAIKHOAN tk, String inputPassword) {//để đăng nhập
        boolean check = false;
        String pass = null;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT PASSWORD FROM taikhoan WHERE USERNAME=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, tk.getUSERNAME());
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                pass = rs.getString("PASSWORD");
                if (inputPassword.equals(pass)) {
                    check = true; // Mật khẩu hợp lệ
                }
            }
            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            System.out.print("co loi xay ra, thuc hien cau lenh khong thanh cong o CheckMk class TAIKHOANDAO\n");
            e.printStackTrace();
        }
        return check;
    }

}