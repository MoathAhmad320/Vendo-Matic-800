package com.techelevator;

import com.techelevator.view.Menu;
import com.techelevator.view.logs.VendingLog;

import java.sql.SQLOutput;

public class VendingMachineCLI {

	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String MAIN_MENU_Exit = "Exit";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE,MAIN_MENU_Exit };
private static final String PURCHASE_MENU_FEED_MONEY ="Feed Money";
private static final String PURCHASE_MENU_SELECT_PRODUCT = "Select Product";
private static final String PURCHASE_MENU_FINISH_TRANSACTION = "Finish Transaction";
private static final String[] PURCHASE_MENU_OPTIONS={PURCHASE_MENU_FEED_MONEY,PURCHASE_MENU_SELECT_PRODUCT,PURCHASE_MENU_FINISH_TRANSACTION};
	private Menu menu;

	public VendingMachineCLI(Menu menu) {
		this.menu = menu;
	}

	public void run() {
		VendingLog.setInventoryPath();
		Inventory.setInventoryPath();
		Inventory.restockInventory();
		while (true) {
			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

			if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
				Inventory.showInventory();
			} else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				String choice2 = (String) menu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS);
				if(choice.equals(PURCHASE_MENU_FEED_MONEY)) {

				}
				}
				else if (choice.equals(PURCHASE_MENU_SELECT_PRODUCT)){

				}
				else if (choice.equals(PURCHASE_MENU_FINISH_TRANSACTION)){

			}
		}
	}

	public static void main(String[] args) {

		Menu menu = new Menu(System.in, System.out);
		VendingMachineCLI cli = new VendingMachineCLI(menu);
		cli.run();
	}
}
