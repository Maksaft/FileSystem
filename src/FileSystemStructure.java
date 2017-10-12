import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import res.MyData;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class FileSystemStructure {
    FileSystemStructure() {
        createStandartFolders();
        createUsersXmlFile();
        createExtendedFolders();
    }


    private void createStandartFolders() {
        File folder = new File(MyData.USERSDIR);
        folder.mkdirs();
    }

    private void createExtendedFolders() {
        File folder = new File(MyData.USERSDIR + "/Maks/");
        folder.mkdirs();
        folder = new File(MyData.USERSDIR + "/Antony/newFolder");
        folder.mkdirs();
    }

    private void createUsersXmlFile() {
        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = null;
            docBuilder = docFactory.newDocumentBuilder();

            Document doc = docBuilder.newDocument();
            Element rootElement = doc.createElement("users");
            doc.appendChild(rootElement);

            createUserXML(doc, rootElement,"Maks");
            createUserXML(doc, rootElement,"Antony");

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(MyData.USERFILEPATH));
            transformer.transform(source, result);

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }

    private void createUserXML(Document doc, Element rootElement,String namee) {
        Element user = doc.createElement("user");
        rootElement.appendChild(user);

        Attr attr = doc.createAttribute("id");
        attr.setValue(namee);
        user.setAttributeNode(attr);

        Element name = doc.createElement("name");
        name.appendChild(doc.createTextNode(namee));
        user.appendChild(name);

        Element path = doc.createElement("path");
        path.appendChild(doc.createTextNode("/"+namee));
        user.appendChild(path);
    }
}
