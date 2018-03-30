package main.java.com.barclays.inventorymanagement.process.impl;

import java.math.BigDecimal;
import java.util.Map;
import main.java.com.barclays.inventorymanagement.model.InventoryManagement;
import main.java.com.barclays.inventorymanagement.process.InventoryManagementProcess;

public class UpdateQuantityProcessImpl  implements InventoryManagementProcess{

	public void maintainInventory(Map<String, InventoryManagement> inventoryItems, String[] instructions) {
		if (instructions[0].equals("updateBuy")) {
			InventoryManagement inventoryManagement = inventoryItems.get(instructions[1]);
			inventoryManagement.setItemName(instructions[1]);
			long newQuantity = inventoryManagement.getQuantity() + Long.valueOf(instructions[2]);
			inventoryManagement.setQuantity(newQuantity);
			
			inventoryItems.replace(inventoryManagement.getItemName(), inventoryManagement);
		} else if (instructions[0].equals("updateSell")) {
			InventoryManagement inventoryManagement = inventoryItems.get(instructions[1]);
			inventoryManagement.setItemName(instructions[1]);
			long newQuantity = inventoryManagement.getQuantity() - Long.valueOf(instructions[2]);
			inventoryManagement.setQuantity(newQuantity);
			
			BigDecimal profit = calculateProfit(inventoryManagement.getProfit(), inventoryManagement.getSellingPrice(), inventoryManagement.getCostPrice(), Long.valueOf(instructions[2]));
			inventoryManagement.setProfit(profit);
			
			inventoryItems.replace(inventoryManagement.getItemName(), inventoryManagement);
		}
	}
	
	private BigDecimal calculateProfit (BigDecimal currentProfit, BigDecimal sellingPrice, BigDecimal costPrice, Long noOfItemsSold) {
		BigDecimal profit = currentProfit.add(sellingPrice.subtract(costPrice).multiply(new BigDecimal(noOfItemsSold)));
		return profit;
	}
}
