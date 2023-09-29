package PopulationCounter;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class PopulationCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();
        Map<String, Map<String, Integer>> map = new LinkedHashMap<>();
        Map<String, Integer> insideMap = new LinkedHashMap<>();
        while (!command.equals("report")) {
            String[] arr = command.split("\\|");
            if (!map.containsKey(arr[1])) {
                if (!insideMap.containsKey(arr[0])) {
                    insideMap.put(arr[0], Integer.parseInt(arr[2]));
                } else {
                    int population = insideMap.get(arr[0]);
                    population += Integer.parseInt(arr[2]);
                    insideMap.put(arr[0], population);
                }

                map.put(arr[1], insideMap);
            } else {
                insideMap = map.get(arr[1]);
                if (!insideMap.containsKey(arr[0])) {
                    insideMap.put(arr[0], Integer.parseInt(arr[2]));
                } else {
                    int population = insideMap.get(arr[0]);
                    population += Integer.parseInt(arr[2]);
                    insideMap.put(arr[0], population);
                }

                map.put(arr[1], insideMap);
            }

            insideMap = new LinkedHashMap<>();
            command = scanner.nextLine();
        }

        for (Map.Entry<String, Map<String, Integer>> entry : map.entrySet()) {
            int totalPopulation = entry.getValue().values().stream()
                    .mapToInt(Integer::intValue)
                    .sum();


            System.out.printf("%s (total population: %d)\n",entry.getKey(),totalPopulation);
            entry.getValue().entrySet().stream()
                    .sorted(Map.Entry.comparingByKey())
                    .forEach(cityEntry -> {
                        System.out.println("=> " + cityEntry.getKey() + ": " + cityEntry.getValue());
                    });

        }

    }
}

