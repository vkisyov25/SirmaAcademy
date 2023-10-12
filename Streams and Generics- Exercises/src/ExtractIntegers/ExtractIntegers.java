package ExtractIntegers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractIntegers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inPath = "D:\\JavaPrograms\\SirmaAcademy-exercises\\Streams and Generics- Exercises\\src\\input.txt";
        try (BufferedReader in = new BufferedReader(new FileReader(inPath))) {
            String line;
            while ((line = in.readLine()) != null) {
                Pattern pattern = Pattern.compile("(\\s|[\\[\\],\\.!?\\-=\\(\\)])(\\d+)(\\s|[\\[\\],\\.!?\\-=\\(\\)])");
                Matcher matcher = pattern.matcher(line);
                while (matcher.find()) {
                    System.out.println(matcher.group());
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
