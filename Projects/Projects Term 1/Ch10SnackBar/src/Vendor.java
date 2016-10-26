/**
 * All work here is honestly obtained and is my own - Jacob Schellman
 * Date of Completion:  10/23/16
 * Assignment:  Chapter 10 Lab SnackBar
 *
 * General Description: This code works as intended and sets up a class that represents a vendor who sells an items for a certain price
 *                      it can sell these items for x stock, for x price, give change, keep track of how much money is deposited in the machine
 *                      and also keeps track of every sale any vendor ever had made.
 */
public class Vendor {
    // Fields:
    private static double totalSales; // An double representing the total number of sales all the Vendors have obtained
    private int deposit; // An instance variable representing the amount deposited into the vendor
    private int change; // The change which is deposit - price
    private int price; // The price, an instance variable
    private int stock; // The number of items left, an instance variable

    // Constructor:
    /**
     * Constructs a Vendor
     *
     * @param price the price of a single item in cents (int)
     * @param stock number of items to place in stock (int)
     */
    public Vendor(int price, int stock) {
        this.price = price;
        this.stock = stock;
        this.deposit = 0;
        this.change = 0;
    }

    // Accessors:
    /**
     * Sets the quantity of items in stock.
     *
     * @param qty number of items to place in stock (int)
     */
    public void setStock(int qty) {
        stock = qty;
    }
    /**
     * Returns the number of items currently in stock.
     *
     * @return number of items currently in stock (int)
     */
    public int getStock() {
        return stock;
    }
    /**
     * Returns the total money the machine has earned.
     *
     * @return dollar value of all of the sales the machine has made (double)
     */
    public static double getTotalSales() {
        double t = totalSales;
        totalSales = 0;
        return t;
    }
    /**
     * Returns the currently deposited amount (in cents).
     *
     * @return number of cents in the current deposit (int)
     */
    public int getDeposit() {
        return deposit;
    }
    /**
     * Returns and zeroes out the amount of change (from
     * the last sale or refund).
     *
     * @return number of cents in the current change (int)
     */
    public int getChange() {
        int t = change;
        change = 0;
        return t;
    }

    // Methods:
    /**
     * Implements a sale.  If there are items in stock and
     * the deposited amount is greater than or equal to
     * the single item price, then adjusts the stock and
     * calculates and sets change, sets deposit to 0 and
     * returns true; otherwise refunds the whole deposit
     * (moves it into change) and returns false.
     *
     * @return true for a successful sale, false otherwise (boolean)
     */
    public boolean makeSale() {
        if (getStock() > 0 && getDeposit() >= price) {
            totalSales += 100 / price;
            stock--;
            change = deposit - price;
            addMoney(-getDeposit());
            return true;
        }
        return false;
    }
    /**
     * Adds a specified amount (in cents) to the
     * deposited amount.
     *
     * @param number of cents to add to the deposit (int)
     */
    public void addMoney(int number) {
        deposit += number;
    }
}