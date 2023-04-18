import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        Restaurant restaurant = new Restaurant(askRestaurantName());
        while(restaurant.hasSpaceAvalibe()){
            addCustomers(restaurant);
        }
    }

    private static int askNumOfCustomers() {
        System.out.print("How many Customers are in your table? ");
        return sc.nextInt();
    }

    public static String askRestaurantName() {
        System.out.print("What is the name of the restaurant? ");
        return sc.nextLine();
    }

    public static void addCustomers(Restaurant restaurant) throws Exception {
        if(restaurant.hasSpaceAvalibe()) {
            restaurant.addNewCustomers(askNumOfCustomers());
        }
        restaurant.showTables();
    }
}
