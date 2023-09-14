import java.util.Scanner;

public class PadawanEquipment {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double budget = Double.parseDouble(scanner.nextLine());
        int studentsCaunt = Integer.parseInt(scanner.nextLine());
        double lightsaber = Double.parseDouble(scanner.nextLine());
        double robe = Double.parseDouble(scanner.nextLine());
        double belt = Double.parseDouble(scanner.nextLine());

        double sum = 0.0;

        //sum = Math.ceil(lightsaber*studentsCaunt + (0.1*lightsaber*studentsCaunt)) + robe*studentsCaunt + belt*studentsCaunt;
        sum = Math.ceil(lightsaber * (studentsCaunt + 0.1*studentsCaunt)) + robe*studentsCaunt + belt*studentsCaunt;

        if(budget>=sum){
            System.out.printf("The money is enough - it would cost %.2f lv.",sum);
        }else {
            System.out.printf("George Lucas will need %.2flv more.",sum-budget);
        }

    }
}
