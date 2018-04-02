package com.lyb.annotation;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/** 
 * * 使用反射处理注解 * 
 * * @author sam 
 * * @since 2017/7/13 
 * */
public class MyMessageProcessor {
	public static void main(String[] args) {
		try {
			// 加载annotationTest.class类
			Class clazz = MyMessageProcessor.class.getClassLoader().loadClass("com.sam.annotation.AnnotationTest");
			clazz.isAnnotationPresent(MyMessage.class);
			// 获取属性
			Field[] fields = clazz.getDeclaredFields();
			// 遍历属性
			for (Field field : fields) {
				field.isAnnotationPresent(MyMessage.class);
				MyMessage myMessage = field.getAnnotation(MyMessage.class);
				System.out.println("name:" + myMessage.name() + " num:" + myMessage.num() + " desc:" + myMessage.desc());
			}
			// 获取类中的方法
			Method[] methods = clazz.getMethods();
			// 遍历方法
			for (Method method : methods) {
				// 判断方法是否带有MyMessage注解
				if (method.isAnnotationPresent(MyMessage.class)) {
					// 获取所有注解
					method.getDeclaredAnnotations();
					// 获取MyMessage注解
					MyMessage myMessage = method.getAnnotation(MyMessage.class);
					System.out.println(
							"name:" + myMessage.name() + " num:" + myMessage.num() + " desc:" + myMessage.desc());
				}
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}