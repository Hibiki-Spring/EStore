package com.briup.bean;

import java.util.Date;

/**
 * 订单项
 * @author briup
 *
 */
public class OrderLine {
	private long id;
	/*订单的数量*/
	private int num;
	/* 订单项维护的产品 */
	private Product product;
	/*订单项从属于的订单*/
	private Order order;
	
	/*添加到购物车的时间*/
	private Date addT;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public Date getAddT() {
		return addT;
	}
	public void setAddT(Date addT) {
		this.addT = addT;
	}
	
}
