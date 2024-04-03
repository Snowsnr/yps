import java.util.*;
import java.sql.*;
public class UsuarioDao {
    
    public static Connection getConnection(){
        String url, username, password;
        url="jdbc:mysql://localhost:3306/yps2";
        username="root";
        password="Sn0w.2017";
        
        /*Para realizar la conexion*/
        Connection con = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection(url, username, password);
            System.out.println("Si se conecto a BD");
        }catch(Exception e){
            System.out.println("Solo juego contigo again");
            System.out.println(e.getMessage());
            System.out.println(e.getStackTrace());
        }
          return con;
    }
    
    public static int Guardar(Usuario e){
        int estatus=0;
        
        try{
            Connection con = UsuarioDao.getConnection();
            String q, i, nom;
            q="insert into usuario(Nombre, Apellido, Correo, Contrasenia) "
                    + "values(?,?,?,?)";
            PreparedStatement ps=con.prepareStatement(q);
            nom=e.getNombre();
            ps.setString(1, e.getNombre());
            ps.setString(2, e.getApellido());
            ps.setString(3, e.getCorreo());
            ps.setString(4, e.getContrasenia());
           
            estatus=ps.executeUpdate();
            con.close();
            
        }catch(Exception d){
            System.out.println("Solo juego contigo again");
            System.out.println(d.getMessage());
            System.out.println(d.getStackTrace());
        }
        return estatus;
    }
    
    public static int Carrito(Usuario e){
        int estatus=0;
        
        try{
            Connection con = UsuarioDao.getConnection();
            String q, i, nom;
            q="insert into compra(id_producto, id_carrito, id_color, Cantidad) "
                    + "values(?,?,?,?)";
            PreparedStatement ps=con.prepareStatement(q);
            ps.setString(1, e.getId());
            ps.setString(2, e.getUsuario());
            ps.setString(3, e.getColor());
            ps.setString(4, e.getCantidad());
           
            estatus=ps.executeUpdate();
            con.close();
            
        }catch(Exception d){
            System.out.println("Solo juego contigo again");
            System.out.println(d.getMessage());
            System.out.println(d.getStackTrace());
        }
        return estatus;
    }
    
    public static int GuardarP(Usuario e){
        int estatus=0;
        
        try{
            Connection con = UsuarioDao.getConnection();
            String q, i, nom;
            q="insert into papeleria(NomPap, Ubicacion, CorrPap, Contrasenia) "
                    + "values(?,?,?,?)";
            PreparedStatement ps=con.prepareStatement(q);
            nom=e.getNombre();
            ps.setString(1, e.getNombre());
            ps.setString(2, e.getUbicacion());
            ps.setString(3, e.getCorreo());
            ps.setString(4, e.getContrasenia());
           
            estatus=ps.executeUpdate();
            con.close();
            
        }catch(Exception d){
            System.out.println("Solo juego contigo again");
            System.out.println(d.getMessage());
            System.out.println(d.getStackTrace());
        }
        return estatus;
    }
    
    public static int VerificarUsuario(String mail, String contra){
        int estatus=1;
        
        try{
            Connection con = UsuarioDao.getConnection();
            Statement stmt=con.createStatement();
                String sql="SELECT * FROM Usuario WHERE usu_nombre=?";
                String sql2="SELECT * FROM Usuario;";
                String correo = "";
                
                
                int h=0;
                
                
                ResultSet nom = stmt.executeQuery(sql2);
                //comprobar si el nombre ingresado existe
                while(nom.next()){
                    correo = nom.getString("Correo");
                    if(correo.equals(mail)){
                        h=h+1;
                        
                    
                        break;
                    }
                } 
                //comprobar si la contraseña coincide
                
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setString(1, correo);
                
                ResultSet pass = ps.executeQuery();
                while(pass.next()){
                    
                    String clave = pass.getString("usu_password");
                    
                    if(clave.equals(contra)){
                        h=h+1;
                        break;
                    }
                }
                
                if(h==2){
                }else{
                   estatus=0;       
                }
            
        }catch(Exception d){
            System.out.println("Solo juego contigo again");
            System.out.println(d.getMessage());
            System.out.println(d.getStackTrace());
        }
        return estatus;
    }
}
