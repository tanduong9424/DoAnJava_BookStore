package Dto;

import java.sql.Date;

public class PHIEUNHAP {
    private int mapn;
    private int manv;
    private String noinhap;
    private int tongtien;
    private java.sql.Date ngaynhap;
    public PHIEUNHAP() {
    }
    
    public PHIEUNHAP(int mapn) {
        this.mapn = mapn;
    }

    public PHIEUNHAP(int mapn, int manv, String noinhap, int tongtien, Date ngaynhap) {
        this.mapn = mapn;
        this.manv = manv;
        this.noinhap = noinhap;
        this.tongtien = tongtien;
        this.ngaynhap = ngaynhap;
    }
    public PHIEUNHAP(int manv, String noinhap, int tongtien, Date ngaynhap) {
        this.manv = manv;
        this.noinhap = noinhap;
        this.tongtien = tongtien;
        this.ngaynhap = ngaynhap;
    }
    public PHIEUNHAP(int manv, int tongtien, Date ngaynhap) {
        this.manv = manv;
        this.tongtien = tongtien;
        this.ngaynhap = ngaynhap;
    }
    public int getMapn() {
        return mapn;
    }
    public void setMapn(int mapn) {
        this.mapn = mapn;
    }
    public int getManv() {
        return manv;
    }
    public void setManv(int manv) {
        this.manv = manv;
    }
    public String getNoinhap() {
        return noinhap;
    }
    public void setNoinhap(String noinhap) {
        this.noinhap = noinhap;
    }
    public int getTongtien() {
        return tongtien;
    }
    public void setTongtien(int tongtien) {
        this.tongtien = tongtien;
    }
    public java.sql.Date getNgaynhap() {
        return ngaynhap;
    }
    public void setNgaynhap(java.sql.Date ngaynhap) {
        this.ngaynhap = ngaynhap;
    }
    
    
}
