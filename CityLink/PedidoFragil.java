public  class PedidoFragil  extends Pedido {
    public PedidoFragil(int codigo, Cliente cliente, double distanciaKm, double pesoKg){
        super(codigo, cliente, distanciaKm, pesoKg);
    }
    @Override
    public String getTipo(){
        return "Frágil";
    }
    @Override 
    public double calcularCosto(Vehiculo vehiculo){
        return vehiculo.calcularCostoViaje(getDistanciaKm()) + 200;
    }
}