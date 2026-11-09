public abstract class Vehiculo {

    private final double capacidadKg;
    private final double velocidadKmh;
    private final double costoPorKm;

    public Vehiculo(double capacidadKg, double velocidadKmh, double costoPorKm) {
        if (capacidadKg <= 0 || velocidadKmh <= 0 || costoPorKm <= 0) {
            throw new IllegalArgumentException(
                "Capacidad, velocidad y costo por km deben ser mayores que cero.");
        }
        this.capacidadKg = capacidadKg;
        this.velocidadKmh = velocidadKmh;
        this.costoPorKm = costoPorKm;
    }

    public abstract String getTipo();

    public abstract double calcularCostoViaje(double distanciaKm);


    public double calcularTiempoHoras(double distanciaKm) {
        return distanciaKm / velocidadKmh;
    }

    public boolean puedeTransportar(double pesoKg) {
        return pesoKg <= capacidadKg;
    }

    public double getCapacidadKg() {
        return capacidadKg;
    }

    public double getVelocidadKmh() {
        return velocidadKmh;
    }

    public double getCostoPorKm() {
        return costoPorKm;
    }

    @Override
    public String toString() {
        return getTipo() + " (capacidad: " + capacidadKg + " kg, velocidad: "
                + velocidadKmh + " km/h, costo: $" + costoPorKm + "/km)";
    }
}