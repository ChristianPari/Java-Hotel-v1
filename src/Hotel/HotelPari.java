package Hotel;

import Hotel.Customer.Customer;
import Hotel.Floor.Floor;
import Hotel.Floor.Room.Room;

import java.util.ArrayList;
import java.util.Scanner;

public class HotelPari {
  private Scanner scanner;
  private int numberOfFloors;
  private ArrayList<Floor> floors = new ArrayList<>();
  private ArrayList<Room> availableRooms = new ArrayList<>();
  private ArrayList<Room> unavailableRooms = new ArrayList<>();

  public HotelPari(
          Scanner scanner,
          int numberOfFloors
  ) {
    this.scanner = scanner;
    this.numberOfFloors = numberOfFloors;
    generateFloors(numberOfFloors);
  }

  public void greet() {
    System.out.print("Welcome to Hotel de Pari, would you like to book a stay?\nY/N: ");
    String response = scanner.nextLine().toLowerCase();

    if (!response.equals("y")) {
      scanner.close();
      System.out.println("Okay, have a great day!");
      return;
    }

    displayRooms();

    registerCustomer();
  }

  private void displayRooms() {
    System.out.println("\nBelow are a list of our available rooms!");
    System.out.println(this);
  }

  private void registerCustomer() {
    System.out.print("\nPlease enter your name!\nName: ");
    String customerName = scanner.nextLine();
    System.out.print("\nWhat is your budget?\nBudget (no cents): ");
    int budget = scanner.nextInt() * 100;
    Customer customer = new Customer(customerName, budget);
    roomChoice(customer);
  }

  private void roomChoice(Customer customer) {
    System.out.print("\nPlease enter the room number you wish to rent: ");
    String roomChosen = Integer.toString(scanner.nextInt());

    for (Room room : availableRooms) {
      if (room.getRoomNumber().equals(roomChosen)) {
        proceedToCheckout(customer, room);
        break;
      }

      if ((availableRooms.indexOf(room) == availableRooms.size() - 1) && (!room.getRoomNumber().equals(roomChosen))) {
        System.out.println("\nPlease enter a valid room option!");
        roomChoice(customer);
      }
    }
  }

  private void proceedToCheckout(Customer customer, Room room) {
    boolean successfulTransaction = customer.checkout(room);

    if (successfulTransaction) {
      System.out.println("\nCongratulations! You have rented room " + room.getRoomNumber());
      unavailableRooms.add(room);
      availableRooms.remove(room);
      System.out.println(this);
      return;
    }


  }

  private void generateFloors(int numberOfFloors) {
    for (int i = 1; i <= numberOfFloors; i++) {

      Floor floor = new Floor(i);
      floors.add(floor);

      for (Room room : floor.getRooms()) {
        availableRooms.add(room);
      }
    }
  }

  public ArrayList<Room> getAvailableRooms() {
    return availableRooms;
  }

  @Override
  public String toString() {
    String hotelDetails = "";
    for (Room room :
            availableRooms) {
      hotelDetails = hotelDetails.concat(room.toString());
    }
    return hotelDetails.trim();
  }
}
