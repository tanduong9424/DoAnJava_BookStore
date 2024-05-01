
package Dto;

import java.sql.Date;

public class KHACHANG {
    private int makh;
    private String hoten;
    private String diachi;
    private String email;
    private int dienthoai;
    private boolean tttk;
    public KHACHANG() {
    }
    public KHACHANG(int makh) {
        this.makh = makh;
    }
    public KHACHANG(String hoten) {
        this.hoten = hoten;
    }
    
    public KHACHANG(int makh, String hoten, String diachi, String email, int dienthoai,
            boolean tttk) {
        this.makh = makh;
        this.hoten = hoten;
        this.diachi = diachi;
        this.email = email;
        this.dienthoai = dienthoai;
        this.tttk = tttk;
    }


    public KHACHANG( String hoten, String diachi, String email, int dienthoai,
            boolean tttk) {
        this.hoten = hoten;
        this.diachi = diachi;
        this.email = email;
        this.dienthoai = dienthoai;
        this.tttk = tttk;
    }
    public int getMakh() {
        return makh;
    }
    public void setMakh(int makh) {
        this.makh = makh;
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
        @Override
	public String toString() {
		return makh + "-"+ hoten;
	}
}
