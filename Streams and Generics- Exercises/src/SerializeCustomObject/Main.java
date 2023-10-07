package SerializeCustomObject;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Shape shape = new Shape("green", 15.3, 12.4);
        String inPath = "D:\\JavaPrograms\\SirmaAcademy-exercises\\Streams and Generics- Exercises\\src\\ex8.txt";
        //write
        try (ObjectOutputStream ous = new ObjectOutputStream(new FileOutputStream(inPath))) {
            ous.writeObject(shape);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //read
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(inPath))) {
            Shape shape1 = (Shape) ois.readObject();
            System.out.println(shape1.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
