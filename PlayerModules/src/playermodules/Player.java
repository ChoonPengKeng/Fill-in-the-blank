
package playermodules;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Player{
    
    public String username;
    public String password;
    public String email;
    
    public Player(){
        username = null;
        password = null;
        email = null;
    }
    
    public Player(String username, String password, String email){
        this.username = username;
        this.password = password;
        this.email = email;
    }
    
    //setter
    public void setUsername(String username){
        this.username = username;
    }
    public void setPassowrd(String password){
        this.password = password;
    }
    public void setEmail(String email){
        this.email = email;
    }
    
    //getter
    public String getUsername(){
        return username;
    }
    public String getPassowrd(){
        return password;
    }
    public String getEmail(){
        return email;
    }
    
    public static boolean valEmail(String input){
        String emailRegex = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
        Pattern emailPat = Pattern.compile(emailRegex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = emailPat.matcher(input);
        return matcher.find();
    }
    
    public static boolean valPassword(String input){
        String passwordRegex = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})";
        Pattern passwordPat = Pattern.compile(passwordRegex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = passwordPat.matcher(input);
        return matcher.find();
    }
    
    @Override
    public String toString(){
        return String.format("%s%s%s", username, password, email);
    }
}
