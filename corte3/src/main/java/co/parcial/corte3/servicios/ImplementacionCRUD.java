package co.parcial.corte3.servicios;

import co.parcial.corte3.modelo.Vehiculo;

import co.parcial.corte3.modelo.Automovil;
import co.parcial.corte3.modelo.Motocicleta;
import co.parcial.corte3.modelo.Camion;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * La clase {@code ImplementacionCRUD} implementa las interfaces {@code CRUD} y
 * {@code OperacionArchivo}. Proporciona implementaciones para las operaciones
 * básicas de creación, lectura, actualización y eliminación (CRUD) sobre
 * vehículos. También permite serializar y deserializar objetos de tipo
 * {@code Vehiculo}.
 * 
 * Además, esta clase proporciona la funcionalidad para manejar una colección
 * dinámica de vehículos y para realizar operaciones sobre vehículos
 * específicos, como agregar, actualizar y eliminar.
 * 
 * @author García Figueroa Daniel Santiago
 * @since 25/05/2025
 */
public class ImplementacionCRUD implements CRUD, OperacionArchivo {

	// Atributos
	private Vehiculo[] vehiculos;
	private int size;

	/**
	 * Constructor que inicializa la lista de vehículos con una capacidad inicial.
	 * 
	 * @param capacidadInicial La capacidad inicial del arreglo de vehículos.
	 */
	public ImplementacionCRUD(int capacidadInicial) {
		vehiculos = new Vehiculo[capacidadInicial];
		size = 0;
	}

	/**
	 * Expande el arreglo de vehículos cuando se alcanza la capacidad máxima.
	 * Duplica el tamaño del arreglo y copia los elementos existentes.
	 */
	private void expandArray() {
		Vehiculo[] nuevoArray = new Vehiculo[vehiculos.length * 2];
		for (int i = 0; i < vehiculos.length; i++) {
			nuevoArray[i] = vehiculos[i];
		}
		vehiculos = nuevoArray;
	}

	/**
	 * Establece la lista de vehículos con los vehículos deserializados.
	 * 
	 * @param vehiculosDeserializados El arreglo de vehículos deserializados.
	 */
	public void setVehiculos(Vehiculo[] vehiculosDeserializados) {
		this.vehiculos = vehiculosDeserializados;

		int contador = 0;
		for (Vehiculo v : vehiculosDeserializados) {
			if (v != null) {
				contador++;
			}
		}
		this.size = contador;
	}

	/**
	 * Serializa el arreglo de vehículos y lo guarda en un archivo.
	 * 
	 * @param vehiculos El arreglo de vehículos a serializar.
	 * @param path      La ruta donde se guardará el archivo.
	 * @param name      El nombre del archivo.
	 * @return Un mensaje indicando el resultado de la operación.
	 */
	@Override
	public String serializar(Vehiculo[] vehiculos, String path, String name) {
		try {
			FileOutputStream fos = new FileOutputStream(path + name);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(vehiculos);
			oos.close();
			fos.close();
			return "Archivo guardado exitosamente.";
		} catch (IOException ioe) {
			return "Error al guardar archivo: " + ioe.getMessage();
		}
	}

	/**
	 * Deserializa un archivo y devuelve el arreglo de vehículos almacenado en él.
	 * 
	 * @param path La ruta del archivo a deserializar.
	 * @param name El nombre del archivo a deserializar.
	 * @return El arreglo de vehículos deserializado.
	 */
	@Override
	public Vehiculo[] deserializar(String path, String name) {
		Vehiculo[] resultado = null;
		try {
			FileInputStream fis = new FileInputStream(path + name);
			ObjectInputStream ois = new ObjectInputStream(fis);
			resultado = (Vehiculo[]) ois.readObject();
			ois.close();
			fis.close();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return resultado;
	}

	/**
	 * Crea un nuevo vehículo y lo agrega al almacenamiento interno.
	 *
	 * <p>
	 * Si hay espacio disponible en el arreglo, el vehículo se inserta en la primera
	 * posición libre. Si el arreglo está lleno, se expande automáticamente antes de
	 * insertar.
	 * </p>
	 *
	 * @param v el vehículo a agregar. No debe ser {@code null}.
	 * @return un mensaje que indica si el vehículo fue agregado exitosamente, y si
	 *         fue necesario expandir el arreglo.
	 * @throws NullPointerException si el parámetro {@code v} es {@code null}.
	 *
	 */
	@Override
	public String create(Vehiculo v) {
		for (int i = 0; i < vehiculos.length; i++) {
			if (vehiculos[i] == null) {
				vehiculos[i] = v;
				size++;
				return "Vehículo agregado exitosamente.";
			}
		}
		expandArray();
		vehiculos[size] = v;
		size++;
		return "Vehículo agregado exitosamente. El arreglo fue expandido.";
	}

	/**
	 * Busca un vehículo en el arreglo de almacenamiento a partir de su placa.
	 *
	 * <p>
	 * La búsqueda no es sensible a mayúsculas/minúsculas.
	 * </p>
	 *
	 * @param placa la placa del vehículo a buscar. No debe ser {@code null}.
	 * @return el vehículo encontrado si existe; de lo contrario, {@code null}.
	 * @throws NullPointerException si {@code placa} es {@code null}.
	 *
	 */
	@Override
	public Vehiculo read(String placa) {
		for (int i = 0; i < size; i++) {
			if (vehiculos[i] != null && vehiculos[i].getPlaca().equalsIgnoreCase(placa)) {
				return vehiculos[i];
			}
		}
		return null;
	}

	/**
	 * Devuelve un arreglo con todos los vehículos actualmente almacenados.
	 *
	 * <p>
	 * El arreglo retornado contiene solo las posiciones ocupadas (vehículos no
	 * nulos).
	 * </p>
	 *
	 * @return un arreglo de {@link Vehiculo} con todos los elementos actualmente
	 *         almacenados.
	 *
	 */
	@Override
	public Vehiculo[] readAll() {
		Vehiculo[] resultado = new Vehiculo[size];
		int j = 0;
		for (Vehiculo v : vehiculos) {
			if (v != null) {
				resultado[j++] = v;
			}
		}
		return resultado;
	}

	/**
	 * Actualiza un vehículo existente en la estructura interna de almacenamiento.
	 *
	 * <p>
	 * Busca el vehículo original por su placa (ignorando mayúsculas/minúsculas) y
	 * lo reemplaza con la instancia actualizada.
	 * </p>
	 *
	 * @param original    el objeto {@link Vehiculo} original a buscar (por su
	 *                    placa).
	 * @param actualizado el nuevo objeto {@link Vehiculo} que reemplazará al
	 *                    original.
	 * @return un mensaje indicando si la operación fue exitosa o si no se encontró
	 *         el vehículo.
	 * @throws NullPointerException si alguno de los parámetros es {@code null}.
	 * 
	 */
	@Override
	public String update(Vehiculo original, Vehiculo actualizado) {
		for (int i = 0; i < size; i++) {
			if (vehiculos[i] != null && vehiculos[i].getPlaca().equalsIgnoreCase(original.getPlaca())) {
				vehiculos[i] = actualizado;
				return "Vehículo actualizado exitosamente.";
			}
		}
		return "Vehículo con placa " + original.getPlaca() + " no encontrado.";
	}

	/**
	 * Elimina un vehículo de la estructura de almacenamiento interna a partir de su
	 * placa.
	 *
	 * <p>
	 * Elimina el vehículo si se encuentra, reacomodando el arreglo para mantener la
	 * continuidad y decrementar el tamaño actual del almacenamiento.
	 * </p>
	 *
	 * @param placa la placa del vehículo a eliminar (no sensible a
	 *              mayúsculas/minúsculas).
	 * @return un mensaje indicando si el vehículo fue eliminado o no se encontró.
	 * @throws NullPointerException si {@code placa} es {@code null}.
	 * 
	 * 
	 */
	@Override
	public String delete(String placa) {
		for (int i = 0; i < size; i++) {
			if (vehiculos[i] != null && vehiculos[i].getPlaca().equalsIgnoreCase(placa)) {
				// Eliminar el vehículo sin importar el tipo
				vehiculos[i] = null;

				// Compactar el arreglo para mantener la continuidad
				for (int j = i; j < size - 1; j++) {
					vehiculos[j] = vehiculos[j + 1];
				}
				vehiculos[size - 1] = null; // Limpiar última posición
				size--;

				return "Vehículo eliminado exitosamente.";
			}
		}
		return "Vehículo con placa " + placa + " no encontrado.";
	}

	/**
	 * Lee y devuelve vehículos de un tipo específico (por ejemplo, Automovil,
	 * Camion).
	 * 
	 * @param tipo La clase del tipo de vehículo a buscar.
	 * @return Un arreglo de vehículos del tipo especificado.
	 */
	public Vehiculo[] readByTipo(Class<?> tipo) {
		int contador = 0;
		for (Vehiculo v : vehiculos) {
			if (v != null && v.getClass() == tipo) {
				contador++;
			}
		}

		Vehiculo[] resultado = new Vehiculo[contador];
		int j = 0;
		for (Vehiculo v : vehiculos) {
			if (v != null && v.getClass() == tipo) {
				resultado[j++] = v;
			}
		}
		return resultado;
	}
}
