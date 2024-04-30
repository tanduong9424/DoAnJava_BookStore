package Dto;

public class NHAXUATBAN {
	@Override
	public String toString() {
		return "NHAXUATBAN [TENNHAXUATBAN=" + TENNHAXUATBAN + ", ISHIDDEN=" + ISHIDDEN + "]";
	}

	private String TENNHAXUATBAN;
	private boolean ISHIDDEN;

	public boolean isISHIDDEN() {
		return ISHIDDEN;
	}

	public void setISHIDDEN(boolean iSHIDDEN) {
		ISHIDDEN = iSHIDDEN;
	}

	public NHAXUATBAN() {
		super();
	}

	public NHAXUATBAN(String tENNHAXUATBAN) {
		super();
		TENNHAXUATBAN = tENNHAXUATBAN;
	}        
	public NHAXUATBAN(String tENNHAXUATBAN,boolean iSHIDDEN) {
		super();
		TENNHAXUATBAN = tENNHAXUATBAN;
		ISHIDDEN= iSHIDDEN;
	}

	public String getTENNHAXUATBAN() {
		return TENNHAXUATBAN;
	}

	public void setTENNHAXUATBAN(String tENNHAXUATBAN) {
		TENNHAXUATBAN = tENNHAXUATBAN;
	}
	
	
}
