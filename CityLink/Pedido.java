public abstract class Pedido implements Rastreable, Facturable {

    private final int codigo;
    private final Cliente cliente;
    private final double distanciaKm;
    private final double pesoKg;
    private EstadoPedido estado;
    private Repartidor repartidor;

    public Pedido(int codigo, Cliente cliente, double distanciaKm, double pesoKg) {
        if (codigo <= 0) {
            throw new IllegalArgumentException("El código debe ser mayor que cero.");
        }
        if (cliente == null) {
            throw new IllegalArgumentException("El pedido necesita un cliente.");
        }
        if (distanciaKm <= 0 || pesoKg <= 0) {
            throw new IllegalArgumentException("Distancia y peso deben ser mayores que cero.");
        }
        this.codigo = codigo;
        this.cliente = cliente;
        this.distanciaKm = distanciaKm;
        this.pesoKg = pesoKg;
        this.estado = EstadoPedido.PENDIENTE;
    }

    public abstract String getTipo();

    public abstract double calcularCosto(Vehiculo vehiculo);

    public void asignarRepartidor(Repartidor repartidor) throws CapacidadExcedidaException {
        if (repartidor == null) {
            throw new IllegalArgumentException("El repartidor no puede ser nulo.");
        }
        if (estado != EstadoPedido.PENDIENTE) {
            throw new EstadoInvalidoException(
                "Solo se puede asignar un pedido pendiente (estado actual: " + estado + ").");
        }
        Vehiculo vehiculo = repartidor.getVehiculo();
        if (!vehiculo.puedeTransportar(pesoKg)) {
            throw new CapacidadExcedidaException(
                "La " + vehiculo.getTipo() + " no puede llevar " + pesoKg
                + " kg (máximo " + vehiculo.getCapacidadKg() + " kg).");
        }
        this.repartidor = repartidor;
        this.estado = EstadoPedido.ASIGNADO;
    }

    public void avanzarEstado() {
        if (estado == EstadoPedido.PENDIENTE) {
            throw new EstadoInvalidoException(
                "El pedido #" + codigo + " debe asignarse a un repartidor antes de avanzar.");
        }
        estado = estado.siguiente();
    }

    @Override
    public String obtenerEstado() {
        String texto = getTipo() + " #" + codigo + ": " + estado;
        if (repartidor != null) {
            texto += " (repartidor: " + repartidor.getNombre() + ")";
        }
        return texto;
    }

    @Override
    public double calcularTotal() {
        if (repartidor == null) {
            throw new EstadoInvalidoException(
                "El pedido #" + codigo + " no tiene repartidor asignado, no se puede facturar.");
        }
        return calcularCosto(repartidor.getVehiculo());
    }

    public int getCodigo() { return codigo; }
    public Cliente getCliente() { return cliente; }
    public double getDistanciaKm() { return distanciaKm; }
    public double getPesoKg() { return pesoKg; }
    public EstadoPedido getEstado() { return estado; }
    public Repartidor getRepartidor() { return repartidor; }

    @Override
    public String toString() {
        return getTipo() + " #" + codigo + " | " + cliente.getNombre()
                + " | " + distanciaKm + " km | " + pesoKg + " kg | " + estado;
    }
}