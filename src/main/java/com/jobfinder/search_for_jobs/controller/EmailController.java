package com.jobfinder.search_for_jobs.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jobfinder.search_for_jobs.dto.JobResponseData;
import com.jobfinder.search_for_jobs.dto.JobsResponse;
import com.jobfinder.search_for_jobs.mapper.JobMapper;
import com.jobfinder.search_for_jobs.model.Jobs;
import com.jobfinder.search_for_jobs.service.EmailService;
import com.jobfinder.search_for_jobs.service.JobsService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/email")
public class EmailController {

    private EmailService emailService;
    private JobsService jobsService;


    public EmailController(EmailService emailService,  JobsService jobsService){
        this.emailService = emailService;
        this.jobsService = jobsService;
    }

    @GetMapping("/envioemail")
    public String envioemail(){

       List<JobResponseData> jobResponseData = new ArrayList<>();
        jobResponseData = jobsService.findAll();

        emailService.enviarEmailTexto( "\n " + "leofreitas798@gmail.com",  "\n" +
                "Vagas para Desenvolvedor Júnior",
                jobResponseData);


        return "Sucesso ao enviar email" ;
    }

}
