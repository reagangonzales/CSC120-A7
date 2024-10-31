import java.util.ArrayList;
/* This is a stub for the House class */

/**
 * Represents a House, a type of Building where students may live, work, and dine.
 * The house keeps track of residents and whether it has a dining room.
 */
public class House extends Building {
  private ArrayList<String> residents;
  private boolean hasDiningRoom;

  /**
   * Constructor to create a House with specified name, address, floors, and dining room availability.
   *
   * @param name The name of the house
   * @param address The address of the house
   * @param nFloors The number of floors in the house
   * @param hasDiningRoom Whether the house has a dining room
   */
  public House(String name, String address, int nFloors, boolean hasDiningRoom) {
    super(name, address, nFloors);
    this.residents = new ArrayList<String>();
    this.hasDiningRoom = hasDiningRoom;
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
}