<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"  %>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"  %>
<sql:setDataSource var="dataSource" driver="com.mysql.cj.jdbc.Driver"
                   url="jdbc:mysql://localhost:3306/ecomercejee" user="root" password=""
/>
<html>
    <title> Supprimer un Article</title>
<head>
    <title>Title</title>
</head>
<body>
<h1>Suppression de l'article</h1>
<% int idArticle = Integer.parseInt(request.getParameter("idArticle")); %>

<sql:update dataSource="${dataSource}">
    DELETE FROM articles WHERE id = ?
    <sql:param value="<%= idArticle %>" />
</sql:update>
<br><br>
<h1>L'article avec l'ID <%= idArticle %> a été supprimé avec succès.</h1>

<p><a href="homeAdmin.jsp">Retour au catalogue</a></p>
</body>
</html>
