package Articles;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] arr = scanner.nextLine().split(", ");
        Articles articles = new Articles(arr[0], arr[1], arr[2]);
        int n = Integer.parseInt(scanner.nextLine());


        for (int i = 0; i < n; i++) {
            String[] arr1 = scanner.nextLine().split(": ");

            if (arr1[0].equals("Edit")) {
                articles.Edit(arr1[1]);
            } else if (arr1[0].equals("ChangeAuthor")) {
                articles.changeAuthor(arr1[1]);
            } else if (arr1[0].equals("Rename")) {
                articles.rename(arr1[1]);
            }
        }
        System.out.println(articles.toString());

    }
}
