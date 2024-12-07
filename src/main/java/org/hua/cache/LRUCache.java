
package org.hua.cache;


/**
 * This is the cache implementation
 * @author panos
 * @param <K>
 * @param <V>
 */
public class LRUCache<K,V> implements Cache<K,V>{
    
    /**
     * We will be talking with the interfaces and not the interface implementations
     * Specifically we will have a Hash Interface variable and a List interface variable that will be initialized from their constructors
     * @param totalSize 
     */
    
    private int size;
    
    public LRUCache (int size){
        if (size <= 0)
            throw new IllegalArgumentException ("The size of the cache cannot be negative!!!");
    
        this.size = size;
    
        /**
         * Creation of the doubly list and of the hash map with their constructors
         */
    
    }
    

    @Override
    public V get(K key) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void put(K key, V value) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
