import java.util.ArrayList;

public class Restaurant {
    protected final int MAX_SPACE = 4;
    
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
        if(this.tables.size() == MAX_SPACE) {
            throw new Exception("There is no space, you have to wait to someone leave the restaurant");
        }
    }

    public void showTables() {
        tables.forEach(table -> System.out.println(table));
    }

    public void deleteTable(int numTable) {
        checkNumtable(numTable);
        tables.remove(numTable);
    }

    private void checkNumtable(int numTable) {
        if(numTable < 0 || numTable >= tables.size()) {
            throw new IllegalArgumentException("The table number is invalid");
        }
    }

    @Override
    public String toString() {
        return "The restaurant " + name + " has " + tables.size() + " tables and " + getNumCustomers() + " customers";
    }

}
