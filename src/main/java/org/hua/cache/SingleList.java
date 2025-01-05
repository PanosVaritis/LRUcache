
package org.hua.cache;
import java.util.NoSuchElementException;

/**
 *Single Linked List Implementation
 * @author panos
 * @param <T>
 */
public class SingleList <T> {
    
    
    private static class Node <T> {
        public T data;
        public Node <T> next;
        
        public Node (T data){
            this.data = data;
            this.next = null;
        }
    }
    
    private Node <T> head;
    
    public void addToList (T data){
        
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
    
    
    public void removeFromList(){
        
        if (head == null){
            throw new NoSuchElementException ("Cannot remove element from empty list!!");
        }else {
            Node theNext = head.next;
            head = theNext;
            //head = head.next;            
        }
        
    }
    
    public void printList (){
        
        Node current = head;
        while (current != null){
            System.out.print (current.data + " -> ");
            current = current.next;
        }
        
        System.out.println ("null");
    }
}
