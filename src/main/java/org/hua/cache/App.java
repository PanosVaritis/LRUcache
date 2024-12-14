
package org.hua.cache;

/**
 *
 * @author panos
 * 
 */
public class App {

    public static void main(String[] args) {
        
        Cache<Integer, String> cache = new LRUCache<>(3, CacheReplacementPolicy.MRU); 
        
    }
}
