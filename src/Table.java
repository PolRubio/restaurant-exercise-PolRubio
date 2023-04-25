public class Table{
    static int TABLECOUNTER = 0;
    static int MAX_SPACE = 6;

    protected int numCustomers;
    protected int numTable;

    public Table() {
        this.numTable = TABLECOUNTER++;
    }
    
    public int getNumCustomers() {
        return numCustomers;
    }

    public int addCustomers(int numCustomers) {
        this.numCustomers = numCustomers;

        if(this.numCustomers > MAX_SPACE)
            this.numCustomers = MAX_SPACE;
        
        return numCustomers - MAX_SPACE;
    }
    
    public static boolean checkNumCustomers(int numCustomers) {
        return numCustomers > 0 && numCustomers < MAX_SPACE;
    }

    @Override
    public String toString() {
        return "Taula " + numTable + ": " + numCustomers + " persones";
    }
}
