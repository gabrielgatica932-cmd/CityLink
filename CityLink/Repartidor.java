public class Repartidor {

    private static final double PORCENTAJE_COMISION = 0.10;

    private final int legajo;
    private String nombre;
    private final Vehiculo vehiculo;

    public Repartidor(int legajo, String nombre, Vehiculo vehiculo) {
        if (legajo <= 0) {
            throw new IllegalArgumentException("El legajo debe ser mayor que cero.");
        }
        if (vehiculo == null) {
            throw new IllegalArgumentException("El repartidor necesita un vehículo.");
        }
        this.legajo = legajo;
        this.vehiculo = vehiculo;
        setNombre(nombre);
    }

    public int getLegajo() {
        return legajo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede ser nulo o vacío.");
        }
        this.nombre = nombre.trim();
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }
    
    public double calcularComision(double montoEnvio) {
        return montoEnvio * PORCENTAJE_COMISION;
    }

    @Override
    public String toString() {
        return "Repartidor #" + legajo + " | " + nombre + " | " + vehiculo.getTipo();
    }
}