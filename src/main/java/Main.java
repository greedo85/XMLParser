import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main( String[] args ) throws ParserConfigurationException, SAXException, IOException, URISyntaxException {
        XMLParser xmlParser = new XMLParser();
        Scanner scanner = new Scanner(System.in);
        String tagName;
        int choice;
        System.out.println("Podaj tagi które mają być brane pod uwagę");
        System.out.println("(sprawdź poprawność inaczej program nie zadziałą)");
        do {
            System.out.println("1 - dodawaj dalej");
            System.out.println("0 - zakończ dodawania");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    scanner.nextLine();
                    System.out.println("Podaj nazwę tagu:");
                    tagName = scanner.nextLine();
                    xmlParser.setTagNames(tagName);
                    break;
                case 0:
                    break;
            }

        } while (choice != 0);
        System.out.println("Wybrałeś tagi: ");
        xmlParser.tagNames.forEach(System.out::println);
        System.out.println("podaj słowa kluczowe ");

        xmlParser.parseXML("https://justjoin.it/feed.atom", "entry");
        xmlParser.dataElementList.forEach(System.out::println);
        /*List<DataElement> list=xmlParser.dataElementList.stream().filter(c->
        {
            c.equals(xmlParser.dataElement.
        })*/
    }

}
