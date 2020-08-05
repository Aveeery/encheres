<!DOCTYPE html>
<html lang="en">
<%@include file="header.jsp" %>
<body>

<H1 class="text-center mt-4">Vendre un article</H1>
 <%@include file="erreur.jsp" %>
<form method="post" action="vendreArticle">
    <div class="mx-4">
        <input type="text" id="nomArticle" class="form-control my-4 " name="nomArticle"  placeholder="Nom de l'article" required>
        <textarea class="form-control my-4" name="descriptionArticle" id="descriptionArticle" rows="3"></textarea>
        

        <select class="col-sm-3 col-form-label" name="categorie" id="categorie">
            <option value="1">Informatique</option>
            <option value="2" >Ameublement</option>
            <option value="3" >Vêtements</option>
            <option value="4" >Sports et loisirs</option>
        </select>

        <div class="my-4">
            <input type="file"
                   id="photoArticle" name="photoArticle"
                   accept="image/png, image/jpeg">
        </div>

        <div class="my-4">
            <label>Mise à prix : </label>
            <input name="prixInitial" type="number" step="10" placeholder="Votre prix">
        </div>

        <div>
            <label>Début de l'enchère :</label>
            <input id="debutEnchere" name="debutEnchere" type="datetime-local">
       
        </div>

        <div>
            <label>Fin de l'enchère :</label>
            <input id="finEnchere" name="finEnchere" type="datetime-local">
            
        </div>


        <div class="display border my-4">
            <h4>Retrait</h4>
            <input name="rueRetrait" id="rueRetrait" class="d-block my-2" type="text" placeholder="Votre adresse">
            <input name="codePostalRetrait" id="codePostalRetrait" class="d-block my-2" type="text" placeholder="Code postal">
            <input name="villeRetrait" id="villeRetrait" class="d-block my-2" type="text" placeholder="Ville">
        </div>
        
        

        <button type="submit" class="btn btn-info my-2">Enregistrer</button>
        <a href="<%=request.getContextPath()%>/" class="btn btn-outline-info my-2">Annuler</a>
        


    </div>
</form>

</body>
</html>