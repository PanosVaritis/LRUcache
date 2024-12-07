
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
        
        for (int i = 0;i < count;i++){
//            list.addFirst(i);
            assertTrue(list.size() == i+1);
        }

        int current = 0;
        while (!list.isEmpty()){
//            assertTrue(list.getLast() == current);
            list.removeLast();
            current++;
        }
        
        for (int i = 0;i < count;i++){
//            list.addLast(i);
            assertTrue(list.size() == i+1);
        }

        list.clear();
        assertTrue(list.isEmpty());

        
        for (int i = 0;i < count;i++){
//            list.addLast(i);
            assertTrue(list.size() == i+1);
        }
        
        current = 0;
        while (!list.isEmpty()){
//            assertTrue(list.getFirst() == current);
            list.removeFirst();
            current++;
        }
        
        assertTrue (list.size() == 0);
    }
    
}
