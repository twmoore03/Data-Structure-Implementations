package MinBinHeap_A3;

public class MinBinHeap_Playground {
	public static void main(String[] args){   
		//Add more tests as methods and call them here!!
		TestBuild();
	}

	public static void TestBuild(){ 
		// constructs a new minbinheap, constructs an array of EntryPair, 
		// passes it into build function. Then print collection and heap.
		delMinTestOne();
	}

	public static void printHeapCollection(EntryPair[] e) { 
		//this will print the entirety of an array of entry pairs you will pass 
		//to your build function.
		System.out.println("Printing Collection to pass in to build function:");
		for(int i=0;i < e.length;i++){
			System.out.print("("+e[i].value+","+e[i].priority+")\t");
		}
		System.out.print("\n");
	}

	public static void printHeap(EntryPair[] e,int len) { 
		//pass in mbh.getHeap(),mbh.size()... this method skips over unused 0th index....
		System.out.println("Printing Heap");
		for(int i=1;i < len+1;i++){
			System.out.print("("+e[i].value+","+e[i].priority+")\t");
		}
		System.out.print("\n");
	}

	public static void buildTestOne() {
		MinBinHeap mbh = new MinBinHeap();
		EntryPair[] collection = new EntryPair[5];
		collection[0] = new EntryPair("a",5);
		collection[1] = new EntryPair("b",4);
		collection[2] = new EntryPair("c",3);
		collection[3] = new EntryPair("d", 2);
		collection[4] = new EntryPair("e",1);
		mbh.build(collection);
		printHeapCollection(collection);
		printHeap(mbh.getHeap(), mbh.size());
	}
	
	public static void delMinTestOne() {
		MinBinHeap mbh = new MinBinHeap();
		EntryPair[] collection = new EntryPair[5];
		collection[0] = new EntryPair("a",5);
		collection[1] = new EntryPair("b",4);
		collection[2] = new EntryPair("c",3);
		collection[3] = new EntryPair("d", 2);
		collection[4] = new EntryPair("e",1);
		mbh.build(collection);
		printHeap(mbh.getHeap(), mbh.size());
		mbh.delMin();
		printHeap(mbh.getHeap(), mbh.size());
		mbh.delMin();
		printHeap(mbh.getHeap(), mbh.size());
		
	}
}