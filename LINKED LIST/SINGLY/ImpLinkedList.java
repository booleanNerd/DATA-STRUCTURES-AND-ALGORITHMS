/*
	Note:
		1. stop the for loop by (--position != 1) && (temp.getNext() != null)
		2. don't use (--position != 1) for deleteAtTheGivenPosition method
		3. didn't use previousNode for insertAtGivenPosition method
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
	
	public void insertIntoHead(int data) {
		//Node temp = new Node();
		Node newNode = new Node();
		if (this.head == null) {
			newNode.setData(data);
			newNode.setNext(null);
			//this.head = newNode;
		} else {
			newNode.setData(data);
			newNode.setNext(this.head);
			//this.head = newNode;
		}
		this.head = newNode;
	}
	
	public void insertIntoLast(int data) {
		Node newNode = new Node();
		newNode.setData(data);
		Node temp = this.head;
		if (this.head == null) {
			//System.out.println("if");
			newNode.setNext(null);
			this.head = newNode;
		} else {
			//System.out.println("else");
			for (; temp.getNext() != null; temp = temp.getNext());
			temp.setNext(newNode);
			newNode.setNext(null);
		}
	}
	
	public void insertAtGivenPosition(int data, int position) {
		Node temp = this.head;
		Node newNode = new Node();
		newNode.setData(data);
		if (position <= 1) {
			newNode.setNext(this.head);
			head = newNode;
		} else {
			// check for loop in made easy book
			for (; ((--position != 1) &&(temp.getNext() != null)); temp = temp.getNext());
			//System.out.println(temp.getData());
			if ((temp == null) || (position != 1)) { // check if statement in made easy book
				return;
			}
			//System.out.println(temp.getData());
			newNode.setNext(temp.getNext());
			temp.setNext(newNode);
		}
	}
	
	/*
		Deletion 
	*/
	
	// delete in the head
	public void deleteHead() {
		this.head = this.head.getNext();
		
	}
	
	// delete in the tail
	public void delete() {
		Node temp = this.head;
		Node previousNode = null;
		for (; temp.getNext() != null; temp = temp.getNext()) {
			previousNode = temp;
		}
		previousNode.setNext(null);
	}
	
	// delete the node at the given position
	public void deleteAtTheGivenPosition(int position) {
		if (position <= 1) {
			this.head = this.head.getNext();
		} else {
			Node temp = this.head;
			int i = 1;
			for (; ((i < position - 1) && temp.getNext() != null); i++, temp = temp.getNext());
			
			if ((temp == null) || (i < position - 1)) {
				return;
			} else {
				temp.setNext(temp.getNext().getNext());
			}
		}
	}
	// printing the linked list
	public void print() {
		for (Node temp = this.head; temp != null; temp = temp.getNext()) {
			System.out.print(temp.getData() + "\n");
		}
	}
}

class ImpLinkedList {
	public static void main(String[] args) {
		LinkedList l = new LinkedList();
		l.insertIntoHead(5);
		l.insertIntoLast(4);
		l.insertIntoHead(3);
		l.insertAtGivenPosition(12, 1);
		l.insertAtGivenPosition(122, 4);
		l.insertIntoLast(2);
		l.insertIntoHead(1);
		l.deleteHead();
		l.delete();
		l.deleteAtTheGivenPosition(1);
		l.deleteAtTheGivenPosition(3);
		l.deleteAtTheGivenPosition(3);
		System.out.println("#################");
		l.print();
	}
	
}