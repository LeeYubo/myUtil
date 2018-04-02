package com.lyb.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;

public class TestReflection {
	private String username;
	private String password;
	public String grade;
	private int[] age;

	public void setUserName(String username) {
		this.username = username;
	}

	private void setPassWord(String password) {
		this.password = password;
	}

	public static void test01() throws ClassNotFoundException {
		System.out.println("测试开始...");
		Class c1 = TestReflection.class;
		Class c2 = Class.forName("com.lyb.reflect.TestReflection");
		// 获取指定的包名
		Type[] types = c1.getGenericInterfaces();
		String package01 = c1.getPackage().getName();
		String package02 = c2.getPackage().getName();
		System.out.println("package01 = " + package01);
		System.out.println("package02 = " + package02);
		// 获取类的修饰符
		int mod = c1.getModifiers();
		String modifier = Modifier.toString(mod);
		System.out.println("modifier = " + modifier);
		// 获取指定类的完全限定名
		String className = c1.getName();
		System.out.println("className = " + className);
		// 获取指定类的父类
		Class superClazz = c1.getSuperclass();
		String superClazzName = superClazz.getName();
		System.out.println("superClazzName = " + superClazzName);
		// 获取实现的接口
		Class[] interfaces = c1.getInterfaces();
		for (Class t : interfaces) {
			System.out.println("interfacesName = " + t.getName());
		}
		// 获取指定类的成员变量
		Field[] fields = c1.getDeclaredFields();
		for (Field field : fields) {
			modifier = Modifier.toString(field.getModifiers()); // 获取每个
			// 字段的访问修饰符
			Class type = field.getType(); // 获取字段的数据类型所对应的
			// Class对象
			String name = field.getName(); // 获取字段名
			if (type.isArray()) { // 如果是数组类型则需要特别处理
				String arrType = type.getComponentType().getName() + "[]";
				System.out.println("" + modifier + " " + arrType + " " + name + ";");
			} else {
				System.out.println("" + modifier + " " + type + " " + name + ";");
			}
		}
		// 获取类的构造方法
		Constructor[] constructors = c1.getDeclaredConstructors();
		for (Constructor constructor : constructors) {
			String name = constructor.getName(); // 构造方法名
			modifier = Modifier.toString(constructor.getModifiers()); // 获取访问修饰符
			System.out.println("" + modifier + " " + name + "(");
			Class[] paramTypes = constructor.getParameterTypes(); // 获取构造方法中的参数
			for (int i = 0; i < paramTypes.length; i++) {
				if (i > 0) {
					System.out.print(",");
				}
				if (paramTypes[i].isArray()) {
					System.out.println(paramTypes[i].getComponentType().getName() + "[]");
				} else {
					System.out.print(paramTypes[i].getName());
				}
			}
			System.out.println(");");
		}
		// 获取成员方法
		Method[] methods = c1.getDeclaredMethods();
		for (Method method : methods) {
			modifier = Modifier.toString(method.getModifiers());
			Class returnType = method.getReturnType(); // 获取方法的返回类型
			if (returnType.isArray()) {
				String arrType = returnType.getComponentType().getName() + "[]";
				System.out.print("" + modifier + " " + arrType + " " + method.getName() + "(");
			} else {
				System.out.print("" + modifier + " " + returnType.getName() + " " + method.getName() + "(");
			}
			Class[] paramTypes = method.getParameterTypes();
			for (int i = 0; i < paramTypes.length; i++) {
				if (i > 0) {
					System.out.print(",");
				}
				if (paramTypes[i].isArray()) {
					System.out.println(paramTypes[i].getComponentType().getName() + "[]");
				} else {
					System.out.print(paramTypes[i].getName());
				}
			}
			System.out.println(");");
		}
	}

	public static void test02() throws InstantiationException, IllegalAccessException, SecurityException,
			NoSuchMethodException, IllegalArgumentException, InvocationTargetException {
		// 反射调用方法，可以通过Method类的invoke方法实现动态方法的调用
		// public Object invoke(Object obj, Object... args)
		// 第一个参数代表对象
		// 第二个参数代表执行方法上的参数
		// 若反射要调用类的某个私有方法，可以在这个私有方法对应的Mehtod对象上先
		// 调用setAccessible(true)
		Class c1 = TestReflection.class;
		TestReflection t1 = (TestReflection) c1.newInstance(); // 利用反射来创
		// 建类的对象
		System.out.println("username == " + t1.username);
		System.out.println("password == " + t1.password);
		Method method = c1.getDeclaredMethod("setUserName", String.class);
		method.invoke(t1, "Java反射的学习");
		System.out.println("username == " + t1.username);
		method = c1.getDeclaredMethod("setPassWord", String.class);
		method.setAccessible(true);
		method.invoke(t1, "反射执行某个Private修饰的方法");
		System.out.println("password == " + t1.password);
	}
	
	
	public String addTwoString(String str1, String str2){
		System.out.println("*************** hahahahahah ***************");
		return str1+" "+str2;
	}
	
	
	public Object test3(String classPath, String functionName,Object [] args) 
			throws ClassNotFoundException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException{
		Object returnObj = null;
		Class<?> clazz = Class.forName(classPath);
		Object class1 = clazz.newInstance();
		Method [] methods = clazz.getDeclaredMethods();
		for(Method method : methods){
			if(functionName.equals(method.getName())){
				returnObj = method.invoke(class1, args);
			}
		}
		return returnObj;
	}

	public static void main(String[] args) throws ClassNotFoundException, SecurityException, IllegalArgumentException,
			InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
//		test01();
//		test02();
//		TestReflection testRefleact = new TestReflection();
//		System.out.println("testRefleact = "+testRefleact);
//		Object [] argsReflect = new Object[2];
//		argsReflect[0] = "hello";
//		argsReflect[1] = "world";
//		System.out.println("argsReflect = "+argsReflect);
//		Object result = testRefleact.test3("com.lyb.reflect.TestReflection","addTwoString",argsReflect);
//		System.out.println("result = "+result);
		TestReflection testRefleact = new TestReflection();
		Class<?> clazz = testRefleact.getClass();
		try {
			Field field = clazz.getField("grade");
			System.out.println("field = "+field);
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		}
		Field[] fields = clazz.getDeclaredFields();
		for(Field field : fields){
			if("password".equals(field.getName()))
			System.out.println("我获取到了私有的属性 password");
		}
	}
}
