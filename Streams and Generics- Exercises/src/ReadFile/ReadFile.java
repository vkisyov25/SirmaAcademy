package ReadFile;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ReadFile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try (BufferedReader in = new BufferedReader(new FileReader("D:\\JavaPrograms\\SirmaAcademy-exercises\\Streams and Generics- Exercises\\src\\input.txt"))) {
            String line = in.readLine();
            while (line != null) {
                System.out.println(line);
                line = in.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}