
package org.hua.cache;

/**
 * Simple class for a node. Each node besides it's references to other nodes, it contains an Entry
 * @author panos
 * @param <K>
 * @param <V>
 */
public class Node <K,V>{
    
    private Entry<K,V> newEntry;
        
    private Node<K,V> next;
        
    private Node<K,V> prev;

    private Node<K,V> dummyNext;
    
    private Node<K,V> dummyPrev;
    
    public Node (K key, V value){
            
        newEntry = new Entry<>(key, value);
        this.next = null;
        this.prev = null;
        this.dummyNext = null;
        this.dummyPrev = null;
          
    }

    public Entry<K, V> getNewEntry() {
        return newEntry;
    }

    public Node<K, V> getNext() {
        return next;
    }

    public Node<K, V> getPrev() {
        return prev;
    }

    public void setNewEntry(Entry<K, V> newEntry) {
        this.newEntry = newEntry;
    }

    public void setNext(Node<K, V> next) {
        this.next = next;
    }

    public void setPrev(Node<K, V> prev) {
        this.prev = prev;
    }

    public Node<K, V> getDummyNext() {
        return dummyNext;
    }

    public void setDummyNext(Node<K, V> dummyNext) {
        this.dummyNext = dummyNext;
    }

    public Node<K, V> getDummyPrev() {
        return dummyPrev;
    }

    public void setDummyPrev(Node<K, V> dummyPrev) {
        this.dummyPrev = dummyPrev;
    }
    
    
    
    
    
    
}
