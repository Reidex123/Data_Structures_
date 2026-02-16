import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.Linked_Lists.singlyLinkedList.LinkedList;

public class testLinkedList {

    private LinkedList<Integer> list;

    @BeforeEach
    public void setUp() {
        list = new LinkedList<>();
    }

    @Test
    public void testAdd() {
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);

        assertEquals(Integer.valueOf(1), list.getFirst());
        assertEquals(Integer.valueOf(6), list.getLast());
    }

    @Test
    public void testAddFirstAndAddLast() {
        list.add(1);
        list.add(2);

        list.addFirst(10);
        list.addLast(12);

        assertEquals(Integer.valueOf(10), list.getFirst());
        assertEquals(Integer.valueOf(12), list.getLast());
    }

    @Test
    public void testAddAtIndex() {
        list.add(1);
        list.add(2);
        list.add(3);

        list.add(1, 9); // Insert 9 at index 1

        assertEquals(Integer.valueOf(9), list.get(1));
    }

    @Test
    public void testElement() {
        list.add(5);
        list.add(6);

        assertEquals(Integer.valueOf(5), list.element());
    }

    @Test
    public void testGetMethods() {
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        assertEquals(Integer.valueOf(4), list.get(3));
        assertEquals(Integer.valueOf(1), list.getFirst());
        assertEquals(Integer.valueOf(4), list.getLast());
    }

    @Test
    public void testPeekMethods() {
        list.add(7);
        list.add(8);
        list.add(9);

        assertEquals(Integer.valueOf(7), list.peek());
        assertEquals(Integer.valueOf(7), list.peekFirst());
        assertEquals(Integer.valueOf(9), list.peekLast());
    }
}
