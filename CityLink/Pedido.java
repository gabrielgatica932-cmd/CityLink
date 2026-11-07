public abstract class Pedido{

    private final int codigo;
    private final Cliente cliente;
    private final double distanciaKm;
    private final double pesoKg;
    private String estado;

    public Pedido(Int codigo, Cliente cliente, double distanciaKm, double pesoKg){
        if(codigo<=0){
            throw new IllegalArgumentException ("El código debe ser cero.");
        }
        if(cliente==null){
            throw new IllegalArgumentException("El pedido necesita un cliente.");
        }
        if(distanciaKm<=0 || pesoKg <=0){
            throw new IllegalArgumentException("Distancia y peso deben ser mayores que cero.");
        }
        this.codigo = codigo;
        this.cliente = cliente;
        this.distanciaKm = distanciaKm;
        this.pesoKg = pesoKg;
        this.estado = "PENDIENTE";
 }
//SEGUNDO
public int getCodigo(){
    return codigo;
}
public Cliente getCliente(){
    return cliente;
}
public double getDistanciaKm(){
    return distanciaKm;
}
public double getPesoKg(){
    return pesoKg;
}
public String getEstado(){
    return estado;
}
@Override
public String toString(){
    return getTipo() + " #" + codigo + " | " + cliente.getNombre()
    + " | " + distanciaKm + " Km | " + estado;
}
}