
/* This is a stub for the Library class */
import java.util.Hashtable;

/**
 * The Library class represents a library, a type of Building, which maintains a collection of book titles.
 * Each book has a title and an availability status.
 */
public class Library extends Building {
  private Hashtable<String, Boolean> collection; 
  private boolean hasElevator;
  /**
   * Constructor for creating a Library with a name, address, and number of floors.
   *
   * @param name The name of the library
   * @param address The address of the library
   * @param nFloors The number of floors in the library
   * @param hasElevator Boolean to determine if library has an elevator or not
   */
  public Library(String name, String address, int nFloors, boolean hasElevator) {
    super(name,address,nFloors);
    this.hasElevator = hasElevator;
    this.collection = new Hashtable<String, Boolean>();
    System.out.println("You have built a library: 📖");
  }

  /**
   * Overloads Library Constructor
   * Sets up default library, Neilson Library
   */
  public Library(){
    this("Neilson Library", "7 Neilson Drive, Northampton, MA 01063", 4, true);
  }


  /**
   * Adds a new book title to the library's collection.
   *
   * @param title The title of the book to add
   */
  public void addTitle(String title) {
    this.collection.put(title, true); // book is available when added
  }

  /**
   * Overloads addTitle method and allows for multiple books to be added at once
   * @param names of books being added to collection 
   */
  public void addTitle(String... names ){
    for (String title: names){
      collection.put(title, true);
    }
  }

  /**
   * Removes a book title from the library's collection.
   *
   * @param title The title of the book to remove
   * @return The title of the removed book
   * @throws RuntimeException if the book title is not found in the collection
   */
  public String removeTitle(String title) {
    if (this.collection.remove(title) != null) {
      return title;
    } else {
      throw new RuntimeException("Title " + title + " not found in collection.");
    }
  }

  /**
   * Checks out a book from the library by setting its availability to false.
   *
   * @param title The title of the book to check out
   * @throws RuntimeException if the book title is not found in the collection
   */
  public void checkOut(String title) {
    if (this.collection.containsKey(title)) {
      this.collection.replace(title, false);
    } else {
      throw new RuntimeException("Title " + title + " not found in collection.");
    }
  }

  /**
   * Returns a book to the library by setting its availability to true.
   *
   * @param title The title of the book to return
   * @throws RuntimeException if the book title is not found in the collection
   */
  public void returnBook(String title) {
    if (this.collection.containsKey(title)) {
      this.collection.replace(title, true);
    } else {
      throw new RuntimeException("Title " + title + " not found in collection.");
    }
  }

  /**
   * Checks if the library contains a particular book title.
   *
   * @param title The title to check for
   * @return true if the title exists in the library's collection, false otherwise
   */
  public boolean containsTitle(String title) {
    return this.collection.containsKey(title);
  }

  /**
   * Checks if a particular book title is available in the library.
   *
   * @param title The title to check for availability
   * @return true if the title is available, false otherwise
   */
  public boolean isAvailable(String title) {
    return this.collection.getOrDefault(title, false);
  }

  /**
   * Prints the library's entire collection, showing each title's availability status.
   */
  public void printCollection() {
    for (String title : this.collection.keySet()) {
      String status = this.collection.get(title) ? "Available" : "Checked out";
      System.out.println(title + ": " + status);
    }
  }

  /**
   * Overides goToFloor method in parent class 
   */
  public void goToFloor(int floorNum) {
    if (hasElevator == true){
      if (this.activeFloor == -1) {
        throw new RuntimeException("You are not inside the Library. Must call enter() before navigating between floors.");
      }
      if (floorNum < 1 || floorNum > this.nFloors) {
        throw new RuntimeException("Invalid floor number. Valid range for this Library is 1-" + this.nFloors +".");
      }
      System.out.println("You are now on floor #" + floorNum + " of " + this.name);
      this.activeFloor = floorNum;
    }
    else {
      System.out.println("This Library does not have an elevator");
    }
  }

  /**
   * Overides showOptions() method in parent class 
   */
  public void showOptions() {
    super.showOptions();
    System.out.println("Available options at " + this.name + ":\n + addTitle() \n + removeTitle() \n + checkOut() \n + returnBook()\n + containsTitle()\n + isAvailable()\n + printCollection()");
  }

  /**
   * Main method to demonstrate the functionality of the Library class.
   *
   * @param args Command-line arguments (not used)
   */
  public static void main(String[] args) {
    Library mylibrary = new Library("Reagan's Library", "4180 Siena Dr", 6, true);
    System.out.println(mylibrary);
    mylibrary.showOptions();
    mylibrary.addTitle("On Earth We're Briefly Gorgeous by Ocean Vuong");
    mylibrary.addTitle("Nina");
    mylibrary.addTitle("King");
    mylibrary.addTitle("The Great Gatsby", "Beautiful Boy", "Perks of Being a Wallflower" );
    System.out.println(mylibrary.collection);
    mylibrary.checkOut("Nina");
    mylibrary.checkOut("On Earth We're Briefly Gorgeous by Ocean Vuong");
    mylibrary.returnBook("Nina");
    mylibrary.printCollection();
    mylibrary.enter();
    mylibrary.goToFloor(2);
    mylibrary.goToFloor(4);
    Library defaultLibrary = new Library();
    System.out.println(defaultLibrary);
  }
}


  