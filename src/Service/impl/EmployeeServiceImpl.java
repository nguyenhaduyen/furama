package Service.impl;

import Service.person_service.EmployeeService;
import common.*;
import models.person.Employee;
import util.ReadAndWriteEmployee;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeServiceImpl implements EmployeeService {
    Scanner scanner = new Scanner(System.in);

    @Override
    public void add() {
        List<Employee> employees = new ArrayList<>();
        String name = "";
        do {
            System.out.println("Moi nhap ten");
            name = scanner.nextLine();
        } while (!CheckName.checkName(name));
        LocalDate dateOfBirth = null;
        boolean isOke = true;
        do {
            isOke = false;
            try {
                System.out.println("Nhap ngay thang nam sinh");
                dateOfBirth = LocalDate.parse(scanner.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
              if (dateOfBirth.until(LocalDate.now()).getYears()<18||dateOfBirth.until(LocalDate.now()).getYears()>100){
                  System.out.println("Lon hon 100 tuoi hoac chua du 18 tuoi");
                  isOke = true;
              }else {
                  isOke=false;
              }
            } catch (DateTimeParseException e) {
                System.out.println("Nhap sai dinh dang");
                isOke = true;
            }
        } while (isOke);
        System.out.println("Nhap gioi tinh");
        String gender = "";
        boolean flag3 = true;
        do {
            System.out.println("1.nu");
            System.out.println("2.nam");
            System.out.println("Moi nhap so");
            String number = scanner.nextLine();
            switch (number) {
                case "1":
                    gender = "nu";
                    flag3 = false;
                    break;
                case "2":
                    gender = "nam";
                    flag3 = false;
                    break;
                default:
                    System.out.println("Nhap khong dung so, moi nhap lai");
            }
        } while (flag3);
        String id = "";
        boolean isOke3 = true;
        do {
            System.out.println("Nhap id");
            id = scanner.nextLine();
            if (!CheckCodeIDEmployee.checkCodeID(id) && CheckID.checkID(id)) {
                isOke3 = false;
            } else {
                System.out.println("trung CMND hoac CMND ko dung dinh dang nen nhap lai");
                isOke3 = true;
            }
        } while (isOke3);
        String phoneNumber = null;
        do {
            System.out.println("Nhap sdt");
            phoneNumber = scanner.nextLine();
        } while (!CheckTelephoneNumber.checkTelephone(phoneNumber));
        String email = "";
        do {
            System.out.println("Moi nhap email");
            email = scanner.nextLine();
        } while (!CheckEmail.checkMail(email));
        String employeeCode = "";
        boolean isOke5 = true;
        do {
            System.out.println("Nhap ma nhan vien");
             employeeCode = scanner.nextLine();
             if (!CheckCodeEmployee.checkCodeEmployee(employeeCode)) {
                 isOke5 = false;
             } else {
                 System.out.println("Ma nhan vien da bi trung voi nhan vien truoc, moi nhap lai ma moi");
                 isOke5 = true;
             }
        } while (isOke5);
        System.out.println("Nhap trinh do hoc van");
        String academicLevel = "";
        boolean flag = true;
        do {
            System.out.println("1. Trung cap" +
                    "\n2. Cao dang" +
                    "\n3. Dai hoc" +
                    "\n4.Sau dai hoc");
            System.out.println("Nhap so");
            String number = scanner.nextLine();
            switch (number) {
                case "1":
                    academicLevel = "Trung cap";
                    flag = false;
                    break;
                case "2":
                    academicLevel = "Cao dang";
                    flag = false;
                    break;
                case "3":
                    academicLevel = "Dai hoc";
                    flag = false;
                    break;
                case "4":
                    academicLevel = "Sau dai hoc";
                    flag = false;
                    break;
                default:
                    System.out.println("Nhap khong dung so, moi nhap lai");
                    break;
            }
        } while (flag);
        System.out.println("Nhap chuc vu");
        String status = "";
        boolean flag1 = true;
        String number1;
        do {
            System.out.println("1. Le tan" +
                    "\n2. Phuc vu" +
                    "\n3. Chuyen vien" +
                    "\n4.Giam sat" +
                    "\n5. Quan ly" +
                    "\n6 Giam doc");
            System.out.println("moi nhap so");
            number1 = scanner.nextLine();
            switch (number1) {
                case "1":
                    status = "Le tan";
                    flag1 = false;
                    break;
                case "2":
                    status = "Phuc vu";
                    flag1 = false;
                    break;
                case "3":
                    status = " Chuyen vien";
                    flag1 = false;
                    break;
                case "4":
                    status = "Giam sat";
                    flag1 = false;
                    break;
                case "5":
                    status = "Quan ly";
                    flag1 = false;
                    break;
                case "6":
                    status = "Giam doc";
                    flag1 = false;
                    break;
                default:
                    System.out.println("Nhap khong dung so, moi nhap lai");
                    break;
            }
        } while (flag1);
        boolean isOke1 = true;
        Double salary = null;
        do {
            isOke1 = false;
            try {
                System.out.println("Nhap luong");
                salary = Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Nhap sai dinh dang moi nhap lai");
                isOke1 = true;
            }
        } while (isOke1);
        employees.add(new Employee(name, dateOfBirth, gender, id, phoneNumber, email, employeeCode, academicLevel, status, salary));
        String pathFileEmployee = "src/data/employee_data.csv";
        ReadAndWriteEmployee.writeEmployee(employees, pathFileEmployee, true);
    }

    public void display() {
        String pathFileEmployee = "src/data/employee_data.csv";
        List<Employee> employees = ReadAndWriteEmployee.readEmployee(pathFileEmployee);
        for (Employee e : employees) {
            System.out.println(e);
        }
    }

    @Override
    public void edit() {
        List<Employee> employees = ReadAndWriteEmployee.readEmployee("src/data/employee_data.csv");
        System.out.println("Nhap id can sua");
        String id = scanner.nextLine();
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getId().equals(id)) {
                String name = "";
                do {
                    System.out.println("Moi nhap ten");
                    name = scanner.nextLine();
                } while (!CheckName.checkName(name));
                employees.get(i).setName(name);
                LocalDate dateOfBirth = null;
                boolean isOke2 = true;
                do {
                    isOke2 = false;
                    try {
                        System.out.println("Nhap ngay sinh");
                        dateOfBirth = LocalDate.parse(scanner.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                        if (dateOfBirth.until(LocalDate.now()).getYears()<18||dateOfBirth.until(LocalDate.now()).getYears()>100){
                            System.out.println("Lon hon 100 tuoi hoac chua du 18 tuoi");
                            isOke2 = true;
                        }else {
                            isOke2=false;
                        }
                    }catch (DateTimeParseException e) {
                        System.out.println("Nhap sai dinh dang, moi nhap lai");
                        isOke2 = true;
                    }
                } while (isOke2
                );
                employees.get(i).setDateOfBirth(dateOfBirth);
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
                            employees.get(i).setGender("nu");
                            flag = false;
                            break;
                        case "2":
                            employees.get(i).setGender("nam");
                            flag = false;
                            break;
                        default:
                            System.out.println("Nhap khong dung so, moi nhap lai");
                    }
                } while (flag);
                String newId = "";
                do {
                    System.out.println("Nhap CMND can sua");
                    newId = scanner.nextLine();
                } while (!CheckID.checkID(newId));
                employees.get(i).setId(newId);
                String telephoneNumber = "";
                do {
                    System.out.println("Nhap so dien thoai");
                    telephoneNumber = scanner.nextLine();
                } while (!CheckTelephoneNumber.checkTelephone(telephoneNumber));
                employees.get(i).setPhoneNumber(telephoneNumber);
                String email = "";
                do {
                    System.out.println("Nhap email");
                    email = scanner.nextLine();
                } while (!CheckEmail.checkMail(email));
                employees.get(i).setEmail(email);
                System.out.println("Nhap ma nhan vien");
                employees.get(i).setEmployeeCode(scanner.nextLine());
                System.out.println("Nhap trinh do hoc van");
                String academicLevel = "";
                boolean flag1 = true;
                do {
                    System.out.println("1. Trung cap" +
                            "\n2. Cao dang" +
                            "\n3. Dai hoc" +
                            "\n4.Sau dai hoc");
                    System.out.println("Nhap so");
                    String number = scanner.nextLine();
                    switch (number) {
                        case "1":
                            employees.get(i).setAcademicLevel("Trung cap");
                            flag1 = false;
                            break;
                        case "2":
                            employees.get(i).setAcademicLevel("Cao dang");
                            flag1 = false;
                            break;
                        case "3":
                            employees.get(i).setAcademicLevel("Dai hoc");
                            flag1 = false;
                            break;
                        case "4":
                            employees.get(i).setAcademicLevel("Sau dai hoc");
                            flag1 = false;
                            break;
                        default:
                            System.out.println("Nhap sai so, moi nhap lai");
                    }
                } while (flag1);
                System.out.println("Nhap chuc vu");
                String status = "";
                boolean flag2 = true;
                String number;
                do {
                    System.out.println("1. Le tan" +
                            "\n2. Phuc vu" +
                            "\n3. Chuyen vien" +
                            "\n4.Giam sat" +
                            "\n5. Quan ly" +
                            "\n6 Giam doc");
                    System.out.println("moi nhap so");
                    number = scanner.nextLine();
                    switch (number) {
                        case "1":
                            employees.get(i).setStatus("Le tan");
                            flag2 = false;
                            break;
                        case "2":
                            employees.get(i).setStatus("Phuc vu");
                            flag2 = false;
                            break;
                        case "3":
                            employees.get(i).setStatus("Chuyen vien");
                            flag2 = false;
                            break;
                        case "4":
                            employees.get(i).setStatus("Giam sat");
                            flag2 = false;
                            break;
                        case "5":
                            employees.get(i).setStatus("Quan ly");
                            flag2 = false;
                            break;
                        case "6":
                            employees.get(i).setStatus("Giam doc");
                            flag2 = false;
                            break;
                        default:
                            System.out.println("Nhap sai so, moi nhap lai");
                    }
                } while (flag2);
                boolean isOke = true;
                Double salary = null;
                do {
                    isOke = false;
                    try {
                        System.out.println("moi nhap luong");
                        salary = Double.parseDouble(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Nhap sai dinh dang, moi nhap lai");
                        isOke = true;
                    }
                } while (isOke);
                employees.get(i).setSalary(salary);
            }
        }
        ReadAndWriteEmployee.writeEmployee(employees, "src/data/employee_data.csv", false);
    }
}

//    @Override
//    public void delete() {
//        System.out.println("Nhap id(CMND) can xoa");
//        int id = Integer.parseInt(scanner.nextLine());
//        for (int i = 0; i < employees.size() ; i++) {
//           if(employees.get(i).getId()==id) {
//               employees.remove(employees.get(i));
//               return;
//           }
//        }
//        System.out.println("Khong ton tai CMND do");
//        display();
//    }


