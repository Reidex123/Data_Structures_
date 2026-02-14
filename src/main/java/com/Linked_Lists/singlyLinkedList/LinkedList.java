package com.Linked_Lists.singlyLinkedList;
import java.util.Iterator;

/**
 *Implementation of a singly LinkedList
 *
 * @author Koketso Gaowelwe
 * @version 13/02/2026
 */

public class LinkedList<T> implements Iterable<T>{

	public Node<T> head;
	public int size;

	@SuppressWarnings("hiding")
	public class Node<T>{
		public T data;
		public Node<T> next;

		public Node(T data){
			this.data = data;
			this.next = null;
		}
	}

	private class listIterator implements Iterator<T>{
		public Node<T> current;

		public listIterator(LinkedList<T> list){
			this.current = list.head;
		}

		@Override
		public boolean hasNext(){
			return current.next != null;
		}

		@Override
		public T next(){
			T data;

			if (hasNext()) {
				data = (current.next).data;
			}
			else {
				return null;
			}

			return data;
		}
	}

	public LinkedList(){
		this.head = null;
		this.size = 0;
	}

	@Override
	public Iterator<T> iterator(){
		return new listIterator(this);
	}

	/**
	 * Adds the specified element to the end of the list
	 * @param data - element to add
	 */
	public void add(T data){

		if (data == null){
			NullArgumentException();
			return;
		}

		if (isEmpty()){
			this.head = new Node<>(data);
			(this.size)++;
			return;
		}

		Node<T> current = this.head;
		while (current.next != null){
			current = current.next;
		}

		current.next = new Node<>(data);
		(this.size)++;
	}

	/**
	 * Adds the specified element at a specified index in the list
	 * @param index - position in the list
	 * @param data - element to add
	 */
	public void add(int index, T data){

		if (index > this.size || index < 0){
			IndexOutOfBounds();
			return;
		}

		if (index == 0){
			this.addFirst(data);
			return;
		}

		if (index == this.getSize() - 1){
			addLast(data);
			return;
		}

		Node<T> nodeToAdd = new Node<>(data);
		Node<T> current = this.head;

		for (int i = 0; i < index-1; i++){
			current = current.next;
		}

		nodeToAdd.next = current.next;
		current.next = nodeToAdd;

		(this.size)++;

	}

	/**
	 * Inserts the specified element at the start of the list(a.k.a THE HEARD)
	 * @param data - the element to add
	 */
	public void addFirst(T data){

		if (data == null){
			NullArgumentException();
			return;
		}

		if (isEmpty()){
			this.head = new Node<>(data);
			(this.size)++;
			return;
		}

		Node<T> nodeToAdd = new Node<>(data);
		nodeToAdd.next = this.head;
		this.head = nodeToAdd;

		(this.size)++;
	}

	/**
	 * Add the specified element at the end of the list
	 * @param data - element to add
	 */
	public void addLast(T data) {

		if (data == null) {
			NullArgumentException();
			return;
		}

		this.add(data);
	}

	/**
	 * Replaces the element in the specified index with the element specified
	 * @param index - position where to replace
	 * @param data - new element in this position
	 */
	public void set(int index, T data) {

		if (index < 0 || index > this.getSize()) {
			this.IndexOutOfBounds();
			System.exit(0);
		}

		if (index == 0) {
			(this.head).data = data;
			System.exit(0);
		}

		if (isEmpty() && index > 0) {
			System.out.println("The list is empty. Operation cannot be executed!!");
			System.exit(0);
		}

		Node<T> current = this.head;

		for (int i = 0; i < index; i++) {
			current = current.next;
		}

		current.data = data;
	}

	/**
	 * Returns, but does not remove the heard of this list
	 */
	public T element(){
		return this.head.data;
	}

	/**
	 * Returns the element in this list at a specified index
	 * @param index - position in the list
	 */
	public T get(int index){

		if (index < 0 || index >= this.getSize()){
			return	null;
		}

		if (index == 0){
			return this.element();
		}

		if (index == this.getSize()-1){
			return this.getLast();
		}

		Node<T> current = this.head;
		int pointer = 0;

		while (pointer != index){
			current = current.next;

			pointer++;
		}

		return current.data;

	}

	/**
    * Returns the first element of this list
    */
	public T getFirst(){
		return this.element();
	}

	/**
	 * Returns the last element of this list
	 */
	public T getLast() {
		Node<T> current = this.head;

		while (current.next != null) {
			current = current.next;
		}

		return current.data;
	}

	/**
	 * Pushes the specified element into the stack represented by the list
	 * @param data - element to push
	 */
	public void push(T data) {
		this.addLast(data);
	}

	/**
	 * Returns but does not remove the heard of this list
	 */
	public T peek(){
		return this.getFirst();
	}

	/**
	 * Returns but does not remove the first element of this list
	 */
	public T peekFirst(){
		return this.getFirst();
	}

	/**
	 * Returns but does not remove the last element of this list
	 */
	public T peekLast(){
		return this.getLast();
	}

	/**
	 * Adds the specified element as the tail in this list
	 * @param data - the element to add
	 */
	public boolean offer(T data){
		this.addLast(data);
		return true;
	}

	/**
	 * Adds the specified element at the front of this list
	 * @param data - the element to add
	 */
	public boolean offerFirst(T data){
		this.addFirst(data);
		return true;
	}

	/**
	 * Adds the specified element at the end of this list
	 * @param data - element to add
	 */
	public boolean offerLast(T data) {
		this.addLast(data);
		return true;
	}

	/**
	 * Checks if the specified element is in the list
	 * @param data - element to check
	 */
	public boolean contains(T data) {

		if (!this.isEmpty() && data != null) {
			Node<T> current = this.head;

			while (current.next != null) {
				if (current.data == data) {
					return true;
				}
				current = current.next;
			}
		}

		return false;
	}

	/**
	 * Removes and returns the heard of the list
	 */
	public T poll() {
		return this.pollFirst();
	}

	/**
	 * Removes and returns the first element of this list
	 */
	public T pollFirst() {
		if (this.getSize() == 1) {
			T data = this.getFirst();
			this.head = null;
			(this.size)--;
			return data;
		}

		Node<T> nodeToRemove = this.head;
		this.head.next = this.head;

		(this.size)--;

		return nodeToRemove.data;
	}

	/**
	 * Removes and returns the last element of this list
	 */
	public T pollLast() {
		if (this.getSize() == 1) {
			return this.pollFirst();
		}

		Node<T> current = this.head;
		int pointer = 0;

		while (pointer != this.getSize() - 1) {
			current = current.next;
			pointer++;
		}

		T data = (current.next).data;
		current.next = null;

		(this.size)--;

		return data;
	}

	/**
	 * Pop an element from the stack represented by this list
	 */
	public T pop() {
		return this.pollLast();
	}

	/**
	 * Returns the index of the first occurance of the specified element in the list
	 * @param data - element of which we need the index of
	 */
	public int indexOf(T data) {
		if (data == null) {
			return -1;
		}

		int index = 0;
		Node<T> current = this.head;

		while (current.next != null) {
			if (current.data == data) {
				return index;
			}

			current = current.next;
			index++;
		}

		return -1;
	}

	/**
	 * Returns and remove the heard of the list
	 */
	public T remove() {
		return this.pollFirst();
	}

	/**
	 * Returns and removes an element from this list at a specified index
	 * @param index - position of the element to remove
	 */
	public T remove(int index) {
		if (index < 0 || index > this.getSize()) {
			this.IndexOutOfBounds();
			return null;
		}

		if (index == 0) {
			return pollFirst();
		}

		if (index == this.getSize() - 1) {
			return pollLast();
		}

		Node<T> nodeToDelete;
		Node<T> current = this.head;

		for (int i = 0; i < index; i++) {
			current = current.next;
		}

		nodeToDelete = current.next;
		T data = nodeToDelete.data;
		current.next = nodeToDelete.next;

		(this.size)--;

		return data;
	}

	/**
	 * Removes the first occurance of the element from the list
	 * @param data - element to remove
	 */
	public boolean remove(T data) {
		if (data != null) {
			int index = this.indexOf(data);
			T removedElement = index >= 0 ? this.remove(index) : null;

			(this.size)--;
			return removedElement != null;
		}

		return false;
	}

	/**
	 * Removes and return the first element of this list
	 */
	public T removeFirst() {
		return this.remove();
	}

	/**
	 * Removes and return the last element of this list
	 */
	public T removeLast() {
		return this.pollLast();
	}

	/**
	 * Returns the size of this list
	 */
	public int getSize(){
		return this.size;
	}

	/**
	 * Checks if the list is empty or not
	 */
	public boolean isEmpty(){
		return this.size == 0;
	}

	private void NullArgumentException(){
		System.out.println("Add non-null argument..!!!!");
	}

	private void IndexOutOfBounds(){
		System.out.println("Invalid index.!!!");
	}

	/**
	 * Returns the string representation of this list
	 */
	@Override
	public String toString(){
		Node<T> current = this.head;

		StringBuilder string = new StringBuilder();

		for (int i = 0; i < this.getSize() - 1; i++) {
			string.append(current.data).append("-> ");
			current = current.next;
		}

		string.append(current.data);

		return string.toString();

	}
}
