
package org.hua.cache;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author panos
 */
public class LRUCacheTest {
    
    
    private LRUCache<Integer, String> cache = new LRUCache<>(10);
    
    @Test
    public void cacheTest() {
        
        int count = 20;
        for (int i  = 0;i < count;i++){
            cache.put(i, " ");
        }
        
        assertTrue (cache.getActualSize() <= cache.getTotalSize());
    
        
        int count1 = 100000;
        for (int i = 0;i < count1;i++){
            cache.put(i, "");
        }
        
        assertTrue(cache.getActualSize() == cache.getTotalSize());
    
        cache.emptyCache();
        assertTrue(cache.getActualSize() == 0);
        assertTrue(cache.getTotalSize() == 10);
        
        
        for (int i = 0;i < count;i++){
            cache.put(1, " ");
        }
        assertTrue (cache.getActualSize() == 1);
        
    }
    
}
