/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;
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
    
    @Override
    public String toString(){
        return String.format("%s%s%s", username, password, email);
    }
}

