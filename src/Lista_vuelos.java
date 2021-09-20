
import java.util.ArrayList;
import java.util.Vector;
import java.sql.*;

public class Lista_vuelos {
	
	private Nodo nodo_cabecera;
	protected Vector<Vuelo> lis_vuelos;
	public static ArrayList <Vuelo> vuelos = new ArrayList<Vuelo>();
	
	public Lista_vuelos() {

		/*Metodo Construtor*/ 
		
		this.nodo_cabecera = null;
	}
	
	public boolean es_vacia () {
		
		/*Matodo que Determina si la lista esta vacia*/
		
		boolean vacia =true ;
		
		if (nodo_cabecera != null) {
			vacia = false;
		}
		
		return vacia;
	}
	
	public void  adicionar(Vuelo vuelo) {
		/*adiciona un dato al final de la lista*/
		
		Nodo nodo_actual;
		
		if (es_vacia()) {
			this.nodo_cabecera = new Nodo(vuelo);
		}else {
			nodo_actual = nodo_cabecera;
			while (nodo_actual.nodo_sig != null) {
				nodo_actual = nodo_actual.nodo_sig;
			}
			nodo_actual.nodo_sig = new Nodo(vuelo);
		}

	}

	public void recorrer() {
		
		/*recorre e imprime los nodos de la listaSE*/
	
		Nodo nodo_actual = nodo_cabecera;
		while (nodo_actual != null) {
			System.out.print(nodo_actual .vuelo);
			nodo_actual = nodo_actual.nodo_sig;
		}
	}		

	public void borrar(int id_vuelo) {
		Nodo nodo_actual = nodo_cabecera;
		Nodo nodo_aux = null;
		while (nodo_actual != null && ((Vuelo) nodo_actual.vuelo).getIdVuelo() != id_vuelo){
			nodo_aux = nodo_actual;
			nodo_actual = nodo_actual.nodo_sig;
		}
		if (nodo_actual != null) {
			if (nodo_actual == nodo_cabecera) {
				nodo_cabecera = nodo_actual.nodo_sig;
				nodo_actual= null;
			}else {
				nodo_aux.nodo_sig =nodo_actual.nodo_sig;
				nodo_actual=null;
			}
		}
		
	}
	
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
            String sql = singleQuotesChar+ "Vuelo"+singleQuotesChar;
			ResultSet rs =  stm.executeQuery("select * from public."+ sql );
            
            while (rs.next() ){
				
                String fecha= rs.getString("fecha");
				int id_vuelo = rs.getInt("id_vuelo");
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

	public ArrayList<Vuelo> getVuelos(){
		return vuelos;
	}
	

}
