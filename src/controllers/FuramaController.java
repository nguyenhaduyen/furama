package controllers;
import java.util.Scanner;

public class FuramaController {
    public static void furamaController() {
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        String number;
        do {
            System.out.println("1.Employee Management");
            System.out.println("2.Customer Management");
            System.out.println("3.Facility Management");
            System.out.println("4.Booking Management");
            System.out.println("5.Promotion Management");
            System.out.println("6.Exit");
            System.out.println("Moi nhap so");
            number = scanner.nextLine();
            switch (number) {
                case "1":
                    EmployeeManagement.employeeManagement();
                    break;
                case "2":
                    CustomerManagement.customerManagement();
                    break;
                case "3":
                    FacilityManagement.facilityManagement();
                    break;
                case "4":
                    BookingManagement.bookingManagement();
                    break;
                case "5":
                    PromotionManagement.promotionManagement();
                    break;
                case "6":
                    flag = false;
                default:
                    System.out.println("Nhap sai so, moi nhap lai");
            }
        }
        while (flag);
    }
}
