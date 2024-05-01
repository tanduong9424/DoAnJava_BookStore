package Dto;

import java.sql.Date;

public class NHANVIEN {
    private int manv;
    private String hoten;
    private String diachi;
    private String email;
    private int dienthoai;
    private boolean tttk;
    public NHANVIEN() {
        
    }
    public NHANVIEN(int mANV) {
        manv=mANV;
    }

    

    public NHANVIEN( String hoten, String diachi, String email, int dienthoai,boolean tttk) {
        this.hoten = hoten;
        this.diachi = diachi;
        this.email = email;
        this.dienthoai = dienthoai;
        this.tttk = tttk;
    }



    public NHANVIEN(int manv, String hoten, String diachi, String email, int dienthoai,boolean tttk) {
        this.manv = manv;
        this.hoten = hoten;
        this.diachi = diachi;
        this.email = email;
        this.dienthoai = dienthoai;
        this.tttk = tttk;
    }
    
    public int getManv() {
        return manv;
    }
    public void setManv(int manv) {
        this.manv = manv;
    }

    public String getHoten() {
        return hoten;
    }
    public void setHoten(String hoten) {
        this.hoten = hoten;
    }
    public String getDiachi() {
        return diachi;
    }
    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public int getDienthoai() {
        return dienthoai;
    }
    public void setDienthoai(int dienthoai) {
        this.dienthoai = dienthoai;
    }
    public boolean isTttk() {
        return tttk;
    }
    public void setTttk(boolean tttk) {
        this.tttk = tttk;
    }  
}
