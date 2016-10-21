package SPLT_A4;

public class SPLT implements SPLT_Interface{
  private BST_Node root;
  private int size;
  
  public SPLT() {
    this.size = 0;
  } 
  
  public BST_Node getRoot() { //please keep this in here! I need your root node to test your tree!
    return root;
  }

@Override
public void insert(String s) {
	if(root==null){
		root=new BST_Node(s);
		size++;
	}
	if(root.insertNode(s)){
		size++;
	}
}

@Override
public void remove(String s) {
	if (root != null) {
		if(size==1&&root.data.equals(s)){
			root=null;
			size--;
		}
		if(root.removeNode(s)){
			size--;
		}
	}
}

@Override
public String findMin() {
	if(root==null)return null;
	return root.findMin().data;
}

@Override
public String findMax() {
	if(root==null)return null;
	return root.findMax().data;
}

@Override
public boolean empty() {
	if (this.size == 0) return true;
	return false;
}

@Override
public boolean contains(String s) {
	if(empty())return false;
	return root.containsNode(s);
}

@Override
public int size() {
	return this.size;
}

@Override
public int height() {
	return this.height();
}  

}