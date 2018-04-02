package com.lyb.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapTest {

	public static void main(String[] args) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("name", "liyubo");
		map.put("sex", "male");
		map.put("age", "30");
		Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
		while(iterator.hasNext()){
			Map.Entry<String, String> entry = iterator.next();
			System.out.println("key = " + entry.getKey()+",value = "+entry.getValue());
		}
		System.out.println("----------------------");
		Set<Map.Entry<String, String>> set = map.entrySet();
		for (Map.Entry<String, String> entry : set) {
			System.out.println("key = " + entry.getKey()+",value = "+entry.getValue());
		}
	}
}
