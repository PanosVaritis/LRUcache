
package org.hua.cache;

/**
 * This is an interface with all the methods that a 
 * doubly linked list must have
 * @author panos
 * @param <K>
 * @param <V>
 */
public interface ListInterface<K,V> {
  
    /**
     * Adds a node and it's payload in the start of the list
     * @param key
     * @param value
     */
    void addFirst(K key, V value);
    
    /**
     * Adds a node and it's payload in the end of the list
     * @param key
     * @param value
     */
    void addLast (K key, V value);
    
    /**
     * Removes the last node of the list, 
     * and connects with the rest
     */
    Node<K,V> removeLast();
    
    /**
     * Not necessary for the app we make
     * It removes the first node of the list, and connects with the rest
     */
    Node<K,V> removeFirst();
    
    /**
     * 
     * @return true if the list is empty
     * false otherwise
     */
    boolean isEmpty();
    
    /**
     * It drops all the nodes of the list
     */
    void clear();
    
    /**
     * When called it return the first node of the list (The reference of the node)
     * @return Entry<K,V>
     */
    Node<K,V> getFirst();
    
    /**
     * When called it returns the the last node of the list (The reference of the node)
     * @return Entry<K,V>
     */
    Node<K,V> getLast();
    
    
    /** 
     * When called returns an integer number which represents the current size of the list
     * @return 
     */
    int size();
    
    /**
     * Used for debugging purposes. It print's the list forward
     */
    void displayForward();
    
    
    /**
     * 
     */
    void moveToTop(Node<K,V> node);
}
