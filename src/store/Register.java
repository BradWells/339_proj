package store;
import java.util.Scanner;

public class Register {
	
	private static final String DONE = "done";
	
	private static final String SALE = "sale";
	private static final String RENTAL = "rental";
	
	private static final String MOVIE = "movie";
	private static final String CD = "cd";
	private static final String DVD = "dvd";
	private static final String BOOK = "book";
	

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter customer name: ");
		String custName = scan.nextLine();
		Customer customer = new Customer(custName);
		
		boolean addMore = true;
		
		while(addMore == true){
			
			String title = getTitleFromInput(scan);
			Product product = getProductFromInput(scan, title);
			addCategoriesFromInput(scan, product);
			
			String saleRentalString;
			do{
				System.out.println("Sale or Rental? (sale\\rental):");
				saleRentalString = scan.nextLine();
			} while(!(saleRentalString.equals(SALE) || saleRentalString.equals(RENTAL)));
			
			if(saleRentalString.equals(SALE) ){
				
			} else if 
			System.out.println("Enter length of rental in days: ");
			int daysRented = scan.nextInt();
			scan.nextLine(); //Consume new line TODO make this better
			
			MovieRental rental = null;
			
			switch(cat){
				case CHILDRENS:
					rental = new ChildrensMovieRental(movieTitle, cat, daysRented);
					break;
				case REGULAR:
					rental = new RegularMovieRental(movieTitle, cat, daysRented);
					break;
				case NEW_RELEASE:
					rental = new NewMovieRental(movieTitle, cat, daysRented);
			}
			//TODO handle when rental is null
			customer.addRental(rental);
			
			//TODO clean this up to handle incorrect entry
			System.out.println("Add another rental? (yes\\no): ");
			if(!scan.nextLine().equals("yes")){
				addMore = false;
			}
		}
		
		Statement statement = new Statement(customer);
		
		System.out.println(statement.getReceipt());
		
		System.out.println(statement.getHTML());
		
		scan.close();
	}
	
	private static String getTitleFromInput(Scanner scan){
		System.out.println("Enter title: ");
		return scan.nextLine();
	}
	
	private static Product getProductFromInput(Scanner scan, String title){
		Product product = null;
		while(product != null){
			System.out.println("Enter product name: ");
			String productName = scan.nextLine();
			switch(productName){
				case MOVIE:
					product = new Movie(title);
					break;
				case CD:
					product = new CD(title);
					break;
				case DVD:
					product = new DVD(title);
					break;
				case BOOK:
					product = new BOOK(title);
					break;
			}
		}
		return product;
	}
	
	private static void addCategoriesFromInput(Scanner scan, Product product){
		System.out.println("Enter product category: ");
		
		String typeString = scan.nextLine();
		while(!typeString.equals(DONE)){
			product.addCategory(typeString);
		}
	}
	
}



