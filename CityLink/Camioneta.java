public class Camioneta extends Vehiculo{
    
    private static final double CARGO_FIJO = 500.0;

    public Camioneta() {
        super(500.0, 40.0, 200.0);
    }

    @Override 
    public String getTipo() {
        return "Camioneta";
    }

    @Override 
    public double calcularCostoViaje(double distanciaKm) {
        return CARGO_FIJO + (getCostoPorKm() * distanciaKm);
    }
}
