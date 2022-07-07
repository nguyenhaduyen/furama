package common;

import models.person.Employee;
import util.ReadAndWriteEmployee;

import java.util.List;
import java.util.Scanner;

public class CheckCodeIDEmployee {
    public static boolean checkCodeID(String id) {
        Scanner scanner = new Scanner(System.in);
        List<Employee> employeeList = ReadAndWriteEmployee.readEmployee("src/data/employee_data.csv");
        for (int i = 0; i < employeeList.size(); i++) {
            if (employeeList.get(i).getId().equals(id)) {
                return true;
            }
        }
        return false;
    }
}
