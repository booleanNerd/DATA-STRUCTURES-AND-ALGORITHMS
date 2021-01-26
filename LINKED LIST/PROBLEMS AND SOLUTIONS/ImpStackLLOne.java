/*
Problem No 1
*/
class Node {
	int data;
	Node previous;
	
	// getters
	public int getData() {
		return this.data;
	}
	public Node getPrevious() {
		return this.previous;
	}
	
	// setters
	public void setData(int data) {
		this.data = data;
	}
	public void setPrevious(Node previous) {
		this.previous = previous;
	}
}

class StackLinkedList {
	Node top = null;
	public void push(int data) {
		Node newTop = new Node();
		newTop.setData(data);
		if (this.top == null) {
			newTop.setPrevious(null);
			//this.top = newTop;
		} else {
			newTop.setPrevious(this.top);
			//this.top = newTop
		}
		this.top = newTop;
	}
	
	public void pop() {
		if (this.top == null) {
			return;
		} else {
			this.top = this.top.getPrevious();
		}
	}
	
	public void print() {
		Node temp = this.top;
		for(; temp != null; temp = temp.getPrevious()) {
			System.out.println(temp.getData());
		}
	}
	
}
class ImpStackLLOne {
	public static void main(String[] args) {
		StackLinkedList sll = new StackLinkedList();
		sll.push(5);
		sll.push(4);
		sll.push(3);
		sll.push(2);
		sll.push(1);
		sll.pop();
		sll.pop();
		sll.pop();
		sll.pop();
		sll.pop();
		sll.pop();
		sll.pop();
		sll.pop();
		sll.push(11);
		sll.print();
	}
}










