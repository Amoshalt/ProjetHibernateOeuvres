<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@include file="./header.jsp" %>
<SCRIPT language="Javascript" type="text/javascript"></SCRIPT>
<script type="text/javascript" src="js/foncControle.js"></script>


<body>
<div class="jumbotron text-center">
    <h1>Ajout d'un Propriétaire</h1>
</div>

<div class="container">
    <FORM  name='identification' method="post" action="insererProprietaire.htm" onsubmit="return teste()">
        <div class="form-group">
            <label for="numero">Numero :</label>
            OeuvreventeId :${idOeuvrevente}fin
            <input type="number" class="form-control" id="numero" placeholder="${idOeuvrevente}" name="numero">
        </div>
        <div class="form-group">
            <label for="titreOeuvre">Titre:</label>
            <input type="text" class="form-control" id="titreOeuvre" placeholder="${titreOeuvrevente}" name="titreOeuvre">
        </div>
        <div class="form-group">
            <label for="prix">Prix :</label>
            <input type="text" class="form-control" id="prix" placeholder="${prixOeuvrevente}" name="prix">
        </div>
        <div class="form-group">
            <label for="proprietaire">Proprietaire :</label>
            <input type="text" class="form-control" id="proprietaire" placeholder="${proprietaire.nomProprietaire} ${proprietaire.prenomProprietaire} " name="prix">
        </div>

        <button type="submit"class="btn btn-default">Ajouter</button>
    </FORM>
</DIV>
</body>
</html>