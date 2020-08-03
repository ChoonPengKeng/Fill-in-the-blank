/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LList;
import java.util.Iterator;
import java.util.NoSuchElementException;


public class LList<T> implements ListInterface<T> {

  private Node firstNode; // reference to first node
  private int length;  	// number of entries in list

  public LList() {
    clear();
  }


  @Override
  public final void clear() {
    firstNode = null;
    length = 0;
  }

  @Override
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
  public boolean add(int newPosition, T newEntry) { // OutOfMemoryError possible
    boolean isSuccessful = true;

    if ((newPosition >= 1) && (newPosition <= length + 1)) {
      Node newNode = new Node(newEntry);

      if (isEmpty() || (newPosition == 1)) { // case 1: add to beginning of list
        newNode.next = firstNode;
        firstNode = newNode;
      } else {								// case 2: list is not empty and newPosition > 1
        Node nodeBefore = firstNode;
        for (int i = 1; i < newPosition - 1; ++i) {
          nodeBefore = nodeBefore.next;		// advance nodeBefore to its next node
        }

        newNode.next = nodeBefore.next;	// make new node point to current node at newPosition
        nodeBefore.next = newNode;		// make the node before point to the new node
      }

      length++;
    } else {
      isSuccessful = false;
    }

    return isSuccessful;
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

  @Override
  public boolean replace(int givenPosition,int choice, String newEntry) {
    boolean isSuccessful = true;

    if ((givenPosition >= 1) && (givenPosition <= length)) {
      Node currentNode = firstNode;
      for (int i = 0; i < givenPosition-1 ; ++i) {
        currentNode = currentNode.next;		// advance currentNode to next node
      }
      if(choice==1)
      currentNode.people.username = newEntry;// currentNode is pointing to the node at givenPosition
      else
          currentNode.people.password=newEntry;
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
      if (anEntry.equals(currentNode.people.username)) {
        found = true;
      } 
      else if(anEntry.equals(currentNode.people.password))
          found = true;
      else {
        currentNode = currentNode.next;
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

    @Override

  
    
 public boolean equals(Object o)
    {
        if(this == o)
            return true;
        if(o ==null)
            return false;
     if (o instanceof LList)
     {
     LList otherLString = (LList)o;
     int n = length;
     if(n == otherLString.length)
     {
     Node n1 = firstNode; 
     Node n2 = otherLString.firstNode;
     while(n1 != null)
     {
         if(n1.people.username!=n2.people.username){
             return false;
     }
    }
     n1=n1.next;
     n2=n2.next;
     }
     return true;
     }
    return false;
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
        if (name.equals(trav.people.username)) {
          return index;
        }
        else if(name.equals(trav.people.password))
                return index;
      }

    return -1;
  } 
 

 /* public int indexOf(Object obj) {
    int index =0;
    Node<T> trav = firstNode;

    // Support searching for null
    if (obj == null) {
      for (; trav != null; trav = trav.next, index++) {
        if (trav.data == null) {
           
          return index;
          
        }
      }
      // Search for non null object
    } else
      for (; trav != null; trav = trav.next, index++) {
        if (obj.equals(trav.data)) {
            
          return index;
        }
      }

    return -1;
  } */
  
  public int indexOf(People obj)
      {
          int index =1;
    Node<T> trav = firstNode;

    // Support searching for null
    if (obj == null) {
      for (; trav != null; trav = trav.next, index++) {
        if (trav.people == null) {
           
          return index;
          
        }
      }
      // Search for non null object
    } else
      for (; trav != null; trav = trav.next, index++) {
        if (obj.equals(trav.people)) {
            
          return index;
        }
      }

    return -1;
      }   



  
  
  private class Node<T> {

    private People people;
    private String name;
    private String password;
    private Node next;

    private Node() {
      this.password=password;
      this.people=people;
      this.name=(String) name;
      this.password=password;
      this.next = null;
      
    }

    private Node(String name,String password, Node next) {
      this.name = name;
      this.password=password;
      this.next = next;
    }

        private Node(T data) {
           this.people=(People) data;
        }
  }

   /*   private class Node {

        private T data;
        private Node next;

        private Node(T data) {
            this.data = data;
            next = null;
        }

        private Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }
        
 
    }*/
}