package java_pattern_proxy.inter;

public interface OrderApi {
	String getProductName();
	void setProductName(String name);
	int getOrderNum();
	void setOrderNum(int orderNum,String user);
	String getOrderUser();
	void setOrderUser(String userName);
}
