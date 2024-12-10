
package org.hua.cache;
/**
 *
 * @author panos
 * 
 */
public class App {

    public static void main(String[] args) {
        
        Cache<Integer, String> myCache = new LRUCache(3);

        myCache.put(1, "One");
        myCache.put(2, "Two");
        myCache.put(3, "Three");


        System.out.println ("Key with number 1 corresponds to value: "+myCache.get(1));
        System.out.println ("Key with number 5 corresponds to value: "+myCache.get(5));
        System.out.println ("Key with number 3 corresponds to value: "+myCache.get(3));


        myCache.put (2, "Hello");
        myCache.put(4, "Four");

        System.out.println ("Key with number 1 corresponds to value: "+myCache.get(1));

    }
}
