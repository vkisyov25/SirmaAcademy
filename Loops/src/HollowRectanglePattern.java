import java.util.Scanner;

public class HollowRectanglePattern {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int m = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n ; i++) {
            if(i==0){
                for (int j = 0; j < m; j++) {
                    System.out.printf("*");
                }
                System.out.println();
            }else if(i==n-1){
                for (int j = 0; j < m; j++) {
                    System.out.printf("*");
                }
                System.out.println();
            }else {
                for (int j = 0; j < m; j++) {
                    if(j==0){
                        System.out.printf("*");
                    } else if (j==m-1) {
                        System.out.printf("*");
                    }
                    else {
                        System.out.printf(" ");
                    }
                }
                System.out.println();
            }
        }
    }
}
