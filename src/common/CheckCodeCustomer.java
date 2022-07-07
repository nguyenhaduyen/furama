package common;

import models.person.Customer;
import util.ReadAndWriteCustomer;

import java.util.List;

public class CheckCodeCustomer {
    public static boolean checkCodeCustomer(String customerCode) {
        List<Customer> customerList = ReadAndWriteCustomer.readFileCustomer("src/data/customer_data.csv");
        for (int i = 0; i < customerList.size(); i++) {
            if (customerList.get(i).getCustomerCode().equals(customerCode)) {
                ;
                return true;
            }
        }
        return false;
    }
}

