
package org.hua.cache;
import java.util.Scanner;

/**
 *
 * @author panos
 */
public class App {

    public static void main(String[] args) {
        System.out.println("This is a simple app for the doubly linked list");
        
        ListInterface<Integer> list = new DoublyList<>();
        
        for (int i = 0;i < 10;i++){
            list.addLast(i);
        }
        
        
        list.displayForward();
        list.clear();


        for (int i = 0;i < 10;i++)
            list.addFirst(i);
        list.displayForward();
        
        
        while (!list.isEmpty()){
            list.displayForward();
            list.removeLast();
        }
        
        for (int i = 0;i < 10;i++)
            list.addLast(i+10);
        
        list.displayForward();
        list.clear();
        
        for (int i = 0;i < 10;i++)
            list.addFirst(i);
        
        while (!list.isEmpty()){
            list.displayForward();
            list.removeFirst();
        }
        
    
       
        
        /**
         * Bellow the actual program will be executed!!!
         */
//        Scanner input = new Scanner (System.in);
//        int cacheSize;
//        System.out.print ("Provide the size of the cache: ");
//        cacheSize = input.nextInt();
//        Cache<Integer, String> myCache = new LRUCache(cacheSize);
        
        
    }
}
