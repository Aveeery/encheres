<%@page import="fr.eni.javaee.eniencheres.messages.LecteurMessage"%>
<%@page import="java.util.List"%><!-- Lecture code erreur -->


<%List<Integer> listeCodesErreur = (List<Integer>)request.getAttribute("listeCodesErreur");
if(listeCodesErreur!=null){%>
	<p style="color:red;">Erreur :</p>
	<%for(int codeErreur:listeCodesErreur){%>
		<p><%=LecteurMessage.getMessageErreur(codeErreur)%></p><%	
	}
}%>