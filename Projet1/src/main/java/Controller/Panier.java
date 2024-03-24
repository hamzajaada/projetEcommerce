package Controller;

import Model.Article;
import Model.Iplementation.ArticlesDaoimpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "Panier", urlPatterns = "/Panier")
public class Panier  extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int idArticle = Integer.parseInt(req.getParameter("id"));
        System.out.println("idArticle :");
        System.out.println(idArticle);
        ArticlesDaoimpl Ad = new ArticlesDaoimpl();
        Article article = Ad.getArticleById(idArticle);
        HttpSession session = req.getSession(true);
        List<Article> panier = (List<Article>) session.getAttribute("panier");
        if (panier == null) {
            panier = new ArrayList<>();
            session.setAttribute("panier", panier);
        }
        panier.add(article);

        resp.sendRedirect(req.getContextPath() + "/panier.jsp");
    }


}
