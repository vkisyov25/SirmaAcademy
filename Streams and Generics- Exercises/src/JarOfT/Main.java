package JarOfT;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Jar<String> stringJar = new Jar<>();
        stringJar.add("element1");
        stringJar.add("element2");
        stringJar.add("element3");

        System.out.println(stringJar.remove());
        System.out.println(stringJar.remove());

    }
}
