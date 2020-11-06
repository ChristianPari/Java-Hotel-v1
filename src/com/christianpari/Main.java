package com.christianpari;

import Hotel.HotelPari;

import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    HotelPari hotelPari = new HotelPari(scanner, 2);
    hotelPari.greet();
  }
}