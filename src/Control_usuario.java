import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Control_usuario implements Initializable {

    Lista_vuelos lis_vuelos = new Lista_vuelos();

    List<Usuario> usuarios = new ArrayList<>();

    static String usuario;

    static Usuario real_usuario;
    

    @FXML
    private ImageView im_vuelo;

    @FXML
    private TextField txf_usuario;

    @FXML
    private PasswordField txf_contraseña;

    @FXML
    private Label lb_olvide;

    @FXML
    private Button btn_ingresar;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        lis_vuelos.conexion_usuarios();
        usuarios = lis_vuelos.getUsuarios();
        
    }

    @FXML
    void iniciar_seccion(ActionEvent event) {
        boolean iguales = false;
        boolean bloqueo = false;
        int indi =0;
        usuario = txf_usuario.getText();
        String contraseña = txf_contraseña.getText();
        Usuario u1 = new Usuario(usuario, contraseña);
        
        for (int i = 0 ; i<usuarios.size(); i++){
            if (u1.toString().equals(usuarios.get(i).toString())){
                iguales = true; indi=i; break;
            }
            if (u1.getUsuario().equals(usuarios.get(i).getUsuario())) {
                indi = i;
                bloqueo = true;
                break;  
            } 
        }
        if (usuarios.get(indi).getEstado() == true){
            if (bloqueo){
                Alert nocontra = new Alert(AlertType.INFORMATION);
                nocontra.setTitle("Contraseña Incorrecta");
                nocontra.setHeaderText("Contraseña Incorrecta Verifique su contraseña");
                nocontra.setContentText("Su contraseña es incorrecta");
                usuarios.get(indi).setIntento();
                nocontra.showAndWait();
            }

            if(!iguales && !bloqueo){
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Usuario no encontrado");
                alert.setHeaderText("Usuario no encontrado Verifique sus datos");
                alert.setContentText("En caso de no estar registrado, cree una cuenta primero antes de ingresar");
                alert.showAndWait();
                
            }else if (iguales){
                real_usuario = usuarios.get(indi);
                Control_usuario.getUsuario();
                this.cerrar();
                iguales = false; 
            }      
        }else{
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Usuario Bloqueado");
            alert.setHeaderText("Su Usuario ha sido bloqueado");
            alert.setContentText("Espere un minuto e intente nuevamente");
            alert.showAndWait();
        }
        
    }

    public static String getUsuario(){
        return usuario;
    }
    public static Usuario trae_usuario (){
        //System.out.println(real_usuario+ " "+real_usuario.getTipo());
        return real_usuario;
    }

    @FXML
    void menu_vuelo(MouseEvent event) {

    }

    @FXML
    void recuperar_contraseña(MouseEvent event) {
        try {
            FXMLLoader fxmlloader =new FXMLLoader();
            URL xmlUrl = getClass().getResource("interfazContraseña.fxml");
            fxmlloader.setLocation(xmlUrl);
            Parent root = fxmlloader.load();
            final Stage dialogo = new Stage();
            dialogo.initModality(Modality.APPLICATION_MODAL);
            Scene scene = new Scene(root);
            dialogo.setScene(scene);
            dialogo.showAndWait();

        } catch (IOException e) {
           e.printStackTrace();
        }
    }

    public void cerrar(){
        try {

            Stage  mistage =(Stage) this.btn_ingresar.getScene().getWindow();
            mistage.close();

            
        } catch (Exception e) {
            
        }
    }

    

}
