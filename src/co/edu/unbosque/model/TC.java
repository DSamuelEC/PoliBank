package co.edu.unbosque.model;

import co.edu.unbosque.model.exceptions.CupoExcedidoException;

public class TC {
    private double cupoTotal;  // Cupo total de la tarjeta de crédito
    private double cupoDisponible;  // Cupo disponible restante

    // Constructor: inicializa el cupo total y el cupo disponible
    public TC(double cupoTotal) {
        this.cupoTotal = cupoTotal;
        this.cupoDisponible = cupoTotal;  // Inicialmente, todo el cupo está disponible
    }

    // Método para asignar cupo a una pareja
    public boolean asignarCupo(double montoAsignado) throws CupoExcedidoException {
        if (montoAsignado > cupoDisponible) {
            throw new CupoExcedidoException("El cupo asignado excede el cupo disponible.");
        }
        // Restar el cupo asignado del cupo disponible
        cupoDisponible -= montoAsignado;
        return true;
    }

    // Método para liberar cupo cuando se elimina o actualiza una pareja
    public void liberarCupo(double montoLiberado) {
        // Sumar el cupo liberado al cupo disponible
        cupoDisponible += montoLiberado;
        if (cupoDisponible > cupoTotal) {
            cupoDisponible = cupoTotal;  // El cupo disponible no puede exceder el cupo total
        }
    }

    // Getters y Setters
    public double getCupoTotal() {
        return cupoTotal;
    }

    public void setCupoTotal(double cupoTotal) {
        this.cupoTotal = cupoTotal;
        // Actualizar el cupo disponible en caso de cambiar el cupo total
        if (cupoDisponible > cupoTotal) {
            cupoDisponible = cupoTotal;
        }
    }

    public double getCupoDisponible() {
        return cupoDisponible;
    }

    public void setCupoDisponible(double cupoDisponible) {
        this.cupoDisponible = cupoDisponible;
    }
}
