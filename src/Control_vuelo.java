import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.scene.control.Accordion;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;

import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.TitledPane;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

import javafx.scene.text.Text;
import javafx.stage.Stage;


public class Control_vuelo implements Initializable {
    List<Vuelo> vuelos = new ArrayList<>();
    List<Vuelo> solicitud = new ArrayList<>();
    List<Piloto> pilotos = new ArrayList<>();
    List<Avion> aviones = new ArrayList<>();
    List<Vuelo> vuelos_aceptados = new ArrayList<>();
    List<Vuelo> vuelos_rechazos = new ArrayList<>();
    List<Vuelo> vuelos_vacia= new ArrayList<>();

    ObservableList<Vuelo> vueloob;
    ObservableList<Vuelo> ob_solitud;
    ObservableList<Piloto> ob_pilotos;
    ObservableList<Avion> ob_aviones;
    ObservableList<Vuelo> vuelo_vacia = FXCollections.observableList(vuelos_vacia);
    ObservableList<Vuelo> vuelos_ac;
    ObservableList<Vuelo> vuelos_rech;
    ObservableList<String> tipo = FXCollections.observableArrayList();
    Lista_vuelos lis_vuelos = new Lista_vuelos();

    Usuario usuario ;

    @FXML
    private TabPane pan_menus;

    @FXML
    private Button boton_rechazar;
    
    @FXML
    private Button botonRevisar;

    @FXML
    private Button botonAgregar;

    @FXML
    private Button botonEliminar;

    @FXML
    private Tab tab_aerolinea;

    @FXML
    private Tab tab_aerpuerto;

    @FXML
    private TableView<Vuelo> vuelosAceptados;


    @FXML
    private TableColumn<Vuelo, Integer> cod_vuelo;

    @FXML
    private TableColumn<Vuelo, String> hora;

    @FXML
    private TableColumn<Vuelo, String> fecha;

    @FXML
    private TableColumn<Vuelo, String> avion;

    @FXML
    private TableColumn<Vuelo, String> piloto;


    @FXML
    private TitledPane panel1;

    @FXML
    private Accordion solicitudes;

    @FXML
    private DatePicker calendarioVuelos;

    @FXML
    private ImageView im_hecho;

    @FXML
    private ScrollPane sb_barra;

    @FXML
    private Button editar;

    @FXML
    private Menu menu_vuelo;

    @FXML
    private Menu menu_hangar;

    @FXML
    private GridPane pane1;

    @FXML
    private Button bt_editar;

    @FXML
    private TableView<Vuelo> vuelosAceptados1;

    @FXML
    private TableColumn<Vuelo, Integer> cod_vuelo1;

    @FXML
    private TableColumn<Vuelo, String> hora1;

    @FXML
    private TableColumn<Vuelo, String> fecha1;

    @FXML
    private TableColumn<Vuelo, String> avion1;

    @FXML
    private TableColumn<Vuelo, String> piloto1;

    @FXML
    private ComboBox<Piloto> cb_piloto;

    @FXML
    private ComboBox<Avion> cb_avion;

    @FXML
    private ComboBox<String> cb_tipo;

    @FXML
    private DatePicker dp_fecha_aerolinea;

    @FXML
    private TextField tx_hora;

    @FXML
    private Button bt_solicitar;

    @FXML
    private Tab tab_aerpuerto1;

    @FXML
    private DatePicker dp_fecha_viuelo;

    @FXML
    private DatePicker dp_fecha_aplazar;

    @FXML
    private Button bt_aplazar;

    @FXML
    private TableView<Vuelo> vuelosAceptados2;

    @FXML
    private TableColumn<Vuelo, Integer> cod_vuelo2;

    @FXML
    private TableColumn<Vuelo, String> hora2;

    @FXML
    private TableColumn<Vuelo, String> avion2;

    @FXML
    private TableColumn<Vuelo, String> piloto2;

    @FXML
    private TableColumn<Vuelo, String> fecha2;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.usuario = Control_usuario.trae_usuario();
        this.im_hecho.setVisible(false);
        
        lis_vuelos.conexion();
        vuelos = lis_vuelos.getVuelos();
        vueloob = FXCollections.observableList(vuelos);

        lis_vuelos.conexion_solicitud();
        solicitud = lis_vuelos.getSolitudes();
        ob_solitud = FXCollections.observableList(solicitud);
        
        lis_vuelos.vuelos_registrados();
        vuelos_aceptados = lis_vuelos.getVuelos_Aceptados();
        vuelos_ac = FXCollections.observableList(vuelos_aceptados);
        
        lis_vuelos.vuelos_rechazos();
        vuelos_rechazos = lis_vuelos.getVuelos_Rechazos();
        vuelos_rech = FXCollections.observableList(vuelos_rechazos);

        lis_vuelos.conexion_piloto();
        pilotos = lis_vuelos.getPilotos();
        ob_pilotos = FXCollections.observableList(pilotos);
        cb_piloto.setItems(ob_pilotos);

        lis_vuelos.conexion_avion();
        aviones = lis_vuelos.getAviones();
        ob_aviones = FXCollections.observableList(aviones);
        cb_avion.setItems(ob_aviones);

        tipo.addAll("Pasajeros","Carga");
        cb_tipo.setItems(tipo);

        this.vuelosAceptados.setItems(vuelos_ac);
        this.fecha.setCellValueFactory(new PropertyValueFactory<>("fecha"));
        this.cod_vuelo.setCellValueFactory(new PropertyValueFactory<>("idVuelo"));
        this.hora.setCellValueFactory(new PropertyValueFactory<>("hora")); 
        this.avion.setCellValueFactory(new PropertyValueFactory<>("siglas"));
        this.piloto.setCellValueFactory(new PropertyValueFactory<>("nom_piloto"));
        
        this.vuelosAceptados1.setItems(vuelos_rech);
        this.fecha1.setCellValueFactory(new PropertyValueFactory<>("fecha"));
        this.cod_vuelo1.setCellValueFactory(new PropertyValueFactory<>("idVuelo"));
        this.hora1.setCellValueFactory(new PropertyValueFactory<>("hora")); 
        this.avion1.setCellValueFactory(new PropertyValueFactory<>("siglas"));
        this.piloto1.setCellValueFactory(new PropertyValueFactory<>("nom_piloto"));
        

        this.vuelosAceptados2.setItems(vuelos_ac);
        this.fecha2.setCellValueFactory(new PropertyValueFactory<>("fecha"));
        this.cod_vuelo2.setCellValueFactory(new PropertyValueFactory<>("idVuelo"));
        this.hora2.setCellValueFactory(new PropertyValueFactory<>("hora")); 
        this.avion2.setCellValueFactory(new PropertyValueFactory<>("siglas"));
        this.piloto2.setCellValueFactory(new PropertyValueFactory<>("nom_piloto"));
        
        
        //this.verifico_usuario(usuario);
    }   
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
                        String datos_title = c.contentProperty().getValue().toString();
                        String codigo = datos_title.substring(55,59);
                        int cod = Integer.parseInt(codigo);
                        lis_vuelos.solicitudRechazada(cod);
                        solicitudes.getPanes().remove(c);
                    }else{}
                    break;

                }else{}

            }
            
        }


    }

    @FXML
    void agregarVuelo(ActionEvent event) {
        this.fecha.setCellValueFactory(new PropertyValueFactory<>("fecha"));
        this.cod_vuelo.setCellValueFactory(new PropertyValueFactory<>("idVuelo"));
        this.hora.setCellValueFactory(new PropertyValueFactory<>("hora")); 
        this.avion.setCellValueFactory(new PropertyValueFactory<>("siglas"));
        this.piloto.setCellValueFactory(new PropertyValueFactory<>("nom_piloto"));

        if(solicitudes.getPanes().isEmpty()){
        
        }else{
            int j =0;
            int can = vuelos.size();
            int  k=solicitudes.getPanes().size();
            for (int z = 0 ; z<can ;z++){
               
                for(int i=0; i<k ; i++) {
                     if(solicitudes.getPanes().get(i).isExpanded()){
                        Vuelo v1 = vuelos.get(z);
                        TitledPane a =solicitudes.getPanes().get(i);
                        
                        String vuelo = "" +v1.getIdVuelo();
                        String datos_title = a.contentProperty().getValue().toString();
                        String m = datos_title.substring(55,59);
                        String fechatabla =""; String horatabla="" ;
 
                        if (vuelo.equals(m) ){
                            Boolean igual = false;
                            String fechavuelo = v1.getFecha();  String horavuelo = v1.getHora();
                            if (vuelosAceptados.getItems().isEmpty()){
                                fechatabla = "";
                                horatabla = "";
                            }else{
                                while (j< vuelosAceptados.getItems().size()){
                                    fechatabla = vuelosAceptados.getItems().get(j).getFecha();
                                    horatabla = vuelosAceptados.getItems().get(j).getHora(); 
                                        
                                    if (fechavuelo.equals(fechatabla) && horavuelo.equals(horatabla)){
                                        Alert alert = new Alert(AlertType.ERROR);
                                        alert.setTitle("Horario Cuzado");
                                        alert.setHeaderText("No se puede agregar el vuelo");
                                        alert.setContentText("Ya existe un vuelo agendado en ese horario");
                                        alert.showAndWait();
                                        int codigo = Integer.parseInt(m);
                                        lis_vuelos.solitudReprogramar(codigo);
                                        solicitudes.getPanes().remove(a);
                                        igual =true;
                                        break;
                                    }else{
                                        igual =false;
                                        j++;
                                    }
                                    
                                }
                            }
                            
                            if (!igual){
                                vuelosAceptados.getItems().add(v1);
                                int codigo = v1.getIdVuelo();
                                String fecha = v1.getFecha();
                                String hora = v1.getHora();
                                String avion = v1.getSiglas();
                                String piloto = v1.getNom_piloto();
                                lis_vuelos.solictudAceptada(codigo);
                                lis_vuelos.registrar_vuelo(codigo, fecha, hora, piloto, avion);
                                solicitudes.getPanes().remove(a);
                            }
                           
                        }   
                    }

                }
            }
        }
    }

    @FXML
    void eliminarVuelo(ActionEvent event) {
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Eliminar vuelo ");
        alert.setHeaderText("Seguro que desea eliminar este vuelo");
        alert.setContentText("El vuelo sera eliminado de la lista de vuelos aceptados");
        
        if(vuelosAceptados.getSelectionModel().isEmpty() ){
        
        }else{              
                alert.showAndWait();
                if (alert.getResult().getText().equals("Aceptar")){
                    
                    int indice = vuelosAceptados.getSelectionModel().getSelectedIndex();
                    int codigo = vuelosAceptados.getItems().get(indice).getIdVuelo();
                    lis_vuelos.solitudReprogramar(codigo);
                    vuelosAceptados.getItems().remove(vuelosAceptados.getSelectionModel().getSelectedItem());
                }
            }
        
    }

    @FXML
    void editarVuelo(ActionEvent event) {
        this.im_hecho.setVisible(true);
        vuelosAceptados.setEditable(true);
        this.fecha.setCellFactory(TextFieldTableCell.forTableColumn());
        this.fecha.setOnEditCommit(data -> {
            Vuelo p = data.getRowValue();
            p.setFecha(data.getNewValue());
            Vuelo v1 = vuelosAceptados.getSelectionModel().getSelectedItem();
            int codigo = v1.getIdVuelo();
            String fecha = v1.getFecha();
            lis_vuelos.cambiar_fecha(fecha, codigo);
        });
        
        this.hora.setCellFactory(TextFieldTableCell.forTableColumn());
        this.hora.setOnEditCommit(data -> {
            Vuelo p = data.getRowValue();
            p.setHora(data.getNewValue());
            Vuelo v1 = vuelosAceptados.getSelectionModel().getSelectedItem();
            int codigo = v1.getIdVuelo();
            String hora = v1.getHora();
            lis_vuelos.cambiar_hora(hora, codigo);
        });
        
    }

    @FXML
    void edicion_exitosa(MouseEvent event) {

        vuelosAceptados.refresh();
        vuelosAceptados.setEditable(false);
        Vuelo v1 = vuelosAceptados.getSelectionModel().getSelectedItem();
        int codigo = v1.getIdVuelo();
        String fecha = v1.getFecha();
        String hora = v1.getHora();
        System.out.println("entre "+ fecha);
        lis_vuelos.cambiar_fecha(fecha, codigo);
        lis_vuelos.cambiar_hora(hora, codigo);
        
        
    }

    @FXML
    void visualizarFecha(ActionEvent event) {
        if (vuelo_vacia.isEmpty()){

        }else{vuelo_vacia.clear();}
        
        int can = vuelos_aceptados.size();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy ");
        LocalDate fecha_vuelo = this.calendarioVuelos.getValue();
        this.vuelosAceptados.setItems(vuelo_vacia);
        
        if (fecha_vuelo ==null){
            this.vuelosAceptados.setItems(this.vuelos_ac);
        }else{
            String fecha_date = fecha_vuelo.format(formato);
            for (int i=0; i<can;i++){
                Vuelo v1 = vuelos_aceptados.get(i);
                String fecha_arreglo = vuelos_aceptados.get(i).getFecha();
                if (fecha_arreglo.equals(fecha_date)){
                    
                    vuelo_vacia.add(v1);
                    this.vuelosAceptados.getItems().add(v1);
                    
                }

            }
        }

    }

    @FXML
    void ver_solicitud(MouseEvent event) {
        String vuelotexto = "";
        int can = this.vuelos.size(); int i =0;
        if (vuelos.isEmpty() || solicitudes.getPanes().isEmpty()){
            while (i < can){
                vuelotexto = new String(vuelos.get(i).toString());
                
                TitledPane paneSol = new TitledPane("solicitud "+(i+1), new Label(vuelotexto));
                solicitudes.getPanes().add(paneSol);
                
                Text l = new Text(vuelotexto);
                
                paneSol.setContent(l);
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
                    
                    if(t1.equals(t2)){
                        flag = false;
                    }
                
                }
                if(flag ){
                    vuelotexto = new String(vuelos.get(z).toString());
                    TitledPane paneSol = new TitledPane("solicitud "+(z+1), new Label(vuelotexto));
                    solicitudes.getPanes().add(paneSol);
                    
                }    
                
            }
        }
        this.sb_barra.setContent(solicitudes);
        this.sb_barra.setHbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        this.sb_barra.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        this.sb_barra.setPannable(true);
        
    }

    public void verifico_usuario(Usuario usu){
        if (usu == null){
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("error inicio de sección");
            alert.setHeaderText("No ha iniciado sección con ningun usuario");
            alert.setContentText("Para entrar al sistema por favor ingrese como usuario");
            alert.showAndWait();
        }
        if (usu.getTipo().equals("0")){
            System.out.println("usuario areopuerto");
            this.pan_menus.getTabs().remove(tab_aerolinea);
        }
        if (usu.getTipo().equals("1")){
            System.out.println("usuario areolinea");
            this.pan_menus.getTabs().remove(tab_aerpuerto);
        }
        if (usu.getTipo().equals("2")){
            System.out.println("usuario hangar");
            //this.pan_menus.setStyle(".tab-header-area { visibility: hidden ;}");
        }
    }

    public void cerrar(){
        try {
            FXMLLoader fxmlloader =new FXMLLoader();
            URL xmlUrl = getClass().getResource("inicio.fxml");
            fxmlloader.setLocation(xmlUrl);
            Parent root = fxmlloader.load();
            Control_inicio controlador = fxmlloader.getController();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
            
            String usuario = Control_usuario.getUsuario();
            controlador.modificar_usuario(usuario);

            Stage  mistage =(Stage) this.botonAgregar.getScene().getWindow();
            mistage.close();

            
        } catch (Exception e) {
            
        }
    }
    
    @FXML
    void aplazarVuelo(ActionEvent event) {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy ");
        int can = vuelos_aceptados.size();
        LocalDate fecha_vuelo = this.dp_fecha_viuelo.getValue();
        LocalDate fecha_aplazar = this.dp_fecha_aplazar.getValue();
        this.vuelosAceptados2.setItems(vuelo_vacia);
        for (int i=0; i<can;i++){
            Vuelo v1 = vuelos_aceptados.get(i); 
            String fecha_arreglo = vuelos_aceptados.get(i).getFecha();
            if (fecha_arreglo.equals(fecha_vuelo.format(formato))){
                vuelos_aceptados.get(i).setFecha(fecha_aplazar.format(formato));
                
            }
            vuelo_vacia.add(v1);
        }
        
        this.vuelosAceptados2.refresh();
        this.vuelosAceptados2.setItems(vuelo_vacia);
    }
    
    @FXML
    void editarSolicitud(ActionEvent event) {
        Vuelo  v1 = vuelosAceptados1.getSelectionModel().getSelectedItem();
        Piloto p1 = new Piloto(v1.getId(), v1.getNom_piloto());
        String siglas = v1.getSiglas();
        Avion a1 = new Avion();
        for (int i=0; i< aviones.size();i++){
            if(siglas.equals(aviones.get(i).getSiglas())){
                a1 = aviones.get(i);
            }
        }
        String tipo ;
        if (v1.getTipo() == 21){
            tipo ="Pasajeros";
        }else{
            tipo="Carga";
        }
        cb_piloto.setValue(p1);
        cb_avion.setValue(a1);
        cb_tipo.setValue(tipo);
        tx_hora.setText(v1.getHora());

        vuelosAceptados1.getSelectionModel().clearSelection();        
    }

    @FXML
    void solicitar_vuelo(ActionEvent event) {
        int codigo = (solicitud.get(solicitud.size()-1).getIdVuelo())+1;
        int tipoav ;
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy ");
        String piloto = cb_piloto.getSelectionModel().getSelectedItem().getNom_piloto();
        int id_piloto = cb_piloto.getSelectionModel().getSelectedItem().getId_piloto();
        String avion = cb_avion.getSelectionModel().getSelectedItem().getSiglas();
        String tipo = cb_tipo.getSelectionModel().getSelectedItem();
        if (tipo.equals("Pasajeros")){
            tipoav = 21;
        }else{
            tipoav = 22;
        }
        String fecha = dp_fecha_aerolinea.getValue().format(formato);
        String hora = tx_hora.getText();
        String estado = "Revisar";
        Vuelo v1 = new Vuelo(codigo, fecha, hora, tipoav, id_piloto, piloto, avion,estado);
        lis_vuelos.registrar_solicitud(codigo, fecha, hora, tipoav, id_piloto, piloto, avion, estado);
        System.out.println(v1);

        cb_avion.getSelectionModel().clearSelection();
        cb_piloto.getSelectionModel().clearSelection();
        cb_tipo.getSelectionModel().clearSelection();
        dp_fecha_aerolinea.setValue(null);
        tx_hora.setText("");

    }
}
      
