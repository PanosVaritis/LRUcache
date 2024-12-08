
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
        Cache<Integer, String> myCache = new LRUCache(10);

        
        myCache.put(1, "Panos");
        myCache.put(2, "Dimiris");
        myCache.put(3, "Marios");
        myCache.put(4, "Maria");
        myCache.put(5, "Thanasis");
        myCache.put(6, "George");
        myCache.put(7, "Georgia");
        myCache.put(8, "Panagiota");
        myCache.put(9, "Panagiotis");
        myCache.put(10, "Stathis");
        myCache.put(11, "Iasonas");
        myCache.put(12, "Victoras");
        myCache.put(13, "Panagos");
        myCache.put(14, "Ioakim");
        myCache.put(15, "Nikolas");

        
        myCache.print();
    }
}
