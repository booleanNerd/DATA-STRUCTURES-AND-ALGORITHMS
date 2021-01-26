/*
Problem No 15
	Insert into Sorted Linked List
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
	
	// insert into sorted linked list
	public void insertInSortedLL(int data) {
		Node newNode = new Node();
		newNode.setData(data);
		
		Node temp = this.head;
		Node previousNode = null;
		if (this.head != null) {
			if (newNode.getData() <= temp.getData()) {
				newNode.setNext(temp);
				this.head = newNode;
			} else {
				for (; ((temp.getData() < newNode.getData()) && (temp.getNext() != null)); temp = temp.getNext()) {
					previousNode = temp;
				}
				if (temp.getNext() == null) {
					temp.setNext(newNode);
					newNode.setNext(null);
					return;
				}
				previousNode.setNext(newNode);
				newNode.setNext(temp);
			}
		} else {
			newNode.setNext(null);
			this.head = newNode;
		}
		
	} 
	
	// printing the linked list
	public void print() {
		for (Node temp = this.head; temp != null; temp = temp.getNext()) {
			System.out.print(temp.getData() + "\n");
		}
	}
}

class ImpSortLLInsertFifteen {
	public static void main(String[] args) {
		LinkedList l = new LinkedList();
		l.insertInSortedLL(77);
		l.insertInSortedLL(44);
		l.insertInSortedLL(0);
		l.insertInSortedLL(1);
		l.insertInSortedLL(100);
		l.insertInSortedLL(-1);
		l.insertInSortedLL(-1);
		l.insertInSortedLL(-2);
		l.insertInSortedLL(101);
		l.print();
	}
	
}