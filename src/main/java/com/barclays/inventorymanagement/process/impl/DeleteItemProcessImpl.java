package main.java.com.barclays.inventorymanagement.process.impl;

import java.math.BigDecimal;
import java.util.Map;
import main.java.com.barclays.inventorymanagement.model.InventoryManagement;
import main.java.com.barclays.inventorymanagement.process.InventoryManagementProcess;

public class DeleteItemProcessImpl  implements InventoryManagementProcess{

	public void maintainInventory(Map<String, InventoryManagement> inventoryItems, String[] instructions) {
		InventoryManagement inventoryManagment = inventoryItems.get(instructions[1]);
		inventoryManagment.setItemName(instructions[1]);
		
		BigDecimal profit = inventoryManagment.getProfit().subtract(inventoryManagment.getCostPrice().multiply(new BigDecimal(inventoryManagment.getQuantity())));
		inventoryManagment.setProfit(profit);
		inventoryManagment.setInActiveItem(true);	// Performing soft delete
	}
}
