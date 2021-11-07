import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;

import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.Alert.AlertType;

import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.ImageView;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Control_hangar implements Initializable {
    DateTimeFormatter formato;

    List<Hangar> hangares = new ArrayList<>();
    
    List<Avion> aviones = new ArrayList<>();

    List<Avion> aviones_reser = new ArrayList<>();

    List<EntradaHangar> entradas = new ArrayList<>();

    List<Reserva> reservas = new ArrayList<>();

    List<Aerolinea> aerolineas = new ArrayList<>();
    
    Usuario usuario;

    Lista_vuelos lis_vuelos = new Lista_vuelos();


    @FXML
    private TabPane pan_menus;

    @FXML
    private Tab tab_entrada;

    @FXML
    private Tab tab_salida;

    @FXML
    private Tab tab_reservar;

    @FXML
    private ComboBox<Avion> cob_aviones;

    @FXML
    private TextArea txa_datos_avion;

    @FXML
    private TableView<Hangar> tabla_hangar;

    @FXML
    private Button btn_registrar;

    @FXML
    private TableView<Reserva> tabla_reservas;

    @FXML
    private TableColumn<Reserva, String> col_avion_reser;

    @FXML
    private TableColumn<Reserva, String> col_hangar_reser;

    @FXML
    private TableColumn<Reserva, String> col_fecha_reser;

    @FXML
    private TableColumn<Reserva, String> col_fsalida_reser;

    @FXML
    private ComboBox<Aerolinea> cob_aerolineas;

    @FXML
    private ComboBox<Avion> cob_avione_reser;

    @FXML
    private DatePicker dp_fe_ingreso;

    @FXML
    private DatePicker dp_fe_salida;

    @FXML
    private Button btn_reservar;

    @FXML
    private Button btn_editar;

    @FXML
    private ImageView im_hecho;

    @FXML
    private Button btn_reliminar;

    @FXML
    private DatePicker dp_fe_sa_reg;

    @FXML
    private TableView<EntradaHangar> tabla_entradas;

    @FXML
    private TableColumn<EntradaHangar, Integer> col_hangaroc;

    @FXML
    private TableColumn<EntradaHangar, String> col_siglas;

    @FXML
    private TableColumn<EntradaHangar, String> col_fec_ingreso;

    @FXML
    private TableColumn<EntradaHangar, String> col_hora_ingreso;

    @FXML
    private TableColumn<EntradaHangar, String> col_fec_salida;

    @FXML
    private TableColumn<EntradaHangar, String> col_hora_salida;

    @FXML
    private Button btn_retirar;

    @FXML
    private TableColumn<Hangar, Integer> col_hangar;

    @FXML
    private TableColumn<Hangar, String> col_estado;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.usuario = Control_usuario.trae_usuario();
        this.verifico_usuario(usuario);
        this.im_hecho.setVisible(false);
        formato = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        lis_vuelos.conexion_hangar();
        hangares = lis_vuelos.getHangares();
        ObservableList<Hangar> hangar = FXCollections.observableList(hangares);
        this.col_hangar.setCellValueFactory(new PropertyValueFactory<Hangar,Integer>("idHangar"));
        this.col_estado.setCellValueFactory(new PropertyValueFactory<Hangar,String>("estado"));
        this.tabla_hangar.setItems(hangar);   
        

        lis_vuelos.conexion_avion();
        aviones = lis_vuelos.getAviones();
        ObservableList<Avion> avion = FXCollections.observableList(aviones);
        cob_aviones.setItems(avion);

        lis_vuelos.conexion_aerolinea();
        aerolineas = lis_vuelos.getAerolineas();
        ObservableList<Aerolinea> aerolinea = FXCollections.observableList(aerolineas);
        cob_aerolineas.setItems(aerolinea);
        
        lis_vuelos.conexion_entradas();
        entradas = lis_vuelos.getEntradas();
        ObservableList<EntradaHangar> entrada = FXCollections.observableList(entradas);
        this.col_hangaroc.setCellValueFactory(new PropertyValueFactory<>("idHangar"));
        this.col_siglas.setCellValueFactory(new PropertyValueFactory<>("avion"));
        this.col_hora_ingreso.setCellValueFactory(new PropertyValueFactory<>("hora_en"));
        this.col_fec_ingreso.setCellValueFactory(new PropertyValueFactory<>("fecha_en"));
        this.col_fec_salida.setCellValueFactory(new PropertyValueFactory<>("fecha_sa"));
        this.col_hora_salida.setCellValueFactory(new PropertyValueFactory<>("hora_sa"));
        this.tabla_entradas.setItems(entrada);

        lis_vuelos.conexion_reserva();
        reservas = lis_vuelos.getReservas();
        ObservableList<Reserva> reserva = FXCollections.observableList(reservas);
        this.col_avion_reser.setCellValueFactory(new PropertyValueFactory<>("avion"));
        this.col_hangar_reser.setCellValueFactory(new PropertyValueFactory<>("hangar"));
        this.col_fecha_reser.setCellValueFactory(new PropertyValueFactory<>("fecha_ingreso"));
        this.col_fsalida_reser.setCellValueFactory(new PropertyValueFactory<>("fecha_salida"));
        this.tabla_reservas.setItems(reserva);
    }
    
    @FXML
    void Escoger_avion(ActionEvent event) {
        int indice = cob_aviones.getSelectionModel().getSelectedIndex();
        this.txa_datos_avion.setText(aviones.get(indice).imprimir());
    }

    @FXML
    void registrar_salida(ActionEvent event) {
        int costo = 8000; // por hora
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Retirar avión ");
        alert.setHeaderText("Seguro que desea retira este avión");
        alert.setContentText("El avión sera eliminado de la lista de aviones aceptados");
        
        if(tabla_entradas.getSelectionModel().isEmpty() ){
        
        }else{              
            alert.showAndWait();
            if (alert.getResult().getText().equals("Aceptar")){
                
                EntradaHangar e1 = tabla_entradas.getSelectionModel().getSelectedItem();
                String ingreso = e1.getFecha_en().substring(0,1);
                String salida = e1.getFecha_sa().substring(0,2);
                int fecha_sa= Integer.parseInt(salida);
                int fecha_en= Integer.parseInt(ingreso);
                
                int horas = (fecha_sa-fecha_en)*24;
                
                String en = e1.getHora_en().substring(0,2);
                String sa = e1.getHora_sa().substring(0,2);

                int hora_en = Integer.parseInt(en);
                int hora_sa = Integer.parseInt(sa);
                
                int hora_total  = Math.abs(horas- Math.abs((hora_en -hora_sa)));
                int costo_total = costo * hora_total;

                String factura = "         Factura Hangar"+"\n"+"\n"+
                                 "         Datos del Registro:     " +"\n"+"\n"+ "         siglas:     "+e1.getAvion()+"\n"+"         Hangar:     "+e1.getIdHangar()+"\n"+
                                 "         Fecha de entrada:        "+e1.getFecha_en()+"\n"+"         Fecha de Salida:     "+e1.getFecha_sa()+"\n"+
                                 "         Tiempo de Estadia:       "+ hora_total+" horas"+"\n"+"\n"+ "          COSTO: "+costo_total; 
                
                final Stage dialog = new Stage();
                dialog.initModality(Modality.APPLICATION_MODAL);
                //dialog.initOwner(primaryStage);
                VBox dialogVbox = new VBox(20);
                dialogVbox.getChildren().add(new Text(factura));
                Scene dialogScene = new Scene(dialogVbox, 300, 200);
                dialog.setScene(dialogScene);
                dialog.show();
                lis_vuelos.Registrar_salida(e1.getIdHangar());
                lis_vuelos.hangar_libre(e1.getIdHangar());
                tabla_entradas.getItems().remove(tabla_entradas.getSelectionModel().getSelectedItem());
            }
            }
            
        
    }

    @FXML
    void Eliminar_reserva(ActionEvent event) {
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Eliminar Reserva ");
        alert.setHeaderText("Seguro que desea cancelar esta reserva");
        alert.setContentText("La reserva sera eliminada y perdera su cupo");
        
        if(tabla_reservas.getSelectionModel().isEmpty() ){
        
        }else{              
            alert.showAndWait();
            if (alert.getResult().getText().equals("Aceptar")){
                Reserva r1 = this.tabla_reservas.getSelectionModel().getSelectedItem();
                String hangar = r1.getHangar();
                lis_vuelos.modificar_reserva(hangar);
                lis_vuelos.hangar_libre(Integer.parseInt(hangar));
                this.tabla_reservas.getItems().remove(r1);
            }
        }
    }

    @FXML
    void Reservar_hangar(ActionEvent event) {
        int indice = cob_avione_reser.getSelectionModel().getSelectedIndex();
        int ind1 = cob_aerolineas.getSelectionModel().getSelectedIndex();
        if (indice != -1 && ind1 !=-1 && dp_fe_ingreso.getValue() !=null && dp_fe_salida.getValue()  != null){
            String fecha_in = this.dp_fe_ingreso.getValue().format(formato);
            String fecha_sa = this.dp_fe_salida.getValue().format(formato);
            Hangar hangar = this.busca_hangar();
            String v1 = aviones.get(indice).getSiglas();
            String h1 =""+ hangar.getIdHangar();
            
            System.out.println("antes " +lis_vuelos.getHangares() +"\n");
            Reserva r1 = new Reserva(v1, h1,fecha_in,fecha_sa);
            
            lis_vuelos.hangar_ocuado(Integer.parseInt(h1));
            this.hangares.clear();
            lis_vuelos.conexion_hangar();
            this.hangares = lis_vuelos.getHangares();
            System.out.println("despues " +lis_vuelos.getHangares() +"\n");
            
            lis_vuelos.reservar_hangar(h1, v1, fecha_in, fecha_sa);
            this.tabla_reservas.getItems().add(r1);
        }else{
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Campos Vacios");
            alert.setHeaderText("No estan seleccionados todos los campos");
            alert.showAndWait();
        }
    }

    @FXML
    void editar_reserva(ActionEvent event) {
        this.im_hecho.setVisible(true);
        this.tabla_reservas.setEditable(true);
                
        this.col_avion_reser.setCellFactory(TextFieldTableCell.forTableColumn());
        this.col_avion_reser.setOnEditCommit(data -> {
            Reserva p = data.getRowValue();
            p.setAvion(data.getNewValue());
            String avion = tabla_reservas.getSelectionModel().getSelectedItem().getAvion();
            String hangar = tabla_reservas.getSelectionModel().getSelectedItem().getHangar();
            String fecha_en = tabla_reservas.getSelectionModel().getSelectedItem().getFecha_ingreso();
            String fecha_sa = tabla_reservas.getSelectionModel().getSelectedItem().getFecha_salida();
            
            lis_vuelos.modificar_reserva(hangar);
            lis_vuelos.hangar_libre(Integer.parseInt(hangar));
            lis_vuelos.reservar_hangar(hangar, avion, fecha_en, fecha_sa);
            lis_vuelos.hangar_ocuado(Integer.parseInt(hangar));
        });
        this.col_hangar_reser.setCellFactory(TextFieldTableCell.forTableColumn());
        this.col_hangar_reser.setOnEditCommit(data ->{
            Reserva p = data.getRowValue();
            p.setHangar(data.getNewValue());
            String avion = tabla_reservas.getSelectionModel().getSelectedItem().getAvion();
            String hangar = tabla_reservas.getSelectionModel().getSelectedItem().getHangar();
            String fecha_en = tabla_reservas.getSelectionModel().getSelectedItem().getFecha_ingreso();
            String fecha_sa = tabla_reservas.getSelectionModel().getSelectedItem().getFecha_salida();
            
            lis_vuelos.modificar_reserva(hangar);
            lis_vuelos.hangar_libre(Integer.parseInt(hangar));
            lis_vuelos.reservar_hangar(hangar, avion, fecha_en, fecha_sa);
            lis_vuelos.hangar_ocuado(Integer.parseInt(hangar));
        });
        this.col_fecha_reser.setCellFactory(TextFieldTableCell.forTableColumn());
        this.col_fecha_reser.setOnEditCommit(data ->{
            Reserva p = data.getRowValue();
            p.setFecha_ingreso(data.getNewValue());
            String avion = tabla_reservas.getSelectionModel().getSelectedItem().getAvion();
            String hangar = tabla_reservas.getSelectionModel().getSelectedItem().getHangar();
            String fecha_en = tabla_reservas.getSelectionModel().getSelectedItem().getFecha_ingreso();
            String fecha_sa = tabla_reservas.getSelectionModel().getSelectedItem().getFecha_salida();
            
            lis_vuelos.modificar_reserva(hangar);
            lis_vuelos.hangar_libre(Integer.parseInt(hangar));
            lis_vuelos.reservar_hangar(hangar, avion, fecha_en, fecha_sa);
            lis_vuelos.hangar_ocuado(Integer.parseInt(hangar));
        });
        this.col_fsalida_reser.setCellFactory(TextFieldTableCell.forTableColumn());
        this.col_fsalida_reser.setOnEditCommit(data ->{
            Reserva p = data.getRowValue();
            p.setFecha_salida(data.getNewValue());
            String avion = tabla_reservas.getSelectionModel().getSelectedItem().getAvion();
            String hangar = tabla_reservas.getSelectionModel().getSelectedItem().getHangar();
            String fecha_en = tabla_reservas.getSelectionModel().getSelectedItem().getFecha_ingreso();
            String fecha_sa = tabla_reservas.getSelectionModel().getSelectedItem().getFecha_salida();
            
            lis_vuelos.modificar_reserva(hangar);
            lis_vuelos.hangar_libre(Integer.parseInt(hangar));
            lis_vuelos.reservar_hangar(hangar, avion, fecha_en, fecha_sa);
            lis_vuelos.hangar_ocuado(Integer.parseInt(hangar));
        });
        
    }

    @FXML
    void edición_exitosa(MouseEvent event) {
        this.tabla_reservas.setEditable(false);
        im_hecho.setVisible(false);
    }

    @FXML
    void parar_edicion(InputMethodEvent event) {
        System.out.println("entre jijiji");
    }

    @FXML
    void registrar_entrada(ActionEvent event) {
        
        int indice = cob_aviones.getSelectionModel().getSelectedIndex();
        if (indice != -1 && dp_fe_sa_reg.getValue() != null){
            Avion a1 = aviones.get(indice);
            Hangar h1 = new Hangar();
            
            if (tabla_hangar.getSelectionModel().getSelectedIndex() != -1 ){
                
                int  indi_han = tabla_hangar.getSelectionModel().getSelectedIndex();
                h1 = hangares.get(indi_han);
            }else{
                if (this.busca_hangar()!= null){
                    System.out.println("busca");
                    h1 = this.busca_hangar();
                }
            }
            if (h1.getEstado().equals("Ocupado   ")){
                System.out.println("entre");
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Hangar no disponible");
                alert.setHeaderText("El hangar escogido ya se encuentra ocupado");
                alert.setContentText("puede escoger otro o permita que se busque automaticamente");
                alert.showAndWait();
            }
            int hangar = h1.getIdHangar();
            String avion = a1.getSiglas();
            String hora_en = setHoraActual();
            String fecha_en = setFechaActual();
            String hora_sa = "23:57";
            String fecha_sa = dp_fe_sa_reg.getValue().format(formato);
            String admin = h1.getAdministrador();

            lis_vuelos.Registrar_entrada(hangar, avion, hora_en, fecha_en,fecha_sa,hora_sa,admin);
            lis_vuelos.hangar_ocuado(hangar);
            lis_vuelos.conexion_hangar(); lis_vuelos.conexion_entradas();
            this.tabla_hangar.getItems().clear();this.tabla_entradas.getItems().clear();
            lis_vuelos.conexion_entradas();
            entradas = lis_vuelos.getEntradas();
            ObservableList<EntradaHangar> entrada = FXCollections.observableList(entradas);
            lis_vuelos.conexion_hangar();
            hangares = lis_vuelos.getHangares();
            ObservableList<Hangar> hangar1 = FXCollections.observableList(hangares);
            this.tabla_hangar.setItems(hangar1);
            this.tabla_entradas.setItems(entrada);
        }else{
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Campos Vacios");
            alert.setHeaderText("No estan seleccionado el campo de avion o fecha");
            alert.showAndWait();
        }
        
        
    }

    public Hangar busca_hangar (){
        
        Hangar h1 = new Hangar();
        int can = hangares.size(); boolean encontre = true;
        for (int i=0; i<can ; i++){
           
            if (hangares.get(i).getEstado().equals("Libre     ")){
                h1 = hangares.get(i); encontre= false;
                i=can;
                
            }
        }
        if (!encontre){
            return h1;
        }else{
            return null;
        }
    }

    public  String setHoraActual() {
        Calendar calendario = new GregorianCalendar();
        int hora_actual = calendario.get(Calendar.HOUR_OF_DAY);
        int minuto_actual = calendario.get(Calendar.MINUTE);
        
        int minuto = minuto_actual;
        int hora = hora_actual;

        String horaActual = ""+hora+":"+minuto;
        return horaActual;
    }

    public String setFechaActual(){
        Calendar calendario = new GregorianCalendar();
        int dia = calendario.get(Calendar.DAY_OF_MONTH);
        int mes = calendario.get(Calendar.MONTH);
        int  año = calendario.get(Calendar.YEAR);
        
        String fecha = ""+dia+"/"+ mes+"/"+año;
        
        return fecha;
    }

    @FXML
    void traer_aviones(ActionEvent event) {
        String aero_linea ;
        
        if (cob_aerolineas.getSelectionModel().getSelectedItem() == null){
            
        }else{
            
            aero_linea = cob_aerolineas.getSelectionModel().getSelectedItem().getNom_aerolinea();
            System.out.println(aero_linea);
            lis_vuelos.avion_aerolinea(aero_linea);
            aviones_reser = lis_vuelos.getAviones_aero();
            ObservableList<Avion> avion_re = FXCollections.observableList(aviones_reser);
            cob_avione_reser.setItems(avion_re);
        }
        
    }

    public void verifico_usuario(Usuario usu){
        if (usu.getTipo().equals("0")){
            
            
        }
        if (usu.getTipo().equals("1")){
            //System.out.println("usuario areolinea");
            this.pan_menus.getTabs().remove(tab_entrada);
            this.pan_menus.getTabs().remove(tab_salida);
        }
        if (usu.getTipo().equals("2")){
            //System.out.println("usuario hangar");
            this.pan_menus.getTabs().remove(tab_reservar);
            
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

            Stage  mistage =(Stage) this.btn_editar.getScene().getWindow();
            mistage.close();

            
        } catch (Exception e) {
            
        }
    }



}
