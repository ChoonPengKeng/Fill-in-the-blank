package adt;

import java.util.Iterator;
import Entity.Ranking;

public class SortedArrayList<T extends Comparable<T>> implements SortedArrayListInterface<T>{
    private T[] list;
    private int length;
    private final static int DEFAULY_CAPACITY= 4;
  
    public SortedArrayList() {
        this(DEFAULY_CAPACITY);
    }

    public SortedArrayList(int initialCapacity) {
        length = 0;
        list = (T[]) new Comparable[initialCapacity];
    }

    public boolean add(T newEntry){
        boolean valid = true;
        
        if(newEntry instanceof Ranking){
            valid = checkDuplicate(newEntry);

            if(valid == true){
                int i = 0;
                
                if(arrayFull()){
                    doubleArray();
                }

                while(i < length && newEntry.compareTo(list[i]) < 0){
                    i++;
                }
                makeRoom(i + 1);
                list[i] = newEntry;
                length++;
                return true;

            }
            else
                return false;
            }
        else 
            return false;
    }
    
    public boolean remove(T newEntry){
        int i = 0;
        if (newEntry instanceof Ranking){
            Ranking Ranking = (Ranking)newEntry;
            if(checkExist(newEntry) == true){
                while(i < length && Ranking.getName().compareTo(((Ranking)list[i]).getName()) != 0){
                    i ++;
                }
                removeGap(i);
                length--;
                return true;
            }
            else
                return false;
        }
        else
            return false;
    }
    
    public boolean search(T newEntry){
        int i = 0;
        Ranking Ranking = (Ranking)newEntry;
        while(i < length && Ranking.getName().compareTo(((Ranking)list[i]).getName()) != 0){
            i ++;
        }
        System.out.println("\n\tSearch Ranking");
        System.out.println("\t-------------");
        System.out.println("\tPlayer name : " + (((Ranking)list[i]).getName()));
        System.out.println("\tPlayer score: " + (((Ranking)list[i]).getScore()));
        System.out.println("\tPlayer rank : #" + (i+1));
        return true;
    }
    
    public boolean update(T newEntry){
        if (newEntry instanceof Ranking){
            int i = 0;
            Ranking Ranking = (Ranking)newEntry;
            
            if(checkExist(newEntry) == true){
                while(i < length && Ranking.getName().compareTo(((Ranking)list[i]).getName()) != 0){
                    i++;
                }
                list[i] = newEntry;
                swapping(Ranking.getScore(), i);
                return true;
            }
            else 
                return false;
        }
        else 
            return false;
    }
    
    public int getLength(){
        return length;
    }
    
    public boolean arrayFull(){
        return list.length == length;
    }
    
    public boolean checkDuplicate(T newEntry){
        int indexValid = 0;
        boolean valid = true;
        Ranking Ranking = (Ranking)newEntry;
        while(indexValid + 1 <= length && list != null){
            if(Ranking.getName().compareTo(((Ranking)list[indexValid]).getName()) != 0){
                valid = true;
            }
            else{
                valid = false;
                break;
            }
            
            indexValid++;
        }
        
        return valid;
    }
    
    public boolean checkExist(T newEntry){
        int indexValid = 0;
        boolean valid = true;
        Ranking Ranking = (Ranking)newEntry;
        while(indexValid + 1 <= length && list != null){
            if(Ranking.getName().compareTo(((Ranking)list[indexValid]).getName()) != 0){
                valid = false;
            }
            else{
                valid = true;
                break;
            }
            
            indexValid++;
        }
        
        return valid;
    }
    
    // ----
    
    public String toString(){
        
        String outputStr = "\tRank\tPlayer Name\tScore\n";
        for(int index = 0; index < length; index++){
            outputStr += "\t#" + (index+1) + "\t" + list[index] + "\n";
        }
        outputStr += "Total player: " + length + "\n";
        return outputStr;
    }
      
    public void doubleArray(){
        T[] oldList = list;
        int oldSize = oldList.length;

        list = (T[]) new Comparable[2 * oldSize];

        for (int index = 0; index < oldSize; index++) {
            list[index] = oldList[index];
        }
    }
    
    
    private void makeRoom(int newPosition) {
        int newIndex = newPosition - 1;
        int lastIndex = length - 1;

        for (int index = lastIndex; index >= newIndex; index--) {
            list[index + 1] = list[index];
        }
    }
    
    private void removeGap(int givenPosition){
        int currentIndex = givenPosition + 1;
        int nextIndex = currentIndex + 1;
        for(int index = currentIndex; index < length; index++){
            list[index - 1] = list[nextIndex - 1];
            nextIndex ++;
        }
    }

    private boolean swapping(int score, int passIndex){
        int i = 0, index = passIndex;
        
        // case 1
        if(index == 0){
            int currentIndex = index;
            int nextIndex = index + 1;
            T[] temporarily;
            temporarily = (T[]) new Comparable[1];
            while(currentIndex + 1 < length &&  score <= (((Ranking)list[nextIndex]).getScore())){
                temporarily[0] = list[currentIndex];
                list[currentIndex] = list[nextIndex];
                list[nextIndex] = temporarily[0];
                currentIndex++;
                nextIndex++;
            }
            list[currentIndex] = list[nextIndex - 1];
        } // end of case 1
        
        // case 2
        else if( index + 1 == length){ // (length = 5) == (index+1 = 0-4 + 1) = 5 
            int currentIndex = index;
            int nextIndex = index - 1;
            T[] temporarily;
            temporarily = (T[]) new Comparable[1];
            while(currentIndex > 0 && (((Ranking)list[nextIndex]).getScore()) < score){
                temporarily[0] = list[currentIndex];
                list[currentIndex] = list[nextIndex];
                list[nextIndex] = temporarily[0];
                currentIndex--;
                nextIndex--;
            }
            list[currentIndex] = list[nextIndex + 1]; 
        } // end of case 2
        
        // case 3
        else{
            int currentIndex = index;
            int leftScore = (((Ranking)list[currentIndex - 1]).getScore());
            int rightScore = (((Ranking)list[currentIndex + 1]).getScore());
            
            if(leftScore < score){ // 50 < 70(input)
                int nextIndex = index - 1;
                T[] temporarily;
                temporarily = (T[]) new Comparable[1]; 
                
                while(nextIndex >= 0 && (((Ranking)list[nextIndex]).getScore()) < score){            
                    temporarily[0] = list[currentIndex];
                    list[currentIndex] = list[nextIndex];
                    list[nextIndex] = temporarily[0];
                    currentIndex--;
                    nextIndex--;
                }
                list[currentIndex] = list[nextIndex + 1]; 
            }
            
            else if(leftScore >= score && rightScore < score){ // 50 >= 40(input) > 10 || 50 >= 50(input) > 10
                int nextIndex = index - 1;
                list[currentIndex] = list[nextIndex +1];
            }

            else if(rightScore >= score){ // 10(input) >= 10 || 5(input) > 10
                int nextIndex = index + 1;
                T[] temporarily;
                temporarily = (T[]) new Comparable[1];
                
                while(currentIndex + 1 < length && (((Ranking)list[nextIndex]).getScore()) >= score){
                    temporarily[0] = list[currentIndex];
                    list[currentIndex] = list[nextIndex];
                    list[nextIndex] = temporarily[0];
                    currentIndex++;
                    nextIndex++;
                }
                list[currentIndex] = list[nextIndex - 1]; 
            }
            else{
                System.out.println("Here is an error\n");
                return false;
            }
        } // end of case 3

        return true;
    }
    
    // Iterator
    @Override
    public Iterator<T> getIterator() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private class HateIterator implements Iterator<T>{
        int currentIndex = 0;
        
        @Override
        public boolean hasNext() {
            return currentIndex < length;
        }
        
        @Override
        public T next() {
            T currentElement = null;
            if(hasNext()){
                currentElement = list[currentIndex];
                currentIndex++;
            }
            return currentElement;
        }  
    }
    
}
