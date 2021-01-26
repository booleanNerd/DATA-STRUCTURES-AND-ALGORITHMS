/*
Problem No 2
	print the nth node from the end of the linked list
	
	FORMULA:
		(Number of Nodes - n) + 1
*/

class Node {
	int data;
	Node next;
	
	public void setData(int data) {
		this.data = data;
	}
	public void setNext(Node next) {
		this.next = next;
	}
	public int getData() {
		return this.data;
	}
	public Node getNext() {
		return this.next;
	}
}

class LinkedList {
	Node head = null;
	int noOfNode = 0;
	
	// insert
	public void insert(int data) {
		Node newNode = new Node();
		newNode.setData(data);
		newNode.setNext(null);
		Node temp = this.head;
		if (this.head == null) {
			this.head = newNode;
		} else {
			for (; temp.getNext() != null; temp = temp.getNext());
			temp.setNext(newNode);
		}
		this.noOfNode++;
	}
	
	
	// printing the linked list
	public void print(int position) {
		
		int exactPosition = (this.noOfNode - position) + 1;
		Node temp = this.head;
		int currentPosition = 1;
		
		if (exactPosition < 1) {
			System.out.print("Required Positon doesn't exist");
		} else {
			for (; currentPosition < exactPosition; temp = temp.getNext(), currentPosition++);
			System.out.print(temp.getData());
		}
	}
}

class ImpLinkedListTwo {
	public static void main(String[] args) {
		LinkedList l = new LinkedList();
		l.insert(5);
		l.insert(4);
		l.insert(3);
		l.insert(2);
		l.insert(1);
		l.print(5);
	}
	
}