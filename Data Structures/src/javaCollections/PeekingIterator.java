package javaCollections;

import java.util.Iterator;
import java.util.LinkedList;

/*
 * The following implements a peek() function for the list iterator
 * The method allows to peek the value of the element in the list without advancing the iterator
 */
public class PeekingIterator implements Iterable<Integer>{

	private LinkedList<Integer> list= new LinkedList<Integer>();
	
	public PeekingIterator(){
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
	}
	
	private class listIterator implements Iterator<Integer>{
		int index = 0;
		public boolean hasNext() {
			// TODO Auto-generated method stub
			
			if(index < list.size())
				return true;
			else
				return false;
		}

		public Integer next() {
			// TODO Auto-generated method stub
			Integer val = null;
			if(hasNext()){
				 val = list.get(index);
				index++;
				
			}
			
			return val; 
			
		}

		public void remove() {
			// TODO Auto-generated method stub
			if(list.size() > 0){
				list.remove(index);
			}
			else{
				System.out.println("No elements in list to remove");
			}
			
		}
		
		public Integer peekforVal(){			
			return hasNext() ? list.get(index) : null;			
		}
		
	} 
	public Iterator<Integer> iterator() {
		// TODO Auto-generated method stub
		return new listIterator();
	}
	
	public static void main(String[] args) {
		
		PeekingIterator myIterator = new PeekingIterator();		
		Iterator<Integer> itr = myIterator.iterator();
		
		for(Integer i : myIterator.list){
			int val = itr.next();
			
			System.out.println("The peek value is: "+ ((listIterator) itr).peekforVal());
			System.out.println("The next value is: "+val);
			
			System.out.println("");
		}
	}

}
