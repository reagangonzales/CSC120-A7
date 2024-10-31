/* This is a stub for the Cafe class */
/**
 * The Cafe class represents a cafe, a type of Building, with an inventory of coffee, sugar packets, creams, and cups.
 * This class allows the sale of coffee with customization of ingredients, and handles restocking when supplies run low.
 */
public class Cafe extends Building {
    private int nCoffeeOunces;  // coffee inventory in ounces
    private int nSugarPackets;  // sugar packets inventory
    private int nCreams;        // cream inventory
    private int nCups;          // cups inventory

    /**
     * Constructor for creating a Cafe with specified coffee, sugar, cream, and cup inventory levels.
     *
     * @param name          The name of the cafe
     * @param address       The address of the cafe
     * @param nFloors       The number of floors in the cafe
     * @param coffeeOunces  Initial coffee inventory in ounces
     * @param sugarPackets  Initial sugar packets inventory
     * @param creams        Initial cream inventory
     * @param cups          Initial cup inventory
     */
    public Cafe(String name, String address, int nFloors, int coffeeOunces, int sugarPackets, int creams, int cups) {
        super(name, address, nFloors); // call the constructor of Building
        this.nCoffeeOunces = coffeeOunces;
        this.nSugarPackets = sugarPackets;
        this.nCreams = creams;
        this.nCups = cups;
    }

    /**
     * Sells a coffee of specified size, sugar packets, and creams.
     * Restocks inventory if any ingredient is insufficient.
     *
     * @param size          The size of the coffee in ounces
     * @param nSugarPackets The number of sugar packets for the coffee
     * @param nCreams       The number of cream servings for the coffee
     */
    public void sellCoffee(int size, int nSugarPackets, int nCreams) {
        // Check if there are enough supplies, restock if not
        if (this.nCoffeeOunces < size || this.nSugarPackets < nSugarPackets || this.nCreams < nCreams || this.nCups < 1) {
            restock(100, 50, 30, 10);  // arbitrary restocking values
        }
        // Deduct inventory
        this.nCoffeeOunces -= size;
        this.nSugarPackets -= nSugarPackets;
        this.nCreams -= nCreams;
        this.nCups -= 1;
    }

    /**
     * Restocks the cafe's inventory with the specified quantities of coffee, sugar packets, creams, and cups.
     *
     * @param nCoffeeOunces  Amount of coffee to add in ounces
     * @param nSugarPackets  Amount of sugar packets to add
     * @param nCreams        Amount of creams to add
     * @param nCups          Amount of cups to add
     */
    private void restock(int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups) {
        this.nCoffeeOunces += nCoffeeOunces;
        this.nSugarPackets += nSugarPackets;
        this.nCreams += nCreams;
        this.nCups += nCups;
        System.out.println("Cafe restocked!");
    }

    /**
     * Main method to demonstrate the functionality of the Cafe class.
     *
     * @param args Command-line arguments (not used)
     */
    public static void main(String[] args) {
        Cafe myCafe = new Cafe("Campus Cafe", "10 College Lane", 1, 100, 50, 30, 10);
        myCafe.sellCoffee(12, 2, 3);
        myCafe.sellCoffee(16, 3, 2);
    }
}


