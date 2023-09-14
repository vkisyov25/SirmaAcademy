import java.util.Scanner;

public class SpecialNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        int num=0;
        int digit=0;
        boolean flag= true;
        for (int i = 1; i <9 ; i++) {
            //num = i;
            for (int a = 1; a < 9; a++) {
                for (int b = 1; b < 9; b++) {
                    for (int k = 1; k < 9; k++) {
                        if(n%i==0 && n%a==0 && n%b==0 && n%k==0){
                            System.out.printf("%d%d%d%d\n",i,a,b,k);
                        }
                    }

                }

            }
        
        }
    }
}
