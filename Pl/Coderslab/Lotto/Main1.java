package Pl.Coderslab.Lotto;


import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {

        int[] b = lottoNumbers();
        youWinYouLose(chooseNumbers(), b);


    }

    private static int[] chooseNumbers() {
        int[] result = new int[6];
        int temp = -1;
        int tT, s;
        for (int i = 0; i < 6; i++) {
            tT = 0;


            if (i == 0) {
                System.out.println("Podaj " + (i + 1) + " liczbę");
                result[i] = testIf1_49();
            } else {
                while (tT == 0) {
                    System.out.println("Podaj " + (i + 1) + " liczbę");
                    s = tT;
                    temp = testIf1_49();
                    for (int j = 0; j <= i; j++) {
                        if (result[j] == temp) {
                            System.out.println("Wybrałeś już tą liczbe.");
                            s++;
                        }
                    }
                    if (s == 0) {
                        tT = 1;
                    }
                }
                result[i] = temp;
            }
        }
        Arrays.sort(result);
        return result;
    }

    private static int testIf1_49() {
        int result;
        result = testIfInt();
        while (result < 1 || result > 49) {
            System.out.println("Podałeś liczbe spoza zakresu 1-49 podaj ja jeszcze raz");
            result = testIfInt();
        }
        return result;
    }

    private static int testIfInt() {
        Scanner scan = new Scanner(System.in);
        while (!scan.hasNextInt()) {
            scan.next();
            System.out.println("\n Nieprawidłowe dane");
        }
        return scan.nextInt();
    }

    private static int[] lottoNumbers() {
        int[] result = new int[6];
        Integer[] arr = new Integer[49];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }

        Collections.shuffle(Arrays.asList(arr));
        for (int i = 0; i < 6; i++) {
            result[i] = arr[i];
        }
        Arrays.sort(result);
        return result;
    }

    private static void youWinYouLose(int[] a, int[] b) {
        int x = 0;
        System.out.println("Wygrane liczby to:");
        System.out.println(Arrays.toString(b));
        System.out.println("Twoje liczby to:");
        System.out.println(Arrays.toString(a));

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if (a[i] == b[j]) {
                    x++;
                }
            }
        }
        if (x >= 3) {
            System.out.println("Wygrana");
        } else {
            System.out.println("Spróbuj ponownie swojego szczescia");
        }
    }
}