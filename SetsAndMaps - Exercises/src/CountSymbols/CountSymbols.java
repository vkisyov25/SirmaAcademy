package CountSymbols;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CountSymbols {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        Map<Character, Integer> map = new TreeMap<>();

        for (int i = 0; i < text.length(); i++) {
            int count = 0;
            char key = text.charAt(i);
            if (!map.containsKey(key)) {

                map.put(key, ++count);
            } else {
                count = map.get(key);
                count++;
                map.put(key, count);
            }

        }

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            System.out.printf("%c: %d\n", entry.getKey(), entry.getValue());
        }

    }
}
