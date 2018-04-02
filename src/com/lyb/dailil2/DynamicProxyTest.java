package com.lyb.dailil2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxyTest {

	public static void main(String[] args) {
		
		//具体完成工作的类的实例
		Resource resourceImpl = new ResourceImpl();
		
        //HandlerImpl 实现了 InvocationHandler 接口，并能实现方法调用从代理类到委托类的分派转发
        InvocationHandler invocationHandler = new HandlerImpl(resourceImpl);
        
        //该方法用于为指定类装载器、一组接口及调用处理器生成动态代理类实例
        Resource dynamicProxy = (Resource) Proxy.newProxyInstance(
						resourceImpl.getClass().getClassLoader(),
						resourceImpl.getClass().getInterfaces(),
						invocationHandler);
        dynamicProxy.operationA();
        dynamicProxy.operationB();
    }
}


//原始接口
interface Resource {
    public void operationA();
    public void operationB();
}


//实现类，即委托类
class ResourceImpl implements Resource {
	 
    public void operationA() {
        System.out.println("A");
    }
    public void operationB() {
        System.out.println("B");
    }
}

class HandlerImpl implements InvocationHandler {
	
    // 委托类，用于真正执行分派转发过来的方法调用
    private Object object;
 
    HandlerImpl(Object object){
    	this.object = object;
    }
    
    // 该方法负责集中处理动态代理类上的所有方法调用。第一个参数既是代理类实例，第二个参数是被调用的方法对象
    // 第三个方法是调用参数。调用处理器根据这三个参数进行预处理或分派到委托类实例上发射执行
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    	System.out.println("方法名 method = "+method.getName());
    	if("operationA".equals(method.getName())){
    		System.out.println(" procy "+proxy.getClass());
        	System.out.println("  before invoke  ");
            return method.invoke(object, args);
    	}else{
    		return null;
    	}
    }
}