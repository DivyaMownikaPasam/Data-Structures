package heaps;

public class MaxHeap {
	
	private int[] heap;
	private int size;
	private int maxSize;
	private static final int FRONT = 1;

	
	public MaxHeap(int maxSize){
		this.maxSize = maxSize;
		this.size = 0;		
		this.heap = new int[this.maxSize+1];
		this.heap[0] = Integer.MAX_VALUE;
	}
	
	public int parentPos(int pos){		
		return pos/2;
	}
	
	public int leftChildPos(int pos){
		return 2 * pos;
	}
	
	public int rightChildPos(int pos){
		return 2 * pos + 1;
	}
	
	public void swap(int pos1, int pos2){
		int temp = heap[pos1];
		heap[pos1] = heap[pos2];
		heap[pos2] = temp; 
	}
	
	public void insert(int node){
		heap[++size] = node;
		int current = size;
		while(heap[parentPos(current)] < heap[current]){
			swap(parentPos(current), current);
			current = parentPos(current);
		}		
	}
	
public void printHeap()
    {
        for (int i = 1; i <= size / 2; i++ )
        {
            System.out.print(" PARENT : " + heap[i] + " LEFT CHILD : " + heap[2*i]
                  + " RIGHT CHILD :" + heap[2 * i  + 1]);
            System.out.println();
        }
    }
	
	  private boolean isLeaf(int pos)
	    {
	        if (pos >=  (size / 2)  &&  pos <= size)
	        {
	            return true;
	        }
	        return false;
	    }
	  
    private void maxHeapify(int pos)
    {
        if (!isLeaf(pos))
        { 
            if ( heap[pos] < heap[leftChildPos(pos)]  || heap[pos] < heap[rightChildPos(pos)])
            {
                if (heap[leftChildPos(pos)] > heap[rightChildPos(pos)])
                {
                    swap(pos, leftChildPos(pos));
                    maxHeapify(leftChildPos(pos));
                }else
                {
                    swap(pos, rightChildPos(pos));
                    maxHeapify(rightChildPos(pos));
                }
            }
        }
    }
    public void maxHeap()
    {
        for (int pos = (size / 2); pos >= 1; pos--)
        {
            maxHeapify(pos);
        }
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  MaxHeap maxHeap = new MaxHeap(15);
	        maxHeap.insert(512);
	        maxHeap.insert(7);
	        maxHeap.insert(2);
	        maxHeap.insert(100);
	        maxHeap.insert(1);
	        maxHeap.insert(999);
	        maxHeap.insert(40);
	        maxHeap.insert(41);
	        maxHeap.insert(3);
	        
	        maxHeap.printHeap();
	        
	        System.out.println("*******************************************");
	        maxHeap.maxHeap();
	 
	        maxHeap.printHeap();
	}

}
