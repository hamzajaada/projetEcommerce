package Controller;


import Model.Client;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class registerServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nom = req.getParameter("nom");
        String prenom = req.getParameter("prenom");
        String adresse = req.getParameter("adresse");
        String ville = req.getParameter("ville");
        String codePostal = req.getParameter("codePostal");
        String tel = req.getParameter("tel");

        Client c = new Client(nom,prenom,adresse,ville,codePostal,tel);


    }
}
