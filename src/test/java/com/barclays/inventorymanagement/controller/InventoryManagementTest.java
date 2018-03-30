package test.java.com.barclays.inventorymanagement.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.junit.Test;

import main.java.com.barclays.inventorymanagement.controller.InventoryManagementController;
import main.java.com.barclays.inventorymanagement.model.InventoryManagement;

public class InventoryManagementTest {

	@SuppressWarnings("static-access")
	@Test
	public void testInventoryManagement() {
		List<String> inventoryManagementCommands = new ArrayList<String>();
		inventoryManagementCommands.add("create Book01 10.50 13.79");
		inventoryManagementCommands.add("create Food01 1.47 3.98");
		inventoryManagementCommands.add("create Med01 30.63 34.29");
		inventoryManagementCommands.add("create Tab01 57.00 84.98");
		inventoryManagementCommands.add("updateBuy Tab01 100");
		inventoryManagementCommands.add("updateSell Tab01 2");
		inventoryManagementCommands.add("updateBuy Food01 500");
		inventoryManagementCommands.add("updateBuy Book01 100");
		inventoryManagementCommands.add("updateBuy Med01 100");
		inventoryManagementCommands.add("updateSell Food01 1");
		inventoryManagementCommands.add("updateSell Food01 1");
		inventoryManagementCommands.add("updateSell Tab01 2");
		inventoryManagementCommands.add("report");
		inventoryManagementCommands.add("delete Book01");
		inventoryManagementCommands.add("updateSell Tab01 5");
		inventoryManagementCommands.add("create Mobile01 10.51 44.56");
		inventoryManagementCommands.add("updateBuy Mobile01 250");
		inventoryManagementCommands.add("updateSell Food01 5");
		inventoryManagementCommands.add("updateSell Mobile01 4");
		inventoryManagementCommands.add("updateSell Med01 10");
		inventoryManagementCommands.add("report");
		
		Map<String, InventoryManagement> inventoryItems = new TreeMap<String, InventoryManagement>();
		for (String inventoryManagmentCommand : inventoryManagementCommands) {
			// Call the inventory management method
			InventoryManagementController inventoryManagementProcess = new InventoryManagementController();
			inventoryManagementProcess.inventoryManagement(inventoryManagmentCommand, inventoryItems);
		}
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testInventoryManagementExtension() {
		List<String> inventoryManagementCommands = new ArrayList<String>();
		inventoryManagementCommands.add("create Book01 10.50 13.79");
		inventoryManagementCommands.add("create Food01 1.47 3.98");
		inventoryManagementCommands.add("create Med01 30.63 34.29");
		inventoryManagementCommands.add("create Tab01 57.00 84.98");
		inventoryManagementCommands.add("updateBuy Tab01 100");
		inventoryManagementCommands.add("updateSell Tab01 2");
		inventoryManagementCommands.add("updateBuy Food01 500");
		inventoryManagementCommands.add("updateBuy Book01 100");
		inventoryManagementCommands.add("updateBuy Med01 100");
		inventoryManagementCommands.add("updateSell Food01 1");
		inventoryManagementCommands.add("updateSell Food01 1");
		inventoryManagementCommands.add("updateSell Tab01 2");
		inventoryManagementCommands.add("report");
		inventoryManagementCommands.add("delete Book01");
		inventoryManagementCommands.add("updateSell Tab01 5");
		inventoryManagementCommands.add("create Mobile01 10.51 44.56");
		inventoryManagementCommands.add("updateBuy Mobile01 250");
		inventoryManagementCommands.add("updateSell Food01 5");
		inventoryManagementCommands.add("updateSell Mobile01 4");
		inventoryManagementCommands.add("updateSell Med01 10");
		inventoryManagementCommands.add("report");
		inventoryManagementCommands.add("updateSellPrice Med01 30.29");
		inventoryManagementCommands.add("updateSellPrice Med01 30.29");
		inventoryManagementCommands.add("report");
		
		Map<String, InventoryManagement> inventoryItems = new TreeMap<String, InventoryManagement>();
		for (String inventoryManagmentCommand : inventoryManagementCommands) {
			// Call the inventory management method
			InventoryManagementController inventoryManagementProcess = new InventoryManagementController();
			inventoryManagementProcess.inventoryManagement(inventoryManagmentCommand, inventoryItems);
		}
	}
}
