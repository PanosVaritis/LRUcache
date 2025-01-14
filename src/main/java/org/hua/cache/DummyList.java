package org.hua.cache;

import java.util.NoSuchElementException;

/**
 * @author panos
 * @param <K>
 * @param <V>
 **/


public class DummyList <K,V>{
    
    private Node<K,V> dummyHead;
    
    private Node<K,V> dummyTail;
    
    private int size;
    
    public  DummyList (){
        this.dummyHead = null;
        this.dummyTail = null;
        this.size = 0;
    }
    
    
    public void dummyAdd (Node<K,V> node){
        
        if (isEmpty()){
            this.dummyHead = node;
            this.dummyTail = node;
        }else {
            node.setDummyNext(this.dummyHead);
            dummyHead.setDummyPrev(node);
            this.dummyHead = node;
        }
        this.size++;
    }
    
    public Node<K,V> dummyDrop (){
        
      if (isEmpty())
          throw new NoSuchElementException ("The dummy list is empty. Cannot remove from empty dummy list.....");
      
      Node<K,V> toBeDropped  = dummyHead;
      
      if (dummyHead == dummyTail){
          this.dummyHead = null;
          this.dummyTail = null;
      }else {
          dummyHead = toBeDropped.getNext();
          dummyHead.setDummyPrev(null);
          toBeDropped.setDummyNext(null);
      }  
        
      this.size--;
      return toBeDropped; 
      
//      
//
//        //Must be carefful with the null pointer exception
//        Node<K,V> tempo = head;
//            
//        if (head == tail){
//            this.head = null;
//            this.tail = null;
//        }else {
//            head = tempo.getNext();
//            head.setPrev(null);
//            tempo.setNext(null);
//        }
//        this.size--;
//        return tempo;
    }
    
    public void dummyDropSpecific (Node<K,V> node){
        
        //We check if the dummy list is empty
        if (isEmpty())
            throw new NoSuchElementException ("The dummy list is empty!!! Cannot drop specific from dummy list.....");
        
        //We check if the dummy list has only one node inside (Size == 1)
        if (dummyHead == dummyTail){
            this.dummyHead = null;
            this.dummyTail = null;
            node.setDummyNext(null);
            node.setDummyPrev(null);
            this.size --;
            return ;
        }

        
        //We check if the node that we are trying to remove is the first on the dummy list
        if (node.getDummyPrev() == null){
            dummyHead = dummyHead.getDummyNext();
            dummyHead.setDummyPrev(null);
            node.setDummyNext(null);
            this.size--;
            return ;
        }
        
        //We check if the node that we are trying to remove is the last on the list
        if (node.getDummyNext() == null){
            dummyTail = dummyTail.getDummyPrev();
            dummyTail.setDummyNext(null);
            node.setDummyPrev(null);
            this.size--;
            return ;
        }
        
        
        //If we reach this area, this means that the node we are trying to remove is somewehre inside the list
        Node<K,V> back = node.getDummyPrev();
        Node<K,V> front = node.getDummyNext();
        back.setDummyNext(front);
        front.setDummyPrev(back);
        node.setDummyNext(null);
        node.setDummyPrev(null);
        this.size--;
        
    }
    
    public boolean isEmpty (){
        return this.size == 0;
    }
    
    
    public int size (){
        return this.size;
    }
    
    //For test purposes!
    public K dummySearch (Node <K,V> dummyNode){
        
        if (isEmpty())
            throw new NoSuchElementException ("Dummy list is empty");
        
        Node<K,V> current = dummyHead;
        
        while (current != null){
            if (current == dummyNode){
                return dummyNode.getNewEntry().getKey();
            }
            current = current.getDummyNext();
        }
        
        return null;
    }
    
    
    
}
