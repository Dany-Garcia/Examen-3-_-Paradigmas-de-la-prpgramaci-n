package co.parcial.corte3.modelo;

import java.io.Serializable;

/**
 * La clase {@code Automovil} extiende de la clase {@code Vehiculo} e implementa
 * la interfaz {@code Serializable}. Representa un automóvil con atributos
 * específicos como el estilo del vehículo. Esta clase permite almacenar y
 * gestionar la información sobre el automóvil.
 * 
 * @author García Figueroa Daniel Santiago
 * @since 25/05/2025
 */
public class Automovil extends Vehiculo implements Serializable {

	private String estilo;

	/**
	 * Constructor sobrecargado que inicializa los atributos del automóvil. Llama al
	 * constructor de la clase {@code Vehiculo} para inicializar los atributos
	 * comunes de todos los vehículos y luego inicializa el atributo específico
	 * {@code estilo}.
	 * 
	 * @param placa  La placa del automóvil.
	 * @param marca  La marca del automóvil.
	 * @param modelo El modelo del automóvil.
	 * @param peso   El peso del automóvil.
	 * @param estilo El estilo del automóvil.
	 */
	public Automovil(String placa, String marca, String modelo, double peso, String estilo) {
		super(placa, marca, modelo, peso);
		this.estilo = estilo;
	}

	/**
	 * Obtiene el estilo del automóvil.
	 * 
	 * @return El estilo del automóvil.
	 */
	public String getEstilo() {
		return estilo;
	}

	/**
	 * Establece el estilo del automóvil.
	 * 
	 * @param estilo El estilo del automóvil.
	 */
	public void setEstilo(String estilo) {
		this.estilo = estilo;
	}

	/**
	 * Retorna una representación en cadena de caracteres del objeto
	 * {@code Automovil}. La representación incluye los valores de los atributos
	 * {@code estilo}, {@code placa}, {@code marca}, {@code modelo} y {@code peso}.
	 * 
	 * @return Una cadena que representa el objeto {@code Automovil}.
	 */
	@Override
	public String toString() {
		return "Automovil [estilo=" + estilo + ", getPlaca()=" + getPlaca() + ", getMarca()=" + getMarca()
				+ ", getModelo()=" + getModelo() + ", getPeso()=" + getPeso() + "]";
	}

}
