package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;

public final class Princ_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\" dir=\"ltr\">\n");
      out.write("  <head>\n");
      out.write("    <meta charset=\"utf-8\">\n");
      out.write("    <link rel=\"stylesheet\" href=\"CSS/bootstrap.css\">\n");
      out.write("    <link rel=\"stylesheet\" href=\"csss/estilo.css\">\n");
      out.write("    <title>Pagina Principal</title>\n");
      out.write("  </head>\n");
      out.write("  <body>\n");
      out.write("      ");

          String usuario = "";
          HttpSession sesionOk = request.getSession();
          usuario = (String)sesionOk.getAttribute("usuario");
          System.out.println(usuario);
          
          
      
      out.write("\n");
      out.write("    <header id=\"header\" class=\"fixed-top\">\n");
      out.write("\t\t<nav id=\"nav\">\n");
      out.write("\t\t\t<ul>\n");
      out.write("        <li id=\"imagen\"><img src=\"img/YPS.jpg\"  class=\"rounded\" width=\"61px\" height=\"61px\"></li>\n");
      out.write("\t\t\t\t<li><a href=\"Princ.jsp\"><span class=\"primero\"><i class=\"icon icon-home3\"></i></span>Inicio</a></li>\n");
      out.write("\t\t\t\t<li><a href=\"Categorias.jsp\"><span class=\"segundo\"><i class=\"icon icon-books\"></i></span>Categorias</a>\n");
      out.write("\t\t\t\t\t<ul>\n");
      out.write("\t\t\t\t\t\t<li><a href=\"PapelyCartulina.jsp\">Papel y Cartulina</a></li>\n");
      out.write("\t\t\t\t\t\t<li><a href=\"EscolaresyOficina.jsp\">Escolares y de Oficina</a></li>\n");
      out.write("\t\t\t\t\t\t<li><a href=\"ArteyManualidades.jsp\">Arte y Manualidades</a></li>\n");
      out.write("\t\t\t\t\t\t<li><a href=\"Regalos.jsp\">Regalos</a></li>\n");
      out.write("\t\t\t\t\t</ul>\n");
      out.write("\t\t\t\t</li>\n");
      out.write("\t\t\t\t<li><a href=\"Papelerias.jsp\"><span class=\"tercero\"><i class=\"icon icon-office\"></i></span>Papelerias</a></li>\n");
      out.write("\t\t\t\t<li><a href=\"Carrito.jsp\"><span class=\"cuarto\"><i class=\"icon icon-cart\"></i></span>Carrito</a></li>\n");
      out.write("\t\t\t</ul>\n");
      out.write("\t\t</nav>\n");
      out.write("\t</header>\n");
      out.write("  <div class=\"container-fluid\" >\n");
      out.write("    <div class=\"row\">\n");
      out.write("      <div class=\"col-lg-6 col1\">\n");
      out.write("        <div class=\"shadow-sm p-3 mb-5 bg-white rounded\" id=\"encabezado\"><h3>Productos populares</h3></div>\n");
      out.write("            ");

                
                                String driver="com.mysql.jdbc.Driver";
                                Class.forName(driver).newInstance();
                                Connection con=null;
                                Statement st=null;
                                ResultSet rs=null;
                                

                                try{
                                    String url="jdbc:mysql://localhost:3306/yps2?user=root&password=n0m3l0";
                                    con=DriverManager.getConnection(url);
                                    st=con.createStatement();
                                    rs=st.executeQuery("Select producto.id_producto, material.Material, producto.Ubimagen, producto.Precio from material INNER JOIN producto ON producto.id_material=material.id_material;");
                                    
                                    String ubimg, nom;
                                    int id;
                                    float prec;

                                    int i=1;
                                    while(rs.next()){
                                        id=rs.getInt(1);
                                        nom=rs.getString(2);
                                        ubimg=rs.getString(3);
                                        prec=rs.getFloat(4);
                                        System.out.println("el id es: "+id);
                                        
                                        
                                        if(i==(i/2)*2){
                                            
                                
      out.write("\n");
      out.write("            <div class=\"card\" style=\"width: 18rem;\" id=\"horizontal\">\n");
      out.write("                <img class=\"card-img-top\" width=\"60px\" src=\"img/");
      out.print(ubimg);
      out.write("\" alt=\"Card image cap\">\n");
      out.write("                <div class=\"card-body\">\n");
      out.write("                    <h5 class=\"card-title\">");
      out.print(nom);
      out.write("</h5>\n");
      out.write("                  <p class=\"card-text\">$");
      out.print(prec);
      out.write("</p>\n");
      out.write("                  <form action=\"Datos\">\n");
      out.write("                      <input type=\"hidden\" name=\"nom\" value=\"");
      out.print(nom);
      out.write("\">\n");
      out.write("                      <input type=\"hidden\" name=\"prec\" value=\"");
      out.print(prec);
      out.write("\">\n");
      out.write("                      <input type=\"hidden\" name=\"img\" value=\"");
      out.print(ubimg);
      out.write("\">\n");
      out.write("                      <input type=\"hidden\" name=\"id\" value=\"");
      out.print(id);
      out.write("\">\n");
      out.write("                      <input class=\"btn btn-primary\" type=\"submit\" value=\"Comprar\" />\n");
      out.write("                  </form>\n");
      out.write("                </div>                   \n");
      out.write("            </div>\n");
      out.write("                                ");
 }else{
                                
      out.write("\n");
      out.write("            <div class=\"card\" style=\"width: 18rem;\" id=\"horizontal\">\n");
      out.write("                <img class=\"card-img-top\" width=\"60px\" src=\"img/");
      out.print(ubimg);
      out.write("\" alt=\"Card image cap\">\n");
      out.write("                <div class=\"card-body\">\n");
      out.write("                    <h5 class=\"card-title\">");
      out.print(nom);
      out.write("</h5>\n");
      out.write("                  <p class=\"card-text\">$");
      out.print(prec);
      out.write("</p>\n");
      out.write("                  <form action=\"Datos\">\n");
      out.write("                      <input type=\"hidden\" name=\"nom\" value=\"");
      out.print(nom);
      out.write("\">\n");
      out.write("                      <input type=\"hidden\" name=\"prec\" value=\"");
      out.print(prec);
      out.write("\">\n");
      out.write("                      <input type=\"hidden\" name=\"img\" value=\"");
      out.print(ubimg);
      out.write("\">\n");
      out.write("                      <input type=\"hidden\" name=\"id\" value=\"");
      out.print(id);
      out.write("\">\n");
      out.write("                      <input class=\"btn btn-primary\" type=\"submit\" value=\"Comprar\" />\n");
      out.write("                  </form>\n");
      out.write("                </div>                   \n");
      out.write("            </div>\n");
      out.write("                                ");

                                        }
                                        i++;
                                    }
                                    rs.close();
                                    st.close();
                                    con.close();
                                    }catch(Exception e){
                                    System.out.println("Hay un error: "+e.getMessage());
                                    System.out.println(e.getStackTrace());
                                    }
                                
      out.write("\n");
      out.write("        </div>\n");
      out.write("      <div class=\"col-lg-6 col2\">\n");
      out.write("        <div class=\"shadow-sm p-3 mb-5 bg-dark rounded\" id=\"encabezado2\"><h3>Mejores Papelerias</h3></div>\n");
      out.write("                                ");

                                try{
                                    String url="jdbc:mysql://localhost:3306/yps2?user=root&password=n0m3l0";
                                    con=DriverManager.getConnection(url);
                                    st=con.createStatement();
                                    rs=st.executeQuery("select * from papeleria");
                                    
                                    int i=1;
                                    int cal, id;
                                    String nom, ubic, img;
                                    while(rs.next()){
                                        id=rs.getInt(1);
                                        nom=rs.getString(2);
                                        ubic=rs.getString(3);
                                        img=rs.getString(4);
                                        System.out.println("id papeleria"+id);
                                        System.out.print("Entro a while");
                                        if(i==(i/2)*2){
                                
      out.write("\n");
      out.write("            <div class=\"card\" style=\"width: 18rem;\" id=\"horizontal\">\n");
      out.write("                <img class=\"card-img-top\" src=\"img/");
      out.print(img);
      out.write("\" alt=\"Card image cap\">\n");
      out.write("                <div class=\"card-body\">\n");
      out.write("                  <h5 class=\"card-title\">");
      out.print(nom);
      out.write("</h5>\n");
      out.write("                  <form action=\"Datos2\">\n");
      out.write("                      <input type=\"hidden\" name=\"id_pap\" value=\"");
      out.print(id);
      out.write("\">\n");
      out.write("                      <input type=\"hidden\" name=\"nom\" value=\"");
      out.print(nom);
      out.write("\">\n");
      out.write("                      <input type=\"hidden\" name=\"img\" value=\"");
      out.print(img);
      out.write("\">\n");
      out.write("                      <input type=\"hidden\" name=\"ubi\" value=\"");
      out.print(ubic);
      out.write("\">\n");
      out.write("                      \n");
      out.write("                      <input class=\"btn btn-primary\" type=\"submit\" value=\"Visualizar\" />\n");
      out.write("                  </form>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("                                ");
 }else{
                                
      out.write("\n");
      out.write("          <div class=\"card\" style=\"width: 18rem;\" id=\"horizontal\">\n");
      out.write("                <img class=\"card-img-top\" src=\"img/");
      out.print(img);
      out.write("\" alt=\"Card image cap\">\n");
      out.write("                <div class=\"card-body\">\n");
      out.write("                  <h5 class=\"card-title\">");
      out.print(nom);
      out.write("</h5>\n");
      out.write("                  <p class=\"card-text\"> Variedad a buen precio </p>\n");
      out.write("                  <form action=\"Datos2\">\n");
      out.write("                      <input type=\"hidden\" name=\"id_pap\" value=\"");
      out.print(id);
      out.write("\">\n");
      out.write("                      <input type=\"hidden\" name=\"nom\" value=\"");
      out.print(nom);
      out.write("\">\n");
      out.write("                      <input type=\"hidden\" name=\"img\" value=\"");
      out.print(img);
      out.write("\">\n");
      out.write("                      <input type=\"hidden\" name=\"ubi\" value=\"");
      out.print(ubic);
      out.write("\">\n");
      out.write("                      \n");
      out.write("                      <input class=\"btn btn-primary\" type=\"submit\" value=\"Visualizar\" />\n");
      out.write("                  </form>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("                                ");

                                        }
                                        i++;
                                    }
                                    rs.close();
                                    st.close();
                                    con.close();
                                    }catch(Exception e){
                                    System.out.println("Hay un error: "+e.getMessage());
                                    System.out.println(e.getStackTrace());
                                    }
                                
      out.write("\n");
      out.write("        </div>\n");
      out.write("          <footer id=\"footer\">\n");
      out.write("            <div id=\"social\" margin-rigth=\"0%\">\n");
      out.write("        \t\t\t<h3>Contacto:</h3><h5> yourpapershop@outlook.com</h5>\n");
      out.write("        \t\t\t<div id=\"facebook\"></div>\n");
      out.write("              <div id=\"twitter\"><a href=\"https://twitter.com/YourPaperShopOF\"  target=\"_blank\"><img src=\"img/twitterlogo.png\" height=\"50 px\"></a></div>\n");
      out.write("        \t\t</div>\n");
      out.write("          </footer>\n");
      out.write("  </body>\n");
      out.write("</html>");
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
