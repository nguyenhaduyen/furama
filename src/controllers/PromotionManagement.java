package controllers;

import java.util.Scanner;

public class PromotionManagement {
    public static void promotionManagement () {
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        int number5;
        do {
            System.out.println("1. Display list customers use service");
            System.out.println("2. Display list customers get voucher");
            System.out.println("3. Return main menu");
            System.out.println("Nhap so");
            number5 = Integer.parseInt(scanner.nextLine());
        } while (flag);
    }
}
