import java.net.URL;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Interfaz extends Application{
	Lista_vuelos lis_vuelos = new Lista_vuelos();
	
	public void start (Stage Primarystage) throws Exception{
		FXMLLoader fxmlloader =new FXMLLoader();
		URL xmlUrl = getClass().getResource("interfaz.fxml");
		fxmlloader.setLocation(xmlUrl);
		Parent root = fxmlloader.load();
		
		Scene scene = new Scene(root);

		lis_vuelos.conexion();

		 Primarystage.setTitle("Aeropuerto el Campanero");
		 Primarystage.setScene(scene);
		 Primarystage.show();

	}

	public static void main(String[] args) {
		launch (args);
	}
}