package WriteToFile;

import java.io.*;
import java.util.Scanner;

public class WriteToFile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inPath = "D:\\JavaPrograms\\SirmaAcademy-exercises\\Streams and Generics- Exercises\\src\\input.txt";
        String outPath = "D:\\JavaPrograms\\SirmaAcademy-exercises\\Streams and Generics- Exercises\\src\\ex2.txt";


        try (BufferedReader in = new BufferedReader(new FileReader(inPath));
             PrintWriter out = new PrintWriter(new FileOutputStream(outPath))) {
            String line;
            while ((line = in.readLine()) != null) {
                String cleanedLine = line.replaceAll("[.,!?;]", "");
                out.println(cleanedLine);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
