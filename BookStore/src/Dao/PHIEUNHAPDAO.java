package Dao;

import Dto.NHANVIEN;
import Dto.PHIEUNHAP;
import Dto.SACH;

import conDatabase.JDBCUtil;
import java.sql.Connection;
import java.sql.Date;
import java.sql.JDBCType;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import java.sql.Statement;


public class PHIEUNHAPDAO implements DAOInterface<PHIEUNHAP>{
    	public static PHIEUNHAPDAO getInstance() {
		return new PHIEUNHAPDAO();
	}
    @Override
    public int insert(PHIEUNHAP t) {
        int ketqua=0;
        try {
            Connection con=JDBCUtil.getConnection();
            String sql="INSERT phieunhap (tongtien,ngaynhap) VALUES (?,?) ";
            PreparedStatement pst=con.prepareStatement(sql);
            pst.setInt(1, t.getTongtien());
            pst.setDate(2, t.getNgaynhap());
            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("có lỗi xảy ra, không thể insert phiếu nhập");
            e.printStackTrace();
        }
        return ketqua;
    }
	public int insertCONOINHAP(PHIEUNHAP t,NHANVIEN nv) {
		int mahoadon = 0;
        try {
            Connection con=JDBCUtil.getConnection();
            String sql="INSERT phieunhap (manv,noinhap,tongtien,ngaynhap) VALUES (?,?,?,?) ";
                        PreparedStatement pst = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			pst.setInt(1, nv.getManv());
			pst.setString(2, t.getNoinhap());
            pst.setInt(3, t.getTongtien());
            pst.setDate(4, t.getNgaynhap());
            			pst.executeUpdate();
                        ResultSet generatedKeys = pst.getGeneratedKeys();
                        if (generatedKeys.next()) {
                            mahoadon = generatedKeys.getInt(1);
                        }
            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("có lỗi xảy ra, không thể insert phiếu nhập");
            e.printStackTrace();
        }
        return mahoadon;
    }
	public int insertKONOINHAP(PHIEUNHAP t,NHANVIEN nv) {
        int ketqua=0;
        try {
            Connection con=JDBCUtil.getConnection();
            String sql="INSERT phieunhap (manv,tongtien,ngaynhap) VALUES (?,?,?) ";
            PreparedStatement pst=con.prepareStatement(sql);
			pst.setInt(1, nv.getManv());
            pst.setInt(2, t.getTongtien());
            pst.setDate(3, t.getNgaynhap());
            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("có lỗi xảy ra, không thể insert phiếu nhập");
            e.printStackTrace();
        }
        return ketqua;
    }

    @Override
    public int update(PHIEUNHAP t) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }
//KHI DELETE THÌ SẢN PHẨM NHẬP SẼ GIẢM SỐ LƯỢNG
    @Override
    public int delete(PHIEUNHAP t) {
		int ketqua=0;
		try {
			Connection con=JDBCUtil.getConnection();
			String sqlKho="SELECT MASACH,SOLUONG FROM phieunhap,chitietphieunhap "+
						"WHERE phieunhap.mapn=chitietphieunhap.mapn AND phieunhap.mapn=?";
			PreparedStatement pst1=con.prepareStatement(sqlKho);
			pst1.setInt(1, t.getMapn());
			ResultSet rs=pst1.executeQuery();
			while(rs.next()) {
				int MASACH=rs.getInt("MASACH");
				int SOLUONG=rs.getInt("SOLUONG");
				SACH kho=new SACH(MASACH);
				SACHDAO.getInstance().muaSACH(kho,SOLUONG);
			}
			
			
			
			String sql="DELETE from  phieunhap  "+
					" WHERE mapn=?";
			
			PreparedStatement pst=con.prepareStatement(sql);
			
			pst.setInt(1,t.getMapn());
			
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
    public ArrayList selectAll() {
		ArrayList<PHIEUNHAP> ketqua=new ArrayList<PHIEUNHAP>();
		try {
			Connection con=JDBCUtil.getConnection();
			
			String sql=" SELECT * FROM phieunhap ";
			
			PreparedStatement pst=con.prepareStatement(sql);
			
			
			ResultSet rs=pst.executeQuery();
			while(rs.next()) {
				int mapn=rs.getInt("mapn");
				int manv=rs.getInt("manv");
				String noinhap=rs.getString("noinhap");
                int tongtien=rs.getInt("tongtien");
                Date ngaynhap=rs.getDate("ngaynhap");
                PHIEUNHAP pn=new PHIEUNHAP(mapn,manv,noinhap,tongtien,ngaynhap);
				ketqua.add(pn);
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
    public PHIEUNHAP selectById(PHIEUNHAP t) {
		PHIEUNHAP ketqua=null;
		try {
			Connection con=JDBCUtil.getConnection();
			
			String sql=" SELECT * FROM phieunhap "+
					"WHERE mapn=?";
			PreparedStatement pst=con.prepareStatement(sql);
			pst.setInt(1,t.getMapn());
			
			ResultSet rs=pst.executeQuery();
			while(rs.next()) {
				int mapn=rs.getInt("mapn");
				int manv=rs.getInt("manv");
				String noinhap=rs.getString("noinhap");
                int tongtien=rs.getInt("tongtien");
                Date ngaynhap=rs.getDate("ngaynhap");
                PHIEUNHAP pn=new PHIEUNHAP(mapn,manv,noinhap,tongtien,ngaynhap);
				ketqua=pn;
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
		ArrayList<PHIEUNHAP> ketqua=new ArrayList<PHIEUNHAP>();
		try {
			Connection con=JDBCUtil.getConnection();
			
			String sql=" SELECT * FROM phieunhap "+
					"WHERE "+condition;
			
			Statement pst=con.createStatement();
			
			
			ResultSet rs=pst.executeQuery(sql);
			while(rs.next()) {
				int mapn=rs.getInt("mapn");
				int manv=rs.getInt("manv");
				String noinhap=rs.getString("noinhap");
                int tongtien=rs.getInt("tongtien");
                Date ngaynhap=rs.getDate("ngaynhap");
                PHIEUNHAP pn=new PHIEUNHAP(mapn,manv,noinhap,tongtien,ngaynhap);
				ketqua.add(pn);
			}
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.print("co loi xay ra, thuc hien cau lenh khong thanh cong o selectByCondition class HOADONDAO \n");
			e.printStackTrace();
		}
		return ketqua;
    }
    
}
