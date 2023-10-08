package CopyBytes;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class CopyBytes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inPath = "D:\\JavaPrograms\\SirmaAcademy-exercises\\Streams and Generics- Exercises\\src\\input.txt";
        String outPath = "D:\\JavaPrograms\\SirmaAcademy-exercises\\Streams and Generics- Exercises\\src\\ex3.txt";

        try (FileInputStream in = new FileInputStream(inPath);
             FileOutputStream out = new FileOutputStream(outPath)) {
            int oneByte = in.read();
            while (oneByte != -1) {
                if (oneByte == 32 || oneByte == 10) {
                    out.write((char) oneByte);
                } else {
                    String num = String.valueOf(oneByte);
                    for (int i = 0; i < num.length(); i++) {
                        out.write(num.charAt(i));
                    }

                }

                oneByte = in.read();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
