package Controller;


import Model.Client;


import Model.Iplementation.ClientDaoImpl;


import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.sql.SQLException;

import static java.lang.Integer.parseInt;

@WebServlet(name = "registerServlet", urlPatterns = "/registerServlet")
public class registerServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nom = req.getParameter("nom");
        String prenom = req.getParameter("prenom");
        String adresse = req.getParameter("adresse");
        String ville = req.getParameter("ville");
        int codePostal = parseInt(req.getParameter("codePostal"));
        String tel = req.getParameter("tel");
        String motPasse = req.getParameter("motPasse");

        Client c = new Client(nom,prenom,adresse,codePostal,ville,tel,motPasse);
        ClientDaoImpl clientDao = new ClientDaoImpl();

        try {
            clientDao.AddClient(c);
            System.out.println("client added successful");
            resp.sendRedirect(req.getContextPath() + "/login.jsp");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
