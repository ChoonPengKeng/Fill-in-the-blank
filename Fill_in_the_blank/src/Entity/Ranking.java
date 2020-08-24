/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import adt.SortedArrayList;

/**
 *
 * @author User
 */
public class Ranking implements Comparable<Ranking> {

    private String name;
    private int score;
    
    SortedArrayList<Ranking> scoreList = new SortedArrayList<Ranking>();
    
    // Constructors
    public Ranking(int score, String name) {
        this.name = name;
        this.score = score;
    }
    
    public Ranking(int score) {
        this.score = score;
    }
        
    public Ranking(String name) {
        this.name = name;
    }
    
    // Getters
    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    // Setters
    public String setName(String name) {
        this.name = name;
        return name;
    }

    public int setScore(int score) {
        this.score = score;
        return score;
    }

    // To String
    @Override
    public String toString() {
        return name + "\t\t" + score;
    }

    // Downcast
    @Override
    public int compareTo(Ranking o) {
        if(o instanceof Ranking ){ //score / this.compareTo(o)
           if (score >= ((Ranking) o).getScore()){
               return 0;
           }
           else
               return -1;
       }
       else 
           return -1; 
    }
}