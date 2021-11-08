
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.sql.*;

public class Lista_vuelos {
	

	protected Vector<Vuelo> lis_vuelos;
	public static List <Vuelo> vuelos = new ArrayList<Vuelo>();
    public static List <Vuelo> solicitudes = new ArrayList<Vuelo>();
    public static List <Vuelo> vuelos_aceptados = new ArrayList<Vuelo>();
    public static List <Vuelo> vuelos_rechazos = new ArrayList<Vuelo>();
    public static List <Hangar> hangares = new ArrayList<Hangar>();
    public static List <Avion> aviones = new ArrayList<Avion>();
    public static List <Piloto> pilotos = new ArrayList<Piloto>();
    public static List <Avion> aviones_aero = new ArrayList<Avion>();
    public static List <Reserva> reservas = new ArrayList<Reserva>();
    public static List <Aerolinea> aerolineas = new ArrayList<Aerolinea>();
    public static List <EntradaHangar> entradas= new ArrayList<EntradaHangar>();
    public static List <Usuario> usuarios= new ArrayList<Usuario>();

    
	public void conexion (){
        
        Connection BaseDatos = null;
        //Statement st = null;
        try {
            String url="jdbc:postgresql://localhost:5432/Aeropuerto";
            String usuario="postgres";
            String contrasena="lolita";

            BaseDatos = DriverManager.getConnection(url, usuario, contrasena);
            Statement stm = BaseDatos.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            char singleQuotesChar = '"';
            String sql = singleQuotesChar+ "Solicitud"+singleQuotesChar;
			ResultSet rs =  stm.executeQuery("select * from public."+ sql+" where estado like '%evisa%'order by cod_solicitud;" );
            
            while (rs.next() ){
				
                String fecha= rs.getString("fecha");
				int id_vuelo = rs.getInt("cod_solicitud");
				int tipo = rs.getInt("tipo");
				String hora = rs.getString("hora");
				int id_piloto = rs.getInt("idpiloto");
				String nom_piloto = rs.getString("nompiloto");
				String siglas = rs.getString("siglas_avion");
                
				Vuelo v1 = new Vuelo(id_vuelo, fecha, hora,tipo,id_piloto,nom_piloto,siglas);
				vuelos.add(v1);
				
                
            }
			// System.out.println(vuelos);
            rs.close();
            stm.close();
        } catch (SQLException ex) {
            System.out.println("Error: " + ex);
    
        }
	}

    public void conexion_solicitud (){
        
        Connection BaseDatos = null;
        //Statement st = null;
        try {
            String url="jdbc:postgresql://localhost:5432/Aeropuerto";
            String usuario="postgres";
            String contrasena="lolita";

            BaseDatos = DriverManager.getConnection(url, usuario, contrasena);
            Statement stm = BaseDatos.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            char singleQuotesChar = '"';
            String sql = singleQuotesChar+ "Solicitud"+singleQuotesChar;
			ResultSet rs =  stm.executeQuery("select * from public."+ sql+"order by cod_solicitud;" );
            
            while (rs.next() ){
				
                String fecha= rs.getString("fecha");
				int id_vuelo = rs.getInt("cod_solicitud");
				int tipo = rs.getInt("tipo");
				String hora = rs.getString("hora");
				int id_piloto = rs.getInt("idpiloto");
				String nom_piloto = rs.getString("nompiloto");
				String siglas = rs.getString("siglas_avion");
                
				Vuelo v1 = new Vuelo(id_vuelo, fecha, hora,tipo,id_piloto,nom_piloto,siglas);
				solicitudes.add(v1);
				
                
            }
			// System.out.println(vuelos);
            rs.close();
            stm.close();
        } catch (SQLException ex) {
            System.out.println("Error: " + ex);
    
        }
	}


	public void solitudReprogramar (int codigo){
        Connection BaseDatos = null;
        //Statement st = null;
        try {
            String url="jdbc:postgresql://localhost:5432/Aeropuerto";
            String usuario="postgres";
            String contrasena="lolita";

            BaseDatos = DriverManager.getConnection(url, usuario, contrasena);
            Statement stm = BaseDatos.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            char singleQuotesChar = '"';
            String sql = singleQuotesChar+ "Solicitud"+singleQuotesChar;
			String rs =  "update "+sql+" set estado='Reprogramar' where cod_solicitud ="+codigo+";" ;
            stm.execute(rs);
            stm.close();
        } catch (SQLException ex) {
            System.out.println("Error: " + ex);
        }
    }

    public void solicitudRechazada(int codigo){
        Connection BaseDatos = null;
        //Statement st = null;
        try {
            String url="jdbc:postgresql://localhost:5432/Aeropuerto";
            String usuario="postgres";
            String contrasena="lolita";

            BaseDatos = DriverManager.getConnection(url, usuario, contrasena);
            Statement stm = BaseDatos.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            char singleQuotesChar = '"';
            String sql = singleQuotesChar+ "Solicitud"+singleQuotesChar;
			String rs =  "update "+sql+" set estado='Rechazada' where cod_solicitud ="+codigo+";" ;
            stm.execute(rs);
            stm.close();
        } catch (SQLException ex) {
            System.out.println("Error: " + ex);
        }
    }

    public void solictudAceptada(int codigo){
        Connection BaseDatos = null;
        //Statement st = null;
        try {
            String url="jdbc:postgresql://localhost:5432/Aeropuerto";
            String usuario="postgres";
            String contrasena="lolita";

            BaseDatos = DriverManager.getConnection(url, usuario, contrasena);
            Statement stm = BaseDatos.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            char singleQuotesChar = '"';
            String sql = singleQuotesChar+ "Solicitud"+singleQuotesChar;
			String rs =  "update "+sql+" set estado='Aceptada' where cod_solicitud ="+codigo+";" ;
            stm.execute(rs);
            stm.close();
        } catch (SQLException ex) {
            System.out.println("Error: " + ex);
        }
    }

    public void registrar_vuelo(Integer idVuelo,String fecha,String hora,String nombre,String siglas){
        Connection BaseDatos = null;

        try {
            String url="jdbc:postgresql://localhost:5432/Aeropuerto";
            String usuario="postgres";
            String contrasena="lolita";

            BaseDatos = DriverManager.getConnection(url, usuario, contrasena);
            Statement stm = BaseDatos.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            char singleQuotesChar = '"';
            String sql = singleQuotesChar+ "Vuelo"+singleQuotesChar;
			String values = idVuelo+","+"'"+fecha+"'"+","+"'"+hora+"'"+","+"'"+siglas+"'"+","+"'"+nombre+"'";
            String sentencia ="INSERT INTO public."+ sql+" (cod_vuelo,fecha_vuelo," +
            "hora_vuelo,avion_vuelo,piloto_vuelo) VALUES "+"("+ values +");" ;
            
            stm.execute(sentencia);
            stm.close();
        } catch (SQLException ex) {
            System.out.println("Error: " + ex);
    
        }
    }

    public void registrar_solicitud(Integer idVuelo,String fecha,String hora,int tipo,int id,String nombre,String siglas,String estado){
        Connection BaseDatos = null;

        try {
            String url="jdbc:postgresql://localhost:5432/Aeropuerto";
            String usuario="postgres";
            String contrasena="lolita";

            BaseDatos = DriverManager.getConnection(url, usuario, contrasena);
            Statement stm = BaseDatos.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            char singleQuotesChar = '"';
            String sql = singleQuotesChar+ "Solicitud"+singleQuotesChar;
			String values = idVuelo+","+"'"+fecha+"'"+","+"'"+hora+"'"+","+tipo+","+ id+","+"'"+nombre+"'"+","+"'"+siglas+"'"+","+"'"+estado+"'";
            String sentencia ="INSERT INTO public."+ sql+" (cod_solicitud,fecha," +
            "hora,tipo,idpiloto,nompiloto,siglas_avion,estado) VALUES "+"("+ values +");" ;
            
            stm.execute(sentencia);
            stm.close();
        } catch (SQLException ex) {
            System.out.println("Error: " + ex);
    
        }
    }

    public void cambiar_fecha(String fecha, int codigo){
        Connection BaseDatos = null;
        //Statement st = null;
        try {
            String url="jdbc:postgresql://localhost:5432/Aeropuerto";
            String usuario="postgres";
            String contrasena="lolita";

            BaseDatos = DriverManager.getConnection(url, usuario, contrasena);
            Statement stm = BaseDatos.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            char singleQuotesChar = '"';
            String sql = singleQuotesChar+ "Vuelo"+singleQuotesChar;
			String rs =  "update "+sql+" set fecha_vuelo ='"+ fecha+"' where cod_vuelo ="+codigo+";" ;
            stm.execute(rs);
            stm.close();
        } catch (SQLException ex) {
            System.out.println("Error: " + ex);
        }
    }

    public void cambiar_hora(String hora, int codigo){
        Connection BaseDatos = null;
        //Statement st = null;
        try {
            String url="jdbc:postgresql://localhost:5432/Aeropuerto";
            String usuario="postgres";
            String contrasena="lolita";

            BaseDatos = DriverManager.getConnection(url, usuario, contrasena);
            Statement stm = BaseDatos.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            char singleQuotesChar = '"';
            String sql = singleQuotesChar+ "Vuelo"+singleQuotesChar;
			String rs =  "update "+sql+" set hora_vuelo ='"+ hora+"' where cod_vuelo ="+codigo+";" ;
            System.out.println("entre");
            stm.execute(rs);
            stm.close();
        } catch (SQLException ex) {
            System.out.println("Error: " + ex);
        }
    }

    public void conexion_hangar(){
        Connection BaseDatos = null;

        try {
            String url="jdbc:postgresql://localhost:5432/Aeropuerto";
            String usuario="postgres";
            String contrasena="lolita";

            BaseDatos = DriverManager.getConnection(url, usuario, contrasena);
            Statement stm = BaseDatos.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            char singleQuotesChar = '"';
            String sql = singleQuotesChar+ "Hangar"+singleQuotesChar;
			ResultSet rs =  stm.executeQuery("select * from public."+ sql );
            
            while (rs.next() ){
				
                
				int id_hangar = rs.getInt("cod_hangar");
				String ubicacion = rs.getString("ubicacion_hangar");
                int capacidad = rs.getInt("capacidad_hangar");
				String administrador = rs.getString("admin_hangar");
				String estado = rs.getString("estado_hangar");
                
				Hangar h1 = new Hangar(id_hangar, ubicacion, capacidad, administrador, estado);
				hangares.add(h1);
                
				
                
            }
			// System.out.println(vuelos);
            rs.close();
            stm.close();
        } catch (SQLException ex) {
            System.out.println("Error: " + ex);
    
        }
    }

    public void conexion_avion(){
        Connection BaseDatos = null;

        try {
            String url="jdbc:postgresql://localhost:5432/Aeropuerto";
            String usuario="postgres";
            String contrasena="lolita";

            BaseDatos = DriverManager.getConnection(url, usuario, contrasena);
            Statement stm = BaseDatos.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            char singleQuotesChar = '"';
            String sql = singleQuotesChar+ "Avion"+singleQuotesChar;
			ResultSet rs =  stm.executeQuery("select * from public."+ sql );
            
            while (rs.next() ){

				String siglas = rs.getString("siglas_avion");
				String modelo = rs.getString("modelo_avion");
                int capacidad = rs.getInt("capacidad_avion");
				int no_motores = rs.getInt("motores_avion");
                int peso = rs.getInt("peso_nominal");
				String aerolinea = rs.getString("aerolinea_avion");
                
				Avion a1 = new Avion(siglas, modelo, capacidad, no_motores, peso, aerolinea);
				aviones.add(a1);
  
            }
            rs.close();
            stm.close();
        } catch (SQLException ex) {
            System.out.println("Error: " + ex);
    
        }
    }

    public void conexion_piloto(){
        Connection BaseDatos = null;

        try {
            String url="jdbc:postgresql://localhost:5432/Aeropuerto";
            String usuario="postgres";
            String contrasena="lolita";

            BaseDatos = DriverManager.getConnection(url, usuario, contrasena);
            Statement stm = BaseDatos.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            char singleQuotesChar = '"';
            String sql = singleQuotesChar+ "Piloto"+singleQuotesChar;
			ResultSet rs =  stm.executeQuery("select * from public."+ sql );
            
            while (rs.next() ){

                int id = rs.getInt("id_piloto");
				String nombre = rs.getString("nom_piloto");
                
				Piloto p1 = new Piloto(id, nombre);
                pilotos.add(p1);
  
            }
            rs.close();
            stm.close();
        } catch (SQLException ex) {
            System.out.println("Error: " + ex);
    
        }
    }

    public void conexion_reserva(){
        Connection BaseDatos = null;
        //Statement st = null;
        try {
            String url="jdbc:postgresql://localhost:5432/Aeropuerto";
            String usuario="postgres";
            String contrasena="lolita";

            BaseDatos = DriverManager.getConnection(url, usuario, contrasena);
            Statement stm = BaseDatos.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            char singleQuotesChar = '"';
            String sql = singleQuotesChar+ "Reserva"+singleQuotesChar;
			ResultSet rs =  stm.executeQuery("select * from public."+ sql+";" );
            
            while (rs.next() ){
				
                String hangar = rs.getString("hangar_reser");
				
				String avion = rs.getString("avion_reser");
				
				String fecha_en = rs.getString("fecha_ingreso");
				String fecha_sa = rs.getString("fecha_salida");
                
				Reserva v1 = new Reserva(avion, hangar, fecha_en, fecha_sa);
				reservas.add(v1);
				
                
            }
			// System.out.println(vuelos);
            rs.close();
            stm.close();
        } catch (SQLException ex) {
            System.out.println("Error: " + ex);
    
        }
    }

    public void Registrar_entrada(int hangar,String avion,String hora_en, String fecha_en,String hora_sa, String fecha_sa,String admin){
        Connection BaseDatos = null;

        try {
            String url="jdbc:postgresql://localhost:5432/Aeropuerto";
            String usuario="postgres";
            String contrasena="lolita";

            BaseDatos = DriverManager.getConnection(url, usuario, contrasena);
            Statement stm = BaseDatos.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            char singleQuotesChar = '"';
            String sql = singleQuotesChar+ "EntradaHangar"+singleQuotesChar;
            String values = "'"+hangar+"'"+","+"'"+avion+"'"+","+"'"+hora_en+"'"+","+"'"+fecha_en+"'"+","+"'"+hora_sa+"'"+","+"'"+fecha_sa+"'"+","+"'"+admin+"'";
            String sentencia ="INSERT INTO public."+ sql+" (hangar_ocu,avion_ocu," +
            "hora_entrada,fecha_entrada,fecha_salida,hora_salida,administrador) VALUES "+"("+ values +");" ;
			stm.executeQuery(sentencia);
            stm.close();
        } catch (SQLException ex) {
            System.out.println("Error: " + ex);
    
        }

    }

    public void hangar_ocuado(int id_hangar){
        Connection BaseDatos = null;
        
        //Statement st = null;
        try {
            String url="jdbc:postgresql://localhost:5432/Aeropuerto";
            String usuario="postgres";
            String contrasena="lolita";

            BaseDatos = DriverManager.getConnection(url, usuario, contrasena);
            Statement stm = BaseDatos.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            char singleQuotesChar = '"';
            String sql = singleQuotesChar+ "Hangar"+singleQuotesChar;
			String rs =  "update "+sql+" set estado_hangar='Ocupado' where cod_hangar ="+id_hangar+";" ;
            stm.execute(rs);
            stm.close();
        } catch (SQLException ex) {
            System.out.println("Error: " + ex);
            
        }
    }

    public void conexion_entradas(){
        Connection BaseDatos = null;
        //Statement st = null;
        try {
            String url="jdbc:postgresql://localhost:5432/Aeropuerto";
            String usuario="postgres";
            String contrasena="lolita";

            BaseDatos = DriverManager.getConnection(url, usuario, contrasena);
            Statement stm = BaseDatos.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            char singleQuotesChar = '"';
            String sql = singleQuotesChar+ "EntradaHangar"+singleQuotesChar;
			ResultSet rs =  stm.executeQuery("select * from public."+ sql );
            
            while (rs.next() ){
				
                
				int id_hangar = rs.getInt("hangar_ocu");
				String avionocu = rs.getString("avion_ocu");
				String hora_en = rs.getString("hora_entrada");
				String fecha_en= rs.getString("fecha_entrada");
				String fecha_sa = rs.getString("fecha_salida");
                String hora_sa = rs.getString("hora_salida");
                String admin = rs.getString("Administrador");
                
				EntradaHangar e1 = new EntradaHangar(id_hangar, avionocu, fecha_en, hora_en, fecha_sa, hora_sa, admin);
                entradas.add(e1);
				
                
            }
			// System.out.println(vuelos);
            rs.close();
            stm.close();
        } catch (SQLException ex) {
            System.out.println("Error: " + ex);
    
        }
    }

    public void conexion_aerolinea(){
        Connection BaseDatos = null;

        try {
            String url="jdbc:postgresql://localhost:5432/Aeropuerto";
            String usuario="postgres";
            String contrasena="lolita";

            BaseDatos = DriverManager.getConnection(url, usuario, contrasena);
            Statement stm = BaseDatos.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            char singleQuotesChar = '"';
            String sql = singleQuotesChar+ "Aerolinea"+singleQuotesChar;
			ResultSet rs =  stm.executeQuery("select * from public."+ sql );
            
            while (rs.next() ){   
				int codigo = rs.getInt("cod_aerolinea");
                String nombre = rs.getString("nom_aerolinea");

				Aerolinea Ar1 = new Aerolinea(codigo, nombre);
                aerolineas.add(Ar1);

            }
			// System.out.println(vuelos);
            rs.close();
            stm.close();
        } catch (SQLException ex) {
            System.out.println("Error: " + ex);
    
        }
    }

    public void avion_aerolinea(String aero_linea){
        Connection BaseDatos = null;

        try {
            String url="jdbc:postgresql://localhost:5432/Aeropuerto";
            String usuario="postgres";
            String contrasena="lolita";

            BaseDatos = DriverManager.getConnection(url, usuario, contrasena);
            Statement stm = BaseDatos.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            char singleQuotesChar = '"';
            String sql = singleQuotesChar+ "Avion"+singleQuotesChar;
			ResultSet rs =  stm.executeQuery("select * from public."+ sql+"where aerolinea_avion like '"+aero_linea+"'"+";");
            
            while (rs.next() ){

				String siglas = rs.getString("siglas_avion");
				String modelo = rs.getString("modelo_avion");
                int capacidad = rs.getInt("capacidad_avion");
				int no_motores = rs.getInt("motores_avion");
                int peso = rs.getInt("peso_nominal");
				String aerolinea = rs.getString("aerolinea_avion");
                
				Avion a1 = new Avion(siglas, modelo, capacidad, no_motores, peso, aerolinea);
				aviones_aero.add(a1);
  
            }
            rs.close();
            stm.close();
        } catch (SQLException ex) {
            System.out.println("Error: " + ex);
    
        }
    }

    public void vuelos_registrados(){
        Connection BaseDatos = null;
        //Statement st = null;
        try {
            String url="jdbc:postgresql://localhost:5432/Aeropuerto";
            String usuario="postgres";
            String contrasena="lolita";

            BaseDatos = DriverManager.getConnection(url, usuario, contrasena);
            Statement stm = BaseDatos.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            char singleQuotesChar = '"';
            String sql = singleQuotesChar+ "Solicitud"+singleQuotesChar;
			ResultSet rs =  stm.executeQuery("select * from public."+ sql+" where estado like '%cepta%';" );
            
            while (rs.next() ){
				
                String fecha= rs.getString("fecha");
				int id_vuelo = rs.getInt("cod_solicitud");
				int tipo = rs.getInt("tipo");
				String hora = rs.getString("hora");
				int id_piloto = rs.getInt("idpiloto");
				String nom_piloto = rs.getString("nompiloto");
				String siglas = rs.getString("siglas_avion");
                
				Vuelo v1 = new Vuelo(id_vuelo, fecha, hora,tipo,id_piloto,nom_piloto,siglas);
				vuelos_aceptados.add(v1);
				
                
            }
			// System.out.println(vuelos);
            rs.close();
            stm.close();
        } catch (SQLException ex) {
            System.out.println("Error: " + ex);
    
        }
    }

    public void vuelos_rechazos(){
        Connection BaseDatos = null;
        //Statement st = null;
        try {
            String url="jdbc:postgresql://localhost:5432/Aeropuerto";
            String usuario="postgres";
            String contrasena="lolita";

            BaseDatos = DriverManager.getConnection(url, usuario, contrasena);
            Statement stm = BaseDatos.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            char singleQuotesChar = '"';
            String sql = singleQuotesChar+ "Solicitud"+singleQuotesChar;
			ResultSet rs =  stm.executeQuery("select * from public."+ sql+" where estado like '%echazada%'or estado like '%eprograma%' ;" );
            
            while (rs.next() ){
				
                String fecha= rs.getString("fecha");
				int id_vuelo = rs.getInt("cod_solicitud");
				int tipo = rs.getInt("tipo");
				String hora = rs.getString("hora");
				int id_piloto = rs.getInt("idpiloto");
				String nom_piloto = rs.getString("nompiloto");
				String siglas = rs.getString("siglas_avion");
                
				Vuelo v1 = new Vuelo(id_vuelo, fecha, hora,tipo,id_piloto,nom_piloto,siglas);
				vuelos_rechazos.add(v1);
				
                
            }
			// System.out.println(vuelos);
            rs.close();
            stm.close();
        } catch (SQLException ex) {
            System.out.println("Error: " + ex);
    
        }
    }

    public void Registrar_salida(int codigo ){
        Connection BaseDatos = null;

        try {
            String url="jdbc:postgresql://localhost:5432/Aeropuerto";
            String usuario="postgres";
            String contrasena="lolita";

            BaseDatos = DriverManager.getConnection(url, usuario, contrasena);
            Statement stm = BaseDatos.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            char singleQuotesChar = '"';
            String sql = singleQuotesChar+ "EntradaHangar"+singleQuotesChar;
            String sentencia ="delete from public."+ sql+"where hangar_ocu = "+codigo+";" ;
			stm.executeQuery(sentencia);
            stm.close();
        } catch (SQLException ex) {
            System.out.println("Error: " + ex);
    
        }
    }

    public void hangar_libre (int hangar){
        Connection BaseDatos = null;
        
        //Statement st = null;
        try {
            String url="jdbc:postgresql://localhost:5432/Aeropuerto";
            String usuario="postgres";
            String contrasena="lolita";

            BaseDatos = DriverManager.getConnection(url, usuario, contrasena);
            Statement stm = BaseDatos.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            char singleQuotesChar = '"';
            String sql = singleQuotesChar+ "Hangar"+singleQuotesChar;
			String rs =  "update "+sql+" set estado_hangar='Libre' where cod_hangar ="+hangar+";" ;
            stm.execute(rs);
            stm.close();
        } catch (SQLException ex) {
            System.out.println("Error: " + ex);
            
        }
    }

    public void reservar_hangar (String hangar, String avion,String fecha_en ,String fecha_sa){
        Connection BaseDatos = null;

        try {
            String url="jdbc:postgresql://localhost:5432/Aeropuerto";
            String usuario="postgres";
            String contrasena="lolita";

            BaseDatos = DriverManager.getConnection(url, usuario, contrasena);
            Statement stm = BaseDatos.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            char singleQuotesChar = '"';
            String sql = singleQuotesChar+ "Reserva"+singleQuotesChar;
            String values = "'"+hangar+"'"+","+"'"+avion+"'"+","+"'"+fecha_en+"'"+","+"'"+fecha_sa+"'";
            String sentencia ="INSERT INTO public."+ sql+" (hangar_reser,avion_reser," +
            "fecha_ingreso,fecha_salida) VALUES "+"("+ values +");" ;
			stm.executeQuery(sentencia);
            stm.close();
        } catch (SQLException ex) {
            System.out.println("Error: " + ex);
    
        }
    }
   
    public void modificar_reserva(String hangar){
        Connection BaseDatos = null;

        try {
            String url="jdbc:postgresql://localhost:5432/Aeropuerto";
            String usuario="postgres";
            String contrasena="lolita";

            BaseDatos = DriverManager.getConnection(url, usuario, contrasena);
            Statement stm = BaseDatos.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            char singleQuotesChar = '"';
            String sql = singleQuotesChar+ "Reserva"+singleQuotesChar;
            //String values = "'"+hangar+"'"+","+"'"+avion+"'"+","+"'"+fecha_en+"'"+","+"'"+fecha_sa+"'";
            String sentencia ="delete from public."+sql+" where hangar_reser like '"+hangar+"' ;";
			stm.executeQuery(sentencia);
            stm.close();
        } catch (SQLException ex) {
            System.out.println("Error: " + ex);
    
        }
    }

    public void conexion_usuarios(){
        Connection BaseDatos = null;
        //Statement st = null;
        try {
            String url="jdbc:postgresql://localhost:5432/Aeropuerto";
            String usuario="postgres";
            String contrasena="lolita";

            BaseDatos = DriverManager.getConnection(url, usuario, contrasena);
            Statement stm = BaseDatos.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            char singleQuotesChar = '"';
            String sql = singleQuotesChar+ "Usuarios"+singleQuotesChar;
			ResultSet rs =  stm.executeQuery("select * from public."+ sql );
            
            while (rs.next() ){
				
                
				
				String nomusuario = rs.getString("nomusuario").strip();
				String contraseña = rs.getString("contraseña").strip();
				String tipousuario = rs.getString("tipousuario").strip();
                String pregunta = rs.getString("pregunta").strip();
				
                
			    Usuario u1 = new Usuario(nomusuario, contraseña,pregunta,tipousuario);
                usuarios.add(u1);
				
                
            }
			// System.out.println(vuelos);
            rs.close();
            stm.close();
        } catch (SQLException ex) {
            System.out.println("Error: " + ex);
    
        }
    }

    public void registrar_usuario(String usuario1, String contraseña, String pregunta, String tipo){
        Connection BaseDatos = null;

        try {
            String url="jdbc:postgresql://localhost:5432/Aeropuerto";
            String usuario="postgres";
            String contrasena="lolita";

            BaseDatos = DriverManager.getConnection(url, usuario, contrasena);
            Statement stm = BaseDatos.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            char singleQuotesChar = '"';
            String sql = singleQuotesChar+ "Usuarios"+singleQuotesChar;
            String values = "'"+usuario1+"'"+","+"'"+contraseña+"'"+","+"'"+tipo+"'"+","+"'"+pregunta+"'";
            String sentencia ="INSERT INTO public."+ sql+" (nomusuario,contraseña," +
            "tipousuario,pregunta) VALUES "+"("+ values +");" ;
			stm.executeQuery(sentencia);
            stm.close();
        } catch (SQLException ex) {
            System.out.println("Error: " + ex);
    
        }

    }

    public List<Vuelo> getVuelos(){
		return vuelos;
	}
    public List<Vuelo> getSolitudes(){
		return solicitudes;
	}
    public List<Vuelo> getVuelos_Aceptados(){
		return vuelos_aceptados;
	}
    public List<Vuelo> getVuelos_Rechazos(){
		return vuelos_rechazos;
	}
    public List<Hangar> getHangares(){
		return hangares;
	}
    public List<Avion> getAviones(){
		return aviones;
	}
    public List<Piloto> getPilotos(){
		return pilotos;
	}
    public List<Avion> getAviones_aero(){
		return aviones_aero;
	}
    public List<EntradaHangar> getEntradas(){
		return entradas;
	}
    public List<Aerolinea> getAerolineas(){
		return aerolineas;
	}
    public List<Reserva> getReservas(){
		return reservas;
	}
    public List<Usuario> getUsuarios(){
		return usuarios;
	}
	

}
