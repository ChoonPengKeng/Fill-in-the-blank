/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adt;

import java.util.Iterator;

/**
 *
 * @author User
 */
public interface SortedArrayListInterface<T extends Comparable<T>>{
    
    public boolean add(T newEntry);
    
    public boolean remove(T newEntry);
    public boolean checkDuplicate(T newEntry);
    public boolean search(T newEntry);
    public boolean checkExist(T newEntry);
    public boolean update(T newEntry);
    
    public int getLength();
    
    public Iterator<T> getIterator();
}
