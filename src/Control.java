import java.util.ArrayList;
import java.util.Optional;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Accordion;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.TitledPane;
import javafx.scene.input.MouseEvent;



public class Control extends Interfaz {
    ArrayList<Vuelo> vuelos = lis_vuelos.getVuelos();

    @FXML
    private Button boton_rechazar;
    
    @FXML
    private Button botonRevisar;

    @FXML
    private Button botonAgregar;

    @FXML
    private Button botonEliminar;

    @FXML
    private Accordion vuelosAceptados;

    @FXML
    private TitledPane panel1;

    @FXML
    private Accordion solicitudes;
    
    @FXML
    private ListView<Vuelo> lista_vuelos;

    @FXML
    void rechazar_solicitud(ActionEvent event) {
        
        if(solicitudes.getPanes().isEmpty()){
        
        }else{
            TextInputDialog rechazo = new TextInputDialog();
            rechazo.setTitle("Solicitud Rechazada");
            rechazo.setHeaderText("Se rechaza la solicitud por:");
            rechazo.setResizable(true);
            

            for (int i=0, k=solicitudes.getPanes().size(); i<k ; i++){
                
                if(solicitudes.getPanes().get(i).isExpanded()){
                    
                    

                    Optional<String> result = rechazo.showAndWait();
                     if (result.isPresent()){
                        TitledPane c = solicitudes.getPanes().get(i);
                        solicitudes.getPanes().remove(c);
                    }else{}
                    break;

                }else{}

            }
            
        }


    }

    @FXML
    void agregarVuelo(ActionEvent event) {
        
        if(solicitudes.getPanes().isEmpty()){
        
        }else{
            
            for (int i=0, k=solicitudes.getPanes().size(); i<k ; i++){
                
                if(solicitudes.getPanes().get(i).isExpanded()){
                    
                    TitledPane a=solicitudes.getPanes().get(i);
                    vuelosAceptados.getPanes().add(a);
                    a.setText("vuelo");
                    solicitudes.getPanes().remove(a);
                }

            }
            
        }
    }

    @FXML
    void eliminarVuelo(ActionEvent event) {
        if(vuelosAceptados.getPanes().isEmpty()){
        
        }else{
            for (int i=0, k=vuelosAceptados.getPanes().size(); i<k ; i++){
                
                if(vuelosAceptados.getPanes().get(i).isExpanded()){
                    TitledPane c = vuelosAceptados.getPanes().get(i);
                    vuelosAceptados.getPanes().remove(c);
                }

            }
            
        }
    }

    @FXML
    void ver_solicitud(MouseEvent event) {
        String vuelotexto = "";
        int can = vuelos.size(); int i =0;
        if (vuelos.isEmpty() || solicitudes.getPanes().isEmpty()){
            while (i < can){
                vuelotexto = new String(vuelos.get(i).toString());
                TitledPane paneSol = new TitledPane("solicitud "+(i+1), new Label(vuelotexto));
                solicitudes.getPanes().add(paneSol);
                i++;
            }
        }else{
            
            boolean flag = true;
            
           
            
            for ( int z =0; z<can; z++){
                flag = true;
                for (int j=0, k=solicitudes.getPanes().size(); j<k ; j++){
                    TitledPane paneBaseDatos = new TitledPane("solicitud "+(z+1),new Label(vuelotexto));
                
                    String t1 = paneBaseDatos.getText(); //System.out.println(t1);
                    String t2 = solicitudes.getPanes().get(j).getText();//System.out.println(t2);
                    boolean f =t1.equals(t2);System.out.println(f);
                    if(t1.equals(t2)){
                        System.out.println("1"+flag);
                        flag = false;System.out.println("2"+flag);
                    }
                
                }
                if(flag ){
                    vuelotexto = new String(vuelos.get(z).toString());
                    TitledPane paneSol = new TitledPane("solicitud "+(z+1), new Label(vuelotexto));
                    solicitudes.getPanes().add(paneSol);
                    
                }    
                
            }
            
                
            }
             
       
        
    } 
          
}
      
