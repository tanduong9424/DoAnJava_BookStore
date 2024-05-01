package Dto;

public class TAIKHOAN {
	@Override
	public String toString() {
		return "TAIKHOAN [USERNAME=" + USERNAME + ", PASSWORD=" + PASSWORD + ", ROLE=" + ROLE + "]";
	}
	public String toStringInsert() {
		return "TAIKHOAN [USERNAME=" + USERNAME + ", ROLE=" + ROLE + "]";
	}
	private String USERNAME;
	private String PASSWORD;
	private String ROLE;
        private int makh;
        private int manv;
	public TAIKHOAN() {
		super();
	}
	public TAIKHOAN(String uSERNAME) {
		super();
		USERNAME = uSERNAME;
	}
        public TAIKHOAN(String uSERNAME,String pASSWORD) {
		super();
		USERNAME = uSERNAME;
                PASSWORD= pASSWORD;
	}
	public TAIKHOAN(String uSERNAME, String pASSWORD, String rOLE) {
		super();
		USERNAME = uSERNAME;
		PASSWORD = pASSWORD;
		ROLE = rOLE;
	}
        public TAIKHOAN(String uSERNAME, String pASSWORD, int mANV,int mAKH) {
		super();
		USERNAME = uSERNAME;
		PASSWORD = pASSWORD;
		manv=mANV;
                makh=mAKH;
	}
        public TAIKHOAN(String uSERNAME, String pASSWORD, int mANV,String rOLE) {
		super();
		USERNAME = uSERNAME;
		PASSWORD = pASSWORD;
		manv=mANV;
                ROLE=rOLE;
	}   
        public TAIKHOAN(String uSERNAME, String pASSWORD, String rOLE,int mAKH) {
		super();
		USERNAME = uSERNAME;
		PASSWORD = pASSWORD;
		makh=mAKH;
                ROLE=rOLE;
	} 
        public TAIKHOAN(String uSERNAME, String pASSWORD, int mANV,int mAKH,String rOLE) {
		super();
		USERNAME = uSERNAME;
		PASSWORD = pASSWORD;
		manv=mANV;
                makh=mAKH;
                ROLE=rOLE;
	}
	public String getUSERNAME() {
		return USERNAME;
	}
	public void setUSERNAME(String uSERNAME) {
		USERNAME = uSERNAME;
	}
	public String getPASSWORD() {
		return PASSWORD;
	}
	public void setPASSWORD(String pASSWORD) {
		PASSWORD = pASSWORD;
	}
	public String getROLE() {
		return ROLE;
	}
	public void setROLE(String rOLE) {
		ROLE = rOLE;
	}
        public int getMANV() {
		return manv;
	}
	public void setMANV(int mANV) {
		manv = mANV;
	}
        public int getMAKH() {
		return makh;
	}
	public void setMAKH(int mAKH) {
		makh = mAKH;
	}

	
}
