package com.techelevator;

import com.techelevator.view.*;
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
		VendingLog.setLoggerPath();
		Inventory.setInventoryPath();
		Inventory.restockInventory();
		boolean menuLoop = true;
		while (true) {
			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

			if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
				Inventory.showInventory();
			} else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
//				set loop for second menu(purchase menu)
//				plugged in appropriate methods for each menu slot
				System.out.println("Current Money Provided: $"+Money.displayCurrentAmount());
				menuLoop=true;
				while(menuLoop==true){
					String choice2 = (String) menu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS);
					System.out.println("Current Money Provided: $"+Money.displayCurrentAmount());
					if(choice2.equals(PURCHASE_MENU_FEED_MONEY)) {
						Money.feedBillsInput();
						Money.feedBillsProcessor(Money.getBillFed());
					}
					else if (choice2.equals(PURCHASE_MENU_SELECT_PRODUCT)){
						Inventory.showInventory();
						Inventory.setUserChoice();
						Inventory.purchase(Inventory.getUserChoice());
					}
					else if (choice2.equals(PURCHASE_MENU_FINISH_TRANSACTION)){
						Money.changeCalculator();
						Money.changePrinter();
						menuLoop=false;
//					added false boolean to return to previous menu

					}}
			} else if (choice.equals(MAIN_MENU_Exit)){
//				added exit code for whole program
				System.out.println("Enjoy your snacks and have a nice day!");
				return;
			}
		}}

	public static void main(String[] args) {


		Menu menu = new Menu(System.in, System.out);
		VendingMachineCLI cli = new VendingMachineCLI(menu);
		cli.run();
	}
}
