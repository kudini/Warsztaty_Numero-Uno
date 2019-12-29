package DiceRoller;

import java.util.Random;
import java.util.Scanner;

public class Main1 {
/*

    Napisz funkcję, która:

    przyjmie w parametrze taki kod w postaci String,
    rozpozna wszystkie dane wejściowe:
    rodzaj kostki, 2xD10 +10
    liczbę rzutów, dices/type+modifier
            modyfikator,
    wykona symulację rzutów i zwróci wynik.

    Typy kostek występujące w grach:

    D3, D4, D6, D8, D10, D12, D20, D100.
            while(!scan.hasNext("quit")) {
            str=str+scan.nextLine()+ "\n";
        }
        Syst
*/
    public static void main(String[] args) {
        Random random= new Random();
        Scanner scan = new Scanner(System.in);
        System.out.println("Program symuluje rzut następującymi kośćmi:");
        System.out.println("D3, D4, D6, D8, D10, D12, D20, D100.");
        System.out.println("Wprowadź dane według wzoru: YxDYY +/-YY np.2xd10 +10");
        System.out.println("By zakończyć wpisz quit");
        while(true) {
            System.out.print("Rzuć :");
            String str = scan.nextLine();
            if (str.contains("quit")){
                break;
            }
            int a1 = 1, c1, result, dice;
            str = str.toLowerCase();
            if (str.contains("d")) {
                String b = typeOfDice(str);

                if (str.contains("x")) {
                    if (roll(b, random) != -1) {
                        a1 = numberOfRolls(str);
                    } else {
                        a1 = 0;
                    }
                }


                result = 0;
                for (int i = 0; i < a1; i++) {
                    dice = roll(b, random);
                    if (dice > 0) {
                        if (a1 == 1) {
                            System.out.println("Wyrzuciłeś : " + dice);
                        } else {
                            System.out.print(i + 1 + " rzut to: " + dice);
                        }
                        result = result + dice;
                    }
                    System.out.println();
                }
                if (result > 0) {
                    if (str.contains(" ")) {
                        char c2 = str.charAt(str.indexOf(" ") + 1);
                        c1 = modifier(str);

                        if (c2 == '+') {
                            System.out.println("Twój wynik to:");
                            System.out.println(result + c1);
                        }
                        if (c2 == '-') {
                            System.out.println("Twój wynik to:");
                            System.out.println(result - c1);
                        }
                    } else {
                        System.out.println("Twój wynik to:");

                        System.out.println(result);
                    }
                }
            } else {
                System.out.println("Nieprawidłowe dane");
            }
        }
    }

    private static int roll(String str, Random random) {
        int result=-1;
        if(str.equalsIgnoreCase("D3")){
            result=random.nextInt(3)+1;
        }
        if(str.equalsIgnoreCase("D4")){
            result=random.nextInt(4)+1;
        }
        if(str.equalsIgnoreCase("D6")){
            result=random.nextInt(6)+1;
        }
        if(str.equalsIgnoreCase("D8")){
            result=random.nextInt(8)+1;
        }
        if(str.equalsIgnoreCase("D10")){
            result=random.nextInt(10)+1;
        }
        if(str.equalsIgnoreCase("D12")){
            result=random.nextInt(12)+1;
        }
        if(str.equalsIgnoreCase("D20")){
            result=random.nextInt(20)+1;
        }
        if(str.equalsIgnoreCase("D100")){
            result=random.nextInt(100)+1;
        }
        if (result == -1) {
            System.out.println("Nie ma takiej kości");
        }
        return result;
    }
    private static int numberOfRolls(String str) {
        int result;
        result=Integer.parseInt(str.substring(0 ,str.indexOf("x")));
        return result;
    }
    private static int modifier(String str) {

        int result;
        result=Integer.parseInt(str.substring(str.lastIndexOf(" ")+1));
        return result;
    }
    private static String typeOfDice(String str){
        String result;
        if(str.contains(" ")) {
            if (str.indexOf("d") > str.indexOf(" ")) {
                result="Nieprawidłowe dane ";
                System.out.println(result);
            }else {
                result = str.substring(str.indexOf("d"), str.indexOf(" "));
            }
        } else {
            result=str.substring(str.indexOf("d"));
        }
        return result;
    }
}
