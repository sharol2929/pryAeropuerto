public class Vuelo {
    protected int idVuelo ;
    protected int id;
    protected String fecha,hora,siglas,nom_piloto;
    public static final int Pasajeros = 0;
    public static final int Carga = 1;
    protected int tipo;
    
    public Vuelo(int idVuelo,String fecha,String hora,int tipo, int id,String nombre,String siglas){
        this.fecha = fecha;
        this.idVuelo = idVuelo;
        this.hora = hora;
        this.tipo = tipo;
        this.id =id; this.nom_piloto =nombre;
        this.siglas = siglas;
        
    }

    @Override
    public String toString() {
        String cadena ="Datos del vuelo "+"\n"+"Identificación del vuelo	: " + idVuelo+"\n"+"fecha				: " + fecha+"\n"+"tipo de vuelo			: " + tipo +"\n"+"\n"
        +"Datos del piloto"+"\n"+ "Identificación del piloto : "+ id+"\n"+ "Nombre del piloto : "+ nom_piloto+
        "\n"+"Datos del avion"+ "\n"+ "Siglas del Avión : "+siglas;
    
        return cadena;
    }

	public int getIdVuelo() {
		return idVuelo;
	}

	public void setIdVuelo(int idVuelo) {
		this.idVuelo = idVuelo;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

    
}

