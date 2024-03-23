package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ArticlesDaoimpl {
    private static Connection con;
    private PreparedStatement stm;
    private ResultSet rs;
   public List<Article> getAllArticle(){
   List<Article> Articles = new ArrayList<Article>();
        con = DbConnection.getConnexion();
       String request = "select * from articles";
       try {
           stm = con.prepareStatement(request);
           rs = stm.executeQuery();
           while(rs.next()) {
               Article p = new Article(rs.getInt(1),rs.getString(2),rs.getDouble(3), rs.getInt(4),rs.getInt(5),rs.getString(6));
               Articles.add(p);
           }
       } catch (Exception e) {
           e.printStackTrace();
       }
       return  Articles;
   }
}
