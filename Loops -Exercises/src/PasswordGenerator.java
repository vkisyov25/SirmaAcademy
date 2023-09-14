import java.util.Scanner;

public class PasswordGenerator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int m = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                for (int i3 = 'a'; i3 < 'a' + m; i3++) {
                    for (int i4 = 'a'; i4 < 'a' + m; i4++) {
                        for (int i5 = 2; i5 <= n; i5++) {

                            if (i5 > i && i5 > j) {
                                System.out.printf("%d%d%c%c%d\n", i, j, i3, i4, i5);
                            }
                        }
                    }
                }
            }
        }
    }
}