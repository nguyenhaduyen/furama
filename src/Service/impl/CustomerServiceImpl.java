package Service.impl;

import Service.person_service.CustomerService;
import common.*;
import models.person.Customer;
import util.ReadAndWriteCustomer;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
public class CustomerServiceImpl implements CustomerService {
    Scanner scanner = new Scanner(System.in);
    @Override
    public void add() {
        String name ="";
        do {
            System.out.println("Moi nhap ten");
            name = scanner.nextLine();
        }while (!CheckName.checkName(name));
        LocalDate dateOfBirth = null;
        boolean isOke10 = true;
        do {
            isOke10 = false;
            try {
                System.out.println("Nhap ngay thang nam sinh");
                dateOfBirth = LocalDate.parse(scanner.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                if (dateOfBirth.until(LocalDate.now()).getYears()<18||dateOfBirth.until(LocalDate.now()).getYears()>100){
                    System.out.println("Lon hon 100 tuoi hoac chua du 18 tuoi");
                    isOke10 = true;
                }else {
                    isOke10=false;
                }
            } catch (DateTimeParseException e) {
                System.out.println("Nhap sai dinh dang");
                isOke10 = true;
            }
        } while (isOke10);
        System.out.println("Nhap gioi tinh");
        String gender = "";
        boolean flag = true;
        do {
            System.out.println("1.nu");
            System.out.println("2.nam");
            System.out.println("Moi nhap so");
            String number = scanner.nextLine();
            switch (number) {
                case "1": gender = "nu";
                flag = false;
                break;
                case "2" : gender = "nam";
                flag = false;
                break;
                default:
                    System.out.println("Moi nhap lai");
            }
        } while (flag);
        String id = "";
        boolean isOke1 = true;
        do {
            System.out.println("Moi nhap CMND khach hang");
            id = scanner.nextLine();
            if (!CheckCodeIDCustomer.checkCodeID(id) && CheckID.checkID(id)) {
                isOke1 = false;
            } else {
                System.out.println("CMND khach da nhap bi trung hoac nhap sai dinh dang");
                isOke1 = true;
            }
        } while (isOke1);
        String phoneNumber = "";
        do {
            System.out.println("Nhap sdt");
            phoneNumber = scanner.nextLine();
        } while (!CheckTelephoneNumber.checkTelephone(phoneNumber));
        String email ="";
        do {
            System.out.println("Moi nhap email");
            email = scanner.nextLine();
        }while (!CheckEmail.checkMail(email));
        String customerCode = "";
        boolean isOke6 = true;
        do {
            System.out.println("Moi nhap ma KH");
            customerCode = scanner.nextLine();
            if (!CheckCodeCustomer.checkCodeCustomer(customerCode)) {
                isOke6 = false;
            } else {
                System.out.println("Ma Khach Hang moi bi trung voi ma KH cu, moi nhap lai");
                isOke6 = true;
            }
        } while (isOke6);
        System.out.println("Nhap loai khach hang");
        String typeOfCustomer = "";
        do {
            System.out.println("1.Diamond" +
                    "\n2.Platinum," +
                    "\n3. Gold" +
                    "\n4.Silver" +
                    "\n5.Member");
            System.out.println("Nhap so");
            String number = scanner.nextLine();
            switch (number) {
                case "1":
                    typeOfCustomer = "Diamond";
                    break;
                case "2":
                    typeOfCustomer = "Platinum";
                    break;
                case "3":
                    typeOfCustomer = "Gold";
                    break;
                case "4":
                    typeOfCustomer = "Silver";
                    break;
                case "5":
                    typeOfCustomer = "Member";
                    break;
                default:
                    System.out.println("Nhap sai so, moi nhap lai");
            }
        } while (typeOfCustomer.equals("")) ;
        System.out.println("Nhap dia chi");
        String address = scanner.nextLine();
        List<Customer> customers = new LinkedList<>();
        customers.add(new Customer(name,dateOfBirth,gender,id,phoneNumber,email,customerCode,typeOfCustomer,address));
        String pathFile = "src/data/customer_data.csv";
        ReadAndWriteCustomer.writeFileCustomer(customers,pathFile,true);
        display();
    }

    @Override
    public void edit() {
        List<Customer> customers = ReadAndWriteCustomer.readFileCustomer("src/data/customer_data.csv");
        System.out.println("Moi nhap CMND can chinh sua doi tuong");
        String id = scanner.nextLine();
        for (int i = 0; i < customers.size() ; i++) {
            if (customers.get(i).getId().equals(id)) {
                String name = "";
                do {
                    System.out.println("Moi nhap ten");
                    name = scanner.nextLine();
                } while (!CheckName.checkName(name));
                customers.get(i).setName(name);
                LocalDate dateOfBirth = null;
                boolean isOke = true;
                do {
                    isOke = false;
                    try {
                        System.out.println("Nhap ngay sinh");
                        dateOfBirth = LocalDate.parse(scanner.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                        if (dateOfBirth.until(LocalDate.now()).getYears()<18||dateOfBirth.until(LocalDate.now()).getYears()>100){
                            System.out.println("Lon hon 100 tuoi hoac chua du 18 tuoi");
                            isOke = true;
                        }else {
                            isOke=false;
                        }
                    }catch (DateTimeParseException e) {
                        System.out.println("Nhap sai dinh dang, moi nhap lai");
                        isOke = true;
                    }
                } while (isOke);
                customers.get(i).setDateOfBirth(dateOfBirth);
                System.out.println("Nhap gioi tinh");
                String gender = "";
                boolean flag = true;
                do {
                    System.out.println("1.nu");
                    System.out.println("2.nam");
                    System.out.println("Moi nhap so");
                    String number = scanner.nextLine();
                    switch (number) {
                        case "1":
                            customers.get(i).setGender("nu");
                            flag = false;
                            break;
                        case "2" :
                            customers.get(i).setGender("nam");
                            flag = false;
                        default:
                            System.out.println("Nhap sai so, moi nhap lai");
                    }
                } while (flag);
                String newId = "";
                do {
                    System.out.println("Nhap CMND can sua");
                    newId = scanner.nextLine();
                } while (!CheckID.checkID(newId));
                customers.get(i).setId(newId);
                String phoneNumber = "";
                do {
                    System.out.println("Nhap sdt");
                    phoneNumber = scanner.nextLine();
                    CheckTelephoneNumber.checkTelephone(phoneNumber);
                } while (!CheckTelephoneNumber.checkTelephone(phoneNumber));
                String email ="";
                do {
                    System.out.println("Nhap email");
                    email = scanner.nextLine();
                } while (!CheckEmail.checkMail(email));
                customers.get(i).setEmail(email);
                System.out.println("Nhap ma KH");
                customers.get(i).setCustomerCode(scanner.nextLine());
                System.out.println("Nhap loai KH");
                boolean flag3 = true;
                do {
                    System.out.println("1.Diamond" +
                            "\n2.Platinum," +
                            "\n3. Gold" +
                            "\n4.Silver" +
                            "\n5.Member");
                    System.out.println("Nhap so");
                    String number = scanner.nextLine();
                    switch (number) {
                        case "1":
                            customers.get(i).setTypeOfCustomer("Diamond");
                            flag3 = false;
                            break;
                        case "2":
                           customers.get(i).setTypeOfCustomer("Platinum");
                           flag3 = false;
                            break;
                        case "3":
                            customers.get(i).setTypeOfCustomer("Gold");
                            flag3 = false;
                            break;
                        case "4":
                            customers.get(i).setTypeOfCustomer("Silver");
                            flag3 = false;
                            break;
                        case "5":
                            customers.get(i).setTypeOfCustomer("Member");
                            flag3 = false;
                            break;
                        default:
                            System.out.println("Nhap sai so, moi nhap lai");
                            break;
                    }
                } while (flag3) ;
                System.out.println("Moi nhap lai dia chi");
                customers.get(i).setAddress(scanner.nextLine());
                ReadAndWriteCustomer.writeFileCustomer(customers,"src/data/customer_data.csv",false);
            }
        }
    }
    public void display() {
        List<Customer> customers = ReadAndWriteCustomer.readFileCustomer("src/data/customer_data.csv");
        for (Customer c: customers) {
            System.out.println(c);
        }
}
}
