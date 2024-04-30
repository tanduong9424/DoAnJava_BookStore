package Dto;

import java.sql.Date;

public class KHUYENMAI {
    private int makhuyenmai;
    private java.sql.Date ngaytao;
    private java.sql.Date ngaybatdau;
    private java.sql.Date ngayketthuc;
    private int tongtiencanthiet;
    private int phantramgiam;
    private boolean ISHIDDEN;
    
    public KHUYENMAI() {
    }
    public KHUYENMAI(int makhuyenmai) {
        this.makhuyenmai = makhuyenmai;
    }
    public KHUYENMAI(int makhuyenmai, Date ngaytao, Date ngaybatdau, Date ngayketthuc, int tongtiencanthiet,
            int phantramgiam, boolean iSHIDDEN) {
        this.makhuyenmai = makhuyenmai;
        this.ngaytao = ngaytao;
        this.ngaybatdau = ngaybatdau;
        this.ngayketthuc = ngayketthuc;
        this.tongtiencanthiet = tongtiencanthiet;
        this.phantramgiam = phantramgiam;
        ISHIDDEN = iSHIDDEN;
    }
    public KHUYENMAI(Date ngaytao, Date ngaybatdau, Date ngayketthuc, int tongtiencanthiet, int phantramgiam,
            boolean iSHIDDEN) {
        this.ngaytao = ngaytao;
        this.ngaybatdau = ngaybatdau;
        this.ngayketthuc = ngayketthuc;
        this.tongtiencanthiet = tongtiencanthiet;
        this.phantramgiam = phantramgiam;
        ISHIDDEN = iSHIDDEN;
    }
    public int getMakhuyenmai() {
        return makhuyenmai;
    }
    public void setMakhuyenmai(int makhuyenmai) {
        this.makhuyenmai = makhuyenmai;
    }
    public java.sql.Date getNgaytao() {
        return ngaytao;
    }
    public void setNgaytao(java.sql.Date ngaytao) {
        this.ngaytao = ngaytao;
    }
    public java.sql.Date getNgaybatdau() {
        return ngaybatdau;
    }
    public void setNgaybatdau(java.sql.Date ngaybatdau) {
        this.ngaybatdau = ngaybatdau;
    }
    public java.sql.Date getNgayketthuc() {
        return ngayketthuc;
    }
    public void setNgayketthuc(java.sql.Date ngayketthuc) {
        this.ngayketthuc = ngayketthuc;
    }
    public int getTongtiencanthiet() {
        return tongtiencanthiet;
    }
    public void setTongtiencanthiet(int tongtiencanthiet) {
        this.tongtiencanthiet = tongtiencanthiet;
    }
    public int getPhantramgiam() {
        return phantramgiam;
    }
    public void setPhantramgiam(int phantramgiam) {
        this.phantramgiam = phantramgiam;
    }
    public boolean isISHIDDEN() {
        return ISHIDDEN;
    }
    public void setISHIDDEN(boolean iSHIDDEN) {
        ISHIDDEN = iSHIDDEN;
    }
        @Override
	public String toString() {
		return ""+makhuyenmai+"-"+phantramgiam+"%";
	}    
}
