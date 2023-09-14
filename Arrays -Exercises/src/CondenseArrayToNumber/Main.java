package CondenseArrayToNumber;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int[] arr = Arrays.stream(scanner.nextLine().split(",")).mapToInt(e -> Integer.parseInt(e)).toArray();

        //solving with list
        /*List<Integer> list = Arrays.stream(scanner.nextLine().split(",")).map(e->Integer.parseInt(e)).collect(Collectors.toList());
        while (list.size()!=1){
            for (int i = 0; i < list.size()-1; i++) {
                //arr[i] = arr[i]+arr[i+1];
                list.set(i,list.get(i) + list.get(i+1));
            }
            list.remove(list.size()-1);
        }
        System.out.println(list.get(0));*/

        while (arr.length !=1){
            for (int i = 0; i < arr.length-1; i++) {
                arr[i] = arr[i]+arr[i+1];

            }
            arr = removeMethod(arr);
        }
        System.out.println(arr[0]);



    }

    public static int[] removeMethod(int[] array){
        int[] array1 = new int[array.length-1];
        for (int i = 0; i < array.length-1; i++) {
            array1[i] = array[i];
        }
        return array1;
    }
}
