package com.lyb.dataType;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Stack;

import com.lyb.log.Log;

public class ListTest {

	
	public void ArrayListTest(){
		
		List<String> list = new ArrayList<String>();
		Log.getLogger().info("start insert ..... ");
		for(int i=0; i<10; i++){
			list.add("test"+i);
		}
		Log.getLogger().info("finished insert ..... ");
		
		List<String> list2 = new ArrayList<String>();
		for(int i=0; i<10; i++){
			list2.add("liyubo"+i);
		}
		
		list.addAll(2,list2);//在指定位置插入
		list.addAll(list2);//默认在末尾插入
		Iterator<String> iterator2 = list.iterator();
		while(iterator2.hasNext()){
			System.out.println(iterator2.next());
		}
		
		System.out.println("hehehhehe");
		ListIterator<String> listIterator = list.listIterator(19);
		while(listIterator.hasNext()){
			System.out.println(listIterator.next());
		}
		System.out.println("hahahahahha");
		
		Log.getLogger().info(" indexOf start ");
		int firstPosition = list.indexOf("test");//第一次出现指定元素的位置
		System.out.println("test first position = "+firstPosition);
		int lastPosition = list.lastIndexOf("test");//最后次出现指定元素的位置
		System.out.println("test last position = "+lastPosition);
		Log.getLogger().info(" indexOf end ");
		
		//查看list中是否包含某一个变量		
		if(list.contains("test2345")){
			System.out.println("list 包含 test2345");
		}
		Log.getLogger().info("start search ..... ");
		String str = (String) list.get(2);
		System.out.println("get string = "+str);
		Log.getLogger().info("finished search ..... ");
		
		System.out.println("\n");
		Log.getLogger().info("start search iterator..... ");
		Iterator<String> iterator = list.iterator();
		while(iterator.hasNext()){
			if(iterator.next().equals(("test2345"))){
				System.out.println("OK!!!");
			}
		}
		Log.getLogger().info("finished search iterator..... ");
		System.out.println("\n");
	}
	
	
	public void LinkedListTest(){
		LinkedList<String> linkedList = new LinkedList<String>();
		for(int i=0; i<10; i++){
			linkedList.add("liyubo"+i);
		}
//		System.out.println(linkedList.get(linkedList.size()-1));
//		linkedList.remove(linkedList.size()-1);
//		System.out.println(linkedList.get(linkedList.size()-1));
		
		System.out.println(" getFirst = "+linkedList.getFirst());
		System.out.println(" getLast = "+linkedList.getLast());
		
	}
	
	public void StackTest(){
		Stack<String> stack = new Stack<String>();
		int a = 0;
		for(int i=0;i<10;i++){
			a = i+1;
			stack.add("test"+a);
		}
		
		String stack3 = stack.get(3);
		System.out.println("stack3 = "+stack3);
		String stack3_2 = stack.elementAt(3);
		System.out.println("stack3_2 = "+stack3_2);
		
		Iterator<String> iterator = stack.iterator();
		while(iterator.hasNext()){
			System.out.println(iterator.next()+" ");
		}
		
		System.out.println("-------------");
		System.out.println("search test2 = "+stack.search("test2"));//查找元素在栈中的位置，距离栈顶的位置，从1开始
		System.out.println("-------------");
		
		String testPeek = stack.peek();
		System.out.println("peek = "+testPeek);
		
		String testPop = stack.pop();
		System.out.println("pop = "+testPop);
		Iterator<String> iteratorPop = stack.iterator();
		while(iteratorPop.hasNext()){
			System.out.print(iteratorPop.next()+" ");
		}
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ListTest listTest = new ListTest();
		listTest.LinkedListTest();
	}

}
