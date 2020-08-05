
<div class="text-center my-5"><h1>Liste des enchères</h1></div>
 <%
boolean connected = false;
String pseudo = "";
if (session.getAttribute("connected")!=null) {
connected = (boolean)session.getAttribute("connected");
pseudo = (String)session.getAttribute("pseudo");
}

if (connected) {

%>	
<h2 style="text-align : center">Bonjour <%=pseudo %> !</h2>
<% } else { %> Vous n'êtes pas connecté !<% } %>