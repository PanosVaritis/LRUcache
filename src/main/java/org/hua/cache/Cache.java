
package org.hua.cache;

/**
 * A cache interface 
 * 
 * @param <K> the key type
 * @param <V>  the value type
 * 
 * @author panos
 */
public interface Cache <K, V>{
    
    /**
     * Get the value for a key. Returns null if the key is not in the cache
     * @return the value of the key
     * @param key the key
     */
    V get(K key);
    
    /**
     * Put a new key value pair in the cache
     * 
     * @param key the key
     * @param value the value
     *
     */
    void put (K key, V value);
    
    /**
     * When this method is called will return the number of hits in the cache so far
     * It doesn't make any calculation. Just returns the value. 
     * @return number of times the item was found
     */
    int getHitCount();
    
    /**
     * When this method is called will return the number of misses in the cache so far
     * It doesn't make any calculation. Just returns the value. 
     * @return number of times the item was not found
     */
    int getMissCount();
    
}
