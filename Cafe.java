/* This is a stub for the Cafe class */
/**
 * The Cafe class represents a cafe, a type of Building, with an inventory of coffee, sugar packets, creams, and cups.
 * This class allows the sale of coffee with customization of ingredients, and handles restocking when supplies run low
 */
public class Cafe extends Building {
    private int nCoffeeOunces;  // coffee inventory in ounces
    private int nSugarPackets;  // sugar packets inventory
    private int nCreams;        // cream inventory
    private int nCups;          // cups inventory

    /**
     * Constructor for creating a cafe with specified coffee, sugar, cream, and cup inventory levels
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
        System.out.println("You have built a cafe: ☕");
    }

    /**
     * Overloads Cafe Constructor
     * Sets up default cafe, Neilson Library
     **/
    public Cafe(){
        this("Neilson Library", "7 Nielson Dr", 2, 30, 30, 30, 30);
    }

    /**
     * Sells a coffee of specified size, sugar packets, and creams
     * Restocks inventory if any ingredient is insufficient
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
     * Overloads method to sell coffee with default 1 sugar packet and 1 cream serving.
     * @param size The size of the coffee in ounces
     */
    public void sellCoffee(int size) {
        sellCoffee(size, 1, 1); // Defaults to 1 sugar and 1 cream
    }

    /**
     * Restocks the cafe's inventory with the specified quantities of coffee, sugar packets, creams, and cups
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

    /* 
     * Overides showOptions() method in building class 
     */    
    public void showOptions() {
        super.showOptions();
        System.out.println("Available options at " + this.name + ":\n + sellCoffee() \n + restock()");
    }

    /*
     * Overrides goToFloor method in building class
     * Restricts customer access to upper floors
     * @param floorNum The floor number to navigate to 
     */
    public void goToFloor(int floorNum) {
        if (floorNum < 2){
            if (this.activeFloor == -1) {
                throw new RuntimeException("You are not inside the Library. Must call enter() before navigating between floors.");
            }
            if (floorNum < 1 || floorNum > this.nFloors) {
                throw new RuntimeException("Invalid floor number. Valid range for this Cafe is 1-" + this.nFloors +".");
            }
            System.out.println("You are now on floor #" + floorNum + " of " + this.name);
            this.activeFloor = floorNum;
        } else {
            System.out.println("Sorry, the upper levels are reserved for staff.");
        }
    }

    /**
     * Main method to demonstrate the functionality of the Cafe class
     *
     * @param args Command-line arguments (not used)
     */
    public static void main(String[] args) {
        // Cafe myCafe = new Cafe("Campus Cafe", "10 College Lane", 1, 100, 50, 30, 10);
        // myCafe.sellCoffee(12, 2, 3);
        // myCafe.sellCoffee(16, 3, 2);
        Cafe myCafe = new Cafe("Reagan's Cafe","4180 Siena Dr", 1, 100, 50, 30, 10);
        
        // Print details of Cafe object
        System.out.println(myCafe);
        
        // Display available options
        myCafe.showOptions();

        // Display initial inventory
        System.out.println("Original inventory | Coffee oz: " + myCafe.nCoffeeOunces + " | Sugar packets: " + myCafe.nSugarPackets + " | Creams: " + myCafe.nCreams  + " | Number of Cups: " + myCafe.nCups);
        
        // Sell coffee and display inventory after each sale
        myCafe.sellCoffee(12, 2, 3);
        System.out.println("Inventory after using 12 coffee ounces, 2 sugar packets, and 3 creams: "+ myCafe.nCoffeeOunces + " | " + myCafe.nSugarPackets + " | " + myCafe.nCreams + " | " + myCafe.nCups);
        
        myCafe.sellCoffee(16, 5, 4);
        System.out.println("Inventory after using 16 coffee ounces, 5 sugar packets, and 4 creams: " + myCafe.nCoffeeOunces + " | " + myCafe.nSugarPackets + " | " + myCafe.nCreams + " | " + myCafe.nCups);
        
        myCafe.sellCoffee(90, 15, 20);
        System.out.println("Inventory after using 90 coffee ounces, 15 sugar packets, and 20 creams: " + myCafe.nCoffeeOunces + " | " + myCafe.nSugarPackets + " | " + myCafe.nCreams + " | " + myCafe.nCups);
        
        // Test overloaded sellCoffee method with additional cup parameter
        myCafe.sellCoffee(12);
        System.out.println("Inventory after selling 12 oz coffee with 1 sugar and 1 cream by default: " + myCafe.nCoffeeOunces + " | " + myCafe.nSugarPackets + " | " + myCafe.nCreams + " | " + myCafe.nCups);
        
        // Attempt to navigate to a restricted floor
        try {
            myCafe.goToFloor(2);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        // Create a Cafe instance with default parameters and print details
        Cafe defaultCafe = new Cafe();
        System.out.println(defaultCafe);


    }
}


