
/* This is a stub for the Library class */
import java.util.Hashtable;

/**
 * The Library class represents a library, a type of Building, which maintains a collection of book titles.
 * Each book has a title and an availability status.
 */
public class Library extends Building {
  private Hashtable<String, Boolean> collection; // book collection with availability

  /**
   * Constructor for creating a Library with a name, address, and number of floors.
   *
   * @param name The name of the library
   * @param address The address of the library
   * @param nFloors The number of floors in the library
   */
  public Library(String name, String address, int nFloors) {
    super(name, address, nFloors); // call the constructor of Building
    this.collection = new Hashtable<String, Boolean>(); // initialize the book collection
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
   * Main method to demonstrate the functionality of the Library class.
   *
   * @param args Command-line arguments (not used)
   */
  public static void main(String[] args) {
    Library myLibrary = new Library("Forbes Library", "Main St", 2);
    myLibrary.addTitle("1984 by George Orwell");
    myLibrary.addTitle("The Great Gatsby by F. Scott Fitzgerald");

    System.out.println("Initial collection status:");
    myLibrary.printCollection();

    myLibrary.checkOut("1984 by George Orwell");
    System.out.println("\nAfter checking out '1984 by George Orwell':");
    System.out.println("Is '1984' available? " + myLibrary.isAvailable("1984 by George Orwell"));
    myLibrary.printCollection();

    myLibrary.returnBook("1984 by George Orwell");
    System.out.println("\nAfter returning '1984 by George Orwell':");
    myLibrary.printCollection();
  }
}


  