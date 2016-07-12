package lruCache;

import java.util.LinkedHashMap;
import java.util.Map;

public class LruCache {

	int cacheCapacity;
	Map<Integer,Integer> cache = new LinkedHashMap<Integer, Integer>();
	
	public LruCache(int capacity) {
		this.cacheCapacity = capacity;
	}
	
	public int getValue(int key){
		int value = -1;
		
		if(cache.get(key) != null){
			value = cache.get(key);
			cache.remove(key);
			cache.put(key,value);
		}
		return value;
	}
	
	public void setValue(int key, int value){
		if(cache.size() < cacheCapacity){			
			if(cache.containsKey(key))
				cache.remove(key);
		}
		else{
			for(int k: cache.keySet()){
				cache.remove(k);
				break;
			}	
		}
		cache.put(key, value);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
