package models.fileFunctions;

public interface FileFunction {
    public int moveFolder(String pathFrom, String pathTo);
    public int moveFile(String pathFrom, String pathTo);

    public int renameFolder(String path, String newName);
    public int renameFile(String path, String newName);

    public String[] search(String searchText);

    public String[][] showFolder(String path);
}
