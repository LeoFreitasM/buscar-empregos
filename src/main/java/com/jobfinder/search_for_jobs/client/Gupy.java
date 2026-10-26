package com.jobfinder.search_for_jobs.client;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jobfinder.search_for_jobs.dto.JobsResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


@Component
public class Gupy {

  private final HttpClient client = HttpClient.newHttpClient();

  public Gupy(){

  }

  public JobsResponse searchForJob() {
      //https://portal.gupy.io/api/job-search/jobs?jobName=Desenvolvedor%20Junior&limit=20&offset=100
      //https://portal.gupy.io/api/job-search/jobs?jobName=assistente%20administrativo&limit=20&offset=20

   HttpRequest request = HttpRequest.newBuilder()
           .uri(URI.create("https://portal.gupy.io/api/job-search/jobs?jobName=analista%20sistemas&limit=20&offset=20"))
           .GET()
           .build();

      try {

          HttpResponse<String> response = client.send(
                  request, HttpResponse.BodyHandlers.ofString());

          ObjectMapper objectMapper = new ObjectMapper();

          JobsResponse jobsResponse = objectMapper.readValue(response.body(), JobsResponse.class);

          System.out.println(jobsResponse.getData());


          System.out.println("Enviado com sucesso! Código status: " + response.statusCode());

          return jobsResponse;


      } catch (IOException | InterruptedException e) {

          throw new RuntimeException("Erro ao conectar com a API da Gupy" + e);
      }

  }
}
