package UniqueUsernames;

import java.util.HashSet;
import java.util.Scanner;

public class UniqueUsernames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = Integer.parseInt(scanner.nextLine());
        HashSet<String> numSet = new HashSet<>();
        for (int i = 0; i < num; i++) {
            String word = scanner.nextLine();
            numSet.add(word);
        }

        for (String s : numSet) {
            System.out.println(s);
        }

    }
}
