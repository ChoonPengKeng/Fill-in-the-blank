/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adt;

import Entity.Admin;



public class LinkedList<T> implements LinkedListInterface<T> {

  private Node firstNode; // reference to first node
  private int length;  	// number of entries in list



  public boolean add(T newEntry) {
    Node newNode = new Node(newEntry);	// create the new node
    
    if (isEmpty()) {
      firstNode = newNode;
    } else {                        // add to end of nonempty list
      Node currentNode = firstNode;	// traverse linked list with p pointing to the current node
      while (currentNode.next != null) { // while have not reached the last node
        currentNode = currentNode.next;
      }
      currentNode.next = newNode; // make last node reference new node
    }

    length++;
 
    return true;
  }
  
  


  @Override
  public T remove(int givenPosition) {
    T result = null;                 // return value

    if ((givenPosition >= 1) && (givenPosition <= length)) {
      if (givenPosition == 1) {      // case 1: remove first entry
        result = (T) firstNode.people;     // save entry to be removed
        firstNode = firstNode.next;
      } else {                         // case 2: givenPosition > 1
        Node nodeBefore = firstNode;
        for (int i = 1; i < givenPosition-1 ; i++) {
          nodeBefore = nodeBefore.next;		// advance nodeBefore to its next node
        }
        result = (T) nodeBefore.next.people;  // save entry to be removed
        nodeBefore.next = nodeBefore.next.next;	// make node before point to node after the
      } 																// one to be deleted (to disconnect node from chain)

      length--;
    }

    return result; // return removed entry, or null if operation fails
  }



  public boolean replace(int givenPosition,int choice, String newEntry) {
    boolean isSuccessful = true;

    if ((givenPosition >= 1) && (givenPosition <= length)) {
      Node currentNode = firstNode;
      for (int i = 0; i < givenPosition-1 ; ++i) {
        currentNode = currentNode.next;		// advance currentNode to next node
      }
      if(choice==1)
      currentNode.people.username = newEntry;// currentNode is pointing to the node at givenPosition
      else if(choice==2)
          currentNode.people.password=newEntry;
      else if(choice==3)
          currentNode.people.phone=newEntry;
      else if(choice==4)
          currentNode.people.email=newEntry;
    } else {
      isSuccessful = false;
    }

    return isSuccessful;
  }
  
  

  @Override
  public T getEntry(int givenPosition) {
    T result = null;

    if ((givenPosition >= 1) && (givenPosition <= length)) {
      Node currentNode = firstNode;
      for (int i = 0; i < givenPosition-1 ; ++i) {
        currentNode = currentNode.next;		// advance currentNode to next node
      }
      result = (T) currentNode.people;	// currentNode is pointing to the node at givenPosition
    }

    return result;
  }

  @Override
  public boolean contains(String anEntry) {
    boolean found = false;
    Node currentNode = firstNode;

    while (!found && (currentNode != null)) {
      if (anEntry.toUpperCase().equals(currentNode.people.username.toUpperCase())) {
        found = true;
      } 
      else if(anEntry.equals(currentNode.people.password))
          found = true;
      else if(anEntry.equals(currentNode.people.phone))
              found = true;
      else if(anEntry.equals(currentNode.people.email))
              found = true; 
      else {
        currentNode=currentNode.next;
      }
    
}
    return found;
  }
  

  
  @Override
  public int getLength() {
    return length;
  }

  @Override
  public boolean isEmpty() {
    boolean result;

    result = length == 0;

    return result;
  }

  @Override
  public boolean isFull() {
    return false;
  }

  @Override
  public String toString() {
    String outputStr = "";
    Node currentNode = firstNode;
    while (currentNode != null) {
      outputStr += currentNode.people + "\n";
      currentNode = currentNode.next;
    }
    return outputStr;
  }


 
  public int indexOf(String name) {
    int index =1;
    Node<T> trav = firstNode;

    // Support searching for null
    if (name == null) {
        
      for (; trav != null; trav = trav.next, index++) {
        if (trav.people == null) {
           
          return index;
          
        }
      }
      // Search for non null object
    }else
      for (; trav != null; trav = trav.next, index++) {
        if (name.toUpperCase().equals(trav.people.username.toUpperCase())) {
          return index;
        }
        else if(name.equals(trav.people.password))
          return index;
        else if(name.equals(trav.people.phone))
          return index;
        else if(name.equals(trav.people.email))
          return index;        
      }

    return -1;
  }
  
  

  private class Node<T> {

    private Admin people;
    private Node next;


    private Node() {

      this.people=people;
      this.next = null;
      
    }

    private Node(Node next) {

      this.next = next;
    }

    private Node(T data) {
     this.people=(Admin) data;
    }
    

  }


}