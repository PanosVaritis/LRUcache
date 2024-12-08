
package org.hua.cache;
/**
 *
 * @author panos
 * 
 */
public class App {

    public static void main(String[] args) {
        
        /**
         * Bellow the actual program will be executed!!!
        */
        Cache<Integer, String> myCache = new LRUCache(3);
//        LRUCache<Integer, String> myCache = new LRUCache(10);
    
    myCache.put(1, "One");
    myCache.put(2, "Two");
    myCache.put(3, "Three");
    
    
    System.out.println ("Get key 1: "+myCache.get(1));
    System.out.println ("Get key 2: "+myCache.get(2));
    System.out.println ("Get key 3: "+myCache.get(3));
    
    myCache.put(4, "Four");
    
    System.out.println ("Get key 1 after addind 4: "+myCache.get(1));
    System.out.println ("Get key 2 after adding 4: "+myCache.get(2));
    System.out.println ("Get key 3 after adding 4: "+myCache.get(3));
    System.out.println ("Get key 4: "+myCache.get(4));
    
    
    myCache.put(5, "Five");
    
    System.out.println ("Get key 2 after addind 5: "+myCache.get(2));
    System.out.println ("Get key 3 after adding 5: "+myCache.get(3));
    System.out.println ("Get key 4 after adding 5: "+myCache.get(4));
    System.out.println ("Get key 5: "+myCache.get(5));
    
            
    
    
    }
}
