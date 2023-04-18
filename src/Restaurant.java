import java.util.zip.CheckedInputStream;

public class Restaurant {
    protected String name;
    protected int numCustomers;
    protected final int MAX_SPACE = 24;

    public Restaurant(String name) {
        this.name = name;
        this.numCustomers = 0;
    }

    public String getName() {
        return name;
    }

    public int getNumCustomers() {
        return numCustomers;
    }

    public void setNumCustomers(int num) {
        this.numCustomers = num;
    }

    public void addNumCustomers(int num) throws Exception {
        checkAvalibeSpace(num);
        this.numCustomers += num;
    }
    
    public boolean hasSpaceAvalibe(){
        return this.numCustomers < MAX_SPACE;
    }

    public void checkAvalibeSpace(int askNumOfCustomers) throws Exception {
        if(this.numCustomers + askNumOfCustomers > 24) {
            throw new Exception("There is no space for this number of Customers");
        }
    }
}
