import java.util.ArrayList;

public class Restaurant {
    protected final int MAX_SPACE = 24;
    
    protected String name;
    protected ArrayList<Table> tables = new ArrayList<Table>();

    public Restaurant(String name) {
        checkName(name);
        this.name = name;
    }

    private void checkName(String name2) {
        if(name2 == null || name2.isEmpty()) {
            throw new IllegalArgumentException("The name of the restaurant can't be empty");
        }
    }

    public String getName() {
        return name; 
    }

    public int getNumCustomers() {
        int numCustomers = 0;
        for (Table table : tables) {
            numCustomers += table.getNumCustomers();
        }
        return numCustomers;
    }

    public void addNewCustomers(int num) throws Exception {
        checkAvalibeSpace(num);
        tables.add(new Table(num));
    }   
    
    public boolean hasSpaceAvalibe(){
        return this.getNumCustomers() < MAX_SPACE;
    }

    public void checkAvalibeSpace(int askNumOfCustomers) throws Exception {
        if(this.getNumCustomers() + askNumOfCustomers > 24) {
            throw new Exception("There is no space for this number of Customers");
        }
    }

    public void showTables() {
        tables.forEach(table -> System.out.println(table));
    }

}
