/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package salesmanagementsystem;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DELL
 */
public class CustomerDAO {
    
    
    static String URL = "jdbc:mysql://localhost:3308/sales_db"; 
    static String USER = "root";
    static String PASSWORD = "";
    
    
    public Customer addCustomer(String cName, String phone, int userId){
        // adds a customer to the database
        Customer customer = null;
        String sql = "INSERT INTO customer (customer_name, phone_no,created_by) VALUES (?,?,?)";
        String sql1 = "SELECT customer_id FROM customer WHERE phone_no = ?";
        
        try{
            Connection con = DatabaseConnection.getConnection(URL, USER, PASSWORD);
            PreparedStatement preStmt = con.prepareStatement(sql);
            
            preStmt.setString(1, cName);
            preStmt.setString(2, phone);
            preStmt.setInt(3, userId);
            
            preStmt.executeUpdate();
            
            PreparedStatement ps = con.prepareStatement(sql1);
            ps.setString(1, phone);
            
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                customer = new Customer(
                        rs.getInt("customer_id")
                );
            }
            
            con.close();
            
        }
        catch(SQLException e){
            e.printStackTrace();
        }
       return customer; 
    }
    
   
    
    public List<Customer> viewCustomerList() {
        // retrieve list of customers
        List<Customer> customers = new ArrayList<>();
        String sql = "SELECT customer_id, customer_name, phone_no FROM customer";

        try {
            
            Connection con = DatabaseConnection.getConnection(URL, USER, PASSWORD);
            PreparedStatement preStmt = con.prepareStatement(sql);
            
            ResultSet rs = preStmt.executeQuery() ;

            while (rs.next()) {
                Customer c = new Customer(
                    rs.getInt("customer_id"),
                    rs.getString("customer_name"),
                    rs.getString("phone_no")
                );
                customers.add(c);
            }
        } 
        catch (SQLException e) {
        e.printStackTrace();
    }
    return customers;
}
    
    
 
    public Customer getCustomerByPhone(String phone) {
        // Selects a customer using phone number
        Customer customer = null;
        String sql = "SELECT customer_id, customer_name, phone_no FROM customer WHERE phone_no = ?";

        try (Connection con = DatabaseConnection.getConnection(URL, USER, PASSWORD);
             PreparedStatement preStmt = con.prepareStatement(sql)) {

            preStmt.setString(1, phone);
            try (ResultSet rs = preStmt.executeQuery()) {
                if (rs.next()) {
                    customer = new Customer(
                        rs.getInt("customer_id"),
                        rs.getString("customer_name"),
                        rs.getString("phone_no")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customer;
    }   
}
