import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.*;

import com.Linked_Lists.singlyLinkedList.LinkedList;

public class TestLinkedList {
    private final LinkedList<Integer> list;

    public TestLinkedList() {
        this.list = new LinkedList<>();
    }

    @Test
    public void testAdd() {
	for(int i = 1; i <= 6; i++) {
		this.list.add(i);
	}

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
	for(int i = 1; i <= 3; i++) {
		this.list.add(i);
	}
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
	for(int i = 1; i <= 4; i++ {
		this.list.add(i);
	}

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
