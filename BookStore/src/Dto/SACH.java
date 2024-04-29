
package Dto;

import java.sql.Date;

public class SACH {

	private int MASACH;
	private String TENSACH;
	private String IMAGE;
	private int SOLUONG;
	private String TENNHAXUATBAN;
	private int GIABIA;
	private int LANTAIBAN;
	private boolean ISHIDDEN;
	
	public SACH() {
	}
	
	public SACH(int mASACH) {
		MASACH = mASACH;
	}

	public SACH(int mASACH, String tENSACH, String iMAGE, int sOLUONG,
			 String tENNHAXUATBAN, int gIABIA, int lANTAIBAN,
			boolean iSHIDDEN) {
		MASACH = mASACH;
		TENSACH = tENSACH;
		IMAGE = iMAGE;
		SOLUONG = sOLUONG;
		TENNHAXUATBAN = tENNHAXUATBAN;
		GIABIA = gIABIA;
		LANTAIBAN = lANTAIBAN;
		ISHIDDEN = iSHIDDEN;
	}

	public SACH(String tENSACH, String iMAGE, int sOLUONG,
			String tENNHAXUATBAN, int gIABIA, int lANTAIBAN,
			boolean iSHIDDEN) {
    		TENSACH = tENSACH;
		IMAGE = iMAGE;
		SOLUONG = sOLUONG;
		TENNHAXUATBAN = tENNHAXUATBAN;
		GIABIA = gIABIA;
		LANTAIBAN = lANTAIBAN;
		ISHIDDEN = iSHIDDEN;
	}
        public SACH(String tENSACH, int sOLUONG,
			String tENNHAXUATBAN, int gIABIA, int lANTAIBAN,
			boolean iSHIDDEN) {
    		TENSACH = tENSACH;
		SOLUONG = sOLUONG;
		TENNHAXUATBAN = tENNHAXUATBAN;
		GIABIA = gIABIA;
		LANTAIBAN = lANTAIBAN;
		ISHIDDEN = iSHIDDEN;
	}
        public SACH(int mASACH, String tENSACH, int sOLUONG, String tENNHAXUATBAN, int gIABIA) {
		MASACH = mASACH;
		TENSACH = tENSACH;
		SOLUONG = sOLUONG;
		TENNHAXUATBAN = tENNHAXUATBAN;
		GIABIA = gIABIA;
	}
        public SACH(int mASACH, String tENSACH, String tENNHAXUATBAN, int gIABIA) {
		MASACH = mASACH;
		TENSACH = tENSACH;
		TENNHAXUATBAN = tENNHAXUATBAN;
		GIABIA = gIABIA;
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



	public boolean isISHIDDEN() {
		return ISHIDDEN;
	}

	public void setISHIDDEN(boolean iSHIDDEN) {
		ISHIDDEN = iSHIDDEN;
	}
	
	
}
