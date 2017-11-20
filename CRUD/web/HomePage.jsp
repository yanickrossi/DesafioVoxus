<%-- 
    Document   : HomePage
    Created on : Nov 18, 2017, 6:41:47 PM
    Author     : Yanick
--%>
<!--319799644902-a9fchhpdonmcoo84o4tk0jk22v9qco23.apps.googleusercontent.com-->
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>

        <title>Home Page Desafio Voxus</title>
        
        <!--<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">-->

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!--necessario para login com google -->
        <script src="https://apis.google.com/js/platform.js" async defer></script>
        <meta name="google-signin-client_id" content="319799644902-a9fchhpdonmcoo84o4tk0jk22v9qco23.apps.googleusercontent.com">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        
        
        

        <%  if (request.getAttribute("falha") != null) {%> 
        <script type="text/javascript"> alert("<%= request.getAttribute("falha")%>     ")</script>
        <% }%>    

    </head>


    <body>
        <h1>Página Inicial</h1>
<!--LOGIN   LOGIN   LOGIN   LOGIN   LOGIN   LOGIN   LOGIN   LOGIN   LOGIN   LOGIN   LOGIN   LOGIN   LOGIN   LOGIN   LOGIN   -->
        <form name="formCadastro" action="Autenticacao" method="POST">
            <table border="0">
                <thead>
                    <tr>
                        <th>AUTENTICAÇÃO</th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>email: </td>
                        <td><input type="text" name="email" value="" size="20" /></td>
                    </tr>
                    <tr>
                        <td>Senha: </td>
                        <td><input type="password" name="senha" value="" /></td>
                    </tr>
                    <tr>
                        <td><input type="submit" value="logar" name="botao autenticacao" /></td>
                        <td></td>
                    </tr>
                </tbody>
            </table>
        </form>

        <!--CADASTROS   CADASTROS   CADASTROS   CADASTROS   CADASTROS   CADASTROS   CADASTROS   CADASTROS   -->
        
        <form name="formNovoCadastrp" action="Cadastrar" method="POST">
            <div>Não possui cadastro? </div>
            <div>Nome: <input type="text" name="nome" value="" size="29" /> </div>
            <div>Sobrenome: <input type="text" name="sobreNome" value="" size="24" /> </div>
            <div>Email: <input type="text" name="email" value="" size="29" /> </div>
            <div>Senha:  <input type="password" name="senha1" value="" size="28" /> </div>
            <div>Confirma senha: <input type="password" name="senha2" value="" size="20" /> </div>

            <input type="submit" value="Cadastrar" name="cadastrar" />
            
            <div>  <!--Não funciona-->  <!--Não funciona-->  <!--Não funciona-->
          
                <!--Não funciona-->       Cadastro usando conta do Google:   <!--Não funciona-->
            
            </div>  <!--Não funciona-->  <!--Não funciona-->  <!--Não funciona-->

          
            <div class="g-signin2" data-onsuccess="onSignIn" data-theme = "dark">
            </div>
        </form>


    </body>
</html>
