package AverageStudentsGrades;

import java.util.*;
import java.util.stream.Collectors;

public class AverageStudentsGrades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = Integer.parseInt(scanner.nextLine());
        Map<String,List<Double>> map =new TreeMap<>();
        List<Double> listGrade = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            String[] arr = scanner.nextLine().split(" ");
            String name = arr[0];
            Double grade = Double.parseDouble(arr[1]);

            if(!map.containsKey(name)){
                listGrade = new ArrayList<>();
                listGrade.add(grade);
                map.put(name,listGrade);
            }else {
                /*listGrade = new ArrayList<>();
                for (int j = 0; j < map.get(name).size(); j++) {
                    listGrade.add(map.get(name).get(j));
                }
                listGrade.add(grade);
                map.put(name,listGrade);*/
                map.get(name).add(grade);
            }
        }


        for (Map.Entry<String, List<Double>> entry : map.entrySet()) {
            //String stringGrades = entry.getValue().toString();
            String stringGrades = entry.getValue()
                    .stream()
                    .map(e -> String.valueOf(e))
                    .collect(Collectors.joining(" "));
            double average=0.0;
            for(int i=0; i<entry.getValue().size(); i++){
                average += entry.getValue().get(i);
            }
            average = average / entry.getValue().size();
            System.out.printf("%s -> %s (avg: %.2f) \n",entry.getKey(),stringGrades,average);
            //System.out.printf("%s -> avg: %.2f) \n",entry.getKey(),average);
        }

    }
}
