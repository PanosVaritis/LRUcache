
package org.hua.cache;
import java.util.NoSuchElementException;

/**
 *Single Linked List Implementation
 * @author panos
 * @param <V>
 */
public class SingleList <V> implements SingleInter <V> {
    
    private Node <V> head;
    
    private int size;
    
    
    public SingleList (){
        this.size = 0;
    }
    
    
    public void add (V data){
        
        Node newNode = new Node (data);
                
        if (head == null){
            head = newNode;
        }else {
           Node current = head;
           while (current.next != null){
               current = current.next;
           }
           current.next = newNode;
        } 
    }
    
    
    public void remove(){
        
        if (head == null){
            throw new NoSuchElementException ("Cannot remove element from empty list!!");
        }else {
            Node theNext = head.next;
            head = theNext;
            //head = head.next;            
        }
    }
    
    
    public int size (){
    
        return this.size;
    }
    
    public boolean isEmpty(){
        
        return this.size == 0;
        
    }
    
    
    
    
    
        private static class Node <V> {
        public V data;
        public Node <V> next;
        
        public Node (V data){
            this.data = data;
            this.next = null;
        }
    }
    
    
}
