/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;
import DAO.DAO_mathang;
import DTO.DTO_mathang;
import java.util.ArrayList;
/**
 *
 * @author hieu
 */
public class BUS_mathang {
    DAO_mathang mathangDAO = new DAO_mathang();
    public ArrayList<DTO_mathang> getAllMathang(){
        return mathangDAO.getAllMathang();
    }
    public String addMathang(DTO_mathang mh){
        if (mathangDAO.hasMathangID(mh.getMaMatmang())){
            return "Ma mat hang da ton tai";
        }
        if (mathangDAO.addMathang(mh))
            return "Them thanh cong";
        return "Them that bai";
    }
    
    public String chinhsuaMathang(DTO_mathang mh){
        if (mathangDAO.suaMathang(mh)){
            return "Sua doi thanh cong";
        } else {
            return "Khong the sua doi";
        }
    }
}
