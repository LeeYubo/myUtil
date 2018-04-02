package com.lyb.daili3;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;

import com.lyb.daili3.impl.ServiceImpl;

public class TestMain {

	public static void main(String[] args) {
//		System.setProperty("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
		AService service = new ServiceImpl();
		System.out.println("service instanceof AService : "+(service instanceof Object));
//		System.out.println("A------"+service.getClass());
		InvocationHandler handlerImpl = new HandlerImpl(service);
//		
//		System.out.println("System.getSecurityManager() = "+System.getSecurityManager());
//		
//		System.out.println("classloder = "+service.getClass());
//		Class<?>[] classArray = service.getClass().getInterfaces();
//		System.out.println(classArray.length);
//		
//		for(int i = 0;i<classArray.length;i++){
//			Class<?> class1 = classArray[i];
//			System.out.println(class1.getName());
//		}
//		
//		System.out.println("Interfaces = "+service.getClass().getInterfaces());
		Class<?> [] interfaces = service.getClass().getInterfaces();
		for(Class interf : interfaces){
			System.out.println("interf = "+interf);
		}
		System.out.println(service.getClass().getClassLoader());
//		
		AService dynamicService = (AService) Proxy.newProxyInstance(
									service.getClass().getClassLoader(), 
									service.getClass().getInterfaces(),
									handlerImpl);
		System.out.println("service instanceof Object : "+(dynamicService instanceof Object));
		System.out.println("service instanceof Proxy : "+(dynamicService instanceof Proxy));
		System.out.println("service instanceof AService : "+(dynamicService instanceof AService));
//		System.out.println("B------"+dynamicService.getClass());
//		Class<?>[] dynamicClassArray = dynamicService.getClass().getInterfaces();
//		for(Class t : dynamicClassArray){
//			System.out.println("t.name = "+t.getName());
//		}
//		Constructor<?>[] constructors = dynamicService.getClass().getDeclaredConstructors();
//		for(Constructor constructor : constructors){
//			System.out.println("构造方法名 = "+constructor.getName()); // 构造方法名
//			System.out.println("获取访问修饰符 = "+Modifier.toString(constructor.getModifiers()));
//			
//			Class[] paramTypes = constructor.getParameterTypes(); // 获取构造方法中的参数
//			for(Class c : paramTypes){
//				System.out.println("参数名 = "+c.getName());
//			}
//		}
		try {
			dynamicService.doSomthingA("liyubo");
		} catch (Exception e) {
			System.out.println("别报错嘛！");
		}
		
		/*System.out.println("生成的代理类的父类："+dynamicService.getClass().getSuperclass());
		System.out.println("生成的代理类实现的接口：");
		Class<?>[] intfs = dynamicService.getClass().getInterfaces();
		for(Class<?> intf : intfs){
			System.out.println(intf.getName());
		}*/
	}
}
