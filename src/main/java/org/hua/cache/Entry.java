
package org.hua.cache;

/**
 * This class is used to represent a key value pair
 * @author panos
 */
public class Entry <K,V>{

    private final K key;
    
    private V value;
    
    public Entry (K key, V value){
        this.key = key;
        this.value = value;
    }
    
    public K getKey (){
        return key;
    }
    
    public V getValue (){
        return value;
    }
    
}
