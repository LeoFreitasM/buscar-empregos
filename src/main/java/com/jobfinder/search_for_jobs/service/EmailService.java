package com.jobfinder.search_for_jobs.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jobfinder.search_for_jobs.dto.JobResponseData;
import com.jobfinder.search_for_jobs.mapper.JobMapper;
import com.jobfinder.search_for_jobs.model.Jobs;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private ObjectMapper objectMapper;

    private final JobsService jobsService;
    private final JobMapper jobMapper;

    @Value("${spring.mail.username}")
    private String remetente;

    public EmailService(JobsService jobsService, JobMapper jobMapper) {
        this.jobsService = jobsService;
        this.jobMapper = jobMapper;
    }

    public String enviarEmailTexto(String destinatario, String assunto, List<JobResponseData> jobResponseData) {


        jobResponseData = jobsService.findAll();
        List<Jobs> jobs = new ArrayList<>();

        try {

            List<JobResponseData> salvar = new ArrayList<>();
            System.out.println(jobResponseData);

            int i = 0;
            while (i < jobResponseData.size()) {

                //if (jobs.get(i).getDate().toLocalDate().isEqual(LocalDate.now())) {
                    salvar.add(jobResponseData.get(i));
              //  }
                i++;
            }

            String jsonString = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(salvar);

            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper message = new MimeMessageHelper(mimeMessage, true, "UTF-8");

            message.setFrom(remetente);
            message.setTo(destinatario);
            message.setSubject(assunto);

            String corpoHtml = "<pre style='font-family: monospace; font-size: 14px;'>" + " <br> " + jsonString + "<br>" + "</pre>";

            message.setText(corpoHtml, true);
            javaMailSender.send(mimeMessage);

            System.out.println(jsonString);
            return "Email enviado.";

        } catch (Exception e) {
            return "Erro ao enviar email " + e.getLocalizedMessage();
        }
    }

}
