package util;

import models.person.Customer;

import java.io.*;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

public class ReadAndWriteCustomer {
    public static List<Customer> readFileCustomer(String pathFile) {
        List<Customer> customerList = new LinkedList<>();
        File file = new File(pathFile);
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        try {
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            String str = "";
            while ((str = bufferedReader.readLine()) != null) {
                String[] arr = str.split(",");
                customerList.add(new Customer(arr[0], LocalDate.parse(arr[1]), arr[2], (arr[3]), arr[4], arr[5], arr[6], arr[7], arr[8]));
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return customerList;
    }
    public static void writeFileCustomer(List<Customer> customerList,String pathFile,boolean append){
        File file = new File ("src/data/customer_data.csv");
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        try {
            fileWriter = new FileWriter(file,append);
            bufferedWriter = new BufferedWriter(fileWriter);
            for (Customer c: customerList) {
                bufferedWriter.write(c.getInfoCSVToCustomer());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

