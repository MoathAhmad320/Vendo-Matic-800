package com.techelevator;

import com.techelevator.view.*;
import com.techelevator.view.Logs.VendingLog;

public class VendingMachineCLI {

	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String MAIN_MENU_Exit = "Exit";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE,MAIN_MENU_Exit," "};
	private static final String PURCHASE_MENU_FEED_MONEY ="Feed Money";
	private static final String PURCHASE_MENU_SELECT_PRODUCT = "Select Product";
	private static final String PURCHASE_MENU_FINISH_TRANSACTION = "Finish Transaction";
	private static final String[] PURCHASE_MENU_OPTIONS={PURCHASE_MENU_FEED_MONEY,PURCHASE_MENU_SELECT_PRODUCT,PURCHASE_MENU_FINISH_TRANSACTION};
	private Menu menu;

	public VendingMachineCLI(Menu menu) {
		this.menu = menu;
	}

	public void run() {
		boolean menuLoop = true;
		while (true) {
			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

			if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
				Inventory.showInventory();
			} else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				System.out.println("Current Money Provided: $" + Money.displayCurrentAmount());
				menuLoop = true;
				while (menuLoop == true) {
					String choice2 = (String) menu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS);
					System.out.println("Current Money Provided: $" + Money.displayCurrentAmount());
					if (choice2.equals(PURCHASE_MENU_FEED_MONEY)) {
						Money.feedBillsInput();
						Money.feedBillsProcessor(Money.getBillFed());
					} else if (choice2.equals(PURCHASE_MENU_SELECT_PRODUCT)) {
						Inventory.showInventory();
						Inventory.setUserChoice();
						Inventory.purchase(Inventory.getUserChoice());
					} else if (choice2.equals(PURCHASE_MENU_FINISH_TRANSACTION)) {
						Money.changeDivider();
						Money.changePrinter();
						menuLoop = false;

					}
				}
			}else if (choice.equals(" ")){
				Inventory.salesReportMapping();
				VendingLog.salesReport();
				System.out.println("A new Sales Report Log has been generated.");
		}else if (choice.equals(MAIN_MENU_Exit)){

				System.out.println("Enjoy your snacks and have a nice day!");
				return;
			}
		}}

	public static void main(String[] args) {
		VendingLog.setLoggerPath();
		VendingLog.setSaleReportDirectoryFilePath();
		Inventory.setInventoryPath();
		Inventory.restockInventory();
		System.out.print("\n"+"***********WELCOME***********"+"\n");
		Menu menu = new Menu(System.in, System.out);
		VendingMachineCLI cli = new VendingMachineCLI(menu);
		cli.run();
	}
}
