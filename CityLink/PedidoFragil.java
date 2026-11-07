public  class PedidoFragil  extends pedido {
    public PedidoFragil(int codigo, Cliente cliente, double distanciaKm, double pesoKg){
        super(codigo, cliente, distanciaKm, pesoKg);
    }
    @Override
    public Strin getTipo(){
        return "Fragil";
    }
    @Override 
    public double calcularCosto(Vehiculo vehiculo){
        return vehiculo.calcularCostoViaje(getDistanciaKm()) + 200;
    }


    
}