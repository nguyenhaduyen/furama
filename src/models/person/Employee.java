package models.person;

import java.time.LocalDate;

public class Employee extends Person{
    private String employeeCode;
    private String academicLevel;
    private String status;
    private double salary;
    public Employee() {

    }

    public Employee(String employeeCode, String academicLevel, String status, double salary) {
        this.employeeCode = employeeCode;
        this.academicLevel = academicLevel;
        this.status = status;
        this.salary = salary;
    }

    public Employee(String name, LocalDate dateOfBirth, String gender, String id, String phoneNumber, String email, String employeeCode, String academicLevel, String status, double salary) {
        super(name, dateOfBirth, gender, id, phoneNumber, email);
        this.employeeCode = employeeCode;
        this.academicLevel = academicLevel;
        this.status = status;
        this.salary = salary;
    }

    public String getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
    }

    public String getAcademicLevel() {
        return academicLevel;
    }

    public void setAcademicLevel(String academicLevel) {
        this.academicLevel = academicLevel;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" + "name = " + getName() + ", dateOfBirth = " + getDateOfBirth() + ", gender = " + getGender() + ", CMND = " + getId()
                + ", phoneNumber = " + getPhoneNumber() + ", email = " + getEmail()+
                ", employeeCode ='" + employeeCode + '\'' +
                ", academicLevel='" + academicLevel + '\'' +
                ", status='" + status + '\'' +
                ", salary=" + salary +
                '}';
    }
    public String getInfoCSVEmployee () {
        return getName() + "," + getDateOfBirth() + "," + getGender()+ "," + getId() + "," + getPhoneNumber() + "," + getEmail() + "," +
                getEmployeeCode() + "," + getAcademicLevel() + "," + getStatus() + "," + getSalary();
    }
}
