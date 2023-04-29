/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.ResultSet;
import java.util.ArrayList;

import DTO.adminDTO;
import java.beans.Statement;

import java.sql.Connection;
import java.sql.DriverManager;

public class taikhoanDAO {
	private Connection con; 
        
        
        
        public boolean sqlConnect(){
            try{
           Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String dbUrl = "jdbc:sqlserver://localhost:1433;DatabaseName=csdl_java;encrypt=false" ;
//           //String dbUrl = "jdbc:sqlserver://DESKTOP-BS85TBL\\TRUONGHIEP:1433;DatabaseName=test;encrypt=true;trustServerCertificate=true;";
            String username = "sa";
            String password= "030511";
            con= DriverManager.getConnection(dbUrl, username, password);
            //connect=con.createStatement();
            System.out.println("Thanh cong");
            return true; 
        }
            catch(Exception e){
                e.printStackTrace();
                return false; 
            }
        }
        
	
	public ArrayList<adminDTO> docDB(String condition, String orderBy) throws Exception {
		// kết nối CSDL
		
                
		
		ArrayList<adminDTO> admin = new ArrayList<>();
                if(sqlConnect()){
                 try{
                  String sql = "Select * FROM tbl_admin"; 
                  Statement stmt = con.createStatement();
                  ResultSet rs = 
                
		while (result.next()) {
			adminDTO ad = new adminDTO();
			ad.setAdminId(result.getString("adminId"));
			ad.setAdminName(result.getString("adminName"));
			ad.setAdminUser(result.getString("adminUser"));
			ad.setAdminPass(result.getString("adminPass"));
			admin.add(ad);
		}
		
                }catch(Exception e){
                    
                }
                return admin;
	}
//	public ArrayList<adminDTO> docDB(String condition) throws Exception {
//		return docDB(condition, null);
//	}
//
//	public ArrayList<adminDTO> docDB() throws Exception {
//		return docDB(null);
//	}
//        
//        
        
}
