/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import DTO.DTO_NCC;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author hieu
 */
public class DAO_NCC extends KetNoicsdl{
    
    
    public ArrayList<DTO_NCC> getAllNCC(){
    ArrayList<DTO_NCC> arr = new ArrayList<DTO_NCC>();
    if (KetNoi()) {
        try {
        String sql = "Select * from NCC where TrangThai=1";
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        while(rs.next()){
        DTO_NCC ncc = new DTO_NCC();
        ncc.setMaNCC(rs.getString("MaNCC"));
        ncc.setTenNCC(rs.getString("TenNCC"));
        ncc.setSDT(rs.getString("SDT"));
        ncc.setDiachi(rs.getString("DiaChi"));
        arr.add(ncc); 
        }
    } catch (SQLException ex) {
        System.out.println(ex)  ;
    } finally {
    closeConnection();
    } }
    return arr;
    }
    
    public boolean addNCC(DTO_NCC ncc){
        boolean result = false;
        if(KetNoi()){
            try{
                String sql = "Insert into NCC values(?,?,?,?,?)";
                PreparedStatement preStatement = con.prepareStatement(sql);
                preStatement.setString(1, ncc.getMaNCC());
                preStatement.setString(2, ncc.getTenNCC());
                preStatement.setString(3, ncc.getSDT());
                preStatement.setString(4,ncc.getDiachi());
                preStatement.setInt(5, 1);
                if (preStatement.executeUpdate()>=1)
                result = true;
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally{
            closeConnection(); } }
        return result;
    }
    
    public boolean suaNCC(DTO_NCC ncc)    
    {
        boolean result = false;
        if(KetNoi()){
        try
        {
            String sql="update NCC set MaNCC=?, TenNCC=?, SDT=?, Diachi=?, TrangThai= ? where MaNCC=?";
            PreparedStatement preStatement=con.prepareStatement(sql);
            preStatement.setString(1, ncc.getMaNCC());
            preStatement.setString(2, ncc.getTenNCC());
            preStatement.setString(3, ncc.getSDT());
            preStatement.setString(4, ncc.getDiachi());
            preStatement.setInt(5, 1);
            preStatement.setString(6, ncc.getMaNCC());
           
            if (preStatement.executeUpdate()>=1)
                result = true;
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally{
            closeConnection(); } }
        return result;
    }
     public boolean xoaNCC(DTO_NCC ncc) {
        if(KetNoi()){
        try {
            String sql = "update NCC set TrangThai=? where MaNCC=?";
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setInt(1, 0);
            pstm.setString(2, ncc.getMaNCC());
            return pstm.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
            closeConnection(); } }
        return false;
    }
    public boolean hasNCCID(String id){
        boolean result = false;
        if(KetNoi()){
            try {
                String sql = "Select * from NCC where MaNCC="+id+" and TrangThai=1";
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
    public boolean hasNCCIDdeleted(String id){
        boolean result = false;
        if(KetNoi()){
            try {
                String sql = "Select * from NCC where MaNCC="+id+" and TrangThai=0";
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
     public ArrayList<DTO_NCC> timtheoten(String s)
    {
        ArrayList<DTO_NCC> dstk = new ArrayList<DTO_NCC>();
        if (KetNoi()) {
        try
        {
            String sql="select * from NCC where TrangThai=1 and (TenNCC like N'" + s +  "%' or MaNCC like N'" + s +  "%' or SDT like N'" + s + "%' or Diachi like N'" + s + "%')" ;
            Statement statement= con.createStatement();
            ResultSet rs =statement.executeQuery(sql);
          while(rs.next())
          {
              DTO_NCC mh= new DTO_NCC();
              mh.setMaNCC(rs.getString(1));
              mh.setTenNCC(rs.getString(2));
              mh.setSDT(rs.getString(3));
              mh.setDiachi(rs.getString(4));
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