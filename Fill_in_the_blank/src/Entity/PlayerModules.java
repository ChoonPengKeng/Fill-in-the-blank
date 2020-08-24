package playermodules;

import java.util.*;

public class PlayerModules{

    private static Player playerList;
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
    
    public static void main(String[] args) {
        playerMenu();
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
        PlayerModules regUsername = new PlayerModules();        
        PlayerModules regPassword = new PlayerModules();
        PlayerModules regEmail = new PlayerModules(); 
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.printf("\n\n%s\n","               [Player Registration]");
        System.out.printf("%s\n",">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        
        System.out.print("Enter Player Username: ");
        String aString = scanner.nextLine();
        
        System.out.print("Enter Player Password: ");
        String bString = scanner.nextLine();
        if(playerList.valPassword(bString)==false){
            System.out.println("\nInvalid player passowrd format!!! Please try again!!!");
            System.out.println("The password must contains at least one digit, lowercase "
                    + "and uppercase characters, special symbol[@#$%] and [6-20] words.");
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
        if(playerList.valPassword(bString)==false){
            System.out.println("Invalid player passowrd format!!! Please try again!!!");
            System.out.println("The password must contains at least one digit, lowercase "
                    + "and uppercase characters, special symbol[@#$%] and [6-20] words.");
            System.out.println("Example: AbC@12");
            invalidLogin();
        }
        else{
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
        PlayerModules modUsername = new PlayerModules();        
        PlayerModules modPassword = new PlayerModules();
        PlayerModules modEmail = new PlayerModules(); 
        
        Scanner scanner = new Scanner(System.in);
        int selection;
        String aString;
        String bString;
        String cString;
        String tempString;
        String initialUsername = "Ali Abu";
        String initialPassword= "AbC@12";
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
                    System.out.println("The password must contains at least one digit, lowercase "
                            + "and uppercase characters, special symbol[@#$%] and [6-20] words.");
                    System.out.println("Example: AbC@12");
                    modifyPlayer();
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
}
