package com.aluracursos.conversordemonedas.principal;

import com.aluracursos.conversordemonedas.modelos.clientConsulta;
import com.aluracursos.conversordemonedas.modelos.monedaConvertir;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner teclado=new Scanner(System.in);
        System.out.println("Digite el tipo de moneda que quiere convertir: ");
        String monedaConvertir= teclado.nextLine();
        clientConsulta clienteConsulta=new clientConsulta(monedaConvertir);
        System.out.println(clienteConsulta.getMonedaAConvertir());
        System.out.println(clienteConsulta.getDireccionConsulta());
        monedaConvertir monedaDestino=clienteConsulta.generarClaseMonedaCovertir();
        System.out.println("Digite la cantidad de dinero que desea transformar: ");
        String cantidadConvertida= teclado.nextLine();
        monedaDestino.setCantidad(Float.parseFloat(cantidadConvertida));
        System.out.println("Digite el tipo de moenda a la que convirtamos sus "+monedaConvertir+": ");
        String monedaConvertida=teclado.nextLine();
        monedaDestino.setMonedaDestino(monedaConvertida);
        monedaDestino.mostrarResultadoDeLaConversion();
    }
}