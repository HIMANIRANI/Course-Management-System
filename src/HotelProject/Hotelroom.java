package HotelProject;
 
// Importing necessary libraries
import java.text.SimpleDateFormat;
import java.util.*;
 
// Main class representing the hotel room management system
public class Hotelroom {
    // Lists to store rooms, reservations, and accounts
    private final List<Room> rooms;
    private final List<Reservation> reservations;
    private final List<Account> accounts;
    private final Scanner scanner;
 
    // Constructor to initialize lists and add an admin account
    public Hotelroom() {
        rooms = new ArrayList<>();
        reservations = new ArrayList<>();
        accounts = new ArrayList<>();
        scanner = new Scanner(System.in);
 
        // Adding Arbin as the Admin
        accounts.add(new Account("Arbin", "Arbin123", "admin"));
    }
 
    // Method to add a room to the list of rooms
    public synchronized void addRoom(Room room) {
        rooms.add(room);
    }
 
    // Method to make a reservation for a guest
    public synchronized void makeReservation(Guest guest, Room room, Date checkInDate, Date checkOutDate) {
        reservations.add(new Reservation(guest, room, checkInDate, checkOutDate));
        room.setOccupied(true);
        System.out.println("Reservation made successfully.");
    }
 
    // Method to check-in a guest
    public synchronized void checkIn(Guest guest, Room room, Date checkInDate, Date checkOutDate) {
        reservations.add(new Reservation(guest, room, checkInDate, checkOutDate));
        room.setOccupied(true);
        System.out.println("Guest " + guest.getName() + " has been checked in to room number " + room.getNumber() + ".");
    }
 
    // Method to check-out a guest by their name
    public synchronized void checkOut(String guestName) {
        boolean checkedIn = false;
        Reservation reservationToCheckOut = null;
 
        // Find the checked-in reservation for the guest
        for (Reservation reservation : reservations) {
            if (reservation.getGuest().getName().equalsIgnoreCase(guestName) && reservation.getRoom().isOccupied()) {
                reservationToCheckOut = reservation;
                checkedIn = true; // Guest is checked in
                break;
            }
        }
 
        // Check-out the guest if they are found
        if (checkedIn) {
            Room room = reservationToCheckOut.getRoom();
            room.setOccupied(false);
            reservations.remove(reservationToCheckOut);
            System.out.println("Guest " + guestName + " has been checked out of room number " + room.getNumber() + ".");
        } else {
            System.out.println("No checked-in reservation found for guest: " + guestName + ".");
        }
    }
 
    // Method to display all available rooms
    public void displayRoomAvailability() {
        System.out.println("Available rooms:");
        for (Room room : rooms) {
            if (!room.isOccupied()) {
                System.out.println("Room Number: " + room.getNumber() + ", Type: " + room.getType());
            }
        }
    }
 
    // Method to display all current reservations
    public void displayReservations() {
        System.out.println("Current reservations:");
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        for (Reservation reservation : reservations) {
            System.out.println("Guest: " + reservation.getGuest().getName() + ", Room Number: " + reservation.getRoom().getNumber() +
                    ", Check-in Date: " + dateFormat.format(reservation.getCheckInDate()) + ", Check-out Date: " + dateFormat.format(reservation.getCheckOutDate()));
        }
    }
 
    // Method to display the main menu options
    public void showMainMenu() {
        System.out.println("Welcome to the Hotel Management System");
        System.out.println("1. Check-in");
        System.out.println("2. Check-out");
        System.out.println("3. Make Reservation");
        System.out.println("4. Create Account");
        System.out.println("5. Delete Account");
        System.out.println("6. Display Reservations");
        System.out.println("7. Search Available Rooms");
        System.out.println("8. Exit");
    }
 
    // Method to start the hotel management system
    public void start() {
        boolean running = true;
        while (running) {
            showMainMenu();
            System.out.print("Enter your choice: ");
            int choice = getIntInput();
 
            switch (choice) {
                case 1:
                    System.out.println("Check-in");
                    System.out.print("Enter guest name: ");
                    String guestNameCheckIn = scanner.nextLine();
                    displayRoomAvailability();
                    System.out.print("Enter room number: ");
                    int roomNumberCheckIn = getIntInput();
                    Room selectedRoomCheckIn = null;
                    for (Room room : rooms) {
                        if (room.getNumber() == roomNumberCheckIn) {
                            selectedRoomCheckIn = room;
                            break;
                        }
                    }
                    if (selectedRoomCheckIn == null || selectedRoomCheckIn.isOccupied()) {
                        System.out.println("Invalid room number or room is already occupied.");
                        break;
                    }
                    Date checkInDateCheckIn = getDateInput("check-in");
                    Date checkOutDateCheckIn = getDateInput("check-out");
                    checkIn(new Guest(guestNameCheckIn), selectedRoomCheckIn, checkInDateCheckIn, checkOutDateCheckIn);
                    break;
 
                case 2:
                    System.out.println("Check-out");
                    System.out.print("Enter guest name: ");
                    String guestNameCheckOut = scanner.nextLine();
                    checkOut(guestNameCheckOut);
                    break;
 
                case 3:
                    System.out.println("Reservation");
                    System.out.print("Enter guest name: ");
                    String guestNameReservation = scanner.nextLine();
                    displayRoomAvailability();
                    System.out.print("Enter room number: ");
                    int roomNumberReservation = getIntInput();
                    Room selectedRoomReservation = null;
                    for (Room room : rooms) {
                        if (room.getNumber() == roomNumberReservation) {
                            selectedRoomReservation = room;
                            break;
                        }
                    }
                    if (selectedRoomReservation == null || selectedRoomReservation.isOccupied()) {
                        System.out.println("Invalid room number or room is already occupied.");
                        break;
                    }
                    Date checkInDateReservation = getDateInput("check-in");
                    Date checkOutDateReservation = getDateInput("check-out");
                    makeReservation(new Guest(guestNameReservation), selectedRoomReservation, checkInDateReservation, checkOutDateReservation);
                    break;
 
                case 4:
                    createAccount();
                    break;
 
                case 5:
                    deleteAccount();
                    break;
 
                case 6:
                    displayReservations();
                    break;
 
                case 7:
                    searchAvailableRooms();
                    break;
 
                case 8:
                    running = false;
                    break;
 
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 8.");
            }
        }
    }
 
    // Method to get integer input from the user with validation
    public int getIntInput() {
        int input = 0;
        boolean validInput = false;
        while (!validInput) {
            try {
                input = Integer.parseInt(scanner.nextLine());
                validInput = true;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
        return input;
    }
 
    // Method to get date input from the user with validation
    public Date getDateInput(String dateType) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = null;
        boolean validInput = false;
        while (!validInput) {
            try {
                System.out.print("Enter " + dateType + " date (DD/MM/YYYY): ");
                String dateString = scanner.nextLine();
                date = dateFormat.parse(dateString);
                validInput = true;
            } catch (java.text.ParseException e) {
                System.out.println("Invalid date format. Please enter the date in the format DD/MM/YYYY.");
            }
        }
        return date;
    }
 
    // Method to create a new account
    public void createAccount() {
        System.out.print("Enter admin username: ");
        String adminUsername = scanner.nextLine();
        System.out.print("Enter admin password: ");
        String adminPassword = scanner.nextLine();
 
        // Check if the provided admin credentials are correct
        boolean isAdminAuthenticated = false;
        for (Account admin : accounts) {
            if (admin.getUsername().equals(adminUsername) && admin.getPassword().equals(adminPassword) && admin.getPermissions().equalsIgnoreCase("admin")) {
                isAdminAuthenticated = true;
                break;
 
 
            }
        }
 
        // If not authenticated, print error message and return
        if (!isAdminAuthenticated) {
            System.out.println("Incorrect admin username or password. You need admin privileges to create an account.");
            return;
        }
 
        // Admin authentication successful, proceed with creating the account
        System.out.print("Enter username for the new account: ");
        String username = scanner.nextLine();
        for (Account account : accounts) {
            if (account.getUsername().equals(username)) {
                System.out.println("Username already exists. Please choose another.");
                return;
            }
        }
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        System.out.print("Enter permissions (admin/staff): ");
        String permissions = scanner.nextLine();
        accounts.add(new Account(username, password, permissions));
        System.out.println("Account created successfully.");
    }
 
    // Method to delete an existing account
    public void deleteAccount() {
        System.out.print("Enter username to delete account: ");
        String username = scanner.nextLine();
        for (Iterator<Account> iterator = accounts.iterator(); iterator.hasNext(); ) {
            Account account = iterator.next();
            if (account.getUsername().equals(username)) {
                // Ask for user's password
                System.out.print("Please enter your password: ");
                String password = scanner.nextLine();
                // Check if the entered password matches the account's password
                if (password.equals(account.getPassword())) {
                    iterator.remove();
                    System.out.println("Account deleted successfully.");
                } else {
                    System.out.println("Incorrect password. Account deletion failed.");
                }
                return;
            }
        }
        System.out.println("Account not found.");
    }
 
    // Method to search for available rooms of a specific type
    public void searchAvailableRooms() {
        System.out.print("Enter room type to search (single/double): ");
        String roomType = scanner.nextLine();
 
        boolean found = false;
        System.out.println("Available rooms of type " + roomType + ":");
        for (Room room : rooms) {
            if (!room.isOccupied() && room.getType().equalsIgnoreCase(roomType)) {
                System.out.println("Room Number: " + room.getNumber() + ", Type: " + room.getType());
                found = true;
            }
        }
 
        if (!found) {
            System.out.println("No available rooms of type " + roomType + " found.");
        }
    }
 
    // Method to close the scanner
    public void closeScanner() {
        scanner.close();
    }
 
    // Main method to run the program
    public static void main(String[] args) {
        Hotelroom hotel = new Hotelroom();
 
        // Adding rooms to the hotel
        hotel.addRoom(new Room(100, "Single"));
        hotel.addRoom(new Room(101, "Single"));
        hotel.addRoom(new Room(102, "Double"));
        hotel.addRoom(new Room(103, "Double"));
        hotel.addRoom(new Room(104, "Single"));
        hotel.addRoom(new Room(105, "Single"));
        hotel.addRoom(new Room(106, "Double"));
        hotel.addRoom(new Room(107, "Double"));
        hotel.addRoom(new Room(108, "Single"));
        hotel.addRoom(new Room(109, "Single"));
 
        // Starting the hotel management system
        hotel.start();
        hotel.closeScanner();
    }
}
 
// Class representing a room in the hotel
class Room {
    private final int number;
    private final String type;
    private boolean occupied;
 
    // Constructor to initialize room number and type
    public Room(int number, String type) {
        this.number = number;
        this.type = type;
        this.occupied = false;
    }
 
    // Getter for room number
    public int getNumber() {
        return number;
    }
 
    // Getter for room type
    public String getType() {
        return type;
    }
 
    // Getter for occupied status
    public boolean isOccupied() {
        return occupied;
    }
 
    // Setter for occupied status
    public void setOccupied(boolean occupied) {
        this.occupied = occupied;
    }
}
 
// Class representing a reservation in the hotel
class Reservation {
    private final Guest guest;
    private final Room room;
    private final Date checkInDate;
    private final Date checkOutDate;
 
    // Constructor to initialize reservation details
    public Reservation(Guest guest, Room room, Date checkInDate, Date checkOutDate) {
        this.guest = guest;
        this.room = room;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
    }
 
    // Getter for guest
    public Guest getGuest() {
        return guest;
    }
 
    // Getter for room
    public Room getRoom() {
        return room;
    }
 
    // Getter for check-in date
    public Date getCheckInDate() {
        return checkInDate;
    }
 
    // Getter for check-out date
    public Date getCheckOutDate() {
        return checkOutDate;
    }
}
 
// Class representing a guest in the hotel
class Guest {
    private final String name;
    private final int id;
 
    // Constructor to initialize guest name and generate a random ID
    public Guest(String name) {
        this.name = name;
        this.id = generateId();
    }
 
    // Method to generate a random guest ID
    private int generateId() {
        return new Random().nextInt(10000);
    }
 
    // Getter for guest name
    public String getName() {
        return name;
    }
 
    // Getter for guest ID
    public int getId() {
        return id;
    }
}
 
// Class representing an account in the hotel management system
class Account {
    private final String username;
    private final String password;
    private final String permissions;
 
    // Constructor to initialize account details
    public Account(String username, String password, String permissions) {
        this.username = username;
        this.password = password;
        this.permissions = permissions;
    }
 
    // Getter for username
    public String getUsername() {
        return username;
    }
 
    // Getter for password
    public String getPassword() {
        return password;
    }
 
    // Getter for permissions
    public String getPermissions() {
        return permissions;
    }
}