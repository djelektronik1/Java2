package XML;

import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DomParser {
    public static Channel parse(String url) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(url);

        NodeList itemList = document.getDocumentElement().getElementsByTagName("item");
        ArrayList<Item> items = new ArrayList<>();
        for (int i = 0; i < itemList.getLength(); i++) {
            Node item = itemList.item(i);

            NodeList itemDataList = item.getChildNodes();
            items.add(new Item(
                    itemDataList.item(1).getTextContent(),
                    itemDataList.item(3).getTextContent(),
                    itemDataList.item(5).getTextContent()
            ));
        }

        return new Channel(
                items
        );
    }
}