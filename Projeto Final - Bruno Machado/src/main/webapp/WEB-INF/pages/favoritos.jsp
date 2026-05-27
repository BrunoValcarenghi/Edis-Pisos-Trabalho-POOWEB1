<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>

<html>
<head>

    <title>Favoritos</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">

</head>
<body>

<jsp:include page="/WEB-INF/pages/includes/header.jsp" />

<div class = "titulo"><h1>FAVORITOS</h1></div>

    <c:forEach var = "i" items="${favoritos}">

    <div class = "card-favorito">

        <p>
            <img src = "${pageContext.request.contextPath}/img/${i.modelo}.jpg" alt = "imagem-produto">
            <b>${i.marca}</b> - ${i.modelo}
        </p>


        <form action="removerfavorito" method="post">

            <input type = "text" name = "usuario_id" value="${i.usuario_id}" hidden="hidden">
            <input type = "text" name = "produto_id" value="${i.produto_id}" hidden="hidden">

            <button type="submit">🗑️</button>
        </form>

    </div>

</c:forEach>

</body>
</html>