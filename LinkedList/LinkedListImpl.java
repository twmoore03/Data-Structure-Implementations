package LinkedListA0;

public class LinkedListImpl implements LIST_Interface {

	public Node root;
	public Node currentNode;
	public int size = 0;
	
	public LinkedListImpl() {
		root = new Node(0);
	}
	
	@Override
	public void clear() {
		//root = new Node(0);
		//size = 0;
		
		root.next = null;
		size = 0;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		if (size == 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean insert(Node n, int index) {
		if (this.size() < index) {
			return false;
		}
		
		if (index == 0 && this.size() > 0) {
			n.next = get(index);
			this.root.next = n;
			size++;
		} else if (index == 0) {
			this.root.next = n;
			size++;
		} else {
			n.next = get(index);
			get(index - 1).next = n;
			size++;
		}
		
		if (get(index) == n) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean remove(int index) {
		if (size <= index) {
			return false;
		} else if (index == 0) {
			Node removedNode = get(index);
			root.next = removedNode.next;
			size--;
			return true;
		} else {
			Node removedNode = get(index);
			get(index - 1).next = removedNode.next;
			size--;
			return true;
		}
	}

	public Node get(int index) {
		if (root.next == null) {
			return null;
		}
		currentNode = root.next;
		for (int count = 0; count <= this.size; count++) {
			if (count == index) {
				return currentNode;
				
			} else if (currentNode.next == null){
				return null;
			} else  {
				currentNode = currentNode.next;
			}
		}
		return currentNode;
	}
	
	public Node getRoot() {
		return root;
	}
	
}
