package com.jobfinder.search_for_jobs.client;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service //mas usar @Component
public class Gupy {

  private final HttpClient client = HttpClient.newHttpClient();

  public String searchForJob() {
      //https://employability-portal.gupy.io/api/v1/jobs?jobName=Desenvolvedor%20Junior
     //https://employability-portal.gupy.io/api/company/Assistente%20Administrativo

   HttpRequest request = HttpRequest.newBuilder()
           .uri(URI.create("https://employability-portal.gupy.io/api/v1/jobs?jobName=Desenvolvedor%20Junior"))
           .GET()
           .build();

      try {

          HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

          System.out.println("Enviado com sucesso! Código status: " + response.statusCode());

          return response.body();

      } catch (IOException | InterruptedException e) {

          throw new RuntimeException("Erro ao conectar com a API da Gupy", e);
      }

  }
}
