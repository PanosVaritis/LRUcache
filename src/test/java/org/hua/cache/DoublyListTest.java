
package org.hua.cache;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author panos
 */
public class DoublyListTest {
    
    
    private ListInterface<Integer, String> list = new DoublyList<>();
    
    @Test
    public void doublyInsert() {
        
        assertTrue(list.isEmpty());

        int count = 100000;
        String text = "Value";
        for (int i = 0;i < count;i++){
            list.addFirst(i, text);
            assertTrue(list.size() == i+1);
        }
        
        assertTrue(list.size() == count);
        list.clear();
        assertTrue(list.size() == 0);
        
    }
    
}
