/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import adt.PlayerArrayStack;
import adt.PlayerStackInterface;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import Entity.Admin;
import Entity.Player;
import adt.LinkedList;
import adt.LinkedListInterface;

import java.util.Scanner;


public class Fill_in_the_blank {

//Admin
private static LinkedListInterface<Admin> llist;
private static Admin adminInfo;
static int index=-1;
static boolean removeSuccessful=false;
static boolean correctpassword=false;
//Player
public static String reg_username;
private static String reg_password;
private static String reg_email;

    public String username(String inputString) {
        PlayerStackInterface<Character> stack = new PlayerArrayStack<>();
        char[] letters = new char[inputString.length()];
        
        reg_username = inputString;
        
        //reverse the string from abc to cba
        int letterIndex = 0;
        for(int j = inputString.length() - 1; j >= 0; j--)
        {
            letters[letterIndex] = inputString.charAt(j);
            letterIndex++;
        }
        for (int i = 0; i < inputString.length(); ++i) {
            stack.push(letters[i]);
        }
        //reverse the string from cba to abc
        StringBuilder reversedString = new StringBuilder();
        while (!stack.Empty()) {
            reversedString.append(stack.pop());
        }
        return reversedString.toString();
    }
    
    public String password(String inputString) {
        PlayerStackInterface<Character> stack = new PlayerArrayStack<>();
        char[] letters = new char[inputString.length()];
        
        reg_password = inputString;
    
        //reverse the string from abc to cba
        int letterIndex = 0;
        for(int j = inputString.length() - 1; j >= 0; j--)
        {
            letters[letterIndex] = inputString.charAt(j);
            letterIndex++;
        }
        for (int i = 0; i < inputString.length(); ++i) {
            stack.push(letters[i]);
        }
        //reverse the string from cba to abc
        StringBuilder reversedString = new StringBuilder();
        while (!stack.Empty()) {
            reversedString.append(stack.pop());
        }
        return reversedString.toString();
        //return reg_password;
    }
    
    public String email(String inputString) {
        PlayerStackInterface<Character> stack = new PlayerArrayStack<>();
        char[] letters = new char[inputString.length()];
        
        reg_email = inputString;
    
        //reverse the string from abc to cba
        int letterIndex = 0;
        for(int j = inputString.length() - 1; j >= 0; j--)
        {
            letters[letterIndex] = inputString.charAt(j);
            letterIndex++;
        }
        for (int i = 0; i < inputString.length(); ++i) {
            stack.push(letters[i]);
        }
        //reverse the string from cba to abc
        StringBuilder reversedString = new StringBuilder();
        while (!stack.Empty()) {
            reversedString.append(stack.pop());
        }
        return reversedString.toString();
    }
    
    public static void playerMenu(){
        Scanner input = new Scanner(System.in);
        int choice;
        int selection;
        
        
        do{
            menu();
            System.out.printf("%s", "Enter Your Selection: ");
            choice = input.nextInt();
            
            if(choice == 1){
                System.out.print("\nAre you confirm to register as a player? (Yes - Y| No - N): ");
                selection = input.next().charAt(0);
                input.nextLine();

                while(Character.toUpperCase(selection)!= 'Y' && Character.toUpperCase(selection)!= 'N'){
                    System.out.println("\nPlease enter according the instruction given!!!");
                    System.out.print("Are you confirm to register as a player? (Yes - Y| No - N): ");
                    selection = input.next().charAt(0);
                    input.nextLine();
                }
                if(Character.toUpperCase(selection)=='Y'){
                    playerRegister();
                }
                else if(Character.toUpperCase(selection)=='N')
                {
                    System.out.println("\n\n");
                }
            }         
            else if(choice == 2){
                System.out.print("\nAre you confirm to login? (Yes - Y| No - N): ");
                selection = input.next().charAt(0);
                input.nextLine();

                while(Character.toUpperCase(selection)!= 'Y' && Character.toUpperCase(selection)!= 'N'){
                    System.out.println("\nPlease enter according the instruction given!!!");
                    System.out.print("\nAre you confirm to login? (Yes - Y| No - N): ");
                    selection = input.next().charAt(0);
                    input.nextLine();
                }
                if(Character.toUpperCase(selection)=='Y'){
                    login();
                }
                else if(Character.toUpperCase(selection)=='N')
                {
                    System.out.println("\n\n");
                }
            }
            else if(choice == 3){
                System.out.print("\nAre you confirm to modify player information? (Yes - Y| No - N): ");
                selection = input.next().charAt(0);
                input.nextLine();

                while(Character.toUpperCase(selection)!= 'Y' && Character.toUpperCase(selection)!= 'N'){
                    System.out.println("\nPlease enter according the instruction given!!!");
                    System.out.print("\nAre you confirm to modify player information? (Yes - Y| No - N): ");
                    selection = input.next().charAt(0);
                    input.nextLine();
                }
                if(Character.toUpperCase(selection)=='Y'){
                    modifyPlayer();
                }
                else if(Character.toUpperCase(selection)=='N')
                {
                    System.out.println("\n\n");
                }
            }
            else if(choice == 4){
                deletePlayer();
            }
            else if(choice < 1 || choice > 5){
                System.out.println("\n<<<<<<<<<<<<<<<No selection, please re-enter a vaule.>>>>>>>>>>>>>>>\n");
            }
        }while(choice != 5);
    }
    
    public static void menu() {
        System.out.printf("%s\n","    Player Menu Selection");
        System.out.printf("%s\n","-----------------------------");
        System.out.printf("%s\n","1. Register as Player");
        System.out.printf("%s\n","2. Player Login");
        System.out.printf("%s\n","3. Modify Player Information");
        System.out.printf("%s\n","4. Delete Player Information");
        System.out.printf("%s\n","5. Exit");
        System.out.printf("%s\n","-----------------------------");

    }
    
    public static void playerRegister(){
        Fill_in_the_blank regUsername = new Fill_in_the_blank ();        
        Fill_in_the_blank regPassword = new Fill_in_the_blank();
        Fill_in_the_blank regEmail = new Fill_in_the_blank(); 
        
        
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.printf("\n\n%s\n","               [Player Registration]");
        System.out.printf("%s\n",">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        
        System.out.print("Enter Player Username: ");
        String aString = scanner.nextLine();
        
        System.out.print("Enter Player Password: ");
        String bString = scanner.nextLine();
        
        System.out.print("Enter Player Email: ");
        String cString = scanner.nextLine();
        if(valEmail(cString)==false){
            System.out.println("Invalid player email format!!! Please try again!!!");
            playerRegister();
        }
        else{
           // System.out.println(playerInfo.toString());
            System.out.printf("\n\n%s\n","      [Player Registration Information]");
            System.out.printf("%s\n","*********************************************");
            System.out.println("Player Username   >>> " + regUsername.username(aString));
            System.out.println("Player Password   >>> " + regPassword.password(bString));
            System.out.println("Player Email      >>> " + regEmail.email(cString));
            System.out.printf("%s\n","*********************************************");
            System.out.println("Player register successfully.");
            System.out.printf("%s\n\n\n\n",">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        }
    }
    
    public static void login(){
        Scanner scanner = new Scanner(System.in);
        String initialUsername = "Ali Abu";
        String initialPassword= "abc1234";
        
        System.out.printf("\n\n%s\n","            [Player Login]");
        System.out.printf("%s\n","^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
        
        System.out.print("Enter Player Username: ");
        String aString = scanner.nextLine();
        
        System.out.print("Enter Player Password: ");
        String bString = scanner.nextLine();
        
        if(aString.equals(reg_username) || aString.equals(initialUsername)){
            if(bString.equals(reg_password) || bString.equals(initialPassword)){
                System.out.println("\nPlayer login successfully.\n\n");
                //>>>>>>>>>>>>>>>>>>connect to game module<<<<<<<<<<<<<<<<
            }
            else {
                System.out.println("\nInvalid player password, please try again!!!");
                invalidLogin();
            }
        } 
        else {
            System.out.println("\nInvalid player username or player password, please try again!!!");
            invalidLogin();
        }
    }  
    
    public static void invalidLogin(){
        Scanner scanner = new Scanner(System.in);
        int selection;

        System.out.print("\nDo you want to login again? (Yes - Y| No - N): ");
        selection = scanner.next().charAt(0);
        //scanner.nextLine();
        while(Character.toUpperCase(selection)!= 'Y' && Character.toUpperCase(selection)!= 'N'){
            System.out.println("\nPlease enter according the instruction given!!!");
            System.out.print("Do you want to login again? (Yes - Y| No - N): ");
            selection = scanner.next().charAt(0);
        }
        if(Character.toUpperCase(selection)=='Y'){
            login();
        }
        else if(Character.toUpperCase(selection)=='N')
        {
            System.out.println("\n\n\n\n");
        }
    }
    
    public static void modifyPlayer(){
        Fill_in_the_blank modUsername = new Fill_in_the_blank();        
        Fill_in_the_blank modPassword = new Fill_in_the_blank();
        Fill_in_the_blank modEmail = new Fill_in_the_blank(); 
        
        Scanner scanner = new Scanner(System.in);
        int selection;
        String aString;
        String bString;
        String cString;
        String tempString;
        String initialUsername = "Ali Abu";
        String initialPassword= "abc1234";
        String initialEmail = "aliabu@gmail.com";
        
        System.out.printf("\n\n%s\n","           [Modify Player Information]");
        System.out.printf("%s\n",">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        System.out.printf("%s\n","1. Player Username");
        System.out.printf("%s\n","2. Player Password");
        System.out.printf("%s\n","3. Player Email");
        System.out.printf("%s\n","4. Exit");
        System.out.printf("%s", "Enter Your Selection: ");
        selection = scanner.nextInt();
        scanner.nextLine();
        
        switch (selection) {
            case 1:
                System.out.print("Enter The Old Player Username: ");
                tempString = scanner.nextLine();
                System.out.print("Enter The New Player Username: ");
                aString = scanner.nextLine();
                if(tempString.equals(initialUsername)){
                    bString = initialPassword;
                    cString = initialEmail;
                    System.out.printf("\n\n%s\n","            [Player Information]");
                    System.out.printf("%s\n","********************************************");
                    System.out.println("Player Username   >>> " + modUsername.username(aString));
                    System.out.println("Player Password   >>> " + modPassword.password(bString));
                    System.out.println("Player Email      >>> " + modEmail.email(cString));
                    System.out.printf("%s\n","********************************************");
                    System.out.println("Player information modified successfully.");
                    System.out.printf("%s\n\n\n\n",">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
                    modifyPlayer();
                }
                else if(tempString.equals(reg_username)){
                    bString = reg_password;
                    cString = reg_email;
                    System.out.printf("\n\n%s\n","            [Player Information]");
                    System.out.printf("%s\n","********************************************");
                    System.out.println("Player Username   >>> " + modUsername.username(aString));
                    System.out.println("Player Password   >>> " + modPassword.password(bString));
                    System.out.println("Player Email      >>> " + modEmail.email(cString));
                    System.out.printf("%s\n","********************************************");
                    System.out.println("Player information modified successfully.");
                    System.out.printf("%s\n\n\n\n",">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
                    modifyPlayer();
                }
                else
                {
                    System.out.println("\nInvalid Old Player Username!!! Please Try Again!!!");
                    modifyPlayer(); 
                }
                break;
            case 2:
                System.out.print("Enter The Old Player Password: ");
                tempString = scanner.nextLine();
                System.out.print("Enter The New Player Password: ");
                bString = scanner.nextLine();
                if(tempString.equals(initialPassword)){
                    aString = initialUsername;
                    cString = initialEmail;
                    System.out.printf("\n\n%s\n","            [Player Information]");
                    System.out.printf("%s\n","********************************************");
                    System.out.println("Player Username   >>> " + modUsername.username(aString));
                    System.out.println("Player Password   >>> " + modPassword.password(bString));
                    System.out.println("Player Email      >>> " + modEmail.email(cString));
                    System.out.printf("%s\n","********************************************");
                    System.out.println("Player information modified successfully.");
                    System.out.printf("%s\n\n\n\n",">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
                    modifyPlayer();
                }
                else if(tempString.equals(reg_password)){
                    aString = reg_username;
                    cString = reg_email;
                    System.out.printf("\n\n%s\n","            [Player Information]");
                    System.out.printf("%s\n","********************************************");
                    System.out.println("Player Username   >>> " + modUsername.username(aString));
                    System.out.println("Player Password   >>> " + modPassword.password(bString));
                    System.out.println("Player Email      >>> " + modEmail.email(cString));
                    System.out.printf("%s\n","********************************************");
                    System.out.println("Player information modified successfully.");
                    System.out.printf("%s\n\n\n\n",">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
                    modifyPlayer();
                }
                else
                {
                    System.out.println("\nInvalid Old Player Password!!! Please Try Again!!!");
                    modifyPlayer(); 
                }
                break;
            case 3:
                System.out.print("Enter The Old Player Email: ");
                tempString = scanner.nextLine();
                System.out.print("Enter The New Player Email: ");
                cString = scanner.nextLine();
                if(valEmail(cString)==false || valEmail(tempString)==false){
                    System.out.println("Invalid player email format!!! Please try again!!!");
                    modifyPlayer();
                }
                else{
                    if(tempString.equals(initialEmail)){
                        aString = initialUsername;
                        bString = initialPassword;
                        System.out.printf("\n\n%s\n","            [Player Information]");
                    System.out.printf("%s\n","********************************************");
                    System.out.println("Player Username   >>> " + modUsername.username(aString));
                    System.out.println("Player Password   >>> " + modPassword.password(bString));
                    System.out.println("Player Email      >>> " + modEmail.email(cString));
                    System.out.printf("%s\n","********************************************");
                    System.out.println("Player information modified successfully.");
                    System.out.printf("%s\n\n\n\n",">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
                        modifyPlayer();
                    }
                    else if(tempString.equals(reg_email)){
                        aString = reg_username;
                        bString = reg_password;
                        System.out.printf("\n\n%s\n","            [Player Information]");
                    System.out.printf("%s\n","********************************************");
                    System.out.println("Player Username   >>> " + modUsername.username(aString));
                    System.out.println("Player Password   >>> " + modPassword.password(bString));
                    System.out.println("Player Email      >>> " + modEmail.email(cString));
                    System.out.printf("%s\n","********************************************");
                    System.out.println("Player information modified successfully.");
                    System.out.printf("%s\n\n\n\n",">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
                        modifyPlayer();
                    }
                    else
                    {
                        System.out.println("\nInvalid Old Player Email!!! Please Try Again!!!");
                        modifyPlayer(); 
                    }
                }
                break;
            case 4:
                System.out.println("\n\n\n\n");
                break;
            default:
                System.out.println("Invalid number!!! Please re-enter number[1-4]");
                modifyPlayer();
                break;
        }
        
    }
    
    public static void deletePlayer(){
        Scanner scanner = new Scanner(System.in);
        int selection;
        
        reg_username = null;
        reg_password = null;
        reg_email = null;
        System.out.print("\nAre you confirm to delete the player information? (Yes - Y| No - N): ");
        selection = scanner.next().charAt(0);
        scanner.nextLine();
        
        while(Character.toUpperCase(selection)!= 'Y' && Character.toUpperCase(selection)!= 'N'){
            System.out.println("\nPlease enter according the instruction given!!!");
            System.out.print("Are you confirm to delete the player information? (Yes - Y| No - N): ");
            selection = scanner.next().charAt(0);
            scanner.nextLine();
        }
        if(Character.toUpperCase(selection)=='Y'){
            
            System.out.printf("\n%s",">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
            System.out.println("\n     Player information deleted successfully.");
            System.out.printf("%s\n\n\n\n",">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        }
        else if(Character.toUpperCase(selection)=='N')
        {
            System.out.println("\n\n");
        }
    }
    
    public static boolean valEmail(String input){
        String emailRegex = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
        Pattern emailPat = Pattern.compile(emailRegex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = emailPat.matcher(input);
        return matcher.find();
    }
 

public static void Admin()
{
 llist.add(new Admin("Ali","Abc111!","012-212-1111","keng@gmail.com"));
 llist.add(new Admin("Baba","Abc222!","012-222-1212","choon@hotmail.com"));
 llist.add(new Admin("Chon","Abc333!","012-321-1213","kkk@hotmail.com"));
 llist.add(new Admin("Dake","Abc123!","017-323-1111","kheng@gmail.com"));
 
   boolean valid;
   int choice=0;
   valid=AdminLogin();

   if(valid==true||correctpassword==true)
   {   
   while(choice!=7&&valid==true)
   {
    if(removeSuccessful==true)
    {
     System.out.println(index);   
     valid=AdminLogin();   
    }
    
   if(valid==true||correctpassword==true)
   {
   System.out.println(llist.getEntry(index));
   System.out.println("Admin Module");
   System.out.println("1. ADD NEW ADMIN");
   System.out.println("2. MODIFY ADMIN");
   System.out.println("3. SEARCH ADMINS");
   System.out.println("4. TERMINATE ADMIN ACCOUNT");
   System.out.println("5. DELETE PLAYER");
   System.out.println("6. ACCESS QUESTION SYSTEM");
   System.out.println("7. Quit System");
   
   System.out.print("Function[1-7]: ");
   Scanner scanner = new Scanner(System.in);
   choice = scanner.nextInt();
   
   switch(choice)
   {
       case 1:
           addAdmin();
           break;
       case 2:
           modifyAdminInfo();
           break;
       case 3:
           searchAdmin();
           break;
       case 4:
           removeAdmin();
           break;
       case 5:
           deletePlayer();
       case 6:   
       default:
               break;
           
   }

   }
   }
   }
   else
       System.out.println("Not allow access Admin system");
        
  

  }

public static void addAdmin()      
{
 char ans;
 String name;
 String phone,email ;
 String newpassword;
Scanner scanner = new Scanner(System.in); 
 do{
 System.out.println("Add");
 do{
     System.out.print("Name: ");
 
 name = scanner.nextLine();
 if(adminInfo.validateName(name)==false)
 {
 System.out.println("Must more than 2 character, not  ontain integer");
 }
 if(llist.contains(name)==true)
 {
 System.out.println("Found repeated name");
 }
 }while(adminInfo.validateName(name)!=true||llist.contains(name)==true);
 
 do{
 System.out.print("Password: ");
 newpassword = scanner.nextLine();
 if(adminInfo.isValidPassword(newpassword)==false)
 {
 System.out.println("Fomat:[at least 5 character] & [a Uppercase] & [a Lowercase] & [a Digit]");
 }
  }while(adminInfo.isValidPassword(newpassword)!=true);
 
 do{
 System.out.print("Phone: ");    
 phone = scanner.nextLine();

 if(adminInfo.validatePhone(phone)==false)
 {
 System.out.println("Phone Number must be in the form 01X-XXX-XXXX");
 }
 if(llist.contains(phone)==true)
 {
 System.out.println("Found repeated phone");
 }
 }while(adminInfo.validatePhone(phone)!=true||llist.contains(phone)==true);

do{ 
 System.out.print("Email: ");
 email=scanner.nextLine();
 if(adminInfo.isValidEmail(email)==false)
 {
  System.out.println("Email must be in the form XXXXX@mail.com");
 }
 if(llist.contains(email)==true)
 {
 System.out.println("Found repeated email");
 }
}while(adminInfo.isValidEmail(email)!=true||llist.contains(email)==true);

 llist.add(new Admin(name,newpassword,phone,email));
 System.out.println("Add new Admin Successfully");
 System.out.println("Want Add Again");
 System.out.print("Yes? : ");
 ans = scanner.next().charAt(0);
 }while(ans=='y');
  }

public static void modifyAdminInfo()
  {
    Scanner scanner = new Scanner(System.in);
    char cont;
    String ans="";
    int choice;
    do{
     
    System.out.println(llist.getEntry(index));
    System.out.println(index);
    
    System.out.println("Modify\n1.Name\n2.Password\n3.Phone\n4.Email");
    do{
    System.out.print("Option[1-4]: ");
    
    choice = scanner.nextInt();
    scanner.nextLine();
    }while(choice<1||choice>=5);
    if(choice==1)
    {
    do{
     System.out.print("Name: ");
 
     ans= scanner.nextLine();
    if(adminInfo.validateName(ans)==false)
    {
        System.out.println("Must more than 2 character, not contain integer");
    }
        if(llist.contains(ans)==true)
        {
            System.out.println("Found repeated name");
        }
    }while(adminInfo.validateName(ans)!=true||llist.contains(ans)==true);
    }
    
    else if(choice==2)
    {
 do{
    System.out.print("Password: ");
    ans = scanner.nextLine();
        if(adminInfo.isValidPassword(ans)==false)
        {
            System.out.println("Fomat:[at least 5 character] & [a Uppercase] & [a Lowercase] & [a Digit]");
        }
     }while(adminInfo.isValidPassword(ans)!=true);
    }
    
    else if(choice ==3)
    {
  do{
     System.out.print("Phone: ");    
     ans = scanner.nextLine();

        if(adminInfo.validatePhone(ans)==false)
        {
            System.out.println("Phone Number must be in the form 01X-XXX-XXXX");
        }
        
        if(llist.contains(ans)==true)
        {
            System.out.println("Found repeated phone");
        }
    }while(adminInfo.validatePhone(ans)!=true||llist.contains(ans)==true);
   }
    
    else if(choice ==4)
    {
  do{
     System.out.print("Email: ");    
     ans = scanner.nextLine();

        if(adminInfo.isValidEmail(ans)==false)
        {
            System.out.println("Email must be in the form XXXX@mail.com");
        }
        
        if(llist.contains(ans)==true)
        {
            System.out.println("Found repeated Email");
        }
    }while(adminInfo.isValidEmail(ans)!=true||llist.contains(ans)==true);
   }
    
    llist.replace(index,choice,ans);
    System.out.println(llist.getEntry(index));
    System.out.print("Continue? [Yes:y|No:other]: ");
    cont=scanner.next().charAt(0);
    }while(cont=='y');
  }
  
public static boolean AdminLogin()
  {
  int count=2;
  char ans=' ';
  String name;
  
   System.out.println("LOG IN");
   do{ 
   System.out.print("Username: ");
   Scanner scanner = new Scanner(System.in);
  
    name = scanner.nextLine();
   index = llist.indexOf(name);

   if(index==-1)
   {
       System.out.println("Invalid Username");
       System.out.print("Reenter?[Y=Yes] [Other=No]: ");
       ans=scanner.next().charAt(0);

   }

 
   }while((ans=='Y'||ans=='y')&&index==-1);
   

  if(index!=-1)
  {
  System.out.print("Password: ");
  Scanner scanner = new Scanner(System.in);
  String password = scanner.nextLine();
  boolean valid=false;
 // System.out.println(llist.test(index, password));
  int index2=llist.indexOf(password);
  if(index==index2)
  {
  valid=true;
  return valid;
  }
  else if(valid == false)
  {
    do{  
      System.out.println("Wrong password\nYou still have [" + count+ "] chance");
      System.out.print("Please reenter: ");
       password = scanner.nextLine();
       count--;
      if(index==llist.indexOf(password))
      {
      count=-1; 
      return true;
      
      }
       if(count==0)
      {

         System.out.println("Forgot Password?");
         System.out.print("Yes[y] No[other]:");
         ans = scanner.next().charAt(0);
            if(ans=='y'||ans=='Y')
             {
                AdminForgotPassword();
             }
          }

    }while(count!=0);
  }
  }
  else 
  return false; 
  
  return false;
  }

public static void removeAdmin()
{
 
Scanner scanner = new Scanner(System.in);
char ans;
System.out.println("You want to quit your job?");
System.out.print("Yes[Y] No[Other] :");
ans = scanner.next().charAt(0);
if(ans=='Y'||ans=='y')
{
llist.remove(index);
System.out.println(index);
removeSuccessful=true;
index=0;
}
else
removeSuccessful=false;
}

public static boolean AdminForgotPassword()
 {
  String phone,password,email="";
  boolean valid;
  Scanner scanner= new Scanner(System.in);
  System.out.print("Name? :");
  String name = scanner.nextLine();
  System.out.print("Phone number? :");
  do{
  phone = scanner.nextLine();
  valid=adminInfo.validatePhone(phone);
  if(valid==false)
  {
    System.out.println("Phone Number must be in the form 01X-XXX-XXXX");
    System.out.print("Please reenter:");
  }
  }while(adminInfo.validatePhone(phone)==false);
  System.out.print("Email? :");
  do{
  email = scanner.nextLine();
  valid=adminInfo.isValidEmail(email);
  if(valid==false)
  {
    System.out.println("Email must be in the form XXX@mail.com");
    System.out.print("Please reenter:");
  }
  }while(adminInfo.isValidEmail(email)==false);
  
  int indexphone = llist.indexOf(phone);
  int indexname =llist.indexOf(name);
  int indexemail = llist.indexOf(email);
  if(indexname!=index||indexphone!=index||indexemail!=index)
  {
      if(indexname!=index)
      System.out.print("Wrong Username!!!!"); 
      if(indexphone!=index)
      System.out.print("Wrong Phone number!!!!"); 
      if(indexemail!=index)
      System.out.println("Wrong Email!!!");
     
                        System.out.println("You are not allowed to access Admin System");
      return correctpassword;
  }

  if(indexname==index&&indexphone==index&&indexemail==index)
  {
   correctpassword=true;   
   System.out.println("Your account is indenticate");   
 do{
 System.out.print("Password: ");
 password = scanner.nextLine();
 if(adminInfo.isValidPassword(password)==false)
 {
 System.out.println("Fomat:[at least 5 character] & [a Uppercase] & [a Lowercase] & [a Digit]");
 }
  }while(adminInfo.isValidPassword(password)!=true);
   llist.replace(index, 2, password);
   return correctpassword;
  }
  return correctpassword;
  }   
  
public static void searchAdmin()
  {  
      int choice;
      String ans;
      int indexchoice;
      Scanner scanner = new Scanner(System.in);
      System.out.println("We have "+llist.getLength()+" + Admin");
      System.out.println("1. Show all Admin Info");
      System.out.println("2. Show certain Admin Info");
      choice = scanner.nextInt();
      if(choice==1)
      {
          System.out.println("ID\tName\t\tPassword\tPhone\t\tEmail");
          System.out.println(llist.toString());
      }
      else if (choice==2)
      {
          System.out.println("Name of the Admin:");
          ans =scanner.nextLine();
          
      }
  }  
  
public static void main(String[] args) {
   llist = new LinkedList<>();
   adminInfo = new Admin();
   int choice =0;
 

    System.out.println("Fill In The Blank");
    while(choice!= 3)
    {    
    System.out.println("1. Player");
    System.out.println("2. Admin");
    System.out.println("3. Quit");
    System.out.print("Are you a? [1-2] :");
    Scanner scanner = new Scanner(System.in);
    choice = scanner.nextInt();
    
    switch(choice)
    {
        case 1:
            playerMenu();
            
            break;
            
        case 2:
            Admin();
            break;
        
        case 3:    
            break;
        
    }
    }

 }
    
  
}
