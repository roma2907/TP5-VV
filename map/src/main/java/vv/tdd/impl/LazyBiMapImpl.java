package vv.tdd.impl;

import vv.tdd.factory.Factory;

public class LazyBiMapImpl<K, V> extends BiMapImpl<K, V> {

	private Factory<K, V> keyFactory;
	private Factory<V, K> valueFactory;

	public LazyBiMapImpl(Factory<K, V> keyFactory, Factory<V, K> valueFactory) {
		this.keyFactory = keyFactory;
		this.valueFactory = valueFactory;
	}

	@SuppressWarnings("unchecked")
	@Override
	public K getByValue(Object value) {
		K key = super.getByValue(value);
		if(key==null){
			K newKey = keyFactory.transform((V)value);
			put(newKey, (V)value);
			return newKey;
		}
		return key;
	}
	

    @SuppressWarnings("unchecked")
	@Override
    public V get(Object key) {
    	V value = super.get(key);
		if(value==null){
			V newValue = valueFactory.transform((K)key);
			put((K)key,newValue);
			return newValue;
		}
		return value;
    
    }
}
