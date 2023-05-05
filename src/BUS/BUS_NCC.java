/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;
import DAO.DAO_NCC;
import DTO.DTO_NCC;
import java.util.ArrayList;
/**
 *
 * @author hieu
 */
public class BUS_NCC {
    DAO_NCC NccDAO = new DAO_NCC();
    public ArrayList<DTO_NCC> getAllNCC(){
        return NccDAO.getAllNCC();
    }
    public String addNCC(DTO_NCC ncc){
        if (NccDAO.hasNCCID(ncc.getMaNCC())){
            return "Nhà cung cấp đã tồn tại";
        }
        if (NccDAO.hasNCCIDdeleted(ncc.getMaNCC())){
            if (NccDAO.suaNCC(ncc)){
                return "Thêm thành công";
            } else {
                return "Thêm thất bại";
            }
        }
        if (NccDAO.addNCC(ncc))
            return "Thêm thành công";
        return "Thêm thất bại";
    }
    
    public String chinhsuaNCC(DTO_NCC mh){
        if (NccDAO.hasNCCIDdeleted(mh.getMaNCC())){
            return "Không tồn tại nhà cung cấp";
        }
        else
        if (NccDAO.suaNCC(mh)){
            return "Sửa thành công";
        } else {
            return "Không thể sửa đổi";
        }
    }
    public String xoaNCC(DTO_NCC mh){
        if (NccDAO.xoaNCC(mh)){
            return "Xóa thành công";
        }
        else
            return "Không thể xóa";
    }
     public ArrayList<DTO_NCC> timkiem(String s){
            return NccDAO.timtheoten(s);
    
    }
}
