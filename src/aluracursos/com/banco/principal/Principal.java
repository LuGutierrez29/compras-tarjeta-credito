package aluracursos.com.banco.principal;
import aluracursos.com.banco.modelos.TarjetaDeCredito;
import aluracursos.com.banco.modelos.Compra;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        int opcion = 1;
        Scanner teclado = new Scanner(System.in);
        System.out.println("Escriba el limite de la tarjeta");
        double limite = teclado.nextDouble();
        TarjetaDeCredito nuevaTarjeta = new TarjetaDeCredito(limite);

        System.out.println("***********************************************\n");
        String menu = """
                *** Escriba el número de la opción deseada ***
                1 - Comprar
                2 - Salir
                \n***********************************************""";

        Scanner referencia = new Scanner(System.in);
        System.out.println(menu);
        opcion = referencia.nextInt();
        while (opcion != 0) {

            switch (opcion) {

                default:
                    System.out.println("Opción no valida");

                case 0:
                    System.out.println("Saliendo del programa, gracias por utilizar nuestros servicios");

                case 1:
                    Scanner usuario = new Scanner(System.in);
                    System.out.println("\nEscriba el articulo que desea comprar:");
                    String articulo = usuario.next();

                    System.out.println("\nEscriba el costo del articulo:");
                    double costo = Double.valueOf(usuario.next());

                    Compra compra = new Compra(articulo, costo);
                    boolean compraRealizada = nuevaTarjeta.lanzarCompra(compra);

                    if (compraRealizada) {
                        System.out.println("\nCompra realizada");
                        System.out.println("\nEscriba 1 para continuar o 0 para salir");
                        opcion = referencia.nextInt();

                    } else {
                        System.out.println("\nSaldo Insuficiente");
                        opcion = 0;
                    }
            }
        }

        System.out.println("*****************************************\n");
        System.out.println("COMPRAS REALIZADAS:\n");
        Collections.sort(nuevaTarjeta.getListaDeCompras());
        for (Compra compra : nuevaTarjeta.getListaDeCompras()) {
            System.out.println(compra.getArticulo() + " - " + compra.getValor());
        }

        System.out.println("\n*****************************************");
        System.out.println("\n Saldo de la tarjeta: " + nuevaTarjeta.getSaldo());
    }
}