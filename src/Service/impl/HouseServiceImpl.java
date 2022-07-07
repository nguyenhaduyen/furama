package Service.impl;

import Service.facility_service.HouseService;
import common.CheckServiceCodeHouse;
import common.CheckServiceName;
import models.facility.House;
import util.ReadAndWriteHouse;

import java.util.*;

public class HouseServiceImpl implements HouseService {
    Scanner scanner = new Scanner(System.in);

    @Override
    public void displayListFacility() {
        Map<House, Integer> houseMap = ReadAndWriteHouse.readFileHouse("src/data/house_data.csv");
        Set<House> houseSet = houseMap.keySet();
        for (House h : houseSet) {
            System.out.println(h + "," + houseMap.get(h));
        }
    }

    @Override
    public void addNewFacility() {
        String serviceName = "";
        do {
            System.out.println("Nhap ten dich vu");
            serviceName = scanner.nextLine();
        } while (!CheckServiceName.checkServiceName(serviceName));
        boolean flag = true;
        double usableArea = 0;
        do {
            try {
                System.out.println("Nhap dien tich dat su dung");
                usableArea = Double.parseDouble(scanner.nextLine());
                if (usableArea > 30) {
                    flag = false;
                } else {
                    System.out.println("Dien tich su dung phai lon hon 30m2, moi nhap lai");
                    flag = true;
                }
            } catch (NumberFormatException e) {
                System.err.println("Nhap sai dinh dang, nhap lai");
                flag = true;
            }
        } while (flag);
        double costRent = 0;
        boolean flag9 = true;
        do {
            flag9 = false;
            try {
                System.out.println("Nhap chi phi thue");
                costRent = Double.parseDouble(scanner.nextLine());
                if (costRent > 0) {
                    flag9 = false;
                } else {
                    System.out.println("Chi phi thue phai la so duong");
                    flag9 = true;
                }
            } catch (NumberFormatException e) {
                System.err.println("Nhap  sai dinh dang, nhap lai");
                flag9 = true;
            }
        } while (flag9);
        int maximumNumberOfPeople = 0;
        boolean flag7 = true;
        do {
            try {
                System.out.println("Nhap so luong nguoi toi da");
                maximumNumberOfPeople = Integer.parseInt(scanner.nextLine());
                if (maximumNumberOfPeople < 20 && maximumNumberOfPeople > 0) {
                    flag7 = false;
                } else {
                    System.out.println("Số lượng người tối đa phải >0 và nhỏ hơn 20");
                    flag7 = true;
                }
            } catch (NumberFormatException e) {
                System.err.println("Nhap sai dinh dang, moi nhap lai");
                flag7 = true;
            }
        } while (flag7);
        String rentalType = null;
        boolean flag4 = true;
        do {
            System.out.println("Chon kieu thue");
            System.out.println("1.Thue theo nam");
            System.out.println("2.Thue theo thang");
            System.out.println("3.Thue theo ngay");
            System.out.println("4.Thue theo gio");
            String num = scanner.nextLine();
            switch (num) {
                case "1":
                    rentalType = "Thue theo nam";
                    flag4 = false;
                    break;
                case "2":
                    rentalType = "Thue theo thang";
                    flag4 = false;
                    break;
                case "3":
                    rentalType = "Thue theo ngay";
                    flag4 = false;
                    break;
                case "4":
                    rentalType = "Thue theo gio";
                    flag4 = false;
                    break;
                default:
                    System.out.println("Nhap sai so moi nhap lai");
                    break;
            }
        } while (flag4);
        String serviceCode = "";
        do {
            System.out.println("Moi nhap ma dich vu");
            serviceCode = scanner.nextLine();
        } while (!CheckServiceCodeHouse.checkServiceCodeHouse(serviceCode));
        System.out.println("Nhap tieu chuan phong");
        String roomStandard = scanner.nextLine();
        int numberOfFloor = 0;
        boolean isOke3 = true;
        do {
            try {
                System.out.println("Nhap so tang");
                numberOfFloor = Integer.parseInt(scanner.nextLine());
                if (numberOfFloor > 0) {
                    isOke3 = false;
                } else {
                    System.out.println("So tang phai la so nguyen duong");
                    isOke3 = true;
                }
            } catch (NumberFormatException e) {
                System.err.println("Nhap sai dinh dang, moi nhap lai");
            }
        }
        while (isOke3);
        Map<House, Integer> houseList = new LinkedHashMap<>();
        houseList.put(new House(serviceName, usableArea, costRent, maximumNumberOfPeople, rentalType, serviceCode, roomStandard, numberOfFloor), 0);
        String path = "src/data/house_data.csv";
        ReadAndWriteHouse.writeFileHouse(path, houseList, true);
    }

    @Override
    public void displayListFacilityMaintenance() {
        Map<House, Integer> houseMap = ReadAndWriteHouse.readFileHouse("src/data/booking_data.csv");
        Set<House> houseSet = houseMap.keySet();
        for (House h : houseSet) {
            if (houseMap.get(h) == 5) {
                System.out.println(h);
            }
        }
    }
}

