import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);
    private static boolean cont = true;

    public static void main(String[] args) throws Exception {
        Restaurant restaurant = new Restaurant(askRestaurantName());
        while(cont)
            askCustomer(restaurant);
    }

    public static String askRestaurantName() {
        System.out.print("What is the name of the restaurant? ");
        return sc.nextLine();
    }

    private static void askCustomer(Restaurant restaurant) throws Exception {
        System.out.print("\n\nWhat do you want to do?\n1. Add new table\n2. Delete a table\n3. Show Restaurant info\n4. Exit\nChoose an option: ");
        doAction(restaurant, sc.nextInt());
    }

    private static void doAction(Restaurant restaurant, int option) throws Exception {
        switch (option) {
            case 1:
                addCustomers(restaurant);
                break;
            case 2:
                deleteTable(restaurant);
                break;
            case 3:
                restaurantInfo(restaurant);
                break;
            case 4:
                System.out.println("Goodbye!");
                cont = false;
                break;
            default:
                System.out.println("Invalid option");
                break;
        }
    }

    private static void restaurantInfo(Restaurant restaurant) {
        System.out.println(restaurant);
    }

    private static void deleteTable(Restaurant restaurant) {
        restaurant.deleteTable(askTable(restaurant));
        restaurant.showTables();
    }

    private static int askTable(Restaurant restaurant) {
        System.out.print("Which table do you want to delete? ");
        return sc.nextInt();
    }

    public static void addCustomers(Restaurant restaurant){
        if(restaurant.hasSpaceAvalibe()) {
            try{
                restaurant.addNewCustomers(askNumOfCustomers());
                restaurant.showTables();
            }catch(Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
    
    private static int askNumOfCustomers() {
        System.out.print("How many Customers are in your new table? ");
        return sc.nextInt();
    }
}
