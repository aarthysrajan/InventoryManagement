package main.java.com.barclays.inventorymanagement.process.impl;

import java.math.BigDecimal;
import java.util.Map;
import main.java.com.barclays.inventorymanagement.model.InventoryManagement;
import main.java.com.barclays.inventorymanagement.process.InventoryManagementProcess;

public class UpdateSellingPriceProcessImpl  implements InventoryManagementProcess{

	public void maintainInventory(Map<String, InventoryManagement> inventoryItems, String[] instructions) {
		InventoryManagement inventoryManagment = inventoryItems.get(instructions[1]);
		inventoryManagment.setItemName(instructions[1]);
		inventoryManagment.setNewSellingPrice(new BigDecimal(instructions[2]).setScale(2));
		
		BigDecimal profit = new BigDecimal(instructions[2]).subtract(inventoryManagment.getCostPrice());
		inventoryManagment.setProfit(profit);
		
		inventoryItems.put(inventoryManagment.getItemName(), inventoryManagment);
	}
}
