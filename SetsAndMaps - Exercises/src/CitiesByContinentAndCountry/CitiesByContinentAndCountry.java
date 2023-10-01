package CitiesByContinentAndCountry;

import java.util.*;
import java.util.stream.Collectors;

public class CitiesByContinentAndCountry {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = Integer.parseInt(scanner.nextLine());
        Map<String,Map<String, List<String>>> map = new LinkedHashMap<>();
        Map<String, List<String>> insideMap = new LinkedHashMap<>();
        List<String> stringList = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            String[] arr = scanner.nextLine().split(" ");
            String continent=  arr[0];
            String country=  arr[1];
            String city=  arr[2];

            if(!map.containsKey(continent)){
                /*if(!insideMap.containsKey(country)){
                    stringList = new ArrayList<>();
                    stringList.add(city);
                    insideMap.put(country,stringList);
                }else {
                    insideMap.get(country).add(city);
                }
                map.put(continent,insideMap);*/
                stringList = new ArrayList<>();
                stringList.add(city);
                insideMap.put(country,stringList);
                map.put(continent,insideMap);
            }else {
                insideMap = map.get(continent);
                if(!insideMap.containsKey(country)){
                    stringList = new ArrayList<>();
                    stringList.add(city);
                    insideMap.put(country,stringList);
                }else {
                    insideMap.get(country).add(city);
                }
                map.put(continent,insideMap);
            }

            insideMap = new LinkedHashMap<>();
        }

        for (Map.Entry<String, Map<String, List<String>>> entry : map.entrySet()) {
            System.out.printf("%s:\n",entry.getKey());


            entry.getValue().entrySet().stream()
                    .sorted(Map.Entry.comparingByKey())
                    .forEach(cityEntry -> {
                        System.out.printf("%s -> %s\n",cityEntry.getKey(),cityEntry.getValue());
                    });
        }


    }
}
