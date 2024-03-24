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
<% int idArticle = Integer.parseInt(request.getParameter("idArticle")); %>
<% String newDesignation = request.getParameter("newDesignation"); %>
<% Double newPrix = Double.parseDouble(request.getParameter("newPrix")); %>
<% int newStock = Integer.parseInt(request.getParameter("newStock")); %>
<% int newIdcat = Integer.parseInt(request.getParameter("newIdCat")); %>
<% String newPhoto = request.getParameter("newPhoto"); %>
<sql:update dataSource="${dataSource}">
    UPDATE articles SET designation = ?, prix = ?, stock = ?, category_id = ?, photo = ? WHERE id = ?;
    <sql:param value="<%= newDesignation %>" />
    <sql:param value="<%= newPrix %>" />
    <sql:param value="<%= newStock %>" />
    <sql:param value="<%= newIdcat %>" />
    <sql:param value="<%= newPhoto %>" />
    <sql:param value="<%= idArticle %>" />
</sql:update>
<h1>Produit mis à jour avec succès.</h1><br><br><br><br>
<p><a href="homeAdmin.jsp">Retour au catalogue</a></p>
</body>
</html>
