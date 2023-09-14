import java.util.ArrayList;
import java.util.Scanner;

public class CollatzConjecture {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = Integer.parseInt(scanner.nextLine());
        ArrayList<Integer> list = new ArrayList<>();
        list.add(num);
        while(num != 1){
            if(num%2==0){
                num /=2;
            }else {
                num = num*3+1;
            }
            list.add(num);
        }

        for (int i = 0; i < list.size(); i++) {
            System.out.printf("%d ",list.get(i));
        }
    }
}
