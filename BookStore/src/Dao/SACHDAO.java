package Dao;

import Dto.SACH;
import conDatabase.JDBCUtil;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class SACHDAO implements DAOInterface<SACH> {
	
	public static SACHDAO getInstance() {
//		HAM CHECK NEU CO 1 THANH PHAN TRONG SACH CO ISHIDDEN
		//FUNCTION
		checkSACH();
		return new SACHDAO();
	}
	public static int checkSACH() {
		int ketqua=0;
		try {
			Connection con=JDBCUtil.getConnection();
			
			String sql = "UPDATE sach " +
		             " SET ISHIDDEN=true " +
		             " WHERE TENNHAXUATBAN IN (SELECT TENNHAXUATBAN FROM nhaxuatban WHERE ISHIDDEN=true)";

			
			PreparedStatement pst=con.prepareStatement(sql);
						
			ketqua=pst.executeUpdate();
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.print("\nco loi xay ra, thuc hien cau lenh khong thanh cong o checkSACH() class SACH \n");
			e.printStackTrace();
		}
		return 0;
	}
//can them sach vao kho
	@Override
	public int insert(SACH t) {
		int ketqua=0;
	// 	try {
	// 		Connection con=JDBCUtil.getConnection();
	// 		ArrayList<SACH> dathem=SACHDAO.getInstance().selectByCondition("TENSACH="+t.getTENSACH()+" MATACGIA="+t.getMATACGIA()+" TENLINHVUC="+t.getTENLINHVUC()+" TENLOAISACH="+t.getTENLOAISACH()+" GIABIA="+t.getGIABIA()+" GIAMUA="+t.getGIAMUA()+" LANTAIBAN="+t.getLANTAIBAN()+" TENNHAXUATBAN="+t.getTENNHAXUATBAN()+" NAMXUATBAN="+t.getNAMXUATBAN()+"ISHIDDEN=false");
	// 		if(dathem!=null) {
	// 			String sql="UPDATE sach "+
	// 					"SET ISHIDDEN=false"+
	// 					"WHERE TENSACH=? AND MATACGIA=? AND TENLINHVUC=? AND TENLOAISACH=? AND GIAMUA=? AND GIABIA=? AND LANTAIBAN=? AND TENNHAXUATBAN=? AND NAMXUATBAN=? AND ISHIDDEN=true";
	// 			PreparedStatement pst=con.prepareStatement(sql);
	// 			ketqua=pst.executeUpdate();
	// 			System.out.print("thuc hien cau lenh "+sql+"\n");
	// 			pst.setString(1,t.getTENSACH());
	// 			pst.setInt(2, t.getMATACGIA());
	// 			pst.setString(3,t.getTENLINHVUC());
	// 			pst.setString(4,t.getTENLOAISACH());
	// 			pst.setInt(5,t.getGIAMUA());
	// 			pst.setInt(6, t.getGIABIA());
	// 			pst.setInt(7,t.getLANTAIBAN());
	// 			pst.setString(8, t.getTENNHAXUATBAN());
	// 			pst.setDate(9,t.getNAMXUATBAN());
	// 		}
	// 		else {
	// 			ArrayList<SACH> dssach=SACHDAO.getInstance().selectAll();
	// 			int length=dssach.size();
				
	// 			String sql="INSERT INTO sach(MASACH,TENSACH,IMAGE,MATACGIA,TENLINHVUC,TENLOAISACH,GIAMUA,GIABIA,LANTAIBAN,TENNHAXUATBAN,NAMXUATBAN,NOIDUNG,ISHIDDEN"+
	// 					"VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
	// 			PreparedStatement pst=con.prepareStatement(sql);
	// //tac gia
	// 			ArrayList<TACGIA> list1=TACGIADAO.getInstance().selectAllExceptISHIDDEN();
	// 			int index1=0;
	// 			for(TACGIA lv :list1) {
	// 				System.out.print(index1+": "+lv.toString());
	// 				index1++;
	// 			}
	// 			System.out.print("\nChon ma tac gia ");
	// 			Scanner sc=new Scanner(System.in);
	// 			String choice=sc.nextLine();
	// 			while(isnumber(choice)==false) {
	// 				System.out.print("\nVui long nhap lua chon la so");
	// 				choice=sc.nextLine();
	// 			}
	// 			TACGIA tacgia1=list1.get((Integer.parseInt(choice)));
	// //ten linh vuc
	// 			ArrayList<LINHVUC> list2=LINHVUCDAO.getInstance().selectAllExceptISHIDDEN();
	// 			int index2=0;
	// 			for(LINHVUC lv :list2) {
	// 				System.out.print(index2+": "+lv.toString());
	// 				index2++;
	// 			}
	// 			System.out.print("\nChon linh vuc");
	// 			choice=sc.nextLine();
	// 			while(isnumber(choice)==false) {
	// 				System.out.print("\nVui long nhap lua chon la so");
	// 				choice=sc.nextLine();
	// 			}
	// 			LINHVUC linhvuc2=list2.get((Integer.parseInt(choice)));
	// //LOAI SACH
	// 			ArrayList<LOAISACH> list3=LOAISACHDAO.getInstance().selectAllExceptISHIDDEN();
	// 			int index3=0;
	// 			for(LOAISACH lv :list3) {
	// 				System.out.print(index3+": "+lv.toString());
	// 				index3++;
	// 			}
	// 			System.out.print("\nChon loai sach");
	// 			choice=sc.nextLine();
	// 			while(isnumber(choice)==false) {
	// 				System.out.print("\nVui long nhap lua chon la so");
	// 				choice=sc.nextLine();
	// 			}
	// 			LOAISACH loaisach3=list3.get((Integer.parseInt(choice)));
				
	// //NHA XUAT BAN
	// 			ArrayList<NHAXUATBAN> list4=NHAXUATBANDAO.getInstance().selectAllExceptISHIDDEN();
	// 			int index4=0;
	// 			for(NHAXUATBAN lv :list4) {
	// 				System.out.print(index4+": "+lv.toString());
	// 				index4++;
	// 			}
	// 			System.out.print("\nChon nha xuat ban");
	// 			choice=sc.nextLine();
	// 			while(isnumber(choice)==false) {
	// 				System.out.print("\nVui long nhap lua chon la so");
	// 				choice=sc.nextLine();
	// 			}
	// 			NHAXUATBAN nhaxuatban4=list4.get((Integer.parseInt(choice)));
				
	// 			ketqua=pst.executeUpdate();
	// 			System.out.print("thuc hien cau lenh "+sql+"\n");
	// 			pst.setString(1,Integer.toString(length+1));
	// 			pst.setString(2,t.getTENSACH());
	// 			pst.setString(3,t.getIMAGE());
	// 			pst.setInt(4, tacgia1.getMATACGIA());
	// 			pst.setString(5,linhvuc2.getTENLINHVUC());
	// 			pst.setString(6,loaisach3.getTENLOAISACH());
	// 			pst.setInt(7,t.getGIAMUA());
	// 			pst.setInt(8, t.getGIABIA());
	// 			pst.setInt(9,t.getLANTAIBAN());
	// 			pst.setString(10, nhaxuatban4.getTENNHAXUATBAN());
	// 			pst.setDate(11,t.getNAMXUATBAN());
	// 			pst.setString(12, t.getNOIDUNG());
	// 			pst.setBoolean(13, false);
	// 		}

			
	// 	}
	// 	catch(Exception e) {
	// 		// TODO Auto-generated catch block
	// 		System.out.print("co loi xay ra, thuc hien cau lenh khong thanh cong o insert class SACHDAO \n");
	// 		e.printStackTrace();
	// 	}
		return 0;
	}
	
//

public int insertSACH(SACH t) {
	int ketqua=0;
	try {
		Connection con=JDBCUtil.getConnection();
                ArrayList<SACH> dathem = SACHDAO.getInstance().selectByCondition("TENSACH='" + t.getTENSACH() + "' AND GIABIA=" + t.getGIABIA() + " AND LANTAIBAN=" + t.getLANTAIBAN() + " AND TENNHAXUATBAN='" + t.getTENNHAXUATBAN() + "' AND ISHIDDEN=true");
	
                if(!dathem.isEmpty()) {
			String sql="UPDATE sach "+
					"SET ISHIDDEN=false"+
					"WHERE MASACH=?";
			PreparedStatement pst=con.prepareStatement(sql);
			System.out.print("thuc hien cau lenh "+sql+"\n");
			pst.setInt(1,dathem.get(0).getMASACH());
			ketqua=pst.executeUpdate();
		}
		else{
                    String sql = "INSERT INTO sach(TENSACH, IMAGE, SOLUONG, GIABIA, LANTAIBAN, TENNHAXUATBAN, ISHIDDEN) " +
                                 "VALUES (?,?,?,?,?,?,?)";
                    PreparedStatement pst = con.prepareStatement(sql);
                    pst.setString(1, t.getTENSACH());
                    pst.setString(2, t.getIMAGE());
                    pst.setInt(3, 0);
                    pst.setInt(4, t.getGIABIA());
                    pst.setInt(5, t.getLANTAIBAN());
                    pst.setString(6, t.getTENNHAXUATBAN());
                    pst.setBoolean(7, false);
                    ketqua = pst.executeUpdate();


		}

		
	}
	catch(Exception e) {
		// TODO Auto-generated catch block
		System.out.print("co loi xay ra, thuc hien cau lenh khong thanh cong o insert class SACHDAO \n");
		e.printStackTrace();
	}
	return 0;
}


	@Override
	public int update(SACH t) {
		int ketqua = 0;
		try {
			Connection con = JDBCUtil.getConnection();
	
			// Kiểm tra xem có giá trị nào trong cột "MASACH" của bảng "chitietphieunhap" hoặc "chitiethoadon" giống với giá trị bạn đang cố gắng cập nhật không
			String sqlCheck = "SELECT * FROM chitietphieunhap WHERE MASACH = ? UNION SELECT * FROM chitiethoadon WHERE MASACH = ?";
			PreparedStatement pstCheck = con.prepareStatement(sqlCheck);
			pstCheck.setInt(1, t.getMASACH());
			pstCheck.setInt(2, t.getMASACH());
			ResultSet rs = pstCheck.executeQuery();
	
			if (rs.next()) {
				// Nếu có, in ra thông báo và trả về một giá trị ngay tại thời điểm đó mà không tiếp tục thực hiện các lệnh SQL tiếp theo
				System.out.println("SẢN PHẨM đã tồn tại trong hóa đơn hoặc phiếu nhập, không thể thay đổi.");
				return -1; // hoặc trả về một giá trị khác thích hợp
			}
	
			// Nếu không có giá trị nào giống, thực hiện cập nhật
			String sql = "UPDATE sach " + " SET " + " TENSACH=?, IMAGE=?,   GIABIA=?, LANTAIBAN=?, TENNHAXUATBAN=?" + " WHERE MASACH=?";
			
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, t.getTENSACH());
			pst.setString(2, t.getIMAGE());
			pst.setInt(3, t.getGIABIA());
			pst.setInt(4, t.getLANTAIBAN());
			pst.setString(5, t.getTENNHAXUATBAN());
			pst.setInt(6, t.getMASACH());
			ketqua = pst.executeUpdate();
			JDBCUtil.closeConnection(con);
		} catch(Exception e) {
			// TODO Auto-generated catch block
			System.out.print("\nCó lỗi xảy ra, thực hiện câu lệnh không thành công trong phương thức update() của lớp SACHDAO.\n");
			e.printStackTrace();
		}
		return ketqua;
	}
	public int updateTHEOCOT(SACH t,String column,String value) {
		int ketqua = 0;
		try {
			Connection con = JDBCUtil.getConnection();
	
			// Kiểm tra xem có giá trị nào trong cột "MASACH" của bảng "chitietphieunhap" hoặc "chitiethoadon" giống với giá trị bạn đang cố gắng cập nhật không
			String sqlCheck = "SELECT * FROM chitietphieunhap WHERE MASACH = ? UNION SELECT * FROM chitiethoadon WHERE MASACH = ?";
			PreparedStatement pstCheck = con.prepareStatement(sqlCheck);
			pstCheck.setInt(1, t.getMASACH());
			pstCheck.setInt(2, t.getMASACH());
			ResultSet rs = pstCheck.executeQuery();
	
			if (rs.next()) {
				// Nếu có, in ra thông báo và trả về một giá trị ngay tại thời điểm đó mà không tiếp tục thực hiện các lệnh SQL tiếp theo
				System.out.println("SẢN PHẨM đã tồn tại trong hóa đơn hoặc phiếu nhập, không thể thay đổi.");
				return -1; // hoặc trả về một giá trị khác thích hợp
			}
	
			// Nếu không có giá trị nào giống, thực hiện cập nhật
			String sql = "UPDATE sach " + " SET " + " ?=? " + " WHERE MASACH=?";
			
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, column);
			if(column.equals("GIABIA") || column.equals("LANTAIBAN")){
				int value1=Integer.parseInt(value);
				pst.setInt(2, value1);
			}
			else if(column.equals("SOLUONG")){
				pst.setInt(2, 0);
			}
			pst.setInt(3, t.getMASACH());
			ketqua = pst.executeUpdate();
			JDBCUtil.closeConnection(con);
		} catch(Exception e) {
			// TODO Auto-generated catch block
			System.out.print("\nCó lỗi xảy ra, thực hiện câu lệnh không thành công trong phương thức update() của lớp SACHDAO.\n");
			e.printStackTrace();
		}
		return ketqua;
	}


	@Override
	public int delete(SACH t) {
		int ketqua=0;
		try {
			Connection con=JDBCUtil.getConnection();

			// Kiểm tra xem có giá trị nào trong cột "MASACH" của bảng "chitietphieunhap" hoặc "chitiethoadon" giống với giá trị bạn đang cố gắng cập nhật không
			String sqlCheck = "SELECT * FROM chitietphieunhap WHERE MASACH = ? UNION SELECT * FROM chitiethoadon WHERE MASACH = ?";
			PreparedStatement pstCheck = con.prepareStatement(sqlCheck);
			pstCheck.setInt(1, t.getMASACH());
			pstCheck.setInt(2, t.getMASACH());
			ResultSet rs = pstCheck.executeQuery();
	
			if (rs.next()) {
				// Nếu có, in ra thông báo và trả về một giá trị ngay tại thời điểm đó mà không tiếp tục thực hiện các lệnh SQL tiếp theo
				String sql1="UPDATE sach"+
						" SET ISHIDDEN=true"+
						" WHERE MASACH=?";
				PreparedStatement pst1=con.prepareStatement(sql1);
				System.out.print("thuc hien cau lenh "+sql1+"\n");
				pst1.setInt(1,t.getMASACH());
				ketqua=pst1.executeUpdate();
				JDBCUtil.closeConnection(con);
			}
			else{
				String sql1="DELETE FROM sach"+
				" WHERE MASACH=?";
				PreparedStatement pst1=con.prepareStatement(sql1);
				System.out.print("thuc hien cau lenh "+sql1+"\n");
				pst1.setInt(1,t.getMASACH());
				ketqua=pst1.executeUpdate();
				JDBCUtil.closeConnection(con);
			}


		}
		catch(Exception e) {
			// TODO Auto-generated catch block
			System.out.print("\nco loi xay ra, thuc hien cau lenh khong thanh cong o delete() class SACHDAO \n");
			e.printStackTrace();
		}
		return 0;
	}

	public int muaSACH(SACH t,int n) {
		int ketqua=0;
		try {
			Connection con=JDBCUtil.getConnection();			
				String sql="UPDATE sach "+
						" SET SOLUONG=? "+
						" WHERE MASACH=? ";
				
				PreparedStatement pst=con.prepareStatement(sql);
				SACH sach=SACHDAO.getInstance().selectById(t);
				if(sach.getSOLUONG()>=n){
					pst.setInt(1,sach.getSOLUONG() -n );

				}
				else{
					System.out.print("Số lượng vượt quá giới hạn mua");
					return 	0;
				}
				pst.setInt(2, t.getMASACH());
				
				ketqua=pst.executeUpdate();
				System.out.print("thuc hien cau lenh"+sql+"\n");
				JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.print("co loi xay ra, thuc hien cau lenh khong thanh cong o update() class KHODAO \n");
			e.printStackTrace();
		}
		return 0;
	}
	public int thuhoiSACH(SACH t,int n) {
		int ketqua=0;
		try {
			Connection con=JDBCUtil.getConnection();			
				String sql="UPDATE sach "+
						" SET SOLUONG=? "+
						" WHERE MASACH=? ";
				
				PreparedStatement pst=con.prepareStatement(sql);
				
				SACH sach=SACHDAO.getInstance().selectById(t);
				pst.setInt(1,sach.getSOLUONG() +n );
				pst.setInt(2, t.getMASACH());
				
				ketqua=pst.executeUpdate();
				System.out.print("thuc hien cau lenh"+sql+"\n");
				JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.print("co loi xay ra, thuc hien cau lenh khong thanh cong o update() class KHODAO \n");
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public ArrayList<SACH> selectAll() {
		ArrayList<SACH> ketqua=new ArrayList<SACH>();
		try {
			Connection con=JDBCUtil.getConnection();
			
			String sql=" SELECT * FROM sach ";
			
			PreparedStatement pst=con.prepareStatement(sql);
			
			ResultSet rs=pst.executeQuery();
			while(rs.next()) {
				int MASACH=rs.getInt("MASACH");
				String TENSACH=rs.getString("TENSACH");
				String IMAGE=rs.getString("IMAGE");
				int SOLUONG= rs.getInt("SOLUONG");
				int GIABIA=rs.getInt("GIABIA");
				int LANTAIBAN=rs.getInt("LANTAIBAN");
				String TENNHAXUATBAN=rs.getString("TENNHAXUATBAN");
				boolean ISHIDDEN=rs.getBoolean("ISHIDDEN");
				SACH sach=new SACH(MASACH,TENSACH,IMAGE,SOLUONG,TENNHAXUATBAN,GIABIA,LANTAIBAN,ISHIDDEN);
				ketqua.add(sach);
			}
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.print("co loi xay ra, thuc hien cau lenh khong thanh cong o selectAll class HOADONDAO \n");
			e.printStackTrace();
		}
		return ketqua;
	}
	
	public ArrayList<SACH> selectAllExceptISHIDDEN() {
		ArrayList<SACH> ketqua=new ArrayList<SACH>();
		try {
			Connection con=JDBCUtil.getConnection();
			
			String sql=" SELECT * FROM sach "+
					"WHERE ISHIDDEN=false";
			
			PreparedStatement pst=con.prepareStatement(sql);
			
			
			ResultSet rs=pst.executeQuery();
			while(rs.next()) {
				int MASACH=rs.getInt("MASACH");
				String TENSACH=rs.getString("TENSACH");
				String IMAGE=rs.getString("IMAGE");
				int SOLUONG= rs.getInt("SOLUONG");
				int GIABIA=rs.getInt("GIABIA");
				int LANTAIBAN=rs.getInt("LANTAIBAN");
				String TENNHAXUATBAN=rs.getString("TENNHAXUATBAN");
				boolean ISHIDDEN=rs.getBoolean("ISHIDDEN");
				SACH sach=new SACH(MASACH,TENSACH,IMAGE,SOLUONG,TENNHAXUATBAN,GIABIA,LANTAIBAN,ISHIDDEN);
				ketqua.add(sach);
			}
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.print("co loi xay ra, thuc hien cau lenh khong thanh cong o selectAll class SACHDAO \n");
			e.printStackTrace();
		}
		return ketqua;
	}

	@Override
	public SACH selectById(SACH t) {
		SACH ketqua=null;
		try {
			Connection con=JDBCUtil.getConnection();
			
			String sql=" SELECT * FROM sach "+
					"WHERE MASACH=?";
			
			PreparedStatement pst=con.prepareStatement(sql);
			pst.setInt(1,t.getMASACH());
			System.out.print("Đã thực thi câu lệnh"+sql);
			ResultSet rs=pst.executeQuery();
			while(rs.next()) {
				int MASACH=rs.getInt("MASACH");
				String TENSACH=rs.getString("TENSACH");
				String IMAGE=rs.getString("IMAGE");
				int SOLUONG= rs.getInt("SOLUONG");
				int GIABIA=rs.getInt("GIABIA");
				int LANTAIBAN=rs.getInt("LANTAIBAN");
				String TENNHAXUATBAN=rs.getString("TENNHAXUATBAN");
				boolean ISHIDDEN=rs.getBoolean("ISHIDDEN");
				SACH sach=new SACH(MASACH,TENSACH,IMAGE,SOLUONG,TENNHAXUATBAN,GIABIA,LANTAIBAN,ISHIDDEN);
				ketqua=sach;
			}
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.print("co loi xay ra, thuc hien cau lenh khong thanh cong o selectAll class SACHDAO \n");
			e.printStackTrace();
		}
		return ketqua;
	}

	@Override
	public ArrayList<SACH> selectByCondition(String condition) {
		ArrayList<SACH> ketqua=new ArrayList<SACH>();
		try {
			Connection con=JDBCUtil.getConnection();
			
			String sql=" SELECT * FROM sach WHERE "+condition;
			
			Statement pst=con.createStatement();
			
			
			ResultSet rs=pst.executeQuery(sql);
			while(rs.next()) {
				int MASACH=rs.getInt("MASACH");
				String TENSACH=rs.getString("TENSACH");
				String IMAGE=rs.getString("IMAGE");
				int SOLUONG= rs.getInt("SOLUONG");
				int GIABIA=rs.getInt("GIABIA");
				int LANTAIBAN=rs.getInt("LANTAIBAN");
				String TENNHAXUATBAN=rs.getString("TENNHAXUATBAN");
				boolean ISHIDDEN=rs.getBoolean("ISHIDDEN");
				SACH sach=new SACH(MASACH,TENSACH,IMAGE,SOLUONG,TENNHAXUATBAN,GIABIA,LANTAIBAN,ISHIDDEN);
				ketqua.add(sach);
			}
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.print("co loi xay ra, thuc hien cau lenh khong thanh cong o selectAll class SACHDAO \n");
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