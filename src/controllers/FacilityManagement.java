package controllers;

import Service.facility_service.HouseService;
import Service.facility_service.RoomService;
import Service.facility_service.VillaService;
import Service.impl.HouseServiceImpl;
import Service.impl.RoomServiceImpl;
import Service.impl.VillaServiceImpl;

import java.util.Scanner;

public class FacilityManagement {
    public static void facilityManagement() {
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        do {
            System.out.println("1 Display list facility");
            System.out.println("2 Add new facility");
            System.out.println("3 Display list facility maintenance");
            System.out.println("4 Return main menu");
            System.out.println("Moi nhap so");
            String number3 = scanner.nextLine();
            switch (number3) {
                case "1":
                    VillaService villaService = new VillaServiceImpl();
                    HouseService houseService = new HouseServiceImpl();
                    RoomService roomService = new RoomServiceImpl();
                    villaService.displayListFacility();
                    houseService.displayListFacility();
                    roomService.displayListFacility();
                    break;
                case "2":
                    addNewFacility();
                    break;
                case "3":
                    break;
                case "4": flag = false;
            }
        } while (flag);
    }

    public static void addNewFacility() {
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        do {
            System.out.println("1. Add New Villa");
            System.out.println("2. Add New House");
            System.out.println("3. Add New Room");
            System.out.println("4. Back to menu");
            System.out.println("Moi nhap so");
            String number = scanner.nextLine();
            switch (number) {
                case "1":
                    VillaService villaService = new VillaServiceImpl();
                    villaService.addNewFacility();
                    break;
                case "2":
                    HouseService houseService = new HouseServiceImpl();
                    houseService.addNewFacility();
                    break;
                case "3":
                    RoomService roomService = new RoomServiceImpl();
                    roomService.addNewFacility();
                    break;
                case "4":
                    flag = false;
                    break;
                default:
                    System.out.println("Nhap sai so, moi nhap lai");
                    break;
            }
        } while (flag);
    }
}
