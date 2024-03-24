<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ajout d'article</title>
</head>
<body>
    <h1>Entrez votre produit</h1>
    <form action="ArticleAjoutee.jsp" method="post">
        <label for="newDesignation">Nouvelle désignation:  </label>
        <input type="text" id="newDesignation" name="newDesignation"/><br><br>
        <label for="newPrix">prix: </label>
        <input type="text" id="newPrix" name="newPrix"/><br><br>
        <label for="newStock">stock:  </label>
        <input type="text" id="newStock" name="newStock" /><br><br>
        <label for="newIdCat">ID Catégorie:  </label>
        <input type="text" id="newIdCat" name="newIdCat" /><br><br>
        <label for="newPhoto"> photo:  </label>
        <input type="text" id="newPhoto" name="newPhoto" /><br><br>
        <input type="submit" value="Ajouter"/>
    </form>
    <p><a href="homeAdmin.jsp">Retour au catalogue</a></p>
</body>
</html>
