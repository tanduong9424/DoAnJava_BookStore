package Main.BackEnd.repository.modal;

public class LOAISACH {
	@Override
	public String toString() {
		return "LOAISACH [TENLOAISACH=" + TENLOAISACH + ", ISHIDDEN=" + ISHIDDEN + "]";
	}

	private String TENLOAISACH;
	private boolean ISHIDDEN;
	
	public boolean isISHIDDEN() {
		return ISHIDDEN;
	}

	public void setISHIDDEN(boolean iSHIDDEN) {
		ISHIDDEN = iSHIDDEN;
	}

	public LOAISACH() {
		super();
	}

	public LOAISACH(String tENLOAISACH,boolean iSHIDDEN) {
		super();
		TENLOAISACH = tENLOAISACH;
		ISHIDDEN= iSHIDDEN;
	}

	public String getTENLOAISACH() {
		return TENLOAISACH;
	}

	public void setTENLOAISACH(String tENLOAISACH) {
		TENLOAISACH = tENLOAISACH;
	}
	
	
}
