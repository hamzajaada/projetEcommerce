<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<sql:setDataSource var="dataSource" driver="com.mysql.cj.jdbc.Driver"
                   url="jdbc:mysql://localhost:3306/ecomercejee" user="root" password=""/>
<html>
<head>
    <title>Ajout Succes</title>
</head>
<body>
<h1>Addition d'article</h1>
    <% String newDesignation = request.getParameter("newDesignation"); %>
    <% Double newPrix = Double.parseDouble(request.getParameter("newPrix")); %>
    <% int newStock = Integer.parseInt(request.getParameter("newStock")); %>
    <% int newIdcat = Integer.parseInt(request.getParameter("newIdCat")); %>
    <% String newPhoto = request.getParameter("newPhoto"); %>
    <sql:update dataSource="${dataSource}">
        INSERT INTO articles (designation, prix, stock, category_id, photo) VALUES (?, ?, ?, ?, ?);
        <sql:param value="<%= newDesignation %>" />
        <sql:param value="<%= newPrix %>" />
        <sql:param value="<%= newStock %>" />
        <sql:param value="<%= newIdcat %>" />
        <sql:param value="<%= newPhoto %>" />
    </sql:update>
    <h1>le Produit a été Ajouté avec succès.</h1><br><br><br><br>
<p><a href="homeAdmin.jsp">Retour au catalogue</a></p>
</body>
</html>
