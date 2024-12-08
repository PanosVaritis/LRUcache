
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
        
        
        for (int i = 0;i< count;i++){
            list.addLast(i, text);
            assertTrue(list.size() == i+1);
        }
        
        assertTrue(list.size() == count);
        list.clear();
        assertTrue(list.size() == 0);
        
        
        for (int i = 0;i < count;i++){
            list.addFirst(i, text);
            list.addLast(i+count, text);
        }
        
        assertTrue(list.size() == 2*count);
        list.clear();
        assertTrue(list.size() == 0);
        
        
        for (int i = 0;i < count;i++){
            list.addLast(i, text);
            assertTrue(list.size() == 1);
            list.removeFirst();
            assertTrue(list.size() == 0);
        }
        
        assertTrue(list.size() == 0);
        
        
        for (int i = 0;i < count;i++){
            list.addFirst(i, text);
            assertTrue (list.size() == i+1);
        }
        
        assertTrue(list.size() == count);
        
        for (int i = 0;i < count;i++){
            assertTrue(list.getLast().getNewEntry().getKey() == i);
            assertTrue(list.getLast().getNewEntry().getValue().equals(text));
            list.removeLast();
        }
        assertTrue(list.size() == 0);
        
        
        for (int i = 0;i < count;i++){
            list.addLast(i, text);
            assertTrue(list.size() == i+1);
        }
        
        assertTrue (list.size() == count);
        
        for (int i = 0;i < count;i++){
            assertTrue(list.getFirst().getNewEntry().getKey() == i);
            assertTrue(list.getFirst().getNewEntry().getValue().equals(text));
            list.removeFirst();
        }
        assertTrue(list.size() == 0);
        
    }
    
}
