package co.parcial.corte3.servicios;

import co.parcial.corte3.modelo.Vehiculo;

/**
 * La interfaz {@code CRUD} define los métodos básicos para realizar operaciones de 
 * creación, lectura, actualización y eliminación (CRUD, por sus siglas en inglés) 
 * sobre objetos de tipo {@code Vehiculo}.
 * 
 * Esta interfaz debe ser implementada por clases que proporcionen la lógica específica 
 * para gestionar vehículos, permitiendo su manipulación en un sistema.
 * 
 * @author García Figueroa Daniel Santiago
 * @since 25/05/2025
 */
public interface CRUD {

    /**
     * Crea un nuevo vehículo y lo almacena.
     * 
     * @param v El vehículo que se desea crear.
     * @return Un mensaje indicando el resultado de la operación.
     */
    String create(Vehiculo v);

    /**
     * Lee y devuelve un vehículo a partir de su placa.
     * 
     * @param placa La placa del vehículo a buscar.
     * @return El vehículo encontrado o {@code null} si no se encuentra.
     */
    Vehiculo read(String placa);

    /**
     * Lee y devuelve todos los vehículos almacenados.
     * 
     * @return Un arreglo de objetos {@code Vehiculo} que contiene todos los vehículos.
     */
    Vehiculo[] readAll();

    /**
     * Actualiza un vehículo existente a partir del objeto original.
     * 
     * @param original El vehículo original que se desea actualizar (se usa su placa para identificarlo).
     * @param actualizado El nuevo vehículo con la información actualizada.
     * @return Un mensaje indicando el resultado de la operación.
     */
    String update(Vehiculo original, Vehiculo actualizado);


    /**
     * Elimina un vehículo de acuerdo a su placa.
     * 
     * @param placa La placa del vehículo que se desea eliminar.
     * @return Un mensaje indicando el resultado de la operación.
     */
    String delete(String placa);

}
