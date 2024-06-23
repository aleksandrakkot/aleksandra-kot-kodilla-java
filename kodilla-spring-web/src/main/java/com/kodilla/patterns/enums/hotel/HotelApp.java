package com.kodilla.patterns.enums.hotel;

public class HotelApp {

    public static void main(String[] args) {
        System.out.println("Accomodation prices:");
        System.out.println("1. Single Bed rooms");
        System.out.println("   - low season: " + PriceList.getSingleBedPrice(Season.LOW));
        System.out.println("   - high season: " + PriceList.getSingleBedPrice(Season.HIGH));
        System.out.println("   - holiday season: " + PriceList.getSingleBedPrice(Season.HOLIDAY));
        System.out.println("2. Double Bed rooms");
        System.out.println("   - low season: " + PriceList.getDoubleBedPrice(Season.LOW));
        System.out.println("   - high season: " + PriceList.getDoubleBedPrice(Season.HIGH));
        System.out.println("   - holiday season: " + PriceList.getDoubleBedPrice(Season.HOLIDAY));

        Season season = Season.HOLIDAY;

        System.out.println(season);
    }
}
