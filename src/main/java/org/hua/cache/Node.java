
package org.hua.cache;

/**
 *
 * @author panos
 * @param <K>
 * @param <V>
 */
public class Node <K,V>{
    
    private Entry<K,V> newEntry;
        
    private Node<K,V> next;
        
    private Node<K,V> prev;

    public Node (K key, V value){
            
        newEntry = new Entry<>(key, value);
        this.next = null;
        this.prev = null;
          
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
    
    
    
    
}
