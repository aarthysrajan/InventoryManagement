package main.java.com.barclays.inventorymanagement.process.impl;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.Map;
import main.java.com.barclays.inventorymanagement.model.InventoryManagement;
import main.java.com.barclays.inventorymanagement.process.InventoryManagementProcess;

public class GenerateReportProcessImpl  implements InventoryManagementProcess{

	@SuppressWarnings("rawtypes")
	public void maintainInventory(Map<String, InventoryManagement> inventoryItems, String[] instructions) {
		// Reports can be done on iReport(Jasper) or HTML report. Since we are using Java, we print with Sysout
		System.out.println("          					INVENTORY REPORT         				 ");
		System.out.println("Item Name			Bought At 		Sold At		AvailableQty		Value");
		System.out.println("---------			---------		-------		------------		-----");
		
		Iterator iterator = inventoryItems.entrySet().iterator();
		BigDecimal totalProfit = new BigDecimal(0);
		BigDecimal totalValue = new BigDecimal(0);
	    while (iterator.hasNext()) {
			Map.Entry inventoryItemMap = (Map.Entry)iterator.next();
	        InventoryManagement inventoryItem = (InventoryManagement)inventoryItemMap.getValue();
	        inventoryItem.setValue(inventoryItem.getCostPrice().multiply(new BigDecimal(inventoryItem.getQuantity())));
	        
	        totalValue = totalValue.add(inventoryItem.getValue());
	        totalProfit = (totalProfit.add(inventoryItem.getProfit()));
	        if (!iterator.hasNext()) {
	        	totalProfit = totalProfit.subtract(inventoryItem.getTotalProfit());
	        	inventoryItem.setTotalProfit(totalProfit);
	        }
	        if (!inventoryItem.isInActiveItem())
	        	System.out.println(inventoryItem.getItemName() + "				" + inventoryItem.getCostPrice() + "			" + inventoryItem.getSellingPrice() + "		" +	inventoryItem.getQuantity() + "			" +	inventoryItem.getValue());
	    }
	    System.out.println("---------------------------------------------------------------------------------------------------");
	    System.out.println("---------------------------------------------------------------------------------------------------");
	    System.out.println("Total value										" + totalValue);
	    System.out.println("Profit since previous report								" + totalProfit);
	}
}
