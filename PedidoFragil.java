package pedidos;
public class PedidoFragil extends Pedido {
    public PedidoFragil(int numero, String descripcion, double distanciaKm, double pesoKg) {
        super(numero, descripcion, distanciaKm, pesoKg);
    }
    @Override
    public double calcularCosto() {
        double costoBase = 500 + (getdistanciaKm() * 100) + (getPesoKg() * 50);
        return costoBase * 1.20; // Aplicar un recargo del 20% para productos frágiles
    }
    @Override
    public double calcularTiempoEntrega() {
        return getdistanciaKm() / 20;
    }
}
