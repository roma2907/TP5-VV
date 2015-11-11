package vv.tdd.impl;

import java.util.Iterator;

/**
 * Created by Simon on 30/09/14.
 */
public class BiMapImpl<K,V> extends SimpleMapImpl<K,V> implements vv.tdd.BiMap<K,V> {


	@Override
	public K getByValue(Object value) {
		K result = null;
		final Iterator<K> it = keySet().iterator();
		while(it.hasNext()){
			final K entry = it.next();
			if(map.get(entry).equals(value)){
				result = entry;
				break;
			}
		}
		return result;
	}

	@Override
	public K removeValue(Object value) {
		final Iterator<Entry<K,V>> it =entrySet().iterator();
		while(it.hasNext()){
			final Entry<K,V> entry = it.next();
			if(entry.getValue().equals(value)){
				final K key = entry.getKey();
				it.remove();
				return key;
			}
		}
		return null;
	}

	@Override
	public V put(K key, V value) {
		if(containsValue(value)){
			remove(getByValue(value));
		}
		return super.put(key, value);
	}

}
