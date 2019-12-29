import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner scan= new Scanner(System.in);
        int max=1000;
        int min=0;
        String str="";
        System.out.println(" Pomyśl liczbe z przedziału 0-1000, a ja ją zgadne w max 10 próbach. Gotowy?");
        System.out.println("Zgaduje " + guessMe(max,min) );
        str=scan.nextLine();
        while(!str.equalsIgnoreCase("trafiles")) {
//            scan.nextLine();
            if(str.equalsIgnoreCase("mniej")) {
                max=guessMe(max,min);
//                str=scan.nextLine();
            } else if(str.equalsIgnoreCase("wiecej")){
                min=guessMe(max,min);
//                str=scan.nextLine();
            } else if(str.equalsIgnoreCase("trafiles")) {
                System.out.println("Zgadłem :)");
            }
                System.out.println("Zgaduje " + guessMe(max, min));
                str=scan.nextLine();

        }



    }
    public static int guessMe(int max,int min){
        int guess= ((max-min)/2)+min;
        return guess;

    }
}
