package com.jobfinder.search_for_jobs.client;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jobfinder.search_for_jobs.dto.JobResponse;
import com.jobfinder.search_for_jobs.dto.JobsResponse;
import com.jobfinder.search_for_jobs.mapper.JobMapper;
import com.jobfinder.search_for_jobs.model.Jobs;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Component
public class Gupy {

  private final HttpClient client = HttpClient.newHttpClient();

  public JobsResponse searchForJob() {
      //https://employability-portal.gupy.io/api/v1/jobs?jobName=Desenvolvedor%20Junior
     //https://employability-portal.gupy.io/api/company/jobs?jobName=Assistente%20Administrativo

   HttpRequest request = HttpRequest.newBuilder()
           .uri(URI.create("https://employability-portal.gupy.io/api/v1/jobs?jobName=Desenvolvedor%20Junior"))
           .GET()
           .build();

      try {

          HttpResponse<String> response = client.send(
                  request, HttpResponse.BodyHandlers.ofString());

          ObjectMapper objectMapper = new ObjectMapper();

          JobsResponse jobsResponse = objectMapper.readValue(response.body(), JobsResponse.class);

          System.out.println("Enviado com sucesso! Código status: " + response.statusCode());

          return jobsResponse;

      } catch (IOException | InterruptedException e) {

          throw new RuntimeException("Erro ao conectar com a API da Gupy", e);
      }

  }
}
