package citylink.modelo;

public class Repartidor {

    
    private final int legajo;
    private final String nombre;
    private final Vehiculo vehiculo;

    private static final double COMISION = 0.10;

    public Repartidor(int legajo, String nombre, Vehiculo vehiculo) {
        this.legajo = legajo;
        this.nombre = nombre;
        this.vehiculo = vehiculo;
    }

    public int getLegajo() {
        return legajo;
    }

    public String getNombre() {
        return nombre;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public double calcularComision(Pedido pedido) {
        return pedido.calcularCosto(vehiculo) * COMISION;
    }

    @Override
    public String toString() {
        return "Legajo: " + legajo +
               " | Nombre: " + nombre +
               " | " + vehiculo;
    }
}