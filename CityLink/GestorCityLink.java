public class GestorCityLink {

    private static final int MAX_CLIENTES = 50;
    private static final int MAX_PEDIDOS = 100;
    private static final int MAX_REPARTIDORES = 10;

    private final Cliente[] clientes = new Cliente[MAX_CLIENTES];
    private final Repartidor[] repartidores = new Repartidor[MAX_REPARTIDORES];
    private final Pedido[] pedidos = new Pedido[MAX_PEDIDOS];
    private int cantClientes = 0;
    private int cantPedidos = 0;
    private int cantRepartidores = 0;

    public void agregarCliente(Cliente cliente) throws AlmacenamientoLlenoException {
        if (cantClientes == MAX_CLIENTES) {
            throw new AlmacenamientoLlenoException(
            "No hay lugar para más clientes (máximo " + MAX_CLIENTES + ").");
        }
        if (indiceCliente(cliente.getCodigo()) != -1) {
            throw new IllegalArgumentException(
            "Ya existe un cliente con el código " + cliente.getCodigo() + ".");
        }
        clientes[cantClientes] = cliente;
        cantClientes++;
    }

    public Cliente buscarCliente(int codigo) throws ClienteNoEncontradoException {
        int pos = indiceCliente(codigo);
        if (pos == -1) {
            throw new ClienteNoEncontradoException("No existe un cliente con el código " + codigo + ".");
        }
        return clientes[pos];
    }

    public void eliminarCliente(int codigo) throws ClienteNoEncontradoException {
        int pos = indiceCliente(codigo);
        if (pos == -1) {
            throw new ClienteNoEncontradoException("No existe un cliente con el código " + codigo + ".");
        }
        for (int i = 0; i < cantPedidos; i++) {
            if (pedidos[i].getCliente().getCodigo() == codigo) {
                throw new IllegalArgumentException(
                "No se puede eliminar el cliente " + codigo + ": tiene pedidos registrados.");
            }
        }
        for (int i = pos; i < cantClientes - 1; i++) {
            clientes[i] = clientes[i + 1];
        }
        clientes[cantClientes - 1] = null;
        cantClientes--;
    }

    public String listarClientes() {
        if (cantClientes == 0) {
            return "No hay clientes registrados.";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < cantClientes; i++) {
            sb.append(clientes[i].toString()).append("\n");
        }
        return sb.toString();
    }

    private int indiceCliente(int codigo) {
        for (int i = 0; i < cantClientes; i++) {
            if (clientes[i].getCodigo() == codigo) {
                return i;
            }
        }
        return -1;
    }

    public void agregarPedido(Pedido pedido) throws AlmacenamientoLlenoException {
        if (cantPedidos == MAX_PEDIDOS) {
            throw new AlmacenamientoLlenoException("No hay lugar para más pedidos (máximo " + MAX_PEDIDOS + ").");
        }
        if (indicePedido(pedido.getCodigo()) != -1) {
            throw new IllegalArgumentException("Ya existe un pedido con el mismo código: " + pedido.getCodigo() + ".");
        }
        pedidos[cantPedidos] = pedido;
        cantPedidos++;
    }

    public String listarPedidos() {
        if (cantPedidos == 0) {
            return "No hay pedidos registrados.";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < cantPedidos; i++) {
            sb.append(pedidos[i].toString()).append("\n");
        }
        return sb.toString();
    }

    private int indicePedido(int codigo) {
        for (int i = 0; i < cantPedidos; i++) {
            if (pedidos[i].getCodigo() == codigo) {
                return i;
            }
        }
        return -1;
    }

    public void agregarRepartidor(Repartidor repartidor) throws AlmacenamientoLlenoException {
        if (cantRepartidores == MAX_REPARTIDORES) {
            throw new AlmacenamientoLlenoException(
            "No hay lugar para más repartidores (máximo " + MAX_REPARTIDORES + ").");
        }
        if (indiceRepartidor(repartidor.getLegajo()) != -1) {
            throw new IllegalArgumentException(
            "Ya existe un repartidor con el legajo " + repartidor.getLegajo() + ".");
        }
        repartidores[cantRepartidores] = repartidor;
        cantRepartidores++;
    }

    public String listarRepartidores() {
        if (cantRepartidores == 0) {
            return "No hay repartidores registrados.";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < cantRepartidores; i++) {
        sb.append(repartidores[i].toString()).append("\n");
        }
        return sb.toString();
    }

    private int indiceRepartidor(int legajo) {
        for (int i = 0; i < cantRepartidores; i++) {
            if (repartidores[i].getLegajo() == legajo) {
                return i;
            }
        }
        return -1;
    }

    private Pedido buscarPedido(int codigo) {
    int pos = indicePedido(codigo);
    if (pos == -1) {
        throw new IllegalArgumentException("No existe un pedido con el código " + codigo + ".");
    }
    return pedidos[pos];
}

    private Repartidor buscarRepartidor(int legajo) {
        int pos = indiceRepartidor(legajo);
        if (pos == -1) {
            throw new IllegalArgumentException("No existe un repartidor con el legajo " + legajo + ".");
        }
        return repartidores[pos];
    }

    public void asignarPedido(int codPedido, int legajo) throws CapacidadExcedidaException {
        Pedido pedido = buscarPedido(codPedido);
        Repartidor repartidor = buscarRepartidor(legajo);
        pedido.asignarRepartidor(repartidor);
    }

    public void avanzarEstado(int codPedido) {
        buscarPedido(codPedido).avanzarEstado();
    }

    public String rastrearPedido(int codPedido) {
        Rastreable rastreable = buscarPedido(codPedido);
        return rastreable.obtenerEstado();
    }

    public String facturarPedido(int codPedido) {
        Pedido pedido = buscarPedido(codPedido);
        Facturable facturable = pedido;
        double total = facturable.calcularTotal();

        Repartidor repartidor = pedido.getRepartidor();
        Vehiculo vehiculo = repartidor.getVehiculo();
        double minutos = vehiculo.calcularTiempoHoras(pedido.getDistanciaKm()) * 60;

        StringBuilder sb = new StringBuilder();
        sb.append("========== FACTURA ==========\n");
        sb.append("Pedido:      #").append(pedido.getCodigo())
        .append(" (").append(pedido.getTipo()).append(")\n");
        sb.append("Cliente:     ").append(pedido.getCliente().getNombre()).append("\n");
        sb.append("Repartidor:  ").append(repartidor.getNombre())
        .append(" - ").append(vehiculo.getTipo()).append("\n");
        sb.append(String.format("Distancia:   %.1f km%n", pedido.getDistanciaKm()));
        sb.append(String.format("Tiempo est.: %.0f min%n", minutos));
        sb.append(String.format("TOTAL:       $%.2f%n", total));
        sb.append(String.format("Comisión repartidor (10%%): $%.2f%n", repartidor.calcularComision(total)));
        sb.append("=============================");
        return sb.toString();
    }
}
