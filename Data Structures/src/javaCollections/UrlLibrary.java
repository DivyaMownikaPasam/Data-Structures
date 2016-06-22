package javaCollections;

import java.util.Iterator;
import java.util.LinkedList;

public class UrlLibrary implements Iterable<String>{
	
	private LinkedList<String> list = new LinkedList<String>();
	
	public UrlLibrary(){
		list.add("www.facebook.com");
		list.add("www.google.com");
		list.add("www.gmail.com");
	}

	//The following will have to be the iterator methods that we have to define - next(), hasNext() and remove
	/*public Iterator<String> iterator() {
	
		return list.iterator();
	}*/

	//Here I am creating another inner class to get the iterator methods defined for the UrlLibrary class as follows:
	
	private class urlIterator implements Iterator<String>{
		
		private int index = 0;
		
		public boolean hasNext() {
			if(index < list.size())
				return true;
			else
				return false;
		}

		public String next() {
			String val =  list.get(index);
			index++;
			return val;
		}
		
		public void remove() {
			// TODO Auto-generated method stub
			list.remove(index);
			
		}
		
	}

	public Iterator<String> iterator() {
		// TODO Auto-generated method stub
		return new urlIterator(); // This returns the new iterator class for your super class
	}

}
