<%@ page import="Model.Article" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Détails de l'article</title>
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

        p {
            margin-bottom: 10px;
        }

        /* Styling for article details */
        .article-details {
            margin-top: 20px;
        }

        .article-details h3 {
            margin-top: 0;
            color: #333;
        }

        .article-details p {
            color: #666;
        }

        .article-details p:first-child {
            font-weight: bold;
        }

        /* Button styling */
        .button {
            display: inline-block;
            padding: 10px 20px;
            background-color: #007bff;
            color: #fff;
            text-decoration: none;
            border-radius: 5px;
            transition: background-color 0.3s ease;
        }

        .button:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
<% Article article = (Article) request.getAttribute("article"); %>
<div class="container">
    <h2>Détails de l'article</h2>
    <div class="article-details">
        <p>ID: <%= article.getId() %></p>
        <p>Désignation: <%= article.getDesignation() %></p>
        <p>Prix: <%= article.getPrix() %></p>
        <p>Stock: <%= article.getStock() %></p>
        <p>Catégorie ID: <%= article.getCategory_id() %></p>
        <p>Photo: <%= article.getPhoto() %></p>
    </div>
</div>
</body>
</html>
