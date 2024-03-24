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
    private PreparedStatement stm;
    private ResultSet rs;
    private static Connection con;
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
    public Article getArticleById(int id) {
        Article article = null;
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

    public void updateArticle(Article article) throws SQLException {

        try {
            con = DbConnection.getConnexion();
            String query = "UPDATE articles SET designation = ?, prix = ?, stock = ?, category_id = ?, photo = ? WHERE id = ?";
            stm = con.prepareStatement(query);
            stm.setString(1, article.getDesignation());
            stm.setDouble(2, article.getPrix());
            stm.setInt(3, article.getStock());
            stm.setInt(4, article.getCategory_id());
            stm.setString(5, article.getPhoto());
            stm.setInt(6, article.getId());
            stm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}