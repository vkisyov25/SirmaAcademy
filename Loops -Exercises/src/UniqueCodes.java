import java.util.Scanner;

public class UniqueCodes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstNum = Integer.parseInt(scanner.nextLine());
        int secondNum = Integer.parseInt(scanner.nextLine());
        int thirdNum = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= firstNum; i++) {
            for (int j = 1; j <= secondNum; j++) {
                for (int k = 1; k <= thirdNum; k++) {
                    if(i%2==0 && k%2==0){
                        if(j==2 || j==3 || j==5 || j==7){
                            System.out.printf("%d%d%d\n",i,j,k);
                        }
                    }
                }

            }

        }
    }
}
