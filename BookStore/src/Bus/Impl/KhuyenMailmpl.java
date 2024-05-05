/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bus.Impl;

import Bus.KhuyenMai;
import Dao.KHUYENMAIDAO;
import Dto.KHUYENMAI;
import java.util.ArrayList;
import javax.swing.JComboBox;
import static org.apache.logging.log4j.util.Strings.isBlank;

/**
 *
 * @author Admin
 */
public class KhuyenMailmpl implements KhuyenMai{
    
    KHUYENMAIDAO khuyenmaidao = new KHUYENMAIDAO();
    @Override
    public void danhsachKhuyenMai(JComboBox model,int tongtien) {
        model.removeAllItems();
        ArrayList<KHUYENMAI> result=khuyenmaidao.selectActivePromotionsToday();
        for (KHUYENMAI tk : result) {
            if(tk.getTongtiencanthiet()<=tongtien){ 
            String row = tk.toString(); // Điều chỉnh dữ liệu tùy thuộc vào cách bạn muốn hiển thị
            model.addItem(row);
            }
        }
       }

    @Override
    public Boolean addKhuyenMai(KHUYENMAI t) {
        return khuyenmaidao.insert(t)==0;    
    }

    @Override
    public Boolean deleteKhuyeMai(KHUYENMAI t) {
        return khuyenmaidao.delete(t)==0;    
    }

    @Override
    public Boolean updateKhuyenMai(KHUYENMAI t) {
        return khuyenmaidao.update(t)==0;    
    }

    @Override
    public ArrayList<KHUYENMAI> getAllKM() {
        return khuyenmaidao.selectAllEXCEPTISHIDDEN();  
    }

    @Override
    public ArrayList<KHUYENMAI> timKiem(String kieuTimKiem, String inputText, String fromDate, String toDate) {
        ArrayList<KHUYENMAI> listKhuyenMai = new ArrayList<>();
        System.out.println(" ngay bat dau "+fromDate+" ngay ket thuc "+ toDate);
        if(inputText!="" && inputText!=null && !isBlank(inputText)){          
            if(kieuTimKiem=="Mã Khuyến Mãi"){            
                if (isBlank(fromDate)|| isBlank(toDate)) {
                    KHUYENMAI t = new KHUYENMAI(Integer.parseInt(inputText));
                    listKhuyenMai.add(khuyenmaidao.selectById(t));
                    return listKhuyenMai;
                }
                else{
                    KHUYENMAI t = new KHUYENMAI(Integer.parseInt(inputText));
                    listKhuyenMai.add(khuyenmaidao.selectByIdFromTo(t, fromDate, toDate));
                    return listKhuyenMai;
                }
                }
            else if(kieuTimKiem=="Tổng tiền cần thiết"){
                if (isBlank(fromDate)|| isBlank(toDate)) {
                    String sql=" tongtiencanthiet = "+inputText;
                    listKhuyenMai=KHUYENMAIDAO.getInstance().selectByCondition(sql);
                    return listKhuyenMai;
                }
                else{
                    String sql=" tongtiencanthiet = "+inputText+" AND ngaytao BETWEEN '"+fromDate+"' AND '"+toDate+"'";
                    listKhuyenMai=KHUYENMAIDAO.getInstance().selectByCondition(sql);
                    return listKhuyenMai;
                }            
            }
            else{
                if (isBlank(fromDate)|| isBlank(toDate)) {
                    String sql=" phantramgiam = "+inputText;
                    listKhuyenMai=KHUYENMAIDAO.getInstance().selectByCondition(sql);
                    return listKhuyenMai;
                }
                else{
                    String sql=" phantramgiam = "+inputText+" AND ngaytao BETWEEN '"+fromDate+"' AND '"+toDate+"'";
                    listKhuyenMai=KHUYENMAIDAO.getInstance().selectByCondition(sql);
                    return listKhuyenMai;
                }             
            }
        }
        else{
            String sql="  ngaytao BETWEEN '"+fromDate+"' AND '"+toDate+"'";
            listKhuyenMai=KHUYENMAIDAO.getInstance().selectByCondition(sql);
            return listKhuyenMai;
        }
    }


    
    
}
