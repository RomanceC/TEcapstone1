package com.techelevator;

import com.techelevator.view.Menu;
import com.techelevator.view.Product;

import java.io.File;
import java.util.*;

import java.util.HashMap;
import java.util.Map;

public class VendingMachineCLI extends Menu {
	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String MAIN_MENU_EXIT="Exit";
	private static final String PURCHASE_MENU_OPTION1="Feed Money";
	private static final String PURCHASE_MENU_OPTION2="Select Product";
	private static final String PURCHASE_MENU_OPTION3="Finish Transaction";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE,MAIN_MENU_EXIT };
	private static final String[] PURCHASE_MENU_OPTIONS = { PURCHASE_MENU_OPTION1, PURCHASE_MENU_OPTION2,PURCHASE_MENU_OPTION3 };
private double amount=0;
	private List <Product> products;
	private Menu menu;
private List <CoinBank>coins;//Intialize

	public VendingMachineCLI(Menu menu) {
		this.menu = menu;
		this.products=new ArrayList<>();
		this.loadItems();
		//this.coins=coins;
	}



	public void run() {
		Scanner inputConsole=new Scanner(System.in);
		while (true) {
			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

			if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
				// display vending machine items
				int count=1;
				for (Product product:products){
					System.out.println(count+") "+product.getName());
				}
			} else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				// do purchase

				while(true){
			 choice= (String) menu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS);
			 if(choice.equals(PURCHASE_MENU_OPTION1)){
				 System.out.println("Please enter the amounts in dollars");
				amount+=inputConsole.nextDouble();
			 }else if(choice.equals(PURCHASE_MENU_OPTION2)){
				 // display list of products
				 for (int i = 0; i < products.size(); i++) {
					 Product product = products.get(i);

					 if (product.getQuantity()==0) {
						 System.out.println((i + 1) + ") " + product.getName() + " (SOLD OUT)");
					 } else {
						 System.out.println((i + 1) + ") " + product.getName() + " $" + product.getPrice());
					 }
				 }

			 }


			 }

			}else if (choice.equals(MAIN_MENU_EXIT)){
				break;
			}
		}

	}

	public static void main(String[] args) {
		Menu menu = new Menu(System.in, System.out);
		VendingMachineCLI cli = new VendingMachineCLI(menu);
		cli.run();
	}
	public void loadItems(){

		//Scanner in= new Scanner(System.in);

		System.out.println("Read from the file ");
		String fileName="vendingmachine.csv";
		File file =new File(fileName);
		try(Scanner fileScanner=new Scanner(file)){



			while (fileScanner.hasNextLine()){
				Product temp=null;
				String listItems=fileScanner.nextLine();
				String[] splitLine=listItems.split("|");
				String category = splitLine[3];
				String code=splitLine[0];
				String name=splitLine[1];
				double price =Double.parseDouble(splitLine[2]);
				temp=new Product(code,name,price,category,5);
				products.add(temp);

			}


		} catch(Exception exception) {
			System.err.println("Something went wrong");
		}
	}
	public void purchaseProcessFlow(){


	}
}
