/**
 * Implementation of doubly linked list
 * @version 02/03/2026
 */

package com.Linked_Lists.doublyLinkedList;

import java.util.Iterator;

public class doublyLinkedList<T> implements Iterable<T> {

    @SuppressWarnings("hiding")
    /**
     * Node class
     */
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

        /**
         * Check if the list has next element
         */
        @Override
        public boolean hasNext() {
            return current.next != null;
        }

        /**
         * Access the next element in the list by printing out the current and move the pointer ahead
         */
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

    /**
     * Add the specified element to the end of the list
     * @param data - element to be inserted
     */
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

    /**
     * Add the specified element to the start of this list
     * @param data - element to be inserted
     */
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

    /**
     * Add the specified element at the end of this list
     * @param data - element to be inserted at the end of the list
     */
    public void addLast(T data) {
        this.add(data);
    }

    /**
     * Add the specified element to the specified index in the list
     * @param index - position to insert the element
     * @param data - element to be inserted
     */
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

    /**
     * Check if the list is empty
     */
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public Iterator<T> iterator() {
        return new listIterator(this);
    }

    /**
     * String representation of this list
     */
    @Override
    public String toString() {
        return null;
    }

}
