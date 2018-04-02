package com.lyb.reflect.test2;

import java.util.ArrayList;
import java.util.List;

class CountedInteger{
	private static long counter;
	private final long id = counter++;
	public String toString(){
		return Long.toString(id);
	}
}

public class FilledList<T> {
	private Class<T> type;
	public FilledList(Class<T> type){
		this.type = type;
	}
	public List<T> create(int nElements){
		List<T> resultList = new ArrayList<T>();
		for(int i=0;i<nElements;i++){
			try {
				resultList.add(type.newInstance());
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		return resultList;
	}
	
	public static void main(String[] args) {
		FilledList<CountedInteger> filledList = new FilledList<CountedInteger>(CountedInteger.class);
		System.out.println(filledList.create(15));
	}
}
