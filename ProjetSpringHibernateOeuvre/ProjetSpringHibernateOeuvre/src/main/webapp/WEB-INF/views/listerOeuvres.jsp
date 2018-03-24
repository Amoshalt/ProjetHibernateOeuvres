<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@include file="./header.jsp" %>

<body>

<div class="jumbotron text-center">
    <h1>Listing des oeuvres</h1>
</div>

<div class="container">
    <a class="btn btn-secondary" href="index.htm" role="button"><span class="glyphicon glyphicon-chevron-left"></span> Retour accueil</a>
    <h2>Tableau des oeuvres</h2>
    <table class="table table-striped">
        <thead>
        <tr>
            <TH>Numéro</TH>
            <TH>Titre</TH>
            <TH>Prix</TH>
            <TH>Proprietaire</TH>
            <TH>Actions</TH>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${mesOeuvres}" var="item">
            <c:set var="idOeuvre">${item.idOeuvrevente}</c:set>
            <c:set var="oeuvresReservees">${oeuvresReservees}</c:set>
            <tr>
                <td>${item.idOeuvrevente}</td>
                <td>${item.titreOeuvrevente}</td>
                <td>${item.prixOeuvrevente}</td>
                <td>${item.proprietaire.nomProprietaire} ${item.proprietaire.prenomProprietaire}</td>
                <td>
                    <c:choose>
                        <c:when test="${fn:contains(oeuvresReservees, idOeuvre)}">
                            <a href="modifierOeuvre.htm">
                                <span class="glyphicon glyphicon-pencil"></span>
                            </a>
                        </c:when>
                        <c:otherwise>
                            <a href="modifierOeuvre.htm?idOeuvre=${idOeuvre}">
                                <span class="glyphicon glyphicon-pencil"></span>
                            </a>
                            <a href="#">
                                <span class="glyphicon glyphicon-check"></span>
                            </a>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>