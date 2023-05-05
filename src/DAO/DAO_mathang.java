/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import DTO.DTO_mathang;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author hieu
 */
public class DAO_mathang extends KetNoicsdl{
    
    
    public ArrayList<DTO_mathang> getAllMathang(){
    ArrayList<DTO_mathang> arr = new ArrayList<DTO_mathang>();
    if (KetNoi()) {
        try {
        String sql = "Select * from table_Mathang";
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        while(rs.next()){
        DTO_mathang mh = new DTO_mathang();
        mh.setMaMatmang(rs.getInt("mamathang"));
        mh.setTenMathang(rs.getString("tenmathang"));
        mh.setMaNhacungcap(rs.getInt("manhacungcap"));
        arr.add(mh); 
        }
    } catch (SQLException ex) {
        System.out.println(ex)  ;
    } finally {
    closeConnection();
    } }
    return arr;
    }
    
    public boolean addMathang(DTO_mathang mth){
        boolean result = false;
        if(KetNoi()){
            try{
                String sql = "Insert into table_Mathang values(?,?,?)";
                PreparedStatement preStatement = con.prepareStatement(sql);
                preStatement.setInt(1, mth.getMaMatmang());
                preStatement.setString(2, mth.getTenMathang());
                preStatement.setInt(3, mth.getMaNhacungcap());
                if (preStatement.executeUpdate()>=1)
                result = true;
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally{
            closeConnection(); } }
        return result;
    }
    
    public boolean suaMathang(DTO_mathang mth)    
    {
        boolean result = false;
        if(KetNoi()){
        try
        {
            String sql="update table_Mathang set mamathang=?, tenmathang=?, manhacungcap=? where mamathang=?";
            PreparedStatement preStatement=con.prepareStatement(sql);
            preStatement.setInt(1, mth.getMaMatmang());
            preStatement.setString(2, mth.getTenMathang());
            preStatement.setInt(3, mth.getMaNhacungcap());
            preStatement.setInt(4, mth.getMaMatmang());

            if (preStatement.executeUpdate()>=1)
                result = true;
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally{
            closeConnection(); } }
        return result;
    }
//     public boolean xoaMathang(String maSP) {
//        try {
//            String sql = "update KHOHANG set isdelete = ? WHERE masp = ?";
//            PreparedStatement pstm = con.prepareStatement(sql);
//            pstm.setBoolean(1, true);
//            pstm.setString(2, maSP);
//
//            return pstm.executeUpdate() > 0;
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }
//        return false;
//    }
    public boolean hasMathangID(int id){
        boolean result = false;
        if(KetNoi()){
            try {
                String sql = "Select * from table_Mathang where mamathang="+id;
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
     public ArrayList<DTO_mathang> timtheoten(String tensp)
    {
        ArrayList<DTO_mathang> dstk = new ArrayList<DTO_mathang>();
        try
        {
            String sql="select * from KHOHANG where tensp like N'" + tensp +  "%'" ;
            Statement statement= con.createStatement();
            ResultSet rs =statement.executeQuery(sql);
          while(rs.next())
          {
              DTO_mathang mh= new DTO_mathang();
              mh.setMaMatmang(rs.getInt(1));
              mh.setTenMathang(rs.getString(2));
              mh.setMaNhacungcap(rs.getInt(3));
              dstk.add(mh);  
          }
        }
        catch(Exception ex)
        {
            System.out.println(ex);
        }
        return dstk;
    }
    
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