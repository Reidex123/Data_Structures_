/**
 * Implementation of doubly linked list
 */

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
            return current.next != null;
        }

        @Override
        public T next() {
            T data;

            if (hasNext()) {
                data = current.data;
                current = current.next;

                return data;
            }

            return null;
        }
    }

    public Node<T> head;
    public int size;

    public doublyLinkedList() {
        this.head = null;
        this.size = 0;
    }

    public void add(T data) {
        if (isEmpty()) {
            this.head = new Node<>(data);
            this.size++;
            Runtime.getRuntime().exit(0);
        }

        Node<T> current = this.head;
        Node<T> node = new Node<>(data);

        while (current.next != null) {
            current = current.next;
        }

        current.next = node;
        node.prev = current;
        this.size++;
    }

    public void addFirst(T data) {
        if (isEmpty()) {
            this.head = new Node<>(data);
            this.size++;
            Runtime.getRuntime().exit(0);
        }

        Node<T> node = new Node<>(data);
        node.next = this.head;
        this.head.prev = node;
        this.head = node;
        this.size++;
    }

    public void addLast(T data) {
        this.add(data);
    }

    public void add(int index, T data) {
        if (index < 0 || index >= this.size) {
            System.out.println("Index out of bounds!!");
            Runtime.getRuntime().exit(0);
        }

        if (isEmpty() || index == 0) {
            this.addFirst(data);
            Runtime.getRuntime().exit(0);
        }

        if (index == this.size - 1) {
            this.addLast(data);
            Runtime.getRuntime().exit(0);
        }

        Node<T> node = new Node<>(data);
        Node<T> current = this.head;

        for (int i = 0; i <= index; i++) {
            current = current.next;
        }

        current.prev.next = node;
        node.prev = current.prev;
        node.next = current;
        current.prev = node;
    }

    public boolean isEmpty() {
        return this.size == 0;
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
