package Hotel.Floor.Room;

import java.util.ArrayList;

public class Room {
  protected String roomNumber;
  protected int cost;
  protected int sleepingAmount;

  public Room (
          String roomNumber,
          String roomType
  ) {
    this.roomNumber = roomNumber;
    calculateCost(roomType);
    setSleepAmount(roomType);
  };

  private void calculateCost(String roomType) {
    int floorFixed = 50;
    int roomFixed = 10;
    int fixedDeposit = 45;
    int roomTypeCost = 0;

    switch (roomType) {
      case "basic":
        roomTypeCost = 50;

      case "suite":
        roomTypeCost = 75;

      case "luxury":
        roomTypeCost = 100;

      default:
        break;
    }

    cost = (floorFixed * (int)roomNumber.charAt(0)) + (roomFixed * (int)roomNumber.charAt(2) - 10) + fixedDeposit + roomTypeCost;
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
    return "" + roomNumber + "";
  };
}
