package singlyLinkedList;

/**
 *Implementation of a singly LinkedList
 *
 * @author Koketso Gaowelwe
 * @version 13/02/2026
 */

public class LinkedList<T> implements Iterable<T>{

	public Node head;
	public int size;

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

			if (hasNext()){
				data = (current.next).data;
			}
			else{
				Runtime.getRunTime().exit(0);
			}

			return data;
		}
	}

	public LinkedList(){
		this.head = null;
		this.size = 0;
	}

	public listIterator iterator(){
		return new listIterator(this);
	}

	public void add(T data){

		if (data == null){
			NullArgumentException();
			return;
		}

		if (isEmpty()){
			this.head = new Node<T>(data);
			(this.size)++;
			return;
		}

		Node<T> current = this.head;
		while (current.next != null){
			current = current.next;
		}

		current.next = new Node<T>(data);
		(this.size)++;
	}

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

		Node<T> nodeToAdd = new Node<T>(data);
		Node<T> current = this.head;

		for (int i = 0; i < index-1; i++){
			current = current.next;
		}

		nodeToAdd.next = current.next;
		current.next = nodeToAdd;

		(this.size)++;

	}

	public void addFirst(T data){

		if (data == null){
			NullArgumentException();
			return;
		}

		if (isEmpty()){
			this.head = new Node<T>(data);
			(this.size)++;
			return;
		}

		Node<T> nodeToAdd = new Node<T>(data);
		nodeToAdd.next = this.head;
		this.head = nodeToAdd;

		(this.size)++;
	}

	public void addLast(T data){

		if (data == null){
			NullArgumentException();
			return;
		}

		this.add(data);
	}

	public T element(){

		if(isEmpty()){
			return System.out.println("Empty List!!");
		}

		return this.head.data;
	}

	public T get(int index){
		
		if (index < 0 || index >= this.getSize()){
			return	IndexOutOfBounds();
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

		current = current.next;

		return current.data;

	}

	public T getFirst(){
		return this.element();
	}

	public T getLast(){
		Node<T> current = this.head;

		while (current.next != null){
			current = current.next;
		}

		return current.data;
	}

	public T peek(){
		return this.getFirst();
	}

	public T peekFirst(){
		return this.getFirst();
	}

	public T peekLast(){
		return this.getLast();
	}

	public boolean offer(T data){
		this.addLast(data);
		return true;
	}

	public boolean offerFirst(T data){
		this.addFirst(data);
		return true;
	}

	public boolean offerLast(T data){
		this.addLast(data);
		return true;
	}

	public int getSize(){
		return this.size;
	}

	public boolean isEmpty(){
		return this.size != 0;
	}
	
	private void NullArgumentException(){
		System.out.println("Add non-null argument..!!!!")
	}

	private void IndexOutOfBounds(){
		System.out.println("Invalid index.!!!");
	}

	@Override
	public void toString(){
		Node<T> current = this.head;

		while (current.next != null){
			System.out.print(current.data + " ");
		}
	}
}
