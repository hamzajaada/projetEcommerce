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
        ArticlesDaoimpl articlesDao = new ArticlesDaoimpl();
        List<Article> articles = articlesDao.getAllArticle();
        System.out.println("les articles");
        System.out.println(articles);
        request.setAttribute("articles" , articles);
        request.getRequestDispatcher("home.jsp").forward(request,response);
    }
}