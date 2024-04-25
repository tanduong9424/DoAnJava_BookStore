package Dto;

import java.sql.Date;

public class NHANVIEN {
    private int manv;
    private String username;
    private String hoten;
    private String diachi;
    private String email;
    private int dienthoai;
    private java.sql.Date ngaytao;
    private boolean tttk;
    public NHANVIEN() {
        
    }
    public NHANVIEN(int manv) {
        this.manv = manv;
    }
    public NHANVIEN(String username) {
        this.username = username;
    }

    public NHANVIEN(String username, String hoten, String diachi, String email, int dienthoai, Date ngaytao,
            boolean tttk) {
        this.username = username;
        this.hoten = hoten;
        this.diachi = diachi;
        this.email = email;
        this.dienthoai = dienthoai;
        this.ngaytao = ngaytao;
        this.tttk = tttk;
    }



    public NHANVIEN(String hoten, String diachi, String email, int dienthoai, Date ngaytao, boolean tttk) {
        this.hoten = hoten;
        this.diachi = diachi;
        this.email = email;
        this.dienthoai = dienthoai;
        this.ngaytao = ngaytao;
        this.tttk = tttk;
    }



    public NHANVIEN(int manv, String username, String hoten, String diachi, String email, int dienthoai, Date ngaytao,
            boolean tttk) {
        this.manv = manv;
        this.username = username;
        this.hoten = hoten;
        this.diachi = diachi;
        this.email = email;
        this.dienthoai = dienthoai;
        this.ngaytao = ngaytao;
        this.tttk = tttk;
    }
    
    public int getManv() {
        return manv;
    }
    public void setManv(int manv) {
        this.manv = manv;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
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
    public java.sql.Date getNgaytao() {
        return ngaytao;
    }
    public void setNgaytao(java.sql.Date ngaytao) {
        this.ngaytao = ngaytao;
    }
    public boolean isTttk() {
        return tttk;
    }
    public void setTttk(boolean tttk) {
        this.tttk = tttk;
    }

    

    
}
