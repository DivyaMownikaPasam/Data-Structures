package linkedLists;

public class LinkedList {

	//The following is Singly LinkedList class implementation
	/*
	 * 1. Build a Linked List given an input - Element insertion at rear end of linked list  
	 * 2. Print the linked list
	 * 3. Insert a node in the beginning
	 * 4. Insert a node given the position
	 * 5. Delete a node at a given position
	 * 6. Sort Linked list 
	 * 7. Search for a given number in a linked list     
	 * 
	 * */
	
	public Node head;
	
	public int size;
	
	public LinkedList() {
		// TODO Auto-generated constructor stub
		head = null;		
		size = 0;
	}
	
	public  void insertNode(int num){
		Node newNode = new Node(num,null);
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
		size++;
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
	
	public  void insertAtBeginning(int num){
		Node newNode = new Node(num,null);
		if(head == null){			
			head = newNode;				
		}
		else{			
			newNode.next = head;
			head = newNode;		
		}
		size++;
	}
	
	public  void insertAtPos(int num, int pos){
		if(pos<0){
			System.out.println("Cannot insert at position less than 0.");
			
		}
		else if(pos==0){
			insertAtBeginning(num);
		}
		else if(pos == size){
			insertNode(num);
		}
		else if(pos > size){
			System.out.println("Cannot insert at the given position");
			
		}
		else{
			int count = 0;
			Node current = head;
			Node prevCurrent = head;
			
			while(current.next !=null && pos != count){
				prevCurrent = current;
				current = current.next;
				count++;				
			}
			Node newNode = new Node(num,null);
			prevCurrent.next = newNode;
			newNode.next = current;			
		}
	}
	
	public  void deleteNode(int pos){
		if(pos < 0 || pos >= size){
			//Remove the head
			System.out.println("Index invalid");			
		}
		else if(pos == 0){
			Node current = head;
			head = current.next;
		}
		else{
			Node current = head;
			Node prevCurrent = head;
			int count = 0;
			while(current.next !=null && pos != count){
				prevCurrent = current;
				current = current.next;
				count++;				
			}
			prevCurrent.next = current.next;
		}
	}
	
	public  void sortLinkedList(){
		Node current , prevCurrent;
		Boolean needIteration = false;
		//int count;
		for(int i=0; i<size && !needIteration; i++){
			current = head;
			//count =0;
			while(current.next != null){
				prevCurrent = current;
				current = current.next;
				if(prevCurrent.data > current.data){
					int temp = prevCurrent.data;
					prevCurrent.data = current.data; 
					current.data = temp;
					needIteration = false;
				//	count++;
				}		
			}
			/*if(count == 0){
				needIteration = true;
			}*/
		}	
	}
	
	public  Boolean searchNode(int num){
		Boolean searchResult = false;
		
		Node current = head;
		while(current !=null){
			if(current.data == num){
				searchResult = true;
				break;
			}
			else{
				current = current.next;

			}
			
		}
		return searchResult;
	}
	/*
	 * struct node* prev   = NULL;
    struct node* current = *head_ref;
    struct node* next;
    while (current != NULL)
    {
        next  = current->next;  
        current->next = prev;   
        prev = current;
        current = next;
    }
    *head_ref = prev;*/
	
	public Node reverseLinkedList(){
		
		if(head == null || head.next == null)
			return head;
		else{
			Node current = head;
			Node prevCurrent = null;
			Node temp = null;
					
		
			while(current.next != null){			
				
				temp = current.next;
				
				current.next = prevCurrent; // Point current node to previous node
				prevCurrent = current; // Point prev current to current node
				current = temp;					
			}
			
			current.next = prevCurrent;
			
			head = current;
			
			return head;
		}
		
	}
	
	
	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		
		list.insertNode(1);
		list.insertNode(2);
		list.insertNode(3);
		list.insertNode(4);
		list.insertNode(5);
		list.insertNode(6);
		list.insertNode(7);
		list.insertNode(8);
		list.insertNode(9);
		
		System.out.println("The following is the built list: ");
		list.printLinkedList();
		
		System.out.println("Reversed List is as follows: ");
		list.reverseLinkedList();
		list.printLinkedList();
		
		list.insertAtBeginning(0);		
		System.out.println("The following is the built list after insert in beginning: ");
		list.printLinkedList();
		
		list.insertAtPos(10, 5);
		System.out.println("The following is the built list after insert at a position: ");
		list.printLinkedList();
		
		list.deleteNode(5);
		System.out.println("The following is the built list after deleting a node at a position: ");
		list.printLinkedList();
		
		LinkedList list2 = new LinkedList();
		list2.insertNode(10);
		list2.insertNode(1);
		list2.insertNode(5);
		list2.insertNode(3);
		list2.insertNode(2);
		
		
		System.out.println("List2 before sort:");
		list2.printLinkedList();
		list2.sortLinkedList();
		System.out.println("List2 after sort:");
		list2.printLinkedList();
		
		System.out.println("**************************************************************************************************");
		
		list.printLinkedList();
		Boolean searchResult1 = list.searchNode(9);
		if(searchResult1){
			System.out.println("Node is present in list");
		}
		else
		{
			System.out.println("Node is not present in list");
		}
		

		Boolean searchResult2 = list.searchNode(10);
		if(searchResult2){
			System.out.println("Node is present in list");
		}
		else
		{
			System.out.println("Node is not present in list");
		}

	}

}
