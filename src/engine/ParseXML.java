package engine;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class ParseXML implements IReadData{

    @Override
    public boolean read(String fileName) {

        try {
            DocumentBuilderFactory f = DocumentBuilderFactory.newInstance();
            f.setNamespaceAware(true);
            DocumentBuilder builder = f.newDocumentBuilder();
            Document doc = builder.parse(fileName);
            Element element = doc.getDocumentElement();
            NodeList nodes = element.getChildNodes();
            for (int i = 0; i < nodes.getLength(); i++) {
                System.out.println("" + nodes.item(i).getTextContent());
            }
            /*NodeList nodeList = doc.getElementsByTagName("settings");
            for (int i = 0; i < nodeList.getLength(); i++){
                Node node = nodeList.item(i);
                if (Node.ELEMENT_NODE == node.getNodeType()){
                    if (node.getNodeName().equals("width")){
                        pageWidth = Integer.parseInt(node.getTextContent());
                    }

                    if (node.getNodeName().equals("height")){
                        pageHeigth = Integer.parseInt(node.getTextContent());
                    }
                }
            }

            nodeList = doc.getElementsByTagName("column");
            for (int i = 0, j = 0, k = 0; i < nodeList.getLength(); i++){
                Node node = nodeList.item(i);
                if (Node.ELEMENT_NODE == node.getNodeType()){
                    if (node.getNodeName().equals("title")){
                        titleColoum[j++] = node.getTextContent();
                    }
                    if (node.getNodeName().equals("width")){
                        widthColoum[k++] = Integer.parseInt(node.getTextContent());
                    }
                }
            }
*/


        } catch (ParserConfigurationException e) {
            e.printStackTrace();
            return false;
        } catch (SAXException e) {
            e.printStackTrace();
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    private int pageWidth;

    public int getPageHeigth() {
        return pageHeigth;
    }

    public int[] getWidthColoum() {
        return widthColoum;
    }

    public String[] getTitleColoum() {
        return titleColoum;
    }

    public int getPageWidth() {
        return pageWidth;
    }

    private int pageHeigth;
    private int []widthColoum;
    private String[] titleColoum;

}