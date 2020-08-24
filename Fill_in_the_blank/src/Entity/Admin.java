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
    public int AdminID=1004;
    private int length=0;


  
    public Admin(int AdminID,String username,String  password,String phone,String email)
    {
      
    this.username=username;
    this.password=password;   
    this.length=length++;
    this.phone =phone;
    this.email = email;
    this.AdminID = AdminID++;
    }
    
    public Admin() {
    this.username=username;
    this.password=password;  
   // this.phone =phone;
    //this.email = email;
    }
   
   

    
    public String toString() {
    return String.format("%d\t%s\t\t%s\t\t%s\t%s",AdminID, username,password,phone,email);
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
  
     
        String regex = "^[aA-zZ]\\w{2,29}$"; 
  

        Pattern p = Pattern.compile(regex); 
         

        if (name == null) { 
            return false; 
        } 
  

        Matcher m = p.matcher(name); 

        return m.matches(); 
    } 
    
    public boolean isValidPassword(String password) 
    { 
  
 
        String regex = "^(?=.*[0-9])"
                       + "(?=.*[a-z])(?=.*[A-Z])"
                       + "(?=\\S+$).{5,20}$"; 
  

        Pattern p = Pattern.compile(regex); 
  

        if (password == null) { 
            return false; 
        } 
  

        Matcher m = p.matcher(password); 

        return m.matches(); 
    }
    
    public boolean isValidEmail(String email) {
      String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
      return email.matches(regex);
   }
   
}
