<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="Model.Article" %>
<%@ page import="Model.Iplementation.ArticlesDaoimpl" %>

<%
    // Récupération des articles depuis la base de données
    System.out.println("avant");
    ArticlesDaoimpl articlesDao = new ArticlesDaoimpl();
    List<Article> articles = articlesDao.getAllArticle();
    System.out.println("les articles :");
    System.out.println(articles);
    System.out.println("apres");
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Catalogue</title>
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

        h1, h2 {
            color: #333;
        }

        select {
            padding: 10px;
            font-size: 16px;
            margin-bottom: 20px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }

        th, td {
            padding: 12px 15px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }

        th {
            background-color: #f2f2f2;
        }

        td img {
            max-width: 100px;
        }

        .btn {
            padding: 10px 20px;
            font-size: 16px;
            text-align: center;
            text-decoration: none;
            color: #fff;
            background-color: #007bff;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }

        .btn:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
<div class="container">
    <h1>Catalogue</h1>
    <select>
        <option value="all">Toutes les catégories</option>
        <option value="all">Électronique</option>
        <option value="all">Maison et jardin</option>
        <option value="all">Sport et loisirs</option>
        <option value="all"> Livres</option>
    </select>
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
            <td><a href="Panier?id=<%= article.getId() %>" class="btn">Ajouter au panier</a></td>
        </tr>
        <% } %>
        </tbody>
    </table>
</div>
</body>
</html>
