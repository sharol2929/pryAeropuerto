import javafx.beans.property.SimpleStringProperty;

public class Reserva {
    private SimpleStringProperty avion,hangar,fecha_ingreso,fecha_salida;

    public Reserva(String avion,String hangar, String fecha_ingreso, String fecha_salida){
        this.avion = new SimpleStringProperty(avion);
        this.hangar = new SimpleStringProperty(hangar);
        this.fecha_ingreso = new SimpleStringProperty(fecha_ingreso);
        this.fecha_salida= new SimpleStringProperty(fecha_salida);
    }

    public String getAvion() {
        return avion.get();
    }
    public String getHangar() {
        return hangar.get();
    }
    public String getFecha_ingreso() {
        return fecha_ingreso.get();
    }
    public String getFecha_salida() {
        return fecha_salida.get();
    }

    public void setAvion(String avion) {
        this.avion = new SimpleStringProperty(avion);
    }
    public void setHangar(String hangar) {
        this.hangar = new SimpleStringProperty(hangar);
    }
    public void setFecha_ingreso(String fecha) {
        this.fecha_ingreso = new SimpleStringProperty(fecha);
    }
    public void setFecha_salida(String fecha) {
        this.fecha_salida = new SimpleStringProperty(fecha);
    }
}
