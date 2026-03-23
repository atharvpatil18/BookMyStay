import java.util.HashMap;

public class BookMyStay {
    public static void main(String[] args) {

        //USE CASE 1
        System.out.println("Welcome to the Hotel Booking Management System");
        System.out.println("System initialized successfully.");
        System.out.println("Application: Book My Stay App v1.0");
    }
}

public class UseCase2HotelBookingApp {

    public static void main(String[] args) {

        System.out.println("Hotel Room Initialization\n");

        // Creating room objects (Polymorphism)
        Room single = new SingleRoom();
        Room doubleRoom = new DoubleRoom();
        Room suite = new SuiteRoom();

        // Static availability
        int singleAvailable = 5;
        int doubleAvailable = 3;
        int suiteAvailable = 2;

        // Single Room Details
        System.out.println("Single Room:");
        single.displayRoomDetails();
        System.out.println("Available: " + singleAvailable);
        System.out.println();

        // Double Room Details
        System.out.println("Double Room:");
        doubleRoom.displayRoomDetails();
        System.out.println("Available: " + doubleAvailable);
        System.out.println();

        // Suite Room Details
        System.out.println("Suite Room:");
        suite.displayRoomDetails();
        System.out.println("Available: " + suiteAvailable);
    }
}

/**
 * Abstract class representing a generic Room
 */
abstract class Room {

    protected int numberOfBeds;
    protected int squareFeet;
    protected double pricePerNight;

    // Constructor
    public Room(int numberOfBeds, int squareFeet, double pricePerNight) {
        this.numberOfBeds = numberOfBeds;
        this.squareFeet = squareFeet;
        this.pricePerNight = pricePerNight;
    }

    // Display room details
    public void displayRoomDetails() {
        System.out.println("Beds: " + numberOfBeds);
        System.out.println("Size: " + squareFeet + " sqft");
        System.out.println("Price per night: " + pricePerNight);
    }
}

/**
 * Single Room class
 */
class SingleRoom extends Room {

    public SingleRoom() {
        super(1, 250, 1500.0);
    }
}

/**
 * Double Room class
 */
class DoubleRoom extends Room {

    public DoubleRoom() {
        super(2, 400, 2500.0);
    }
}

/**
 * Suite Room class
 */
class SuiteRoom extends Room {

    public SuiteRoom() {
        super(3, 750, 5000.0);
    }
}

import java.util.HashMap;

/**
 * Book My Stay App
 * Use Case 3: Centralized Room Inventory Management
 * Demonstrates the use of HashMap for managing room availability.
 *
 * @author Varad
 * @version 1.0
 */

public class UseCase3InventorySetup {

    public static void main(String[] args) {

        System.out.println("Hotel Room Inventory Status\n");

        // Create room objects
        Room single = new SingleRoom();
        Room doubleRoom = new DoubleRoom();
        Room suite = new SuiteRoom();

        // Create inventory
        RoomInventory inventory = new RoomInventory();

        // Register room availability
        inventory.setAvailability("Single Room", 5);
        inventory.setAvailability("Double Room", 3);
        inventory.setAvailability("Suite Room", 2);

        // Display Single Room
        System.out.println("Single Room:");
        single.displayRoomDetails();
        System.out.println("Available Rooms: " + inventory.getAvailability("Single Room"));
        System.out.println();

        // Display Double Room
        System.out.println("Double Room:");
        doubleRoom.displayRoomDetails();
        System.out.println("Available Rooms: " + inventory.getAvailability("Double Room"));
        System.out.println();

        // Display Suite Room
        System.out.println("Suite Room:");
        suite.displayRoomDetails();
        System.out.println("Available Rooms: " + inventory.getAvailability("Suite Room"));

        // Create search service
        SearchService search = new SearchService(inventory);

// Perform room search
        search.displayAvailableRooms(single, "Single Room");
        search.displayAvailableRooms(doubleRoom, "Double Room");
        search.displayAvailableRooms(suite, "Suite Room");
    }
}

/**
 * Abstract class representing a generic room
 */
abstract class Room {

    protected int numberOfBeds;
    protected int squareFeet;
    protected double pricePerNight;

    public Room(int beds, int size, double price) {
        this.numberOfBeds = beds;
        this.squareFeet = size;
        this.pricePerNight = price;
    }

    public void displayRoomDetails() {
        System.out.println("Beds: " + numberOfBeds);
        System.out.println("Size: " + squareFeet + " sqft");
        System.out.println("Price per night: " + pricePerNight);
    }
}

/**
 * Single Room
 */
class SingleRoom extends Room {

    public SingleRoom() {
        super(1, 250, 1500.0);
    }
}

/**
 * Double Room
 */
class DoubleRoom extends Room {

    public DoubleRoom() {
        super(2, 400, 2500.0);
    }
}

/**
 * Suite Room
 */
class SuiteRoom extends Room {

    public SuiteRoom() {
        super(3, 750, 5000.0);
    }
}

/**
 * RoomInventory class manages centralized availability using HashMap
 */
class RoomInventory {

    private HashMap<String, Integer> availability;

    // Constructor initializes inventory
    public RoomInventory() {
        availability = new HashMap<>();
    }

    // Set availability
    public void setAvailability(String roomType, int count) {
        availability.put(roomType, count);
    }

    // Get availability
    public int getAvailability(String roomType) {
        return availability.get(roomType);
    }
}

class SearchService {

    private RoomInventory inventory;

    public SearchService(RoomInventory inventory) {
        this.inventory = inventory;
    }

    public void displayAvailableRooms(Room room, String roomType) {

        int available = inventory.getAvailability(roomType);

        // Show only available rooms
        if (available > 0) {
            System.out.println(roomType + ":");
            room.displayRoomDetails();
            System.out.println("Available Rooms: " + available);
            System.out.println();
        }
    }
}
