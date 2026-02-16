import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import com.binarySearch_Tree.Tree;

public class TestTree {
    private Tree<Integer> bst;

    @BeforeEach
    public void setUp() {
        bst = new Tree<>();
    }

    /*
     * testing for insert and size
     */
    @Test
    public void testInsertAndSize() {
        assertTrue(bst.size() == 0);
        bst.insert(50);
        bst.insert(30);
        bst.insert(70);
        assertEquals(3, bst.size());
    }

    /*
     * testing whether a certain element exists in a tree or not
     */
    @Test
    public void testContains() {
        bst.insert(50);
        bst.insert(25);
        bst.insert(75);

        assertTrue(bst.contains(50));
        assertTrue(bst.contains(25));
        assertFalse(bst.contains(100));
    }

    @Test
    public void testHeight() {
        assertEquals(-1, bst.height());
        bst.insert(30);
        assertEquals(0, bst.height());
        bst.insert(20);
        bst.insert(40);
        bst.insert(10);
        bst.insert(50);
        assertEquals(2, bst.height());
    }

    @Test
    public void testRemovalOfLeaves() {
        bst.insert(30);
        bst.insert(20);
        bst.insert(10);
        assertFalse(bst.contains(50));
        bst.remove(10);
        assertTrue(!bst.contains(10));
        assertEquals(2, bst.size());
        bst.remove(20);
        assertFalse(bst.contains(20));
        assertEquals(1, bst.size());
    }

    @Test
    public void testSize() {
        bst.insert(10);
        bst.insert(10);
        bst.insert(10);
        bst.insert(10);
        bst.insert(10);
        bst.insert(10);
        bst.insert(10);

        assertTrue(bst.contains(10));
        assertEquals(0, bst.height());
        assertEquals(1, bst.size());
    }

    @Test
    public void testInOrderTraversal() {
        bst.insert(90);
        bst.insert(50);
        bst.insert(70);
        bst.insert(30);

        java.io.ByteArrayOutputStream stdout = new java.io.ByteArrayOutputStream();
        System.setOut(new java.io.PrintStream(stdout));
        bst.inOrder();

        assertEquals("30 50 70 90", stdout.toString().trim());
        // reseting the stream
        System.setOut(System.out);
    }
}

