public class Dev {
//hello world
	public static void main(String[] args) {
		System.out.println("Hello world!!!!");
		System.out.println("CECI EST LE DEV!!!");
		System.out.println("le dev aura des sous branches pour chaque fonctionalite du jeu");
		System.out.println("CECI EST LE DEVMAP sous branche de dev");
	}
}
/*
import java.io.File;
import java.util.ArrayList;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
public class Tower {
	
	public static void main(String argv[]) {
			
        try {

            File fXmlFile = new File("C:\\Users\\toto\\git\\ProjectTower\\ProjectTower\\src\\map.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory
                    .newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);
            doc.getDocumentElement().normalize();
            NodeList rowList = doc.getElementsByTagName("rows");
            int[][] map = new int[rowList.item(0).getChildNodes().getLength()-3][rowList.getLength()];
            for (int y = 0; y < rowList.getLength(); ++y) {
                NodeList cellList = rowList.item(y).getChildNodes();
                int k=0;
                for (int x = 0; x < cellList.getLength(); ++x) {
                    Node cell = cellList.item(x);
                                    if (cell.getNodeType() == Node.ELEMENT_NODE) {

                        if((Integer.parseInt(((Element) cell).getElementsByTagName("tileCode").item(0).getTextContent()))!=0){

                        map[k][y] = Integer.parseInt(((Element) cell)
                                .getElementsByTagName("tileCode").item(0)
                                .getTextContent());
                        k++;

                        }
                    }
                }
            }


            for (int y = 0; y < map[0].length; ++y) {
                for (int x = 0; x < map.length; ++x) {
                    System.out.print(map[x][y] + " ");
                }
                System.out.println("");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
*/