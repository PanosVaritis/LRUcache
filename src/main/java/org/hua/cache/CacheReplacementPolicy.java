
package org.hua.cache;

/**
 *
 * @author panos
 */
public enum CacheReplacementPolicy {
    
    LRU("Least Recent Used"),
    MRU("Most Recent Used");
    
    private final String description;
    
        
        
        
    
    CacheReplacementPolicy(String description){
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString(){
        return description;
    }
}
