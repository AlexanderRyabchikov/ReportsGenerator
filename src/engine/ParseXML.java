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
            NodeList nodeList = element.getChildNodes();
            widthColoum = new int[NUM_NODE_WIDTH_COLOUM];
            titleColoum = new String[NUM_NODE_TITLE_COLOUM];
            for (int i = 0; i < nodeList.getLength(); i++) {
                if (nodeList.item(i).getNodeName().equals("page")) {
                    NodeList node = nodeList.item(i).getChildNodes();
                    for (int j = 0; j < node.getLength(); j++) {
                        if (node.item(j).getNodeName().equals("width")) {
                            pageWidth = Integer.parseInt(node.item(j).getTextContent());
                        }

                        if (node.item(j).getNodeName().equals("height")) {
                            pageHeigth = Integer.parseInt(node.item(j).getTextContent());
                        }
                    }
                }
                if (nodeList.item(i).getNodeName().equals("columns")) {
                    int q = 0, g = 0;
                    NodeList node = nodeList.item(i).getChildNodes();
                    for (int j = 0; j < node.getLength(); j++) {
                        if (node.item(j).getNodeName().equals("column")) {
                            NodeList embeddedNode = node.item(j).getChildNodes();
                            for (int k = 0; k < embeddedNode.getLength(); k++) {
                                if (embeddedNode.item(k).getNodeName().equals("title")) {
                                    titleColoum[q++] =
                                            embeddedNode.item(k).getTextContent();
                                }
                                if (embeddedNode.item(k).getNodeName().equals("width")) {
                                    widthColoum[g++] =
                                            Integer.parseInt(embeddedNode.item(k).getTextContent());

                                }
                            }
                        }
                    }
                }

            }
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
    public static final int NUM_NODE_WIDTH_COLOUM = 3;
    public static final int NUM_NODE_TITLE_COLOUM = 3;
}