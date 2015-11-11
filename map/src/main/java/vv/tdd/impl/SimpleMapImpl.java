package vv.tdd.impl;

import java.util.*;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class SimpleMapImpl<K,V> implements Map<K,V> {

	protected Map<K,V> map = new HashMap<K,V>();
	
    @Override
    public int size() {
        return map.size();
    }

    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return map.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return map.containsValue(value);
    }

    @Override
    public V get(Object key) {
        return map.get(key);
    }

    @Override
    public V put(K key, V value) {
        return map.put(key, value);
    }

    @Override
    public V remove(Object key) {
        return map.remove(key);
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {
    	map.putAll(m);
    }

    @Override
    public void clear() {
    	map.clear();
    }

    
	@Override
    public Set<K> keySet() {
        return map.keySet();
    }

    @Override
    public Collection<V> values() {
    	List<V> list = new ArrayList<V>();
    	for(V v :map.values()){
    		list.add(v);
    	}
        return list;
    }

    @SuppressWarnings("restriction")
	@Override
    public Set<Entry<K, V>> entrySet() {
    	if(map.size() == 0){
    		throw new NotImplementedException();
    	}
    	return map.entrySet();
    }
    
    
    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((map == null) ? 0 : map.hashCode());
		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SimpleMapImpl<K, V> other = (SimpleMapImpl<K, V>) obj;
		if (map == null) {
			if (other.map != null)
				return false;
		} else if (!map.equals(other.map))
			return false;
		return true;
	}

}
