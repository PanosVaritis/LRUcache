
package org.hua.cache;

import java.util.Iterator;
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
            newNode.setNext(head);
            head.setPrev(newNode);
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
            newNode.setPrev(tail);
            tail.setNext(newNode);
            tail = newNode;
        }
        this.size++;
    }

    @Override
    public Node<K,V> removeLast() {
        if(isEmpty())
            throw new NoSuchElementException ("The list is empty. Cannot remove from an empty list...");
        
        //must be carefful of the null pointer exception 
        Node<K,V> tempo = tail;

        if (head == tail){
            this.head = null;
            this.tail = null;
        }else {
            tail = tempo.getPrev();
            tail.setNext(null);
            tempo.setPrev(null);
        }
        this.size--;
        return tempo;
    }

    @Override
    public Node<K,V> removeFirst() {
        if (isEmpty())
            throw new NoSuchElementException("The list is empty. Cannot remove from an empty list...");
    
        //Must be carefful with the null pointer exception
        Node<K,V> tempo = head;
            
        if (head == tail){
            this.head = null;
            this.tail = null;
        }else {
            head = tempo.getNext();
            head.setPrev(null);
            tempo.setNext(null);
        }
        this.size--;
        return tempo;
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
    public Node<K,V> getFirst(){
        if (isEmpty())
            throw new NoSuchElementException ("Nothing to return!! The list is empty...");
    
        return head;

    }
    
    @Override 
    public Node<K,V> getLast(){
        if (isEmpty())
            throw new NoSuchElementException ("Nothing to return!!! The list is empty...");
        
        if (size == 1)
            return head;
            
        return tail;
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
            System.out.print (tempo.getNewEntry().getValue() +" <--> ");
            tempo = tempo.getNext();
        }
        System.out.println("\n");
    
    }
    
    @Override
    public void moveToTop (Node<K,V> node){
        removeNodeFromPosition(node);
        addNodeToStart(node);
        
    }

    private void addNodeToStart(Node<K,V> node){
    
        
        if (isEmpty()){
            this.head = node;
            this.tail = node;
        }else {
            node.setPrev(tail);
            tail.setNext(node);
            tail = node;
        }
    }
    
    private void removeNodeFromPosition(Node<K,V> node){
        Node<K,V> tempo = node.getPrev().getNext();
        tempo.setNext(node.getNext());
        
        Node<K,V> tempo1 = node.getNext().getPrev();
        tempo1.setPrev(node.getPrev());
        
        
        node.setNext(null);
        node.setPrev(null);
    
    }
    
    @Override 
    public Iterator<Node<K,V>> iterator(){
        return new ListIterator();
    }
    
    
     private class ListIterator implements Iterator<Node<K,V>>{
         
         private Node<K,V> it = head.getNext();
        
        @Override
        public boolean hasNext() {
            return it != tail;
            
        }

        @Override
        public Node<K,V> next() {
            if (!hasNext())
                throw new NoSuchElementException();
            
            Node<K,V> node = it;
            it = it.getNext();
            return node;
        }
        
    }
    
}
