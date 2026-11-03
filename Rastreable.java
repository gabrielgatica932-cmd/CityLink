 package pedidos;

public interface Rastreable {
    EstadoPedido getEstado();

    void cambiarEstado(EstadoPedido nuevoEstado);
}
