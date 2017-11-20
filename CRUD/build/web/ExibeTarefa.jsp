<%-- 
    Document   : ListaTarefas
    Created on : Nov 19, 2017, 5:06:20 PM
    Author     : Yanick
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <!--Página apenas para exibir a tarefa buscada-->
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Exibição da Tarefa</title>
    </head>
    <body>
        <h1>Tarefa</h1>
        <div>Nome: <%= request.getAttribute("nome") %> </div>
        <div>Descrição:  <%= request.getAttribute("descricao") %></div>
        <div>Prioridade: <%= request.getAttribute("prioridade") %> </div>
        <div>Usuario:  <%= request.getAttribute("usuario") %></div>
        
         <a href="HomePage.jsp">VOLTAR</a>
    </body>
</html>
