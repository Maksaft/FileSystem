package models.fileFunctions.impl;

import models.fileFunctions.FileFunction;

import java.io.File;

public class FileFunctionImpl implements FileFunction{
    private String markAsDir(String dirName){
        return "<b>"+dirName+"</b>";
    }
    private String[] getFilesFromFolder(String path){
        try {
            File dir = new File(path); //path указывает на директорию
            File[] arrFiles = dir.listFiles();
            String[] result = new String[arrFiles.length];
            for(int i=0; i<arrFiles.length ;i++){
                if (arrFiles[i].isDirectory()) {
                    result[i]= markAsDir(arrFiles[i].getName());
                } else {
                    result[i]= arrFiles[i].getName();
                }
            }
            return result;
        }
        catch(NullPointerException e ){
            e.printStackTrace();
            return new String[]{"No such folder"};
        }
    }
    protected static boolean copyFolder (String pathFrom, String pathTo){
        return false;
    }

    @Override
    public int moveFolder(String pathFrom, String pathTo) {
        return 0;
    }

    @Override
    public int moveFile(String pathFrom, String pathTo) {
        return 0;
    }

    @Override
    public int renameFolder(String path, String newName) {
        return 0;
    }

    @Override
    public int renameFile(String path, String newName) {
        return 0;
    }

    @Override
    public String[] search(String searchText) {
        return new String[0];
    }

    @Override
    public String showFolder(String path) {
       return getFilesFromFolder(path).toString();
    }
}
