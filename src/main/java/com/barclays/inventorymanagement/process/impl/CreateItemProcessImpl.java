package main.java.com.barclays.inventorymanagement.process.impl;

import java.math.BigDecimal;
import java.util.Map;
import main.java.com.barclays.inventorymanagement.model.InventoryManagement;
import main.java.com.barclays.inventorymanagement.process.InventoryManagementProcess;

public class CreateItemProcessImpl  implements InventoryManagementProcess{

	public void maintainInventory(Map<String, InventoryManagement> inventoryItems, String[] instructions) {
		InventoryManagement inventoryManagment = new InventoryManagement();
		inventoryManagment.setItemName(instructions[1]);
		inventoryManagment.setCostPrice(new BigDecimal(instructions[2]).setScale(2));
		inventoryManagment.setSellingPrice(new BigDecimal(instructions[3]).setScale(2));
		
		inventoryItems.put(inventoryManagment.getItemName(), inventoryManagment);
	}
}
