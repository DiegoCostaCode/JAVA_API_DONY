package org.example.Services;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.Entities.Produto;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class CosmoAPI{
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

        Produto produto = new Produto();
        produto.setTitulo(description);
        produto.setCod_barras(gtinValue);
        produto.setThumbnail(thumbnail);

        System.out.println("Produto criado:");
        System.out.println("Título: " + produto.getTitulo());
        System.out.println("Código de barras: " + produto.getCod_barras());
        System.out.println("Thumbnail: " + produto.getThumbnail());
    }
}