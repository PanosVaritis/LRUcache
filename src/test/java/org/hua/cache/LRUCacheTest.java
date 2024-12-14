
package org.hua.cache;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author panos
 * 
 * Until test with number 13 we examine the LRU strategy. From test 13 and down we examine the MRU strategy
 */
public class LRUCacheTest {
    
    
    private Cache<Integer, String> cache;
    
    @BeforeEach
    public void setUp(){
        cache = new LRUCache<>(3, CacheReplacementPolicy.LRU);
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
    
    @Test
    public void cacheTest5(){
        
        for (int i = 0;i < 100;i++){
            cache.put(i,"Text");
        }
        
        for (int i = 0;i < 97;i++){
            assertNull (cache.get(i));
        }
        
        assertEquals("Text", cache.get(99));
        assertEquals("Text", cache.get(98));
        assertEquals("Text", cache.get(97));
        
        cache.put(1, "Panos");
        assertNull(cache.get(99));
        cache.put(2, "Marios");
        assertNull (cache.get(88));
        cache.put(3, "Dimitris");
        assertNull (cache.get(97));
        cache.put(4, "Marios");
        assertNull (cache.get(1));
    }
    
    @Test
    public void cacheTest6(){
        
        int count = 100000;
        Cache<Integer, String> cache = new LRUCache<>(count, CacheReplacementPolicy.LRU);
        
        for (int i = 0;i < count;i++){
            cache.put(i, "Text "+i);
        }
        
        for (int i = 0;i < count;i++){
            assertEquals("Text "+i, cache.get(i));
        }
        
        cache.put(1, "Panos");
        cache.put (200000, "Nikos");
        assertNull (cache.get(0));
        cache.put (200001, "Maria");
        cache.put (200002, "Takis");
        assertNull(cache.get(2));
        assertNull(cache.get(3));
    }
    
    @Test
    public void cacheTest7(){
        
        //Since we allow to store strings, the deafault value of a string is null
        cache.put(1, null);
        assertNull(cache.get(1));
        
        cache.put(Integer.MAX_VALUE, "Panagiotis");
        assertEquals ("Panagiotis", cache.get(Integer.MAX_VALUE));
        
        cache.put(Integer.MIN_VALUE, "Dimitrios");
        assertEquals ("Dimitrios", cache.get(Integer.MIN_VALUE));
        
        cache.get(1);
        cache.put(Integer.MAX_VALUE-1, "Manolis");
        assertNull(cache.get(Integer.MAX_VALUE));
    }
  
    @Test
    public void cacheTest8(){
        
        int count = 5000000;
        
        Cache<Integer, String> myCache = new LRUCache<>(count, CacheReplacementPolicy.LRU);
        
        for (int i = 0;i < count;i++){
            myCache.put(i, "Number "+i);
        }
        
        for (int i = 0;i < count;i++){
            assertEquals ("Number "+i, myCache.get(i));
        }
    }

    @Test
    public void cacheTest9(){
        
        int count = 10000;
        Cache<Integer, Integer> myCache = new LRUCache<>(count, CacheReplacementPolicy.LRU);
        
        for (int i = 0;i < count;i++){
            myCache.put(i, i*10);
        }
        
        for (int i = 0;i < count;i++){
            assertEquals(i*10, myCache.get(i));
        }
        
        for (int i = count;i < count*2;i++){
            myCache.put (i, i*2);
        }
        
        for (int i = 0;i < count;i++){
            assertNull(myCache.get(i));
        }
        
        for (int i = count;i < count*2;i++){
            assertEquals(i*2, myCache.get(i));
        }
    }
    
    @Test
    public void cacheTest10(){
        
        
        Cache<String, String> myCache = new LRUCache<>(3, CacheReplacementPolicy.LRU);
        
        assertNull (myCache.get("Varitis"));
        assertNull (myCache.get("Rerdios"));
        assertNull (myCache.get("Haralabidis"));
        
        myCache.put("Varitis", "Data Structures");
        myCache.put("Perdios", "Distributed Systems");
        myCache.put("Haralabidis", "Object Oriented");
        
        assertEquals ("Data Structures", myCache.get("Varitis"));
        assertEquals ("Distributed Systems", myCache.get("Perdios"));
        assertEquals ("Object Oriented", myCache.get("Haralabidis"));
        
        myCache.put ("Varitis", "Distributed Systems");
        myCache.put("Bardaki", "Software Eng");
        assertNull(myCache.get("Perdios"));
        
    }
    
    public void cacheTest11(){
        
        Cache<String, String> myCache = new LRUCache<>(3, CacheReplacementPolicy.LRU);
        
        for (int i = 0;i < 100000;i++)
            myCache.put ("Panos", "Varitis"+i);
        
        assertEquals ("Varitis"+99999, myCache.get("Panos"));
    }
    
    @Test
    public void cacheTest12(){
        
        int count = 100000;
        Cache<String, String> myCache = new LRUCache<>(count, CacheReplacementPolicy.LRU);
        
        
        for (int i = 0;i < count;i++)
            myCache.put ("it2021"+i,"Student"+i);
        
        for (int i = 0;i < count;i++)
            assertEquals ("Student"+i, myCache.get("it2021"+i));
        
        
        myCache.put("it2021"+count, "Student"+count);
        assertNull (myCache.get("it2021"+0));
    }
    
    @Test
    public void cacheTest13(){
        Cache<Integer,String> myCache = new LRUCache<>(3, CacheReplacementPolicy.MRU);
        
        myCache.put(1, "One");
        myCache.put(2, "Two");
        myCache.put(3, "Three");

        assertEquals("One", myCache.get(1));
        assertEquals("Two", myCache.get(2));
        assertEquals("Three", myCache.get(3));
        
        myCache.put(4, "Four");
                
        assertNull(myCache.get(3));
        assertEquals("Two", myCache.get(2));
        assertEquals("One", myCache.get(1));
        assertEquals("Four", myCache.get(4));
    }
}
