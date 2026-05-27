<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>

<html>
<head>

    <title>Avaliações</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">

</head>
<body>

<jsp:include page="/WEB-INF/pages/includes/header.jsp"/>

<div class = "titulo"><h1>AVALIAÇÕES</h1></div>
<div class = "avaliacao">
    <div class="card-avaliacao">

        <form action="avaliacao" method="post">

            <H1>ESCREVA UMA AVALIAÇÃO</H1>

            <input type="text" name = "texto" maxlength="200" required><br>
            <input type = "text" name = "usuario_id" value="${user.id}" required hidden="hidden">

            <button type="submit">PUBLICAR</button>

        </form>

    </div>

        <c:if test="${not empty erro}">
            <p style="color:red">${erro}</p>
        </c:if>

    <c:forEach var = "i" items="${avaliacoes}" >

        <div class = "card-avaliacao">

            <p><b>${i.nome}</b></p>
            <p>${i.texto}</p>

        </div>

    </c:forEach>
</div>
</body>
</html>