package store;
import java.util.Scanner;

public class Register {
	
	private static final String DONE = "done";
	
	private static final String SALE = "sale";
	private static final String RENTAL = "rental";
	
	private static final String Cd = "Cd";
	private static final String CD = "cd";
	private static final String DVD = "dvd";
	private static final String BOOK = "book";
	

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter customer name: ");
		String custName = scan.nextLine();
		Customer customer = new Customer(custName);
		
		boolean addMore = true;
		
		ProductDatabase productDb = ProductDatabase.getDatabase();
		productDb.generateProducts();
		
		while(addMore == true){
			
			Product prod = getProductFromInput(productDb, scan);
			
			String saleRentalString = getTransactionFromInput(scan);
			
			if(saleRentalString.equalsIgnoreCase(SALE) ){
				Sale sale = new Sale(prod);
				
				customer.addSale(sale);
				
			} else if(saleRentalString.equalsIgnoreCase(RENTAL)){
				System.out.println("Enter length of rental in days: ");
				int daysRented = scan.nextInt();
				scan.nextLine(); //Consume new line TODO make this better
				
				Rental rental = new Rental(prod, daysRented);
				
				customer.addRental(rental);
			}
			
			//TODO clean this up to handle incorrect entry
			System.out.println("Add another item? (yes\\no): ");
			if(!scan.nextLine().equals("yes")){
				addMore = false;
			}
		}
		
		Statement statement = new Statement(customer);
		
		System.out.println(statement.getReceipt());
		
		System.out.println(statement.getHTML());
		
		scan.close();
	}
	
	private static String getTransactionFromInput(Scanner scan){
		String saleRentalString;
		do{
			System.out.println("Sale or Rental? (sale\\rental):");
			saleRentalString = scan.nextLine();
		} while(!(saleRentalString.equals(SALE) || saleRentalString.equals(RENTAL)));
		return saleRentalString;
	}
	
	private static Product getProductFromInput(ProductDatabase productDb, Scanner scan){
		Product prod = null;
		while(prod == null){
			System.out.println("Enter product id: ");
			int id = scan.nextInt();
			scan.nextLine(); //Consume new line TODO make this better
			
			prod = productDb.getProduct(id);
		}
		return prod;
	}

}



