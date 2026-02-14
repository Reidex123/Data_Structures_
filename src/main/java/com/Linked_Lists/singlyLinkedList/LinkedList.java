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
	public void addLast(T data){

		if (data == null){
			NullArgumentException();
			return;
		}

		this.add(data);
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
	public boolean offerLast(T data){
		this.addLast(data);
		return true;
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
