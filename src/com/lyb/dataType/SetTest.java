package com.lyb.dataType;

import java.util.HashSet;
import java.util.TreeSet;

public class SetTest {

	public void TreeSetTest(){
		TreeSet<String> treeSet = new TreeSet<String>();
		treeSet.add("C");
		treeSet.add("D");
		treeSet.add("F");
		treeSet.add("A");
		treeSet.add("Z");
		treeSet.add("G");
		treeSet.add("2");
		treeSet.add("3");
		//Set不允许有重复的元素，如果重复再添加则返回false，
		System.out.println(treeSet.add("78"));
		System.out.println(treeSet.add("78"));
		String str = "";
		treeSet.add(str);
		System.out.println(treeSet);
		
		TreeSet<String> treeSet2 = new TreeSet<String>();
		//用来比较两个Set是否一样，长度相同，内容相同
		System.out.println(treeSet.equals(treeSet2));
		
		
	}
	
	
	public void HashSetTest(){
		HashSet<String> hashSet = new HashSet<String>(); 
		hashSet.add("D");
		hashSet.add("A");
		hashSet.add("C");
		hashSet.add("H");
		hashSet.add("R");
		hashSet.add("D");
		hashSet.add("V");
		String str = null;
		hashSet.add(str);
		String str2 = null;
		hashSet.add(str2);
		
		System.out.println(hashSet);
	}
	
	public static void main(String[] args) {
		SetTest setTest = new SetTest();
		setTest.HashSetTest();
	}
}
