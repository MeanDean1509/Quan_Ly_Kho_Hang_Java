/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;


public class ConnectUnit {
	public Connection connect;

	public static void main(String[] args) {

		new ConnectUnit();
	}

	
	public ConnectUnit() {
            sqlConnect();
        
        
        }
        
        public boolean sqlConnect(){
            try{
           Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String dbUrl = "jdbc:sqlserver://localhost:1433;DatabaseName=csdl_java;encrypt=false" ;
//           //String dbUrl = "jdbc:sqlserver://DESKTOP-BS85TBL\\TRUONGHIEP:1433;DatabaseName=test;encrypt=true;trustServerCertificate=true;";
            String username = "sa";
            String password= "030511";
            Connection connect= DriverManager.getConnection(dbUrl, username, password);
            //connect=con.createStatement();
            System.out.println("Thanh cong");
            return true; 
        }
            catch(Exception e){
                e.printStackTrace();
                return false; 
            }
        }
        
        public void closeConnection(){
            try{
                if (connect!=null)
                    connect.close(); 
            }catch(SQLException ex){
                System.out.println(ex);
            }
        }





}