package Controller;


import Model.Client;
<<<<<<< HEAD
=======
import Model.Iplementation.ClientDaoImpl;
>>>>>>> ca167d9b677a30e4c33a9099f939110ace8e91e6
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "registerServlet", urlPatterns = "/registerServlet")
public class registerServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nom = req.getParameter("nom");
        String prenom = req.getParameter("prenom");
        String adresse = req.getParameter("adresse");
        String ville = req.getParameter("ville");
        String codePostal = req.getParameter("codePostal");
        String tel = req.getParameter("tel");
        String motPasse = req.getParameter("motPasse");

        Client c = new Client(nom,prenom,adresse,ville,codePostal,tel,motPasse);
        ClientDaoImpl clientDao = new ClientDaoImpl();
        try {
            clientDao.AddClient(c);
            System.out.println("client added successful");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
