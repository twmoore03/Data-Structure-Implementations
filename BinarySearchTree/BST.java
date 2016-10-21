package BST_A2;

public class BST implements BST_Interface {
	public BST_Node root;
	int size;

	public BST() {
		size = 0;
		root = null;
	}

	public BST_Node getRoot() {
		return root;
	}

	@Override
	public boolean insert(String s) {
		if (s != null) {
			if (root == null) {
				root = new BST_Node(s);
				size++;
			}  else if (this.contains(s)) {
				return false;
			} else {
				size++;
				return root.insertNode(s);
			}
		}
		return false;
	}

	@Override
	public boolean remove(String s) {
		if (root != null && s != null && root.containsNode(s)) {
			if (size == 1) {
				root = null;
				size--;
				return true;
			} else {
				size--;
				root = root.removeNode(s, root);
				return true;
			}
		}
		return false;
	}

	@Override
	public String findMin() {
		if (root != null) {
			String min = root.findMin().data;
			return min;
		} else {
			return null;
		}
	}

	@Override
	public String findMax() {
		if (root != null) {
			String max = root.findMax().data;
			return max;
		} else {
			return null;
		}
	}

	@Override
	public boolean empty() {
		if (size == 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean contains(String s) {
		if (root == null) {
			return false;
		} else if (root.containsNode(s)) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public int height() {
		if (root == null) {
			return -1;
		} 
		int height = root.getHeight();
		return height;
	}

	public boolean stringLessThan(String strOne, String strTwo) {
		if (strOne.compareTo(strTwo) < 0) {
			return true;
		} else {
			return false;
		}
	}

	public boolean stringEquals(String strOne, String strTwo) {
		if (strOne.compareTo(strTwo) == 0) {
			return true;
		} else {
			return false;
		}
	}

	public boolean stringGreaterThan(String strOne, String strTwo) {
		if (strOne.compareTo(strTwo) > 0) {
			return true;
		} else {
			return false;
		}
	}
}
