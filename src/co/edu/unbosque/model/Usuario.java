package co.edu.unbosque.model;

import co.edu.unbosque.model.exceptions.CupoExcedidoException;
import co.edu.unbosque.model.exceptions.ParejaNoEncontradaException;

import java.util.ArrayList;

public class Usuario {
    private String nombreUsuario;
    private TC tarjetaCredito;  // Tarjeta de crédito asociada al usuario
    private ArrayList<Pareja> parejas;  // Lista de parejas asociadas al usuario

    public Usuario(String nombreUsuario, double cupoTarjeta) {
        this.nombreUsuario = nombreUsuario;
        this.tarjetaCredito = new TC(cupoTarjeta);  // Inicializar la tarjeta con el cupo total
        this.parejas = new ArrayList<>();
    }

    // Método para agregar una nueva pareja
    public void agregarPareja(Pareja pareja) throws CupoExcedidoException {
        // Verifica si el cupo asignado a la pareja es válido
        if (tarjetaCredito.asignarCupo(pareja.getCupoAsignado())) {
            parejas.add(pareja);
        }
    }

    // Método para verificar si el cupo total asignado a las parejas excede el 100%
    public boolean verificarCupoDisponible(double nuevoCupo) throws CupoExcedidoException {
        double totalCupoAsignado = 0;
        for (Pareja pareja : parejas) {
            totalCupoAsignado += pareja.getCupoAsignado();
        }
        // Verificación del cupo total no debe superar el 100%
        if (totalCupoAsignado + nuevoCupo > 100) {
            throw new CupoExcedidoException("El cupo total asignado excede el 100%");
        }
        return true;
    }

    // Método para actualizar los datos de una pareja existente
    public void actualizarPareja(String alias, double nuevoCupo) throws ParejaNoEncontradaException, CupoExcedidoException {
        Pareja pareja = buscarPareja(alias);
        if (pareja == null) {
            throw new ParejaNoEncontradaException("Pareja no encontrada.");
        }

        // Liberar el cupo anterior de la pareja y asignar el nuevo cupo
        tarjetaCredito.liberarCupo(pareja.getCupoAsignado());
        tarjetaCredito.asignarCupo(nuevoCupo);
        pareja.setCupoAsignado(nuevoCupo);
    }

    // Método para eliminar una pareja de la lista y liberar el cupo
    public void eliminarPareja(String alias) throws ParejaNoEncontradaException {
        Pareja pareja = buscarPareja(alias);
        if (pareja == null) {
            throw new ParejaNoEncontradaException("Pareja no encontrada.");
        }

        tarjetaCredito.liberarCupo(pareja.getCupoAsignado());
        parejas.remove(pareja);
    }

    // Método para buscar una pareja por alias
    public Pareja buscarPareja(String alias) {
        for (Pareja pareja : parejas) {
            if (pareja.getAlias().equalsIgnoreCase(alias)) {
                return pareja;
            }
        }
        return null;
    }

    // Getters y Setters
    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public TC getTarjetaCredito() {
        return tarjetaCredito;
    }

    public ArrayList<Pareja> getParejas() {
        return parejas;
    }
}
