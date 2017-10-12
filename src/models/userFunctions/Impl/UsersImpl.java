package models.userFunctions.Impl;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import res.MyData;
import models.userFunctions.DAO.UserDAO;
import models.userFunctions.Users;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class UsersImpl implements Users {
    public UsersImpl() {
        createUsers();
    }

    private UserDAO[] users;

    private UserDAO createUser(String id, String name, String path) {
        UserDAO u = new UserDAO();
        u.setId(id);
        u.setName(MyData.USERSDIR+name);
        u.setPath(path);
        return u;
    }

    private void createUsers() {
        try {

            // Строим объектную модель исходного XML файла
            final File xmlFile = new File(MyData.USERFILEPATH);
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(xmlFile);

            // Выполнять нормализацию не обязательно, но рекомендуется
            doc.getDocumentElement().normalize();

            NodeList nodeList = doc.getElementsByTagName("user");
            users = new UserDAO[nodeList.getLength()];
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if (Node.ELEMENT_NODE == node.getNodeType()) {
                    Element element = (Element) node;
                    users[i] = createUser(element.getAttribute("id"),
                            element.getElementsByTagName("name").item(0).getTextContent(),
                            element.getElementsByTagName("path").item(0).getTextContent());
                }
            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    private String[] getUserNames(){
        String[] result = new String[users.length];
        for(int i = 0; i< result.length; i++){
            result[i] = getUserNameById(i);
        }

        return result;
    }

    @Override
    public String[] getUsers() {
        return getUserNames();
    }


    private String getUserNameById(int id) {
        return users[id].getName();
    }

    @Override
    public int getUsersCount() {
        return users.length;
    }

    @Override
    public int getUserById(String id) {
        for(int i = 0; i < getUsersCount(); i++ ){
            if (id.compareTo(users[i].getId())==0){
              return i;
            }
        }
        return -1;
    }

    @Override
    public String getUserPatch(String id) {
        return users[getUserById(id)].getPath();
    }

}
