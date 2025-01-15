
package org.hua.cache;

import java.util.Iterator;

/**
 * This is an interface with the most common methods a doubly linked list must have 
 * @author panos
 * @param <K>
 * @param <V>
 */
public interface ListInterface<K,V> extends Iterable<Node<K,V>>{
  
    /**
     * Adds a node and it's payload in the start of the list
     * We assume that the start of the list is where the header variable points to
     * The node is created inside the method according to the key and value that we provide
     * @param key
     * @param value
     */
    void addFirst(K key, V value);
    
    /**
     * Adds a node and it's payload in the end of the list
     * We assume that the end of the list is where the tail variable points to
     * The node is created inside the method according to the key and the value that we provide
     * @param key
     * @param value
     */
    void addLast (K key, V value);
    
    /**
     * Removes the last node of the list (from the tail), and return's it to the user 
     * 
     * @return Node<K,V>
     */
    Node<K,V> removeLast();
    
    /**
     * Removes the first node from the list (from the head). and return's it to the user
     * @return Node<K,V> 
     */
    Node<K,V> removeFirst();
    
    /**
     * Checks if the list is empty (Compares the size with zero)
     * @return true if the list is empty, false otherwise
     */
    boolean isEmpty();
    
    /**
     * This method when called will empty the list by dropping all the nodes 
     */
    void clear();
    
    /**
     * When called it returns the first node of the list (The reference of the node)
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
     * When this method is called is provided with a node reference in order to place it 
     * in the end of the list (where the tail points at)
     * @param node
     */
    void moveToTop(Node<K,V> node);

    /**
     * This is an iterator for the list
     * @return Iterator<Node<K,V>>
     */
    Iterator<Node<K,V>> iterator();

    /** 
     * Additional method. Takes as parameter a node reference, and removes it from the list in O(1) complexity
     * Specifically added in order to support the LFU method.
     * @param node 
     */
    void removeNode(Node<K,V> node);
    
}
