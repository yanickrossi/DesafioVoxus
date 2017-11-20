package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class HomePage_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!--319799644902-a9fchhpdonmcoo84o4tk0jk22v9qco23.apps.googleusercontent.com-->\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("\n");
      out.write("        <title>Home Page Desafio Voxus</title>\n");
      out.write("        \n");
      out.write("        <!--<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\">-->\n");
      out.write("\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <!--necessario para login com google -->\n");
      out.write("        <script src=\"https://apis.google.com/js/platform.js\" async defer></script>\n");
      out.write("        <meta name=\"google-signin-client_id\" content=\"319799644902-a9fchhpdonmcoo84o4tk0jk22v9qco23.apps.googleusercontent.com\">\n");
      out.write("        <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js\"></script>\n");
      out.write("        \n");
      out.write("        \n");
      out.write("        \n");
      out.write("\n");
      out.write("        ");
  if (request.getAttribute("falha") != null) {
      out.write(" \n");
      out.write("        <script type=\"text/javascript\"> alert(\"");
      out.print( request.getAttribute("falha"));
      out.write("     \")</script>\n");
      out.write("        ");
 }
      out.write("    \n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("\n");
      out.write("\n");
      out.write("    <body>\n");
      out.write("        <h1>Página Inicial</h1>\n");
      out.write("<!--LOGIN   LOGIN   LOGIN   LOGIN   LOGIN   LOGIN   LOGIN   LOGIN   LOGIN   LOGIN   LOGIN   LOGIN   LOGIN   LOGIN   LOGIN   -->\n");
      out.write("        <form name=\"formCadastro\" action=\"Autenticacao\" method=\"POST\">\n");
      out.write("            <table border=\"0\">\n");
      out.write("                <thead>\n");
      out.write("                    <tr>\n");
      out.write("                        <th>AUTENTICAÇÃO</th>\n");
      out.write("                        <th></th>\n");
      out.write("                    </tr>\n");
      out.write("                </thead>\n");
      out.write("                <tbody>\n");
      out.write("                    <tr>\n");
      out.write("                        <td>email: </td>\n");
      out.write("                        <td><input type=\"text\" name=\"email\" value=\"\" size=\"20\" /></td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td>Senha: </td>\n");
      out.write("                        <td><input type=\"password\" name=\"senha\" value=\"\" /></td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td><input type=\"submit\" value=\"logar\" name=\"botao autenticacao\" /></td>\n");
      out.write("                        <td></td>\n");
      out.write("                    </tr>\n");
      out.write("                </tbody>\n");
      out.write("            </table>\n");
      out.write("        </form>\n");
      out.write("\n");
      out.write("        <!--CADASTROS   CADASTROS   CADASTROS   CADASTROS   CADASTROS   CADASTROS   CADASTROS   CADASTROS   -->\n");
      out.write("        \n");
      out.write("        <form name=\"formNovoCadastrp\" action=\"Cadastrar\" method=\"POST\">\n");
      out.write("            <div>Não possui cadastro? </div>\n");
      out.write("            <div>Nome: <input type=\"text\" name=\"nome\" value=\"\" size=\"29\" /> </div>\n");
      out.write("            <div>Sobrenome: <input type=\"text\" name=\"sobreNome\" value=\"\" size=\"24\" /> </div>\n");
      out.write("            <div>Email: <input type=\"text\" name=\"email\" value=\"\" size=\"29\" /> </div>\n");
      out.write("            <div>Senha:  <input type=\"password\" name=\"senha1\" value=\"\" size=\"28\" /> </div>\n");
      out.write("            <div>Confirma senha: <input type=\"password\" name=\"senha2\" value=\"\" size=\"20\" /> </div>\n");
      out.write("\n");
      out.write("            <input type=\"submit\" value=\"Cadastrar\" name=\"cadastrar\" />\n");
      out.write("            \n");
      out.write("            <div>  <!--Não funciona-->  <!--Não funciona-->  <!--Não funciona-->\n");
      out.write("          \n");
      out.write("                <!--Não funciona-->       Cadastro usando conta do Google:   <!--Não funciona-->\n");
      out.write("            \n");
      out.write("            </div>  <!--Não funciona-->  <!--Não funciona-->  <!--Não funciona-->\n");
      out.write("\n");
      out.write("          \n");
      out.write("            <div class=\"g-signin2\" data-onsuccess=\"onSignIn\" data-theme = \"dark\">\n");
      out.write("            </div>\n");
      out.write("        </form>\n");
      out.write("\n");
      out.write("\n");
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
