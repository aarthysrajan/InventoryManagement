package main.java.com.barclays.inventorymanagement.model;

import java.math.BigDecimal;

public class InventoryManagement {

	private String itemName;
	private BigDecimal costPrice;
	private BigDecimal sellingPrice;
	private BigDecimal newSellingPrice;
	private long quantity;
	private BigDecimal profit = new BigDecimal(0);
	private BigDecimal value;
	private boolean inActiveItem = false;
	private BigDecimal totalProfit = new BigDecimal(0);
	
	public String getItemName() {
		return itemName;
	}
	
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	
	public BigDecimal getCostPrice() {
		return costPrice;
	}
	
	public void setCostPrice(BigDecimal costPrice) {
		this.costPrice = costPrice;
	}
	
	public BigDecimal getSellingPrice() {
		return sellingPrice;
	}
	
	public void setSellingPrice(BigDecimal sellingPrice) {
		this.sellingPrice = sellingPrice;
	}
	
	public long getQuantity() {
		return quantity;
	}
	
	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getProfit() {
		return profit;
	}

	public void setProfit(BigDecimal profit) {
		this.profit = profit;
	}

	public BigDecimal getValue() {
		return value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}

	public BigDecimal getNewSellingPrice() {
		return newSellingPrice;
	}

	public void setNewSellingPrice(BigDecimal newSellingPrice) {
		this.newSellingPrice = newSellingPrice;
	}

	public boolean isInActiveItem() {
		return inActiveItem;
	}

	public void setInActiveItem(boolean inActiveItem) {
		this.inActiveItem = inActiveItem;
	}

	public BigDecimal getTotalProfit() {
		return totalProfit;
	}

	public void setTotalProfit(BigDecimal totalProfit) {
		this.totalProfit = totalProfit;
	}
}
