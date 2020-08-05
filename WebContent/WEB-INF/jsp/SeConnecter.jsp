<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <!doctype html>
    <html lang="fr">
        <head>
            <!-- Required meta tags -->
            <meta charset="utf-8">
            <!-- Bootstrap CSS -->
            <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
            <link href="https://fonts.googleapis.com/css2?family=Fira+Sans+Condensed&display=swap" rel="stylesheet">

            <title>Se connecter</title>
        </head>
        <body style="font-family: 'Fira Sans Condensed', sans-serif !important;">
        
            <!-- Formulaire de connexion -->

            <main class="login-form mt-5">
                <div class="container">
                    <div class="row justify-content-center">
                        <div class="col-md-8">
                            <div class="card">
                                <div class="card-header bg-info text-center text-light">Se connecter</div>
                                <div class="card-body">
                                    <form action="<%=request.getContextPath()%>/SeConnecter" method="post">
                                        <div class="form-group row">
                                            <label for="username" class="col-md-4 col-form-label text-md-right">Identifiant</label>
                                            <div class="col-md-6">
                                                <input type="text" id="username" class="form-control" name="username" required autofocus>
                                            </div>
                                        </div>

                                        <div class="form-group row">
                                            <label for="password" class="col-md-4 col-form-label text-md-right">Mot de passe</label>
                                            <div class="col-md-6">
                                                <input type="password" id="password" class="form-control" name="password" required>
                                            </div>
                                        </div>
                                        
										<%@include file="erreur.jsp" %>

                                        <div class="form-group row">
                                            <div class="col-md-6 offset-md-4">
                                                <div class="checkbox">
                                                    <label>
                                                        <input type="checkbox" name="remember"> Se souvenir de moi
                                                    </label>
                                                </div>
                                            </div>
                                        </div>


                                        <!-- Boutons connexion, inscription, et mot de passe oublié -->
                                        <div class="col-md-6 offset-md-4 ">
                                            <button type="submit" class="btn btn-info mb-2">
                                                Se connecter
                                            </button>    
                                             <a href="<%=request.getContextPath()%>/Sinscrire">Créer un compte</a>   
                                            <br>
                                            <a href="#" >
                                                Mot de passe oublié ?
                                            </a>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </main>
        </body>
    </html>