<%@include file="header.jsp" %>
            <main>
               <h1 class="text-center my-5">Profil de ${pseudo}</h1>
                <div class="card  col-md-5 mx-auto border border-info">
                    <ul class="list-group list-group-flush">
                        <li class="list-group-item">Pseudo : <%=request.getAttribute("pseudo")%></li>
                        <li class="list-group-item">Nom : <%=request.getAttribute("nom")%></li>
                        <li class="list-group-item">Prénom : <%=request.getAttribute("prenom")%></li>
                        <li class="list-group-item">Email : <%=request.getAttribute("email")%></li>
                        <li class="list-group-item">Téléphone : <%=request.getAttribute("telephone")%></li>
                        <li class="list-group-item">Rue : <%=request.getAttribute("rue")%> </li>
                        <li class="list-group-item">Code postal : <%=request.getAttribute("code_postal")%></li>
                        <li class="list-group-item">Ville : <%=request.getAttribute("ville")%></li>
                        
                     <c:if test="${!empty sessionScope.pseudo and pseudo eq sessionScope.pseudo}">
                         <li class="list-group-item">Crédit : <%=request.getAttribute("credit")%></li>
                         </c:if>
                        
                    </ul>
                    
                </div>
                <div class="text-center">
                <c:if test="${!empty sessionScope.pseudo and pseudo eq sessionScope.pseudo}">
 					<a href="<%=request.getContextPath()%>/modifierProfil" class="btn btn-dark my-2">Modifier</a>
 			    </c:if>
 			    	<a href="<%=request.getContextPath()%>/Accueil" class="btn btn-outline-info my-2">Retour</a>
 				</div>	
            </main>
        </body>
    </html>