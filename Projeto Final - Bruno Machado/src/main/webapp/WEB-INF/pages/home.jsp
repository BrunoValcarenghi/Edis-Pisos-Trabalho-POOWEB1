<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>

<html>
<head>

    <title>Catálogo</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">

</head>
<body>

<jsp:include page="/WEB-INF/pages/includes/header.jsp" />

<div class = "titulo"><h1>CATÁLOGO</h1></div>

<div class = "catalogo">

    <c:if test="${not empty erro}">
        <p style="color:red">${erro}</p>
    </c:if>

    <c:forEach var = "i" items = "${produtos}">

        <div class = "card-produto">

            <img src = "${pageContext.request.contextPath}/img/${i.modelo}.jpg" alt = "imagem-produto">

            <div class = "card-produto-texto">

                <p><b>${i.marca}</b> - ${i.modelo}</p>

                <form action="favoritos" method="post">
                    <input type="text" name = "id" value="${i.id}" hidden="hidden">
                    <button type="submit">❤️</button>
                </form>

            </div>

        </div>

    </c:forEach>

</div>

</body>
</html>