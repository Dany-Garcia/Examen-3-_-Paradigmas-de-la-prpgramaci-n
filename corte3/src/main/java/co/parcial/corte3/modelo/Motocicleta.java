package co.parcial.corte3.modelo;

import java.io.Serializable;

/**
 * La clase {@code Motocicleta} extiende de la clase {@code Vehiculo} e implementa la interfaz {@code Serializable}.
 * Representa una motocicleta, un tipo de vehículo con un cilindraje de motor específico.
 * 
 * @author García Figueroa Daniel Santiago
 * @since 25/05/2025
 */
public class Motocicleta extends Vehiculo implements Serializable {

    private double cilindrajeMotor;

    /**
     * Constructor sobrecargado que inicializa los atributos de la motocicleta.
     * Llama al constructor de la clase {@code Vehiculo} para inicializar los atributos comunes
     * de todos los vehículos y luego inicializa el atributo específico {@code cilindrajeMotor}.
     * 
     * @param placa        La placa de la motocicleta.
     * @param marca        La marca de la motocicleta.
     * @param modelo       El modelo de la motocicleta.
     * @param peso         El peso de la motocicleta.
     * @param cilindrajeMotor El cilindraje del motor de la motocicleta.
     */
    public Motocicleta(String placa, String marca, String modelo, double peso, double cilindrajeMotor) {
        super(placa, marca, modelo, peso);
        this.cilindrajeMotor = cilindrajeMotor;
    }

    /**
     * Obtiene el cilindraje del motor de la motocicleta.
     * 
     * @return El cilindraje del motor de la motocicleta.
     */
    public double getCilindrajeMotor() {
        return cilindrajeMotor;
    }

    /**
     * Establece el cilindraje del motor de la motocicleta.
     * 
     * @param cilindrajeMotor El nuevo cilindraje del motor de la motocicleta.
     */
    public void setCilindrajeMotor(double cilindrajeMotor) {
        this.cilindrajeMotor = cilindrajeMotor;
    }

    /**
     * Retorna una representación en cadena de caracteres del objeto {@code Motocicleta}.
     * La representación incluye los valores de los atributos {@code cilindrajeMotor}, {@code placa},
     * {@code marca}, {@code modelo} y {@code peso}.
     * 
     * @return Una cadena que representa el objeto {@code Motocicleta}.
     */
    @Override
    public String toString() {
        return "Motocicleta [cilindrajeMotor=" + cilindrajeMotor + ", getPlaca()=" + getPlaca() + ", getMarca()=" 
                + getMarca() + ", getModelo()=" + getModelo() + ", getPeso()=" + getPeso() + "]";
    }

}
