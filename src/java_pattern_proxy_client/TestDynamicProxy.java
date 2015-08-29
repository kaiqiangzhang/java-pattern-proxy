package java_pattern_proxy_client;

import java_pattern_proxy.DynamicProxy;
import java_pattern_proxy.inter.OrderApi;
import java_pattern_proxy_realobject.Order;

public class TestDynamicProxy {

	public static void main(String[] args) {
		//张凯强通过系统创建了一个订单
		Order orderZkq=new Order("老婆",10,"张凯强");
		//创建动态代理
		DynamicProxy dynamicProxy=new DynamicProxy();
		//将具体订单和动态代理关联起来,并返回操作接口
		OrderApi orderApi=dynamicProxy.getProxyInterface(orderZkq);
		//让李四去操作我的订单，看看，肯定没权限
		try {
			orderApi.setOrderNum(10, "李四");
			//让张凯强去操作订单
			orderApi.setOrderNum(10, "张凯强");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("sds");

	}

}
