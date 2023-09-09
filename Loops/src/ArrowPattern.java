import java.util.Scanner;

public class ArrowPattern {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

/*        int num = n;
        for (int i = 0; i < n*2; i++) {
            for (int j = 0; j < (num*2)-1-i; j++) {
                if(i%2==0){
                    if(j%2==0 || j>=i){
                        System.out.print("*");
                    }else {
                        System.out.print(" ");
                    }
                }else {
                    if(j%2!=0){
                        System.out.print("*");
                    }else {
                        System.out.print(" ");
                    }
                }
            }
            System.out.println();

            num--;
        }*/

        /*for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                //System.out.print("* ");


                if(i==0){
                    if(j<n/2){
                        System.out.print(" ");
                    }else {
                        System.out.print("*");
                        break;
                    }


                }else{
                    if(j==n/2-i || j==n/2+i){
                        System.out.print("*");
                    }else {
                        System.out.print(" ");

                    }
                }
            }
            System.out.println();

        }*/

        for(int i=1; i<n; i++){
            for (int j = 3+n-5; j >=i ; j--) {
                System.out.print(" ");
            }
            for (int j = 1; j <=i ; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
