package Vievs;

import javax.servlet.http.HttpServletRequest;

public abstract class AbstractPageView {
    public String html="";
    String lochalLink="http://localhost:8080/FileSystem_war_exploded";
public AbstractPageView(){
    html=createStandartPage();
}

    public String createStandartPage() {
        String result = "\n";
        result += createLink("USERS","/Users");
        result += "<p>&nbsp;</p>\n" + "<div style=\"page-break-after: always;\"><span style=\"display: none;\">&nbsp;</span></div>\n" +
                "<p>&nbsp;</p>";
        return result;
    }

    public String createLink(String name, String link){
        return "<p><a href=\""+lochalLink+link+"\">"+name+"</a></p>";
    }
}
