
package Dao;

import Dao.DAOInterface;
import Dao.SACHDAO;
import Dto.HOADON;
import Dto.KHACHANG;
import Dto.KHUYENMAI;
import Dto.NHANVIEN;
import Dto.SACH;
import Dto.TAIKHOAN;
import conDatabase.JDBCUtil;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;



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
	public int insertHOADONCOTKCOMAKM(HOADON t,KHACHANG kh,KHUYENMAI km,NHANVIEN nv) {
		int mahoadon = 0;
		try {
			Connection con=JDBCUtil.getConnection();
			String sql="INSERT INTO hoadon (makh,manv,NGAYLAP,TONGTIEN,makhuyenmai,tthd) "+
			"VALUES (?,?,?,?,?,?)";
                        PreparedStatement pst = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			pst.setInt(1, kh.getMakh());
			pst.setInt(2, nv.getManv());
			pst.setDate(3, t.getNGAYLAP());
			pst.setInt(4, t.getTONGTIEN()*(100-km.getPhantramgiam())/100);
			pst.setInt(5, km.getMakhuyenmai());
			pst.setBoolean(6, false);
			pst.executeUpdate();
                        ResultSet generatedKeys = pst.getGeneratedKeys();
                        if (generatedKeys.next()) {
                            mahoadon = generatedKeys.getInt(1);
                        }
			JDBCUtil.closeConnection(con);
		}
		catch (SQLException e){
			// TODO Auto-generated catch block
			System.out.print("co loi xay ra, thuc hien cau lenh khong thanh cong o insert() class HOADONDAO \n");
			e.printStackTrace();
		}
		return mahoadon;
	}
	public int insertHOADONKHONGTKCOMAKM(HOADON t,NHANVIEN nv) {
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
	public int insertHOADONCOTKKOMAKM(HOADON t,KHACHANG tk,NHANVIEN nv) {
		int mahoadon = 0;
		try {
			Connection con=JDBCUtil.getConnection();
			String sql="INSERT INTO hoadon (makh,manv,NGAYLAP,TONGTIEN,tthd) "+
			"VALUES (?,?,?,?,?)";
                        PreparedStatement pst = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			pst.setInt(1, tk.getMakh());
			pst.setInt(2, nv.getManv());
			pst.setDate(3, t.getNGAYLAP());
			pst.setInt(4, t.getTONGTIEN());
			pst.setBoolean(5, t.isTthd());
			pst.executeUpdate();
                        ResultSet generatedKeys = pst.getGeneratedKeys();
                        if (generatedKeys.next()) {
                            mahoadon = generatedKeys.getInt(1);
                        }
			JDBCUtil.closeConnection(con);
		}
		catch (SQLException e){
			// TODO Auto-generated catch block
			System.out.print("co loi xay ra, thuc hien cau lenh khong thanh cong o insert() class HOADONDAO \n");
			e.printStackTrace();
		}
		return mahoadon;
	}
        public int insertHOADONKHONGTKKOMAKM(HOADON t, NHANVIEN nv) {
            int mahoadon = 0;
            try {
                Connection con = JDBCUtil.getConnection();
                String sql = "INSERT INTO hoadon (manv, NGAYLAP, TONGTIEN, tthd) VALUES (?, ?, ?, ?)";
                PreparedStatement pst = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                pst.setInt(1, nv.getManv());
                pst.setDate(2, t.getNGAYLAP());
                pst.setInt(3, t.getTONGTIEN());
                pst.setBoolean(4, t.isTthd());
                pst.executeUpdate();

                ResultSet generatedKeys = pst.getGeneratedKeys();
                if (generatedKeys.next()) {
                    mahoadon = generatedKeys.getInt(1);
                }

                JDBCUtil.closeConnection(con);
            } catch (SQLException e) {
                System.out.print("Có lỗi xảy ra khi thực hiện câu lệnh SQL.");
                e.printStackTrace();
            }
            return mahoadon;
        }

// hoa don khong thay doi
	@Override
	public int update(HOADON t) {
		// TODO Auto-generated method stub
		return 0;
	}

        public int updateHOANTHANH(HOADON t) {
            int ketqua = 0;
            try {
                Connection con = JDBCUtil.getConnection();
                String sql = "UPDATE hoadon SET tthd=? WHERE MAHOADON=?";
                PreparedStatement pst = con.prepareStatement(sql);
                pst.setBoolean(1, true);
                pst.setInt(2, t.getMAHOADON());
                ketqua = pst.executeUpdate();
                JDBCUtil.closeConnection(con);
            } catch (SQLException e) {
                System.out.print("Có lỗi xảy ra, thực hiện câu lệnh không thành công trong phương thức updateHOANTHANH() của lớp HOADONDAO \n");
                e.printStackTrace();
            }
            return ketqua;
        }

        	public int updateCHUAHOANTHANH(HOADON t) {
		int ketqua=0;
		try {
			Connection con=JDBCUtil.getConnection();
                        String sql = "UPDATE hoadon SET tthd=? WHERE MAHOADON=?";

			PreparedStatement pst =con.prepareStatement(sql);
			pst.setBoolean(1, false);
			pst.setInt(2, t.getMAHOADON());
			ketqua=pst.executeUpdate();
			JDBCUtil.closeConnection(con);
		}
		catch (SQLException e){
			// TODO Auto-generated catch block
			System.out.print("co loi xay ra, thuc hien cau lenh khong thanh cong o updatehuahoanthanh() class HOADONDAO \n");
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
                        if(t.isTthd()==true){
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
			System.out.print("\nco loi xay ra, thuc hien cau lenh khong thanh cong o delete() class HOADONDAO \n");
			e.printStackTrace();
		}
		return 0;
	}
	public int XacNhanHoaDon(HOADON t) {
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
				SACH sach=new SACH(MASACH);
				SACHDAO.getInstance().muaSACH(sach,SOLUONG);
			}
			
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.print("\nco loi xay ra, thuc hien cau lenh khong thanh cong o delete() class HOADONDAO \n");
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
				int makh=rs.getInt("makh");
				int manv=rs.getInt("manv");
				Date NGAYLAP=rs.getDate("NGAYLAP");
				int TONGTIEN=rs.getInt("TONGTIEN");
				int makhuyenmai=rs.getInt("makhuyenmai");
				boolean tthd=rs.getBoolean("tthd");
				HOADON hoadon=new HOADON(MAHOADON,makh,manv,NGAYLAP,TONGTIEN,makhuyenmai,tthd);
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
				int makh=rs.getInt("makh");
				int manv=rs.getInt("manv");
				Date NGAYLAP=rs.getDate("NGAYLAP");
				int TONGTIEN=rs.getInt("TONGTIEN");
				int makhuyenmai=rs.getInt("makhuyenmai");
				boolean tthd=rs.getBoolean("tthd");
				HOADON hoadon=new HOADON(MAHOADON,makh,manv,NGAYLAP,TONGTIEN,makhuyenmai,tthd);
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
				int makh=rs.getInt("makh");
				int manv=rs.getInt("manv");
				Date NGAYLAP=rs.getDate("NGAYLAP");
				int TONGTIEN=rs.getInt("TONGTIEN");
				int makhuyenmai=rs.getInt("makhuyenmai");
				boolean tthd=rs.getBoolean("tthd");
				HOADON hoadon=new HOADON(MAHOADON,makh,manv,NGAYLAP,TONGTIEN,makhuyenmai,tthd);
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
			System.out.print("hoat dong selectbyid"+t.getMAHOADON());
			String sql=" SELECT * FROM hoadon "+
					"WHERE MAHOADON=?";
			PreparedStatement pst=con.prepareStatement(sql);
			pst.setInt(1,t.getMAHOADON());
			
			ResultSet rs=pst.executeQuery();
			while(rs.next()) {
				int MAHOADON=rs.getInt("MAHOADON");
				int makh=rs.getInt("makh");
				int manv=rs.getInt("manv");
				Date NGAYLAP=rs.getDate("NGAYLAP");
				int TONGTIEN=rs.getInt("TONGTIEN");
				int makhuyenmai=rs.getInt("makhuyenmai");
				boolean tthd=rs.getBoolean("tthd");
				HOADON hoadon=new HOADON(MAHOADON,makh,manv,NGAYLAP,TONGTIEN,makhuyenmai,tthd);
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
				int makh=rs.getInt("makh");
				int manv=rs.getInt("manv");
				Date NGAYLAP=rs.getDate("NGAYLAP");
				int TONGTIEN=rs.getInt("TONGTIEN");
				int makhuyenmai=rs.getInt("makhuyenmai");
				boolean tthd=rs.getBoolean("tthd");
				HOADON hoadon=new HOADON(MAHOADON,makh,manv,NGAYLAP,TONGTIEN,makhuyenmai,tthd);
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
        public int selectMaKHChitieu(KHACHANG t) {
		int ketqua=0;
                
		try {
                        Connection con=JDBCUtil.getConnection();
			String sql=" SELECT SUM(TONGTIEN) AS TONGTIEN    FROM hoadon   WHERE makh = ? AND tthd =1;";
			PreparedStatement pst=con.prepareStatement(sql);
			pst.setInt(1,t.getMakh());
			ResultSet rs=pst.executeQuery();
                        rs = pst.executeQuery();
                        // Kiểm tra xem ResultSet có dữ liệu không
                        while (rs.next()) {
                            // Lấy giá trị SUM từ cột TONGTIEN trong kết quả của câu truy vấn
                            ketqua = rs.getInt("TONGTIEN");
                        }
                        System.out.print(ketqua);
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.print("co loi xay ra, thuc hien cau lenh khong thanh cong o selectAll class HOADONDAO \n");
			e.printStackTrace();
		}
		return ketqua;
	}
        public int selectMaNVDoanhthu(NHANVIEN t) {
		int ketqua=0;
                
		try {
                        Connection con=JDBCUtil.getConnection();
			String sql=" SELECT SUM(TONGTIEN) AS TONGTIEN    FROM hoadon   WHERE manv = ? AND tthd =1;";
			PreparedStatement pst=con.prepareStatement(sql);
			pst.setInt(1,t.getManv());
			ResultSet rs=pst.executeQuery();
                        rs = pst.executeQuery();
                        // Kiểm tra xem ResultSet có dữ liệu không
                        while (rs.next()) {
                            // Lấy giá trị SUM từ cột TONGTIEN trong kết quả của câu truy vấn
                            ketqua = rs.getInt("TONGTIEN");
                        }
                        System.out.print(ketqua);
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.print("co loi xay ra, thuc hien cau lenh khong thanh cong o selectAll class HOADONDAO \n");
			e.printStackTrace();
		}
		return ketqua;
	}
        public int selectTongTien(){
            int ketqua=0;
            try {
                        Connection con=JDBCUtil.getConnection();
			String sql=" SELECT SUM(TONGTIEN) AS TONGTIEN    FROM hoadon   WHERE tthd =1;";
			PreparedStatement pst=con.prepareStatement(sql);
			ResultSet rs=pst.executeQuery();
                        rs = pst.executeQuery();
                        // Kiểm tra xem ResultSet có dữ liệu không
                        while (rs.next()) {
                            // Lấy giá trị SUM từ cột TONGTIEN trong kết quả của câu truy vấn
                            ketqua = rs.getInt("TONGTIEN");
                        }
                        System.out.print(ketqua);
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.print("co loi xay ra, thuc hien cau lenh khong thanh cong o selectAll class HOADONDAO \n");
			e.printStackTrace();
		}
		return ketqua;
	}
        public HOADON selectHoaDonMax(String nhapngay1MAX, String nhapngay2MAX){
            HOADON ketqua =null ;
            try {
                        Connection con=JDBCUtil.getConnection();
			String sql=" SELECT *  FROM hoadon  WHERE tthd =1 AND NGAYLAP BETWEEN ? AND ?  ORDER BY TONGTIEN DESC LIMIT 1;";
			PreparedStatement pst=con.prepareStatement(sql);
			pst.setString(1,nhapngay1MAX);
			pst.setString(2,nhapngay2MAX);
			ResultSet rs=pst.executeQuery();
			while(rs.next()) {
				int MAHOADON=rs.getInt("MAHOADON");
				int makh=rs.getInt("makh");
				int manv=rs.getInt("manv");
				Date NGAYLAP=rs.getDate("NGAYLAP");
				int TONGTIEN=rs.getInt("TONGTIEN");
				int makhuyenmai=rs.getInt("makhuyenmai");
				boolean tthd=rs.getBoolean("tthd");
				HOADON hoadon=new HOADON(MAHOADON,makh,manv,NGAYLAP,TONGTIEN,makhuyenmai,tthd);
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
        public ArrayList<HOADON> selectHoaDonMax2(){
            ArrayList<HOADON> ketqua=new ArrayList<HOADON>();
            try {
                        Connection con=JDBCUtil.getConnection();
			String sql=" SELECT *  FROM hoadon  WHERE tthd =1 ORDER BY TONGTIEN DESC LIMIT 1;";
			PreparedStatement pst=con.prepareStatement(sql);
			ResultSet rs=pst.executeQuery();
			while(rs.next()) {
				int MAHOADON=rs.getInt("MAHOADON");
				int makh=rs.getInt("makh");
				int manv=rs.getInt("manv");
				Date NGAYLAP=rs.getDate("NGAYLAP");
				int TONGTIEN=rs.getInt("TONGTIEN");
				int makhuyenmai=rs.getInt("makhuyenmai");
				boolean tthd=rs.getBoolean("tthd");
				HOADON hoadon=new HOADON(MAHOADON,makh,manv,NGAYLAP,TONGTIEN,makhuyenmai,tthd);
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
        public double selectHoaDonTB(String nhapngay1TB, String nhapngay2TB){
            double ketqua = 0 ;
            try {
                        Connection con=JDBCUtil.getConnection();
			String sql=" SELECT AVG(TONGTIEN) AS TRUNGBINH_TONGTIEN   FROM hoadon  WHERE tthd=1 AND NGAYLAP BETWEEN ? AND ?;";
			PreparedStatement pst=con.prepareStatement(sql);
			pst.setString(1,nhapngay1TB);
			pst.setString(2,nhapngay2TB);
			ResultSet rs=pst.executeQuery();
			while (rs.next()) {
                            // Lấy giá trị SUM từ cột TONGTIEN trong kết quả của câu truy vấn
                            ketqua = rs.getDouble("TRUNGBINH_TONGTIEN");
                        }
                        System.out.print(ketqua);
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.print("co loi xay ra, thuc hien cau lenh khong thanh cong o selectAll class HOADONDAO \n");
			e.printStackTrace();
		}
		return ketqua;
	}
        public double selectHoaDonTB2() {
            double ketqua = 0;
            try {
                Connection con = JDBCUtil.getConnection();
                String sql = "SELECT AVG(TONGTIEN) AS TRUNGBINH_TONGTIEN FROM hoadon WHERE tthd=1;";
                PreparedStatement pst = con.prepareStatement(sql);
                ResultSet rs = pst.executeQuery();
                if (rs.next()) {
                    // Di chuyển con trỏ đến hàng đầu tiên và lấy giá trị từ cột TRUNGBINH_TONGTIEN
                    ketqua = rs.getDouble("TRUNGBINH_TONGTIEN");
                }
                System.out.print(ketqua);
                JDBCUtil.closeConnection(con);
            } catch (SQLException e) {
                System.out.print("Có lỗi xảy ra khi thực hiện câu lệnh không thành công trong lớp HOADONDAO \n");
                e.printStackTrace();
            }
            return ketqua;
        }

}
