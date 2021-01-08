/*
	1. All the block except the last one have (ceil(sqrt(n))) elements. 
	2. Find the block ceil(k / (ceil(sqrt(n))))
	3. Find the element (k mod ceil(sqrt(n)))
	4. There will be no more than floor(sqrt(n)) blocks
*/
class Node {
	// attributes
	int data;
	Node next;
	
	// methods
	
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

class UnrollLinkedListBlock {
	Node blockHead = null;
	Node blockTail = null;
	int numberOfNodes = 0;
	UnrollLinkedListBlock nextBlock = null;
	UnrollLinkedListBlock thisBlock = null;
	
	boolean full = false;
	int noOfElements = 0;
	
	// getters
	public Node getBlockHead() {
		return this.blockHead;
	}
	public Node getBlockTail() {
		return this.blockTail;
	}
	public UnrollLinkedListBlock getNextBlock() {
		return this.nextBlock;
	}
	public UnrollLinkedListBlock getThisBlock() {
		return this.thisBlock;
	}
	public int getNoOfNodes() {
		return this.numberOfNodes;
	}
	
	// setters
	public void setBlockHead(Node blockHead) {
		this.blockHead = blockHead;
	}
	public void setBlockTail(Node blockTail) {
		this.blockTail = blockTail;
	}
	public void setNextBlock(UnrollLinkedListBlock nextBlock) {
		this.nextBlock = nextBlock;
	}
	public void setThisBlock(UnrollLinkedListBlock thisBlock) {
		this.thisBlock = thisBlock;
	}
	
	// incrementor and decrementor
	public void increaseNoOfNodes() {
		this.numberOfNodes++;
	}
	public void decreaseNoOfNodes() {
		this.numberOfNodes--;
	}
	
}

class UnrollLinkedList {
	Node head = null;
	
	UnrollLinkedListBlock uHead = null;
	
	int numberOfElements;
	int currentNoOfElements = 0;
	int noOfBlocks = 0; // number of blocks can be created
	int createdBlockNumber = 0; // number of blocks created
	
	
	// For default number of elements
	UnrollLinkedList() {
		this.numberOfElements = 4;
		noOfBlocksToBeCreated();
		//System.out.println(this.noOfBlocks);
	}
	
	// For user defined number of elements
	UnrollLinkedList(int numberOfElements) {
		this.numberOfElements = numberOfElements;
		noOfBlocksToBeCreated();
		//System.out.println(this.noOfBlocks);
		//System.out.println(acceptedNoOfNodes());
	}
	
	// number of blocks to be created
	public void noOfBlocksToBeCreated() {
		this.noOfBlocks = (int)Math.floor((int)Math.sqrt(this.numberOfElements));
	}
	
	// number of node each block can have except last one 
	public int acceptedNoOfNodes() {
		return (int)Math.ceil(Math.sqrt(this.numberOfElements));
	}
	
	// validation for number of elements
	public boolean check() {
		if (this.currentNoOfElements <= numberOfElements) {
			return true;
		}
		return false;
	}
	/*
		Insert
	*/
	
	// insert into head
	public void insertIntoHead(int data) {
		if (this.uHead != null) {
			if (this.uHead.getBlockHead() != null) {
				if (this.uHead.getNoOfNodes() < acceptedNoOfNodes()) {
					Node newNode = new Node();
					newNode.setData(data);
					newNode.setNext(uHead.getBlockHead());
					this.uHead.getBlockTail().setNext(newNode);
					this.uHead.setBlockHead(newNode);
					this.uHead.numberOfNodes++; // important
				} else {
					// performing shift operation
					Node currentTail = this.uHead.getBlockTail();
					Node temp = this.uHead.getBlockHead();
					Node previousNode = null;
					for (; temp.getNext() != this.uHead.getBlockHead(); temp = temp.getNext()) {
						previousNode = temp;
					}
					previousNode.setNext(this.uHead.getBlockHead());
					this.uHead.setBlockTail(previousNode);
					
					// for head node
					Node newNode = new Node();
					newNode.setData(data);
					newNode.setNext(uHead.getBlockHead());
					this.uHead.getBlockTail().setNext(newNode);
					this.uHead.setBlockHead(newNode);
					this.uHead.numberOfNodes++; // important
			
					shiftHead(this.uHead, this.uHead.getNextBlock(), currentTail);
				}
			} else {
				Node newNode = new Node();
				newNode.setData(data);
				newNode.setNext(newNode);
				this.uHead.setBlockHead(newNode);
				this.uHead.setBlockTail(newNode);

				this.uHead.numberOfNodes++; // important
			}
		} else {
			UnrollLinkedListBlock newBlock = new UnrollLinkedListBlock();
			this.createdBlockNumber++; // important
			this.uHead = newBlock;
			Node newNode = new Node();
			newNode.setData(data);
			newNode.setNext(newNode);
			this.uHead.setBlockHead(newNode);
			this.uHead.setBlockTail(newNode);
			this.uHead.numberOfNodes++; // important
		}
	}
	
	
	public void shiftHead(UnrollLinkedListBlock previousBlock, UnrollLinkedListBlock nextBlock, Node tailNode) {
		if ((nextBlock == null) && (this.createdBlockNumber < noOfBlocks)) {
			UnrollLinkedListBlock newBlock = new UnrollLinkedListBlock();
			this.createdBlockNumber++; // important
			previousBlock.setNextBlock(newBlock);
			//this.createdBlockNumber++;
			nextBlock = newBlock;
			
		}
		
		if ((nextBlock.getNoOfNodes() >= acceptedNoOfNodes()) && (nextBlock.getNextBlock() != null)) {
			// have to hande this block tail node also
			
			// for tail node
			Node currentTail = nextBlock.getBlockTail();
			Node temp = nextBlock.getBlockHead();
			Node tempHead = nextBlock.getBlockHead();
			Node previousNode = null;
			for (; temp.getNext() != tempHead; temp = temp.getNext()) {
				previousNode = temp;
			}
			previousNode.setNext(nextBlock.getBlockHead());
			nextBlock.setBlockTail(previousNode);
			//System.out.println("if tail node seperated");
			// for head node
			tailNode.setNext(nextBlock.getBlockHead());
			nextBlock.getBlockTail().setNext(tailNode);
			nextBlock.setBlockHead(tailNode);
			
			shiftHead(nextBlock, nextBlock.getNextBlock(), currentTail);

			
		} else if((nextBlock.getNoOfNodes() >= acceptedNoOfNodes()) && (this.createdBlockNumber < noOfBlocks)) {

			
			Node currentTail = nextBlock.getBlockTail();
			Node temp = nextBlock.getBlockHead();
			Node tempHead = nextBlock.getBlockHead();
			Node previousNode = null;
			for (; temp.getNext() != tempHead; temp = temp.getNext()) {
				previousNode = temp;
			}
			previousNode.setNext(nextBlock.getBlockHead());
			nextBlock.setBlockTail(previousNode);
			//
			tailNode.setNext(nextBlock.getBlockHead());
			nextBlock.getBlockTail().setNext(tailNode);
			nextBlock.setBlockHead(tailNode);
			//
			
			UnrollLinkedListBlock newBlock = new UnrollLinkedListBlock();
			this.createdBlockNumber++; // important
			nextBlock.setNextBlock(newBlock);
			//shiftHead(nextBlock, nextBlock.getNextBlock(), tailNode);
			shiftHead(nextBlock, nextBlock.getNextBlock(), currentTail); // from the pevious one
			//nextBlock = newBlock;

		} else {
			/*
				Write a condition if the block head is null
			*/
			if (nextBlock.getBlockHead() == null) {
				tailNode.setNext(tailNode);
				nextBlock.setBlockHead(tailNode);
				nextBlock.setBlockTail(tailNode);
				nextBlock.numberOfNodes++; // important
			} else {
				tailNode.setNext(nextBlock.getBlockHead());
				nextBlock.getBlockTail().setNext(tailNode);
				nextBlock.setBlockHead(tailNode);
				nextBlock.numberOfNodes++; // important
			}
		}
	}
	
	/*
		print
	*/
	public void print() {
		/*System.out.println(uHead.getBlockHead().getData());
		System.out.println(uHead.getBlockHead().getNext().getData());
		System.out.println(uHead.getNextBlock().getBlockHead().getData());
		System.out.println(uHead.getNextBlock().getBlockHead().getNext().getData());*/
		UnrollLinkedListBlock uTemp = this.uHead;
		Node tempHead = this.uHead.getBlockHead();
		Node temp = this.uHead.getBlockHead();
		int x = 0;
		for (; uTemp != null; uTemp = uTemp.getNextBlock()) {
			
			temp = uTemp.getBlockHead();
			tempHead = uTemp.getBlockHead();
			for (; temp.getNext() != tempHead; temp = temp.getNext()) {
				System.out.println(temp.getData());
				x++;
				if (x==20) {
					break;
				}
			}
			System.out.println(temp.getData());
			// important
			System.out.println("--------------");
			
				
		}
		
	}
}

class ImpUrollLinkedList {
	public static void main(String[] args) {
		UnrollLinkedList ur = new UnrollLinkedList(16);
		ur.insertIntoHead(1);
		ur.insertIntoHead(2);
		ur.insertIntoHead(3);
		ur.insertIntoHead(4);
		ur.insertIntoHead(5);
		ur.insertIntoHead(6);
		ur.insertIntoHead(7);
		ur.insertIntoHead(8);
		ur.insertIntoHead(9);
		ur.insertIntoHead(10);
		ur.insertIntoHead(11);
		ur.insertIntoHead(12);
		ur.insertIntoHead(13);
		ur.insertIntoHead(14);
		ur.insertIntoHead(15);
		ur.insertIntoHead(16);
		ur.print();
	}
}