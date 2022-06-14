<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

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
        <%@ include file="header-without-login.jsp" %>
    </nav>
</header>

<section class="login-page">
    <h2>Załóż konto</h2>
    <h3 id="error" class="error-inactive"></h3>
    <%--@elvariable id="user" type="pl.coderslab.charity.repository.entity.User"--%>
    <form:form method="post" modelAttribute="user">
        <div class="form-group">
            <input type="text" name="name" placeholder="Nazwa użytkownika" />
        </div>
        <div class="form-group">
            <input type="email" name="mail" placeholder="Email" />
        </div>
        <div class="form-group">
            <input type="password" name="pass" placeholder="Hasło" />
        </div>
        <div class="form-group">
            <input type="password" name="pass2" placeholder="Powtórz hasło" />
        </div>

        <div class="form-group form-group--buttons">
            <a href="/login" class="btn btn--without-border">Zaloguj się</a>
            <button class="btn" id="registration" type="button">Załóż konto</button>
        </div>
    </form:form>
</section>

<%@ include file="footer.jsp" %>
<script src="<c:url value="resources/js/registration.js"/>"></script>
</body>
</html>