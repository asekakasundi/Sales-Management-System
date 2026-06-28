/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package salesmanagementsystem;

/**
 *
 * @author DELL
 */

import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.SQLException;

public class DatabaseConnection {
    
    // The connection string: protocol (jdbc), sub-protocol (mysql), 
    // host (localhost), port (3306), and the database name (sales_db)
    // Database credentials
   
    

    public static Connection getConnection(String URL,String USER, String PASSWORD ) throws     SQLException {
        Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
        con.setAutoCommit(true);
        return con;
    }
    
    
}
