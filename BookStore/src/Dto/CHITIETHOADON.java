package Dto;

public class CHITIETHOADON {
	@Override
	public String toString() {
		return "CHITIETHOADON [MAHOADON=" + MAHOADON + ", MASACH=" + MASACH + ", GIATIEN=" + GIATIEN + ", THANHTIEN="
				+ THANHTIEN + ", SOLUONG=" + SOLUONG + "]";
	}

	private int MAHOADON;
	private int MASACH;
	private int GIATIEN;
	private int THANHTIEN;
	private int SOLUONG;
	
	public CHITIETHOADON() {
		super();
	}
	
	public CHITIETHOADON(int mAHOADON, int mASACH, int gIATIEN, int tHANHTIEN, int sOLUONG) {
		super();
		MAHOADON = mAHOADON;
		MASACH = mASACH;
		GIATIEN = gIATIEN;
		THANHTIEN = tHANHTIEN;
		SOLUONG = sOLUONG;
	}

	public int getMAHOADON() {
		return MAHOADON;
	}

	public void setMAHOADON(int mAHOADON) {
		MAHOADON = mAHOADON;
	}

	public int getMASACH() {
		return MASACH;
	}

	public void setMASACH(int mASACH) {
		MASACH = mASACH;
	}

	public int getGIATIEN() {
		return GIATIEN;
	}

	public void setGIATIEN(int gIATIEN) {
		GIATIEN = gIATIEN;
	}

	public int getTHANHTIEN() {
		return THANHTIEN;
	}

	public void setTHANHTIEN(int tHANHTIEN) {
		THANHTIEN = tHANHTIEN;
	}

	public int getSOLUONG() {
		return SOLUONG;
	}

	public void setSOLUONG(int sOLUONG) {
		SOLUONG = sOLUONG;
	}
	
	
	
}
