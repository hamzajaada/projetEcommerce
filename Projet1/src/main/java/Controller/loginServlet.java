package Controller;

import Model.Iplementation.ClientDaoImpl;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;

@WebServlet(name = "loginServlet", urlPatterns = "/loginServlet")
public class loginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nom = req.getParameter("nom");
        String motPasse = req.getParameter("password");
        String adminUsername = getInitParameter("adminUsername");
        String adminPassword = getInitParameter("adminPassword");
        ClientDaoImpl clientDao = new ClientDaoImpl();
        if(Objects.equals(nom, adminUsername) && Objects.equals(motPasse , adminPassword)) {
            HttpSession session = req.getSession(true);
            session.setAttribute("nomAdmin", adminUsername );
            req.setAttribute("nomAdmin",adminUsername);
            RequestDispatcher view = req.getRequestDispatcher("homeAdmin.jsp");
            view.forward(req,resp);
        } else if(clientDao.finClientByUsernameAndPassword(nom,motPasse)) {
            HttpSession session = req.getSession(true);
            session.setAttribute("nom", adminUsername );
            resp.sendRedirect(req.getContextPath() + "/bienvenue1.jsp");
        } else {
            resp.sendRedirect(req.getContextPath() + "/login.jsp");
        }
    }
}
