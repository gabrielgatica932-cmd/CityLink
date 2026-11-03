package pedidos
public class PedidoUrgsnte
    public double calcularCosto() {
       double costoBase=500+ (getdistanciaKm() * 100) + (getPesoKg() * 50);
 
       return costoBase * 1.5;

    }
    @Override 
    public double calcularTiempoEntrega() {
        return getdistanciaKm() / 30;
    }
    j
    
}
//gk,flldl,cfkkaskkodgsaomp,mdsoapmmmekprprmpmrpa,fmffadkfkklekaf,l,fla-.mmfaekmñ,e smaldmsaplnkannlfnkaFPOAm skampamfapmefmaf