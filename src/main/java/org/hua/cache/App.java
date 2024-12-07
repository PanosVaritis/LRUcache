
package org.hua.cache;
import java.util.Scanner;

/**
 *
 * @author panos
 */
public class App {

    public static void main(String[] args) {
        System.out.println("This is a simple app for the doubly linked list");
        
        ListInterface<Integer, String> list = new DoublyList<>();
        
        /**
         * Bellow the actual program will be executed!!!
        */
        Scanner input = new Scanner (System.in);
        int cacheSize;
        System.out.print ("Provide the size of the cache: ");
        cacheSize = input.nextInt();
        Cache<Integer, String> myCache = new LRUCache(cacheSize);
        myCache.put(2021000, "Varitis");
        myCache.put(2021001, "Marousakis");
        myCache.put(2021002, "Perdios");
        myCache.put(2021003, "Moraitis");
        myCache.put(2021004, "Dimitrakopoulos");

        
        myCache.get(2021000);//will return the value of the key
        myCache.get(2021003);//will return thr value
        myCache.get(2021); /// Does not exist exception

    }
}
