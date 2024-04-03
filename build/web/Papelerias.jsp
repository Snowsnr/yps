<%-- 
    Document   : Princ
    Created on : 5/05/2018, 07:35:58 PM
    Author     : Aaron
--%>

<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>
    <meta charset="utf-8">
    <link rel="stylesheet" href="CSS/bootstrap.css">
    <link rel="stylesheet" href="csss/estilo.css">
    <title>Pagina Principal</title>
  </head>
  <body>
    <header id="header" class="fixed-top">
		<nav id="nav">
			<ul>
        <li id="imagen"><img src="img/YPS.jpg"  class="rounded" width="61px" height="61px"></li>
				<li><a href="Princ.jsp"><span class="primero"><i class="icon icon-home3"></i></span>Inicio</a></li>
				<li><a href="Categorias.jsp"><span class="segundo"><i class="icon icon-books"></i></span>Categorias</a>
					<ul>
						<li><a href="PapelyCartulina.jsp">Papel y Cartulina</a></li>
						<li><a href="EscolaresyOficina.jsp">Escolares y de Oficina</a></li>
						<li><a href="ArteyManualidades.jsp">Arte y Manualidades</a></li>
						<li><a href="Regalos.jsp">Regalos</a></li>
					</ul>
				</li>
				<li><a href="Papelerias.jsp"><span class="tercero"><i class="icon icon-office"></i></span>Papelerias</a></li>
				<li><a href="Carrito.jsp"><span class="cuarto"><i class="icon icon-cart"></i></span>Carrito</a></li>
			</ul>
		</nav>
	</header>
  <div class="container-fluid" >
      <div class="col-l2">
        <div class="shadow-sm p-3 mb-5 bg-dark rounded" id="encabezado2"><h3>Mejores Papelerias</h3></div>
                                <%
                                     String usuario = "";
          HttpSession sesionOk = request.getSession();
          usuario = (String)sesionOk.getAttribute("usuario");
          System.out.println(usuario);
                                    String driver="com.mysql.jdbc.Driver";
                                Class.forName(driver).newInstance();
                                Connection con=null;
                                Statement st=null;
                                ResultSet rs=null;
                                System.out.print("Conecto correctamente");
                                try{
                                    String url="jdbc:mysql://localhost:3306/yps2?user=root&password=Sn0w.2017";
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
                                        System.out.print("Entro a while");
                                        if(i==(i/2)*2){
                                %>
            <div class="card" style="width: 18rem;" id="horizontal">
                <img class="card-img-top" src="img/<%=img%>" alt="Card image cap">
                <div class="card-body">
                  <h5 class="card-title"><%=nom%></h5>
                  <p class="card-text"> Variedad a buen precio </p>
                  <form action="Datos2">
                      <input type="hidden" name="id_pap" value="<%=id%>">
                      <input type="hidden" name="nom" value="<%=nom%>">
                      <input type="hidden" name="img" value="<%=img%>">
                      <input type="hidden" name="ubi" value="<%=ubic%>">
                      
                      <input class="btn btn-primary" type="submit" value="Visualizar" />
                  </form>
                </div>
            </div>
                                <% }else{
                                %>
          <div class="card" style="width: 18rem;" id="horizontal">
                <img class="card-img-top" src="img/<%=img%>" alt="Card image cap">
                <div class="card-body">
                  <h5 class="card-title"><%=nom%></h5>
                  <p class="card-text"> Variedad a buen precio </p>
                  <form action="Datos2">
                      <input type="hidden" name="id_pap" value="<%=id%>">
                      <input type="hidden" name="nom" value="<%=nom%>">
                      <input type="hidden" name="img" value="<%=img%>">
                      <input type="hidden" name="ubi" value="<%=ubic%>">
                      
                      <input class="btn btn-primary" type="submit" value="Visualizar" />
                  </form>
                </div>
            </div>
                                <%
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
                                %>
        </div>
  </div>
          <footer id="footer">
            <div id="social" margin-rigth="0%">
        			<h3>Contacto:</h3><h5> yourpapershop@outlook.com</h5>
        			<div id="facebook"></div>
              <div id="twitter"><a href="https://twitter.com/YourPaperShopOF"  target="_blank"><img src="img/twitterlogo.png" height="50 px"></a></div>
              
        		</div>
          </footer>
  </body>
</html>