package org.example.Services;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.Entities.Reciclagem;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class ConsultaCodBarrasAPI {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o código de barras (GTIN): ");
        String gtin = scanner.nextLine();

        String url = "https://api.cosmos.bluesoft.com.br/gtins/" + gtin;
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .header("User-Agent", "Cosmos-API-Request")
                .header("X-Cosmos-Token", "DADkHujMMbPF0EEvsTLFgQ")
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        String responseBody = response.body();

        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonNode = mapper.readTree(responseBody);

        String description = jsonNode.get("description").asText();
        String gtinValue = jsonNode.get("gtin").asText();
        String thumbnail = jsonNode.get("thumbnail").asText();

        Reciclagem reciclagem = new Reciclagem();
        reciclagem.setTitulo(description);
        reciclagem.setCod_barras(gtinValue);
        reciclagem.setThumbnail(thumbnail);

        System.out.println("Produto criado:");
        System.out.println("Título: " + reciclagem.getTitulo());
        System.out.println("Código de barras: " + reciclagem.getCod_barras());
        System.out.println("Thumbnail: " + reciclagem.getThumbnail());
    }
}