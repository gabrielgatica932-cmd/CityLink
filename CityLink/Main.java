import java.util.Scanner;

public class Main {
    
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {



        System.out.println("¡Hasta luego!");
        sc.close();
    }

    private static void mostrarMenu() {
        System.out.println();
        System.out.println("========== CITYLINK ==========");
        System.out.println(" 1. Registrar cliente");
        System.out.println(" 2. Registrar repartidor");
        System.out.println(" 3. Registrar pedido");
        System.out.println(" 4. Asignar pedido a repartidor");
        System.out.println(" 5. Avanzar estado de un pedido");
        System.out.println(" 6. Listar clientes");
        System.out.println(" 7. Listar repartidores");
        System.out.println(" 8. Listar pedidos");
        System.out.println(" 9. Buscar cliente");
        System.out.println("10. Eliminar cliente");
        System.out.println("11. Rastrear pedido");
        System.out.println("12. Facturar pedido");
        System.out.println(" 0. Salir");
        System.out.println("==============================");
    }

    private static void ejecutarOpcion(int opcion) {
        switch (opcion) {
            case 1:  registrarCliente(); break;
            case 2:  registrarRepartidor(); break;
            case 3:  registrarPedido(); break;
            case 4:  asignarPedido(); break;
            case 5:  avanzarEstado(); break;
            case 6:  listarClientes(); break;
            case 7:  listarRepartidores(); break;
            case 8:  listarPedidos(); break;
            case 9:  buscarCliente(); break;
            case 10: eliminarCliente(); break;
            case 11: rastrearPedido(); break;
            case 12: facturarPedido(); break;
            case 0:  break;
            default: System.out.println("Opción inexistente.");
        }
    }
}
