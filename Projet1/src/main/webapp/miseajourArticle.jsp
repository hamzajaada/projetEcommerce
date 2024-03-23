<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<sql:setDataSource var="dataSource" driver="com.mysql.cj.jdbc.Driver"
                   url="jdbc:mysql://localhost:3306/ecomercejee" user="root" password=""/>

<html>
<head>
    <title>Modification</title>
</head>
<body>
<h1>Édition d'article</h1>

<sql:update dataSource="${dataSource}">
    UPDATE articles SET designation = ?, prix = ?, stock = ?, category_id = ?, photo = ? WHERE id = ?;
    <sql:param value="${param.newDesignation}" />
    <sql:param value="${param.newPrix}" />
    <sql:param value="${param.newStock}" />
    <sql:param value="${param.newIdCat}" />
    <sql:param value="${param.newPhoto}" />
    <sql:param value="${param.idArticle}" />
</sql:update>

<h1>Produit mis à jour avec succès.</h1><br><br><br><br>
<p><a href="homeAdmin.jsp">Retour au catalogue</a></p>
</body>
</html>
