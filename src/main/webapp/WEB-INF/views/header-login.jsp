<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<ul class="nav--actions">
    <li class="logged-user">
        Witaj Agata
        <ul class="dropdown">
            <li><a href="#">Profil</a></li>
            <li><a href="#">Moje zbiórki</a></li>
            <li><a href="#">Wyloguj</a></li>
        </ul>
    </li>
</ul>

<ul>
    <li><a href="/" class="btn btn--without-border active">Start</a></li>
    <li><a href="/#steps" class="btn btn--without-border">O co chodzi?</a></li>
    <li><a href="/#about-us" class="btn btn--without-border">O nas</a></li>
    <li><a href="/#organizations" class="btn btn--without-border">Fundacje i organizacje</a></li>
    <li><a href="#contact" class="btn btn--without-border">Kontakt</a></li>
</ul>