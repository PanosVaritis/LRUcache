package org.hua.cache;

/**
 *  This is an interface for the hash table. It contains all the appropriate methods that a hash table requires
 * @author panos
 * @param <K>
 * @param <V>
 * 
 */
public interface HashInterface <K,V>{
   
    void put (K key, V value);
    
    V get (K key);
    
    V remove (K key);
    
    boolean contains (K key);
    
    int size();
    
    boolean isEmpty();
    
    void clear();
}
