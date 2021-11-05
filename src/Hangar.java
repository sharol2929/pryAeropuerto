import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Hangar {
    private SimpleIntegerProperty idHangar ;
    private SimpleIntegerProperty capacidad;
    private SimpleStringProperty ubicacion, administrador;
    private SimpleStringProperty estado;
    
    public Hangar(){
        
    }
    public Hangar (int id,String ubicación, int capacidad, String administrador,String estado){
        this.idHangar = new SimpleIntegerProperty(id);
        this.ubicacion = new SimpleStringProperty(ubicación);
        this.capacidad = new SimpleIntegerProperty(capacidad);
        this.administrador= new SimpleStringProperty(administrador);
        this.estado = new SimpleStringProperty(estado);
    }

    public String toString (){
        String hangar = "Datos Hangar :"+ "\n"+ "id del hangar:"+ this.idHangar.get() + "\n"+
                        "estado :" + this.estado.get();
        return hangar;
    }

    public int getIdHangar (){
        return idHangar.get();
    }
    public int getCapacidad (){
        return capacidad.get();
    }
    public String getUbicacion (){
        return ubicacion.get();
    }
    public String getAdministrador (){
        return administrador.get();
    }
    public String getEstado (){
        return estado.get();
    }

    public void setIdHangar(int idHangar) {
		this.idHangar = new SimpleIntegerProperty(idHangar);
	}
    public void setCapacidad(int capacidad) {
		this.capacidad = new SimpleIntegerProperty(capacidad);
	}
    public void setUbicacion(String ubicacion) {
		this.ubicacion = new SimpleStringProperty(ubicacion);
	}
    public void setAdministrador(String administrador) {
		this.administrador = new SimpleStringProperty(administrador);
	}
    public void setEstado(String estado) {
		this.estado = new SimpleStringProperty(estado);
	}
}
