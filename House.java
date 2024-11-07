import java.util.ArrayList;
/* This is a stub for the House class */

/**
 * Represents a House, a type of Building where students may live, work, and dine.
 * The house keeps track of residents and whether it has a dining room.
 */
public class House extends Building {
  private ArrayList<String> residents;
  private boolean hasDiningRoom;
  private boolean hasElevator;

  /**
   * Constructor to create a House with specified name, address, floors, and dining room availability.
   *
   * @param name The name of the house
   * @param address The address of the house
   * @param nFloors The number of floors in the house
   * @param hasDiningRoom Whether the house has a dining room
   */
  public House(String name, String address, int nFloors, boolean hasElevator, boolean hasDiningRoom) {
    super(name,address,nFloors);
    this.hasDiningRoom = hasDiningRoom;
    this.hasElevator = hasElevator;
    this.residents = new ArrayList<>();
    System.out.println("You have built a house: 🏠");
  }

  /**
   * Overloads House Constructor
   * Sets up default house, Wilson House
   */
  public House (){
    this("Wilson", "1 Paradise Road Northampton, MA 01063", 5, false, true);
  }

  /**
   * Overloads moveOut method 
   * @param names of all residents moving out
   * @return remaining residents 
   */
  public String moveOut(String... names){
    for (String name: names){
      residents.remove(name);
    }
    return "Remaining resident(s):" + residents;
  }

  /**
   * Overides showOptions() method in parent class 
   */
  public void showOptions() {
    super.showOptions();
    System.out.println("Available options at " + this.name + ":\n + hasDiningRoom() \n + nResidents() \n + moveIn() \n + moveOut()\n + isResident()");
  }
  
  /**
   * Overides goToFloor() method in parent class 
   */
  public void goToFloor(int floorNum) {
    if (hasElevator == true){
      if (this.activeFloor == -1) {
        throw new RuntimeException("You are not inside this House. Must call enter() before navigating between floors.");
      }
      if (floorNum < 1 || floorNum > this.nFloors) {
        throw new RuntimeException("Invalid floor number. Valid range for this House is 1-" + this.nFloors +".");
      }
      System.out.println("You are now on floor #" + floorNum + " of " + this.name);
      this.activeFloor = floorNum;
    } else {
      System.out.println("This House does not have an elevator");
    }
  }

  /**
   * Checks if the house has a dining room.
   *
   * @return true if the house has a dining room, false otherwise
   */
  public boolean hasDiningRoom() {
    return hasDiningRoom;
  }

  /**
   * Gets the number of residents currently in the house.
   *
   * @return The number of residents
   */
  public int nResidents() {
    return residents.size();
  }

  /**
   * Adds a resident to the house.
   *
   * @param name The name of the new resident
   */
  public void moveIn(String name) {
    residents.add(name);
  }

  /**
   * Removes a resident from the house.
   *
   * @param name The name of the resident to remove
   * @return The name of the resident who moved out
   */
  public String moveOut(String name) {
    if (residents.remove(name)) {
      return name;
    } else {
      throw new RuntimeException(name + " is not a resident.");
    }
  }

  /**
   * Checks if a given person is a resident of the house.
   *
   * @param person The name of the person to check
   * @return true if the person is a resident, false otherwise
   */
  public boolean isResident(String person) {
    return residents.contains(person);
  }

  public static void main(String[] args) {
    House myHome = new House("Wilson House", "101", 4, false, true);
    myHome.moveIn("Reagan");
    myHome.moveIn("Marleni");
    myHome.moveIn("Abril");
    myHome.showOptions();
    System.out.println(myHome);
    System.out.println(myHome.hasDiningRoom());   
    System.out.println(myHome.isResident("Sudeen")); 
    System.out.println( myHome.nResidents());
    System.out.println(myHome.residents);   
    myHome.enter();
    myHome.goToFloor(4);
    myHome.goToFloor(1);
    myHome.moveOut("Bianca", "Tara");
    System.out.println(myHome.residents); 
    System.out.println(myHome.nResidents());
    House defaultHouse = new House();
    System.out.println(defaultHouse);
  }
}