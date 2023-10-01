package CompanyUsers;

import java.util.*;

public class CompanyUsers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();
        Map<String, List<String>> map = new TreeMap<>();
        List<String> idList;
        idList = new ArrayList<>();
        while (!command.equals("End")) {

            String[] arr = command.split(" -> ");
            String name = arr[0];
            String id = arr[1];

            if (!map.containsKey(name)) {
                idList = new ArrayList<>();
                idList.add(id);
                map.put(name, idList);
            } else {
                map.get(name).add(id);
            }

            command = scanner.nextLine();
        }

        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            System.out.println(entry.getKey());

            entry.getValue().stream().forEach(e -> System.out.printf("     --%s\n", e));
        }

    }
}
