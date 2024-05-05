/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dto;

/**
 *
 * @author xuand
 */
import java.util.Date;

public class THONGKE {
    private int manv;
    private int makh;
    private Date NGAYLAP;
    private int TONGTIEN;

    public THONGKE() {
        super();
    }

    public THONGKE(int manv, int makh, Date NGAYLAP, int TONGTIEN) {
        super();
        this.manv = manv;
        this.makh = makh;
        this.NGAYLAP = NGAYLAP;
        this.TONGTIEN = TONGTIEN;
    }

    public int getManv() {
        return manv;
    }

    public void setManv(int manv) {
        this.manv = manv;
    }

    public int getMakh() {
        return makh;
    }

    public void setMakh(int makh) {
        this.makh = makh;
    }

    public Date getNGAYLAP() {
        return NGAYLAP;
    }

    public void setNGAYLAP(Date NGAYLAP) {
        this.NGAYLAP = NGAYLAP;
    }

    public int getTONGTIEN() {
        return TONGTIEN;
    }

    public void setTONGTIEN(int TONGTIEN) {
        this.TONGTIEN = TONGTIEN;
    }

    @Override
    public String toString() {
        return "THONGKE [manv=" + manv + ", makh=" + makh + ", NGAYLAP=" + NGAYLAP + ", TONGTIEN=" + TONGTIEN + "]";
    }
}
