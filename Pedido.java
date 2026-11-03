public abstract class Pedido {
   public double getdistanciaKm() {
        return distanciaKm;
    }
    public double getPesoKg() {
        return pesoKg;
    }
    @override
    public string toString() {
        return "Pedido N°:"+numero+
        "\ndescripcion: "+descripcion+
        "\ndistancia: "+distanciaKm+" km"+
        "\npeso: "+pesoKg+" kg"+
        "\nEstado: "+estado;
        "\nCosto: "+calcularCosto();
        "\ntiempo estimado: "+calcularTiempoEntrega()+" horas";
    }
}