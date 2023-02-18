package com.techelevator;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.techelevator.view.Menu;
import com.techelevator.view.Product;

public class VendingMachineCLI {

private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
private static final String MAIN_MENU_EXIT="Exit";
private static final String PURCHASE_MENU_OPTION1="Feed Money";
private static final String PURCHASE_MENU_OPTION2="Select Product";
private static final String PURCHASE_MENU_OPTION3="Finish Transaction";
private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE,MAIN_MENU_EXIT };
private static final String[] PURCHASE_MENU_OPTIONS = { PURCHASE_MENU_OPTION1, PURCHASE_MENU_OPTION2,PURCHASE_MENU_OPTION3 };
private Double amount=0.0;
private List <Product> products;
private Menu menu;  
private DateFormat dateFormat;
private Date date;
private FileWriter fWriter = null;
private String fileName = null;
private File file = null;
public VendingMachineCLI(Menu menu) {
this.menu = menu;
this.products=new ArrayList<>();
this.loadItems();
dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss a");
date = new Date();
fileName = "Log.txt";
file = new File(fileName);
try {
fWriter = new FileWriter(file,true);
} catch (IOException e) {
e.printStackTrace();
}

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
count++;
}
} else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
// do purchase

while(true){
 choice= (String) menu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS);
 if(choice.equals(PURCHASE_MENU_OPTION1)){
 System.out.println("Please enter the amount in whole amount like $1 $2 $5 \n ");
 double credit=(double)inputConsole.nextInt();
amount+=credit;

System.out.println(String.format("$%.2f",credit)+" added");
System.out.println(String.format("Total balance : $%.2f", amount));
try {
fWriter.write(dateFormat.format(date)+String.format(" FEED MONEY $%.2f $%.2f",credit,amount )+"\n");
}catch(IOException e) {
e.printStackTrace();
}
 }else if(choice.equals(PURCHASE_MENU_OPTION2)){
 // display list of products
 int count=1;
 for (Product product:products){
 System.out.println(product.getCode()+") "+product.getName());
 count++;
 }
 System.out.println("please enter the product code \n");

 choice=inputConsole.next();
 boolean validItem=false;
 for (Product product:products){
if(product.getCode().equals(choice)) {
validItem=true;
if(product.getQuantity()>0){
if(amount>=product.getPrice()){
product.setQuantity(product.getQuantity()-1);
//double old_amount=amount;
amount-= product.getPrice();
try {
fWriter.write(dateFormat.format(date)+String.format(" %s $%.2f $%.2f",product.getName(),product.getPrice(),amount )+"\n");
}catch(IOException e) {
e.printStackTrace();
}

System.out.println(String.format("$%.2f",product.getPrice())+" deducted");
System.out.println(String.format("Remaining balance : $%.2f", amount));
switch (product.getCateogry()) {
case "Chip":
System.out.println("Crunch Crunch, Yum!");
break;
case "Candy":
System.out.println("Munch Munch, Yum!");
break;
case "Drink":
System.out.println("Glug Glug, Yum!");
break;
case "Gum":
System.out.println("Chew Chew, Yum!");
break;
default:
System.out.println("Remaining balance : $"+amount);
}
}else{
System.out.println("Insufficient balance ");
System.out.println(String.format("Available balance : $%.2f", amount));
System.out.println(product.getName()+"'s price : "+product.getPrice());
System.out.println("Please load more money to buy this product\n");
}
}else{

 System.out.println("Sorry !! "+ product.getName()+" Out of stock. ");
}

}

 }
 if(!validItem) {
 System.out.println("Invalid Product : "+choice);
System.out.println("Please enter any of valid Product like A1 A2 ..\n");

 }

 }else if ((choice.equals(PURCHASE_MENU_OPTION3))){
 //Finish Transaction

String tempArray[]=String.format("%.2f", amount).split("\\.");
int pennies = Integer.parseInt(tempArray[1]);
int dollars = Integer.parseInt(tempArray[0]);
int quarter=(int)pennies/25;
pennies%=25;
int dime=(int)pennies/10;
pennies%=10;
int nickel=(int)pennies/5;
pennies%=5;

System.out.println(String.format("Available balance : $%.2f", amount));
System.out.print("Returning ");
if(dollars>0)
System.out.print(dollars +" dollar/s");
if(quarter>0)
System.out.print(" and "+quarter +" quarter/s");
if(dime>0)
System.out.print(" and "+dime +" dime/s");
if(nickel>0)
System.out.print(" and "+nickel +" nickel/s");
if(pennies>0)
System.out.print(" and "+pennies +" penny/s");
System.out.println(System.lineSeparator());
break;
 }


 }

}else if (choice.equals(MAIN_MENU_EXIT)){
System.out.println("Exiting...");
try {
 fWriter.flush();
 fWriter.close();
}catch (IOException e) {
e.printStackTrace();
}
System.out.println("Thank You!");
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
String[] splitLine=listItems.split("\\|");
String category = splitLine[3];
String code=splitLine[0];
String name=splitLine[1];
double price =Double.parseDouble(splitLine[2]);
temp=new Product(code,name,price,category,5);
products.add(temp);

}


} catch(Exception exception) {
exception.printStackTrace();
System.err.println("Something went wrong");
}
}
public void purchaseProcessFlow(){


}
}
