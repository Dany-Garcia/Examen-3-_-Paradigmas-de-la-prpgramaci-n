module co.parcial.corte3 {
	requires javafx.controls;
	requires javafx.fxml;

	opens co.parcial.corte3.vista to javafx.fxml;
	opens co.parcial.corte3.controlador to javafx.fxml;

	exports co.parcial.corte3.vista;
	exports co.parcial.corte3.controlador;

}
