
package org.hua.cache;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author panos
 */
public class LRUCacheTest {
    
    
    private Cache<Integer, String> cache;
    
    @BeforeEach
    public void setUp(){
        cache = new LRUCache<>(3);
    }
    
    
    @Test
    public void cacheTest() {
        
        cache.put(1, "One");
        cache.put(2, "Two");
        cache.put(3, "Three");
        
        
        assertEquals("One", cache.get(1));
        assertEquals("Two", cache.get(2));
        assertEquals("Three", cache.get(3));
    }
    
    @Test
    public void cacheTest1(){

        cache.put(1, "One");
        cache.put(2, "Two");
        cache.put(3, "Three");

        assertEquals("One", cache.get(1));
        assertEquals("Two", cache.get(2));
        assertEquals("Three", cache.get(3));
        
        cache.put(4, "Four");
                
        assertNull(cache.get(1));
        assertEquals("Two", cache.get(2));
        assertEquals("Three", cache.get(3));
        assertEquals("Four", cache.get(4));

    }

    @Test
    public void cacheTest2(){
        
        cache.put(1, "One");
        cache.put(2, "Two");
        cache.put(3, "Three");

        assertEquals("One", cache.get(1));
        assertEquals("Two", cache.get(2));
        assertEquals("Three", cache.get(3));
        
        cache.get(1);
        cache.put(4, "Four");
        
        assertNull(cache.get(2));
        assertEquals("One", cache.get(1));
        assertEquals("Three", cache.get(3));
        assertEquals("Four", cache.get(4));
    }
    
    
    @Test
    public void cacheTest3(){
        
        cache.put(1, "One");
        cache.put(2, "Two");
    
        assertEquals ("One", cache.get(1));
        assertEquals ("Two", cache.get(2));
        
        cache.put(3, "Three");
        
        assertEquals("Three", cache.get(3));
        
        cache.put(4, "Four");
        assertNull(cache.get(1));
        assertEquals("Two", cache.get(2));
        assertEquals("Three", cache.get(3));
        assertEquals("Four", cache.get(4));
    }
    

    @Test
    public void cacheTest4(){
        
        assertNull(cache.get(1));
        assertNull(cache.get(2));
        assertNull(cache.get(3));
        assertNull(cache.get(4));
    }
    
}
