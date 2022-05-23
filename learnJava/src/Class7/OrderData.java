package Class7;

import java.util.List;

public class OrderData {

	public OrderData(String orderNo, String cust_name, String cust_mobile, List<Integer> orderitem) {
//		super();
		this.orderNo = orderNo;
		this.cust_name = cust_name;
		this.cust_mobile = cust_mobile;
		this.orderitem = orderitem;
	}

	public OrderData() {
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public String getCust_name() {
		return cust_name;
	}

	public void setCust_name(String cust_name) {
		this.cust_name = cust_name;
	}

	public String getCust_mobile() {
		return cust_mobile;
	}

	public void setCust_mobile(String cust_mobile) {
		this.cust_mobile = cust_mobile;
	}

//	public String getMenuID() {
//		return menuID;
//	}
//	public void setMenuID(String menuID) {
//		this.menuID = menuID;
//	}
	public List<Integer> getOrderitem() {
		return orderitem;
	}

	public void setOrderitem(List<Integer> orderitem) {
		this.orderitem = orderitem;
	}

	public double getTotal_amt() {
		return total_amt;
	}

	public void setTotal_amt(double total_amt) {
		this.total_amt = total_amt;
	}

	private String orderNo;
	private String cust_name;
	private String cust_mobile;
//	private String menuID;
	private List<Integer> orderitem;
	private double total_amt;


}
