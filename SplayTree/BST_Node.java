package SPLT_A4;

public class BST_Node {
	String data;
	BST_Node left;
	BST_Node right;
	BST_Node par;
	boolean justMade;

	BST_Node(String data){
		this.data=data;
		this.justMade = true;
	}

	BST_Node(String data, BST_Node left,BST_Node right,BST_Node par){ //feel free to modify this constructor to suit your needs
		this.data=data;
		this.left=left;
		this.right=right;
		this.par=par;
		this.justMade=true;
	}


	public String getData(){
		return data;
	}
	public BST_Node getLeft(){
		return left;
	}
	public BST_Node getRight(){
		return right;
	}

	public boolean containsNode(String s){
		if(data.equals(s))return true;
		if(data.compareTo(s)>0){    //s lexiconically less than data
			if(left==null)return false;
			return left.containsNode(s);
		}
		if(data.compareTo(s)<0){
			if(right==null)return false;
			return right.containsNode(s);
		}
		return false; //shouldn't hit
	}
	
	//add splay method
	public boolean insertNode(String s){
		if(data.compareTo(s)>0){
			if(left==null){
				left=new BST_Node(s);
				return true;
			}
			return left.insertNode(s);
		}
		if(data.compareTo(s)<0){
			if(right==null){
				right=new BST_Node(s);
				return true;
			}
			return right.insertNode(s);
		}
		return false;//ie we have a duplicate
	}
	
	//add splay method
	public boolean removeNode(String s){
		if(data==null)return false;
		if(data.equals(s)){
			if(left!=null){
				data=left.findMax().data;
				left.removeNode(data);
				if(left.data==null)left=null;
			}
			else if(right!=null){
				data=right.findMin().data;
				right.removeNode(data);
				if(right.data==null)right=null;
			}
			else data=null;
			return true;
		}
		else if(data.compareTo(s)>0){
			if(left==null)return false;
			if(!left.removeNode(s))return false;
			if(left.data==null)left=null;
			return true;
		}
		else if(data.compareTo(s)<0){
			if(right==null)return false;
			if(!right.removeNode(s))return false;
			if(right.data==null)right=null;
			return true;
		}
		return false;
	}
	
	//add splay method
	public BST_Node findMin(){
		if(left!=null)return left.findMin();
		return this;
	}
	
	//add splay method
	public BST_Node findMax(){
		if(right!=null)return right.findMax();
		return this;
	}
	public int getHeight(){
		int l=0;
		int r=0;
		if(left!=null)l+=left.getHeight()+1;
		if(right!=null)r+=right.getHeight()+1;
		return Integer.max(l, r);
	}
	public String toString(){
		return "Data: "+this.data+", Left: "+((this.left!=null)?left.data:"null")+",Right: "+((this.right!=null)?right.data:"null");
	}
	
	private void splay(BST_Node toSplay) {
		
	}
	
	private void zig(BST_Node toZig) {
		
	}
	
	private void zigZig(BST_Node toZigZig) {
		
	}
	
	private void zigZag(BST_Node toZigZag) {
		
	}

}
