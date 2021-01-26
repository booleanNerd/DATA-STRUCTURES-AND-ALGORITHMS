/*
Problem No 9
	Flyod Cycle Finding Algorithm
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
	Node cycleStart = null;
	int noOfNode = 0;
	
	// insert
	public void insert(int data) {
		Node newNode = new Node();
		newNode.setData(data);
		newNode.setNext(null);
		
		/*if (newNode.getData() == 4) {
			cycleStart = newNode;
		}*/
		Node temp = this.head;
		if (this.head == null) {
			this.head = newNode;
		} else {
			for (; temp.getNext() != null; temp = temp.getNext());
			temp.setNext(newNode);
			/*if (newNode.getData() == 9) {
				newNode.setNext(cycleStart);
			}*/
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
	
	public void impFlyodCycleFF() {
		Node tortoise = this.head;
		Node hare = this.head;

		while((hare != null) && (hare.getNext() != null)) {
			tortoise = tortoise.getNext();
			hare = hare.getNext().getNext();
			if (hare == tortoise) {
				System.out.println("This linked list contains loop");
				return;
			}
		}
		System.out.println("No loops in the linked list");
	}
}

class ImpFlyodCycleFALLNine {
	public static void main(String[] args) {
		LinkedList l = new LinkedList();
		l.insert(1);
		l.insert(2);
		l.insert(3);
		l.insert(4);
		l.insert(5);
		l.insert(6);
		l.insert(7);
		l.insert(8);
		l.insert(9);
		l.impFlyodCycleFF();
	}
	
}