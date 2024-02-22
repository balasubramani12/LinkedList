package DoublyLinkedList;

import DoublyLinkedList.Node;

public class DoublyLinkedList {
	Node head;
	Node tail;
	int length;
	// Constructor
	public DoublyLinkedList(int val) {
		Node newNode = new Node(val);
		head = newNode;
		tail = newNode;
		length++;
	}
	// Print all elements of List
	public void printList() {
		Node temp = head;
		
		while(temp != null) {
			System.out.print(temp.val+ " -> ");
			temp = temp.next;
		}System.out.println("null");
	}
	// Add Node to last
	public void append(int val) {
		Node newNode = new Node(val),temp = head;
		tail.next = newNode;
		newNode.prev = tail;
		tail = newNode;
		length++;
	}
	
	// Remove Last Node
	
	public Node removeLast() {
		Node temp = tail;
		if(length == 0 || length == 1) {
			return null;
		}
		tail = tail.prev;
		tail.next = null;
		length--;
		return temp;
	}
	// Add Node at beginning of list;
	public void prepend(int val) {
		Node newNode = new Node(val);
		
		if(length == 0) {
			length++;
			head = newNode;
			tail = newNode;
		}
		
		newNode.next = head;
		head.prev = newNode;
		head = newNode;
		length++;
	}
	// Remove Node at beginning of the list;
	
	public Node removeFront() {
		Node temp = head;
		
		if(length == 0 || length==1) {
			head = null;
			tail=null;
			return null;
		}
		head = head.next;
		head.prev = null;
		length--;
		return temp;
	}
	
	
	// Get Method : To access element at certain index;
	public Node get(int index) {
		if(index < 0 || index >= length) {
			return null;
		}
		Node temp = head;
		for(int i = 0; i < index; i++) {
			temp = temp.next;
		}return temp;
	}
	
	public void set(int index, int val) {
		Node temp = get(index);
		if(length == 0) {
			System.out.println("No Node in List");
		}
		if(temp == null) {
			System.out.println("Invalid Index");
		}
		temp.val = val;
	}
	
	// Insert at particular position;
	
	public Node insert(int index, int val) {
		Node newNode = new Node(val);
		
		if(index == 0) {
			head.prev = newNode;
			newNode.next = head;
			head = newNode;
			
			
		}
		else {
			Node temp = get(index - 1);
			newNode.next = temp.next;
			temp.next = newNode;
			newNode.prev = temp;
			
		}
		length++;
		return newNode;
	}
	
	// Remove Method: to remove Node at particular index;
	
	public void remove(int index) {
		
		if(index == 0) {
			head = head.next;
			head.prev = null;
		}else {
			Node temp  = get(index -1);
			temp.next = temp.next.next;
			temp.next.prev = temp;
		}
		length--;
		
	}
	public Node getHead() {return head;}
	
	public Node getTail() {return tail;}
	
	public int getLength() {return length;}
}
