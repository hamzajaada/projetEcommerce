package Controller;

import Model.Article;
import Model.Iplementation.ArticlesDaoimpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/getArticle")
public class GetArticle extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("articleId"));
        System.out.println("id :");
        System.out.println(id);
        ArticlesDaoimpl Ad = new ArticlesDaoimpl();
        Article article = Ad.getArticleById(id);
        req.setAttribute("article" , article);
        req.getRequestDispatcher("datail.jsp").forward(req,resp);




    }
}
