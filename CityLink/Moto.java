public class Moto extends Vehiculo {
    
    public Moto() {
        super(20.0, 50.0, 80.0);
    }

    @Override
    public String getTipo() {
        return "Moto";
    }

    @Override 
    public double calcularCostoViaje(double distanciaKm) {
        return getCostoPorKm() * distanciaKm;
    }
}
