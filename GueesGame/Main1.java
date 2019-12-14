package GueesGame;

import java.util.Random;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        yourGue();

    }
    public static int numberToGue(){
        Random r = new Random();
        int bound = 100;
        int result = r.nextInt(bound);
        return result;
    }
    public static int yourGue(){
        Scanner scan= new Scanner(System.in);
        int result=0;
        while (result==0) {
            if(String.valueOf(scan.nextLine())=)
            result=scan.nextInt();
        } ;
        return result;
    }

}
