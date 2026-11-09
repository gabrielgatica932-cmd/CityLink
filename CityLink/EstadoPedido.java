public enum EstadoPedido {
    
    PENDIENTE, ASIGNADO, EN_CAMINO, ENTREGADO;

    public EstadoPedido siguiente() {
        if (this == ENTREGADO) {
            throw new EstadoInvalidoException("No se puede avanzar más allá del estado ENTREGADO.");
        }
        return values()[ordinal() + 1];
    }
}
