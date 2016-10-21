package BST_A2;

public class BST_Node {
	String data;
	BST_Node left;
	BST_Node right;
	BST_Node parent;

	BST_Node (String data) {
		this.data = data;
	}

	//Don't touch these three methods, they are used for testing

	public String getData() {
		return data;
	}

	public BST_Node getLeft() {
		return left;
	}

	public BST_Node getRight() {
		return right;
	}

	//Modify methods after this point to make them work properly

	public boolean containsNode(String s) {
		if (s != null) {
			if (stringEquals(s,data)) {
				return true;
			} else if (stringLessThan(s,data)) {
				if (left == null) {
					return false;
				} else {
					return left.containsNode(s);
				}
			} else if (stringGreaterThan(s,data)){
				if (right == null) {
					return false;
				} else {
					return right.containsNode(s);
				}
			}  
		} 
		return false;
	}

	public boolean insertNode(String s) {
		if (s != null) {
			if (stringEquals(s,data)) {
				return false;
			} else if (stringLessThan(s,data)) {
				if (left == null) {
					left = new BST_Node(s);
				} else {
					return left.insertNode(s);
				}
			} else {
				if (right == null) {
					right = new BST_Node(s);
				} else {
					return right.insertNode(s);
				}
			}
		}
		return false;
	}

	public BST_Node removeNode(String s, BST_Node root) {
		if (stringLessThan(s, root.data)) {
			root.left = removeNode(s, root.left);
		} else if (stringGreaterThan(s, root.data)) {
			root.right = removeNode(s,root.right);
		} else if (root.left != null && root.right != null) {
			root.data = root.right.findMin().data;
			root.right = removeNode(root.data, root.right);
		} else {
			root = (root.left != null) ? root.left : root.right;
		}
		return root;
	}
	
	public BST_Node findMin() {
		if (left != null) {
			parent = this;
			return left.findMin();
		} else {
			return this;
		}
	}

	public BST_Node findMax() {
		if (right != null) {
			parent = this;
			return right.findMax();
		} else {
			return this;
		}
	}

	public int getHeight() {
		int leftHeight = 0;
		int rightHeight = 0;

		if (left != null) {
			leftHeight = left.getHeight() + 1;
		} 

		if (right != null) {
			rightHeight =  right.getHeight() + 1;
		}

		if (leftHeight > rightHeight) {
			return leftHeight;
		} else {
			return rightHeight;
		}
	}

	//Feel free to add an helper methods after this point
	public String toString(){
		return "Data: "+this.data+", Left: "+((this.left!=null)?left.data:"null")
				+",Right: "+((this.right!=null)?right.data:"null");
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
	
	public static void copyNode(BST_Node original, BST_Node nodeCopy) {
		nodeCopy.data = original.data;
		nodeCopy.left = original.left;
		nodeCopy.right = original.right;
		nodeCopy.parent = original.parent;
	}
}
