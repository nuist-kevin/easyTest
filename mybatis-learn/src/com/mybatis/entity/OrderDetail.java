package com.mybatis.entity;
/**
 * @ClassName: OrderDetail
 * @Description: 订单明细
 * @author: 蔡文
 */
public class OrderDetail {
    /** 主鍵，訂單明细表Id */
    private Integer id;
    /** 訂單Id */
    private Integer ordersId;
    /** 商品id */
    private Integer itemId;
    /** 商品购买数量 */
    private Integer itemsNum;
    // 明细对应的商品信息
    private Item item;
        //  getter and setter ......
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getOrdersId() {
		return ordersId;
	}
	public void setOrdersId(Integer ordersId) {
		this.ordersId = ordersId;
	}
	public Integer getItemId() {
		return itemId;
	}
	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}
	public Integer getItemsNum() {
		return itemsNum;
	}
	public void setItemsNum(Integer itemsNum) {
		this.itemsNum = itemsNum;
	}
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
    
    
}