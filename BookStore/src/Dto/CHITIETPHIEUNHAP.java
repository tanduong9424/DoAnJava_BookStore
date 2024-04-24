package Dto;

public class CHITIETPHIEUNHAP {
    private int mapn;
    private int MASACH;
    private int gianhap;
    private int soluong;
    private int tongtien;
    public CHITIETPHIEUNHAP() {
    }
    
    public CHITIETPHIEUNHAP(int mapn, int mASACH, int gianhap, int soluong, int tongtien) {
        this.mapn = mapn;
        MASACH = mASACH;
        this.gianhap = gianhap;
        this.soluong = soluong;
        this.tongtien = tongtien;
    }

    public int getMapn() {
        return mapn;
    }

    public void setMapn(int mapn) {
        this.mapn = mapn;
    }

    public int getMASACH() {
        return MASACH;
    }

    public void setMASACH(int mASACH) {
        MASACH = mASACH;
    }

    public int getGianhap() {
        return gianhap;
    }

    public void setGianhap(int gianhap) {
        this.gianhap = gianhap;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public int getTongtien() {
        return tongtien;
    }

    public void setTongtien(int tongtien) {
        this.tongtien = tongtien;
    }
    
    
    
}
