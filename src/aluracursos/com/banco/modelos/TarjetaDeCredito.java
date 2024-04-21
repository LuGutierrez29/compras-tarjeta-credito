package aluracursos.com.banco.modelos;

import java.util.ArrayList;
import java.util.List;

public class TarjetaDeCredito {
    private double limiteTarjeta;
    private double saldo;
    private List<Compra> listaDeCompras;

    public TarjetaDeCredito(double limiteTarjeta) {
        this.limiteTarjeta = limiteTarjeta;
        this.saldo = limiteTarjeta;
        this.listaDeCompras = new ArrayList<>();
    }

    public boolean lanzarCompra(Compra compra) {
        if (this.saldo >= compra.getValor()) {
            this.saldo -= compra.getValor();
            this.listaDeCompras.add(compra);
            return true;
        }
        return false;
    }

    public double getLimiteTarjeta() {
        return limiteTarjeta;
    }

    public double getSaldo() {
        return saldo;
    }

    public List<Compra> getListaDeCompras() {
        return listaDeCompras;
    }
}
