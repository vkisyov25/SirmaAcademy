package BankAccount;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();

        Map<Integer, BankAccount> accountMap = new HashMap<>();

        while (!command.equals("End")) {
            String[] arr = command.split(" ");

            String result = "";
            if (arr[0].equals("Create")) {
                BankAccount bankAccount = new BankAccount();
                accountMap.put(bankAccount.getId(), bankAccount);
                result = String.format("Account ID%d created", bankAccount.getId());
            } else if (arr[0].equals("Deposit")) {
                int id = Integer.parseInt(arr[1]);
                double amount = Double.parseDouble(arr[2]);
                if (accountMap.containsKey(id)) {
                    BankAccount bankAccountFromMap = accountMap.get(id);
                    bankAccountFromMap.deposit(amount);
                    accountMap.put(id, bankAccountFromMap);
                    result = String.format("Deposited %.0f to ID%d", amount, id);
                } else {
                    result = "Account does not exist";
                }

            } else if (arr[0].equals("SetInterest")) {
                double interst = Double.parseDouble(arr[1]);
                BankAccount.setInterestRate(interst);


            } else if (arr[0].equals("GetInterest")) {
                int id = Integer.parseInt(arr[1]);
                int years = Integer.parseInt(arr[2]);

                if (accountMap.containsKey(id)) {
                    BankAccount bankAccount1 = accountMap.get(id);
                    double totalInterest = bankAccount1.getInterest(years);
                    result = String.format("%.2f", totalInterest);
                } else {
                    result = "Account does not exist";
                }

            }
            if (!result.isEmpty()) {
                System.out.println(result);
            }
            command = scanner.nextLine();
        }

    }
}
