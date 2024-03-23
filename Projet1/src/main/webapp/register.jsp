<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Register</title>
    <link rel="stylesheet" type="text/css" href="Css/login.css">
</head>
<body>
<div class="container">
    <h2>Register</h2>
    <form action="" method="post">
        <div class="form-group">
            <label for="nom">Nom:</label>
            <input type="text" id="nom" name="nom" required>
        </div>
        <div class="form-group">
            <label for="prenom">Prenom:</label>
            <input type="text" id="prenom" name="prenom" required>
        </div>
        <div class="form-group">
            <label for="adresse">Adresse:</label>
            <input type="text" id="adresse" name="adresse" required>
        </div>
        <div class="form-group">
            <label for="codePostal">Code Postal:</label>
            <input type="text" id="codePostal" name="codePostal" required>
        </div>
        <div class="form-group">
            <label for="ville">Ville:</label>
            <input type="text" id="ville" name="ville" required>
        </div>
        <div class="form-group">
            <label for="tel">Tel:</label>
            <input type="text" id="tel" name="tel" required>
        </div>
        <div class="form-group">
            <label for="motPasse">Mot de Passe:</label>
            <input type="password" id="motPasse" name="motPasse" required>
        </div>
        <a href="login.jsp">Vous avez un compte ?</a>
        <button type="submit">Register</button>
    </form>
</div>
</body>
</html>

