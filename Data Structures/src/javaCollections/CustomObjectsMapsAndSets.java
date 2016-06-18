package javaCollections;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;


class Person{
	private int id;
	private String name;
	
	public Person(int id, String name){
		this.id = id;
		this.name = name;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String toString(){
		return "{Id is :" + id+ "; Name is " +": "+ name + " }";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
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
		Person other = (Person) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
}
public class CustomObjectsMapsAndSets {
	
	
	public static void main(String[]args){
		
		Person p1 = new Person(0, "Niki");
		Person p2 = new Person(1, "Rohan");
		Person p3 = new Person(2, "Niki2");
		Person p4 = new Person(1, "Rohan");

		Map<Person,Integer> map = new LinkedHashMap<Person, Integer>();
		map.put(p1, 1);
		map.put(p2, 2);
		map.put(p3, 3);
		map.put(p4, 1);
		
		for(Person key:map.keySet()){
			System.out.println(key+ ":" + map.get(key));
		}
		
		
		Set<Person>set = new LinkedHashSet<Person>();
		set.add(p1);
		set.add(p2);
		set.add(p3);
		set.add(p4);
		
		System.out.println("Set is as follows:");
		System.out.println(set); 
		// Here Sets and maps cannot actually say if 2 custom objects asre the same.
		//So on printing, we see duplicate values in the result

	}
	

}
