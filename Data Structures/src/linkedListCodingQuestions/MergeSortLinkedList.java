package linkedListCodingQuestions;

import linkedLists.LinkedList;
import linkedLists.Node;


public class MergeSortLinkedList {
	
	public static Node mergeTwoLists(Node l1, Node l2){
		if(l1 == null && l2 != null)return l2;
		else if(l2==null && l1 != null)return l1;
		else if(l1 == null && l2==null) return null;
		
		Node head = null;
		Node current1, current2;
		if(l1.getData() < l2.getData()){
			head = l1;
			current1 =head.getNext();
			current2 = l2;
		}
		else{
			head=l2;
			current1 = l1;
			current2 =head.getNext();
		}
		
		Node temp = head;
		while(current1 != null && current2 != null){
			if(current1.getData() < current2.getData()){
				temp.setNext(current1);
				temp = current1;
				current1 = current1.getNext();
			}
			else{
				temp.setNext(current2);	
				temp = current2;
				current2 = current2.getNext();
				
			}
		}
		
		if(current1 == null && current2 !=null){
			while(current2 != null){
				temp.setNext(current2);
				temp = current2;
				current2 = current2.getNext();
			}		
		}
		
		
		if(current2 == null && current1 !=null){
			while(current1 != null){
				temp.setNext(current1);
				temp = current1;
				current1 = current1.getNext();
			}		
		}
		
		return head;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		LinkedList list1 = new LinkedList();
		list1.insertNode(1);
		list1.insertNode(2);
		list1.insertNode(3);
		
		
		LinkedList list2 = new LinkedList();
		list2.insertNode(2);
		list2.insertNode(9);
		list2.insertNode(10);
		list2.insertNode(11);
		list2.insertNode(15);
		
		
		list1.head =  mergeTwoLists(list1.head, list2.head);
		
		list1.printLinkedList();

	}

}
