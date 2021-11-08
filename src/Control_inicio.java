import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Control_inicio implements Initializable{
    String usuario;
    
    @FXML
    private ImageView im_vuelo;

    @FXML
    private ImageView im_hangar;

    @FXML
    private Label lb_iniciar;

    @FXML
    private Label lb_cuenta;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
        
    }

    @FXML
    void menu_vuelo(MouseEvent event) {
        try {
            FXMLLoader fxmlloader =new FXMLLoader();
            URL xmlUrl = getClass().getResource("interfaz.fxml");
            fxmlloader.setLocation(xmlUrl);
            Parent root = fxmlloader.load();
            Control_vuelo controlador = fxmlloader.getController();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
            stage.setOnCloseRequest(e -> controlador.cerrar() );

            Stage  mistage =(Stage) this.im_vuelo.getScene().getWindow();
            mistage.close();

            
        } catch (Exception e) {
            
        }
        
    }

    @FXML
    void menu_hangar(MouseEvent event) {
        try {
            FXMLLoader fxmlloader =new FXMLLoader();
            URL xmlUrl = getClass().getResource("interfazHangar.fxml");
            fxmlloader.setLocation(xmlUrl);
            Parent root = fxmlloader.load();
            Control_hangar controlador = fxmlloader.getController();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
            stage.setOnCloseRequest(e -> controlador.cerrar() );

            Stage  mistage =(Stage) this.im_hangar.getScene().getWindow();
            mistage.close();

            
        } catch (Exception e) {
            
        }
    }

    @FXML
    void menu_usuario(MouseEvent event) {
        try {
            FXMLLoader fxmlloader =new FXMLLoader();
            URL xmlUrl = getClass().getResource("interfazUsuario.fxml");
            fxmlloader.setLocation(xmlUrl);
            Parent root = fxmlloader.load();
            final Stage dialogo = new Stage();
            dialogo.initModality(Modality.APPLICATION_MODAL);
            Scene scene = new Scene(root);
            dialogo.setScene(scene);
            dialogo.showAndWait();
            usuario = Control_usuario.getUsuario();
            this.modificar_usuario(usuario);
            
        } catch (Exception e) {
        
        }
            
    }

    public void modificar_usuario(String usuario) {
        lb_iniciar.setText(usuario);
        lb_cuenta.setVisible(false);
        
    }
    
    @FXML
    void menu_cuenta(MouseEvent event) {
        try {
            FXMLLoader fxmlloader =new FXMLLoader();
            URL xmlUrl = getClass().getResource("interfazCuenta.fxml");
            fxmlloader.setLocation(xmlUrl);
            Parent root = fxmlloader.load();
            final Stage dialogo = new Stage();
            dialogo.initModality(Modality.APPLICATION_MODAL);
            Scene scene = new Scene(root);
            dialogo.setScene(scene);
            dialogo.showAndWait();
            
            
            
        } catch (Exception e) {
        
        }
    
    }


}