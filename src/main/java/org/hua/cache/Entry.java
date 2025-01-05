
package org.hua.cache;

/**
 * This class is used to represent a key value pair
 * @author panos
 * @param <K>
 * @param <V>
 */
public class Entry <K,V>{

    private final K key;
    
    private V value;
    
    private Integer counter;
    
    public Entry (K key, V value){
        this.key = key;
        this.value = value;
        this.counter = 1;
    }
    
    public K getKey (){
        return key;
    }
    
    public V getValue (){
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }
    
    public Integer getCounter(){
        return counter;
    }
    
//    public void setCounter(Integer counter){
//        this.counter = counter;
//    }
    
    public void increaseCounter(){
        this.counter++;
    }
    
}
