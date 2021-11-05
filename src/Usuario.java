public class Usuario {
    private String usuario,contraseña,pregunta,tipo;

    public Usuario(String usuario, String contraseña){
        this.usuario = usuario;
        this.contraseña = contraseña;
        
    }
    public Usuario(String usuario, String contraseña, String pregunta,String tipo){
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.pregunta = pregunta;
        this.tipo = tipo;
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
    
}
