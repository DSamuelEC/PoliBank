package co.edu.unbosque.model;

import java.util.ArrayList;

public class Administrador extends Usuario {

    // Constructor del Administrador
    public Administrador(String nombreUsuario) {
        super(nombreUsuario, 0);  // El administrador no tiene cupo ni parejas.
    }

    // El administrador puede ver todos los usuarios del sistema
    public ArrayList<Usuario> consultarUsuarios(ArrayList<Usuario> usuarios) {
        return usuarios;  // Devolvemos todos los usuarios registrados
    }

    // El administrador puede actualizar los datos de un usuario
    public void actualizarUsuario(Usuario usuario, String nuevoNombre, double nuevoCupo) {
        usuario.setNombreUsuario(nuevoNombre);
        usuario.getTarjetaCredito().setCupoTotal(nuevoCupo);  // Modificar el cupo de la tarjeta de crédito
    }

    // El administrador puede eliminar un usuario del sistema
    public void eliminarUsuario(ArrayList<Usuario> usuarios, Usuario usuario) {
        if (!(usuario instanceof Administrador)) {  // Evita eliminar al propio administrador
            usuarios.remove(usuario);
        }
    }

    // El administrador puede listar los datos de un usuario específico
    public String mostrarUsuario(Usuario usuario) {
        StringBuilder sb = new StringBuilder();
        sb.append("Usuario: ").append(usuario.getNombreUsuario()).append("\n");
        sb.append("Cupo Total: ").append(usuario.getTarjetaCredito().getCupoTotal()).append("\n");
        sb.append("Cupo Disponible: ").append(usuario.getTarjetaCredito().getCupoDisponible()).append("\n");

        ArrayList<Pareja> parejas = usuario.getParejas();
        sb.append("Parejas:\n");
        for (Pareja pareja : parejas) {
            sb.append("Alias: ").append(pareja.getAlias()).append(", Cupo Asignado: ").append(pareja.getCupoAsignado()).append("%\n");
        }
        return sb.toString();
    }
    
    // El administrador puede actualizar una pareja de un usuario
    public void actualizarPareja(Usuario usuario, String aliasPareja, double nuevoCupo) throws Exception {
        usuario.actualizarPareja(aliasPareja, nuevoCupo);
    }

    // El administrador puede eliminar una pareja de un usuario
    public void eliminarPareja(Usuario usuario, String aliasPareja) throws Exception {
        usuario.eliminarPareja(aliasPareja);
    }
}
