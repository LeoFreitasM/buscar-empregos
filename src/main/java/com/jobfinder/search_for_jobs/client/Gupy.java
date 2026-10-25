package com.jobfinder.search_for_jobs.client;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jobfinder.search_for_jobs.dto.JobsResponse;
import org.springframework.stereotype.Component;
<<<<<<< Updated upstream

=======
>>>>>>> Stashed changes

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Component
public class Gupy {

  private final HttpClient client = HttpClient.newHttpClient();

<<<<<<< Updated upstream
=======
  public Gupy(){

  }

>>>>>>> Stashed changes
  public JobsResponse searchForJob() {
      //https://employability-portal.gupy.io/api/v1/jobs?jobName=Desenvolvedor%20Junior
     //https://employability-portal.gupy.io/api/company/jobs?jobName=Assistente%20Administrativo

   HttpRequest request = HttpRequest.newBuilder()
<<<<<<< Updated upstream
           .uri(URI.create("https://employability-portal.gupy.io/api/v1/jobs?jobName=Desenvolvedor%20Junior"))
=======
           .uri(URI.create("https://portal.gupy.io/api/job-search/jobs?jobName=estagio%20administrativo&limit=12&offset=0"))
>>>>>>> Stashed changes
           .GET()
           .build();

      try {

          HttpResponse<String> response = client.send(
                  request, HttpResponse.BodyHandlers.ofString());

         ObjectMapper objectMapper = new ObjectMapper();

          JobsResponse jobsResponse = objectMapper.readValue(response.body(), JobsResponse.class);

<<<<<<< Updated upstream
=======

>>>>>>> Stashed changes
          System.out.println("Enviado com sucesso! Código status: " + response.statusCode());

          return jobsResponse;

      } catch (IOException | InterruptedException e) {

          throw new RuntimeException("Erro ao conectar com a API da Gupy", e);
      }

  }
}
