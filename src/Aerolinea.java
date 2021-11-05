public class Aerolinea {
    private int cod_aerolinea;
    private String nom_aerolinea;

    public Aerolinea(int codigo,String nombre){
        this.cod_aerolinea=codigo;
        this.nom_aerolinea=nombre;
    }

    public String toString(){
        return "Aerolinea: "+ cod_aerolinea;
    }

    public int getCod_aerolinea(){
        return cod_aerolinea;
    }

    public void setCod_aerolinea(int codigo){
        this.cod_aerolinea=codigo;
    }

    public String getNom_aerolinea(){
        return nom_aerolinea;
    }

    public void setNom_aerolinea(String nombre){
        this.nom_aerolinea=nombre;
    }
}
