package controllers;

import Service.impl.EmployeeServiceImpl;
import Service.person_service.EmployeeService;

import java.util.Scanner;

public class EmployeeManagement {
    public static void employeeManagement() {
        Scanner scanner = new Scanner(System.in);
        EmployeeService employeeService = new EmployeeServiceImpl();
        boolean flag = true;
        String number;
        do {
            System.out.println("1 Display list employees");
            System.out.println("2 Add new employee");
            System.out.println("3 Edit employee");
            System.out.println("4 Return main menu");
            System.out.println("Moi nhap so");
            number = scanner.nextLine();
            switch (number) {
                case "1": employeeService.display();
                    break;
                case "2": employeeService.add();
                    break;
                case "3": employeeService.edit();
                    break;
                case "4":
                    flag = false;
                default:
                    System.out.println("Nhap sai so, moi nhap lai");
            }
        } while (flag);
    }
}
