package com.aluracursos.conversordemonedas.modelos;

import com.google.gson.annotations.SerializedName;

import java.util.Map;

public class monedaConvertir {
    float cantidad;
    @SerializedName("conversion_rates")
    public Map<String, Float> tipoDeCambio;
    Float tasaDeCambio;
    String monedaDestino;

    @Override
    public String toString() {
        return "Rangos de ocnversion: "+tipoDeCambio+"\n"+
                "Cantidad a convertir:"+cantidad+"\n"+
                "Tipo de moneda final: "+monedaDestino;
    }
    public float buscarTasaDeConversion(){
        tasaDeCambio=tipoDeCambio.get(monedaDestino);
        if (tasaDeCambio!=null){
            return cantidad*tasaDeCambio;
        }else {
            return 0;
        }
    }
    public void mostrarResultadoDeLaConversion(){
        try{
            if (buscarTasaDeConversion()!=0){
                System.out.println("La cantidad convertida es: "+buscarTasaDeConversion()+" "+monedaDestino);
            }else{
                System.out.println("Conversion no posible.");
            }
        }catch (Exception e){
            System.out.println("La convesion fallos: "+e.toString());
        }
    }
    public void setTasaDeCambio(float tasaDeCambio) {
        this.tasaDeCambio = tasaDeCambio;
    }
    public void setCantidad(float cantidad) {
        this.cantidad = cantidad;
    }
    public void setMonedaDestino(String monedaDestino){
        this.monedaDestino=monedaDestino;
    }
}
