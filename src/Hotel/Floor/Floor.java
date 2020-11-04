package Hotel.Floor;

import Hotel.Floor.Room.Basic;
import Hotel.Floor.Room.Luxury;
import Hotel.Floor.Room.Room;
import Hotel.Floor.Room.Suite;

import java.util.ArrayList;

public class Floor {
  private int floorNum;
  private ArrayList<Room> rooms = new ArrayList<>();

  public Floor (
          int floorNum
  ) {
    this.floorNum = floorNum;
    generateRooms(floorNum);
  };

  private void generateRooms(int floorNum) {
    for (int i = 0; i < 5; i++) {
      String roomNumber = Integer.toString((floorNum * 100 + i));
      if (i <= 2) {
        Room room = new Basic(roomNumber, "basic");
        rooms.add(room);
      } else if (i == 3) {
        Room room = new Suite(roomNumber, "suite");
        rooms.add(room);
      } else {
        Room room = new Luxury(roomNumber, "luxury");
        rooms.add(room);
      }
    }
  };

  public ArrayList<Room> getRooms() {
    return rooms;
  }

  public String toString() {
    StringBuilder floorDetails = new StringBuilder("Floor " + floorNum + ": ");

    for (Room room :
            rooms) {
      floorDetails.append(room.toString() + ", ");
    };

    int lastIndex = floorDetails.length();
    floorDetails.delete(lastIndex - 2, lastIndex - 1);
    floorDetails.append("\n");

    return floorDetails.toString();
  };
}
