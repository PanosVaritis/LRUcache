
package org.hua.cache;

import java.util.Random;
/**
 *
 * @author panos
 * 
 */
public class App {

    public static void main(String[] args) {
        
        int count = 1000;
        Random random = new Random();
        Cache<Integer, String> cache = new LRUCache<>(count, CacheReplacementPolicy.LRU); 
        
        
        
        System.out.println ("Total operations: ");
        System.out.println ("Cache Hits: "+cache.getHitCount());
        System.out.println ("Cache Misses: "+cache.getMissCount());
        System.out.println ("Hit Rate: "+cache.getHitCount()/100.0);
        System.out.println ("Miss Rate: "+cache.getMissCount()/100.0);
        
        
    }
}
