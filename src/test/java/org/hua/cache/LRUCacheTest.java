
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
    
    //From this test and after we examine the MRU changing policy
    @Test
    public void cacheTestMru(){
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
    
    
    @Test
    public void cacheTestMru1(){
        Cache<Integer, String> myCache = new LRUCache<>(3, CacheReplacementPolicy.MRU);
        
        
        myCache.put(1, "Panos");
        myCache.put(1, "Dimitris");
        myCache.put(1, "Nikos");
        
        myCache.put(2, "Panos");
        
        myCache.put(3, "Manolis");
        assertEquals ("Nikos", myCache.get(1));
        
        myCache.put(3, "Marios");
        myCache.put(4, "Dimitris");
        assertNull (myCache.get(3));
        myCache.put(9, "Something");
        assertNull (myCache.get(4));
    }
    
    @Test
    public void cacheTestMru2(){
        Cache<Integer, String> myCache = new LRUCache<>(3, CacheReplacementPolicy.MRU);
        
        
        myCache.put(1, "Harokopeio");
        myCache.put(2, "Ekpa");
        myCache.put(3, "Assoe");
        myCache.put(4, "Har");
        myCache.put(5, "Har1");
        myCache.put(6, "Har2");
        myCache.put(7, "Har3");
        myCache.put(8, "Har4");
        myCache.put(9, "Har5");
        myCache.put(10, "Har6");
        myCache.put(11, "Har7");
        
        for (int i = 3; i < 11;i++)
            assertNull(myCache.get(i));
        
        assertEquals ("Harokopeio", myCache.get(1));
        assertEquals ("Ekpa", myCache.get(2));
        assertEquals ("Har7", myCache.get(11));
    }

    //This test does the same operations with the above. The only difference is in the policy
    @Test
    public void cacheTestLruSpecial(){
        Cache<Integer, String> myCache = new LRUCache<>(3, CacheReplacementPolicy.LRU);
   
        myCache.put(1, "Harokopeio");
        myCache.put(2, "Ekpa");
        myCache.put(3, "Assoe");
        myCache.put(4, "Har");
        myCache.put(5, "Har1");
        myCache.put(6, "Har2");
        myCache.put(7, "Har3");
        myCache.put(8, "Har4");
        myCache.put(9, "Har5");
        myCache.put(10, "Har6");
        myCache.put(11, "Har7");
        
        for (int i = 1;i < 9;i++)
            assertNull(myCache.get(i));
        
        assertEquals ("Har5", myCache.get(9));
        assertEquals ("Har6", myCache.get(10));
        assertEquals ("Har7", myCache.get(11));
    }
    
    @Test
    public void cacheTestMru3(){
        Integer count = 1000;
        Cache<Integer, Integer> myCache = new LRUCache<>(count, CacheReplacementPolicy.MRU);
        
        for (int i = 0;i < count;i++){
            myCache.put(i, i);
            assertEquals(i, myCache.get(i));
        }
        
        for (int i = count;i < 2*count;i++)
            myCache.put(i, i);
        
        for (int i = 0;i < count-1;i++)
            assertEquals(i, myCache.get(i));
        
        assertEquals (2*count - 1, myCache.get(2*count - 1));
        
        
        for (int i = count; i < 2*count -1;i++)
            assertNull(myCache.get(i));
    }
    
    
    @Test
    public void cacheTestLruSpecial2(){
        Integer count = 1000;
        Cache<Integer, Integer> myCache = new LRUCache<>(count, CacheReplacementPolicy.LRU);
        
        for(int i = 0;i < count;i++){
            myCache.put(i, i);
            assertEquals(i, myCache.get(i));
        }
        
        for (int i = count;i < 2*count;i++)
            myCache.put(i, i);
        
        for (int i = 0;i < count;i++)
            assertNull(myCache.get(i));
        
        for (int i = count; i < 2*count;i++)
            assertEquals (i, myCache.get(i));
    }


    @Test
    public void cacheTestLfu1 (){
        
        Cache<Integer, String> myCache = new LRUCache<>(3, CacheReplacementPolicy.LFU);
        
        //All of them have the frequency counter as default set to 1
        myCache.put(1, "Panos");
        myCache.put(2, "Nikos");
        myCache.put(3, "Takis");
        
        //Here we ask (get) 5 times the key 1 so the frequency counter should become 6. The other frequency counters remain to 1
        assertEquals("Panos", myCache.get(1));
        myCache.get(1);
        myCache.get(1);
        myCache.get(1);
        myCache.get(1);
        
        //The frequency for the object with key 2 is now 3
        myCache.get(2);
        myCache.get(2);
        
        //Overriding the value. The frequency counter for object with key 3 will become 2
        myCache.put(3, "Nikol");
        
        /*
        In the head of the cache we will have the object with key 3. In he middle the object with key 2,
        and in the tail the object with key 3. Bellow we will try to add a completely new key - value pair in the,
        cache. Normally the object with key number 3 should be removed since it has the lower frequency counter
        */
        
        myCache.put(4, "Thanasis");
        assertNull(myCache.get(3));
    }
    

}
