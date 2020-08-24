/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 *
 * @author User
 */
public class StoreQuestion {
    
    public String question;
    public String meaning;
    public String answer;
    public static int index = 1;
    
    public StoreQuestion(String question, String meaning, String answer)
    {
        this.question = question;
        this.meaning = meaning;
        this.answer = answer;
    }

    
    public String getQuestion()
    {
        return question;
    }
    
    public String getMeaning()
    {
        return meaning;
    }
    
    public String getAnswer()
    {
        return answer;
    }
    
    public int getIndex()
    {
        return index;
    }
    
    public void setIndex(int index)
    {
        this.index = index;
    }
    
    public void setQuestion(String question)
    {
        this.question = question;
    }
    
    public void setMeaning(String meaning)
    {
        this.meaning = meaning;
    }
    
    public void setAnswer(String answer)
    {
        this.answer = answer;
    }
    
    public String toString()
    {
        return String.format("Question: %s\n" +
                "Meaning : %s\n" + 
                "Answer  : %s",question, meaning, answer);
    }
    
    public String toString2()
    { 
        return String.format("%s\n" + "%s\n", question, meaning);
    }
}
