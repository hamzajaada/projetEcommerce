package Controller;

import Model.Client;
import Model.Iplementation.ClientDaoImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet(name = "loginServlet", urlPatterns = "/loginServlet")
public class loginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nom = req.getParameter("nom");
        String motPasse = req.getParameter("password");
        String adminUsername = getServletContext().getInitParameter("adminUsername");
        String adminPassword = getServletContext().getInitParameter("adminPassword");
        ClientDaoImpl clientDao = new ClientDaoImpl();
        Client c = clientDao.finClientByUsernameAndPassword(nom,motPasse);
        if((nom.equals(adminUsername)) && (motPasse.equals(adminPassword))){
            resp.sendRedirect(req.getContextPath() + "/homeAdmin.jsp");
        } else if(c != null) {
            HttpSession session = req.getSession(true);
            session.setAttribute("nom", c.getNom() );
            session.setAttribute("idClient", c.getId() );
            resp.sendRedirect(req.getContextPath() + "/bienvenue1.jsp");
        } else {
            resp.sendRedirect(req.getContextPath() + "/login.jsp");
        }
    }
}