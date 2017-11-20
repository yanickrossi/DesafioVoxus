<%-- 
    Document   : ManipulaTarefa
    Created on : Nov 19, 2017, 5:17:44 PM
    Author     : Yanick
--%>

<!--Pagina onde haverá a maior interação com o usuário-->
<!--Nesta página é possivel inserir, editar, remover ou buscar uma tarefa-->


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>PÁGINA DE MANIPULAR AS TAREFAS</title>
    </head>
    <body>
        <!--Validacao para exibir o usuario que entrou na pagina-->
        
        <%  if (request.getAttribute("user") != null) {%> 
        <h1>Bem Vindo <%= request.getAttribute("user") %>! </h1>
        <script type="text/javascript"> alert("<%= request.getAttribute("falha")%>     ")</script>
        <% }else{%>    
             <h1>Bem Vindo!</h1>
        <%}%>
        <!--Mensagem que é retornada quando finaliza uma ação (inserir,deletar, editar, buscar)-->
        <%  if (request.getAttribute("returnMsg") != null) {%> 
        
        <h1><%= request.getAttribute("returnMsg") %>! </h1>
        
        <% }%>
        
        <!--Formulário que chama o servlet que cuida das açoes-->
        
        <form name="formTarefa" action="ServletPadrao" method="POST">
            <p>Preencha os campos para INSERIR ou EDITAR uma Tarefa</p>
            <div>Nome da Tarefa:
                <div><input type="text"  name="nome" value="" size="30" /></div>
            </div>
            <div>Nome da nova Tarefa(caso for editar):
                <div><input type="text"  name="nomeNovo" value="" size="30" /></div>
            </div>
            <div>
                Descrição: 
                <div><input type="text"  name="descricao" value="" size="30" /></div>
            </div>
            <div>
                Prioridade:
                <div><select name="prioridade">
                    <option>1</option>
                    <option>2</option>
                    <option>3</option>
                    <option>4</option>
                    <option>5</option>
                    </select> </div>
            </div>
            <div>
                Usuário: 
                <div>  <input type="text"  name="usuario" value="" size="30" /></div>
            </div>
            <div><input type="submit" value="Inserir" name="inserirTarefa" /> ou
            <input type="submit" value="Editar" name="editarTarefa" /></div>
            
            
            <p>Insira o nome da Tarefa que deseja DELETAR</p>
            <div><input type="submit" value="Deletar" name="deletarTarefa" /></div>
            <input type="text" name="deletar" value="" size="20" />
            
            
            
            
            
            <p>Insira o nome da Tarefa que deseja BUSCAR</p>
            <div><input type="submit" value="Buscar" name="buscarTarefa"/></div>
            <input type="text" name="buscar" value="" size="20"/>
            <!--<input type="submit" value="Listar" name="listarTarefa"/>-->
        </form>
            <!--Parte de fazer SingOut com o Google+-->
        <a href="#" onclick="signOut();">Sign out(Apenas para o Login Google+)</a>
        <script>
            function signOut() {
                var auth2 = gapi.auth2.getAuthInstance();
                auth2.signOut().then(function () {
                    console.log('User signed out.');
                });
            }
        </script>
    </body>
</html>
