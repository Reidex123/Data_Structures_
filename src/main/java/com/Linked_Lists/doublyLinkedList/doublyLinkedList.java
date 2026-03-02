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
     * Remove the first element in the list
     */
    public void removeFirst(){
        if (isEmpty()){
            System.out.println("The list is empty, operation cannot be performed.!!");
            Runtime.getRuntime().exit(0);
        }

        Node<T> nodeToDelete = this.head;
        this.head = nodeToDelete.next;

        this.head.prev = null;
        nodeToDelete.next = null;

        this.size--;

    }

    /**
     * Remove the last element in this list
     */
    public void removeLast(){
        if (isEmpty()){
            System.out.println("The list is empty, operation cannot be performed.!!");
            Runtime.getRuntime().exit(0);
        }

        Node<T> nodeToDelete = null;
        Node<T> current = this.head;
        while(current.next != null){
            current = current.next;
        }

        nodeToDelete = current;
        current.prev.next = null;
        nodeToDelete.prev = null;

        this.size--;
    }

    /**
     * Remove the element at a specified position
     * @param index - position of the element to be removed
     */
    public void remove(int index){
        if (isEmpty()){
            System.out.println("This list is empty, operstion cannot be performed.!!");
            Runtime.getRuntime().exit(0);
        }

        if (index < 0 || index > this.size){
            System.out.println("Invalid index!!!");
            Runtime.getRuntime().exit(0);
        }

        if (index == 0){
            this.removeFirst();
            Runtime.getRuntime().exit(0);
        }

        if (index == this.size-1){
            this.removeLast();
            Runtime.getRuntime().exit(0);
        }

        Node<T> current = this.head;
        Node<T> nodeToDelete = null;
        for (int i = 0; i < index-1; i++){
            current = current.next;
        }

        nodeToDelete = current.next;
        current.next = nodeToDelete.next;
        nodeToDelete.next.prev = current;
        nodeToDelete.prev = null;

        this.size--;
    }

    /**
     * Get the first element of this list
     */
    public T getFirst(){
        return this.isEmpty() ? null: this.head.data;
    }

    /**
     * Get the last element of this list
     */
    public T getLast(){
        if (isEmpty()){
            return null;
        }

        Node<T> current = this.head;
        while(current.next != null){
            current = current.next;
        }

        return current.data;
    }

    /**
     * Get the element at a specified index
     * @param index - position of the element to get
     */
    public T get(int index){
        if (isEmpty()){
            return null;
        }

        if (index < 0 || index > this.size){
            System.out.println("Invalid index!!");
            return null;
        }

        if (index == 0){
            return this.getFirst();
        }
        if (index == this.size-1){
            return this.getLast();
        }

        Node<T> current = this.head;
        for (int i = 0; i <= index; i++){
            current = current.next;
        }

        return current.data;

    }

    /**
     * get but does not remove the first element of this list
     */
    public T element(){
        return this.getFirst();
    }

    /**
     * Add the specified element at the tail
     * @param data - element to add
     */
    public void offer(T data){
        this.addLast(data);
    }

    /**
     * insert the specified element to the start of the list
     * @param data - element to be inserted
     */
    public void offerFirst(T data){
        this.addFirst(data);
    }

    /**
     * insert the specified element to the end of the list
     * @param data - element to be inserted
     */
    public void offerLast(T data){
        this.offer(data);
    }

    /**
     * Return the index of the specified element, else return -1
     * @param data - element we want to find its index
     */
    public int indexOf(T data){
        if (!this.contains(data)){
            return -1;
        }

        Node<T> current = this.head;
        int index = 0;

        while(current.next != null){
            if (current.data == data){
                return index;
            }

            current = current.next;
            index++;
        }
    }

    /**
     * Check if the specified element is contained in this list
     * @param data - element to search if it exists in the list
     */
    public boolean contains(T data){
        if (isEmpty()){
            return false;
        }

        Node<T> current = this.head;

        while(current.next != null){
            if (current.data == data){
                return true;
            }

            current = current.next;
        }

        return false;
    }

    /**
     * Check if the list is empty
     */
    public boolean isEmpty() {
        return this.size == 0;
    }

    /**
     * Obtain the size of this list
     */
    public int getSize(){
        return this.size;
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
        StringBuffer list = new StringBuffer();
        Node<T> current = this.head;
        
        list.append("[ ");

        for (int i = 0; i < this.size-1; i++){
            list.append(current.data + " ").append("->");
            current = current.next;
        }

        list.append(current.data + " ").append("]");

        return list.toString();
    }

}
