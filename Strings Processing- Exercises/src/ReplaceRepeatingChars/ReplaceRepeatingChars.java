package ReplaceRepeatingChars;

import java.util.Scanner;

public class ReplaceRepeatingChars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text =scanner.nextLine();
        StringBuilder sb = new StringBuilder();

        //sb.append(text.charAt(0));
        for(int i=0; i<text.length(); i++){
            //sb.append(text.charAt(i));
            while(i<text.length()-1){
                if(text.charAt(i)!=text.charAt(i+1)){
                    sb.append(text.charAt(i));
                }
                i++;
            }
            sb.append(text.charAt(i));


        }
        System.out.println(sb);
    }
}
