/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package salesmanagementsystem;

/**
 *
 * @author DELL
 */
public class Customer extends Person {
    
    private int customerId;
    private String phoneNo;
    private User user;
    
    
    // Setters and Getters
    // setters
    public void setCustomerId(int customerId){
        this.customerId = customerId;
    }
    public void setPhoneNo(String phoneNo){
        this.phoneNo = phoneNo;
    }
    public void setUser(User user){
        this.user = user;
    }
    
    
    //getters
    public int getCustomerId(){
        return customerId;
    }
    public String getPhoneNo(){
        return phoneNo;
    }
    public User getUser(){
        return user;
    }
    
    
    // Constructors
    
    // Adding a new customer
    public Customer(String name, String phoneNo,User user)  
    {
        super(name);
        this.phoneNo = phoneNo;
        this.user = user;
    }
    
    //Search customer using customer id
    public Customer(int customerId){
        this.customerId = customerId;
    }
    
    
    // view customer
    public Customer(int customerId, String name,String phoneNo) 
    {
        super(name);
        this.customerId = customerId;
        this.phoneNo = phoneNo;
    }
    
    
    // Select customer using phone
    public Customer(String phoneNo)  
    {
        this.phoneNo = phoneNo;
    }
    
    //Default constructor
    public Customer() 
    {
        super();
    }
      
    
    
    @Override
    public String toString(){
        String msg = "Customer Id: "+getCustomerId()+
                " Customer name: "+ super.getName()+
                " Phone: "+ getPhoneNo()+
                " Created by: "+ getUser();
        
        return msg;
    }
}
