package Hotel;

import Hotel.Floor.Floor;
import Hotel.Floor.Room.Room;

import java.util.ArrayList;
import java.util.Scanner;

public class Hotel {
  private Scanner scanner;
  private int numberOfFloors;
  private ArrayList<Floor> floors = new ArrayList<>();
  private ArrayList<Room> allRooms = new ArrayList<>();

  public Hotel(
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
  }

  private void displayRooms() {
    System.out.println("\nBelow are a list of our available rooms!");
    System.out.println(this);

    interaction1();
  }

  private void interaction1() {
    System.out.print("Please enter the room number you wish to rent: ");
    String roomChosen = Integer.toString(scanner.nextInt());

    for (Room room : allRooms) {
      if (room.getRoomNumber().equals(roomChosen)) {
        System.out.println("Renting room...");
        break;
      }

      if ((allRooms.indexOf(room) == allRooms.size() - 1) && (!room.getRoomNumber().equals(roomChosen))) {
        System.out.println("Please enter a valid room option!");
        interaction1();
      }
    }
  }

  private void generateFloors(int numberOfFloors) {
    for (int i = 1; i <= numberOfFloors; i++) {
      Floor floor = new Floor(i);
      floors.add(floor);
      for (Room room : floor.getRooms()) {
        allRooms.add(room);
      }
    }
  }

  public ArrayList<Room> getAllRooms() {
    return allRooms;
  }

  @Override
  public String toString() {
    String hotelDetails = "";
    for (Floor floor :
            floors) {
      hotelDetails = hotelDetails.concat(floor.toString());
    }
    return hotelDetails.trim();
  }
}
