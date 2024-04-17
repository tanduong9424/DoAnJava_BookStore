package Main.BackEnd.repository.modal;

import java.sql.Date;

public class SACH {

	private int MASACH;
	private String TENSACH;
	private String IMAGE;
	private int SOLUONG;
	private int MATACGIA;
	private String TENLOAISACH;
	private String TENNHAXUATBAN;
	private int GIABIA;
	private int LANTAIBAN;
	private java.sql.Date NAMXUATBAN;
	private boolean ISHIDDEN;
	
	public SACH() {
	}
	
	public SACH(int mASACH) {
		MASACH = mASACH;
	}

	public SACH(int mASACH, String tENSACH, String iMAGE, int sOLUONG, int mATACGIA,
			String tENLOAISACH, String tENNHAXUATBAN,  int gIABIA, int lANTAIBAN, Date nAMXUATBAN
			, boolean iSHIDDEN) {
		MASACH = mASACH;
		TENSACH = tENSACH;
		IMAGE = iMAGE;
		SOLUONG = sOLUONG;
		MATACGIA = mATACGIA;
		TENLOAISACH = tENLOAISACH;
		TENNHAXUATBAN = tENNHAXUATBAN;
		GIABIA = gIABIA;
		LANTAIBAN = lANTAIBAN;
		NAMXUATBAN = nAMXUATBAN;
		ISHIDDEN = iSHIDDEN;
	}

	public SACH(String tENSACH, String iMAGE, int sOLUONG, int mATACGIA, String tENLOAISACH,
			String tENNHAXUATBAN, int gIABIA, int lANTAIBAN, Date nAMXUATBAN,
			boolean iSHIDDEN) {
		TENSACH = tENSACH;
		IMAGE = iMAGE;
		SOLUONG = sOLUONG;
		MATACGIA = mATACGIA;
		TENLOAISACH = tENLOAISACH;
		TENNHAXUATBAN = tENNHAXUATBAN;
		GIABIA = gIABIA;
		LANTAIBAN = lANTAIBAN;
		NAMXUATBAN = nAMXUATBAN;
		ISHIDDEN = iSHIDDEN;
	}

	public int getMASACH() {
		return MASACH;
	}

	public void setMASACH(int mASACH) {
		MASACH = mASACH;
	}

	public String getTENSACH() {
		return TENSACH;
	}

	public void setTENSACH(String tENSACH) {
		TENSACH = tENSACH;
	}

	public String getIMAGE() {
		return IMAGE;
	}

	public void setIMAGE(String iMAGE) {
		IMAGE = iMAGE;
	}

	public int getSOLUONG() {
		return SOLUONG;
	}

	public void setSOLUONG(int sOLUONG) {
		SOLUONG = sOLUONG;
	}

	public int getMATACGIA() {
		return MATACGIA;
	}

	public void setMATACGIA(int mATACGIA) {
		MATACGIA = mATACGIA;
	}

	public String getTENLOAISACH() {
		return TENLOAISACH;
	}

	public void setTENLOAISACH(String tENLOAISACH) {
		TENLOAISACH = tENLOAISACH;
	}

	public String getTENNHAXUATBAN() {
		return TENNHAXUATBAN;
	}

	public void setTENNHAXUATBAN(String tENNHAXUATBAN) {
		TENNHAXUATBAN = tENNHAXUATBAN;
	}

	public int getGIABIA() {
		return GIABIA;
	}

	public void setGIABIA(int gIABIA) {
		GIABIA = gIABIA;
	}

	public int getLANTAIBAN() {
		return LANTAIBAN;
	}

	public void setLANTAIBAN(int lANTAIBAN) {
		LANTAIBAN = lANTAIBAN;
	}

	public java.sql.Date getNAMXUATBAN() {
		return NAMXUATBAN;
	}

	public void setNAMXUATBAN(java.sql.Date nAMXUATBAN) {
		NAMXUATBAN = nAMXUATBAN;
	}

	public boolean isISHIDDEN() {
		return ISHIDDEN;
	}

	public void setISHIDDEN(boolean iSHIDDEN) {
		ISHIDDEN = iSHIDDEN;
	}
	
	
}
