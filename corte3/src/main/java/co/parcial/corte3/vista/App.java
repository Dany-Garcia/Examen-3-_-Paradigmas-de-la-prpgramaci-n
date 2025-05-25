package co.parcial.corte3.vista;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Clase principal de la aplicación JavaFX para la gestión de vehículos.
 *
 * <p>
 * Esta clase extiende {@link javafx.application.Application} y representa el
 * punto de entrada de la interfaz gráfica de usuario (GUI). Se encarga de
 * cargar el archivo FXML principal y mostrar la ventana inicial.
 * </p>
 *
 * <p>
 * El archivo FXML que se carga inicialmente es {@code AppVehiculos.fxml}.
 * </p>
 *
 * @author García Figueroa Daniel Santiago
 * @since 25/05/2025
 */
public class App extends Application {

	private static Scene scene;

	/**
	 * Método de inicio de la aplicación JavaFX.
	 *
	 * <p>
	 * Este método es invocado automáticamente por el sistema JavaFX cuando se lanza
	 * la aplicación. Inicializa la escena y muestra la ventana principal.
	 * </p>
	 *
	 * @param stage el escenario primario proporcionado por el sistema JavaFX.
	 * @throws IOException si ocurre un error al cargar el archivo FXML.
	 */
	@Override
	public void start(Stage stage) throws IOException {
		scene = new Scene(loadFXML("AppVehiculos"), 640, 480);
		stage.setScene(scene);
		stage.show();
	}

	/**
	 * Establece un nuevo contenido raíz para la escena principal a partir del
	 * nombre del archivo FXML dado.
	 *
	 * @param fxml nombre base del archivo FXML (sin extensión) a cargar como nueva
	 *             raíz.
	 * @throws IOException si el archivo FXML no puede ser cargado.
	 */
	static void setRoot(String fxml) throws IOException {
		scene.setRoot(loadFXML(fxml));
	}

	/**
	 * Carga y devuelve el contenido desde un archivo FXML dado.
	 *
	 * @param fxml nombre base del archivo FXML (sin extensión) a cargar.
	 * @return el nodo raíz del archivo FXML cargado.
	 * @throws IOException si el archivo FXML no puede ser leído o cargado.
	 */
	private static Parent loadFXML(String fxml) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
		return fxmlLoader.load();
	}

	/**
	 * Método principal de ejecución de la aplicación.
	 *
	 * <p>
	 * Invoca el método {@link #launch()} para iniciar la aplicación JavaFX.
	 * </p>
	 *
	 * @param args argumentos de la línea de comandos (no utilizados).
	 */
	public static void main(String[] args) {
		launch();
	}

}