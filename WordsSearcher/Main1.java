package WordsSearcher;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;


/*

    Wywołaj pobieranie dla wybranych serwisów internetowych.
    Pomiń wszystkie elementy krótsze niż 3-znakowe.
    Utwórz tablicę elementów wykluczonych np. oraz, ponieważ
    Wczytaj utworzony plik popular_words.txt i na jego podstawie utwórz plik filtered_popular_words.txt, który zawierać będzie wszystkie znalezione słowa, pomijając słowa wykluczone.

*/
public class Main1 {
    public static void main(String[] args) throws FileNotFoundException {
        String[] excludedElements ={"oraz","ponieważ"};
        Connection connect = Jsoup.connect("http://www.onet.pl/");
        File file = new File("popular_words.txt");
        String pattern = "[.]|[,]|[:]|[!]|[\"]|[?]|[-]|[%]";


        try {
            PrintWriter printWriter = new PrintWriter("popular_words.txt");

            Document document = connect.get();
            Elements links = document.select("span.title");
            for (Element elem : links) {
                printWriter.println(elem.text());
            }
            printWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        PrintWriter printWriter = new PrintWriter("popular_Filtered_words.txt");

        String read;
        try {
            Scanner scan = new Scanner(file);
            while (scan.hasNext()) {
                read = scan.next();
                read=read.replaceAll(pattern,"");
                for (String word : excludedElements) {
                    if (read.equals(word)) {
                        read = "";
                        break;
                    }

                }
                if (read.length() > 3) {
                    printWriter.println(read);
                }
            }
            printWriter.close();
        } catch (FileNotFoundException e) {
            System.out.println("Brak pliku.");
        }
    }
}
