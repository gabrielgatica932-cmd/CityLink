package pedidos;
public class PedidoNormal extends Pedido{
    public PedidoNormal(int numero,String descripcion,double distanciaKm,double pesoKg){


        super(numero,descripcion,distanciaKm,pesoKg);
    }
    @Override 
    public double calcularCosto(){
        return 500+ (getdistanciaKm()*100) + (getPesoKg()*50);
    }
    @Override 
    public double calcularTiempoEntrega(){
        return getdistanciaKm()/20;
    }



    
}
