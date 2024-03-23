<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<sql:setDataSource var="dataSource" driver="com.mysql.cj.jdbc.Driver"
                   url="jdbc:mysql://localhost:3306/ecomercejee" user="root" password=""
/>
<html>
<head>
    <title>Editer un Article</title>
</head>
<body>
<h1>Édition de l'article</h1>

<c:if test="${param.idArticle}">
    <sql:query var="article" dataSource="${dataSource}">
        SELECT * FROM articles WHERE id = ?;
    </sql:query>
        <form action="miseajourArticle.jsp" method="post">
            <input type="hidden" name="idArticle" value="${param.idArticle}" />
            <label for="newDesignation">Nouvelle désignation:</label>
            <input type="text" id="newDesignation" name="newDesignation" value="${article.designationArticle}" /><br/>
            <label for="newPrix">Nouveau prix:</label>
            <input type="text" id="newPrix" name="newPrix" value="${article.prixArticle}" /><br/>
            <label for="newStock">Nouveau stock:</label>
            <input type="text" id="newStock" name="newStock" value="${article.stockArticle}" /><br/>
            <label for="newIdCat">Nouvel ID Catégorie:</label>
            <input type="text" id="newIdCat" name="newIdCat" value="${article.idCatArticle}" /><br/>
            <label for="newPhoto">Nouvelle photo:</label>
            <input type="text" id="newPhoto" name="newPhoto" value="${article.photoArticle}" /><br/>
            <input type="submit" value="Mettre à jour l'article"/>
        </form>
</c:if>
<p><a href="homeAdmin.jsp">Retour au catalogue</a></p>
</body>
</html>
