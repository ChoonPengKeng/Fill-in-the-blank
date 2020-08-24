/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import adt.PlayerArrayStack;
import adt.PlayerStackInterface;
import adt.ArrayList;
//import adt.ArrayListInterface;
import java.util.*;
import Entity.Admin;
import Entity.Player;
import Entity.Ranking;
import Entity.StoreQuestion;
import adt.LinkedList;
import adt.LinkedListInterface;
import adt.SortedArrayList;
import java.awt.Color;
import java.util.Scanner;



public class Fill_in_the_blank {
public static final String BLUE = "\033[0;38m";
//Admin
private static LinkedListInterface<Admin> llist;
private static Admin adminInfo;
static int index=-1;
static boolean removeSuccessful=false;
static boolean correctpassword=false;
  static String Blue = "\033[0m";
  static String Red = "\033[0;31m";

//Player
private static Player playerList;
public static String reg_username;
private static String reg_password;
private static String reg_email;
       static Fill_in_the_blank regUsername = new Fill_in_the_blank();        
       static Fill_in_the_blank regPassword = new Fill_in_the_blank();
       static Fill_in_the_blank regEmail = new Fill_in_the_blank();
       

//Ranking
public static String converter;
public static int input1;
public static int addScore2;
public static int easyScorecount=0,mediumScorecount=0,hardScorecount=0;
public static int easyScore=2,mediumScore=5,hardScore=10;
static int totalScore=0;
public static String addScore, deleteScore, searchScore;
public static Scanner scanner = new Scanner(System.in);
public static Ranking ranking = new Ranking(0, null);
public static SortedArrayList<Ranking> scoreList = new SortedArrayList<Ranking>();

 
//Question
  public  static StoreQuestion StoreQuestion;
  public  static ArrayList<StoreQuestion> easy = new ArrayList<StoreQuestion>();
  public  static ArrayList<StoreQuestion> medium = new ArrayList<StoreQuestion>();
  public  static ArrayList<StoreQuestion> hard = new ArrayList<StoreQuestion>();
  public static final Color VERY_LIGHT_RED = new Color(255,102,102);

//Lai Hao Han Player  
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
        System.out.printf(Blue+"%s\n","-----------------------------");
        System.out.printf(Blue+"%s\n","    Player Menu Selection");
        System.out.printf(Blue+"%s\n","-----------------------------");
        System.out.printf(Blue+"%s\n","1. Register as Player");
        System.out.printf(Blue+"%s\n","2. Player Login");
        System.out.printf(Blue+"%s\n","3. Modify Player Information");
        System.out.printf(Blue+"%s\n","4. Delete Player Information");
        System.out.printf(Blue+"%s\n","5. Exit");
        System.out.printf(Blue+"%s\n","-----------------------------");

    }
    
public static void playerRegister(){
     String aString; 
        Scanner scanner = new Scanner(System.in);
        
        System.out.printf("\n\n%s\n","               [Player Registration]");
        System.out.printf("%s\n",">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        
        System.out.print("Enter Player Username: ");
        aString = scanner.nextLine();
        
        System.out.print("Enter Player Password: ");
        String bString = scanner.nextLine();
        if(playerList.valPassword(bString)==false){
            System.out.println("\nInvalid player passowrd format!!! Please try again!!!");
            System.out.println("The password must contains at least one digit, lowercase and uppercase characters, special symbol[@#$%] and [6-20] words.");
            System.out.println("Example: AbC@12");
            playerRegister();
        }
        else{
            System.out.print("Enter Player Email: ");
            String cString = scanner.nextLine();
            if(playerList.valEmail(cString)==false){
                System.out.println("Invalid player email format!!! Please try again!!!");
                playerRegister();
            }
            else{

                System.out.println( regUsername.username(aString));
                System.out.println(regPassword.password(bString));
                System.out.println(regEmail.email(cString));

                System.out.println("Player register successfully.");
                System.out.println("Please go to log in and play the game");
           
                
            }
        }
    }
    
public static void login(){
        Scanner scanner = new Scanner(System.in);
        String initialUsername = "Ali Abu";
        String initialPassword= "AbC@12";
        
        System.out.printf("\n\n%s\n","            [Player Login]");
        System.out.printf("%s\n","^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
        
        System.out.print("Enter Player Username: ");
        String aString = scanner.nextLine();
        
        System.out.print("Enter Player Password: ");
        String bString = scanner.nextLine();
        if(playerList.valPassword(bString)==false){
            System.out.println("Invalid player passowrd format!!! Please try again!!!");
            System.out.println("The password must contains at least one digit, lowercase and uppercase characters, special symbol[@#$%] and [6-20] words.");
            System.out.println("Example: AbC@12");
            invalidLogin();
        }
        else{
            if(aString.equals(reg_username) || aString.equals(initialUsername)){
                
                if(bString.equals(reg_password) || bString.equals(initialPassword)){
                    System.out.println("\nPlayer login successfully.\n\n");
                    reg_username=aString;
                    Game();
                    //>>>>>>>>>>>>>>>>>>connect to game module<<<<<<<<<<<<<<<<
                }
                else {
                    System.out.println("\nInvalid player password, please make sure you had done register");
                    invalidLogin();
                }
            } 
            else {
                System.out.println("\nInvalid player password, please make sure you had done register");
                invalidLogin();
            }
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
                if(playerList.valPassword(bString)==false || playerList.valPassword(tempString)==false){
                    System.out.println("Invalid player passowrd format!!! Please try again!!!");
                    System.out.println("The password must contains at least one digit, lowercase and uppercase characters, special symbol[@#$%] and [6-20] words.");
                    System.out.println("Example: AbC@12");
                    invalidLogin();
                }
                else{
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
                }
                break;
            case 3:
                System.out.print("Enter The Old Player Email: ");
                tempString = scanner.nextLine();
                System.out.print("Enter The New Player Email: ");
                cString = scanner.nextLine();
                if(playerList.valEmail(cString)==false || playerList.valEmail(tempString)==false){
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
                System.out.println("Invalid number!!! Please re-enter number[1-4]!!!");
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
 
//Lee Yong Ranking 
    public static void Ranking()
    {
          // Variable Declaration
        int menuChoice, addScore, updateScore;
        String addName, deleteScore, searchScore, updateName;
        // Validation Variable Declaration
        boolean valid;
        
        // Object Declaration
       // Scanner scanner = new Scanner(System.in);
      //  Ranking ranking = new Ranking(0, null);
       // SortedArrayList<Ranking> scoreList = new SortedArrayList<Ranking>();
        

        do{
            System.out.println(Blue+"---------------------------------------------");
            System.out.println(Blue+"Ranking");
            System.out.println(Blue+"---------------------------------------------");
            System.out.println(Blue+"1. Add Ranking");
            System.out.println(Blue+"2. Delete Ranking");
            System.out.println(Blue+"3. Update Ranking");
            System.out.println(Blue+"4. Search Player Ranking");
            System.out.println(Blue+"5. Show Ranking List");
            System.out.println(Blue+"6. Exit Program");
            System.out.println(Blue+"---------------------------------------------");
            System.out.print("Please select the function by entering the index: ");
            menuChoice = getInput(6);

            switch(menuChoice){
                // Add
                case 1:{
                    System.out.println("1. Add Ranking");
                    System.out.print("Please enter user name you want to add: ");
                    addName =scanner.nextLine();
                    System.out.print("Enter the score of user: ");
                    addScore = getInput(10000);  
                    valid = scoreList.add(new Ranking(ranking.setScore(addScore), ranking.setName(addName)));
                    if(valid == true)
                        System.out.println("Add complete!\n");
                    else{
                        
                        System.out.print("Sorry the user already exist\n");
                        System.out.print("Please proceed to Update Function,");
                        System.out.print("If there is an score need to be update. \n\n");
                    }
                }
                    break;
                    
                // Delete
                case 2:{
                    System.out.println("2. Delete Ranking");
                    System.out.println("\nScore List: \n" + scoreList);
                    System.out.print("Please enter user name you want to delete: ");
                    deleteScore = scanner.nextLine();
                    valid = scoreList.remove(new Ranking(deleteScore));
                    if(valid == true)
                        System.out.println("Delete Complete!\n");
                    else{
                        System.out.print("Unable to find user record,");
                        System.out.print("please enter existing user record.\n\n");
                    }
                }
                    break;
                    
                // Update
                case 3:{
                    System.out.println("3. Update Ranking");
                    System.out.print("Please enter user name you want to update: ");
                    updateName = scanner.nextLine();
                    System.out.print("Please enter user score you want to update: ");
                    updateScore = getInput(10000);
                    valid = scoreList.update(new Ranking(updateScore, updateName));
                    if(valid == true)
                        System.out.println("Score list updated!\n");
                    else{
                        System.out.print("Unable to find user record,");
                        System.out.print("please enter existing user record.\n\n");
                    }
                    
                }
                    break;
                    
                // Search
                case 4:{
                    System.out.println("4. Search Ranking");
                    System.out.print("Please enter user name you want to search: ");
                    searchScore = scanner.nextLine();
                    valid = scoreList.search(new Ranking(searchScore));
                    if(valid == true)
                        System.out.println("Search Complete!\n");
                    else{
                        System.out.print("Unable to find user record,");
                        System.out.print("please enter existing user record.\n\n");
                    }
                    
                }
                    break;
                    
                //List
                case 5:{
                    System.out.println("5. Show Ranking List");
                    System.out.println("\nScore List: \n" + scoreList);
                    System.out.println("This is the list of the score!\n");
                }
                    break;
                    
                case 6:{
                    break;
                }
                
                default:{
                    System.out.println("Only enter index shows above!");
                    System.out.println("Please re-enter!\n");
                }
            }
        }while(menuChoice != 6);
    }
    
    public static int Calculate()
    {
     easyScore = easyScore* easyScorecount; 
     //System.out.println(easyScore);
     mediumScore = mediumScore* mediumScorecount; 
     hardScore = hardScore* hardScorecount; 
     
     totalScore = easyScore+ mediumScore+ hardScore;
     
     return totalScore;
    }  
    
    public static void SetOriginalMark()
    {
       easyScorecount=0;
       mediumScorecount=0;
       hardScorecount=0;
       easyScore=2;
       mediumScore=5;
       hardScore=10;
       totalScore=0;
    }
    public static int getInput(int max) {
        Scanner scanner = new Scanner(System.in);
        boolean isvalid = true;
        int choice  = 0;
        
        do {
            
            try {            
                choice = scanner.nextInt();
                if(choice < 1 || choice > max) isvalid = false;
                else isvalid = true;                
            } catch (Exception e) {
                isvalid = false;
                scanner.nextLine();
            }
            
            if(!isvalid) System.out.print("Invalid command! please enter again : ");
            
        }while(!isvalid);
        return choice;
    }

    
 //  Khor Hui Shuang Question and Answer
 
    public static void Easy()
    {
        Scanner s = new Scanner(System.in);
        boolean invalid;
       int no=1;
        String ans = "";


            for(int i=1;i<=easy.length;i++)
            {   System.out.println("No"+no++);
                System.out.println("------------------------------------------------------------------------------------------");
                System.out.println("Question : "+easy.getEntryQuestion(i));
                System.out.println("Meaning  : "+easy.getEntryMeaning(i));
                System.out.println("------------------------------------------------------------------------------------------");
                do
                {
                    invalid = false;
                    try
                    {
                        System.out.print("Enter answer: ");
                        ans = s.nextLine();
                        ans = ans.toUpperCase();
                        if(!ans.matches("^[A-Za-z\\s]+$"))
                        {
                            invalid = true;
                            System.out.println("Invalid input! Please enter character only!\n");
                        }
                    }
                    catch(Exception e)
                    {
                        invalid = true;
                        System.out.println("Invalid input! Please enter character only!\n");
                    }
                }while(invalid);

                boolean valid = easy.contains(i, ans);
                if(valid == false)
                {
                    System.out.println("Incorrect");
                }
                else if(valid == true)
                {
                    System.out.println("Correct\n");
                    easyScorecount++;
                }
            }

        
    }
    
    public static void Medium()
    {
        Scanner s = new Scanner(System.in);
        boolean invalid;
        boolean cont;
        String ans = "";
        int no=1;

            for(int i=1;i<=medium.length;i++)
            {
                System.out.println("No"+no++);
                System.out.println("------------------------------------------------------------");
                System.out.println("Question : "+medium.getEntryQuestion(i));
                System.out.println("Meaning  : "+medium.getEntryMeaning(i));
                System.out.println("------------------------------------------------------------");
                do
                {
                    invalid = false;
                    try
                    {
                        System.out.print("Enter answer: ");
                        ans = s.nextLine();
                        ans = ans.toUpperCase();
                        if(!ans.matches("^[A-Za-z\\s]+$"))
                        {
                            invalid = true;
                            System.out.println("Invalid input! Please enter character only!\n");
                        }
                    }
                    catch(Exception e)
                    {
                        invalid = true;
                        System.out.println("Invalid input! Please enter character only!\n");
                    }
                }while(invalid);
                System.out.println(medium.contains(i,ans));
                boolean valid = medium.contains(i, ans);
                if(valid == false)
                {
                    System.out.println("Incorrect\n");
                }
                else if(valid == true)
                {
                    System.out.println("Correct\n");
                    mediumScorecount++;
                }
            }

    }
    
    public static void Hard()
    {
        Scanner s = new Scanner(System.in);
        boolean invalid;
        boolean cont;
        String ans = "";
        int no=1;
            for(int i=1;i<=hard.length;i++)
            {
                System.out.println("No"+no++);
                System.out.println("------------------------------------------------------------");
                System.out.println("Question : "+hard.getEntryQuestion(i));
                System.out.println("Meaning  : "+hard.getEntryMeaning(i));
               System.out.println("------------------------------------------------------------");
                do
                {
                    invalid = false;
                    try
                    {
                        System.out.print("Enter answer: ");
                        ans = s.nextLine();
                        ans = ans.toUpperCase();
                        if(!ans.matches("^[A-Za-z\\s]+$"))
                        {
                            invalid = true;
                            System.out.println("Invalid input! Please enter character only!\n");
                        }
                    }
                    catch(Exception e)
                    {
                        invalid = true;
                        System.out.println("Invalid input! Please enter character only!\n");
                    }
                }while(invalid);
                System.out.println(hard.contains(i,ans)); 
                boolean valid = hard.contains(i, ans);
                if(valid == false)
                {
                    System.out.println("Incorrect");
                }
                else if(valid == true)
                {
                    System.out.println("Correct\n");
                    hardScorecount++;
                }
            }

 
    }
    
public static void addQuestion()
    {
        Scanner s = new Scanner(System.in);
        boolean invalid;
        boolean cont;
        int level = 0;
        String question = "", meaning = "", answer = "";
   System.out.println("\n------------------"); 
   System.out.println("    Add Question");
   System.out.println("------------------");  
        do
        {

   System.out.println("1. Easy");
   System.out.println("2. Medium");
   System.out.println("3. Hard");
   System.out.println("Level [1-3]");
                do
            {
                invalid = false;
                try
                {
                    System.out.print("Choose the level(1-3): ");
                    level = s.nextInt();
                    if(level < 1 || level > 3)
                    {
                        invalid = true;
                        System.out.println("Invalid input!Please enter only number between 1 to 3!");
                    }
                }
                catch(Exception e)
                {
                    invalid = true;
                    System.out.println("Invalid input!Please enter only number between 1 to 3!");
                }
            }while(invalid);
            if(level == 1)
            {
                System.out.println("--------------------------------------------------------------------------------------------------");
                System.out.println(easy.toString());
                System.out.println("--------------------------------------------------------------------------------------------------");
                System.out.println("This is your current question");
                question = s.nextLine();
                do
                {
                    invalid = false;
                    try
                    {
                        System.out.print("Question that you want to add(DOG=D_G): ");
                        question = s.nextLine();
                       // question = s.nextLine();
                        if(!question.matches("^_?([^_]+)_?$"))
                        {
                            invalid = true;
                            System.out.println("Invalid input!");
                        }
                    }
                    catch(Exception e)
                    {
                        invalid = true;
                        System.out.println("Invalid input!");
                    }
                }while(invalid);
                do
                {
                    invalid = false;
                    try
                    {
                        System.out.print("Meaning that you want to add: ");
                        meaning = s.nextLine();
                        if(!meaning.matches("^[A-Za-z\\s]+$"))
                        {
                            invalid = true;
                            System.out.println("Invalid input!Please enter character only!");
                        }
                    }
                    catch(Exception e)
                    {
                        invalid = true;
                        System.out.println("Invalid input!Please enter character only!");
                    }
                }while(invalid);
                do
                {
                    invalid = false;
                    try
                    {
                        System.out.print("Answer that you want to add: ");
                        answer = s.nextLine();
                        if(!answer.matches("^[A-Za-z\\s]+$"))
                        {
                            invalid = true;
                            System.out.println("Invalid input!Please enter character only!");
                        }
                    }
                    catch(Exception e)
                    {
                        invalid = true;
                        System.out.println("Invalid input!Please enter character only!");
                    }
                }while(invalid);
                
                easy.add(new StoreQuestion(question, meaning, answer));
                System.out.println("New Question Added");
            }   
            else if(level == 2)
            {
                System.out.println("--------------------------------------------------------------------------------------------------");
                System.out.println(medium.toString());
                System.out.println("--------------------------------------------------------------------------------------------------");
                System.out.println("This is your current question");
                do
                {
                    invalid = false;
                    try
                    {
                        System.out.print("Question that you want to add(DOG=D_G): ");
                        question = s.nextLine();
                        if(!question.matches("^[A-Za-z\\s]+$"))
                        {
                            invalid = true;
                            System.out.println("Invalid input!Please enter character only!");
                        }
                    }
                    catch(Exception e)
                    {
                        invalid = true;
                        System.out.println("Invalid input!Please enter character only!");
                    }
                }while(invalid);
                do
                {
                    invalid = false;
                    try
                    {
                        System.out.print("Meaning that you want to add: ");
                        meaning = s.nextLine();
                        if(!meaning.matches("^[A-Za-z\\s]+$"))
                        {
                            invalid = true;
                            System.out.println("Invalid input!Please enter character only!");
                        }
                    }
                    catch(Exception e)
                    {
                        invalid = true;
                        System.out.println("Invalid input!Please enter character only!");
                    }
                }while(invalid);
                do
                {
                    invalid = false;
                    try
                    {
                        System.out.print("Answer that you want to add: ");
                        answer = s.nextLine();
                        if(!answer.matches("^[A-Za-z\\s]+$"))
                        {
                            invalid = true;
                            System.out.println("Invalid input!Please enter character only!");
                        }
                    }
                    catch(Exception e)
                    {
                        invalid = true;
                        System.out.println("Invalid input!Please enter character only!");
                    }
                }while(invalid);
                medium.add(new StoreQuestion(question, meaning, answer));
            }
            else if(level == 3)
            {   System.out.println("--------------------------------------------------------------------------------------------------");
                System.out.println(hard.toString());
                System.out.println("--------------------------------------------------------------------------------------------------");
                            System.out.println("This is your current question");
                do
                {
                    invalid = false;
                    try
                    {
                        System.out.print("Question that you want to add(DOG=D_G): ");
                        question = s.nextLine();
                        if(!question.matches("^[A-Za-z\\s]+$"))
                        {
                            invalid = true;
                            System.out.println("Invalid input!Please enter character only!");
                        }
                    }
                    catch(Exception e)
                    {
                        invalid = true;
                        System.out.println("Invalid input!Please enter character only!");
                    }
                }while(invalid);
                do
                {
                    invalid = false;
                    try
                    {
                        System.out.print("Meaning that you want to add: ");
                        meaning = s.nextLine();
                        if(!meaning.matches("^[A-Za-z\\s]+$"))
                        {
                            invalid = true;
                            System.out.println("Invalid input!Please enter character only!");
                        }
                    }
                    catch(Exception e)
                    {
                        invalid = true;
                        System.out.println("Invalid input!Please enter character only!");
                    }
                }while(invalid);
                do
                {
                    invalid = false;
                    try
                    {
                        System.out.print("Answer that you want to add: ");
                        answer = s.nextLine();
                        if(!answer.matches("^[A-Za-z\\s]+$"))
                        {
                            invalid = true;
                            System.out.println("Invalid input!Please enter character only!");
                        }
                    }
                    catch(Exception e)
                    {
                        invalid = true;
                        System.out.println("Invalid input!Please enter character only!");
                    }
                }while(invalid);
                hard.add(new StoreQuestion(question, meaning, answer));
            }
            cont = false;
            char contRemove = ' ';
            do
            {
                invalid = false;
                try
                {
                    System.out.print("Do you want to continue add(Y/N): ");
                    contRemove = s.next().charAt(0);
                    if(contRemove != 'Y' && contRemove != 'y' && contRemove != 'N' && contRemove != 'n')
                    {
                        invalid = true;
                        System.out.println("Invalid input!Please enter only 'Y' or 'N'!");
                    }
                }
                catch(Exception e)
                {
                    invalid = true;
                    System.out.println("Invalid input!Please enter only 'Y' or 'N'!");
                }
            }while(invalid);
            if(contRemove == 'Y' || contRemove == 'y')
            {
                cont = true;
            }
            else
            {
                cont = false;
                //back to add,modify,delete menu
            }
        }while(cont);
        
    }
    
public static void modifyQuestion()
    {
        Scanner s = new Scanner(System.in);
        boolean invalid;
        boolean cont;
        int level = 0;
        int detailsEasyModify = 0;
        int detailsMediumModify = 0;
        int detailsHardModify = 0;
        int modifyEasyQuestion = 0;
        int modifyMediumQuestion =0;
        int modifyHardQuestion =0;
   System.out.println("\n----------------------"); 
   System.out.println("    Modify Question");
   System.out.println("-----------------------");     
        do
        {

   System.out.println("1. Easy");
   System.out.println("2. Medium");
   System.out.println("3. Hard");
   System.out.println("Level [1-3]");   
                do
            {
                invalid = false;
                try
                {
                    System.out.print("Choose the level(1-3): ");
                    level = s.nextInt();
                    if(level < 1 || level > 3)
                    {
                        invalid = true;
                        System.out.println("Invalid input!Please enter only number between 1 to 3!");
                    }
                }
                catch(Exception e)
                {
                    invalid = true;
                    System.out.println("Invalid input!Please enter only number between 1 to 3!");
                }
            }while(invalid);
            if(level == 1)
            {   
                int no=1;
                System.out.println("--------------------------------------------------------------------------------------------------");                
                for(int i=1;i<=easy.length;i++)
                {    
                System.out.println("No"+no+++"\n"+easy.getEntry(i));
                }
                System.out.println("--------------------------------------------------------------------------------------------------");                
                do
                {
                    invalid = false;
                    try
                    {
                        System.out.print("Choose the question to modify: ");
                        modifyEasyQuestion = s.nextInt();
                        if(modifyEasyQuestion < 1||modifyEasyQuestion>easy.getLength())
                        {
                            invalid = true;
                            System.out.println("Invalid input!");
                        }
                    }
                    catch(Exception e)
                    {
                        invalid = true;
                        System.out.println("Invalid input!");
                    }
                }while(invalid);
                System.out.println("Details to modify: ");
                System.out.println("1. Meaning");
                System.out.println("2. Answer");
                do
                {
                    invalid = false;
                    try
                    {
                        System.out.print("Choose what to modify: ");
                        detailsEasyModify = s.nextInt();
                        if(detailsEasyModify != 1 && detailsEasyModify != 2)
                        {
                            invalid = true;
                            System.out.println("Invalid input!");
                        }
                    }
                    catch(Exception e)
                    {
                        invalid = true;
                        System.out.println("Invalid input!");
                    }
                }while(invalid);
                String mod = "";
                if(detailsEasyModify == 1)
                {
                    System.out.print("Modified Meaning: ");
                    mod = s.nextLine();
                    mod = s.nextLine();
                }
                else if(detailsEasyModify == 2)
                {
                    System.out.print("Modified Answer: ");
                    mod = s.nextLine();
                    mod = s.nextLine();
                }
                easy.replace(modifyEasyQuestion, mod, detailsEasyModify);
                System.out.println("Modify Successful");
            }
            else if(level == 2)
            {
                int no=1;
                System.out.println("--------------------------------------------------------------------------------------------------");           
                for(int i=1;i<=medium.length;i++)
                {    
                System.out.println("No"+no+++"\n"+medium.getEntry(i));
                }
                System.out.println("--------------------------------------------------------------------------------------------------");
                do
                {
                    invalid = false;
                    try
                    {
                        System.out.print("Choose the question to modify: ");
                        modifyMediumQuestion = s.nextInt();
                        if(modifyMediumQuestion < 1||modifyMediumQuestion>medium.getLength())
                        {
                            invalid = true;
                            System.out.println("Invalid input!Please enter the number bigger than 0!");
                        }
                    }
                    catch(Exception e)
                    {
                        invalid = true;
                        System.out.println("Invalid input!Please enter the number bigger than 0!");
                    }
                }while(invalid);
                System.out.println("Details to modify: ");
                System.out.println("1. Meaning");
                System.out.println("2. Answer");
                do
                {
                    invalid = false;
                    try
                    {
                        System.out.print("Choose what to modify: ");
                        detailsMediumModify = s.nextInt();
                        if(detailsMediumModify != 1 && detailsMediumModify != 2)
                        {
                            invalid = true;
                            System.out.println("Invalid input!Please enter the number only 1 and 2!");
                        }
                    }
                    catch(Exception e)
                    {
                        invalid = true;
                        System.out.println("Invalid input!Please enter the number only 1 and 2!");
                    }
                }while(invalid);
                String mod = "";
                if(detailsMediumModify == 1)
                {
                    System.out.print("Modified Meaning: ");
                    mod = s.nextLine();
                    mod = s.nextLine();
                }
                else if(detailsMediumModify == 2)
                {
                    System.out.print("Modified Answer: ");
                    mod = s.nextLine();
                    mod = s.nextLine();
                }
                medium.replace(modifyMediumQuestion, mod, detailsMediumModify);
            }
            else if(level == 3)
            {
                int no=1;
                System.out.println("--------------------------------------------------------------------------------------------------");
                for(int i=1;i<=hard.length;i++)
                {    
                System.out.println("No"+no+++"\n"+hard.getEntry(i));
                }
                System.out.println("--------------------------------------------------------------------------------------------------");
                do
                {
                    invalid = false;
                    try
                    {
                        System.out.print("Choose the question to modify: ");
                        modifyHardQuestion = s.nextInt();
                        if(modifyHardQuestion < 1||modifyHardQuestion > hard.getLength())
                        {
                            invalid = true;
                            System.out.println("Invalid input!Please enter the number bigger than 0!");
                        }
                    }
                    catch(Exception e)
                    {
                        invalid = true;
                        System.out.println("Invalid input!Please enter the number bigger than 0!");
                    }
                }while(invalid);
                System.out.println("Details to modify: ");
                System.out.println("1. Meaning");
                System.out.println("2. Answer");
                do
                {
                    invalid = false;
                    try
                    {
                        System.out.print("Choose what to modify: ");
                        detailsHardModify = s.nextInt();
                        if(detailsHardModify != 1 && detailsHardModify != 2)
                        {
                            invalid = true;
                            System.out.println("Invalid input!Please enter the number only 1 and 2!");
                        }
                    }
                    catch(Exception e)
                    {
                        invalid = true;
                        System.out.println("Invalid input!Please enter the number only 1 and 2!");
                    }
                }while(invalid);
                String mod = "";
                if(detailsHardModify == 1)
                {
                    System.out.print("Modified Meaning: ");
                    mod = s.nextLine();
                    mod = s.nextLine();
                }
                else if(detailsHardModify == 2)
                {
                    System.out.print("Modified Answer: ");
                    mod = s.nextLine();
                    mod = s.nextLine();
                }
                hard.replace(modifyHardQuestion, mod, detailsHardModify);
            }
            cont = false;
            char contRemove = ' ';
            do
            {
                invalid = false;
                try
                {
                    System.out.print("Do you want to continue modify(Y/N): ");
                    contRemove = s.next().charAt(0);
                    if(contRemove != 'Y' && contRemove != 'y' && contRemove != 'N' && contRemove != 'n')
                    {
                        invalid = true;
                        System.out.println("Invalid input!Please enter only 'Y' or 'N'!");
                    }
                }
                catch(Exception e)
                {
                    invalid = true;
                    System.out.println("Invalid input!Please enter only 'Y' or 'N'!");
                }
            }while(invalid);
            if(contRemove == 'Y' || contRemove == 'y')
            {
                cont = true;
            }
            else
            {
                cont = false;
                //back to add,modify,delete menu
            }
        }while(cont);
        
        
    }
    
public static void deleteQuestion()
    {
        Scanner s = new Scanner(System.in);
        boolean invalid;
        boolean cont;
        int level = 0;
        int choice = 0;
   System.out.println("\n----------------------"); 
   System.out.println("    Delete Question");
   System.out.println("----------------------");      
        do
        {

   System.out.println("1. Easy");
   System.out.println("2. Medium");
   System.out.println("3. Hard");
   System.out.println("Level [1-3]: ");             
            do
            {
                invalid = false;
                try
                {
                    System.out.print("Choose the level(1-3): ");
                    level = s.nextInt();
                    if(level < 1 || level > 3)
                    {
                        invalid = true;
                        System.out.println("Invalid input!Please enter only number between 1 to 3!");
                    }
                }
                catch(Exception e)
                {
                    invalid = true;
                    System.out.println("Invalid input!Please enter only number between 1 to 3!");
                }
            }while(invalid);
            if(level == 1)
            {
                int no=1;
                System.out.println("Easy Level");
                System.out.println("--------------------------------------------------------------------------------------------------");
                for(int i=1;i<=easy.length;i++)
                {    
                System.out.println("No"+no+++"\n"+easy.getEntry(i));
                }
                System.out.println("--------------------------------------------------------------------------------------------------");
                do
                {
                    invalid = false;
                    try
                    {
                        System.out.print("Enter the question you want to remove: ");
                        choice = s.nextInt();
                        if(choice < 1||choice>easy.getLength())
                        {
                            invalid = true;
                            System.out.println("Invalid input!Please enter the number larger than 0!");
                        }
                    }
                    catch(Exception e)
                    {
                        invalid = true;
                        System.out.println("Invalid input!Please enter the number larger than 0!");
                    }
                }while(invalid);
                easy.remove(choice);
                
                StoreQuestion.index = 1;
                System.out.println("After removed: \n");
                System.out.println("Easy Level");
                 System.out.println("==================================================================================================");
                System.out.println(easy.toString());
                 System.out.println("==================================================================================================");              
            }
            else if(level == 2)
            {
                int no=1;
                System.out.println("Medium Level");
                System.out.println("--------------------------------------------------------------------------------------------------");
                for(int i=1;i<=medium.length;i++)
                {    
                System.out.println("No"+no+++"\n"+medium.getEntry(i));
                }
                System.out.println("--------------------------------------------------------------------------------------------------");
                do
                {
                    invalid = false;
                    try
                    {
                        System.out.print("Enter the question you want to remove: ");
                        choice = s.nextInt();
                        if(choice < 1||choice>medium.getLength())
                        {
                            invalid = true;
                            System.out.println("Invalid input!Please enter the number larger than 0!");
                        }
                    }
                    catch(Exception e)
                    {
                        invalid = true;
                        System.out.println("Invalid input!Please enter the number larger than 0!");
                    }
                }while(invalid);
                medium.remove(choice);
                StoreQuestion.index = 1;
                System.out.println("After removed: \n");
                System.out.println("Medium Level");
                System.out.println("==================================================================================================");   
                System.out.println(medium.toString());
                System.out.println("==================================================================================================");   
            }
            else if(level == 3)
            {
                int no=1;
                System.out.println("Hard Level");
                System.out.println("--------------------------------------------------------------------------------------------------");                
                for(int i=1;i<=hard.length;i++)
                {    
                System.out.println("No"+no+++"\n"+hard.getEntry(i));
                }
                System.out.println("--------------------------------------------------------------------------------------------------");                
                do
                {
                    invalid = false;
                    try
                    {
                        System.out.print("Enter the question you want to remove: ");
                        choice = s.nextInt();
                        if(choice < 1||choice>hard.getLength())
                        {
                            invalid = true;
                            System.out.println("Invalid input!Please enter the number larger than 0!");
                        }
                    }
                    catch(Exception e)
                    {
                        invalid = true;
                        System.out.println("Invalid input!Please enter the number larger than 0!");
                    }
                }while(invalid);
                hard.remove(choice);
                StoreQuestion.index = 1;
                System.out.println("After removed: \n");
                System.out.println("Hard Level");
                System.out.println("==================================================================================================");   
                System.out.println(hard.toString());
                System.out.println("==================================================================================================");   
            }
            cont = false;
            char contRemove = ' ';
            do
            {
                invalid = false;
                try
                {
                    System.out.print("Do you want to continue remove(Y/N): ");
                    contRemove = s.next().charAt(0);
                    if(contRemove != 'Y' && contRemove != 'y' && contRemove != 'N' && contRemove != 'n')
                    {
                        invalid = true;
                        System.out.println("Invalid input!Please enter only 'Y' or 'N'!");
                    }
                }
                catch(Exception e)
                {
                    invalid = true;
                    System.out.println("Invalid input!Please enter only 'Y' or 'N'!");
                }
            }while(invalid);
            if(contRemove == 'Y' || contRemove == 'y')
            {
                cont = true;
            }
            else
            {
                cont = false;
                //back to add,modify,delete menu
            }
        }while(cont);      
    }




//Keng Choon Peng Game() and Admin
public static void Game()
    {
     boolean valid=false;   
    int levelChoice = 0; 
    while(levelChoice!=4)  
    {
    
    System.out.println(Blue+"Let Start the Game!!!!");
    System.out.println(Blue+"Please select the game level");
    System.out.println(Blue+"1. Easy");
    System.out.println(Blue+"2. Medium");
    System.out.println(Blue+"3. Hard");
    System.out.println(Blue+"4. Quit");
    Scanner s = new Scanner(System.in);
     
        System.out.print("Choose the level(1-3): ");
        levelChoice = s.nextInt();

        
        if(levelChoice == 1)
        {
            Easy();
        }
        else if(levelChoice == 2)
        {
            Medium();
        }
        else if(levelChoice == 3)
        {
            Hard();
        }
        else if(levelChoice==4)
        {
        
        }    
        else
            System.out.println("Invalid input");
        }
    
       // System.out.println(Calculate());
        int score = Calculate();
        valid = scoreList.add(new Ranking(score, ranking.setName(regUsername.username(reg_username))));
        
        //System.out.println(easyScore);
        if(valid==false)
         scoreList.update(new Ranking(score,regUsername.username(reg_username)));   
        
        System.out.println("\nScore List: \n" + scoreList);
        SetOriginalMark();
      
    }     
public static void Admin()
{
    int count=1;

 
   boolean valid;
   int choice=0;
   valid=AdminLogin();

   if(valid==true||correctpassword==true)
   {   
   while(choice!=8&&valid==true)
   {
    if(removeSuccessful==true)
    {   
     valid=AdminLogin();   
    }
    
   if(valid==true||correctpassword==true)
   {

  // System.out.println(llist.getEntry(index));
  if(count==1)
  {
   System.out.println("\n");
   System.out.println(Blue+"------------------"); 
   System.out.println(Blue+"   ADMIN SYSTEM");
   System.out.println(Blue+"------------------");
 
   System.out.println(Blue+"1. ADD NEW ADMIN");
   System.out.println(Blue+"2. MODIFY ADMIN");
   System.out.println(Blue+"3. SEARCH ADMINS");
   System.out.println(Blue+"4. TERMINATE ADMIN ACCOUNT");
   System.out.println(Blue+"5. DELETE PLAYER");
   System.out.println(Blue+"6. ACCESS QUESTION SYSTEM");
   System.out.println(Blue+"7. ACCESS RANKING SYSTEM");
   System.out.println(Blue+"8. QUIT ADMIN SYSTEM\n");
   System.out.println(Blue+"Welcome "+llist.getEntryName(index));
  }
   System.out.print(Blue+"Function[1-7]: ");
   Scanner scanner = new Scanner(System.in);
   choice = scanner.nextInt();
   
   switch(choice)
   {
       case 1:
           addAdmin();
           count=1;
           break;
       case 2:
           modifyAdminInfo();
           count=1;
           break;
       case 3:
           searchAdmin();
           count=1;
           break;
       case 4:
           removeAdmin();
           count=1;
           break;
       case 5:
           deletePlayer();
           count=1;
           break;
       case 6:
           QuestionMenu();
           count=1;
           break; 
       case 7:
           Ranking();
           count=1;
           break;
       default:
           count=-1;
               break;
           
   }

   }
   }
   }
   else
       //System.out.println("------------------------------");
       System.out.println(Red+"Not allow access Admin system");
      // System.out.println("-------------------------------");
        
  

  }

public static void addAdmin()      
{
 char ans;
 boolean valid;
 String name;
 String phone,email ;
 String newpassword;
Scanner scanner = new Scanner(System.in); 
 
   System.out.println("\n----------------"); 
   System.out.println("     REGISTER");
   System.out.println("----------------"); 
do{
 
 do{
     System.out.print("Name\t: ");
 
 name = scanner.nextLine();
 if(adminInfo.validateName(name)==false)
 {
 System.out.println("-----------------------------------------------");    
 System.out.println("Must more than 2 character, not  ontain integer");
  System.out.println("-----------------------------------------------");  
 }
 if(llist.contains(name)==true)
 {
 System.out.println("-------------");      
 System.out.println("Existing name");
 System.out.println("-------------");    
 }
 }while(adminInfo.validateName(name)!=true||llist.contains(name)==true);
 
 do{
 System.out.print("Password: ");
 newpassword = scanner.nextLine();
  if(llist.contains(newpassword)==true)
 {
 System.out.println("-----------------");        
 System.out.println("Existing password");
 System.out.println("-----------------");   
 }
 if(adminInfo.isValidPassword(newpassword)==false)
 {
 System.out.println("------------------------------------------------------------------------");      
 System.out.println("Fomat:[at least 5 character] & [a Uppercase] & [a Lowercase] & [a Digit]");
 System.out.println("------------------------------------------------------------------------");    
 }
  }while(adminInfo.isValidPassword(newpassword)!=true||llist.contains(newpassword)==true);
 
 do{
 System.out.print("Phone\t: ");    
 phone = scanner.nextLine();

 if(adminInfo.validatePhone(phone)==false)
 {
  System.out.println("--------------------------------------------");      
 System.out.println("Phone Number must be in the form 01X-XXX-XXXX");
   System.out.println("--------------------------------------------");   
 }
 if(llist.contains(phone)==true)
 {
 System.out.println("--------------");       
 System.out.println("Existing phone");
 System.out.println("--------------");      
 }
 }while(adminInfo.validatePhone(phone)!=true||llist.contains(phone)==true);

do{ 
 System.out.print("Email\t: ");
 email=scanner.nextLine();
 if(adminInfo.isValidEmail(email)==false)
 {
  System.out.println("----------------------------------------");   
  System.out.println("Email must be in the form XXXXX@mail.com");
  System.out.println("----------------------------------------");   
 }
 if(llist.contains(email)==true)
 {
 System.out.println("--------------");         
 System.out.println("Existing email");
 System.out.println("--------------");     
 }
}while(adminInfo.isValidEmail(email)!=true||llist.contains(email)==true);

 llist.add(new Admin(adminInfo.AdminID++,name,newpassword,phone,email));
 System.out.println("\nAdd new Admin Successfully");
 System.out.println("-----------------------------");
 System.out.println("Want Add Again");
 System.out.print("Yes[y] No[other]: ");
 ans = scanner.next().charAt(0);
  System.out.println("-----------------------------");
name = scanner.nextLine();
 }while(ans=='y');
  }

public static void modifyAdminInfo()
  {
    Scanner scanner = new Scanner(System.in);
    char cont;
    String ans="";
    int choice;
    do{

   System.out.println("\n------------"); 
   System.out.println("   MODIFY");
   System.out.println("------------"); 
   System.out.println("\n1.Name\n2.Password\n3.Phone\n4.Email");
    do{
    System.out.print("Option[1-4]: ");
    
    choice = scanner.nextInt();
    scanner.nextLine();
    }while(choice<1||choice>=5);
    if(choice==1)
    {
    do{
     System.out.print("\nName\t: ");
 
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
      if(llist.contains(ans)==true)
        {
            System.out.println("Existing password");
        }
        if(adminInfo.isValidPassword(ans)==false)
        {
            System.out.println("Fomat:[at least 5 character] & [a Uppercase] & [a Lowercase] & [a Digit]");
        }
     }while(adminInfo.isValidPassword(ans)!=true||llist.contains(ans)==true);
    }
    
    else if(choice ==3)
    {
  do{
     System.out.print("Phone\t: ");    
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
     System.out.print("Email\t: ");    
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
    System.out.println("Modify Succesful");
    System.out.println("------------------");
    System.out.print("Continue? [Yes:y|No:other]: ");
    cont=scanner.next().charAt(0);
    }while(cont=='y');
  }
  
public static boolean AdminLogin()
{
  int count=2;
  char ans=' ';
  String name;
  System.out.println("\n");
   System.out.println(Blue+"------------"); 
   System.out.println(Blue+"   LOG IN");
   System.out.println(Blue+"------------"); 
   do{ 
   System.out.print("Username: ");
   Scanner scanner = new Scanner(System.in);
  
    name = scanner.nextLine();
   index = llist.indexOf(name);

   if(index==-1)
   {
       System.out.println("-------------------------------");
       System.out.println("Invalid Username");
       System.out.print("Reenter?[Y=Yes] [Other=No]: ");
        ans=scanner.next().charAt(0);
       System.out.println("-------------------------------");
      

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
      System.out.println("\nWrong password\nYou still have [" + count+ "] chance");
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
   System.out.println("\n------------"); 
   System.out.println("   REMOVE");
   System.out.println("------------"); 
System.out.println("You want to quit your job? " +llist.getEntryName(index) );
System.out.print("Yes[Y] No[Other] :");
ans = scanner.next().charAt(0);
if(ans=='Y'||ans=='y')
{
System.out.println("Goodbye "+llist.getEntryName(index)+" Your account had been remove successful");    
llist.remove(index);
//System.out.println(index);
removeSuccessful=true;
index=0;
}
else
removeSuccessful=false;
}

public static boolean AdminForgotPassword()
 {
   System.out.println(Blue+"\n--------------------"); 
   System.out.println(Blue+"   FORGOT PASSWORD");
   System.out.println(Blue+"--------------------");    
  String phone,name,password,email="";
  boolean valid;
  Scanner scanner= new Scanner(System.in);
  System.out.print("Name?\t:");
  name = scanner.nextLine();
  System.out.print("Phone number?\t:");
  do{
  phone = scanner.nextLine();
  valid=adminInfo.validatePhone(phone);
  if(valid==false)
  {
    System.out.println("Phone Number must be in the form 01X-XXX-XXXX");
    System.out.print("Please reenter:\n");
  }
  }while(adminInfo.validatePhone(phone)==false);
  System.out.print("Email\t:");
  do{
  email = scanner.nextLine();
  valid=adminInfo.isValidEmail(email);
  if(valid==false)
  {
    System.out.println("Email must be in the form XXX@mail.com");
    System.out.print("Please reenter:\n");
  }
  }while(adminInfo.isValidEmail(email)==false);
  
  int indexphone = llist.indexOf(phone);
  int indexname =llist.indexOf(name);
  int indexemail = llist.indexOf(email);
  if(indexname!=index||indexphone!=index||indexemail!=index)
  {
      if(indexname!=index)
      System.out.print("Wrong Username!!!!   "); 
      if(indexphone!=index)
      System.out.print("Wrong Phone number!!!!   "); 
      if(indexemail!=index)
      System.out.println("Wrong Email!!!");
     
    //System.out.println("You are not allowed to access Admin System");
      return correctpassword;
  }

  if(indexname==index&&indexphone==index&&indexemail==index)
  {
   correctpassword=true;   
   System.out.println("Your account is indenticate\n");   
 do{
 System.out.print("New Password: ");
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

public static void QuestionMenu()
{
     int choice=0;
     int count=1;
    Scanner scanner = new Scanner(System.in);
   while(choice!=4)
   {
     if(count==1)
     {      
   System.out.println("\n"); 
   System.out.println(Blue+"----------------------"); 
   System.out.println(Blue+"   Question SYSTEM");
   System.out.println(Blue+"----------------------");
   System.out.println(Blue+"1. ADD NEW QUESTION");
   System.out.println(Blue+"2. MODIFY QUESTION");
   System.out.println(Blue+"3. DELETE QUESTION");
   System.out.println(Blue+"4. QUIT QUESTION SYSTEM");
     }
   System.out.print("Function[1-4] :");
  choice = scanner.nextInt();
   
   switch(choice)
   {
   case 1:
   addQuestion();
   count=1;
   break;
           
       case 2:
   modifyQuestion();
   count=1;
        break;

       case 3:
   deleteQuestion();
   count=1;
        break;        
        
       case 4:
           break;
       default:
           System.out.println("Invalid input");
           count=-1;
           break;
   }
   }
}

public static void main(String[] args) {
   llist = new LinkedList<>();
   adminInfo = new Admin();
   
        easy.add(new StoreQuestion("AMO_NT","add up in number or quantity","U"));
        easy.add(new StoreQuestion("FI_TION","a literary work based on the imagination and not necessarily on fact","C"));
        easy.add(new StoreQuestion("HAPP_","enjoying or showing or marked by joy or pleasure","Y"));
        
        medium.add(new StoreQuestion("IN_LUENCE","a power to affect people or events","F"));
        medium.add(new StoreQuestion("DEACO_","a cleric ranking just below a priest in Christian churches","N"));
        medium.add(new StoreQuestion("_USCIOUS","extremely pleasing to the sense of taste","L"));
        
        hard.add(new StoreQuestion("JU_ILATE","to express great joy","B"));
        hard.add(new StoreQuestion("_UBBUB","loud confused noise from many sources","H"));
        hard.add(new StoreQuestion("A_ARDEE","a grant made by a law court","W"));
        
        scoreList.add(new Ranking(10, "Leon"));
        scoreList.add(new Ranking(30, "Peng"));
        scoreList.add(new Ranking(20, "Shuang"));
        scoreList.add(new Ranking(100, "Han"));
        
         llist.add(new Admin(1000,"Ali","Abc111!","012-212-1111","keng@gmail.com"));
         llist.add(new Admin(1001,"Baba","Abc111!","012-222-1212","choon@hotmail.com"));
         llist.add(new Admin(1002,"Chon","Abc333!","012-321-1213","kkk@hotmail.com"));
         llist.add(new Admin(1003,"Dake","Abc123!","017-323-1111","kheng@gmail.com"));
         
         //scoreList.update(new Ranking(5,"Leon"));   
        
        //System.out.println("\nScore List: \n" + scoreList);    
         //Ranking();
   int choice =0;
   // deleteQuestion();

    System.out.println(Blue +"==================");
    System.out.println(Blue+"Fill In The Blank");
    System.out.println(Blue+"==================");
    while(choice!= 3)
    {    
    System.out.println(Blue+"1. Player");
    System.out.println(Blue+"2. Admin");
    System.out.println(Blue+"3. Quit");
    System.out.print(Blue+"Are you a? [1-3] :");
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
