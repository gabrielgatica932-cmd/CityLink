public class PedidoUrgente extends Pedido{
    public PedidoUrgente(int codigo, Cliente cliente, double distanciaKm, double pesoKg){
        super(codigo, cliente , distanciaKm , PesoKg);
    }

    @Override 
    public String getTipo() {
        return "Urgente";
    }

    @override 
    public double calcularCosto(Vehiculo vehiculo){
        return vehiculo.calcularCostoViaje(getDistanciaKm())*1.5; //recargo 50%
    }
}