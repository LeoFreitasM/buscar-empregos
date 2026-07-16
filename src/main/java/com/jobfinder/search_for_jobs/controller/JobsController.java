package com.jobfinder.search_for_jobs.controller;

import com.jobfinder.search_for_jobs.client.Gupy;
import com.jobfinder.search_for_jobs.service.JobsService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/jobs")
public class JobsController {

    private final JobsService jobsService;
    private final Gupy gupy;

    public JobsController(JobsService jobsService, Gupy gupy) {
        this.jobsService = jobsService;
        this.gupy = gupy;
    }

    @GetMapping("/teste")
    public String saveJobs(){
        return gupy.searchForJob();
    }

}
