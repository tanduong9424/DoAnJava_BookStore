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
	public TAIKHOAN() {
		super();
	}
	public TAIKHOAN(String uSERNAME) {
		super();
		USERNAME = uSERNAME;
	}
	public TAIKHOAN(String uSERNAME, String pASSWORD, String rOLE) {
		super();
		USERNAME = uSERNAME;
		PASSWORD = pASSWORD;
		ROLE = rOLE;
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
	
	
}
