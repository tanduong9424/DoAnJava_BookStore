package Dao;

import Dto.CHITIETPHIEUNHAP;
import Dto.PHIEUNHAP;
import Dto.SACH;
import conDatabase.JDBCUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;




public class CHITIETPHIEUNHAPDAO implements DAOInterface<CHITIETPHIEUNHAP>{
    
        public static CHITIETPHIEUNHAPDAO getInstance() {
		return new CHITIETPHIEUNHAPDAO();
	}
//thêm số lượng vào sách
    @Override
    public int insert(CHITIETPHIEUNHAP t) {
		int ketqua=0;
		try {
			Connection con=JDBCUtil.getConnection();

//			String sqlKho="SELECT MASACH,SOLUONG FROM phieunhap,chitietphieunhap "+
//						"WHERE phieunhap.mapn=chitietphieunhap.mapn AND phieunhap.mapn=?";
//			PreparedStatement pst1=con.prepareStatement(sqlKho);
//			pst1.setInt(1, t.getMapn());
//			ResultSet rs=pst1.executeQuery();
//			while(rs.next()) {
//				int MASACH=rs.getInt("MASACH");
//				int SOLUONG=rs.getInt("SOLUONG");
//				SACH kho=new SACH(MASACH);
//				SACHDAO.getInstance().thuhoiSACH(kho,SOLUONG);
//			}


			String sql="INSERT INTO chitietphieunhap (mapn,MASACH,gianhap,soluong,tongtien) "+
					" VALUES (?,?,?,?,?)";
			
			PreparedStatement pst=con.prepareStatement(sql);
			pst.setInt(1, t.getMapn());
			pst.setInt(2, t.getMASACH());
			pst.setInt(3, t.getGianhap());
			pst.setInt(4, t.getSoluong());
			pst.setInt(5, t.getTongtien());
			
			ketqua=pst.executeUpdate();
			System.out.print("thuc hien cau lenh"+sql+"\n");
			System.out.print("them CHITIETPHIEUNHAP thanh cong");
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.print("co loi xay ra, thuc hien cau lenh khong thanh cong o insert() class CHITIETHOADONDAO \n");
			e.printStackTrace();
		}
		return ketqua;
    }

    @Override
    public int update(CHITIETPHIEUNHAP t) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public int delete(CHITIETPHIEUNHAP t) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public ArrayList selectAll() {
		ArrayList<CHITIETPHIEUNHAP> ketqua=new ArrayList<CHITIETPHIEUNHAP>();
		try {
			Connection con=JDBCUtil.getConnection();
			String sql="SELECT * FROM chitietphieunhap";
			
			PreparedStatement pst=con.prepareStatement(sql);
			ResultSet rs=pst.executeQuery();
			while(rs.next()) {
				int mapn=rs.getInt("mapn");
                int MASACH=rs.getInt("MASACH");
				int gianhap=rs.getInt("gianhap");
                int soluong=rs.getInt("soluong");
                int tongtien=rs.getInt("tongtien");
                CHITIETPHIEUNHAP ctpn= new CHITIETPHIEUNHAP(mapn,MASACH,gianhap,soluong,tongtien);
				ketqua.add(ctpn);
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
    public ArrayList selectAllByPHIEUNHAP(PHIEUNHAP t) {
		ArrayList<CHITIETPHIEUNHAP> ketqua=new ArrayList<CHITIETPHIEUNHAP>();
		try {
			Connection con=JDBCUtil.getConnection();
			String sql="SELECT * FROM chitietphieunhap WHERE mapn=?";
			
			PreparedStatement pst=con.prepareStatement(sql);
                        pst.setInt(1, t.getMapn());
			ResultSet rs=pst.executeQuery();
			while(rs.next()) {
				int mapn=rs.getInt("mapn");
                int MASACH=rs.getInt("MASACH");
				int gianhap=rs.getInt("gianhap");
                int soluong=rs.getInt("soluong");
                int tongtien=rs.getInt("tongtien");
                CHITIETPHIEUNHAP ctpn= new CHITIETPHIEUNHAP(mapn,MASACH,gianhap,soluong,tongtien);
				ketqua.add(ctpn);
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
    public CHITIETPHIEUNHAP selectById(CHITIETPHIEUNHAP t) {
		CHITIETPHIEUNHAP ketqua=null;
		try {
			Connection con=JDBCUtil.getConnection();
			String sql="SELECT * FROM chitietphieunhap"+
                "WHERE mapn=?";
			
			PreparedStatement pst=con.prepareStatement(sql);
                        pst.setInt(1, t.getMapn());
			ResultSet rs=pst.executeQuery();
			while(rs.next()) {
				int mapn=rs.getInt("mapn");
                int MASACH=rs.getInt("MASACH");
				int gianhap=rs.getInt("gianhap");
                int soluong=rs.getInt("soluong");
                int tongtien=rs.getInt("tongtien");
                CHITIETPHIEUNHAP ctpn= new CHITIETPHIEUNHAP(mapn,MASACH,gianhap,soluong,tongtien);
				ketqua=ctpn;
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
    public ArrayList selectByCondition(String condition) {
		ArrayList<CHITIETPHIEUNHAP> ketqua=new ArrayList<CHITIETPHIEUNHAP>();
		try {
			Connection con=JDBCUtil.getConnection();
			
			String sql=" SELECT * FROM chitietphieunhap "+
					"WHERE "+condition;
			
			Statement pst=con.createStatement();
			
			
			ResultSet rs=pst.executeQuery(sql);
			while(rs.next()) {
				int mapn=rs.getInt("mapn");
                int MASACH=rs.getInt("MASACH");
				int gianhap=rs.getInt("gianhap");
                int soluong=rs.getInt("soluong");
                int tongtien=rs.getInt("tongtien");
                CHITIETPHIEUNHAP ctpn= new CHITIETPHIEUNHAP(mapn,MASACH,gianhap,soluong,tongtien);
				ketqua.add(ctpn);
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
