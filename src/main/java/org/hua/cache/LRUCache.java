
package org.hua.cache;

/**
 *
 * @author panos
 * @param <K>
 * @param <>V
 */
public class LRUCache<K,V> implements Cache<K,V>{
    
    private static final int TOTAL_AVAILABLE_SIZE = 60;
    
    public LRUCache (){
        
    }
    

    @Override
    public V get(K key) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public V put(K key, V value) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
