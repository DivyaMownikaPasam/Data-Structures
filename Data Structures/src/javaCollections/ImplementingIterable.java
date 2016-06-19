package javaCollections;

import java.util.Iterator;

public class ImplementingIterable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UrlLibrary urlLibrary = new UrlLibrary();
		
		// How to iterate through a list that was defined in your custom class;
		
		//Thr following is one way of doing it using the modern for each loop
		System.out.println("Iterating using FOR-EACH loop construct");
		for(String url:urlLibrary){
			System.out.println(url);
		}
		
		//The following will be one if you are implemnting using Iterator methods
		System.out.println("Iterating using ITERATOR construct");
		Iterator<String> i = urlLibrary.iterator();
		while(i.hasNext()){
			String val = i.next();
			System.out.println(val);
			
		}
		
	}

}
