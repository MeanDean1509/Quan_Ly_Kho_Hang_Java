/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;
import DAO.DAO_KhachHang;
import DTO.DTO_KhachHang;
import java.util.ArrayList;
/**
 *
 * @author hieu
 */
public class BUS_KhachHang {
    DAO_KhachHang KHDAO = new DAO_KhachHang();
    public ArrayList<DTO_KhachHang> getAllKhachHangs(){
        return KHDAO.getAllKhachHangs();
    }
    public String addNCC(DTO_KhachHang ncc){
        if (KHDAO.hasKHID(ncc.getMaKhachHang())){
            return "Mã Khách hàng đã tồn tại";
        }
        if (KHDAO.hasKHIDdeleted(ncc.getMaKhachHang())){
            if (KHDAO.suaKH(ncc)){
                return "Thêm thành công";
            } else {
                return "Thêm thất bại";
            }
        }
        if (KHDAO.addKH(ncc))
            return "Thêm thành công";
        return "Thêm thất bại";
    }
    
    public String chinhsuaKH(DTO_KhachHang mh){
        if (KHDAO.hasKHIDdeleted(mh.getMaKhachHang())){
            return "Không tồn tại khách hàng trên";
        }
        else
        if (KHDAO.suaKH(mh)){
            return "Sửa thành công";
        } else {
            return "Không thể sửa đổi";
        }
    }
    public String xoaKH(DTO_KhachHang mh){
        if (KHDAO.xoaKH(mh)){
            return "Xóa thành công";
        }
        else
            return "Không thể xóa";
    }
     public ArrayList<DTO_KhachHang> timkiem(String s){
            return KHDAO.tim_kiem(s);
    
    }
}
