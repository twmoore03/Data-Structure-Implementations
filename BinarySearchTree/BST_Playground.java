package BST_A2;

public class BST_Playground {
	public static void main(String[]args) {
		BST testTree = new BST();
		testTree.insert("D");
		testTree.insert("O");
		testTree.insert("L");
		testTree.insert("M");
		testTree.insert("F");
		testTree.insert("G");
		testTree.remove("D");
		printLevelOrder(testTree);
	}

	static void printLevelOrder(BST tree){ 
		//will print your current tree in Level-Order...
		//https://en.wikipedia.org/wiki/Tree_traversal
		int h=tree.getRoot().getHeight();
		for(int i=0;i<=h;i++){
			printGivenLevel(tree.getRoot(), i);
		}
	}

	static void printGivenLevel(BST_Node root,int level){
		if(root==null)return;
		
		if(level==0)System.out.print(root.data+" ");
		
		else if(level>0){
			printGivenLevel(root.left,level-1);
			printGivenLevel(root.right,level-1);
		}
	}
}
