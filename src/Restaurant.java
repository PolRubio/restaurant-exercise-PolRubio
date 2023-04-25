import java.util.ArrayList;

public class Restaurant {
    protected final int MAX_SPACE = 4;
    
    protected String name;
    protected ArrayList<Table> tables = new ArrayList<Table>();

    public Restaurant(String name) {
        checkName(name);
        this.name = name;
    }

    private void checkName(String name) {
        if(name == null || name.isEmpty()) {
            throw new IllegalArgumentException("El nom del restaurant no pot ser null ni buit");
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
        if(num > 0){
            checkAvailableSpace();
            tables.add(new Table());
            // addNewCustomers(tables.get(-1).addCustomers(num));
            addNewCustomers(tables.get(tables.size()-1).addCustomers(num));
        }
    }   
    
    public boolean hasSpaceAvailable(){
        return this.tables.size() < MAX_SPACE;
    }

    public void checkAvailableSpace() throws Exception {
        if(this.tables.size() == MAX_SPACE) {
            throw new Exception("No hi ha espai disponible, el restaurant està ple, haureu d'esperar a que algú surti");
        }
    }

    public String showTables() {
        String tablesString = "";
        for (Table table : tables)
            tablesString += table;
        return tablesString;
    }

    public void deleteTable(int numTable) {
        checkNumTable(numTable);
        tables.remove(numTable);
    }

    private void checkNumTable(int numTable) {
        if(numTable < 0 || numTable >= tables.size()) {
            throw new IllegalArgumentException("El numero de taula no pot ser negatiu ni superior a " + tables.size() + " taulas");
        }
    }

    @Override
    public String toString() {
        return "El restaurant " + name + " té " + tables.size() + " taules i " + getNumCustomers() + " clients";
    }
}
