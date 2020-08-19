/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Admin{

 
    public String username;
    public String password;
    public String phone;
    public String email;
    public static int AdminID=1000;
    private int length=0;


  
    public Admin(String username,String  password,String phone,String email)
    {
      
    this.username=username;
    this.password=password;   
    this.length=length++;
    this.phone =phone;
    this.email = email;
    }
    
    public Admin() {
    this.username=username;
    this.password=password;  
   // this.phone =phone;
    //this.email = email;
    }
   
    public String getusername()
    {
    return this.username;
    }
    
    public String getpassword()
    {
    return this.password;
    }
    
    public void setpassword(String password)
    {
     this.password=password;
      
    }
    
    public void setusername(String username)
    {
     this.username = username;
    }    

    
    public String toString() {
    return String.format("%d\t%s\t\t%s\t\t%s\t%s",AdminID++, username,password,phone,email);
  }

    public boolean validatePhone(String phone)
    {
    
      Pattern pattern = Pattern.compile("\\d{3}-\\d{3}-\\d{4}");
      Matcher matcher = pattern.matcher(phone);

      if (matcher.matches()) {
          if(phone.charAt(0)!='0'||phone.charAt(1)!='1')
          {
          return false;
          }
          return true;
      }
      else
      {
          return false;
 
      }
    }

    public boolean validateName(String name) 
    { 
  
        // Regex to check valid username. 
        String regex = "^[aA-zZ]\\w{2,29}$"; 
  
        // Compile the ReGex 
        Pattern p = Pattern.compile(regex); 
         
        // If the username is empty 
        // return false 
        if (name == null) { 
            return false; 
        } 
  
        // Pattern class contains matcher() method 
        // to find matching between given username 
        // and regular expression. 
        Matcher m = p.matcher(name); 
  
        // Return if the username 
        // matched the ReGex 
        return m.matches(); 
    } 
    
    public boolean isValidPassword(String password) 
    { 
  
        // Regex to check valid password. 
        String regex = "^(?=.*[0-9])"
                       + "(?=.*[a-z])(?=.*[A-Z])"
                       + "(?=\\S+$).{5,20}$"; 
  
        // Compile the ReGex 
        Pattern p = Pattern.compile(regex); 
  
        // If the password is empty 
        // return false 
        if (password == null) { 
            return false; 
        } 
  
        // Pattern class contains matcher() method 
        // to find matching between given password 
        // and regular expression. 
        Matcher m = p.matcher(password); 
  
        // Return if the password 
        // matched the ReGex 
        return m.matches(); 
    }
    
    public boolean isValidEmail(String email) {
      String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
      return email.matches(regex);
   }
    
    
}