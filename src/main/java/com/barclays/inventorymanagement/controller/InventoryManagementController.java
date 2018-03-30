package main.java.com.barclays.inventorymanagement.controller;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.logging.Logger;
import main.java.com.barclays.inventorymanagement.model.InventoryManagement;
import main.java.com.barclays.inventorymanagement.process.InventoryManagementProcess;
import main.java.com.barclays.inventorymanagement.process.impl.CreateItemProcessImpl;
import main.java.com.barclays.inventorymanagement.process.impl.DeleteItemProcessImpl;
import main.java.com.barclays.inventorymanagement.process.impl.GenerateReportProcessImpl;
import main.java.com.barclays.inventorymanagement.process.impl.UpdateQuantityProcessImpl;
import main.java.com.barclays.inventorymanagement.process.impl.UpdateSellingPriceProcessImpl;

public class InventoryManagementController  {

	private final static Logger logger = Logger.getLogger( InventoryManagementController.class.getName());
	
	public static void inventoryManagement(String inventoryManagmentCommand, Map<String, InventoryManagement> inventoryItems) {
		boolean invalidCommand = false;
		
		if (inventoryManagmentCommand != null && !inventoryManagmentCommand.isEmpty()) {
			
			String[] instructions = inventoryManagmentCommand.split("\\s+");
			
			if (instructions != null && instructions.length > 0) {
				InventoryManagementProcess inventoryManagementProcess = null;
				if (instructions[0].equals("create") && instructions.length == 4) {
					inventoryManagementProcess = new CreateItemProcessImpl();
				} else if (instructions[0].equals("delete") && instructions.length == 2) {
					inventoryManagementProcess = new DeleteItemProcessImpl();
				} else if ((instructions[0].equals("updateBuy") || instructions[0].equals("updateSell")) && instructions.length == 3) {
					inventoryManagementProcess = new UpdateQuantityProcessImpl();
				} else if (instructions[0].equals("updateSellPrice") && instructions.length == 3) {
					inventoryManagementProcess = new UpdateSellingPriceProcessImpl();
				} else if (instructions[0].equals("report")) {
					inventoryManagementProcess = new GenerateReportProcessImpl();
				}
				// Call the inventory management method
				inventoryManagementProcess.maintainInventory(inventoryItems, instructions);
			}
		} else 
			System.out.println("Invalid Command!");
		
		if (invalidCommand)
			System.out.println("Invalid Command!");
	}
	
	// This allows to test from the console
	public static void main (String args[]) {
		try {
			Scanner in = new Scanner(System.in);
			// TreeMap used to sort in alphabetical order 
			Map<String, InventoryManagement> inventoryItems = new TreeMap<String, InventoryManagement>();
			
			// Allow the user to enter multiple input commands
			while (true) {
				System.out.println("Enter a command(Type 'end' to exit): ");
				String inventoryManagementCommand = in.nextLine();
				
				if (inventoryManagementCommand.equals("end"))
					break;
				
				inventoryManagement(inventoryManagementCommand, inventoryItems);
			}
			in.close();	// Close the input stream
		} catch (Exception e) {
			logger.info("Inventory Management process failed with " + e.getMessage());
			e.printStackTrace();
		}
	}
}