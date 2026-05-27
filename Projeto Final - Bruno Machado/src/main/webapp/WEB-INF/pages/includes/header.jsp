<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>

<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">

<div class="header">

    <div class = "header-logo">
        <img src="${pageContext.request.contextPath}/img/icon.png" alt="logo">
        <h1>EDIS Pisos</h1>
    </div>

    <div class = "header-links">
        <a href = "catalogo">Catálogo</a>
        <a href = "avaliacao">Avaliações</a>
        <a href = "favoritos">Favoritos</a>
        <a href = "logout">Sair</a>
    </div>

</div>
