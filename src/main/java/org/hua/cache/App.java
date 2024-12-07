
package org.hua.cache;

/**
 *
 * @author panos
 */
public class App {

    public static void main(String[] args) {
        
        /**
         * Bellow the actual program will be executed!!!
        */
        Cache<Integer, String> myCache = new LRUCache(10);
        myCache.put(2021001, "Marousakis");
        myCache.put(2021002, "Perdios");
        myCache.put(2021003, "Moraitis");
        myCache.put(2021004, "Dimitrakopoulos");
        
        myCache.print();


//        myCache.get(2021000);//will return the value of the key
//        myCache.get(2021003);//will return thr value
//        myCache.get(2021); /// Does not exist exception

    }
}
