package org.example.Services;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.Entities.Instituicao;
import org.example.Entities.Noticia;
import org.example.Entities.Usuario;
import org.example.Infrastructure.Loggable;
import org.example.Repository.NoticiaRepository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class NoticiasOceano implements Loggable<String> {

    public static void main(String[] args) throws IOException, InterruptedException {

        NoticiaRepository noticiaRepository = new NoticiaRepository();
        Usuario usuario = new Usuario();

        Noticia noticia = new Noticia();

        Instituicao instituicao = new Instituicao();

        String query = "q=poluição+oceano+animais+marinhos";
        String language = "language=pt";
        String apiKey = "apiKey=fc57113b470746b1969b51d8f69b83b7";

        String api = "https://newsapi.org/v2/everything?"+ query + "&" + language +"&" + apiKey;

        HttpURLConnection connection = (HttpURLConnection) new URL(api).openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("Accept", "application/json");

        try {
            int responseCode = connection.getResponseCode();
            if (responseCode == 200) {
                // Leitura da resposta bem-sucedida
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                ObjectMapper mapper = new ObjectMapper();
                JsonNode rootNode = mapper.readTree(response.toString());
                JsonNode articles = rootNode.get("articles");

                for (JsonNode article : articles) {
                    String title = article.get("title").asText();
                    String description = article.get("description").asText();
                    String fonte = article.get("url").asText();
                    String publishedAt = article.get("publishedAt").asText();
                    String thumbnail = article.get("urlToImage").asText();

                    if (!title.contains("[Removed]") && !description.contains("[Removed]")) {

                        noticia.setTitulo_noticia(title);
                        noticia.setConteudo(description);
                        noticia.setFonte_noticia(fonte);
                        noticia.setThumbnail_noticia(thumbnail);
                        noticia.setData_publicacao(publishedAt);
                        noticiaRepository.Create(noticia);

                        System.out.println("Título: " + title);
                        System.out.println("Descrição: " + description);
                        System.out.println("URL: " + fonte);
                        System.out.println("Data: " + publishedAt);
                        System.out.println("Thumbnail: " + thumbnail);
                        System.out.println("---------------------------------");
                    }
                }
            }
        } catch (IOException e) {
            // Leitura da resposta de erro
            Loggable.logError("Error" + e.getMessage());
        }
    }
    }

