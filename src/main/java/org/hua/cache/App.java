
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
        
        int count = 10;
        Scanner scanner = new Scanner(System.in);
        Random random = new Random ();
        Cache<Integer, String> cache;
        Integer key;
        int operations = 10000;
        
        System.out.println ("Welcome to the cache!!! Please select your strategy.");
        System.out.println ("1. LRU("+CacheReplacementPolicy.LRU+")");
        System.out.println ("2. MRU("+CacheReplacementPolicy.MRU+")");
        System.out.println ("3. LFU("+CacheReplacementPolicy.LFU+")");
        System.out.print ("Insert your choice (MRU or LRU): ");
        String dec = scanner.nextLine();
        
        if (dec.trim().equalsIgnoreCase("LRU")){
           cache = new LRUCache<>(count, CacheReplacementPolicy.LRU); 
        }else if (dec.trim().equalsIgnoreCase("MRU")){
            cache = new LRUCache<>(count, CacheReplacementPolicy.MRU);
        }else if (dec.trim().equalsIgnoreCase("LFU")){
            cache = new LRUCache<>(count, CacheReplacementPolicy.LFU);
        }else {
            throw new IllegalArgumentException ("The selected value is not correct");
        }


        for (int i = 0;i < operations;i++){
            
            if (random.nextInt(100) < 70){

                key = random.nextInt(10) + 1;
            }else {
                
                key = random.nextInt(200) + 1;
                
                while (key <= 10)
                    key = random.nextInt(200) + 1;
            }
            
            if (random.nextBoolean()){
                
                cache.get(key);
            }else {
                
                cache.put(key, "Student"+key);
            }
        }
        System.out.println ("Total operations: "+operations);
        System.out.println ("Cache hits: "+cache.getHitCount());
        System.out.println ("Cache misses: "+cache.getMissCount());
        System.out.println ("Hit rate: "+cache.getHitCount()/100.0);
        System.out.println ("Miss Rate: "+cache.getMissCount()/100.0);
    }
}
