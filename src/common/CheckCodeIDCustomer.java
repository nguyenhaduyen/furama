package common;

import models.person.Customer;
import models.person.Employee;
import util.ReadAndWriteCustomer;
import util.ReadAndWriteEmployee;

import java.util.List;
import java.util.Scanner;

public class CheckCodeIDCustomer {
    public static boolean checkCodeID(String id) {
        Scanner scanner = new Scanner(System.in);
        List<Customer> customerList = ReadAndWriteCustomer.readFileCustomer("src/data/customer_data.csv");
        for (int i = 0; i < customerList.size(); i++) {
            if (customerList.get(i).getId().equals(id)) {
                return true;
            }
        }
        return false;
    }
}

