package org.example.Services;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.Entities.Material;
import org.example.Entities.Reciclagem;
import org.example.Entities.Usuario;
import org.example.Infrastructure.Loggable;
import org.example.Repository.MaterialRepository;
import org.example.Repository.ReciclagemRepository;
import org.example.Repository.UsuarioRepository;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsultaCodBarrasAPI extends UsuarioRepository implements Loggable<String> {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner scanner = new Scanner(System.in);

        ObjectMapper mapper = new ObjectMapper();

        Reciclagem reciclagem = new Reciclagem();

        UsuarioRepository usuarioRepository = new UsuarioRepository();
        MaterialRepository materialRepository = new MaterialRepository();
        ReciclagemRepository reciclagemRepository = new ReciclagemRepository();

        List<Usuario> usuarios = usuarioRepository.Read();
        List<Material> materiais = materialRepository.Read();

        System.out.print("Digite o seu ID: ");
        int Id = scanner.nextInt();

        Usuario usuarioID = null;

        usuarioID = usuarios.stream()
                .filter(u -> u.getId_entidade() == Id)
                .findFirst()
                .orElse(null);

        if (usuarioID == null) {
            Loggable.logInfo("ID inválido. Por favor, se cadastre para cadastrar produtos.");
            return;
        }

        System.out.println("Bem-vindo " + usuarioID.getNome_usuario());

        System.out.print("De 1 a 3, por favor, escolha a categoria do produto reciclável: \n 1 - Plástico;\n 2 - Lata;\n 3 - Vidro;\n");
        int category = scanner.nextInt();
        scanner.nextLine();

        Material material = null;
        switch (category) {
            case 1:
                material = materiais.stream().filter(m -> m.getId_entidade() == 3).findFirst().orElse(null);
                break;
            case 2:
                material = materiais.stream().filter(m -> m.getId_entidade() == 4).findFirst().orElse(null);
                break;
            case 3:
                material = materiais.stream().filter(m -> m.getId_entidade() == 6).findFirst().orElse(null);
                break;
            default:
                Loggable.logInfo("Material não encontrado. Por favor, escolha novamente");
                return;
        }

        if (material == null) {
            System.out.println("Material não encontrado. Por favor, escolha novamente.");
            return;
        }


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
        if (response.statusCode()!= 200) {
            System.out.println("Erro ao consultar o código de barras. Código de status: " + response.statusCode());
            return;
        }

        String responseBody = response.body();

        JsonNode jsonNode;
        try {
            jsonNode = mapper.readTree(responseBody);
        } catch (JsonParseException e) {
            Loggable.logInfo("Erro ao parsear o JSON: " + e.getMessage());
            return;
        }

        String description = jsonNode.get("description").asText();
        String gtinValue = jsonNode.get("gtin").asText();
        String thumbnail = jsonNode.get("thumbnail").asText();

        reciclagem.setTitulo(description);
        reciclagem.setCod_barras(gtinValue);
        reciclagem.setThumbnail(thumbnail);
        reciclagem.setMaterial_id(material);
        reciclagem.setUsuario_id(usuarioID);

        reciclagemRepository.Create(reciclagem);

        System.out.println("Produto criado:");
        System.out.println("Título: " + reciclagem.getTitulo());
        System.out.println("Código de barras: " + reciclagem.getCod_barras());
        System.out.println("Thumbnail: " + reciclagem.getThumbnail());
        System.out.println("Usuário: " + reciclagem.getUsuario_id().getId_entidade());
        System.out.println("Material: " + reciclagem.getMaterial_id().getNome_material());
    }
}