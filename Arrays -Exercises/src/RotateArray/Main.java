package RotateArray;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] arr = scanner.nextLine().split(",");
        int step  = Integer.parseInt(scanner.nextLine());

        String temp ="";
        for (int i = 0; i < arr.length-1; i ++) {
            if(arr.length/step==i){
                break;
            }

            temp = arr[i];
            arr[i] = arr[i+step];
            arr[i+step] = temp;

        }

        System.out.println(Arrays.toString(arr));

    }
}
