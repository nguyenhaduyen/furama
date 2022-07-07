package common;

import models.person.Employee;
import util.ReadAndWriteEmployee;

import java.util.List;

public class CheckCodeEmployee {
    public static boolean checkCodeEmployee (String employeeCode) {
        List<Employee> employeeList = ReadAndWriteEmployee.readEmployee("src/data/employee_data.csv");
        for (int i = 0; i <employeeList.size() ; i++) {
            if (employeeList.get(i).getEmployeeCode().equals(employeeCode)) {
                return true;
            }
        }
        return false;
    }
}
