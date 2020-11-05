package com.christianpari;

import Hotel.Hotel;

import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    Hotel hotel = new Hotel(scanner, 2);
    hotel.greet();
  }
}