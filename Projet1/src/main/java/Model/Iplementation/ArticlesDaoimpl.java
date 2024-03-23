package Model.Iplementation;

import Model.Article;
import Model.DbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ArticlesDaoimpl {
    //private static Connection con;
    private PreparedStatement stm;
    private ResultSet rs;
   public List<Article> getAllArticle(){
       List<Article> Articles = new ArrayList<>();
       Connection con = null;
       String request = "select * from articles";
       try {
           con = DbConnection.getConnexion();
           System.out.println("avant stm");
           stm = con.prepareStatement(request);
           System.out.println("avant rs");
           rs = stm.executeQuery();

           while(rs.next()) {
               Article p = new Article(rs.getInt(1),rs.getString(2),rs.getDouble(3), rs.getInt(4),rs.getInt(5),rs.getString(6));
               System.out.println("while test");
               Articles.add(p);
           }
           System.out.println("apres rs");
           System.out.println("les articles : " + Articles.toString());
       } catch (Exception e) {
           e.printStackTrace();
       } finally {
           try {
               if (rs != null) {
                   rs.close();
               }
               if (stm != null) {
                   stm.close();
               }
               if (con != null) {
                   con.close();
               }
           } catch (SQLException e) {
               e.printStackTrace();
           }
       }
       return  Articles;
   }
    public Article getArticleById(int id) {
        Article article = null;
        Connection con = null;
        String request = "SELECT * FROM articles WHERE id = ?";
        try {
            con = DbConnection.getConnexion();
            stm = con.prepareStatement(request);
            stm.setInt(1, id);
            rs = stm.executeQuery();
            if (rs.next()) {
                article = new Article(rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getInt(4), rs.getInt(5), rs.getString(6));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return article;
    }
}
