<%@include file="header.jsp" %>
            <main>
               <h1 class="text-center my-5">Détail de la vente</h1>
                <div class="card  col-md-5 mx-auto border border-info">
                <h2>${article.nomArticle}</h2>
                    <ul class="list-group list-group-flush">
                      <li class="list-group-item">Description : ${article.description}</li>
  
                      <li class="list-group-item">Meilleure offre ${article.prixVente} par Bob</li>
                      <li class="list-group-item">Mise à prix : ${article.prixInitial}</li>
                      <li class="list-group-item">Fin de l'enchère le :  ${article.dateFinEnchere}</li> 
                      <li class="list-group-item">Adresse de retrait : ${article.rue} ${article.ville} ${article.codePostal}</li>
                      <li class="list-group-item">Vendeur : ${article.pseudo}</li>
                      <div class="my-4">
                      <form method="post" action="${request.getContextPath()}/enchere"> 
                      	<label>Ma proposition : </label>
          				  <input name="offre" type="number" step="10" placeholder="${article.prixVente}">
          				  <input type="submit">
        				</form>
    				</div>
          				<a href="<%=request.getContextPath()%>/Accueil">Retour</a>
                    </ul>
                </div>       
            </main>
        </body>
    </html>