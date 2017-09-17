package stringQuestions;
import linkedLists.LinkedList;
import linkedLists.Node;

/*
 * The following code checks if the given linkedList is a palindrome or not.
 * 
 * */

public class checkForPalindrome {

	public static Boolean checkPalindrome(LinkedList list){
		
		int mid = list.size/2;
		Node current = list.head;
		
		while(mid >0){			
			current = current.getNext();
			mid --;			
		}
		
		LinkedList list2 = new LinkedList();
		while(current!=null){
			list2.insertNode(current.getData());
			current = current.getNext();			
		}
		//System.out.println("Size of list2 before deletion: " + list2.size);
		
		if(list.size % 2 == 0){
			//Meaning if the number of elements in the 2nd list are even
			list2.reverseLinkedList();
		} 
		else{
			list2.deleteNode(0);	
			list2.reverseLinkedList();
		}
	
		current = list.head;
		Node current2 = list2.head;
		for(int i=0; i<list2.size; i++){			
			if(current.getData() != current2.getData())
				return false;
			else{
				current = current.getNext();
				current2 = current2.getNext();
			}
			
		}
	
		return true;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		LinkedList list = new LinkedList();
		
		list.insertNode(1);
		list.insertNode(0);
		list.insertNode(2);
		list.insertNode(6);
		list.insertNode(1);
		list.insertNode(0);
		list.insertNode(1);
		
		
		System.out.println(checkPalindrome(list));
		
		
		System.out.println(list.isPalindrome());

	}

}
