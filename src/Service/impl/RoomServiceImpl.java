package Service.impl;

import Service.facility_service.RoomService;
import common.CheckServiceCodeRoom;
import common.CheckServiceName;
import models.facility.Room;
import util.ReadAndWriteRoom;

import java.util.*;

public class RoomServiceImpl implements RoomService {
    Scanner scanner = new Scanner(System.in);

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
                System.err.println("Nhap sai dinh dang, moi nhap lai");
                flag = true;
            }
        } while (flag);
        double costRent = 0;
        boolean flag9 = true;
        do {
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
                System.err.println("Nhap sai dinh dang, moi nhap lai");
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
            }catch (NumberFormatException e) {
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
        } while (!CheckServiceCodeRoom.checkServiceCodeRoom(serviceCode));
        System.out.println("Nhap dich vu mien phi di kem");
        String freeService = scanner.nextLine();
        Map<Room, Integer> roomMap = new LinkedHashMap<>();
        roomMap.put(new Room(serviceName, usableArea, costRent, maximumNumberOfPeople, rentalType, serviceCode, freeService), 0);
        String path = "src/data/room_data.csv";
        ReadAndWriteRoom.writeFileRoom(path, roomMap, true);
    }

    @Override
    public void displayListFacility() {
        Map<Room, Integer> roomMap = ReadAndWriteRoom.readFileRoom("src/data/room_data.csv");
        Set<Room> roomSet = roomMap.keySet();
        for (Room r : roomSet) {
            System.out.println(r + "," + roomMap.get(r));
        }
    }

    @Override
    public void displayListFacilityMaintenance() {
        Map<Room, Integer> romMap = ReadAndWriteRoom.readFileRoom("src/models/facility/Room.java");
        Set<Room> roomSet = romMap.keySet();
        for (Room r : roomSet) {
            if (romMap.get(r) == 5) {
                System.out.println(r);
            }
        }
    }
}
