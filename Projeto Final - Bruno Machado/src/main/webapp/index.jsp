<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>

<html>
<head>

    <title>Login</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">

</head>
<body>


<div class = "card-usuario">


    <div class = "div-form">

        <h2>ACESSAR</h2>
        <form action = "login" method = "post">

            <label>Email:</label><br>
            <input type="email" name="email" required><br>

            <label>Senha:</label><br>
            <input type="password" name="senha" required><br>

            <button type="submit">ENTRAR</button><br>
            <a href="cadastro">CRIAR CONTA</a>

        </form>

        <c:if test="${not empty erro}">
            <p style="color:red">${erro}</p>
        </c:if>

    </div>

</div>

</body>
</html>
