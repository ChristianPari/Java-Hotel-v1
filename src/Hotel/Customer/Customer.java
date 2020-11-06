package Hotel.Customer;

import Hotel.Floor.Room.Room;

import java.util.ArrayList;

public class Customer {
  private String name;
  private int cashInCents;
  private ArrayList<Room> rentingRooms = new ArrayList<>();

  public Customer (
          String name,
          int cashInCents
  ) {
    this.name = name;
    this.cashInCents = cashInCents;
  }

  public boolean checkout(Room room) {
    boolean valid = room.attemptCheckout(this);
    if (valid) {
      rentingRooms.add(room);
      room.isOccupied = true;
      cashInCents -= room.getCost();
      return true;
    }
    return false;
  }

  public int getCashInCents() {
    return cashInCents;
  }
}
