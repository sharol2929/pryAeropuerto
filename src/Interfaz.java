import java.net.URL;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Interfaz extends Application{
	
	
	public void start (Stage Primarystage) throws Exception{
		FXMLLoader fxmlloader =new FXMLLoader();
		URL xmlUrl = getClass().getResource("interfazUsuario.fxml");
		fxmlloader.setLocation(xmlUrl);
		Parent root = fxmlloader.load();
		
		Scene scene = new Scene(root);

		

		 Primarystage.setTitle("Aeropuerto el Campanero");
		 Primarystage.setHeight(500);
		 Primarystage.setWidth(600);
		 Primarystage.setScene(scene);
		 Primarystage.show();

	}

	public static void main(String[] args) {
		launch (args);
	}
}