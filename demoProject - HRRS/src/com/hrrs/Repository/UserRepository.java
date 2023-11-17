package com.hrrs.Repository;

import com.hrrs.Model.User.Role;
import com.hrrs.Model.User.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.hrrs.Service.UserManager.getUsers;

public class UserRepository {
    public static void writeToFile() {
        try {
            File file = new File("D:\\JavaPrograms\\SirmaAcademy-exercises\\demoProject - HRRS\\src\\users.csv");
            FileWriter myWriter = new FileWriter(file);
            for (int i = 0; i < getUsers().size(); i++) {
                String username = getUsers().get(i).getUsername();
                String password = getUsers().get(i).getPassword();
                boolean cr = UserRepository.userValidation(username, password);
                //Validation
                if (!cr) {
                    throw new Exception("Invalid format");
                }
                Role roles = getUsers().get(i).getRoles();

                myWriter.write(username + "," + password + "," + roles + "," + "\n");
            }
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static List<User> readCSV() throws Exception {
        List<String> records = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("D:\\JavaPrograms\\SirmaAcademy-exercises\\demoProject - HRRS\\src\\users.csv"))) {
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
        List<User> userList = new ArrayList<>();
        for (int i = 0; i < records.size(); i += 3) {
            String username = records.get(i);
            String password = records.get(i + 1);
            String role = records.get(i + 2);
            boolean cr = userValidation(username, password);
            //Validation
            if (!cr) {
                throw new Exception("Invalid format");
            }
            User user = null;
            if (role.equals("ADMINISTRATOR")) {
                user = new User(username, password, Role.ADMINISTRATOR);
            } else if (role.equals("ORDINARY_USER")) {
                user = new User(username, password, Role.ORDINARY_USER);
            } else {
                throw new Exception("Invalid format");
            }
            userList.add(user);
        }
        return userList;
    }

    public static boolean userValidation(String username, String password) {
        Pattern patternUsername = Pattern.compile("[a-zA-z]+");
        Matcher matcherUsername = patternUsername.matcher(username);
        if (!matcherUsername.matches()) {
            return false;
        }

        Pattern patternPassword = Pattern.compile("[a-zA-Z\\d]+");
        Matcher matcherPassword = patternPassword.matcher(password);
        if (!matcherPassword.matches()) {
            return false;
        }

        return true;
    }
}
