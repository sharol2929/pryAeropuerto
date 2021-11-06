
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;


public class Vuelo {
    private SimpleIntegerProperty idVuelo ;
    private SimpleIntegerProperty id;
    private SimpleStringProperty fecha, siglas,nom_piloto;
    private SimpleStringProperty hora;
    public static final int Pasajeros = 0;
    public static final int Carga = 1;
    protected int tipo;
    
    public Vuelo(Integer idVuelo,String fecha,String hora,int tipo, int id,String nombre,String siglas){
        this.fecha =  new SimpleStringProperty(fecha);
        this.idVuelo = new SimpleIntegerProperty(idVuelo);
        this.hora = (new SimpleStringProperty(hora));
        this.tipo = tipo;
        this.id = new SimpleIntegerProperty(id); 
        this.nom_piloto = new SimpleStringProperty(nombre);
        this.siglas = new SimpleStringProperty(siglas);
        
    }
	public Vuelo(Integer idVuelo,String fecha,String hora,String nombre,String siglas){
        this.fecha =  new SimpleStringProperty(fecha);
        this.idVuelo = new SimpleIntegerProperty(idVuelo);
		this.hora = (new SimpleStringProperty(hora));
        this.nom_piloto = new SimpleStringProperty(nombre);
        this.siglas = new SimpleStringProperty(siglas);
        
    }


    @Override
    public String toString() {
        String cadena ="Datos del vuelo "+"\n"+"Identificación del vuelo	: " + idVuelo.get()+"\n"+"fecha				: " + fecha.get()+"\n"+"tipo de vuelo			: " + tipo +"\n"+"\n"
        +"Datos del piloto"+"\n"+ "Identificación del piloto : "+ id.get()+"\n"+ "Nombre del piloto : "+ nom_piloto.get()+"\n"+"\n"
        +"Datos del avion"+ "\n"+ "Siglas del Avión : "+siglas.get();
    
        return cadena;
    }

	public int getIdVuelo() {
		return idVuelo.get();
	}

	public void setIdVuelo(int idVuelo) {
		this.idVuelo = new SimpleIntegerProperty(idVuelo);
	}

	public String getFecha() {
		return fecha.get();
	}

	public void setFecha(String fecha) {
		this.fecha = new SimpleStringProperty(fecha);
	}

    public String getHora() {
		return hora.get();
	}

	public void setHora(String hora) {
		this.hora = new SimpleStringProperty(hora);
	}

    public String getSiglas() {
		return siglas.get();
	}

	public void setSiglas(String siglas) {
		this.siglas = new SimpleStringProperty(siglas);
	}

    public String getNom_piloto() {
		return nom_piloto.get();
	}

	public void setNom_piloto(String nom_piloto) {
		this.nom_piloto = new SimpleStringProperty(nom_piloto);
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

    
}

