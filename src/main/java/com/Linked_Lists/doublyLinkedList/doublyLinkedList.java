package com.Linked_Lists.doublyLinkedList;


import java.util.Iterator;

public class doublyLinkedList<T> implements Iterable<T> {

    @SuppressWarnings("hiding")
    public class Node<T> {
        public T data;
        public Node<T> prev;
        public Node<T> next;

        public Node(T data) {
            this.data = data;
        }
    }

    public class listIterator implements Iterator<T> {
        Node<T> current;

        public listIterator(doublyLinkedList<T> list) {
            current = list.head;
        }

        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public T next() {
            return null;
        }
    }

    public Node<T> head;
    public int size;

    public doublyLinkedList() {
        this.head = null;
        this.size = 0;
    }

    @Override
    public Iterator<T> iterator() {
        return new listIterator(this);
    }

    @Override
    public String toString() {
        return null;
    }

}
