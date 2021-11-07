import java.util.Calendar;
import java.util.GregorianCalendar;

public class Usuario {
    private String usuario,contraseña,pregunta,tipo;
    private boolean estado;
    private int intento;
    private String hora_bloqueo = "1";

    public Usuario(String usuario, String contraseña){
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.estado = true;
        this.intento = 0;
    }
    public Usuario(String usuario, String contraseña, String pregunta,String tipo){
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.pregunta = pregunta;
        this.tipo = tipo;
        this.estado = true;
        this.intento = 0;
        
    }

    public String toString(){
        return usuario +" - " + contraseña;
    }

    public String getUsuario(){
        return this.usuario;
    }

    public String getContraseña(){
        return this.contraseña;
    }

    public String getPregunta(){
        return this.pregunta;
    }
    public String getTipo(){
        return this.tipo;
    }
    public boolean getEstado(){
        System.out.println(setHoraActual()+" "+hora_bloqueo);
        if (estado){

        }else{
          if (setHoraActual().equals(this.hora_bloqueo)){
            this.estado = true;  
            }
        }
        return this.estado;
        
    }
    public void setEstado(boolean estado) {
        this.estado = estado;      
    }
    public int getIntento() {
        return intento;
    }
    public void setIntento( ) {
        if (this.intento < 2){
           this.intento = (this.intento + 1); 
        }else{
            this.estado = false;
            this.hora_bloqueo = tiempo();
            this.intento = 0;
        }
        

    }

    public  String setHoraActual() {
        Calendar calendario = new GregorianCalendar();
        int hora_actual = calendario.get(Calendar.HOUR_OF_DAY);
        int minuto_actual = calendario.get(Calendar.MINUTE);
        
        int minuto = minuto_actual;
        int hora = hora_actual;

        String horaActual = ""+hora+":"+minuto;
        return horaActual;
    }
    public  String tiempo() {
        Calendar calendario = new GregorianCalendar();
        int hora_actual = calendario.get(Calendar.HOUR_OF_DAY);
        int minuto_actual = calendario.get(Calendar.MINUTE);
        
        int minuto = minuto_actual + 1;
        int hora = hora_actual;

        String horaActual = ""+hora+":"+minuto;
        return horaActual;
    }
    
    
}
