package org.hua.cache;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
/**
 *
 * @author panos
 */
public class DummyListTest {
    
    private DummyList<Integer, String> testList;
    
    
    @BeforeEach 
    public void setUp (){
        
        testList = new DummyList<>();
        
    }
    
    @Test
    public void test1 (){
        
        Node<Integer, String> node1 = new Node<>(1, "Panos");
        Node<Integer, String> node2 = new Node<>(2, "Nikos");
        Node<Integer, String> node3 = new Node<>(3, "Marios");
        Node<Integer, String> node4 = new Node<>(4, "Thanasis");
        Node<Integer, String> node5 = new Node<>(5, "Dimitris");
        Node<Integer, String> node6 = new Node<>(6, "George");
        Node<Integer, String> node7 = new Node<>(7, "Nikolas");
        Node<Integer, String> node8 = new Node<>(8, "Foteini");
        
        
        testList.dummyAdd(node1);
        testList.dummyAdd(node2);
        testList.dummyAdd(node3);
        testList.dummyAdd(node4);
        testList.dummyAdd(node5);
        testList.dummyAdd(node6);
        testList.dummyAdd(node7);
        testList.dummyAdd(node8);
        
        assertEquals(8, testList.size());
        testList.dummyDropSpecific(node4);
        assertEquals(7, testList.size());
        assertNull(testList.dummySearch(node4));
        testList.dummyDropSpecific(node1);
        assertEquals (6, testList.size());
        assertNull(testList.dummySearch(node1));
        
        testList.dummyDropSpecific(node2);
        assertEquals (5, testList.size());
        testList.dummySearch(node2);
        
        testList.dummyDropSpecific(node3);
        assertEquals (4, testList.size());
        testList.dummySearch(node3);
        
        
        testList.dummyDropSpecific(node5);
        assertEquals (3, testList.size());
        testList.dummySearch(node5);
        
        
        testList.dummyDropSpecific(node6);
        assertEquals (2, testList.size());
        testList.dummySearch(node6);
        
        
        testList.dummyDropSpecific(node7);
        assertEquals (1, testList.size());
        testList.dummySearch(node7);
        
        
        testList.dummyDropSpecific(node8);
        assertEquals (0, testList.size());
    }
    
    @Test
    public void test2 (){
        
        DummyList<Integer, Integer> listTest = new DummyList<>();
        
        Node<Integer, Integer> node = new Node<>(0, 10);
        Node<Integer, Integer> node1 = new Node<>(1, 11);
        Node<Integer, Integer> node2 = new Node<>(2, 12);
        Node<Integer, Integer> node3 = new Node<>(3, 13);
        Node<Integer, Integer> node4 = new Node<>(4, 14);
        Node<Integer, Integer> node5 = new Node<>(5, 15);
        
        assertEquals(0 ,listTest.size());
        listTest.dummyAdd(node);
        assertEquals (1, listTest.size());
        listTest.dummyAdd(node1);
        assertEquals (2, listTest.size());
        listTest.dummyAdd(node2);
        assertEquals (3, listTest.size());
        listTest.dummyAdd(node3);
        assertEquals (4, listTest.size());
        listTest.dummyAdd(node4);
        assertEquals (5, listTest.size());
        listTest.dummyAdd(node5);
        assertEquals (6, listTest.size());
        
        
        listTest.dummyDropSpecific(node2);
        assertEquals (5, listTest.size());
        assertNull (listTest.dummySearch(node2));
        assertEquals (5, listTest.dummySearch(node5));
        
        Node<Integer, Integer> node7 = new Node<>(7, 17);
        listTest.dummyAdd(node7);
        assertEquals (6, listTest.size());
        
        listTest.dummyDropSpecific(node7);
        assertEquals (5, listTest.size());
        assertNull (listTest.dummySearch(node7));
        
        listTest.dummyDropSpecific(node);
        assertEquals (4, listTest.size());
        assertNull (listTest.dummySearch(node));
        
        listTest.dummyDropSpecific(node1);
        assertEquals (3, listTest.size());
        assertNull (listTest.dummySearch(node1));
        
        listTest.dummyDropSpecific(node4);
        listTest.dummyDropSpecific(node5);
        listTest.dummyDropSpecific(node3);
        assertEquals (0, listTest.size());
        listTest.dummyAdd(node);
        listTest.dummyAdd(node1);
        listTest.dummyDropSpecific(node1);
        assertEquals (1, listTest.size());
        assertNull (listTest.dummySearch(node1));
        
        listTest.dummyAdd(node3);
        listTest.dummyDropSpecific(node);
        assertNull (listTest.dummySearch(node));
        assertEquals(1, listTest.size());
        listTest.dummyDropSpecific(node3);
        assertEquals (0, listTest.size());
    }

    
    /**
     * The purpose of the above tests is to study the behavior of the dummy list when we insert nodes,
     * and when we remove specific nodes. Those two operations will be done in LFU strategy and especially,
     * during the frequency update of a node. Then the appropriate node will be selected and will be removed
     * from the dummy List, and afterwards will be added to a dummy list with frequency higher by 1.
     * We make several dummyDropSpecific (node), in order to simulate all the possible positions that a node
     * might be in the dummy list. (First, Last, The only one, or in the middle)
     */
    
    
    @Test 
    public void test3 (){
        
        DummyList <Integer, Integer> dummyList = new DummyList<>();
        
        
        Node <Integer, Integer> node1 = new Node<>(1, 11);
        Node <Integer, Integer> node2 = new Node<>(2, 12);
        Node <Integer, Integer> node3 = new Node<>(3, 13);
        
        assertEquals(0, dummyList.size());
        dummyList.dummyAdd(node1);
        dummyList.dummyAdd(node2);
        dummyList.dummyAdd(node3);
        assertEquals(3, dummyList.size());
        
        /**
         * The current form of the dummy list here is: from head to tail node3 -> node2 -> node1, 
         * since the dummyAdd method adds each node at the head of the list similar to a stack. Also the, 
         * removal of the nodes is made through the head of the list, again working as stack. Bellow we will,
         * drop some nodes and and with the help of the assertions we will see the expected results.
         * After the dummy list is empty if we try to search for a node we will get an exception
         */
        
        dummyList.dummyDrop();
        assertEquals(2, dummyList.size());
        assertNull(dummyList.dummySearch(node3));
        
        dummyList.dummyDrop();
        assertEquals(1, dummyList.size());
        assertNull (dummyList.dummySearch(node2));
        
        dummyList.dummyDrop();
        assertEquals(0, dummyList.size());
                
        
    }
}
