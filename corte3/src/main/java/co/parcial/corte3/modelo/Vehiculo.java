package co.parcial.corte3.modelo;

import java.io.Serializable;

/**
 * La clase {@code Vehiculo} representa un vehículo genérico con atributos comunes como
 * la placa, la marca, el modelo y el peso. Esta clase es la base para otros tipos de vehículos
 * como automóviles, camiones y motocicletas, que heredan sus atributos y funcionalidades.
 * 
 * @author García Figueroa Daniel Santiago
 * @since 25/05/2025
 */
public class Vehiculo implements Serializable {

    private String placa;
    private String marca;
    private String modelo;
    private double peso;

    /**
     * Constructor sobrecargado que inicializa los atributos del vehículo.
     * 
     * @param placa  La placa del vehículo.
     * @param marca  La marca del vehículo.
     * @param modelo El modelo del vehículo.
     * @param peso   El peso del vehículo.
     */
    public Vehiculo(String placa, String marca, String modelo, double peso) {
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.peso = peso;
    }

    /**
     * Obtiene la placa del vehículo.
     * 
     * @return La placa del vehículo.
     */
    public String getPlaca() {
        return placa;
    }

    /**
     * Establece la placa del vehículo.
     * 
     * @param placa La nueva placa del vehículo.
     */
    public void setPlaca(String placa) {
        this.placa = placa;
    }

    /**
     * Obtiene la marca del vehículo.
     * 
     * @return La marca del vehículo.
     */
    public String getMarca() {
        return marca;
    }

    /**
     * Establece la marca del vehículo.
     * 
     * @param marca La nueva marca del vehículo.
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }

    /**
     * Obtiene el modelo del vehículo.
     * 
     * @return El modelo del vehículo.
     */
    public String getModelo() {
        return modelo;
    }

    /**
     * Establece el modelo del vehículo.
     * 
     * @param modelo El nuevo modelo del vehículo.
     */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    /**
     * Obtiene el peso del vehículo.
     * 
     * @return El peso del vehículo.
     */
    public double getPeso() {
        return peso;
    }

    /**
     * Establece el peso del vehículo.
     * 
     * @param peso El nuevo peso del vehículo.
     */
    public void setPeso(double peso) {
        this.peso = peso;
    }

    /**
     * Retorna una representación en cadena de caracteres del objeto {@code Vehiculo}.
     * La representación incluye los valores de los atributos {@code placa}, {@code marca},
     * {@code modelo} y {@code peso}.
     * 
     * @return Una cadena que representa el objeto {@code Vehiculo}.
     */
    @Override
    public String toString() {
        return "Automovil [placa=" + placa + ", marca=" + marca + ", modelo=" + modelo + ", peso=" + peso + "]";
    }

}
