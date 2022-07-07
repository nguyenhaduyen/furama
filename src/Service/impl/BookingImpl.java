package Service.impl;

import Service.BookingService;
import models.Booking;
import models.facility.House;
import models.facility.Room;
import models.facility.Villa;
import models.person.Customer;
import util.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

public class BookingImpl implements BookingService {
    static Scanner scanner = new Scanner(System.in);

    @Override
    public void addNewBooking() {
        System.out.println("Moi nhap ma hop dong");
        String bookingCode = scanner.nextLine();
        Boolean flag = true;
        LocalDate start = null;
        do {
            flag = false;
            try {
                System.out.println("Moi nhap ngay check in");
                start = LocalDate.parse(scanner.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            } catch (DateTimeParseException e) {
                System.out.println("Nhap sai dinh dang, moi nhap lai");
                flag = true;
            }
        } while (flag);
        Boolean isOke = true;
        LocalDate end = null;
        do {
            isOke = false;
            try {
                System.out.println("Moi nhap ngay check out");
                end = LocalDate.parse(scanner.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));

            } catch (DateTimeParseException e) {
                System.out.println("Nhap sai dinh dang, moi nhap lai");
                isOke = true;
            }
        } while (isOke);


        List<Customer> customerList = ReadAndWriteCustomer.readFileCustomer("src/data/customer_data.csv");
        for (int i = 0; i < customerList.size(); i++) {
            System.out.println((i+1) + ". " + customerList.get(i).getCustomerCode() + ", name: " + customerList.get(i).getName());
        }
        int choose;
        do {
            System.out.println("Lay ma KH");
            try {
                choose = Integer.parseInt(scanner.nextLine());
                if (choose < 1 || choose > customerList.size()) {
                    System.err.println("khong co ma khach hang");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.err.println("nhap sai dinh dang, nhap lai");
            }
        } while (true);
        String customerCode = customerList.get(choose - 1).getCustomerCode();

        boolean flag3 = true;
        int index=1;
        String serviceCode = "";
        String kinOfService = "";
        do {
            System.out.println("Moi loai dich vu");
            System.out.println("1.House");
            System.out.println("2.Villa");
            System.out.println("3.Room");
            String number = scanner.nextLine();
            int choose1 = 0;
            switch (number) {
                case "1":
//                    index = 1;
                    Map<House, Integer> houseMap = ReadAndWriteHouse.readFileHouse("src/data/house_data.csv");
                    List<House> houseList = new ArrayList<>(houseMap.keySet());
                    if (houseList.isEmpty()){
                        System.out.println("khong co house trong");
                        flag3 =true;
                    }else {
                        kinOfService = "House";
                        for (House h : houseList) {
                            System.out.println((index++) + ". " + h.getServiceCode());
                        }
                        do {
                            try {
                                System.out.println("Moi nhap dich vu");
                                choose1 = Integer.parseInt(scanner.nextLine());
                            } catch (NumberFormatException e) {
                                System.out.println("nhap lai");
                            }
                        } while (choose1 < 1 || choose1 > houseList.size());
                        serviceCode = houseList.get(choose1 - 1).getServiceCode();
                        flag3 = false;
                    }
                    break;
                case "2":
//                    index = 1;
                    Map<Villa, Integer> villaMap = ReadAndWriteVilla.readFileVilla("src/data/villa_data.csv");
                    List<Villa> villaList = new ArrayList<>(villaMap.keySet());
                    if (villaList.isEmpty()){
                        System.out.println("khong co villa trong");
                        flag3 = true;
                    }else {
                        kinOfService = "House";
                        for (Villa v : villaList) {
                            System.out.println((index++) + "." + v.getServiceCode());
                        }
                        do {
                            try {
                                System.out.println("Moi nhap dich vu");
                                choose1 = Integer.parseInt(scanner.nextLine());
                            } catch (NumberFormatException e) {
                                System.out.println("Nhap sai, ko co ");
                            }
                        } while (choose1 < 1 || choose1 > villaList.size());
                        serviceCode = villaList.get(choose1 - 1).getServiceCode();
                        flag3 = false;
                    }
                    break;
                case "3":
//                    index = 1;
                    Map<Room, Integer> roomMap = ReadAndWriteRoom.readFileRoom("src/data/room_data.csv");
                    List<Room> roomList = new ArrayList<>(roomMap.keySet());
                    if (roomList.isEmpty()){
                        System.out.println("khong co phong trong");
                        flag3 =true;
                    }else {
                        kinOfService = "House";
                        for (Room r : roomList) {
                            System.out.println((index++) +","+r.getServiceCode());
                        }
                        do {
                            try {
                                System.out.println("Moi nhap dich vu");
                                choose1 = Integer.parseInt(scanner.nextLine());
                            } catch (NumberFormatException e) {
                                System.out.println("Nhap sai dinh dang, moi nhap lai");
                            }
                        } while (choose1 < 1 || choose1 > roomList.size());
                        serviceCode = roomList.get(choose1 - 1).getServiceCode();
                        flag3 = false;
                    }
                    break;
            }
        } while (flag3);
        Set<Booking> bookingSet = new TreeSet<>();
        bookingSet.add(new Booking(bookingCode, start, end, customerCode, serviceCode, kinOfService));
        ReadAndWriteBooking.writeFileBooking("src/data/booking_data.csv",bookingSet,true);
        Map <Room,Integer> roomMap = ReadAndWriteRoom.readFileRoom("src/data/room_data.csv");
        Set<Room> roomList = roomMap.keySet();
            for (Room r: roomList) {
                if (serviceCode.equals(r.getServiceCode())){
                    roomMap.replace(r,roomMap.get(r)+1);
                }
            }
            ReadAndWriteRoom.writeFileRoom("src/data/room_data.csv",roomMap,false);
        Map <Villa,Integer> villaMap =  ReadAndWriteVilla.readFileVilla("src/data/villa_data.csv");
        Set <Villa> villaSet = villaMap.keySet();
        for (Villa v: villaSet) {
            if(serviceCode.equals(v.getServiceCode())) {
                villaMap.replace(v,villaMap.get(v)+1);
            }
        }
        ReadAndWriteVilla.writeFileVilla(villaMap,"src/data/villa_data.csv",false);
        Map <House,Integer> houseMap = ReadAndWriteHouse.readFileHouse("src/data/house_data.csv");
        Set <House> houseSet = houseMap.keySet();
        for (House h : houseSet) {
            if (serviceCode.equals(h.getServiceCode())) {
                houseMap.replace(h,houseMap.get(h)+1);
            }
        }
        ReadAndWriteHouse.writeFileHouse("src/data/house_data.csv",houseMap,false);
    }

    @Override
    public void displayListBooking() {
        Set <Booking> bookingSet = ReadAndWriteBooking.readFileBooking("src/data/booking_data.csv");
        for (Booking b: bookingSet) {
            System.out.println(b);
        }
    }

    @Override
    public void createNewContracts() {

    }

    @Override
    public void displayListContracts() {

    }

    @Override
    public void editContracts() {

    }
}
