package Vievs.impl;

import Vievs.AbstractPageView;
import models.fileFunctions.FileFunction;
import models.fileFunctions.impl.FileFunctionImpl;
import models.userFunctions.Impl.UsersImpl;
import models.userFunctions.Users;

public class FolderView extends AbstractPageView {

    FolderView() {
        super();
    }


    FolderView(String userId, String path) {
        super();
        FileFunction ff = new FileFunctionImpl();
        Users users = new UsersImpl();


        String mainPath = users.getUserPatch(userId) + path;
        String[][] folder = ff.showFolder(mainPath);

        html+= createLink("back",users.getUserPatch(userId));
        for(int i=0; i<folder.length;i++){
            if ("1".compareTo(folder[i][0])==0) {
                html+= createLink("",users.getUserPatch(userId));
            }
        }
    }
}
