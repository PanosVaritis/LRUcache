
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
    
    private CacheReplacementPolicy strategy;
    
    //Variable used to count the hits. Initialized each time to zero
    private int hits;
    
    //Variable used to count the misses. Initialized each time to zero
    private int misses;
    
    
    public LRUCache (int totalSize, CacheReplacementPolicy strategy){
        
        if (totalSize <= 0)
            throw new IllegalArgumentException ("The size of the cache cannot be negative!!!");
    
        this.totalSize = totalSize;
        
        this.actualSize = 0;
        
        this.list = new DoublyList<>();
        
        this.map = new HashMap();
    
        this.strategy = strategy;
    
        this.hits = 0;
        
        this.misses = 0;
        
    }
    

    @Override
    public V get(K key) {
        
        if (!map.containsKey(key)){
            this.misses++;
            return null;
        }
        
        Node<K,V> node = map.get(key);
        
        list.moveToTop(node);
        
        this.hits++;
        
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
            
            if(this.strategy == CacheReplacementPolicy.LRU){
                removeBasedOnLru();
            }else if (this.strategy == CacheReplacementPolicy.MRU){
                removeBasedOnMru();
            }
        }
        
        
        list.addLast(key, value);
        Node<K,V> newNode = list.getLast();
        map.put(key, newNode);
        this.actualSize++;
    }
    
    
    @Override 
    public int getHitCount (){
       return this.hits;
    }
    
    
    @Override 
    public int getMissCount(){
        return this.misses;
    }
    
    
    private void removeBasedOnLru(){
        
        //We remove the first node of the list. Lest recent used item from the cache
        Node<K,V> node = list.removeFirst();
        map.remove(node.getNewEntry().getKey());
        this.actualSize--;
    }
    
    private void removeBasedOnMru(){
        
        //We remove the last node of the list. Most recent used item from the cache
        Node<K,V> node = list.removeLast();
        map.remove(node.getNewEntry().getKey());
        this.actualSize--;
    }
    
}
