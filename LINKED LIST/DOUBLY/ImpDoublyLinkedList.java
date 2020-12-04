/* 
	INSERTION
		HINT:
			1. We cannot insert at the last position by insertAtGivenPosition
			2. In the insertAtGivenPosition method stop by (  position - 1 )
			3. If you are insert a node at the tail using insertAtGivenPosition, if condition is needed
			4. We can insert the node by insertAtGivenPosition method in the [ last or tail ]
	DELETION
		HINT:
			1. 
*/

// Node class
class Node {
	int data;
	Node previous;
	Node next;
	
	// setters
	public void setData(int data) {
		this.data = data;
	}
	public void setPrevious(Node previous) {
		this.previous = previous;
	}
	public void setNext(Node next) {
		this.next = next;
	}
	
	// getters
	public int getData() {
		return this.data;
	}
	public Node getPrevious() {
		return this.previous;
	}
	public Node getNext() {
		return this.next;
	}
}

// Doubly Linked List class
class DoublyLinkedList {
	Node head = null; // head node
	
	// insert into head
	public void insertIntoHead(int data) {
		Node temp = this.head;
		Node newNode = new Node();
		newNode.setData(data);
		
		if (temp == null) {
			newNode.setNext(null);
		} else {
			newNode.setNext(this.head);
		}
		newNode.setPrevious(null);
		this.head = newNode;
	}
	
	// insert in to the tail
	public void insert(int data) {
		Node temp = this.head;
		Node newNode = new Node();
		if (temp == null) {
			insertIntoHead(data);
		} else {
			for(; temp.getNext() != null; temp = temp.getNext());
			newNode.setData(data);
			newNode.setNext(null);
			newNode.setPrevious(temp);
			temp.setNext(newNode);
		}
	}
	
	// insert into the given position
	public void insertAtGivenPosition(int data, int position) {
		Node temp = this.head;
		Node newNode = new Node();
		int i = 1;
		// position = 1 or less
		if (position <= 1) {
			insertIntoHead(data);
		} else {
			for (; ((i < position-1) && (temp.getNext() != null)); temp = temp.getNext(), i++);
			
			if (temp == null || i < position-1) {
				return;
			} else {
				newNode.setData(data);
				newNode.setNext(temp.getNext());
				newNode.setPrevious(temp);
				temp.setNext(newNode);
				if (newNode.getNext() != null) { // for tail next pointer is null
					newNode.getNext().setPrevious(newNode);
				}
			}
		}
	}
	
	/*
		Deletion Part
	*/
	
	// delete head
	public void deleteHead() {
		this.head = this.head.getNext();
		this.head.setPrevious(null);
	}
	
	// delete tail 
	public void delete() {
		Node temp = this.head;
		for (; temp.getNext() != null; temp = temp.getNext());
		temp.getPrevious().setNext(null);
	}
	
	// delete at the given position
	public void deleteAtTheGivenPosition(int position) {
		Node temp = this.head;
		if (position <= 1) {
			deleteHead();
		} else {
			int kPosition = 1;
			for (; ((kPosition < position-1) && (temp.getNext() != null)); temp = temp.getNext(), kPosition++);
			if (kPosition < position-1) {
				return;
			} else {
				temp.setNext(temp.getNext().getNext());
				if (temp.getNext() != null) // be carefull here
					temp.getNext().setPrevious(temp);
			}
		}
	}
	// print the doubly linked list
	public void print() {
		Node temp = this.head;
		for (; temp != null; temp = temp.getNext()) {
			//System.out.println(temp.getData());
			System.out.print(temp.getData() + "<=>");
		}
		System.out.println("null");
	}
}

class ImpDoublyLinkedList {
	public static void main(String[] args) {
		DoublyLinkedList d = new DoublyLinkedList();
		d.insertIntoHead(5);
		d.insertIntoHead(4);
		d.insertIntoHead(3);
		d.insertIntoHead(2);
		d.insertIntoHead(1);
		d.insert(1);
		d.insertIntoHead(4);
		d.insert(2);
		d.insertAtGivenPosition(3, 1);
		d.insertAtGivenPosition(66, 2);
		d.insertAtGivenPosition(77, 6);
		d.deleteHead();
		d.delete();
		d.deleteAtTheGivenPosition(1);
		d.deleteAtTheGivenPosition(3);
		d.insert(77);
		d.deleteAtTheGivenPosition(2);
		d.print();
	}
}