
package org.hua.cache;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

import java.util.Random;
import java.util.Set;
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
        System.out.print ("Insert your choice (MRU or LRU): ");
        String dec = scanner.nextLine();
        
        
        if (dec.trim().equalsIgnoreCase("LRU")){
           cache = new LRUCache<>(count, CacheReplacementPolicy.LRU); 
        }else if (dec.trim().equalsIgnoreCase("MRU")){
            cache = new LRUCache<>(count, CacheReplacementPolicy.MRU);
        }else {
            throw new IllegalArgumentException ("The selected value is not correct");
        }

        

        Set<Integer> fr = new HashSet<>();
        for (int i = 1;i <= 10;i++)
            fr.add(i);
        
        Set<Integer> all = new HashSet<>();
        for (int i = 1;i <= 200;i++)
            all.add(i);
        
        
        
        for (int i = 0;i < operations;i++){
            
            if (random.nextInt(100) < 70){
                List<Integer> frequent = new ArrayList<>(fr);
                key = frequent.get(random.nextInt(frequent.size()));
            }else {
                List<Integer> allKeys = new ArrayList<>(all);
                key = allKeys.get(random.nextInt(all.size()));
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
