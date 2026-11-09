public class Cliente {

    private final int codigo;
    private String nombre;
    private String telefono;
    private String zona;

    public Cliente(int codigo, String nombre, String telefono, String zona) {
        if (codigo <= 0) {
            throw new IllegalArgumentException("El código debe ser mayor que cero.");
        }
        this.codigo = codigo;
        setNombre(nombre);
        setTelefono(telefono);
        setZona(zona);
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede ser nulo o vacío.");
        }
        this.nombre = nombre.trim();
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        if (telefono == null || telefono.trim().isEmpty()) {
            throw new IllegalArgumentException("El teléfono no puede ser nulo o vacío.");
        }
        this.telefono = telefono.trim();
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        if (zona == null || zona.trim().isEmpty()) {
            throw new IllegalArgumentException("La zona no puede ser nula o vacía.");
        }
        this.zona = zona.trim();
    }

    @Override
    public String toString() {
        return "Cliente #" + codigo + " | " + nombre + " | Tel: " + telefono
                + " | Zona: " + zona;
    }
}