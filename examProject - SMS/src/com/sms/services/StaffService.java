package com.sms.services;

import com.sms.StaffManagementApp;
import com.sms.interfaces.Service;
import com.sms.model.Employee;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class StaffService implements Service {
    private static List<Employee> employees;

    public static List<Employee> getEmployees() {
        return employees;
    }

    public List<Employee> readCSV() throws Exception {
        List<String> records = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("employee.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                for (int i = 0; i < values.length; i++) {
                    records.add(values[i]);
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        List<Employee> employees1 = new ArrayList<>();
        for (int i = 0; i < records.size(); i += 5) {
            int ID = Integer.parseInt((records.get(i)));
            String name = records.get(i + 1);
            String department = records.get(i + 2);
            String role = records.get(i + 3);
            double salary = Double.parseDouble(records.get(i + 4));
            boolean cr = StaffManagementApp.validateEmployee(String.valueOf(ID), name, department, role, String.valueOf(salary));
            //Validation
            if (!cr) {
                throw new Exception("Invalid format");
            }
            Employee employee = new Employee(ID, name, department, role, salary);
            employees1.add(employee);
        }
        return employees1;
    }

    public StaffService() throws Exception {
        // Запълваме списъка със служители от файл ако няма данни във файла създаваме празен лист
        this.employees = readCSV();
        if (this.employees == null) {
            this.employees = new ArrayList<>();
        }
    }

    @Override
    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    @Override
    public void editEmployee(int id, Scanner scanner) {
        boolean isHave = false;
        for (int i = 0; i < getEmployees().size(); i++) {
            if (getEmployees().get(i).getID() == id) {
                isHave = true;
                break;
            }
        }
        if (isHave) {

            System.out.println("What is to edit\n" +
                    "1. Department\n" +
                    "2. Role\n" +
                    "3. Salary\n" +
                    "4. Exit\n" +
                    "Enter a number");
            int command = Integer.parseInt(scanner.nextLine());
            //while (command<=4){
            if (command == 1) {
                System.out.println("department: ");
                String dep = scanner.nextLine();
                employees.get(id).setDepartment(dep);
                System.out.println("Successful change");
            } else if (command == 2) {
                System.out.println("role: ");
                String role = scanner.nextLine();
                employees.get(id).setRole(role);
                System.out.println("Successful change");
            } else if (command == 3) {
                System.out.println("salary: ");
                double salary = Double.parseDouble(scanner.nextLine());
                employees.get(id).setSalary(salary);
                System.out.println("Successful change");
            }
            //command = Integer.parseInt(scanner.nextLine());
            //}
        } else {
            System.out.println("There isn't employee with this ID");
        }

    }

    @Override
    public void fireEmployee(int id) {
        //This employee already doesn't work in the company - remove this employee
        employees.removeIf(employee -> employee.getID() == id);
        //TODO remove from file (may be)
    }

    //List of all active employees with their details.
    @Override
    public List<Employee> listEmployees() {
        return getEmployees();
    }

    @Override
    public void searchEmployees(String keyword) {
        // Search for employees by a given keyword (name, ID, department)
        employees.stream()
                .filter(employee -> employee.getName().contains(keyword) || String.valueOf(employee.getID()).contains(keyword) || employee.getDepartment().contains(keyword))
                .forEach(System.out::println);
    }


}
