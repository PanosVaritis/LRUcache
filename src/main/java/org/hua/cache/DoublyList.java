
package org.hua.cache;

import java.util.NoSuchElementException;

/**
 * @param <K>
 * @param <V>
 * An implementation of the ListInterface
 * This class represents a doubly linked list
 * @author panos
 */

public class DoublyList<K,V> implements ListInterface<K,V> {

    
    private Node<K,V> head;
    
    private Node<K,V> tail;
    
    private int size;
    
    public DoublyList(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }
    
    @Override
    public void addFirst(K key, V value) {
        
        Node<K,V> newNode = new Node(key, value);
        
        
        if (isEmpty()){
            this.head = newNode;
            this.tail = newNode;
        }else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        this.size++;
    }

    @Override
    public void addLast(K key, V value) {
        
        
        Node<K,V> newNode = new Node(key, value);
        
        if (isEmpty()){
            this.head = newNode;
            this.tail = newNode;
        }else {
            newNode.prev = tail;
            tail.next = newNode;
            this.tail = newNode;
        }
        this.size++;
    }

    @Override
    public void removeLast() {
        if(isEmpty())
            throw new NoSuchElementException ("The list is empty. Cannot remove from an empty list...");
        
        if (head == tail){
            this.head = null;
            this.tail = null;
        }else {
            Node<K,V> tempo = tail;
            tail = tempo.prev;
            tail.next = null;
            tempo.prev = null;
        }
        this.size--;
    }

    @Override
    public void removeFirst() {
        if (isEmpty())
            throw new NoSuchElementException("The list is empty. Cannot remove from an empty list...");
    
        if (head == tail){
            this.head = null;
            this.tail = null;
        }else {
            Node<K,V> tempo = head;
            head = tempo.next;
            head.prev = null;
            tempo.next = null;
        }
        this.size--;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }
    
    
    @Override
    public Entry<K,V> getFirst(){
        if (isEmpty())
            throw new NoSuchElementException ("Nothing to return!! The list is empty...");
    
        return head.newEntry;
    
    }
    
    @Override 
    public Entry<K,V> getLast(){
        if (isEmpty())
            throw new NoSuchElementException ("Nothing to return!!! The list is empty...");
        
        if (size == 1)
            return head.newEntry;
            
        return tail.newEntry;
    }
    
    @Override 
    public int size(){
        return this.size;
    }
    
    
    @Override
    public void displayForward() {
        
        if (isEmpty()){
            throw new NoSuchElementException ("Nothing to print. The list is empty....");
        }
        
        Node<K,V> tempo = head;
        
        while (tempo != null){
            System.out.print (tempo.newEntry.getValue() +" <--> ");
            tempo = tempo.next;
        }
        System.out.println("\n");
    
    }
    
    
    /**
     * Inner class that represents the nodes. Since we make it static, it cannot access non static fields from the 
     * outside class and must declare the T specifically
     * @param <T> 
     */
    private static class Node<K,V>{
        
        public Entry<K,V> newEntry;
        
        public Node<K,V> next;
        
        public Node<K,V> prev;

        public Node (K key, V value){
            
            newEntry = new Entry<>(key, value);
            this.next = null;
            this.prev = null;
            
        }
    }
    
    
}
