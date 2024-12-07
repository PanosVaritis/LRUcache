package org.hua.cache;

import java.util.LinkedList;
import java.util.ListIterator;

public class MyHash<K, V> implements HashInterface<K, V> {

    public static final int DEFAULT_SIZE = 17;
    
    private LinkedList<Entry<K, V>>[] array;

    private int size;

    public MyHash(int m) {
        if (m <= 0){
            throw new IllegalArgumentException("Array size must be positive");
        }
        this.size = 0;
        this.array = (LinkedList<Entry<K, V>> []) new Object[m];
        
        for (int i = 0;i < m;i++){
            this.array[i] = new LinkedList<>();
        }
        
    }

    public MyHash() {
        this(DEFAULT_SIZE);
    }

    @Override
    public void put(K key, V value) {
        insert(key, value);
    }

    @Override
    public V remove(K key) {
        LinkedList<Entry<K, V>> list = getList(key);
        
        ListIterator<Entry<K, V>> it = list.listIterator();
        while (it.hasNext()){
            Entry<K, V> cur = it.next();
            
            if (key.equals(cur.getKey())){
                
                V value = cur.getValue();
                it.remove();
                size--;
                return value;
            }
        }
        return null;
    
    }

    @Override
    public V get(K key) {
        
        LinkedList<Entry<K, V>> list = getList(key);
        
        for (Entry<K,V> e: list){
            if (key.equals(e.getKey())){
                return e.getValue();
            }
        }
        return null;
    }

    @Override
    public boolean contains(K key) {
        
        LinkedList<Entry<K, V>> list = getList(key);
        
        for (Entry<K,V> e: list){
            if (key.equals(e.getKey())){
                return true;
            }
        }
        return false;
    }


    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        for (int i = 0; i < array.length;i++){
            array[i].clear();
        }
        this.size = 0;
        
    }

    private LinkedList<Entry<K,V>> getList(K key){
        return array[Math.abs(key.hashCode()) % array.length];
    }


    //Does not rehash. Just insert the key and the value in the appropriate position
    private void insert(K key, V value){
        
        LinkedList<Entry<K, V>> list = getList(key);
        
        ListIterator<Entry<K, V>> it = list.listIterator();
        while (it.hasNext()){
            Entry<K, V> cur = it.next();
            
            if (key.equals(cur.getKey())){
                it.set(new Entry<>(key, value));
                return ;
            }
        }
        list.addFirst(new Entry<>(key, value));
        size++;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }
    

    

}

