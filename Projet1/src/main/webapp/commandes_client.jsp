<%@ page import="Model.Iplementation.CommandeClientDaoImpl" %>
<%@ page import="Model.CommandeClient" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Afficher les commandes</title>
</head>
<body>
<h1>Commandes du client</h1>
<table border="1">
    <thead>
    <tr>
        <th>ID Commande</th>
        <th>Date Commande</th>
        <th>Quantité Commandée</th>
        <th>Désignation Article</th>
        <th>Prix Article</th>
    </tr>
    </thead>
    <tbody>
        <% for (CommandeClient commande : (List<CommandeClient>) request.getAttribute("commandeClients")) { %>
        <tr>
            <td><%= commande.getIdCommande() %></td>
            <td><%= commande.getDateCommande() %></td>
            <td><%= commande.getQteCde() %></td>
            <td><%= commande.getDesignationArticle() %></td>
            <td><%= commande.getPrixArticle() %></td>
        </tr>
        <% } %>
    </tbody>
</table>
</body>
</html>