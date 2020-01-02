package Pl.Coderslab.Zgadywanie2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int max = 1000;
        int min = 0;
        String str;
        System.out.println(" Pomyśl liczbe z przedziału 0-1000, a ja ją zgadne w max 10 próbach. Gotowy?");
        System.out.println("Zgaduje " + guessMe(max, min));
        str = scan.nextLine();
        while (!str.equalsIgnoreCase("1-1")) {
            if (str.equalsIgnoreCase("mniej")) {
                max = guessMe(max, min);
            }
            if (str.equalsIgnoreCase("wiecej")) {
                min = guessMe(max, min);
            }
            if (str.equalsIgnoreCase("trafiles")) {
                System.out.println("Zgadłem :)");
                break;
            }
            if (max == min + 1) {
                System.out.println("Oszukujesz ? ;)");

            }
            System.out.println("Zgaduje " + guessMe(max, min));
            str = scan.nextLine();

        }


    }

    private static int guessMe(int max, int min) {
        return ((max - min) / 2) + min;

    }
}
