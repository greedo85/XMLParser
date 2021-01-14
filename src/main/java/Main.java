import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Scanner;

public class Main {

    public static void main( String[] args ) throws ParserConfigurationException, SAXException, IOException, URISyntaxException {
        XMLParser xmlParser = new XMLParser();
        Scanner scanner = new Scanner(System.in);
        String keyword;
        int choice;
        do {
            System.out.println("1 - dodawaj dalej");
            System.out.println("0 - zakończ dodawania");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    scanner.nextLine();
                    System.out.println("Podaj słowo klczowe:");
                    keyword = scanner.nextLine();
                    xmlParser.setKeyWords(keyword);
                    break;
                case 0:
                    break;
            }

        } while (choice != 0);

        xmlParser.parseXML("https://justjoin.it/feed.atom", "entry");
    }

}
