package java_pattern_proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import java_pattern_proxy.inter.OrderApi;
import java_pattern_proxy_realobject.Order;

public class DynamicProxy implements InvocationHandler{
	/**
	 * 被代理对象
	 * 2015-07-11 20:53:09
	 * @author kris.zhang
	 */
	private OrderApi order=null;

	/**
	 * 
	 * @param order 具体的订单对象，相当于具体的目标对象
	 * @return 绑定好代理和目标对象后的代理对象接口
	 */
	public OrderApi getProxyInterface(Order order){
		//设置被代理的对象，好方便invoke里的操作
		this.order=order;
		//把真正的订单对象和动态代理关联起来
		OrderApi orderApi=(OrderApi)Proxy.newProxyInstance(order.getClass().getClassLoader(), order.getClass().getInterfaces(), this);
		return orderApi;
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		//如果调用的是setXXX方法就需要检查权限
		if(method.getName().startsWith("set")){
			//如果不是创建人就不能修改订单
			if(order.getOrderUser()!=null  && order.getOrderUser().equals(args[1])){
				return method.invoke(order, args);
			}else{
				System.out.println("对不起！"+args[1]+" 你无权修改订单中得内容！");
			}
		}else{//不是调用的setXXX方法就继续运行
			return  method.invoke(order, args);
		}
		return null;
	}

}
