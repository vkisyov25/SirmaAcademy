package WordFilter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class WordFilter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] arr = scanner.nextLine().split(" ");

        Arrays.stream(arr)
                .filter(e -> e.length() % 2 == 0)
                .forEach(System.out::println);


        List<Integer> list = new ArrayList<>();

    }
}
