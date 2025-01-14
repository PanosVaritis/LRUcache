package org.hua.cache;

/**
 *
 * @author panos
 * @param <K>
 * @param <V>
 **/


public class DummyList <K,V>{
    
    private Node<K,V> dummyNext;
    
    private Node<K,V> dummyPrev;
    
    private int size;
    
    public  DummyList (){
        this.dummyNext = null;
        this.dummyPrev = null;
        this.size = 0;
    }
    
    
    public void dummyAdd (Node<K,V> node){
        
    }
    
    public Node<K,V> dummyDrop (){
        
      return null; 
    }
    
    public void dummyDropSpecific (Node<K,V> node){
        
    }
    
    
}
