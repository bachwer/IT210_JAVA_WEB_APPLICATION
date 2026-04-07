package Session02.Ex4_5_6.java.org.example.demo3.model.Entity;

import java.time.LocalDate;

public class Employee {
    private String code;
    private String name;
    private String department;
    private double salary;
    private LocalDate joinDate;
    private String status;

    public Employee(String code, String name, String department, double salary, LocalDate joinDate, String status) {
        this.code = code;
        this.name = name;
        this.department = department;
        this.salary = salary;
        this.joinDate = joinDate;
        this.status = status;
    }

    public Employee() {
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setJoinDate(LocalDate joinDate) {
        this.joinDate = joinDate;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    public LocalDate getJoinDate() {
        return joinDate;
    }

    public String getStatus() {
        return status;
    }
}
