/*
	Note:
	
	Insert
		
		
	Delete
		1. carefull while deleting the only one node 
		2. Always look for the head is null or not
		
	Print
		1. Always look for the head is null or not
*/
class Node {
	int data;
	Node next;
	
	// getters
	public int getData() {
		return this.data;
	}
	public Node getNext() {
		return this.next;
	}
	
	// setters
	public void setData(int data) {
		this.data = data;
	}
	public void setNext(Node next) {
		this.next = next;
	}
}

class CircularLinkedList {
	Node head = null;
	
	// insert into head
	public void insertIntoHead(int data) {
		Node newNode = new Node();
		newNode.setData(data);
		if (this.head == null) {
			this.head = newNode;
			newNode.setNext(this.head);
		} else {
			Node temp = this.head;
			newNode.setNext(this.head);
			for (; temp.getNext() != this.head; temp = temp.getNext());
			temp.setNext(newNode);
			this.head = newNode;
		}
	}
	
	// inser at the given position
	public void insertAtGivenPosition(int data, int position) {
		if (position <= 1) {
			insertIntoHead(data);
		} else {
			Node newNode = new Node();
			newNode.setData(data);
			Node temp = this.head;
			int k = 1;
			for (; ((k < (position-1)) && (temp.getNext() != this.head)); temp = temp.getNext(), k++);
			if (k < (position-1)) {
				return;
			} else {
				newNode.setNext(temp.getNext());
				temp.setNext(newNode);
			}
		}
	}
	
	// insert into tail
	public void insert(int data) {
		if (this.head == null) {
			insertIntoHead(data);
		} else {
			Node temp = this.head;
			Node newNode = new Node();
			newNode.setData(data);
			for (; temp.getNext() != this.head; temp = temp.getNext());
			newNode.setNext(temp.getNext());
			temp.setNext(newNode);
		}
	}
	
	/*
		Delete
	*/
	
	// delete the head node
	public void deleteHead() {
		if (this.head == null) { // for empty circular list
			return;
		}
			
		if (this.head.getNext() == this.head) {
			this.head = null;
			return;
		} else {
			Node temp = this.head;
			for (; temp.getNext() != this.head; temp = temp.getNext());
			this.head = this.head.getNext();
			temp.setNext(this.head);
		}		
	}
	
	// delete th node at the given position
	public void deteteAtGivenPosition(int position) {
		if (position <= 1) {
			deleteHead();
		} else {
			int k = 1;
			Node temp = this.head;
			for (; ((k < (position-1)) && (temp.getNext() != this.head)); k++, temp = temp.getNext());
			if (k < (position-1)) {
				return;
			} else {
				temp.setNext(temp.getNext().getNext());
			}
			
		}
	}
	
	// delete the tail node
	public void deleteTail() {
		if (this.head == null) {
			return;
		}
		Node temp = this.head;
		Node pred = null;
		for (; temp.getNext() != this.head; temp = temp.getNext()) {
			pred = temp;
		}
		pred.setNext(temp.getNext());
	}
	
	// print the Circular Linked List
	public void print() {
		if (this.head == null) { // important
			return;
		}
		Node temp = this.head.getNext();
		if (temp == this.head) {
			System.out.println(temp.getData());
		} else {
			for (; temp != this.head; temp = temp.getNext()) {
				System.out.print(temp.getData() + "->");
			}
			System.out.print(temp.getData()); // this is for head node data
		}
		
	}
}

class ImpCircularLinkedList {
	public static void main(String args[]) {
		CircularLinkedList c = new CircularLinkedList();
		//c.insertIntoHead(10);
		//c.insertIntoHead(9);
		//c.insertIntoHead(8);
		c.insert(7);
		//c.insertIntoHead(1);
		c.insert(6);
		c.insertIntoHead(1);
		c.insertAtGivenPosition(11, 5);
		//c.deleteHead();
		//c.deleteTail();
		//c.deteteAtGivenPosition(1);
		c.deteteAtGivenPosition(5);
		c.print();
	}
}
















