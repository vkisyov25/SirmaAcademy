import java.util.Scanner;

public class PyramidOfNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner( System.in );

        int n = Integer.parseInt(scanner.nextLine());
        int count = 0;

        for ( int i = 1; i <= n; i++) {

            for ( int k = 1; k <= i; k++ ) {
                count++;
                System.out.printf("%d ", count);
                if (count == n ){
                    return;

                }
            }
            System.out.println();
        }
    }
}
