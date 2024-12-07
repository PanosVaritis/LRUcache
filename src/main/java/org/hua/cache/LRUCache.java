
package org.hua.cache;

import java.util.HashMap;


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

    private ListInterface<K,V> list;
    
    private HashMap<K,Node<K,V>> map;
     
    private int actualSize;
    
    private int totalSize;
    
    public LRUCache (int totalSize){
        
        if (totalSize <= 0)
            throw new IllegalArgumentException ("The size of the cache cannot be negative!!!");
    
        this.totalSize = totalSize;
        
        this.actualSize = 0;
        
        this.list = new DoublyList<>();
        
        this.map = new HashMap();
    }
    

    @Override
    public V get(K key) {
        
        if (!map.containsKey(key))
            return null;
        
        Node<K,V> node = map.get(key);
        
        list.moveToTop(node);
        
        return node.getNewEntry().getValue();
    }

    
    
    @Override
    public void put(K key, V value) {
        
        if (map.containsKey(key)){
            
            Node<K,V> node = map.get(key);
            
            node.getNewEntry().setValue(value);
            
            list.moveToTop(node);
            
            return;
        }
        
        if (actualSize >= totalSize){
            
            Node<K,V> node = list.removeLast();
            map.remove(node.getNewEntry().getKey());
            actualSize--;
        }
        
        
        list.addFirst(key, value);
        Node<K,V> newNode = list.getFirst();
        map.put(key, newNode);
        actualSize++;
    }
    
}
