package javaCollections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;


class Names implements Comparable<Names>{
	String name;
	
	public Names (String name){
		
		this.name = name;
	}

	public int compareTo(Names names) {
		return this.name.compareTo(names.name);
		
		//The foll can also be done taking length into consideration
		/*int len1 = this.name.length();
		int len2 = names.name.length();
		
		if(len1 > len2)
			return 1;
		else if(len1 < len2)
			return -1;
		else{
			return this.name.compareTo(names.name);
		}*/
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Names other = (Names) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
}
public class NaturalOrder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<Names> list = new ArrayList<Names>();		
		Set<Names> set = new TreeSet<Names>();
		
		addElements(list);
		Collections.sort(list);
		showElements(list);
		System.out.println("");
		addElements(set);
		showElements(set);
		
		
	}
	
	private static void addElements(Collection<Names> col){
		col.add(new Names("niki"));
		col.add(new Names("rohan"));
		col.add(new Names("neeraj"));
		col.add(new Names("tilak"));
		col.add(new Names("sharan"));
		col.add(new Names("monish"));	
	}
	
	private static void showElements(Collection<Names> col){
		for(Names str: col){
			System.out.println(str.name);
		}
	}

}
