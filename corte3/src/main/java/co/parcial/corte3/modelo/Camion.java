package co.parcial.corte3.modelo;

import java.io.Serializable;

/**
 * La clase {@code Camion} extiende de la clase {@code Vehiculo} e implementa la
 * interfaz {@code Serializable}. Representa un camión, un tipo de vehículo con
 * una capacidad de carga específica.
 * 
 * @author García Figueroa Daniel Santiago
 * @since 25/05/2025
 */
public class Camion extends Vehiculo implements Serializable {

	private double CapacidadCarga;

	/**
	 * Constructor sobrecargado que inicializa los atributos del camión. Llama al
	 * constructor de la clase {@code Vehiculo} para inicializar los atributos
	 * comunes de todos los vehículos y luego inicializa el atributo específico
	 * {@code CapacidadCarga}.
	 * 
	 * @param placa          La placa del camión.
	 * @param marca          La marca del camión.
	 * @param modelo         El modelo del camión.
	 * @param peso           El peso del camión.
	 * @param CapacidadCarga La capacidad de carga del camión.
	 */
	public Camion(String placa, String marca, String modelo, double peso, double CapacidadCarga) {
		super(placa, marca, modelo, peso);
		this.CapacidadCarga = CapacidadCarga;
	}

	/**
	 * Obtiene la capacidad de carga del camión.
	 * 
	 * @return La capacidad de carga del camión.
	 */
	public double getCapacidadCarga() {
		return CapacidadCarga;
	}

	/**
	 * Establece la capacidad de carga del camión.
	 * 
	 * @param capacidadCarga La nueva capacidad de carga del camión.
	 */
	public void setCapacidadCarga(double capacidadCarga) {
		CapacidadCarga = capacidadCarga;
	}

	/**
	 * Retorna una representación en cadena de caracteres del objeto {@code Camion}.
	 * La representación incluye los valores de los atributos
	 * {@code CapacidadCarga}, {@code placa}, {@code marca}, {@code modelo} y
	 * {@code peso}.
	 * 
	 * @return Una cadena que representa el objeto {@code Camion}.
	 */
	@Override
	public String toString() {
		return "Camion [CapacidadCarga=" + CapacidadCarga + ", getPlaca()=" + getPlaca() + ", getMarca()=" + getMarca()
				+ ", getModelo()=" + getModelo() + ", getPeso()=" + getPeso() + "]";
	}

}
