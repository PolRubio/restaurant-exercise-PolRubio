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
        System.out.print("Quin és el nom del restaurant? ");
        return sc.nextLine();
    }

    private static void askCustomer(Restaurant restaurant) throws Exception {
        System.out.print("Que vols fer?\n1. Afegir una nova taula\n2. Eliminar una taula\n3. Mostrar informació del restaurant\n4. Sortir\nEscull una opció: ");
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
                System.out.println("Adeu!");
                cont = false;
                break;
            default:
                System.out.println("Opció incorrectas");
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
        System.out.print("Quina taula vols eliminar? ");
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
        System.out.print("Quantes persones sereu a la taula? ");
        return sc.nextInt();
    }
}
