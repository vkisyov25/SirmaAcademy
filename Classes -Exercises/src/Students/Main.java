package Students;

import java.util.*;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();

        List<Students> studentsList = new ArrayList<>();
        Map<String, List<Students>> map = new LinkedHashMap<>();

        while (!command.equals("end")) {
            String[] studentArr = command.split(" ");

            if (!map.containsKey(studentArr[3])) {
                Students students = new Students(studentArr[0], studentArr[1], Integer.parseInt(studentArr[2]), studentArr[3]);
                studentsList.add(students);
                map.put(studentArr[3], studentsList);
            } else {
                for (int j = 0; j < map.get(studentArr[3]).size(); j++) {
                    studentsList.add(map.get(studentArr[3]).get(j));
                }
                Students students = new Students(studentArr[0], studentArr[1], Integer.parseInt(studentArr[2]), studentArr[3]);
                studentsList.add(students);

                map.put(studentArr[3], studentsList);
            }

            studentsList = new ArrayList<>();
            command = scanner.nextLine();
        }

        String town = scanner.nextLine();

        for (Map.Entry<String, List<Students>> entry : map.entrySet()) {
            if (entry.getKey().equals(town)) {
                for (int j = 0; j < map.get(entry.getKey()).size(); j++) {
                    System.out.printf("%s\n", entry.getValue().get(j));
                }
            }

        }


    }
}
