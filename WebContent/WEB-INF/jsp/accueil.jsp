<%@include file="header.jsp" %>
<main role="main">
	<!-- TITRE --> 
	<div class="text-center my-5"><h1>Liste des enchères</h1></div>
	<!-- TITRE --> 

             
	<!-- Recherche de l'article et définition de la catégorie d'objet --> 
	<div class="container">
		<form method="post" action="<%=request.getContextPath()%>/Accueil">				
			<input id="motCle" name = "motCle" class="col-sm-6 col-form-label" type="text" placeholder="Le nom de l'article contient..." aria-label="Search">
	
			<label class="col-sm-2 col-form-label " for="categorie" >Catégorie : </label>
			<select class="col-sm-3 col-form-label class="mb-4" id="idCategorie" name="idCategorie">
	
				<option value="0">Toutes les catégories</option>	
				<option value="1">Informatique</option>
				<option value="2">Ameublement</option>
				<option value="3">Vêtements</option>
				<option value="4">Sports et loisirs</option>
			</select>                          
	<c:if test="${!empty sessionScope.pseudo}">  
		<!-- Définir les articles à afficher selon les résultats du formulaire -->
		
		<div class="mt-4">
				<label class="custom-control-label" for="achats">Mes achats</label>
				<input type="radio" id="achats" name="achats_vente" value="achat" class="custom-control-input mt-3">
					<ul>
						<li>
							<input type="checkbox" value ="true" id="encheresouvertes" name="encheresouvertes" class="form-check-input">    
							<label class="form-check-label" for="encheresouvertes">enchères ouvertes</label>
							                  
                        </li>
                        <li> 
                        	<input type="checkbox"  id="achatsencours" value ="true"  name="achatsencours" class="form-check-input">
                            <label class="form-check-label" for="achatsencours">mes enchères en cours</label>
                        </li>
                        <li> 
                        	<input type="checkbox" id="achatsremportes" value ="true" name="achatsremportes" class="form-check-input">
                            <label class="form-check-label" for="achatsremportes">mes enchères remportées</label>
                       	</li>
                     </ul>
				<label class="custom-control-label" for="customRadioInline2">Mes ventes</label>	
				<input type="radio" id="customRadioInline2" name="achats_vente" value="vente" class="custom-control-input">
                      <ul>
                      	
                          <li> 
                          		<input type="checkbox" id="ventesencours" value ="true" name="ventesencours" class="form-check-input">
                                <label class="form-check-label" for="ventesencours">mes ventes en cours</label>
                          </li>
                          <li> <input type="checkbox" id="ventesnondebutees"  value ="true" name="ventesnondebutees" class="form-check-input">
                                        <label class="form-check-label" for="ventesnondebutees">ventes non débutées</label></li>
                                    <li> <input type="checkbox" id="ventesterminees" value ="true"  name="ventesterminees" class="form-check-input">
                                        <label class="form-check-label" for="ventesterminees">ventes terminées</label></li>
                                </ul>
	</div>
                        <!-- Définir les articles à afficher selon les résultats du formulaire -->
	</c:if>
	        <button type="submit" class="btn btn-info mb-2"> Rechercher </button>  
   		</form>
	</div>
 <!-- Recherche de l'article et définition de la catégorie d'objet -->  
                 
 <!-- Affichage des articles -->                                      
              
	<c:forEach items="${listeArticles}" var="article">
	<div class=" col-md-9 mx-auto my-5">
	    <div class="card">
	<div class="card-body">  
		   <c:choose>
                       <c:when test="${!empty sessionScope.pseudo}">                       
    	<p class="card-text"><a href="<%=request.getContextPath()%>/enchere?nomArticle=${article.nomArticle}">${article.nomArticle}</a></p> 
                        </c:when>
                    	<c:otherwise>
                       <h5 class="card-title"> Nom article : ${article.nomArticle}</h5>
                        </c:otherwise>
                    	</c:choose>
		<p class="card-text">Prix : ${article.prixVente}</p>

                     
	    <p class="card-text">Fin de l'enchère : ${article.finEnchere}</p>
	    <p class="card-text">Vendeur : <a href="<%=request.getContextPath()%>/visiteProfil?pseudo=${article.pseudoVendeur}">${article.pseudoVendeur}</a></p>    
	  </div>
	  </div>
	</div>
	</c:forEach>
     
  	<p class="text-center">${erreur}</p>

            </main>
<%@include file="footer.jsp" %>