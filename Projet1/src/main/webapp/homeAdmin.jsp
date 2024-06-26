<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="Model.Article" %>
<%@ page import="Model.Iplementation.ArticlesDaoimpl" %>

<%
    ArticlesDaoimpl articlesDao = new ArticlesDaoimpl();
    List<Article> articles = articlesDao.getAllArticle();
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Liste des articles "Admin"</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f7f7f7;
        }

        .container {
            max-width: 800px;
            margin: 20px auto;
            padding: 20px;
            background-color: #fff;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        h2 {
            color: #333;
        }

        ul {
            list-style-type: none;
            padding: 0;
            margin-top: 20px;
        }

        li {
            margin-bottom: 20px;
            padding: 20px;
            background-color: #fff;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            transition: all 0.3s ease;
        }

        li:hover {
            transform: translateY(-5px);
            box-shadow: 0 0 20px rgba(0, 0, 0, 0.2);
        }

        li h3 {
            margin: 0;
            color: #333;
        }

        li p {
            margin: 0;
            color: #666;
        }
    </style>
</head>
<body>
<div class="container">
    <h2>Liste des articles</h2>
    <table>
        <thead>
        <tr>
            <th>Référence</th>
            <th>Titre</th>
            <th>Prix</th>
            <th>Action</th>
        </tr>
        </thead>
        <tbody>
        <% for (Article article : articles) { %>
        <tr>
            <td>
                <form action="/Projet1_war_exploded/getArticle" method="post">
                    <input type="hidden" name="articleId" value="<%= article.getId() %>">
                    <button type="submit"><%= article.getId() %></button>
                </form>
            </td>
            <td><%= article.getDesignation() %></td>
            <td><%= article.getPrix() %></td>
            <td>
                <% int idArticle = article.getId(); %>
                <form method="post" action ="./AdminEdit.jsp" >
                <input type="hidden" name="idArticle" value="<%= idArticle %>" />
                <input type="submit" value="Editer"/>
                </form>
                <form method="post" action ="./AdminSupprimer.jsp" >
                    <input type="hidden" name="idArticle" value="<%= idArticle %>" />
                    <input type="submit" value="supprimer"/>
                </form>
            </td>
        </tr>
        <% } %>
        </tbody>
    </table>
    <a href="AdminAjouter.jsp">Ajouter Un Produit</a>
    <a href="AdminCommandes.jsp">Consulter les Commandes</a>
</div>
</body>
</html>