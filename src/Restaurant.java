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
        checkAvalibeSpace(num);
        tables.add(new Table(num));
    }   
    
    public boolean hasSpaceAvalibe(){
        return this.tables.size() < MAX_SPACE;
    }

    public void checkAvalibeSpace(int askNumOfCustomers) throws Exception {
        if(this.tables.size() == MAX_SPACE) {
            throw new Exception("No hi ha espai disponible, el restaurant està ple, haureu d'esperar a que algú surti");
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
            throw new IllegalArgumentException("El numero de taula no pot ser negatiu ni superior a " + tables.size() + " taulas");
        }
    }

    @Override
    public String toString() {
        return "El restaurant " + name + " té " + tables.size() + " taules i " + getNumCustomers() + " clients";
    }

}
