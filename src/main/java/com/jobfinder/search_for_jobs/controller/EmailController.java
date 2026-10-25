package com.jobfinder.search_for_jobs.controller;

import com.jobfinder.search_for_jobs.dto.JobResponseData;
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

    //marcelaabade26732@gmail.com

    @GetMapping("/envioemail")
    public String envioemail(){

       List<JobResponseData> jobResponseData = new ArrayList<>();
        jobResponseData = jobsService.findAll();

        emailService.enviarEmailTexto( "\n " + "marcelaabade26732@gmail.com",  "\n" +
                "Vagas de ADM para Marcela",
                jobResponseData);


        return "Sucesso ao enviar email" ;
    }

}
