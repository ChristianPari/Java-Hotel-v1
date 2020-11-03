package com.christianpari;

import java.util.Scanner;

public class Hotel {
  private Scanner scanner;
  private int floors;
  private int[] allRooms;

  public Hotel(
          Scanner scanner,
          int floors
  ) {
    this.scanner = scanner;
    this.floors = floors;
  }

  public void greet() {
    System.out.println("Welcome to Hotel de Pari, would you like to book a stay?\n Y/N: ");
    String response = scanner.nextLine().toLowerCase();

    if (!response.equals("y")) {
      scanner.close();
      System.out.println("Okay, have a great day!");
      return;
    }

    interaction1();
  }

  private void interaction1() {
//        display the rooms available
  }
}
