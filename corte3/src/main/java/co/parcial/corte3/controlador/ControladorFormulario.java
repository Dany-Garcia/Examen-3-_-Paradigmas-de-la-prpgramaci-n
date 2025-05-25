package co.parcial.corte3.controlador;

import co.parcial.corte3.modelo.Automovil;
import co.parcial.corte3.modelo.Camion;
import co.parcial.corte3.modelo.Motocicleta;
import co.parcial.corte3.modelo.Vehiculo;
import co.parcial.corte3.servicios.ImplementacionCRUD;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

/**
 * Controlador principal del formulario de gestión de vehículos en la interfaz
 * JavaFX.
 * 
 * <p>
 * Esta clase actúa como intermediario entre la interfaz gráfica definida en el
 * archivo FXML y la lógica de negocio, utilizando una implementación de CRUD
 * para gestionar vehículos de distintos tipos: {@code Automóvil},
 * {@code Motocicleta} y {@code Camión}.
 * </p>
 *
 * <p>
 * Funcionalidades principales de esta clase:
 * </p>
 * <ul>
 * <li>Crear, leer, actualizar y eliminar vehículos (operaciones CRUD).</li>
 * <li>Serializar y deserializar la información de vehículos en formato
 * binario.</li>
 * <li>Filtrar, buscar y visualizar vehículos en una tabla dinámica.</li>
 * <li>Mostrar/ocultar campos dinámicos en el formulario dependiendo del tipo de
 * vehículo.</li>
 * </ul>
 *
 * <p>
 * La clase está asociada a una vista definida en FXML y es invocada
 * automáticamente por JavaFX mediante el mecanismo de inyección con
 * {@code @FXML}.
 * </p>
 *
 * @author García Figueroa Daniel Santiago
 * @since 25/05/2025
 * @see javafx.fxml.Initializable
 * @see ImplementacionCRUD
 * @see Vehiculo
 */
public class ControladorFormulario implements Initializable {

	/**
	 * Botón para eliminar un vehículo seleccionado.
	 */
	@FXML
	private Button btDelete;

	/**
	 * Botón para crear un nuevo vehículo.
	 */
	@FXML
	private Button bttCreate;

	/** Botón para deserializar los datos almacenados. */
	@FXML
	private Button bttDeserealizar;

	/** Botón para leer (buscar) un vehículo específico por su placa. */
	@FXML
	private Button bttRead;

	/** Botón para serializar los datos de los vehículos registrados. */
	@FXML
	private Button bttSerializar;

	/** Botón para actualizar un vehículo existente. */
	@FXML
	private Button bttUpdate;

	/** Columna que muestra el número de placa de cada vehículo. */
	@FXML
	private TableColumn<Vehiculo, String> column1;

	/**
	 * Columna de la tabla que muestra la marca del vehículo.
	 */
	@FXML
	private TableColumn<Vehiculo, String> column2;

	/**
	 * Columna de la tabla que muestra el modelo del vehículo.
	 */
	@FXML
	private TableColumn<Vehiculo, String> column3;

	/** Columna que muestra el peso del vehículo en kilogramos. */
	@FXML
	private TableColumn<Vehiculo, String> column4;

	/**
	 * Columna dinámica que muestra un atributo específico según el tipo de
	 * vehículo: - Estilo (para Automóviles) - Cilindraje (para Motocicletas) -
	 * Capacidad de carga (para Camiones)
	 */
	@FXML
	private TableColumn<Vehiculo, String> column5;

	/** Tabla principal que despliega los vehículos registrados en el sistema. */
	@FXML
	private TableView<Vehiculo> tblView;

	/**
	 * ComboBox para seleccionar el tipo de vehículo a registrar (Automóvil,
	 * Motocicleta, Camión).
	 */
	@FXML
	private ComboBox<String> comboVehiculo;

	/** ComboBox para filtrar los vehículos en la tabla según su tipo. */
	@FXML
	private ComboBox<String> comboTipoVehiculoView;

	/**
	 * Etiqueta para el campo "Cilindraje del Motor", visible solo para
	 * Motocicletas.
	 */
	@FXML
	private Label lblCilindrajeMotor;

	/** Etiqueta para el campo "Capacidad de Carga", visible solo para Camiones. */
	@FXML
	private Label lblCpdCarga;

	/** Etiqueta para el campo "Estilo", visible solo para Automóviles. */
	@FXML
	private Label lblEstilo;

	/** Etiqueta de encabezado de la sección de gestión de vehículos. */
	@FXML
	private Label lblGestionVehiculos;

	/** Etiqueta para el campo "Marca". */
	@FXML
	private Label lblMacra;

	/** Etiqueta para el campo "Modelo". */
	@FXML
	private Label lblModelo;

	/** Etiqueta para el campo "Peso". */
	@FXML
	private Label lblPeso;

	/** Etiqueta para el campo "Placa". */
	@FXML
	private Label lblPlaca;

	/** Etiqueta genérica para el tipo de vehículo. */
	@FXML
	private Label lblVehiculo;

	/** Campo de texto para ingresar la placa a buscar. */
	@FXML
	private TextField txtBuscador;

	/**
	 * Campo de texto para ingresar el cilindraje del motor. Visible solo si el tipo
	 * es Motocicleta.
	 */
	@FXML
	private TextField txtCilindrajeMotor;

	/**
	 * Campo de texto para ingresar la capacidad de carga. Visible solo si el tipo
	 * es Camión.
	 */
	@FXML
	private TextField txtCpdCarga;

	/**
	 * Campo de texto para ingresar el estilo del automóvil. Visible solo si el tipo
	 * es Automóvil.
	 */
	@FXML
	private TextField txtEstilo;

	/** Campo de texto para ingresar la marca del vehículo. */
	@FXML
	private TextField txtMarca;

	/** Campo de texto para ingresar el modelo del vehículo. */
	@FXML
	private TextField txtModelo;

	/** Campo de texto para ingresar el peso del vehículo. */
	@FXML
	private TextField txtPeso;

	/** Campo de texto para ingresar la placa del vehículo. */
	@FXML
	private TextField txtPlaca;

	/**
	 * Lista observable de vehículos que se muestra en la tabla. Permite mantener
	 * sincronizada la vista con los datos almacenados en el sistema.
	 */
	ObservableList<Vehiculo> vehiculos;

	/**
	 * Servicio de acceso a datos que implementa operaciones CRUD (create, read,
	 * readAll, update, delete) y manejo de persistencia (serializar y
	 * deserializar). Encapsula la lógica de negocio para manipular objetos del tipo
	 * {@code Vehiculo}.
	 */
	ImplementacionCRUD ic;

	/**
	 * Inicializa la interfaz gráfica del formulario una vez que todos los elementos
	 * han sido cargados por JavaFX. Este método se ejecuta automáticamente al
	 * cargar el archivo FXML y al implementar la interfaz
	 * {@link javafx.fxml.Initializable}.
	 *
	 * <p>
	 * Las principales tareas de inicialización incluyen:
	 * </p>
	 * <ul>
	 * <li>Instanciar el servicio {@link ImplementacionCRUD} con capacidad
	 * inicial.</li>
	 * <li>Cargar todos los vehículos existentes desde el CRUD y mostrarlos en la
	 * tabla.</li>
	 * <li>Inicializar los elementos {@code ComboBox} con los tipos de vehículo
	 * disponibles.</li>
	 * <li>Configurar las columnas de la tabla para mostrar propiedades dinámicas
	 * según el tipo de vehículo.</li>
	 * </ul>
	 *
	 * @param location  La ubicación del archivo FXML si se especificó alguna (puede
	 *                  ser {@code null}).
	 * @param resources El recurso de localización utilizado para
	 *                  internacionalización (puede ser {@code null}).
	 * 
	 * @see javafx.fxml.Initializable
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {

		ic = new ImplementacionCRUD(10);

		// Cargar vehículos desde el CRUD al iniciar
		vehiculos = FXCollections.observableArrayList(ic.readAll());
		tblView.setItems(vehiculos);

		comboVehiculo.getItems().addAll("Automóvil", "Motocicleta", "Camión");
		comboTipoVehiculoView.getItems().addAll("Todos", "Automóvil", "Motocicleta", "Camión");

		column1.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getPlaca()));
		column2.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getMarca()));
		column3.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getModelo()));
		column4.setCellValueFactory(cell -> new SimpleStringProperty(String.valueOf(cell.getValue().getPeso())));
		column5.setCellValueFactory(cell -> {
			Vehiculo v = cell.getValue();
			if (v instanceof Automovil) {
				return new SimpleStringProperty("Estilo: " + ((Automovil) v).getEstilo());
			} else if (v instanceof Motocicleta) {
				return new SimpleStringProperty("Cilindraje: " + ((Motocicleta) v).getCilindrajeMotor() + " cc");
			} else if (v instanceof Camion) {
				return new SimpleStringProperty("Carga: " + ((Camion) v).getCapacidadCarga() + " kg");
			} else {
				return new SimpleStringProperty("N/A");
			}
		});
	}

	/**
	 * Maneja el evento cuando el usuario selecciona un tipo de vehículo en el
	 * {@code ComboBox comboVehiculo}. Este método ajusta dinámicamente la
	 * visibilidad de los campos específicos del tipo de vehículo seleccionado.
	 *
	 * <p>
	 * El comportamiento específico es:
	 * </p>
	 * <ul>
	 * <li>Para {@code Automóvil}: se muestran los campos de estilo.</li>
	 * <li>Para {@code Motocicleta}: se muestran los campos de cilindraje.</li>
	 * <li>Para {@code Camión}: se muestran los campos de capacidad de carga.</li>
	 * </ul>
	 * 
	 * <p>
	 * Antes de mostrar campos, se asegura de limpiar y ocultar todos los
	 * específicos.
	 * </p>
	 *
	 * @param event El evento de acción generado por la selección del
	 *              {@code ComboBox}.
	 * @see javafx.event.ActionEvent
	 * @see javafx.scene.control.ComboBox
	 */
	@FXML
	void onTipoVehiculoSeleccionado(ActionEvent event) {
		String tipoSeleccionado = comboVehiculo.getValue();

		// Oculta todos los campos específicos primero
		lblEstilo.setVisible(false);
		txtEstilo.setVisible(false);
		lblCilindrajeMotor.setVisible(false);
		txtCilindrajeMotor.setVisible(false);
		lblCpdCarga.setVisible(false);
		txtCpdCarga.setVisible(false);

		// Limpia los campos siempre
		txtEstilo.clear();
		txtCilindrajeMotor.clear();
		txtCpdCarga.clear();

		// Mostrar solo los necesarios
		if (tipoSeleccionado == null)
			return;

		switch (tipoSeleccionado) {
		case "Automóvil":
			lblEstilo.setVisible(true);
			txtEstilo.setVisible(true);
			break;
		case "Motocicleta":
			lblCilindrajeMotor.setVisible(true);
			txtCilindrajeMotor.setVisible(true);
			break;
		case "Camión":
			lblCpdCarga.setVisible(true);
			txtCpdCarga.setVisible(true);
			break;
		}
	}

	/**
	 * Filtra y carga en la tabla los vehículos según el tipo seleccionado en
	 * {@code comboTipoVehiculoView}.
	 *
	 * <p>
	 * Este método soporta las siguientes opciones de filtrado:
	 * </p>
	 * <ul>
	 * <li><b>Todos:</b> muestra todos los vehículos registrados.</li>
	 * <li><b>Automóvil, Motocicleta o Camión:</b> filtra los vehículos según la
	 * clase correspondiente.</li>
	 * </ul>
	 *
	 * <p>
	 * El resultado se refleja en tiempo real en la tabla {@code tblView}.
	 * </p>
	 *
	 * @param event Evento generado al hacer clic en el botón de búsqueda o
	 *              seleccionar un filtro.
	 * @see javafx.event.ActionEvent
	 * @see javafx.collections.ObservableList
	 */
	@FXML
	void onBuscar(ActionEvent event) {
		String tipoSeleccionado = comboTipoVehiculoView.getValue();
		Vehiculo[] resultados;

		if (tipoSeleccionado == null || tipoSeleccionado.equalsIgnoreCase("Todos")) {
			resultados = ic.readAll();
		} else {
			Class<?> tipo;

			switch (tipoSeleccionado) {
			case "Automóvil":
				tipo = Automovil.class;
				break;
			case "Motocicleta":
				tipo = Motocicleta.class;
				break;
			case "Camión":
				tipo = Camion.class;
				break;
			default:
				tipo = Vehiculo.class;
			}

			resultados = ic.readByTipo(tipo);
		}

		tblView.setItems(FXCollections.observableArrayList(resultados));
		tblView.setVisible(true);
	}

	// OPERACIONES CRUD:

	/**
	 * Crea un nuevo vehículo a partir de los datos ingresados en el formulario.
	 * 
	 * <p>
	 * Este método valida los campos obligatorios comunes (placa, marca, modelo y
	 * peso), así como los campos específicos según el tipo de vehículo seleccionado
	 * (automóvil, motocicleta o camión). Si los datos son válidos, se crea una
	 * instancia del vehículo correspondiente y se persiste utilizando el servicio
	 * CRUD.
	 * 
	 * <p>
	 * También realiza las siguientes acciones:
	 * </p>
	 * <ul>
	 * <li>Verifica que la placa no esté duplicada.</li>
	 * <li>Realiza conversiones numéricas seguras para los campos de peso,
	 * cilindraje y capacidad de carga.</li>
	 * <li>Actualiza la lista observable de vehículos para reflejar el cambio en la
	 * tabla.</li>
	 * <li>Muestra mensajes informativos o de advertencia mediante ventanas
	 * emergentes (alerts).</li>
	 * </ul>
	 * 
	 * @param event el evento de acción que dispara la creación del vehículo,
	 *              generalmente al hacer clic en un botón.
	 * 
	 * @throws NumberFormatException    si los valores numéricos ingresados (peso,
	 *                                  cilindraje, carga) no son válidos.
	 * @throws IllegalArgumentException si alguno de los valores numéricos es
	 *                                  negativo.
	 * @throws RuntimeException         si ocurre un error inesperado durante la
	 *                                  creación o persistencia del vehículo.
	 * 
	 * 
	 */
	@FXML
	void create(ActionEvent event) {
		Alert alert = new Alert(AlertType.INFORMATION);

		try {
			String tipo = comboVehiculo.getValue();
			if (tipo == null) {
				alert.setAlertType(AlertType.WARNING);
				alert.setContentText("Debes seleccionar un tipo de vehículo.");
				alert.show();
				return;
			}

			// Validar campos comunes
			String placa = txtPlaca.getText().trim();
			String marca = txtMarca.getText().trim();
			String modelo = txtModelo.getText().trim();
			String pesoTexto = txtPeso.getText().trim();

			if (placa.isEmpty() || marca.isEmpty() || modelo.isEmpty() || pesoTexto.isEmpty()) {
				alert.setAlertType(AlertType.WARNING);
				alert.setContentText("Placa, Marca, Modelo y Peso son obligatorios.");
				alert.show();
				return;
			}

			// Validar duplicado de placa con lista sincronizada
			boolean placaExiste = vehiculos.stream().anyMatch(v -> v.getPlaca().equalsIgnoreCase(placa));
			if (placaExiste) {
				alert.setAlertType(AlertType.WARNING);
				alert.setContentText("Ya existe un vehículo con esta placa.");
				alert.show();
				return;
			}

			double peso;
			try {
				peso = Double.parseDouble(pesoTexto);
				if (peso < 0)
					throw new IllegalArgumentException("El peso no puede ser negativo.");
			} catch (NumberFormatException e) {
				alert.setAlertType(AlertType.WARNING);
				alert.setContentText("El campo 'Peso' debe ser un número válido.");
				alert.show();
				return;
			}

			Vehiculo nuevoVehiculo = null;

			switch (tipo) {
			case "Automóvil":
				String estilo = txtEstilo.getText().trim();
				if (estilo.isEmpty()) {
					alert.setAlertType(AlertType.WARNING);
					alert.setContentText("El estilo del automóvil es obligatorio.");
					alert.show();
					return;
				}
				nuevoVehiculo = new Automovil(placa, marca, modelo, peso, estilo);
				break;

			case "Motocicleta":
				String cilindrajeTexto = txtCilindrajeMotor.getText().trim();
				if (cilindrajeTexto.isEmpty()) {
					alert.setAlertType(AlertType.WARNING);
					alert.setContentText("El cilindraje de la motocicleta es obligatorio.");
					alert.show();
					return;
				}
				double cilindraje;
				try {
					cilindraje = Double.parseDouble(cilindrajeTexto);
					if (cilindraje < 0)
						throw new IllegalArgumentException("El cilindraje no puede ser negativo.");
				} catch (NumberFormatException e) {
					alert.setAlertType(AlertType.WARNING);
					alert.setContentText("El campo 'Cilindraje' debe ser un número válido.");
					alert.show();
					return;
				}
				nuevoVehiculo = new Motocicleta(placa, marca, modelo, peso, cilindraje);
				break;

			case "Camión":
				String cargaTexto = txtCpdCarga.getText().trim();
				if (cargaTexto.isEmpty()) {
					alert.setAlertType(AlertType.WARNING);
					alert.setContentText("La capacidad de carga del camión es obligatoria.");
					alert.show();
					return;
				}
				double carga;
				try {
					carga = Double.parseDouble(cargaTexto);
					if (carga < 0)
						throw new IllegalArgumentException("La capacidad de carga no puede ser negativa.");
				} catch (NumberFormatException e) {
					alert.setAlertType(AlertType.WARNING);
					alert.setContentText("El campo 'Capacidad de carga' debe ser un número válido.");
					alert.show();
					return;
				}
				nuevoVehiculo = new Camion(placa, marca, modelo, peso, carga);
				break;
			}

			// Persistir
			String mensaje = ic.create(nuevoVehiculo);

			// Sincronizar lista
			vehiculos.setAll(ic.readAll());

			alert.setAlertType(AlertType.INFORMATION);
			alert.setContentText("Vehículo creado exitosamente.\n" + mensaje);
			alert.show();

			clear();

		} catch (Exception e) {
			alert.setAlertType(AlertType.WARNING);
			alert.setContentText("Error inesperado: " + e.getMessage());
			alert.show();
		}
	}

	/**
	 * Busca un vehículo por su número de placa e informa al usuario del resultado.
	 * 
	 * <p>
	 * Este método obtiene la placa ingresada en el campo de búsqueda, y si no está
	 * vacía, intenta recuperar el vehículo correspondiente desde el servicio CRUD.
	 * Si se encuentra, llena el formulario con los datos del vehículo y ajusta
	 * dinámicamente los campos visibles según su tipo (Automóvil, Motocicleta o
	 * Camión). También selecciona visualmente el vehículo en la tabla si está
	 * presente.
	 * </p>
	 * 
	 * <p>
	 * Si no se encuentra ningún vehículo con la placa especificada, se muestra una
	 * advertencia. En caso de errores durante la operación, se notifica mediante
	 * una alerta de error.
	 * </p>
	 * 
	 * @param event el evento de acción que dispara la búsqueda, típicamente un clic
	 *              en un botón.
	 * 
	 * @throws RuntimeException si ocurre un error inesperado durante la búsqueda
	 *                          del vehículo.
	 * 
	 */
	@FXML
	void read(ActionEvent event) {
		Alert alert;
		try {
			String placaBusqueda = txtBuscador.getText().trim();

			if (placaBusqueda.isEmpty()) {
				alert = new Alert(Alert.AlertType.WARNING);
				alert.setContentText("Debes ingresar una placa para buscar.");
				alert.show();
				return;
			}

			// Buscar el vehículo por placa
			Vehiculo encontrado = ic.read(placaBusqueda);

			if (encontrado != null) {
				// Llenar los campos con la información del vehículo encontrado
				txtPlaca.setText(encontrado.getPlaca());
				txtMarca.setText(encontrado.getMarca());
				txtModelo.setText(encontrado.getModelo());
				txtPeso.setText(String.valueOf(encontrado.getPeso()));

				// Seleccionar el tipo en comboVehiculo y mostrar campos específicos
				if (encontrado instanceof Automovil) {
					comboVehiculo.setValue("Automóvil");
					txtEstilo.setText(((Automovil) encontrado).getEstilo());

					lblEstilo.setVisible(true);
					txtEstilo.setVisible(true);

					lblCilindrajeMotor.setVisible(false);
					txtCilindrajeMotor.setVisible(false);
					lblCpdCarga.setVisible(false);
					txtCpdCarga.setVisible(false);
				} else if (encontrado instanceof Motocicleta) {
					comboVehiculo.setValue("Motocicleta");
					txtCilindrajeMotor.setText(String.valueOf(((Motocicleta) encontrado).getCilindrajeMotor()));

					lblEstilo.setVisible(false);
					txtEstilo.setVisible(false);

					lblCilindrajeMotor.setVisible(true);
					txtCilindrajeMotor.setVisible(true);

					lblCpdCarga.setVisible(false);
					txtCpdCarga.setVisible(false);
				} else if (encontrado instanceof Camion) {
					comboVehiculo.setValue("Camión");
					txtCpdCarga.setText(String.valueOf(((Camion) encontrado).getCapacidadCarga()));

					lblEstilo.setVisible(false);
					txtEstilo.setVisible(false);

					lblCilindrajeMotor.setVisible(false);
					txtCilindrajeMotor.setVisible(false);

					lblCpdCarga.setVisible(true);
					txtCpdCarga.setVisible(true);
				}

				// Seleccionar el vehículo en la tabla
				if (vehiculos.contains(encontrado)) {
					tblView.getSelectionModel().select(encontrado);
					tblView.scrollTo(encontrado);
				}

				// Mostrar alerta con información del vehículo
				String mensaje = String.format("Placa: %s\nMarca: %s\nModelo: %s\nPeso: %.2f", encontrado.getPlaca(),
						encontrado.getMarca(), encontrado.getModelo(), encontrado.getPeso());

				alert = new Alert(Alert.AlertType.INFORMATION);
				alert.setTitle("Vehículo encontrado");
				alert.setHeaderText("Detalles del vehículo");
				alert.setContentText(mensaje);
				alert.showAndWait();

			} else {
				alert = new Alert(Alert.AlertType.WARNING);
				alert.setContentText("No se encontró un vehículo con esa placa.");
				alert.show();
			}

		} catch (Exception e) {
			alert = new Alert(Alert.AlertType.ERROR);
			alert.setContentText("Error inesperado: " + e.getMessage());
			alert.show();
		}
	}

	/**
	 * Actualiza la información de un vehículo previamente seleccionado en la tabla.
	 * 
	 * <p>
	 * Este método permite modificar los atributos de un vehículo existente, excepto
	 * su número de placa, que actúa como identificador único. El usuario debe
	 * seleccionar primero un vehículo en la tabla. Luego, se validan los campos
	 * comunes (marca, modelo, peso) y los campos específicos del tipo de vehículo
	 * (Automóvil, Motocicleta o Camión). Si los datos son válidos, se crea una
	 * nueva instancia del vehículo con los nuevos valores y se actualiza mediante
	 * el servicio CRUD.
	 * </p>
	 * 
	 * <p>
	 * En caso de éxito, se actualiza la lista observable que alimenta la tabla y se
	 * muestra una alerta informativa. Si ocurre alguna validación fallida o error
	 * inesperado, se notifica mediante una alerta de advertencia o error.
	 * </p>
	 *
	 * @param event el evento de acción que dispara la actualización, normalmente un
	 *              clic en un botón.
	 *
	 * @throws RuntimeException si ocurre un error inesperado durante el proceso de
	 *                          actualización.
	 * 
	 */
	@FXML
	void update(ActionEvent event) {
		Alert alert = new Alert(AlertType.INFORMATION);

		Vehiculo seleccionado = tblView.getSelectionModel().getSelectedItem();
		if (seleccionado == null) {
			alert.setAlertType(AlertType.WARNING);
			alert.setContentText("Debes seleccionar un vehículo de la tabla para actualizar.");
			alert.show();
			return;
		}

		try {
			String tipo = comboVehiculo.getValue();
			if (tipo == null) {
				alert.setAlertType(AlertType.WARNING);
				alert.setContentText("Debes seleccionar un tipo de vehículo.");
				alert.show();
				return;
			}

			// Placa NO se puede modificar — se usa la del objeto seleccionado
			String placa = seleccionado.getPlaca();
			String marca = txtMarca.getText().trim();
			String modelo = txtModelo.getText().trim();
			String pesoTexto = txtPeso.getText().trim();

			if (marca.isEmpty() || modelo.isEmpty() || pesoTexto.isEmpty()) {
				alert.setAlertType(AlertType.WARNING);
				alert.setContentText("Marca, Modelo y Peso son obligatorios.");
				alert.show();
				return;
			}

			double peso;
			try {
				peso = Double.parseDouble(pesoTexto);
				if (peso < 0)
					throw new IllegalArgumentException("El peso no puede ser negativo.");
			} catch (NumberFormatException e) {
				alert.setAlertType(AlertType.WARNING);
				alert.setContentText("El campo 'Peso' debe ser un número válido.");
				alert.show();
				return;
			}

			Vehiculo vehiculoActualizado = null;

			switch (tipo) {
			case "Automóvil":
				String estilo = txtEstilo.getText().trim();
				if (estilo.isEmpty()) {
					alert.setAlertType(AlertType.WARNING);
					alert.setContentText("El estilo del automóvil es obligatorio.");
					alert.show();
					return;
				}
				vehiculoActualizado = new Automovil(placa, marca, modelo, peso, estilo);
				break;

			case "Motocicleta":
				String cilindrajeTexto = txtCilindrajeMotor.getText().trim();
				if (cilindrajeTexto.isEmpty()) {
					alert.setAlertType(AlertType.WARNING);
					alert.setContentText("El cilindraje de la motocicleta es obligatorio.");
					alert.show();
					return;
				}
				double cilindraje;
				try {
					cilindraje = Double.parseDouble(cilindrajeTexto);
					if (cilindraje < 0)
						throw new IllegalArgumentException("El cilindraje no puede ser negativo.");
				} catch (NumberFormatException e) {
					alert.setAlertType(AlertType.WARNING);
					alert.setContentText("El campo 'Cilindraje' debe ser un número válido.");
					alert.show();
					return;
				}
				vehiculoActualizado = new Motocicleta(placa, marca, modelo, peso, cilindraje);
				break;

			case "Camión":
				String cargaTexto = txtCpdCarga.getText().trim();
				if (cargaTexto.isEmpty()) {
					alert.setAlertType(AlertType.WARNING);
					alert.setContentText("La capacidad de carga del camión es obligatoria.");
					alert.show();
					return;
				}
				double carga;
				try {
					carga = Double.parseDouble(cargaTexto);
					if (carga < 0)
						throw new IllegalArgumentException("La capacidad de carga no puede ser negativa.");
				} catch (NumberFormatException e) {
					alert.setAlertType(AlertType.WARNING);
					alert.setContentText("El campo 'Capacidad de carga' debe ser un número válido.");
					alert.show();
					return;
				}
				vehiculoActualizado = new Camion(placa, marca, modelo, peso, carga);
				break;
			}

			// Importante: pasar el objeto original como referencia para que se actualice
			// correctamente
			String mensaje = ic.update(seleccionado, vehiculoActualizado);

			vehiculos.setAll(ic.readAll());

			alert.setAlertType(AlertType.INFORMATION);
			alert.setContentText("Vehículo actualizado exitosamente.\n" + mensaje);
			alert.show();

			clear();

		} catch (Exception e) {
			alert.setAlertType(AlertType.WARNING);
			alert.setContentText("Error inesperado: " + e.getMessage());
			alert.show();
		}
	}

	/**
	 * Elimina un vehículo seleccionado de la tabla y del sistema.
	 * 
	 * <p>
	 * Este método permite al usuario eliminar un vehículo previamente seleccionado
	 * en la tabla. Primero, se verifica que haya una selección válida. Luego, se
	 * solicita una confirmación al usuario mediante una alerta de tipo
	 * {@code CONFIRMATION}. Si el usuario acepta, se procede a eliminar el vehículo
	 * utilizando el número de placa como identificador único.
	 * </p>
	 * 
	 * <p>
	 * Después de la eliminación, se actualiza la lista observable vinculada a la
	 * tabla y se muestra un mensaje informativo. También se limpian los campos del
	 * formulario.
	 * </p>
	 *
	 * @param event el evento de acción que dispara la eliminación, normalmente un
	 *              clic en un botón.
	 *
	 * @throws RuntimeException si ocurre un error inesperado durante el proceso de
	 *                          eliminación.
	 * 
	 */
	@FXML
	void delete(ActionEvent event) {
		Vehiculo seleccionado = tblView.getSelectionModel().getSelectedItem();

		if (seleccionado == null) {
			Alert alert = new Alert(Alert.AlertType.WARNING);
			alert.setContentText("Debes seleccionar un vehículo de la tabla para eliminar.");
			alert.show();
			return;
		}

		Alert confirmacion = new Alert(Alert.AlertType.CONFIRMATION);
		confirmacion.setTitle("Confirmar eliminación");
		confirmacion.setHeaderText(
				"¿Estás seguro que deseas eliminar el vehículo con placa: " + seleccionado.getPlaca() + "?");

		Optional<javafx.scene.control.ButtonType> resultado = confirmacion.showAndWait();
		if (resultado.isPresent() && resultado.get() == javafx.scene.control.ButtonType.OK) {
			String mensaje = ic.delete(seleccionado.getPlaca());

			// Refrescar la lista observable y la vista
			vehiculos.setAll(ic.readAll());

			Alert alert = new Alert(Alert.AlertType.INFORMATION);
			alert.setContentText(mensaje);
			alert.show();

			clear(); // Limpia los campos del formulario
		}
	}

	// OPERACIONES ARCHIVO:

	/**
	 * Serializa la lista completa de vehículos almacenados en el CRUD a un archivo
	 * binario.
	 * 
	 * <p>
	 * Este método obtiene todos los vehículos actualmente gestionados por el CRUD,
	 * y los serializa en un archivo llamado {@code "binaryfile.bin"} usando el
	 * método {@code serializar} de la implementación CRUD.
	 * </p>
	 * 
	 * <p>
	 * Después de la serialización, muestra una alerta informativa con el resultado
	 * de la operación (éxito o error).
	 * </p>
	 * 
	 * @param event el evento de acción que dispara la serialización, típicamente un
	 *              clic en un botón.
	 * 
	 */
	@FXML
	void serializar(ActionEvent event) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Serialización");

		// Serializa todos los vehículos actuales en la estructura del CRUD
		String resultado = ic.serializar(ic.readAll(), "", "binaryfile.bin");

		alert.setContentText(resultado);
		alert.show();
	}

	/**
	 * Deserializa la lista de vehículos desde un archivo binario y actualiza la
	 * vista.
	 * 
	 * <p>
	 * Este método intenta cargar un arreglo de vehículos desde el archivo
	 * {@code "binaryfile.bin"} mediante el método {@code deserializar} del CRUD.
	 * Posteriormente, actualiza la lista observable y refresca la tabla con los
	 * datos deserializados.
	 * </p>
	 * 
	 * <p>
	 * En caso de error durante la lectura o deserialización del archivo, se muestra
	 * una alerta con el mensaje de error.
	 * </p>
	 * 
	 * @param event el evento de acción que dispara la deserialización, típicamente
	 *              un clic en un botón.
	 * 
	 * 
	 */
	@FXML
	void deserializar(ActionEvent event) {
		Alert alert = new Alert(Alert.AlertType.WARNING);
		try {
			// Asumiendo que ic.deserializar(...) devuelve un arreglo de Vehiculo[]
			ic.setVehiculos(ic.deserializar("", "binaryfile.bin")); // Este método debe existir en tu CRUD
			vehiculos.clear();

			for (Vehiculo v : ic.readAll()) {
				if (v != null)
					vehiculos.add(v);
			}

			loadTable(); // Actualiza las columnas y la tabla

			// Mensaje de éxito
			Alert success = new Alert(Alert.AlertType.INFORMATION);
			success.setContentText("Vehículos deserializados correctamente.");
			success.show();

		} catch (Exception e) {
			alert.setContentText("Error al abrir el archivo: " + e.getMessage());
			alert.show();
		}
	}

	/**
	 * Configura las columnas de la tabla {@code tblView} para mostrar las
	 * propiedades de los vehículos en la lista observable {@code vehiculos}.
	 * 
	 * <p>
	 * Cada columna se enlaza con un atributo específico del objeto {@link Vehiculo}
	 * o sus subclases ({@link Automovil}, {@link Motocicleta}, {@link Camion}). La
	 * columna adicional muestra información específica según el tipo concreto de
	 * vehículo.
	 * </p>
	 * 
	 * <p>
	 * Finalmente, asigna la lista observable {@code vehiculos} como fuente de datos
	 * para la tabla.
	 * </p>
	 * 
	 * <p>
	 * Este método debe llamarse después de que {@code vehiculos} haya sido
	 * inicializada y contenga los datos a mostrar.
	 * </p>
	 * 
	 */
	private void loadTable() {
		column1.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getPlaca()));
		column2.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getMarca()));
		column3.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getModelo()));
		column4.setCellValueFactory(cell -> new SimpleStringProperty(String.valueOf(cell.getValue().getPeso())));

		column5.setCellValueFactory(cell -> {
			Vehiculo v = cell.getValue();
			if (v instanceof Automovil) {
				Automovil auto = (Automovil) v;
				return new SimpleStringProperty("Estilo: " + auto.getEstilo());
			} else if (v instanceof Motocicleta) {
				Motocicleta moto = (Motocicleta) v;
				return new SimpleStringProperty("Cilindraje: " + moto.getCilindrajeMotor() + " cc");
			} else if (v instanceof Camion) {
				Camion camion = (Camion) v;
				return new SimpleStringProperty("Carga: " + camion.getCapacidadCarga() + " kg");
			} else {
				return new SimpleStringProperty("N/A");
			}
		});

		tblView.setItems(vehiculos); // Asegúrate de haber cargado datos en 'vehiculos'
	}

	/**
	 * Limpia y restablece todos los campos de entrada del formulario relacionados
	 * con los datos de un vehículo.
	 * 
	 * <p>
	 * Este método borra el contenido de todos los campos de texto y deselecciona
	 * las opciones en los ComboBox {@code comboVehiculo} y
	 * {@code comboTipoVehiculoView}.
	 * </p>
	 * 
	 * <p>
	 * Además, oculta las etiquetas y campos específicos de tipo de vehículo que se
	 * muestran dinámicamente, dejando el formulario listo para una nueva entrada o
	 * búsqueda.
	 * </p>
	 * 
	 */
	private void clear() {
		txtPlaca.clear();
		txtMarca.clear();
		txtModelo.clear();
		txtPeso.clear();
		txtEstilo.clear();
		txtCilindrajeMotor.clear();
		txtCpdCarga.clear();
		txtBuscador.clear();

		comboVehiculo.getSelectionModel().clearSelection();
		comboTipoVehiculoView.getSelectionModel().clearSelection();

		// Ocultar campos específicos si los muestras dinámicamente
		lblEstilo.setVisible(false);
		txtEstilo.setVisible(false);
		lblCilindrajeMotor.setVisible(false);
		txtCilindrajeMotor.setVisible(false);
		lblCpdCarga.setVisible(false);
		txtCpdCarga.setVisible(false);

		// reiniciarlo
		// vehiculoSeleccionado = null;
	}

}