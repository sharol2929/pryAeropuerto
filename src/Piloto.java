public class Piloto {
    private int id_piloto;
    private String nom_piloto;
    public Piloto (int id , String nombre ){
        this.id_piloto=id;
        this.nom_piloto=nombre;
    }
    public int getId_piloto() {
        return id_piloto;
    }
    public void setId_piloto(int id_piloto) {
        this.id_piloto = id_piloto;
    }
    public String getNom_piloto() {
        return nom_piloto;
    }
    public void setNom_piloto(String nom_piloto) {
        this.nom_piloto = nom_piloto;
    }
    @Override
    public String toString() {
        return  id_piloto + "=" + nom_piloto ;
    }

    
}
