public class Table{
    static int TABLECOUNTER = 0;

    protected final int MAX_SPACE = 6;
    protected int numCustomers;
    protected int numTable;

    public Table(int numCustomers) {
        this.numCustomers = numCustomers;
        this.numTable = TABLECOUNTER++;
    }

    public String toString() {
        return "Mesa " + numTable + ": " + numCustomers + " persones";
    }

    public int getNumCustomers() {
        return numCustomers;
    }

}