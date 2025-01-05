package org.hua.cache;

/**
 * @author panos
 * This an interface with basic methods for a simple connected list
 * @param <V>
 */

public interface SingleInter <V> {
    
    //Add a new node in the start of the list
    void add(V payload);
    
    
    //Remove the first node of the list
    void remove();
    
    //Returns the size of the list
    int size();
    
    //Returns true if the list is empty, otherwise false
    boolean isEmpty();
    
    
}
