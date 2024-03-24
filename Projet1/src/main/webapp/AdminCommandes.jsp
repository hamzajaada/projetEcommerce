<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"  %>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"  %>
<sql:setDataSource var="dataSource" driver="com.mysql.cj.jdbc.Driver"
                   url="jdbc:mysql://localhost:3306/ecomercejee" user="root" password=""
/>
<html>
<head>
    <title>Les Commandes Reçues</title>
</head>
<body>
<h1>Liste des Commandes reçues : </h1>
<sql:query var="result" dataSource="${dataSource}">
    SELECT * FROM commandes;
</sql:query>
<c:if test="${not empty result.rows}">
    <table >
        <tr>
            <th>ID Commande</th>
            <th>ID Client</th>
            <th>Date</th>
        </tr>
        <c:forEach var="row" items="${result.rows}">
            <tr>
                <td>${row.id}</td>
                <td>${row.client_id}</td>
                <td>${row.dateCommande}</td>
            </tr>
        </c:forEach>
    </table>
</c:if>

<c:if test="${empty result.rows}">
    <p>Aucune commande n'a été trouvée.</p>
</c:if>
<p><a href="homeAdmin.jsp">Retour au catalogue</a></p>
</body>
</html>
