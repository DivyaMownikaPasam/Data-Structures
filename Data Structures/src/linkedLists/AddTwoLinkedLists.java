package linkedLists;
/*
 * You are given two linked lists representing two non-negative numbers. 
 * The digits are stored in reverse order and each of their nodes contain a single digit. 
 * Add the two numbers and return it as a linked list.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
 * */
public class AddTwoLinkedLists {
	 public Node head;
	 int size=0;
		public  void reverseLinkedList(){
			
			Node p1 = head;
			if(p1.next == null)
				return;
			
			Node p2 = p1.next;
			while(p1 != null && p2 != null){
				Node temp = p2.next;				
				p2.next = p1;
				p1 = p2;
				p2 = temp;				
			}
			head.next = null;
			head = p1;
		}
		
		public  void insertNode(int num){
			Node newNode = new Node(num,null);
			size++;
			if(head == null){			
				head = newNode;
				
			}
			else{
				Node current = head;
				while(current.next != null){
					current = current.next;
				}
				current.next = newNode;
			}
			
		}
		
	    public static  Node addTwoNumbers(Node l1, Node l2, int s1, int s2) {	
	    	AddTwoLinkedLists res = new AddTwoLinkedLists();
	    	if(l1 == null)
	    		return l2;
	    	
	    	if(l2 == null)
	    		return l1;
	    	
	    	Node c1 , c2;
	   	    	
	    	if(s1>=s2){
	    		c1 = l1;
	    		c2 = l2;
	    	}else{
	    		c1 = l2;
	    		c2 = l1;
	    	}
	    	
	    	int rem =0;
	    	while(c1 !=null && c2!=null){
	    		
	    		int i = c1.data + c2.data + rem;
	    		if(i/10 == 0)
	    			res.insertNode(i);
	    		else{	    			
	    			rem = i/10;
	    			i = i % 10;
	    			res.insertNode(i);
	    		}
	    		c1 = c1.next;
	    		c2 = c2.next;
	    	}
	    	
	    	while(c1 != null){
	    		if(rem != 0){
	    			res.insertNode(c1.data + rem);
	    		}
	    		else{
	    			res.insertNode(c1.data);
	    		}
	    		c1= c1.next;
	    	}	    
	    	
	    	return res.head;
	    }
	
		public  void printLinkedList(){
			if(head == null){
				System.out.println("List is empty");
			}
			else{
				Node current = head;
				System.out.print(current.data + " ");
				while(current.next != null){
					current = current.next;
					System.out.print(current.data + " ");				
				}			
			}
			System.out.println();
		}
		
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AddTwoLinkedLists list1= new AddTwoLinkedLists();
		list1.insertNode(9);		
		list1.insertNode(9);
		list1.insertNode(9);
		
		
		//list1.reverseLinkedList();
		
		AddTwoLinkedLists list2= new AddTwoLinkedLists();
		list2.insertNode(9);
		list2.insertNode(9);
		list2.insertNode(9);
		
		//list2.reverseLinkedList();
		
		AddTwoLinkedLists result= new AddTwoLinkedLists();

		result.head = addTwoNumbers(list1.head, list2.head, list1.size, list2.size);
		result.printLinkedList();
		
	}

}
