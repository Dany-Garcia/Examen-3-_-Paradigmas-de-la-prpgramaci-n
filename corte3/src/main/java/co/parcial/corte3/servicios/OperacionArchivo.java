package co.parcial.corte3.servicios;

import co.parcial.corte3.modelo.Vehiculo;

/**
 * La interfaz {@code OperacionArchivo} define los métodos para realizar operaciones de
 * serialización y deserialización de objetos de tipo {@code Vehiculo}.
 * 
 * La implementación de esta interfaz debe proporcionar la lógica específica para guardar
 * vehículos en un archivo (serialización) y leer vehículos desde un archivo (deserialización).
 * 
 *@author García Figueroa Daniel Santiago
 * @since 25/05/2025
 */
public interface OperacionArchivo {

    /**
     * Serializa un arreglo de vehículos y lo guarda en un archivo especificado por la ruta y el nombre.
     * 
     * @param vehiculos El arreglo de vehículos que se desea serializar.
     * @param path La ruta donde se guardará el archivo.
     * @param name El nombre del archivo.
     * @return Un mensaje indicando el resultado de la operación (éxito o error).
     */
    public String serializar(Vehiculo[] vehiculos, String path, String name);

    /**
     * Deserializa un archivo y devuelve el arreglo de vehículos almacenado en él.
     * 
     * @param path La ruta del archivo a deserializar.
     * @param name El nombre del archivo a deserializar.
     * @return El arreglo de vehículos deserializado.
     */
    public Vehiculo[] deserializar(String path, String name);

}
