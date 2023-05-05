/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import DTO.DTO_KhachHang;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author hieu
 */
public class DAO_KhachHang extends KetNoicsdl{
    
    
    public ArrayList<DTO_KhachHang> getAllKhachHangs(){
    ArrayList<DTO_KhachHang> arr = new ArrayList<DTO_KhachHang>();
    if (KetNoi()) {
        try {
        String sql = "Select * from KHACHHANG where TrangThai=1";
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        while(rs.next()){
        DTO_KhachHang ncc = new DTO_KhachHang();
        ncc.setMaKhachHang(rs.getString("MaKH"));
        ncc.setTenKH(rs.getString("TenKH"));
        ncc.setSDT(rs.getString("SDT"));
        ncc.setDiachi(rs.getString("DiaChi"));
        ncc.setEmail(rs.getString("Email"));
        arr.add(ncc); 
        }
    } catch (SQLException ex) {
        System.out.println(ex)  ;
    } finally {
    closeConnection();
    } }
    return arr;
    }
    
    public boolean addKH(DTO_KhachHang ncc){
        boolean result = false;
        if(KetNoi()){
            try{
                String sql = "Insert into KHACHHANG values(?,?,?,?,?,?)";
                PreparedStatement preStatement = con.prepareStatement(sql);
                preStatement.setString(1, ncc.getMaKhachHang());
                preStatement.setString(2, ncc.getTenKH());
                preStatement.setString(3, ncc.getSDT());
                preStatement.setString(4,ncc.getDiachi());
                preStatement.setString(5,ncc.getEmail());
                preStatement.setInt(6, 1);
                if (preStatement.executeUpdate()>=1)
                result = true;
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally{
            closeConnection(); } }
        return result;
    }
    
    public boolean suaKH(DTO_KhachHang ncc)    
    {
        boolean result = false;
        if(KetNoi()){
        try
        {
            String sql="update KHACHHANG set MaKH=?, TenKH=?, SDT=?, Diachi=?, Email=?, TrangThai= ? where MaKH=?";
            PreparedStatement preStatement=con.prepareStatement(sql);
            preStatement.setString(1, ncc.getMaKhachHang());
            preStatement.setString(2, ncc.getTenKH());
            preStatement.setString(3, ncc.getSDT());
            preStatement.setString(4, ncc.getDiachi());
            preStatement.setString(5, ncc.getEmail());
            preStatement.setInt(6, 1);
            preStatement.setString(7, ncc.getMaKhachHang());
           
            if (preStatement.executeUpdate()>=1)
                result = true;
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally{
            closeConnection(); } }
        return result;
    }
     public boolean xoaKH(DTO_KhachHang ncc) {
        if(KetNoi()){
        try {
            String sql = "update KHACHHANG set TrangThai=? where MaKH=?";
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setInt(1, 0);
            pstm.setString(2, ncc.getMaKhachHang());
            return pstm.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
            closeConnection(); } }
        return false;
    }
    public boolean hasKHID(String id){
        boolean result = false;
        if(KetNoi()){
            try {
                String sql = "Select * from KHACHHANG where MaKH="+id+" and TrangThai=1";
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                result = rs.next();
            } catch (SQLException ex) {
                System.out.println(ex);
            } finally{
                closeConnection();
            }
        }
        return result;
    }
    public boolean hasKHIDdeleted(String id){
        boolean result = false;
        if(KetNoi()){
            try {
                String sql = "Select * from KHACHHANG where MaKH="+id+" and TrangThai=0";
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                result = rs.next();
            } catch (SQLException ex) {
                System.out.println(ex);
            } finally{
                closeConnection();
            }
        }
        return result;
    }
     public ArrayList<DTO_KhachHang>tim_kiem(String s)
    {
        ArrayList<DTO_KhachHang> dstk = new ArrayList<DTO_KhachHang>();
        if (KetNoi()) {
        try
        {
            String sql="select * from KHACHHANG where TrangThai=1 and (TenKH like N'" + s +  "%' or MaKH like N'" + s +  "%' or SDT like N'" + s + "%' or Diachi like N'" + s + "%' or Email like N'" + s + "%')" ;
            Statement statement= con.createStatement();
            ResultSet rs =statement.executeQuery(sql);
          while(rs.next())
          {
              DTO_KhachHang mh= new DTO_KhachHang();
              mh.setMaKhachHang(rs.getString(1));
              mh.setTenKH(rs.getString(2));
              mh.setSDT(rs.getString(3));
              mh.setDiachi(rs.getString(4));
              mh.setEmail(rs.getString(5));
              dstk.add(mh);  
          }
        }
        catch(Exception ex)
        {
            System.out.println(ex);
        }finally {
    closeConnection();
    } }
        return dstk;
    }
//    
//    public ArrayList<DTO_mathang> timtheoten(String tensp){
//        ArrayList<DTO_mathang> dssp = new ArrayList<DTO_mathang>();
//        try {
//            String sql = "select * form table_Mathang where tenmathang like N" + tensp + "%'";
//            Statement stm = con.createStatement();
//            ResultSet rs = stm.executeQuery(sql);
//            while(rs.next()){
//                DTO_mathang mh = new DTO_mathang();
//                dssp.set
//            }
//        }
//    }
    
}