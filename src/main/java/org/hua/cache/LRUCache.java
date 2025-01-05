
package org.hua.cache;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

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
    
    private TreeMap<Integer, List<Node<K,V>>> treeMap;
    
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
        
        if (this.strategy == CacheReplacementPolicy.LFU)
            treeMap = new TreeMap<>();
        
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
            
            if (this.strategy == CacheReplacementPolicy.LFU){
                
                duplicateWithLFU(key, value);
                return ;
                
            }else {
                
                duplicateWithOthers(key, value);
                return ;
                
            }
        }
        
        if (actualSize >= totalSize){
            
            if(this.strategy == CacheReplacementPolicy.LRU){
                removeBasedOnLru();
            }else if (this.strategy == CacheReplacementPolicy.MRU){
                removeBasedOnMru();
            }else if (this.strategy == CacheReplacementPolicy.LFU){
                removeBasedOnLfu();
            }
        }
        
        
        if (this.strategy == CacheReplacementPolicy.LFU){
            addBasedOnLFU(key, value);
        }else {
            addBasedOnTheOtherStrategies(key, value);
        }
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
    
    
    private void removeBasedOnLfu(){
        
        //We use the first entry method, that return the first enrty of the the map. The entry is the key and the value
        Map.Entry<Integer ,List<Node<K,V>>> entry = treeMap.firstEntry();
        
        //After we get the entry we take the value of the entry whick is the node list
        List<Node<K,V>> nodeList = entry.getValue();
        
        //Using the methods that the list provides we can remove the first node in O(1) complexity
        nodeList.removeFirst();
        
        //We decrease the size of the cache
        this.actualSize--;
    }
    
    
    private void updateFrequency (Node<K,V> node){
        
        //We have the old frequency stored locally in case we need it
        Integer oldFrequency = node.getNewEntry().getCounter();
        
        //We use the method and we increase the frequency of the node
        node.getNewEntry().increaseCounter();
        
        //We have the new frequency stored locally in case we need it
        Integer newFrequency = node.getNewEntry().getCounter();
        
        removeFromTreeLinkedList(node);
        
        addToTreeLinkedList(node);

    }
    
    
    
    private void addBasedOnLFU(K key, V value){
        
        list.addLast(key, value);
        Node<K,V> node = list.getLast();
        map.put(key, node);
        
        if (!(treeMap.containsKey(1))){
            
            treeMap.put(1, new LinkedList<>());
            
        }
        
        treeMap.get(1).add(node);
        this.actualSize++;
    }
    
    
    private void addBasedOnTheOtherStrategies(K key, V value){
        
            list.addLast(key, value);
            Node<K,V> newNode = list.getLast();
            map.put(key, newNode);
            this.actualSize++;
        
    }
    
    
    private void duplicateWithLFU(K key, V value){
        
        Node<K,V> node = map.get(key);
        node.getNewEntry().setValue(value);
        list.moveToTop(node);
        updateFrequency(node);
        
        
        
    }
    
    private void duplicateWithOthers (K key, V value){
                    
            Node<K,V> node = map.get(key);
            node.getNewEntry().setValue(value);
            list.moveToTop(node);
            
    }
    
    
    private void removeFromTreeLinkedList(Node<K,V> node){
        
        Integer freq = node.getNewEntry().getCounter();
        freq--;
        
        List<Node<K,V>> myList = treeMap.get(freq);
        
        //The list only has one node
        if (myList.size() == 1){
            return ;
        }
        
        //This is the last node of the list
        if (node.getNext() == null){
            return ;
        }
        
        //This is the first node of the list
        if (node.getPrev() == null){
            return ;
        }

        
        //The node might be anywhere on the list
        node.getNext();


        
        
        
    }
    
    
    private void addToTreeLinkedList (Node<K,V> node){
        
        
        if (!(treeMap.containsKey(node.getNewEntry().getCounter()))){
            
            treeMap.put(node.getNewEntry().getCounter(), new LinkedList<>());
            
        }
        
        treeMap.get(node.getNewEntry().getCounter()).add(node);
        
    }
    
    
    
       
}
