/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package salesmanagementsystem;


import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

/**
 *
 * @author DELL
 */
public class LoginController {
    
    public User logIn(String userName, String password){           // Gets user name & password and validate before loging in 
                                                                               
        User user = null ;                                                      
        String URL = "jdbc:mysql://localhost:3308/sales_db";                   
        String USER = "root";
        String PASSWORD = "";
        String sql = " SELECT * FROM users WHERE user_name =? AND password = BINARY ?;"; //BINARY checks if the password is same as the one in the database
                                                                                            
        try{
            Connection con = DatabaseConnection.getConnection(URL, USER, PASSWORD);
            PreparedStatement preStmt = con.prepareStatement(sql);
            
            preStmt.setString(1,userName);
            preStmt.setString(2, password);
            
            ResultSet rs = preStmt.executeQuery();
            
            while(rs.next()){
                user = new User(
                        rs.getInt("user_id"),
                        rs.getString("user_name"),
                        rs.getString("password")
                );
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return user;
    }
}
