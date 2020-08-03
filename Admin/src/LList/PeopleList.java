/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LList;


import java.util.Scanner;

/**
 *
 * @author ACER
 */
public class PeopleList {

private ListInterface<People> llist;
private People peopleinfo;
static int index=-1;
//private static People<ListInterface> peopleInfo = new People<ListInterface>();
    public PeopleList() {
        
   llist = new LList<>();
   peopleinfo = new People();
       info();
   
    //login();
    System.out.println(llist.indexOf("Dake"));
    llist.replace(3,1,"PPPP");
    llist.remove(5);
    System.out.println(llist.toString());
    // modify();
     // search();
 
    }

public void info()
{


 llist.add(new People("Ali","abc111"));
 llist.add(new People("Baba","abc222"));
 llist.add(new People("Chon","abc333"));
 llist.add(new People("Dake","abc123"));

 

 String name="Dake";
 index = llist.indexOf("Ali");

}
  public static void main(String[] args) {
    new PeopleList();
    
  }
  
  public void add()      
  {
 char ans;
 
   do{
 System.out.println("Add");
 System.out.println("Name");
 Scanner scanner = new Scanner(System.in);
 String name = scanner.nextLine();
 System.out.println("Password");
 String newnum = scanner.nextLine();
 llist.add(new People(name,newnum));
 System.out.println("Yes?");
 ans = scanner.next().charAt(0);
 }while(ans=='y');
  }
  public void modify()
  {
    login();
    char cont;
    do{
    String ans ;
    System.out.println(llist.getEntry(index));
    System.out.println(index);
    System.out.println("Modify\n 1.Name\n2.Password");
    Scanner scanner = new Scanner(System.in);
    int choice = scanner.nextInt();
    scanner.nextLine();
    if(choice==1)
    {
    System.out.println("Name");
    ans = scanner.nextLine();
    }
    else
    {
    System.out.println("Password");
    ans = scanner.nextLine();
    }
    llist.replace(index,choice,ans);
    System.out.println(llist.toString());
    System.out.println("Want to continue");
    cont=scanner.next().charAt(0);
    }while(cont=='y');
  }
  
  public void login()
  {
  int count=0;
      
  System.out.println("Password");
  Scanner scanner = new Scanner(System.in);
  String password = scanner.nextLine();
  index=llist.indexOf(password);
  if(index!=-1)
      System.out.println(llist.getEntry(index));
  else
  {
    do{  count++;
      System.out.println("Wrong password Please reenter");
       password = scanner.nextLine();
      if(count==2)
          forgotpassword();
    }while(count!=2);
  }

  }
  
  public void forgotpassword()
  {
  System.out.println("Forgot Password?");
  System.out.println("What is your name?");
  Scanner scanner = new Scanner(System.in);
  String name = scanner.nextLine();
  int index =llist.indexOf(name);
  System.out.println(index);
  System.out.println(llist.getEntry(index));
  boolean exist = llist.contains(name);
  if(exist ==true)
  {
   System.out.println("Your had indenticate");   
   System.out.println("Please enter your new password");
   String password = scanner.nextLine();
   System.out.println(llist.replace(index, 2, password));
   
  }
  
  else
  {
   System.out.println("You are nor allow to access this Admin system");
   
  }
  
  }       
  public void search()
  {
  
  System.out.println("Search");
  Scanner scanner = new Scanner(System.in);
  String name = scanner.nextLine();
  int index=llist.indexOf(name);
  System.out.println(llist.getEntry(index));
  //int index=llist. 
 // System.out.println(peopleinfo.getEntry(1));
  }

  

}
