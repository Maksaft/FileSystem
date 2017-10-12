package models.userFunctions.DAO;

public class UserDAO {
    private String id = "";
    private String name = "";
    private String path = "";


    public String getName() {
        return name;
    }
    public void setName(String newName) {
        this.name = newName;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
