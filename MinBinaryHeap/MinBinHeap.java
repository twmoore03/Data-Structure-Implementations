package MinBinHeap_A3;

public class MinBinHeap implements Heap_Interface {
	private EntryPair[] array; //load this array
	private int size;
	private static final int arraySize = 10000; //Everything in the array will initially 
	//be null. This is ok! Just build out 
	//from array[1]

	public MinBinHeap() {
		this.array = new EntryPair[arraySize];
		array[0] = new EntryPair(null, -100000); //0th will be unused for simplicity 
		//of child/parent computations...
		//the book/animation page both do this.
	}

	//Please do not remove or modify this method! Used to test your entire Heap.
	@Override
	public EntryPair[] getHeap() { 
		return this.array;
	}

	//inserts the EntryPair in the correct place in the binary heap, based on its priority
	//Uses perculateUp method
	@Override
	public void insert(EntryPair entry) {
		if (entry == null) {
			throw new IllegalArgumentException();
		}

		int hole = size + 1;
		array[hole] = entry;
		percolateUp(hole);
		size++;
	}

	//deletes the minimum EntryPair and then resorts the binary heap to fill the resulting hole
	//uses percolateDown method.
	@Override
	public void delMin() {
		EntryPair minPair = this.getMin();

		array[1] = array[size];
		percolateDown(1);
		size--;
	}

	//returns the minimum EntryPair in the binary heap
	@Override
	public EntryPair getMin() {
		return array[1];
	}

	//Returns the size of the binary heap
	@Override
	public int size() {
		return size;
	}

	//populates a binary heap when given an array of EntryPair entries
	@Override
	public void build(EntryPair[] entries) {
		for (int i = 1; i <= entries.length; i++) {
			array[i] = entries[i - 1];
			size++;
		}
		int lastParentLocation = floor(entries.length / 2);
		for (int i = lastParentLocation; i > 0; i--) {
			percolateDown(i);
		}
	}

	//Primary method used to implement delMin. Hole starts at the top and shifts down, being filled 
	//at each level of the binary heap with the least priority EntryPair until it reaches the last level of the binary heap.
	//Then once on the bottom level place the previous farthest right EntryPair in the array in the last hole
	private void percolateDown(int hole) {
		int child;
		EntryPair temp;

		for( ; hole * 2 < size; hole = child) {
			child = hole * 2;
			temp = array[hole];
			if (array[child + 1].priority < array[child].priority) {
				child++;
			}
			if (array[child].priority < array[hole].priority) {
				array[hole] = array[child];
				array[child] = temp;
			} else {
				break;
			}
		}
	}

	//Used for the insertion method. Create a hole at the bottom and check if placing the EntryPair to be inserted in 
	//this would violate the heap order property. If it would, shift the hole up one and repeat.
	private void percolateUp(int hole) {
		for ( ; array[floor(hole / 2)].priority > array[hole].priority; hole /= 2) {
			EntryPair temp = array[hole];
			array[hole] = array[floor(hole / 2)];
			array[floor(hole / 2)] = temp;
		}
	}

	private int floor(int n) {
		return n = n - (n % 1);
	}
}