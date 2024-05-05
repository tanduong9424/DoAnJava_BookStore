package Dao;

import Dto.KHACHANG;
import Dto.NHANVIEN;
import Dto.TAIKHOAN;
import conDatabase.JDBCUtil;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;



public class NHANVIENDAO implements DAOInterface<NHANVIEN>{
    public static NHANVIENDAO getInstance() {
		return new NHANVIENDAO();
	}
    @Override
    public int insert(NHANVIEN t) {//không có tài khoản
        int ketqua=0;
        try {
            Connection con=JDBCUtil.getConnection();
            String sql="INSERT INTO nhanvien (hoten,diachi,email,dienthoai,tttk) VALUES (?,?,?,?,?)";
            PreparedStatement pst=con.prepareStatement(sql);
            pst.setString(1, t.getHoten());
            pst.setString(2, t.getDiachi());
            pst.setString(3, t.getEmail());
            pst.setInt(4, t.getDienthoai());
            pst.setBoolean(5, t.isTttk());
            ketqua=pst.executeUpdate();
			JDBCUtil.closeConnection(con);
            return ketqua;

        } catch (Exception e) {
            System.out.println("updateCOTK");
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

            String sql="UPDATE nhanvien SET hoten=?,diachi=?,email=?,dienthoai=?,tttk=? WHERE manv=?";
            PreparedStatement pst=con.prepareStatement(sql);
            pst.setString(1, t.getHoten());
            pst.setString(2, t.getDiachi());
            pst.setString(3, t.getEmail());
            pst.setInt(4, t.getDienthoai());
            pst.setBoolean(5, t.isTttk());
            pst.setInt(6, t.getManv());
            ketqua=pst.executeUpdate();
			JDBCUtil.closeConnection(con);

        } catch (Exception e) {
            System.out.println("có lỗi xảy ra, không thể update nhân viên");
            e.printStackTrace();
        }
        return ketqua;
    }

    @Override
    public int delete(NHANVIEN t) {
        int ketqua=0;
        try {
            Connection con=JDBCUtil.getConnection();

            String sqlCheck1 = "SELECT * FROM hoadon WHERE manv = ?";
			PreparedStatement pstCheck1 = con.prepareStatement(sqlCheck1);
			pstCheck1.setInt(1, t.getManv());
			ResultSet rs1 = pstCheck1.executeQuery();
	
			if (rs1.next()) {
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
            String sqlCheck2 = "SELECT * FROM phieunhap WHERE manv = ?";
			PreparedStatement pstCheck2 = con.prepareStatement(sqlCheck2);
			pstCheck2.setInt(1, t.getManv());
			ResultSet rs2 = pstCheck2.executeQuery();
	
			if (rs2.next()) {
				// Nếu có, in ra thông báo và trả về một giá trị ngay tại thời điểm đó mà không tiếp tục thực hiện các lệnh SQL tiếp theo
				System.out.println("NHÂN VIÊN đã tồn tại trong phiếu nhập, không thể xóa.");
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
            System.out.println("có lỗi xảy ra, không thể  nhân viên");
            e.printStackTrace();
        }
        return ketqua;
    }

    @Override
    public ArrayList selectAll() {
        ArrayList<NHANVIEN> ketqua=new ArrayList<NHANVIEN>();
		try {
			Connection con=JDBCUtil.getConnection();
			
			String sql=" SELECT * FROM nhanvien WHERE tttk=true";
			
			PreparedStatement pst=con.prepareStatement(sql);
			
			
			ResultSet rs=pst.executeQuery();
			while(rs.next()) {
				int manv=rs.getInt("manv");	
                                String hoten=rs.getString("hoten");	
                                String diachi=rs.getString("diachi");	
                                String email=rs.getString("email");	
                                int dienthoai=rs.getInt("dienthoai");		
                                boolean tttk=rs.getBoolean("tttk");	
				NHANVIEN nv=new NHANVIEN(manv,hoten,diachi,email,dienthoai,tttk);
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
			
			String sql=" SELECT * FROM nhanvien WHERE manv=? AND tttk=true";
			
			PreparedStatement pst=con.prepareStatement(sql);
			pst.setInt(1, t.getManv());
			
			ResultSet rs=pst.executeQuery();
			while(rs.next()) {
				int manv=rs.getInt("manv");	
                                String hoten=rs.getString("hoten");	
                                String diachi=rs.getString("diachi");	
                                String email=rs.getString("email");	
                                int dienthoai=rs.getInt("dienthoai");		
                                boolean tttk=rs.getBoolean("tttk");	
				NHANVIEN nv=new NHANVIEN(manv,hoten,diachi,email,dienthoai,tttk);
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
                                String hoten=rs.getString("hoten");	
                                String diachi=rs.getString("diachi");	
                                String email=rs.getString("email");	
                                int dienthoai=rs.getInt("dienthoai");		
                                boolean tttk=rs.getBoolean("tttk");	
				NHANVIEN nv=new NHANVIEN(manv,hoten,diachi,email,dienthoai,tttk);
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
    public ArrayList getIDnv() {
        ArrayList<Integer> IDnv=new ArrayList<Integer>();
		try {
			Connection con=JDBCUtil.getConnection();
			
			String sql=" SELECT manv FROM nhanvien WHERE tttk=true";
			
			PreparedStatement pst=con.prepareStatement(sql);
			
			
			ResultSet rs=pst.executeQuery();
			while(rs.next()) {
				int manv=rs.getInt("manv");	
				IDnv.add(manv);
			}
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.print("co loi xay ra, thuc hien cau lenh khong thanh cong o selectIDnv class NHANVIENDAO \n");
			e.printStackTrace();
		}
		return IDnv;
    }

    public NHANVIEN SearchNVByID(TAIKHOAN t) {
       NHANVIEN kq=null;
       
       try{
           Connection con=JDBCUtil.getConnection();
           String sql="SELECT * FROM nhanvien WHERE manv=? AND tttk=true";
           PreparedStatement pst=con.prepareStatement(sql);
           pst.setInt(1,t.getMANV());
           ResultSet rs=pst.executeQuery();
           while(rs.next()){
               int makh=rs.getInt("manv");
               String hoten=rs.getString("hoten");
               String diachi=rs.getString("diachi");
               int dienthoai=rs.getInt("dienthoai");
               String email=rs.getString("email");
               Boolean tttk =rs.getBoolean("tttk");
               NHANVIEN tmp=new NHANVIEN(makh,hoten,diachi,email,dienthoai,tttk);
               kq=tmp;
           }
       }catch(SQLException e){
           e.printStackTrace();
           System.out.print("co loi o getkhFromTK");
       }
       return kq;
    }
    public ArrayList<NHANVIEN> timkiemNangCao(String input, String type) {
        ArrayList<NHANVIEN> ketqua = new ArrayList<>();
        String sql;
        try {
            Connection con = JDBCUtil.getConnection();
            PreparedStatement pst = null;
            switch (type) {
                case "Mã Nhân Viên":
                    sql = "SELECT * FROM nhanvien WHERE CAST(manv AS VARCHAR(20)) LIKE ? AND tttk=true";
                    pst = con.prepareStatement(sql);
                    pst.setString(1, "%" + input + "%");
                    break;
                case "Tên Nhân Viên":
                    sql = "SELECT * FROM nhanvien WHERE LOWER(hoten) LIKE ? AND tttk=true";
                    pst = con.prepareStatement(sql);
                    pst.setString(1, "%" + input.toLowerCase() + "%");
                    break;
                case "Địa Chỉ":
                    sql = "SELECT * FROM nhanvien WHERE LOWER(diachi) LIKE ? AND tttk=true";
                    pst = con.prepareStatement(sql);
                    pst.setString(1, "%" + input.toLowerCase() + "%");
                    break;
                case "Số Điện Thoại":
                    sql = "SELECT * FROM nhanvien WHERE CAST(dienthoai AS VARCHAR(20)) LIKE ? AND tttk=true";
                    pst = con.prepareStatement(sql);
                    pst.setString(1, "%" + input + "%");
                    break;
                case "Email":
                    sql = "SELECT * FROM nhanvien WHERE LOWER(email) LIKE ? AND tttk=true";
                    pst = con.prepareStatement(sql);
                    pst.setString(1, "%" + input.toLowerCase() + "%");
                    break;
            }
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                int manv = rs.getInt("manv");
                String hoten = rs.getString("hoten");
                String diachi = rs.getString("diachi");
                String email = rs.getString("email");
                int dienthoai = rs.getInt("dienthoai");
                boolean tttk = rs.getBoolean("tttk");
                NHANVIEN nhanVien = new NHANVIEN(manv, hoten, diachi, email, dienthoai, tttk);
                ketqua.add(nhanVien);
            }
            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            System.out.print("co loi o timkiemnangcao NHANVIENDAO\n");
            e.printStackTrace();
        }
        return ketqua;
    }
}
