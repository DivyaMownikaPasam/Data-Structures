package linkedLists;

public class FindMergePointsOfLists {

	public static int mergeNode(Node head1, Node head2){
		
		Node current1, current2;
		int result= -1;
		int size1= findSizeOfList(head1);
		int size2 = findSizeOfList(head2);
		int diff;
		if(size1 > size2){
			current1 = head1;
			current2 = head2;
			diff = size1-size2;
		}else{
			current1 =head2;
			current2 = head1;
			diff = size2-size1;
		}
		//Now traverse the list which is longer from 1st node 
		//to the difference of lengths between 1st and second lists
		while(current1 !=null && diff>0){
			current1 = current1.next;
			diff--;
		}
		
		while(current1 !=null && current2!=null){
			if(current1.data == current2.data){
				result = current1.data;
				break;
			}else{
				current1 = current1.next;
				current2 = current2.next;
			}
		}
		return result;
	}
	
	public static int findSizeOfList(Node head){
		Node current = head;
		int size =0;
		while(current!=null){
			size++;
			current = current.next;
		}
		return size;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node head1 = new Node(1,null);
		head1.next = new Node(2,null);
		head1.next.next = new Node(3,null);
		head1.next.next.next = new Node(4,null);
		
		Node head2 = new Node(10,null);
		head2.next = new Node(5,null);
		head2.next.next = new Node(4,null);
		
		int mergePoint = mergeNode(head1,head2);
		if(mergePoint > 0)
			System.out.println("The merge point is: "+ mergePoint);
		else
			System.out.println("There is no merge point between the lists");

	}

}
