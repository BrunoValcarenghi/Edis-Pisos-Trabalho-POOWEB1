<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>

<html>
<head>

    <title>Avaliações</title>
    <link rel="stylesheet" type="text/css" href="<c:url value='/css/style.css'/>">

</head>
<body>

<jsp:include page="/WEB-INF/pages/includes/header.jsp"/>

<div class = "titulo"><h1>AVALIAÇÕES</h1></div>
<div class = "avaliacao">
    <div class="card-avaliacao">

        <form action="avaliacao" method="post">

            <H1>ESCREVA UMA AVALIAÇÃO</H1>

            <textarea name="texto" maxlength="200" required></textarea><br>

            <button type="submit">PUBLICAR</button>

        </form>

    </div>

        <c:if test="${not empty erro}">
            <p style="color:red">${erro}</p>
        </c:if>

    <c:forEach var = "i" items="${avaliacoes}" >

        <div class = "card-avaliacao">

            <c:choose>
                <c:when test="${param.editarId == i.id && user.id == i.usuario_id}">

                    <form class="form-editar-avaliacao" action="editaravaliacao" method="post">

                            <div>
                                <input type="hidden" name="id" value="${i.id}">
                                <p><b>${i.nome}</b></p>
                                <textarea name="texto" maxlength="200" required>${i.texto}</textarea><br>
                            </div>

                            <div class="acoes-avaliacao">
                                <button class="botao-emoji" type="submit" title="Salvar avaliacao">💾</button>
                                <a class="botao-avaliacao botao-emoji" href="avaliacao" title="Cancelar edicao">↩️</a>
                            </div>

                    </form>

                </c:when>
                <c:otherwise>
                    <div class="texto-avaliacao">
                        <p><b>${i.nome}</b></p>
                        <p>${i.texto}</p>
                    </div>
                </c:otherwise>
            </c:choose>

            <c:if test="${user.id == i.usuario_id && param.editarId != i.id}">
                <div class="acoes-avaliacao">
                    <a class="botao-avaliacao botao-emoji" href="avaliacao?editarId=${i.id}" title="Editar avaliacao">✏️</a>
                    <form action="excluiravaliacao" method="post">
                        <input type="hidden" name="id" value="${i.id}">
                        <button class="botao-emoji" type="submit" title="Excluir avaliacao">🗑️</button>
                    </form>
                </div>
            </c:if>

        </div>

    </c:forEach>
</div>
</body>
</html>
