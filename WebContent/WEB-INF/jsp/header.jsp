<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

    <!DOCTYPE html>
    <html>
        <head>
            <meta charset="UTF-8">
            <link href="https://fonts.googleapis.com/css2?family=Fira+Sans+Condensed&display=swap" rel="stylesheet">
            <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
            <title>Accueil</title>
        </head>
        
        <body style="font-family: 'Fira Sans Condensed', sans-serif !important;">
            <header>
                <!-- Header navbar --> 
                <div class="navbar navbar-dark bg-info">
                    <div class="container d-flex justify-content-between">
                        <a href="#" class="navbar-brand d-flex align-items-center">
                            <strong>Eni-Enchères</strong>
                        </a>
                         <%
                        boolean connected = false;
                        if(session.getAttribute("connected")!=null){
                        	connected = (boolean)session.getAttribute("connected");
                        }
                        %>
                        
                        <c:choose>
                        	<c:when test="${!empty sessionScope.pseudo}">                       
                       			<div>
                            <a href="Enchères" class="btn btn-outline-light my-2">Enchères</a>
                            <a href="<%=request.getContextPath()%>/vendreArticle" class="btn btn-outline-light my-2">Vendre un article</a>
                            <a href="<%=request.getContextPath()%>/visiteProfil?pseudo=${sessionScope.pseudo}" class="btn btn-outline-light my-2">Mon profil</a>
                           	<a href="<%=request.getContextPath()%>/SeDeconnecter" class="btn btn-dark my-2">Se déconnecter</a> 
                        </div>
                        
                        </c:when>
                    	<c:otherwise>
                        <div>
                            <a href="<%=request.getContextPath()%>/SeConnecter" class="btn btn-dark my-2">Se connecter</a>
                            <a href="Sinscrire" class="btn btn-outline-light my-2">S'inscrire</a>
                        </div>
                        </c:otherwise>
                    	</c:choose>
                        
                        
                    </div>
                </div>
            </header>