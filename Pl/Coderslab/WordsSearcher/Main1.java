package Pl.Coderslab.WordsSearcher;

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


public class Main1 {
    public static void main(String[] args) throws FileNotFoundException {
        String[] excludedElements = {"oraz", "ponieważ"};
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
                read = read.replaceAll(pattern, "");
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
