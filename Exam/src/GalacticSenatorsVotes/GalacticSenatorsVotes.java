package GalacticSenatorsVotes;

import java.util.Scanner;

public class GalacticSenatorsVotes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] arr = scanner.nextLine().split(", ");
        int yesCount = 0;
        int noCount = 0;
        int abstainCount = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals("Yes")) {
                yesCount++;
            } else if (arr[i].equals("No")) {
                noCount++;
            } else {
                abstainCount++;
            }

        }

        if (noCount == 0 && yesCount == 0 && abstainCount > 0) {
            System.out.println("Abstain");
            return;
        }

        if (yesCount == noCount) {
            System.out.println("Tie");
        } else if (yesCount > noCount) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }

    }
}
