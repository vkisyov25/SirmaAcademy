package JediArchivesSearch;

import java.util.Scanner;

public class JediArchivesSearch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] inputArr = scanner.nextLine().split(", ");
        String word = scanner.nextLine();
        int count = 0;
        int firstIndex = 0;
        int lastIndex = 0;
        boolean isNotHave = true;
        for (int i = 0; i < inputArr.length; i++) {
            if (word.equals(inputArr[i])) {
                isNotHave = false;
                count++;
                if (count == 1) {
                    firstIndex = i;
                } else {
                    lastIndex = i;
                }

            }

        }

        if (count == 1) {
            lastIndex = firstIndex;
        }

        if (isNotHave) {
            System.out.println("Record not found");
        } else {
            System.out.printf("First Occurrence: %d\n", firstIndex);
            System.out.printf("Last Occurrence: %d", lastIndex);
        }

    }
}
