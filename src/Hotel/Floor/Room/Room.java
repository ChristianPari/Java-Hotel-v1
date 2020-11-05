package Hotel.Floor.Room;

public class Room {
  private String roomNumber;
  private int cost;
  private int sleepingAmount;

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

    cost = (floorFixed * firstIndex) + (roomFixed * lastIndex - 10) + fixedDeposit + roomTypeCost;
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
    return "\nRoom " + roomNumber + ", cost per night: $" + cost;
  };

  public String getRoomNumber() { return roomNumber; };
}
