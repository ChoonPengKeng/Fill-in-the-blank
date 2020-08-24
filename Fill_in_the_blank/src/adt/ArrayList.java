/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adt;

import Entity.StoreQuestion;

/**
 *
 * @author User
 */
public class ArrayList <T> implements ArrayListInterface<T> {

  private StoreQuestion[] array;
  public int length;
  private static final int DEFAULT_CAPACITY = 50;
  

  public ArrayList() {
    this(DEFAULT_CAPACITY);
  }

  public ArrayList(int initialCapacity) {
    length = 0;
    array =  new StoreQuestion[initialCapacity];
  }

  public boolean add(StoreQuestion newEntry) {
    array[length] = newEntry;
    length++;
    return true;
  }

  public boolean add(int newPosition, StoreQuestion newEntry) {
    boolean isSuccessful = true;

    if ((newPosition >= 1) && (newPosition <= length + 1)) {
      if (!isArrayFull()) {
        makeRoom(newPosition);
        array[newPosition - 1] = newEntry;
        length++;
      }
    } else {
      isSuccessful = false;
    }

    return isSuccessful;
  }

  public T remove(int givenPosition) {
    T Ranking = null;

    if ((givenPosition >= 1) && (givenPosition <= length)) {
      Ranking = (T)array[givenPosition - 1];

      if (givenPosition < length) {
        removeGap(givenPosition);
      }

      length--;
    }

    return Ranking;
  }

  public void clear() {
    length = 0;
  }

  public boolean replace(int givenPosition, String newEntry, int choice) {
    boolean isSuccessful = true;

    if ((givenPosition >= 1) && (givenPosition <= length)) {
      
      if(choice == 1)
        {
            array[givenPosition - 1].meaning = newEntry;
        }
      else if(choice == 2)
      {
          array[givenPosition - 1].answer = newEntry;
      }
    } else {
      isSuccessful = false;
    }
    
    
    return isSuccessful;
  }

  public T getEntry(int givenPosition) {
    T Ranking = null;

    if ((givenPosition >= 1) && (givenPosition <= length)) {
      Ranking = (T)array[givenPosition - 1];
    }
    
    return Ranking;
  }
  
  public T getEntryQuestion(int givenPosition) {
    T Ranking = null;

    if ((givenPosition >= 1) && (givenPosition <= length)) {
      Ranking = (T)array[givenPosition - 1].question;
    }

    return Ranking;
  }
  
  public T getEntryMeaning(int givenPosition) {
    T Ranking = null;

    if ((givenPosition >= 1) && (givenPosition <= length)) {
      Ranking = (T)array[givenPosition - 1].meaning;
    }

    return Ranking;
  }
  
    
  
  public boolean contains(int givenPosition, String anEntry) {
    boolean found = false;
    if ((givenPosition >= 1) && (givenPosition <= length)) {
      if (anEntry.equals(array[givenPosition-1].answer)) {
        found = true;
        
      }
    }

    return found;
  }

  public int getLength() {
    return length;
  }

  public boolean isEmpty() {
    return length == 0;
  }

  public boolean isFull() {
    return false;
  }

  public String toString() {
    String outputStr = "";
    for (int index = 0; index < length; ++index) {
      outputStr += array[index] + "\n\n";
    }

    return outputStr;
  }

  private boolean isArrayFull() {
    return length == array.length;
  }

  /**
   * Task: Makes room for a new entry at newPosition. Precondition: 1 <=
   * newPosition <= length + 1; length is array's
 length before addition.
   */
  private void makeRoom(int newPosition) {
    int newIndex = newPosition - 1;
    int lastIndex = length - 1;

    // move each entry to next higher index, starting at end of
    // array and continuing until the entry at newIndex is moved
    for (int index = lastIndex; index >= newIndex; index--) {
      array[index + 1] = array[index];
    }
  }

  /**
   * Task: Shifts entries that are beyond the entry to be removed to the next
   * lower position. Precondition: array is not empty; 1 <= givenPosition <
 length; length is array's length before removal.
   */
  private void removeGap(int givenPosition) {
    // move each entry to next lower position starting at entry after the
    // one removed and continuing until end of array
    int removedIndex = givenPosition - 1;
    int lastIndex = length - 1;

    for (int index = removedIndex; index < lastIndex; index++) {
      array[index] = array[index + 1];
    }
  }
}
