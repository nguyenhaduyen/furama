package controllers;

import Service.BookingService;
import Service.impl.BookingImpl;

import java.util.Scanner;

public class BookingManagement {
    public static void bookingManagement() {
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        String number4;
        BookingService bookingService = new BookingImpl();
        do {
            System.out.println("1. Add new booking");
            System.out.println("2. Display list booking");
            System.out.println("3. Create new contracts");
            System.out.println("4. Display list contracts");
            System.out.println("5. Edit contracts");
            System.out.println("6. Return main menu");
            System.out.println("Nhap so");
            number4 = scanner.nextLine();
            switch (number4) {
                case "1" : bookingService.addNewBooking();
                break;
                case "2": bookingService.displayListBooking();
                break;
                case "3": bookingService.createNewContracts();
                break;
                case "4": bookingService.displayListContracts();
                break;
                case "5": bookingService.editContracts();
                break;
                case "6": flag = false;
                default:
                    System.out.println("Nhap sai, moi nhap lai");
            }
        } while (flag);
    }
}
