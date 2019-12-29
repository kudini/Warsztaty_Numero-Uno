package GueesGame;

import java.util.Random;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        int guessMe=numberToGue();
        int a;
        do {
            a=yourGue();
            if (a>guessMe){
                System.out.println("za duzo");
            } else if (a<guessMe){
                System.out.println(" za mało");
            } else
                System.out.println("zgadłeś to "+ a);
        } while (guessMe!=a);

    }
    private static int numberToGue(){
        Random r = new Random();
        int bound = 100;
        return r.nextInt(bound);
    }
    private static int getResult() {
        Scanner scan = new Scanner(System.in) ; int result =0;
        if(scan.hasNextInt()) {
            int a=scan.nextInt();
            if(a<=100 && a>=0) {
                result = a;
            } else {
                System.out.println("Podaj liczbe mniejsza lub rowna niż 100 i wieksza od -1");
            }
        }else {
            System.out.println("to nie jest liczba całkowita");
        }
        return result;
    }

    private static int yourGue(){
        int result=0;
        System.out.println("Podaj liczbe całkowitą");
        while (result==0) {
            result = getResult();
        }
        return result;
    }

}
