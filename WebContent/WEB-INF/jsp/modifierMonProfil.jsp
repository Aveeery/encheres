<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="https://fonts.googleapis.com/css2?family=Fira+Sans+Condensed&display=swap" rel="stylesheet">
<!------ Include the above in your HEAD tag ---------->
<title>Inscription</title>
</head>
 <body style="font-family: 'Fira Sans Condensed', sans-serif !important;">
	<div class="container register-form">
       		<div class="form">
                <div class="note">
                    <h1 class="my-3 text-center">Mon profil</h1>
                </div>
					
				<form method="post" action="<%=request.getContextPath()%>/modifierProfil">
                <div class="form-content">
                    <div class="row">
 <!------ Colonnes de gauche ---------->                      
                        <div class="col-md-6">
                          <div class="form-group">
                                <input type="text" class="form-control" placeholder="Prénom" name="pseudo"/>
                            </div>
                            <div class="form-group">
                                <input type="text" class="form-control" placeholder="Prénom" name="prenom"/>
                            </div>
                            <div class="form-group">
                                <input type="text" class="form-control" placeholder="Téléphone" name="telephone"/>
                            </div>
                            <div class="form-group">
                                <input type="text" class="form-control" placeholder="Code Postal" name="codepostal"/>
                            </div>
                            <div class="form-group">
                                <input type="password" class="form-control" placeholder="Mot de passe" name="password"/>
                            </div>
                        </div>
                        
<!------ Colonnes de droite ---------->
                        <div class="col-md-6">
                            <div class="form-group">
                                <input type="text" class="form-control" placeholder="Nom" name="nom"/>
                            </div>
                            <div class="form-group">
                                <input type="email" class="form-control" placeholder="Email" name="email"/>
                            </div>
                             <div class="form-group">
                                <input type="text" class="form-control" placeholder="Rue" name="rue"/>
                            </div>
                             <div class="form-group">
                                <input type="text" class="form-control" placeholder="Ville" name="ville"/>
                            </div>
                             <div class="form-group">
                                <input type="password" class="form-control" placeholder="Confirmer le mot de passe" name="passwordVerif"/>
                            </div>
                        </div>
                    </div>
                    <%@include file="erreur.jsp" %>
                    <div class="text-center">
                        <button type="submit" class="btn btn-info my-2">Valider les modifications</button>
                        <a href="<%=request.getContextPath()%>/accueilConnecte" class="btn btn-outline-info my-2">Annuler</a>
                        <a href="<%=request.getContextPath()%>/supprimerCompte" class="btn btn-danger my-3">Supprimer mon compte</a>
                        
                    </div> 
                </div>
              	</form>
            </div>
        </div>
</body>
</html>