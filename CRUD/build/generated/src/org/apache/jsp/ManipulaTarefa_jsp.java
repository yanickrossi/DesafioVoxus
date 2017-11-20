package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class ManipulaTarefa_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("<!--Pagina onde haverá a maior interação com o usuário-->\n");
      out.write("<!--Nesta página é possivel inserir, editar, remover ou buscar uma tarefa-->\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>PÁGINA DE MANIPULAR AS TAREFAS</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <!--Validacao para exibir o usuario que entrou na pagina-->\n");
      out.write("        \n");
      out.write("        ");
  if (request.getAttribute("user") != null) {
      out.write(" \n");
      out.write("        <h1>Bem Vindo ");
      out.print( request.getAttribute("user") );
      out.write("! </h1>\n");
      out.write("        <script type=\"text/javascript\"> alert(\"");
      out.print( request.getAttribute("falha"));
      out.write("     \")</script>\n");
      out.write("        ");
 }else{
      out.write("    \n");
      out.write("             <h1>Bem Vindo!</h1>\n");
      out.write("        ");
}
      out.write("\n");
      out.write("        <!--Mensagem que é retornada quando finaliza uma ação (inserir,deletar, editar, buscar)-->\n");
      out.write("        ");
  if (request.getAttribute("returnMsg") != null) {
      out.write(" \n");
      out.write("        \n");
      out.write("        <h1>");
      out.print( request.getAttribute("returnMsg") );
      out.write("! </h1>\n");
      out.write("        \n");
      out.write("        ");
 }
      out.write("\n");
      out.write("        \n");
      out.write("        <!--Formulário que chama o servlet que cuida das açoes-->\n");
      out.write("        \n");
      out.write("        <form name=\"formTarefa\" action=\"ServletPadrao\" method=\"POST\">\n");
      out.write("            <p>Preencha os campos para INSERIR ou EDITAR uma Tarefa</p>\n");
      out.write("            <div>Nome da Tarefa:\n");
      out.write("                <div><input type=\"text\"  name=\"nome\" value=\"\" size=\"30\" /></div>\n");
      out.write("            </div>\n");
      out.write("            <div>Nome da nova Tarefa(caso for editar):\n");
      out.write("                <div><input type=\"text\"  name=\"nomeNovo\" value=\"\" size=\"30\" /></div>\n");
      out.write("            </div>\n");
      out.write("            <div>\n");
      out.write("                Descrição: \n");
      out.write("                <div><input type=\"text\"  name=\"descricao\" value=\"\" size=\"30\" /></div>\n");
      out.write("            </div>\n");
      out.write("            <div>\n");
      out.write("                Prioridade:\n");
      out.write("                <div><select name=\"prioridade\">\n");
      out.write("                    <option>1</option>\n");
      out.write("                    <option>2</option>\n");
      out.write("                    <option>3</option>\n");
      out.write("                    <option>4</option>\n");
      out.write("                    <option>5</option>\n");
      out.write("                    </select> </div>\n");
      out.write("            </div>\n");
      out.write("            <div>\n");
      out.write("                Usuário: \n");
      out.write("                <div>  <input type=\"text\"  name=\"usuario\" value=\"\" size=\"30\" /></div>\n");
      out.write("            </div>\n");
      out.write("            <div><input type=\"submit\" value=\"Inserir\" name=\"inserirTarefa\" /> ou\n");
      out.write("            <input type=\"submit\" value=\"Editar\" name=\"editarTarefa\" /></div>\n");
      out.write("            \n");
      out.write("            \n");
      out.write("            <p>Insira o nome da Tarefa que deseja DELETAR</p>\n");
      out.write("            <div><input type=\"submit\" value=\"Deletar\" name=\"deletarTarefa\" /></div>\n");
      out.write("            <input type=\"text\" name=\"deletar\" value=\"\" size=\"20\" />\n");
      out.write("            \n");
      out.write("            \n");
      out.write("            \n");
      out.write("            \n");
      out.write("            \n");
      out.write("            <p>Insira o nome da Tarefa que deseja BUSCAR</p>\n");
      out.write("            <div><input type=\"submit\" value=\"Buscar\" name=\"buscarTarefa\"/></div>\n");
      out.write("            <input type=\"text\" name=\"buscar\" value=\"\" size=\"20\"/>\n");
      out.write("            <!--<input type=\"submit\" value=\"Listar\" name=\"listarTarefa\"/>-->\n");
      out.write("        </form>\n");
      out.write("            <!--Parte de fazer SingOut com o Google+-->\n");
      out.write("        <a href=\"#\" onclick=\"signOut();\">Sign out(Apenas para o Login Google+)</a>\n");
      out.write("        <script>\n");
      out.write("            function signOut() {\n");
      out.write("                var auth2 = gapi.auth2.getAuthInstance();\n");
      out.write("                auth2.signOut().then(function () {\n");
      out.write("                    console.log('User signed out.');\n");
      out.write("                });\n");
      out.write("            }\n");
      out.write("        </script>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
