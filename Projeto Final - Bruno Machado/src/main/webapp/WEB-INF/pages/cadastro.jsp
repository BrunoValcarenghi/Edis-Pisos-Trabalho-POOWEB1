<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>

<html>
<head>

    <title>Cadastro</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">

</head>
<body>

<div class = "card-usuario">

    <div class = "div-form">
        <h2>ACESSAR</h2>
        <form action = "cadastro" method = "post">

            <label>Nome:</label><br>
            <input type="text" name="nome" maxlength="50" required><br>

            <label>Email:</label><br>
            <input type="email" name="email" maxlength="100" required><br>

            <label>Senha:</label><br>
            <input type="password" name="senha" maxlength="16" required><br>

            <button type="submit">CADASTRAR</button><br>
            <a href="index.jsp">JÁ TENHO CONTA</a><br>

        </form>

        <c:if test="${not empty erro}">
            <p style="color:red">${erro}</p>
        </c:if>

    </div>

</div>

</body>
</html>
