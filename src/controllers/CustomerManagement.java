package controllers;

import Service.impl.CustomerServiceImpl;
import Service.person_service.CustomerService;

import java.util.Scanner;

public class CustomerManagement {
    public static void customerManagement() {
        Scanner scanner = new Scanner(System.in);
        CustomerService customerService = new CustomerServiceImpl();
        boolean flag = true;
        String number2;
        do{
            System.out.println("1. Display list customers");
            System.out.println("2. Add new customer");
            System.out.println("3. Edit customer");
            System.out.println("4. Return main menu");
            System.out.println("Moi nhap so");
            number2 = scanner.nextLine();
            switch (number2) {
                case "1": customerService.display();
                    break;
                case "2": customerService.add();
                    break;
                case "3": customerService.edit();
                    break;
                case "4": flag = false;
                default:
                    System.out.println("Nhap sai so, moi nhap lai");
            }
        } while (flag);
    }
}
