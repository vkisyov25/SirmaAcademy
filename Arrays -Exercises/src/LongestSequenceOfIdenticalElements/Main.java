package LongestSequenceOfIdenticalElements;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);

        int[] arr = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(e -> Integer.parseInt(e)).toArray();
        List<Integer> list = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();

        for (int i = 0; i < arr.length-1; i++) {

            while(i != arr.length-1){
                if(arr[i]==arr[i+1]){
                    list.add(arr[i]);
                }else{ //|| i==arr.length-1  (arr[i]!=arr[i+1])
                    list.add(arr[i]);
                    if(list.size()>=list1.size()){
                        list1 =list;
                    }
                    list = new ArrayList<>();
                }

                i++;
            }

            if(arr[i-1]==arr[i]){
                list.add(arr[i]);
                if(list.size()>=list1.size()){
                    list1 =list;
                }
            }
        }
        System.out.println(Arrays.toString(new List[]{list1}));
    }
}
