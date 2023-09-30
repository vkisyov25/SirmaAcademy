package StarfighterFormation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class StarfighterFormation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //int[] numArr  = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
        List<Integer> numList = Arrays.stream(scanner.nextLine().split(", ")).map(Integer::parseInt).collect(Collectors.toList());
        String command = scanner.nextLine();
        while (!command.equals("end")) {
            String[] commandArr = command.split(" ");
            if (commandArr[0].equals("destroy")) {
                int index = Integer.parseInt(commandArr[1]);
                if (index >= 0 && index <= numList.size() - 1) {
                    numList.remove(index);
                    numList.stream().forEach(e -> System.out.printf("%d ", e));
                    System.out.println();
                }

            } else if (commandArr[0].equals("swap")) {
                int index1 = Integer.parseInt(commandArr[1]);
                int index2 = Integer.parseInt(commandArr[2]);
                if ((index1 >= 0 && index1 <= numList.size() - 1) && (index2 >= 0 && index2 <= numList.size() - 1) && (index1 != index2)) {
                    int element1 = numList.get(index1);
                    int element2 = numList.get(index2);
                    numList.set(index1, element2);
                    numList.set(index2, element1);
                    numList.stream().forEach(e -> System.out.printf("%d ", e));
                    System.out.println();
                }

            } else if (commandArr[0].equals("add")) {
                int id = Integer.parseInt(commandArr[1]);
                numList.add(id);
                numList.stream().forEach(e -> System.out.printf("%d ", e));
                System.out.println();
            } else if (commandArr[0].equals("insert")) {
                int id = Integer.parseInt(commandArr[1]);
                int index = Integer.parseInt(commandArr[2]);
                if (index >= 0 && index <= numList.size() - 1) {
                    numList.set(index, id);
                    numList.stream().forEach(e -> System.out.printf("%d ", e));
                    System.out.println();
                }

            } else {
                if (numList.size() % 2 != 0) {
                    int index = numList.size() / 2;
                    int id = numList.get(index);
                    System.out.println(id);
                } else {
                    int id = numList.size() / 2;
                    System.out.printf("%d %d", numList.get(id - 1), numList.get(id));
                }

            }

            command = scanner.nextLine();
        }
    }
}
