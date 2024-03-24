package Controller;


import Model.CommandeClient;
import Model.Iplementation.CommandeClientDaoImpl;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CommandesClient", urlPatterns = "/CommandesClient")
public class CommandesClientServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        int idClient = (Integer) session.getAttribute("idClient");

        CommandeClientDaoImpl clientDao = new CommandeClientDaoImpl();
        List<CommandeClient> commandeClients = new ArrayList<>();
        try {
            commandeClients = clientDao.getCommandesClient(idClient);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.setAttribute("commandeClients", commandeClients);
        request.getRequestDispatcher("commandes_client.jsp").forward(request,response);
    }
}