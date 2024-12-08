
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
//        Cache<Integer, String> myCache = new LRUCache(10);
        LRUCache<Integer, String> myCache = new LRUCache(10);

        
        myCache.put(1, "Panos");
        myCache.put(1, "Dimiris");
        myCache.put(1, "Marios");
        myCache.put(1, "Maria");
        myCache.put(1, "Thanasis");
        myCache.put(1, "George");
        myCache.put(1, "Georgia");
        myCache.put(1, "Panagiota");
        myCache.put(1, "Panagiotis");

        
    }
}
