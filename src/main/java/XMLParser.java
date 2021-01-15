import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class XMLParser {

    DocumentBuilderFactory documentBuilderFactory;
    DocumentBuilder documentBuilder;
    Document document;
    URI uri;
    List<String> tagNames;
    List<DataElement> dataElementList;
    DataElement dataElement;

    public XMLParser() throws ParserConfigurationException {
        documentBuilderFactory = DocumentBuilderFactory.newInstance();
        documentBuilder = documentBuilderFactory.newDocumentBuilder();
        tagNames = new ArrayList<>();
        dataElementList = new ArrayList<>();
    }

    public void setTagNames( String elementTagName ) {
        tagNames.add(elementTagName);
    }

    public void parseXML( String adress, String tagname ) throws URISyntaxException, IOException, SAXException {
        uri = new URI(adress);
        document = documentBuilder.parse(String.valueOf(uri));
        NodeList nodeList = document.getElementsByTagName(tagname);
        String someElement;
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                    dataElement = new DataElement();
                for (int j = 0; j < tagNames.size(); j++) {
                    someElement = element.getElementsByTagName(tagNames.get(j)).item(0).getTextContent();
                    dataElement.addToInfo(someElement);
                }
                    dataElementList.add(dataElement);
            }
        }
    }
}
