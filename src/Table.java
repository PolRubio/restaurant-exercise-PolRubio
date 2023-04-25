public class Table{
    static int TABLECOUNTER = 0;

    protected final int MAX_SPACE = 6;
    protected int numCustomers;
    protected int numTable;

    public Table(int numCustomers) {
        checkNumCustomers(numCustomers);
        this.numCustomers = numCustomers;
        this.numTable = TABLECOUNTER++;
    }

    private void checkNumCustomers(int numCustomers) {
        if(numCustomers < 0 || numCustomers > MAX_SPACE) {
            throw new IllegalArgumentException("El nombre de persones no pot ser negatiu ni superior a " + MAX_SPACE + " persones");
        }
    }

    public int getNumCustomers() {
        return numCustomers;
    }
   
    @Override
    public String toString() {
        return "Taula " + numTable + ": " + numCustomers + " persones";
    }
}