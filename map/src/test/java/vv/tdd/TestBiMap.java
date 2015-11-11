package vv.tdd;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;

import java.util.Map;

import org.junit.Test;

import vv.tdd.impl.BiMapImpl;

/**
 * Created by Simon on 02/10/14.
 */
public class TestBiMap extends TestMap {

	@Override
	@Test
	public void testPut() {

		final Object previous1 = map.put("1", 1);
		assertEquals(1, map.get("1"));
		assertEquals(null, previous1);
		assertFalse(map.containsKey("3"));

		final Object previous2 = map.put("1", 2);
		final Object previous3 = map.put("3", 3);
		assertEquals(map.get("1"), 2);
		assertEquals(map.get("3"), 3);
		assertEquals(1, previous2);
		assertEquals(null, previous3);

		final Object previous4 = map.put("4", 2);
		assertEquals(map.get("4"), 2);
		assertEquals(null, previous4);
		assertFalse(map.containsKey("1"));
		assertEquals(((BiMap)map).getByValue(2), "4");

		final Object previous5 = map.put("3", 2);
		assertEquals(map.get("3"), 2);
		assertEquals(3, previous5);
		assertFalse(map.containsKey("4"));
		assertFalse(map.containsValue(3));
	}

	@Test
	public void testRemoveValue() {
		final BiMap biMap = (BiMap)map;

		biMap.put("1", 1);
		biMap.put("2", 2);
		biMap.put("3", 3);

		biMap.removeValue(1);
		assertFalse(biMap.containsValue(1));
		assertFalse(biMap.containsKey("1"));
		assertEquals("2",biMap.getByValue(2));
		assertEquals(2,biMap.get("2"));
	}

	@Test
	public void testGetByValue() {
		final BiMap biMap = (BiMap) map;
		biMap.put("1", "1");
		biMap.put("2", "12");
		biMap.put("3", "2");

		assertEquals("1",biMap.getByValue("1"));
		biMap.put("1", "11");
		assertEquals("1",biMap.getByValue("11"));

		assertNull(biMap.getByValue("4"));

		biMap.put("4", "4");
		assertEquals("4",biMap.getByValue("4"));
	}


	@Override
	protected Map<String, Integer> getNewMap() {
		return new BiMapImpl<String, Integer>();
	}
}