package Controller;

import Model.Article;
import Model.Iplementation.ArticlesDaoimpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


@WebServlet("/getAllArticles")
public class GetAllArticlesServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h2>Liste des articles</h2>");

        // Création de l'objet ArticlesDaoimpl
        ArticlesDaoimpl articlesDao = new ArticlesDaoimpl();

        // Appel de la méthode getAllArticle() pour récupérer tous les articles
        List<Article> articles = articlesDao.getAllArticle();

        // Affichage des articles
        out.println("<ul>");
        for (Article article : articles) {
            out.println("<li>" + article.getId() + " - " + article.getDesignation() + " - " + article.getPrix() + "</li>");
        }
        out.println("</ul>");

        out.println("</body></html>");
    }
}