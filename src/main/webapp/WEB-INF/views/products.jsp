<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<body>
<h2>Liste des produits</h2>
<table border="1">
    <tr>
        <th>ID</th>
        <th>Nom</th>
        <th>Prix</th>
        <th>Catégorie</th>
    </tr>
    <c:forEach var="p" items="${products}">
        <tr>
            <td>${p.id}</td>
            <td>${p.name}</td>
            <td>${p.price}</td>
            <td>${p.category.name}</td>
        </tr>
    </c:forEach>
</table>
<a href="products/add">Ajouter un produit</a>
</body>
</html>
