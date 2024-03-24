<%@ page import="Model.Article" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Page de panier</title>
</head>
<body>
<div class="container">
<<<<<<< HEAD
    <table>
        <thead>
        <tr>
            <th>Designation</th>
            <th>Catégorie</th>
            <th>Qantité</th>
            <th>Prix</th>
        </tr>
        </thead>
        <tbody>
        <%
            HttpSession SessionApp = request.getSession(false);
            List<Article> articleList = (List<Article>) SessionApp.getAttribute("panier");
            if (articleList.isEmpty()) {
        %>
        <tr>
            <td>Votre panier est vide</td>
        </tr>
        <% } else { %>
        <% for (Article article : articleList) { %>
        <tr>
            <td><%= article.getDesignation() %></td>
            <td><%= article.getCategory_id() %></td>
            <td>
                <form action="/Panier" method="post">
                    <input type="number" name="<%= article.getId() %>_quantity" value="1" min="1" max="<%= article.getStock() %>">
                </form>
            </td>
            <td><%= article.getPrix() %></td>
        </tr>
        <% } %>
        <% } %>
        </tbody>
    </table>
    <div class="actions-container">
        <div class="actions">
            <a class="custom-link" href="home.jsp">Commander un autre disque</a>
            <% if (!articleList.isEmpty()) { %>
            <form action="" method="post">
=======
    <form action="Panier" method="post">
        <table>
            <thead>
            <tr>
                <th>Designation</th>
                <th>Catégorie</th>
                <th>Quantité</th>
                <th>Prix</th>
            </tr>
            </thead>
            <tbody>
            <%
                HttpSession SessionApp = request.getSession(false);
                List<Article> articleList = (List<Article>) SessionApp.getAttribute("panier");
                if (articleList.isEmpty()) { %>
            <tr>
                <td>Votre panier est vide</td>
            </tr>
            <% } else {
                for (Article article : articleList) { %>
            <tr>
                <td><%= article.getDesignation() %></td>
                <td><%= article.getCategory_id() %></td>
                <td>
                    <input type="number" name="quantity_<%= article.getId() %>" value="1" min="1" max="<%= article.getStock() %>">
                </td>
                <td><%= article.getPrix() %></td>
            </tr>
            <% }
            } %>
            </tbody>
        </table>
        <div class="actions-container">
            <div class="actions">
                <a class="custom-link" href="home.jsp">Commander un autre disque</a>
                <% if (!articleList.isEmpty()) { %>
>>>>>>> c7b6366e0278e6f613c3ece9b8a7e2fd45d8bc25
                <button type="submit">Enregistrer votre commande</button>
                <% } %>
            </div>
        </div>
    </form>
</div>
</body>
</html>
