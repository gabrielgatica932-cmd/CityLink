public class Bicicleta extends Vehiculo {
    
    public Bicicleta() {
        super(5.0, 15.0, 20.0);
    }

    @Override 
    public String getTipo() {
        return "Bicicleta";
    }

    @Override 
    public double calcularCostoViaje(double distanciaKm) {
        return getCostoPorKm() * distanciaKm;
    }
}
