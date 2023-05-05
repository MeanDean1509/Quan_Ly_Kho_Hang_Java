/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
/**
 *
 * @author hieu
 */
public class KetNoicsdl 
{
    protected Connection con;
    public boolean KetNoi()
    {
        try
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String dbUrl = "jdbc:sqlserver://localhost:1433;DatabaseName=QLKH;encrypt=true;trustServerCertificate=true;";
            String username = "sa";
            String password= "dienkhang1509";
            con=DriverManager.getConnection(dbUrl, username, password);
            return true;
        }
           catch(Exception ex)
            {
                ex.printStackTrace();
                return false;
            }        
    }
    public void closeConnection() {
    try {
        if (con!=null)
            con.close();
        } catch (SQLException ex) 
            {
                System.out.println(ex); 
            }
    }
    
}
