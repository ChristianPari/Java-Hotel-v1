package Hotel.Floor.Room;

import Hotel.Customer.Customer;

public class Room {
  private String roomNumber;
  private int cost;
  private int sleepingAmount;
  public boolean isOccupied = false;

  public Room (
          String roomNumber,
          String roomType
  ) {
    this.roomNumber = roomNumber;
    calculateCost(roomType);
    setSleepAmount(roomType);
  };

  public boolean attemptCheckout(Customer customer) {
    if (customer.getCashInCents() >= cost) { return true; }

    return false;
  }

  private void calculateCost(String roomType) {
    int floorFixed = 50;
    int roomFixed = 10;
    int fixedDeposit = 45;
    int roomTypeCost = 0;

    switch (roomType) {
      case "basic":
        roomTypeCost = 50;
        break;

      case "suite":
        roomTypeCost = 75;
        break;

      case "luxury":
        roomTypeCost = 100;
        break;

      default:
        break;
    };

    int firstIndex = Integer.parseInt("" + roomNumber.charAt(0) + "");
    int lastIndex = Integer.parseInt("" + roomNumber.charAt(2) + "");

    cost = ((floorFixed * firstIndex) + (roomFixed * lastIndex - 10) + fixedDeposit + roomTypeCost) * 100;
  };

  private void setSleepAmount(String roomType) {
    switch (roomType) {
      case "basic":
        sleepingAmount = 4;

      case "suite":
        sleepingAmount = 6;

      case "luxury":
        sleepingAmount = 8;
    }
  };

  @Override
  public String toString() {
    String cost = Integer.toString(this.cost);
    return "\nRoom " + roomNumber + ", cost per night: $" +
            cost.substring(0, cost.length() - 2) + "." +
            cost.substring((cost.length() - 2), cost.length());
  };

  public String getRoomNumber() { return roomNumber; }

  public int getCost() { return cost; }
}
