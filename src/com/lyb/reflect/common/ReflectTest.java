package com.lyb.reflect.common;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectTest {

	public static void main(String[] args) {
	
		Student student = new Student();
		Class<?> clazz = student.getClass();
		//获取所有属性
		Field[] fields = clazz.getDeclaredFields();
		for(Field field : fields){
			System.out.println("属性名："+field.getName());
			System.out.println("属性类型："+field.getType());
			field.setAccessible(true);
			try {
				System.out.println("属性值："+field.get(student));
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		
		//获取所有方法
		String methodName = "introduce"; 
		Method[] methods = clazz.getDeclaredMethods();
		for(Method method : methods){
			if(methodName.equals(method.getName())){
				try {
					method.setAccessible(true);
					Object object = method.invoke(student,"girl");
					System.out.println("方法执行结果："+object);
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				}
			}
		}
		
		//获取构造方法
		Constructor<?>[] constructors = clazz.getConstructors();
		for(Constructor csonstructor : constructors){
			if(csonstructor.getParameterTypes().length>0){
				try {
					student = (Student)csonstructor.newInstance(new Object [] {"",23,""});
					System.out.println(student);
					System.out.println(student.getGradeCount());
				} catch (InstantiationException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				}
			}else{
				System.out.println("无参的构造函数！");
			}
			/*Class<?> [] params = csonstructor.getParameterTypes();
			for(Class<?> param : params){
				System.out.println("构造函数的参数名称："+param.getName());
				System.out.println("构造函数的参数类型："+param.getTypeParameters());
			}*/
		}
	}
}
