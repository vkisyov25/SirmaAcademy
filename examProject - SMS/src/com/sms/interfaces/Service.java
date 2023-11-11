package com.sms.interfaces;

import com.sms.model.Employee;

import java.util.List;
import java.util.Scanner;

public interface Service {
    void addEmployee(Employee employee);

    void editEmployee(int id, Scanner scanner);

    void fireEmployee(int id);

    List<Employee> listEmployees();

    void searchEmployees(String keyword);
}
