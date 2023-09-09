import java.util.ArrayList;
import java.util.Scanner;

public class FibonacciSequenceSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int sum=0;
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0; i<n; i++){
            if(i<=1){
                list.add(1);

            }else {
                //int first = list.get(i-2);
                //int second = list.get(i-1);
                list.add(list.get(i-2) + list.get(i - 1));

            }
        }
        for(int i=0; i<list.size(); i++){
            sum += list.get(i);
        }
        System.out.println(sum);
    }
}
