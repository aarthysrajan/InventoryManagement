package main.java.com.barclays.inventorymanagement.process;

import java.util.Map;
import main.java.com.barclays.inventorymanagement.model.InventoryManagement;

public interface InventoryManagementProcess {

	public void maintainInventory(Map<String, InventoryManagement> inventoryItems, String[] instructions);
}
