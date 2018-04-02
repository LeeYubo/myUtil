package com.lyb.reflect.test1;

interface HasBatteries {};
interface WaterProof {};
interface Shoots {};

class Toy{
	Toy() {System.out.println("hehe1");}
	Toy(int i) {System.out.println("hehe2");}
}

class FancToy extends Toy implements HasBatteries,WaterProof,Shoots{
	public FancToy() {
		super(1);
	}
}

public class ToyTest {

	static void printInfo(Class<?> cc){
		System.out.println("Class name = "+cc.getName()+", is interface ? = "+cc.isInterface());
		System.out.println("simple name = "+cc.getSimpleName());
		System.out.println("canonical name = "+cc.getCanonicalName());
	}
	
	public static void main(String[] args) {
		Class<?> c = null;
		try {
			c = Class.forName("com.lyb.reflect.test1.FancToy");
		} catch (ClassNotFoundException e) {
			System.out.println("can't find FancToy");
			System.exit(1);
		}
		printInfo(c);
		for(Class<?> face : c.getInterfaces()){
			printInfo(face);
		}
		Class<?> up = c.getSuperclass();
		Object object = null;
		try {
			object = up.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		System.out.println("-----------------");
		printInfo(object.getClass());
	}
}
