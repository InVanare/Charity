<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html lang="pl">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta http-equiv="X-UA-Compatible" content="ie=edge" />
    <title>Document</title>
    <link rel="stylesheet" href="<c:url value="resources/css/style.css"/>" />
</head>
<body>
<header>
    <nav class="container container--70">
        <%@ include file="header.jsp" %>
    </nav>
</header>

<section class="login-page">
    <sec:authorize access="isAuthenticated()">
        <h2>Jesteś już zalogowany.</h2>
    </sec:authorize>
    <sec:authorize access="!isAuthenticated()">
    <h2>Panel logowania</h2>
    <h3 id="error" class="error-inactive"></h3>
    <form method="post">
        <div class="form-group">
            <input type="text" name="username" placeholder="Nazwa użytkownika" />
        </div>
        <div class="form-group">
            <input type="password" name="password" placeholder="Hasło" />
        </div>

        <div class="form-group form-group--buttons">
            <button class="btn" id="login" type="submit">Zaloguj się</button>
            <a href="/registration" class="btn btn--without-border">Załóż konto</a>
        </div>
    </form>
    </sec:authorize>
</section>

<%@ include file="footer.jsp" %>
<%--<script src="<c:url value="resources/js/registration.js"/>"></script>--%>
</body>
</html>