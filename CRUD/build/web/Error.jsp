<%-- 
    Document   : Error
    Created on : Nov 19, 2017, 6:46:07 PM
    Author     : Yanick
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <!--        Página que exibe as mensagens de erro da aplicação      -->
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Aconteceu Algum Erro!</title>
    </head>
    <body>
        <!--dependendo de onde vem a mensagem de erro, uma mensagem diferente é exibida -->
        <!--Isso é possível através do envio da mensagem pelo atributo erroMsm que é sempre setado adequadamente-->
        
        <h1>Erro! <%= request.getAttribute("erroMsg") %></h1>
        <a href="HomePage.jsp">VOLTAR</a>
    </body>
</html>
