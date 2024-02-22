package LinkedList;

public class LinkedList {
	private Node head;
	private Node tail;
	int length;

	// Constructor
	public LinkedList(int val) {
		Node newNode = new Node(val);
		head = newNode;
		tail = newNode;
		length++;
	}

	public void getHead() {
		System.out.println("Head: " + head.val);
	}

	public void getTail() {
		System.out.println("Tail: " + tail.val);
	}

	public void getLength() {
		System.out.println("Length: " + length);
	}

	// Print list
	public void printlist() {
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.val + " -> ");
			temp = temp.next;
		}
		System.out.println("null");
	}

	/// Append Last ///

	public void append(int val) {
		Node newNode = new Node(val);
		if (length == 0) {
			head = newNode;
			tail = newNode;

		} else {
			tail.next = newNode;
			tail = newNode;

			/// Tym Comp: O(n) ///

			/*
			 * Node temp = head; while(temp.next != null) { temp = temp.next; } temp.next =
			 * newNode; newNode.next = null;
			 */

		}
		length++;
	}

	/// Remove Last ///

	public Node removeLast() {
		if (length == 1) {
			head = null;
			tail = null;
			return head;
		} else {
			Node temp = head;
			while (temp.next.next != null) {
				temp = temp.next;
			}
			tail = temp;
			tail.next = null;
		}
		length--;
		return null;
	}

	// Prepend //
	public void prepend(int val) {
		Node newNode = new Node(val);

		if (length == 0) {
			head = newNode;
			tail = newNode;
		} else {
			newNode.next = head;
			head = newNode;
		}
		length++;
	}

	// Remove First

	public Node removeFirst() {
		if (length == 1) {
			head = null;
			tail = null;
		}

		else {
			head = head.next;

		}
		length--;
		return null;
	}

	// Get Method to access the ith index element

	public Node get(int index) {
		if (index < 0 || index >= length)
			return null;
		else {
			Node temp = head;
			for (int i = 0; i < index; i++) {
				temp = temp.next;
			}
			return temp;
		}
	}

	// Set Method to set new value the ith index of Node

	public boolean set(int index, int val) {
		Node temp = get(index);
		if (temp != null) {
			temp.val = val;
		}
		return false;
	}

	public void insert(int index, int value) {
		Node newNode = new Node(value);

		
		if (index == 0) {
			prepend(value);

		}

		else {
			Node temp = get(index - 1);
			if (temp != null) {
				newNode.next = temp.next;
				temp.next = newNode;
				length++;
			}
		}
	}
	// Removing the particular element
	public Node remove(int index) {
		Node temp = get(index - 1);
		Node discard ;
		if(index == 0) {
			discard = head;
			head = head.next;
			return discard;
		}
		temp.next = temp.next.next;
		length--;
		return null;
	}
	
	// Reversing LinkedList 
	
	public void reverse() {
		Node temp = head;
		head = tail;
		tail = temp;
		
		Node before = null,after = temp.next;
		
		for(int i = 0; i < length; i++ ) {
			after = temp.next;
			temp.next = before;
			before = temp;
			temp  = after;
		}
		 
	}
	
	// Find Kth node from last;
	
	public Node findFromLast(int k) {
		Node temp = head;
		if(length == 1) {
			return head;
		}
		if(k < 0 || k > length) {
			return null;
		}
		temp = get(length-k);
		return temp;
	} 
	
	public Node findKthFromEnd(int k) {
		
        Node slow = head;
        Node fast = head;
 
        for (int i = 0; i < k; i++) {
            if (fast == null) {
                return null;
            }
            fast = fast.next;
        }
 
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
 
        return slow;
    }

	
	
	

}
