package util;

import models.person.Employee;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWriteEmployee {
    public static List<Employee> readEmployee(String pathFile) {
        List <Employee> employeeList = new ArrayList<>();
        File file = new File ("src/data/employee_data.csv");
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        try {
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            String str = "";
            while ((str=bufferedReader.readLine())!=null) {
                String [] arr = str.split(",");
                employeeList.add(new Employee(arr[0],LocalDate.parse(arr[1]),arr[2],(arr[3]),arr[4],arr[5],arr[6],arr[7],arr[8],Double.parseDouble(arr[9])));
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return employeeList;
    }
    public static void writeEmployee (List<Employee> employeeList, String pathFile, boolean append) {
        File file = new File("src/data/employee_data.csv");
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        try {
            fileWriter = new FileWriter(file,append);
            bufferedWriter = new BufferedWriter(fileWriter);
            for (Employee e: employeeList) {
                bufferedWriter.write(e.getInfoCSVEmployee());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
