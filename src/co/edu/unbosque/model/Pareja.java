package co.edu.unbosque.model;

public class Pareja {
    private String alias;
    private double cupoAsignado; // En porcentaje del cupo total

    // Constructor
    public Pareja(String alias, double cupoAsignado) {
        this.alias = alias;
        this.cupoAsignado = cupoAsignado;
    }

    // Getters y Setters
    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public double getCupoAsignado() {
        return cupoAsignado;
    }

    public void setCupoAsignado(double cupoAsignado) {
        this.cupoAsignado = cupoAsignado;
    }

    // Método toString para mostrar la pareja en formato legible
    @Override
    public String toString() {
        return "Pareja [Alias: " + alias + ", Cupo Asignado: " + cupoAsignado + "%]";
    }

    // Método equals para comparar parejas por alias
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Pareja pareja = (Pareja) obj;

        return alias != null ? alias.equalsIgnoreCase(pareja.alias) : pareja.alias == null;
    }

    @Override
    public int hashCode() {
        return alias != null ? alias.toLowerCase().hashCode() : 0;
    }
}
