public class Avion {
    private String siglas,modelo,aerolinea;
    private int capacidad,peso,no_motores;

    public Avion(String siglas,String modelo,int capacidad,int motores,int peso ,String aerolinea ){
        this.setSiglas(siglas);
        this.setModelo(modelo);
        this.setCapacidad(capacidad);
        this.setNo_motores(motores);
        this.setPeso(peso);
        this.setAerolinea(aerolinea);
    }

    public String toString(){
        String avion = "Avión : "+ this.siglas;
        return avion;
    }

    public String imprimir(){
        String avio = "Datos del Avión:"+ "\n"+
                      "Siglas:    " + this.siglas +"\n"+
                      "Modelo:    " + this.modelo +"\n" +
                      "Aerolinea: " + this.aerolinea+ "\n";
        return(avio);
    }

    public int getNo_motores() {
        return no_motores;
    }

    public void setNo_motores(int no_motores) {
        this.no_motores = no_motores;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public String getAerolinea() {
        return aerolinea;
    }

    public void setAerolinea(String aerolinea) {
        this.aerolinea = aerolinea;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getSiglas() {
        return siglas;
    }

    public void setSiglas(String siglas) {
        this.siglas = siglas;
    }

    
}
