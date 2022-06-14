<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<ul class="nav--actions">
    <sec:authorize access="isAuthenticated()">
        <li class="logged-user">
            Witaj <sec:authorize access="isAuthenticated()"><sec:authentication property="principal.username"/></sec:authorize>
            <ul class="dropdown">
                <li><a href="<c:url value="/dashboard"/>">Panel</a></li>
                <li><a href="#">Profil</a></li>
                <li><a href="#">Moje zbiórki</a></li>
                <li><a href="<c:url value="/logout"/>">Wyloguj</a></li>
            </ul>
        </li>
    </sec:authorize>
    <sec:authorize access="!isAuthenticated()">
        <li><a href="/login" class="btn btn--small btn--without-border">Zaloguj</a></li>
        <li><a href="/registration" class="btn btn--small btn--highlighted">Załóż konto</a></li>
    </sec:authorize>
</ul>

<ul>
    <li><a href="/" class="btn btn--without-border active">Start</a></li>
    <li><a href="/#steps" class="btn btn--without-border">O co chodzi?</a></li>
    <li><a href="/#about-us" class="btn btn--without-border">O nas</a></li>
    <li><a href="/#organizations" class="btn btn--without-border">Fundacje i organizacje</a></li>
    <li><a href="#contact" class="btn btn--without-border">Kontakt</a></li>
</ul>
