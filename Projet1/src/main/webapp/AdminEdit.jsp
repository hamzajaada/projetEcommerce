<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"  %>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"  %>
<sql:setDataSource var="dataSource" driver="com.mysql.cj.jdbc.Driver"
                   url="jdbc:mysql://localhost:3306/ecomercejee" user="root" password=""
/>
<html>
<head>
    <title>Editer un Article</title>
</head>
<body>
<h1>Édition de l'article</h1>
<% int idArticle = Integer.parseInt(request.getParameter("idArticle")); %>
<sql:query var="result" dataSource="${dataSource}">
    SELECT * FROM articles WHERE id = ?
    <sql:param value="<%= idArticle %>" />
</sql:query>

<c:if test="${not empty result.rows}">
        <form action="miseajourArticle.jsp" method="post">
            <c:forEach var="row" items="${result.rows}">
            <input type="hidden" name="idArticle" value="${row.id}" />
            <label for="newDesignation">Nouvelle désignation:</label>
            <input type="text" id="newDesignation" name="newDesignation" value="${row.designation}" /><br/>
            <label for="newPrix">Nouveau prix:</label>
            <input type="text" id="newPrix" name="newPrix" value="${row.prix}" /><br/>
            <label for="newStock">Nouveau stock:</label>
            <input type="text" id="newStock" name="newStock" value="${row.stock}" /><br/>
            <label for="newIdCat">Nouvel ID Catégorie:</label>
            <input type="text" id="newIdCat" name="newIdCat" value="${row.category_id}" /><br/>
            <label for="newPhoto">Nouvelle photo:</label>
            <input type="text" id="newPhoto" name="newPhoto" value="${row.photo}" /><br/>
            <input type="submit" value="Mettre à jour l'article"/>
            </c:forEach>
        </form><br/><br/>
</c:if>
<p><a href="homeAdmin.jsp">Retour au catalogue</a></p>
</body>
</html>
