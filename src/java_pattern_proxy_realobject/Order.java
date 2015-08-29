package java_pattern_proxy_realobject;

import java_pattern_proxy.inter.OrderApi;

public class Order implements OrderApi{
	private int mOrderNum;
	private String mProductName;
	private String mOrderUser;

	public Order(String productName,int orderNum,String ordertUser){
		this.mProductName=productName;
		this.mOrderNum=orderNum;
		this.mOrderUser=ordertUser;
	}
	
	@Override
	public String getProductName() {
		// TODO Auto-generated method stub
		System.out.println();
		return mProductName;
		
	}

	@Override
	public void setProductName(String name) {
		// TODO Auto-generated method stub
		this.mProductName=name;
	}

	@Override
	public int getOrderNum() {
		// TODO Auto-generated method stub
		return mOrderNum;
	}

	@Override
	public void setOrderNum(int orderNum, String user) {
		// TODO Auto-generated method stub
		System.out.println("修改订单成功！修改后的数量为："+orderNum);
		this.mOrderNum=orderNum;
	}

	@Override
	public String getOrderUser() {
		// TODO Auto-generated method stub
		return mOrderUser;
	}

	@Override
	public void setOrderUser(String userName) {
		// TODO Auto-generated method stub
		this.mOrderUser=userName;
	}

}
