package aluracursos.com.banco.modelos;

public class Compra implements Comparable<Compra>{

    private String articulo;
    private double valor;

    public Compra(String articulo, double valor) {
        this.articulo = articulo;
        this.valor = valor;
    }

    public String getArticulo() {
        return articulo;
    }

    public double getValor() {
        return valor;
    }

    @Override
    public String toString() {
        return "Compra: articulo='" + articulo + '\'' +
                ", valor=" + valor;
    }

    @Override
    public int compareTo(Compra otraCompra) {
        return Double.valueOf(this.valor).compareTo(Double.valueOf(otraCompra.getValor()));
    }
}

