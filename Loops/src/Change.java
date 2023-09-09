import java.util.Scanner;

public class Change {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double num = Double.parseDouble(scanner.nextLine());
        num *=100;
        while (num!=0){
            if(num>=200){
                num -=200;
                System.out.println(2);
            } else if (num>=100) {
                num -=100;
                System.out.println(1);
            } else if (num>=50) {
                num -=50;
                System.out.println(0.50);

            } else if (num>=20) {
                num -=20;
                System.out.println(0.20);

            } else if (num>=10) {
                num -=10;
                System.out.println(0.10);

            } else if (num>=5) {
                num -=5;
                System.out.println(0.05);

            }else if (num>=2) {
                num -=2;
                System.out.println(0.02);

            }else if (num>=1) {
                num -=1;
                System.out.println(0.01);

            }


        }
    }
}
