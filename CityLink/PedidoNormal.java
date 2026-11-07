public class PedidoNormal extends Pedido{
    public PedidoNormal(int codigo, Cliente cliente , double distanciaKm, double pesoKg){
        super(codigo, cliente , distanciaKm , pesoKg);
    }

    @Override 
    public String getTipo(){
        return "Normal";
    }

    @Override 
    public double calcularCosto(Vehiculo vehiculo){
        return vehiculo.calcularCostoViaje(getDistanciaKm());
    }
}