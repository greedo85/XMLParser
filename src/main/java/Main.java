import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.net.URISyntaxException;

public class Main {

    public static void main( String[] args ) throws ParserConfigurationException, SAXException, IOException, URISyntaxException {
        XMLParser xmlParser=new XMLParser();
        xmlParser.parseXML("https://justjoin.it/feed.atom","entry","id","title");
    }

}
