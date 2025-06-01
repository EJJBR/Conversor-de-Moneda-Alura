package com.aluracursos.conversordemonedas.modelos;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class clientConsulta {
    String monedaAConvertir;
    String direccionConsulta;

    public clientConsulta(String monedaAConvertir) {
        this.monedaAConvertir = monedaAConvertir;
        this.direccionConsulta="https://v6.exchangerate-api.com/v6/b26eef3f08b58eebf5ab94fa/latest/"+monedaAConvertir;
    }

    public String consulta (){
        try {
            HttpClient cliente = HttpClient.newHttpClient();
            HttpRequest consulta=HttpRequest.newBuilder().uri(URI.create(direccionConsulta)).build();
            HttpResponse<String>respuesta=cliente.send(consulta, HttpResponse.BodyHandlers.ofString());
            String json=respuesta.body();
            return json;
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public monedaConvertir generarClaseMonedaCovertir(){
        Gson gson=new Gson();
        monedaConvertir monedaDestino=gson.fromJson(this.consulta(), monedaConvertir.class);
        return monedaDestino;
    }
    public String getMonedaAConvertir() {
        return monedaAConvertir;
    }

    public void setMonedaAConvertir(String monedaAConvertir) {
        this.monedaAConvertir = monedaAConvertir;
    }

    public String getDireccionConsulta() {
        return direccionConsulta;
    }
}
