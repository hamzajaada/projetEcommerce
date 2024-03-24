package Controller;

import Model.Article;
import Model.Client;
import Model.Commande;
import Model.Iplementation.ArticlesDaoimpl;
import Model.Iplementation.ClientDaoImpl;
import Model.Iplementation.CommandeDaoImpl;
import Model.Iplementation.LignesCommandeDaoImpl;
import Model.LignesCommande;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
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

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        List<Article> panier = (List<Article>) session.getAttribute("panier");
        int idClient = (Integer) session.getAttribute("idClient");
        ClientDaoImpl clientDao = new ClientDaoImpl();
        Client cl = clientDao.findClientById(idClient);

        if (panier != null && !panier.isEmpty()) {
            ArticlesDaoimpl articleDao = new ArticlesDaoimpl();
            CommandeDaoImpl commandeDao = new CommandeDaoImpl();
            LignesCommandeDaoImpl ligneCommandeDao = new LignesCommandeDaoImpl();
            Date dateCommande = new Date();

            try {
                for (Article article : panier) {
                    int quantite = Integer.parseInt(req.getParameter("quantity_" + article.getId()));

                    int newStock = article.getStock() - quantite;
                    article.setStock(newStock);
                    articleDao.updateArticle(article);

                    LignesCommande ligneCommande = new LignesCommande();
                    ligneCommande.setArticleId(article.getId());
                    ligneCommande.setQteCde(quantite);
                    ligneCommandeDao.addLigneCommande(ligneCommande);
                }


                Commande commande = new Commande();
                commande.setClient(cl);
                commande.setDateCommande(dateCommande);
                commandeDao.addCommande(commande);

                resp.sendRedirect(req.getContextPath() + "/confirmation.jsp");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            resp.sendRedirect(req.getContextPath() + "/panier.jsp");
        }
    }
}
