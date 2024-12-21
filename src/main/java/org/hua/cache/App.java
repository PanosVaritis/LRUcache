
package org.hua.cache;

import java.util.Scanner;

import java.util.Random;
/**
 *
 * @author panos
 * 
 */
public class App {

    public static void main(String[] args) {
        
        int count = 1000;
        Scanner scanner = new Scanner(System.in);
        Random random = new Random ();
        Cache<Integer, String> cache;
        int key;
        int operations = 10000;
        
        
        System.out.println ("Welcome to the cache!!! Please select your strategy.");
        System.out.println ("1. LRU("+CacheReplacementPolicy.LRU+")");
        System.out.println ("2. MRU("+CacheReplacementPolicy.MRU+")");
        System.out.print ("Insert your choice (MRU or LRU): ");
        String dec = scanner.nextLine();
        
        
        if (dec.trim().equalsIgnoreCase("LRU")){
           cache = new LRUCache<>(count, CacheReplacementPolicy.LRU); 
        }else if (dec.trim().equalsIgnoreCase("MRU")){
            cache = new LRUCache<>(count, CacheReplacementPolicy.MRU);
        }else {
            throw new IllegalArgumentException ("The selected value is not correct");
        }


        for (int i = 0;i < count;i++){
            cache.put(i, "Student"+i);
        }
        
        for (int i = 0;i < operations;i++){
            key =  random.nextInt(10000);
            cache.get(key);
        }
            
        
        System.out.println ("Total operations: "+operations);
        System.out.println ("Cache hits: "+cache.getHitCount());
        System.out.println ("Cache misses: "+cache.getMissCount());
        System.out.println ("Hit rate: "+cache.getHitCount()/100.0);
        System.out.println ("Miss Rate: "+cache.getMissCount()/100.0);
        
        
        
    }
}
