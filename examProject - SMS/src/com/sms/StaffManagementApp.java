package com.sms;


import com.sms.interfaces.Service;
import com.sms.model.Employee;
import com.sms.services.StaffService;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StaffManagementApp {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        // implement fileReader/fileWriter to handle saving into csv/json
        Service service = new StaffService(); //new StaffService(reader, writer);
        //Manager manager = new StaffManager(service);
        System.out.println("......Welcome to Staff Management System......");
        displayCommands();
        boolean isRunning = true;
        while (isRunning) {
            System.out.println("Enter a command: (add, edit, fire, list, search, exit)");
            String command = scanner.nextLine();
            //manager.execute(command);
            switch (command) {
                case "add":
                    adding(scanner, service);
                    break;
                case "edit":
                    editing(scanner, service);
                    break;
                case "fire":
                    fireEmployee(scanner, service);
                    break;
                case "list":
                    visualization(service);
                    break;
                case "search":
                    serachingEmployee(scanner, service);
                    break;
                case "exit":
                    System.out.println("Program ended");
                    isRunning = false;
                    break;
                default:
                    System.out.println("Invalid command. Try again.");
            }
        }
    }

    private static void serachingEmployee(Scanner scanner, Service service) {
        System.out.println("Enter Name or ID or Department ");
        String keyword = scanner.nextLine();
        service.searchEmployees(keyword);
    }

    private static void visualization(Service service) {
        if (service.listEmployees().size() == 0) {
            System.out.println("There aren't employees");
        } else {
            service.listEmployees().forEach(System.out::println);
        }
    }

    private static void fireEmployee(Scanner scanner, Service service) {
        System.out.println("ID to edit: ");
        int Id = Integer.parseInt(scanner.nextLine());
        service.fireEmployee(Id);
        writeToFile();
    }

    private static void editing(Scanner scanner, Service service) {
        System.out.println("ID to edit: ");
        int id = Integer.parseInt(scanner.nextLine());
        service.editEmployee(id, scanner);
        writeToFile();
    }

    public static boolean validateEmployee(String ID, String name, String department, String role, String salary) {
        Pattern patternId = Pattern.compile("[0-9]+");
        Matcher matcherId = patternId.matcher(ID);
        if (!matcherId.matches()) {
            return false;
        }
        Pattern patternName = Pattern.compile("[a-zA-z]+");
        Matcher matcherName = patternName.matcher(name);
        if (!matcherName.matches()) {
            return false;
        }

        Pattern patternDepartment = Pattern.compile("[a-zA-Z]+");
        Matcher matcherDepartment = patternDepartment.matcher(department);
        if (!matcherDepartment.matches()) {
            return false;
        }
        Pattern patternRole = Pattern.compile("[a-zA-z ]+");
        Matcher matcherRole = patternRole.matcher(role);
        if (!matcherRole.matches()) {
            return false;
        }

        Pattern patternSalary = Pattern.compile("\\d+.\\d+");
        Matcher matcherSalary = patternSalary.matcher(salary);
        if (!matcherSalary.matches()) {
            return false;
        }


        return true;
    }

    private static void adding(Scanner scanner, Service service) throws Exception {
        int ID;
        if (StaffService.getEmployees().size() == 0) {
            ID = 0;
        } else {
            ID = (StaffService.getEmployees().get(StaffService.getEmployees().size() - 1).getID()) + 1;
        }
        System.out.println("name:");
        String name = scanner.nextLine();
        System.out.println("department:");
        String department = scanner.nextLine();
        System.out.println("role:");
        String role = scanner.nextLine();
        System.out.println("salary:");
        double salary = Double.parseDouble(scanner.nextLine());
        boolean cr = validateEmployee(String.valueOf(ID), name, department, role, String.valueOf(salary));
        if (!cr) {
            throw new Exception("Invalid format ");
        }
        Employee employee = new Employee(ID, name, department, role, salary);
        service.addEmployee(employee);
        //write to CSV-file
        writeToFile();
    }

    private static void writeToFile() {
        try {
            FileWriter myWriter = new FileWriter("employee.csv");
            for (int i = 0; i < StaffService.getEmployees().size(); i++) {
                myWriter.write(StaffService.getEmployees().get(i).getID() + "," + StaffService.getEmployees().get(i).getName() +
                        "," + StaffService.getEmployees().get(i).getDepartment() + "," + StaffService.getEmployees().get(i).getRole() +
                        "," + StaffService.getEmployees().get(i).getSalary() + ",");
            }
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    private static void displayCommands() {
        System.out.println(">>Menu<<");
        System.out.println("Add Employee");
        System.out.println("Edit Employee");
        System.out.println("Fire Employee");
        System.out.println("List Employees");
        System.out.println("Search Employees");
        System.out.println("Exit");
    }
}
