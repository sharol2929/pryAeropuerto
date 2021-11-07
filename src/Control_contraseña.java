import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.ImageView;

public class Control_contraseña implements Initializable {
    List<Usuario> usuarios = new ArrayList<>();

    Lista_vuelos lis_vuelos = new Lista_vuelos();

    boolean confirmo ;

    @FXML
    private ImageView im_vuelo;

    @FXML
    private TextField txf_contraseña;

    @FXML
    private Label lb_cont;

    @FXML
    private Label lb_cont1;


    @FXML
    private PasswordField txf_confirmo;

    @FXML
    private TextField txf_usuario;

    @FXML
    private Button btn_cambiar;

    @FXML
    private TextField txf_pregunta;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        lis_vuelos.conexion_usuarios();
        usuarios = lis_vuelos.getUsuarios();
        confirmo = false;
        lb_cont.setVisible(false); lb_cont1.setVisible(false);
        btn_cambiar.setVisible(false);
        txf_contraseña.setVisible(false); txf_confirmo.setVisible(false);
        
    }

    @FXML
    void crear_contraseña(ActionEvent event) {
        
        String contraseña = txf_contraseña.getText();
        String contraseña2 = txf_confirmo.getText();
        if (confirmo){
            
            if(contraseña.length()>3 && contraseña.equals(contraseña2)){
                System.out.println(contraseña);
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Cambio de contraseña");
                alert.setHeaderText("Contraseña Cambiada con exito");
                alert.setContentText("Ahora ya puede ingresar al sistema");
                alert.showAndWait(); 
            }
        }
    }
    @FXML
    void confirmar(ActionEvent event) {
        String usuario = txf_usuario.getText();
        String pregunta = txf_pregunta.getText();
        boolean encontre = false;
        for (int i = 0 ; i<usuarios.size(); i++){
            if (usuario.equals(usuarios.get(i).getUsuario())){
                encontre = true;
                if (pregunta.equals(usuarios.get(i).getPregunta())){
                    lb_cont.setVisible(true); lb_cont1.setVisible(true);
                    btn_cambiar.setVisible(true);
                    txf_contraseña.setVisible(true); txf_confirmo.setVisible(true);
                    confirmo = true;
                    
                }
            }
            
        }
        if (!encontre){
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Usuario Invalido");
            alert.setHeaderText("No se enconro el nombre de usuario");
            alert.setContentText("Verifique que digito correctamente sus datos");
            alert.showAndWait();
        }else{
            
        }
    }
    

}

