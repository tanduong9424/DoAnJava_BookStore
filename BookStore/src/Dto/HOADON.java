package Dto;

import java.sql.Date;

public class HOADON {
	@Override
	public String toString() {
		return "HOADON [MAHOADON=" + MAHOADON + ", TENKHACHHANG=" + TENTAIKHOAN + ", NGAYLAP=" + NGAYLAP
				+ ", TONGTIEN=" + TONGTIEN + "]";
	}
	private int MAHOADON;
	private String TENTAIKHOAN;
	private int manv;
	private java.sql.Date NGAYLAP;
	private int TONGTIEN;
	private int makhuyenmai;
	private boolean tthd;
	public HOADON() {
		super();
	}
	public HOADON(int mAHOADON) {
		MAHOADON = mAHOADON;
	}
	public HOADON(int mAHOADON, String tENTAIKHOAN, int manv, Date nGAYLAP, int tONGTIEN, int makhuyenmai,
			boolean tthd) {
		MAHOADON = mAHOADON;
		TENTAIKHOAN = tENTAIKHOAN;
		this.manv = manv;
		NGAYLAP = nGAYLAP;
		TONGTIEN = tONGTIEN;
		this.makhuyenmai = makhuyenmai;
		this.tthd = tthd;
	}
	public HOADON(String tENTAIKHOAN, int manv, Date nGAYLAP, int tONGTIEN, int makhuyenmai, boolean tthd) {
		TENTAIKHOAN = tENTAIKHOAN;
		this.manv = manv;
		NGAYLAP = nGAYLAP;
		TONGTIEN = tONGTIEN;
		this.makhuyenmai = makhuyenmai;
		this.tthd = tthd;
	}
	public HOADON(int manv, Date nGAYLAP, int tONGTIEN, int makhuyenmai, boolean tthd) {
		this.manv = manv;
		NGAYLAP = nGAYLAP;
		TONGTIEN = tONGTIEN;
		this.makhuyenmai = makhuyenmai;
		this.tthd = tthd;
	}
	public HOADON(String tENTAIKHOAN, int manv, Date nGAYLAP, int tONGTIEN, boolean tthd) {
		TENTAIKHOAN = tENTAIKHOAN;
		this.manv = manv;
		NGAYLAP = nGAYLAP;
		TONGTIEN = tONGTIEN;
		this.tthd = tthd;
	}
	public HOADON(int manv, Date nGAYLAP, int tONGTIEN, boolean tthd) {
		this.manv = manv;
		NGAYLAP = nGAYLAP;
		TONGTIEN = tONGTIEN;
		this.tthd = tthd;
	}
	public int getMAHOADON() {
		return MAHOADON;
	}
	public void setMAHOADON(int mAHOADON) {
		MAHOADON = mAHOADON;
	}
	public String getTENTAIKHOAN() {
		return TENTAIKHOAN;
	}
	public void setTENTAIKHOAN(String tENTAIKHOAN) {
		TENTAIKHOAN = tENTAIKHOAN;
	}
	public int getManv() {
		return manv;
	}
	public void setManv(int manv) {
		this.manv = manv;
	}
	public java.sql.Date getNGAYLAP() {
		return NGAYLAP;
	}
	public void setNGAYLAP(java.sql.Date nGAYLAP) {
		NGAYLAP = nGAYLAP;
	}
	public int getTONGTIEN() {
		return TONGTIEN;
	}
	public void setTONGTIEN(int tONGTIEN) {
		TONGTIEN = tONGTIEN;
	}
	public int getMakhuyenmai() {
		return makhuyenmai;
	}
	public void setMakhuyenmai(int makhuyenmai) {
		this.makhuyenmai = makhuyenmai;
	}
	public boolean isTthd() {
		return tthd;
	}
	public void setTthd(boolean tthd) {
		this.tthd = tthd;
	}
	
}
