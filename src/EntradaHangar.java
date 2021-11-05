import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class EntradaHangar{
    private SimpleIntegerProperty idHangar ;
    private SimpleStringProperty avion,fecha_en,hora_en,fecha_sa,hora_sa,admin;

    public EntradaHangar(int idHangar,String avion,String fecha_en,String hora_en,String fecha_sa, String hora_sa,String admin){
        this.idHangar =new SimpleIntegerProperty(idHangar);
        this.avion=new SimpleStringProperty(avion);
        this.fecha_en=new SimpleStringProperty(fecha_en);
        this.hora_en =new SimpleStringProperty(hora_en);
        this.fecha_sa=new SimpleStringProperty(fecha_sa);
        this.hora_sa=new SimpleStringProperty(hora_sa);
        this.admin=new SimpleStringProperty(admin);
    }

    public String getAdmin() {
        return admin.get();
    }

    public void setAdmin(String admin) {
        this.admin = new SimpleStringProperty(admin);
    }

    public String getHora_sa() {
        return hora_sa.get();
    }

    public void setHora_sa(String hora_sa) {
        this.hora_sa = new SimpleStringProperty(hora_sa);
    }

    public String getFecha_sa() {
        return fecha_sa.get();
    }

    public void setFecha_sa(String fecha_sa) {
        this.fecha_sa = new SimpleStringProperty(fecha_sa);
    }

    public String getHora_en() {
        return hora_en.get();
    }

    public void setHora_en(String hora_en) {
        this.hora_en = new SimpleStringProperty(hora_en);
    }

    public String getFecha_en() {
        return fecha_en.get();
    }

    public void setFecha_en(String fecha_en) {
        this.fecha_en = new SimpleStringProperty(fecha_en);
    }

    public String getAvion() {
        return avion.get();
    }

    public void setAvion(String avion) {
        this.avion = new SimpleStringProperty(avion);
    }

    public int getIdHangar() {
        return idHangar.get();
    }

    public void setIdHangar(int idHangar) {
        this.idHangar = new SimpleIntegerProperty(idHangar);
    }
}