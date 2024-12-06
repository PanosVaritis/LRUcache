
package org.hua.cache;

import java.util.NoSuchElementException;

/**
 * @param <T>
 * An implementation of the ListInterface
 * This class represents a doubly linked list
 * @author panos
 */

public class DoublyList<T> implements ListInterface<T> {

    private Node<T> head;
    private Node<T> tail;
    private int size;
    
    public DoublyList(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }
    
    @Override
    public void addFirst(T data) {
        
        Node<T> newNode = new Node(data);
        
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
    public void addLast(T data) {
        
        Node<T> newNode = new Node(data);
        
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
            Node<T> tempo = tail;
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
            Node<T> tempo = head;
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
    public T getFirst(){
        if (isEmpty())
            throw new NoSuchElementException ("Nothing to return!! The list is empty...");
    
        return head.data;
    
    }
    
    @Override 
    public T getLast(){
        if (isEmpty())
            throw new NoSuchElementException ("Nothing to return!!! The list is empty...");
        
        if (size == 1)
            return head.data;
            
        return tail.data;
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
        
        Node<T> tempo = head;
        
        while (tempo != null){
            System.out.print (tempo.data +" <--> ");
            tempo = tempo.next;
        }
        System.out.println("\n");
    
    }
    
    
    /**
     * Inner class that represents the nodes. Since we make it static, it cannot access non static fields from the 
     * outside class and must declare the T specifically
     * @param <T> 
     */
    private static class Node<T>{
        
        public T data;
        public Node<T> next;
        public Node<T> prev;
        
        public Node (T data){
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }
    
    
}
