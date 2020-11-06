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
    for (int i = 1; i <= 5; i++) {
      String roomNumber = Integer.toString((floorNum * 100 + i));

      if (i <= 3) {
        Room room = new Basic(roomNumber, "basic");
        rooms.add(room);
      };

      if (i == 4) {
        Room room = new Suite(roomNumber, "suite");
        rooms.add(room);
      };

      if (i == 5){
        Room room = new Luxury(roomNumber, "luxury");
        rooms.add(room);
      };
    }
  };

  public ArrayList<Room> getRooms() {
    return rooms;
  }

  @Override
  public String toString() {
    StringBuilder floorDetails = new StringBuilder("Floor " + floorNum + ": ");

    for (Room room :
            rooms) {
      floorDetails.append(room.toString());
    };

    int lastIndex = floorDetails.length();
    floorDetails.delete(lastIndex, lastIndex);
    floorDetails.append("\n");

    return floorDetails.toString();
  };
}
