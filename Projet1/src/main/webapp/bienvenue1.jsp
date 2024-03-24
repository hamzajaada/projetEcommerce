<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Bienvenue Monsieur User</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f5f5f5;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        .container {
            text-align: center;
        }

        h1 {
            color: #333;
        }

        .button {
            display: inline-block;
            padding: 10px 20px;
            margin: 10px;
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

        .button:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
<div class="container">
    <%
        HttpSession SessionApp = request.getSession(false);
        String nom = (String) SessionApp.getAttribute("nom");
    %>
    <h1>Bonjour Monsieur <%= nom %></h1>
    <a href="home.jsp" class="button">Consulter le catalogue</a>
    <a href="./CommandesClient" class="button">Suivre vos commandes</a>
    <a href="panier.jsp" class="button">Visualiser votre panier</a>
</div>
</body>
</html>