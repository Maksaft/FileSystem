package models.userFunctions;

public interface Users {
    public String[] getUsers();
    public int getUsersCount();
    public int getUserById(String id);
    public String getUserPatch(String id);

}
