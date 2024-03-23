package Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.Objects;

@WebServlet(name = "loginServlet", urlPatterns = "/loginServlet")
public class loginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nom = req.getParameter("nom");
        String motPasse = req.getParameter("password");

        String adminUsername = getInitParameter("adminUsername");
        String adminPassword = getInitParameter("adminPassword");

        if(Objects.equals(nom, adminUsername) && Objects.equals(motPasse , adminPassword)) {

        }
    }
}
