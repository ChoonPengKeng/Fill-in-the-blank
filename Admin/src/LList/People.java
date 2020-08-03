/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LList;

/**
 *
 * @author ACER
 */
import java.io.Serializable;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author ACER
 */
public class People{

 
    String username;
    String  password;
    private int getIndex;
    private int length=0;

    static boolean userLogedIn;

  
    public People(String username,String  password)
    {
      
    this.username=username;
    this.password=password;   
    this.length=length++;
   
    }
    
    People() {
    this.username=username;
    this.password=password;  
    }
   
    public String getusername()
    {
    return username;
    }
    
    public String getpassword()
    {
    return password;
    }
    
    public String setpassword(String password)
    {
     return this.password=password;
      
    }
    
    public String setusername(String username)
    {
    return this.username = username;
    }    

    
    public String toString() {
    return String.format("%s%s", username,password);
  }



}