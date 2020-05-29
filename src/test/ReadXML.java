package test;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class ReadXML {

    private static final String FILE_PATH = "/config/solr.xml";


    @Test
    public void read() {
        try {
            InputStreamReader in = new InputStreamReader(ReadXML.class.getResourceAsStream(FILE_PATH));

            SAXReader reader = new SAXReader();
            Document document = reader.read(in);
            Element root = document.getRootElement();
            Iterator iterator = root.elementIterator("solr");

            while (iterator.hasNext()) {
                Element element = (Element) iterator.next();
                String name = element.elementText("name");
                String url = element.elementText("url");

                System.out.println("name:" + name + "  url:" + url);
            }


            List<Element> list = root.elements();
            for (Element e : list) {
                String elementName = e.getName();
                String elementValue = e.getText();
                System.out.println(elementName + ":" + elementValue);
            }

        } catch (DocumentException e) {
            e.printStackTrace();
        }

    }
}
