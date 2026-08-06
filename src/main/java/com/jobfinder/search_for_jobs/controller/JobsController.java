package com.jobfinder.search_for_jobs.controller;

import com.jobfinder.search_for_jobs.client.Gupy;

import com.jobfinder.search_for_jobs.dto.JobResponse;
import com.jobfinder.search_for_jobs.dto.JobsResponse;
import com.jobfinder.search_for_jobs.mapper.JobMapper;
import com.jobfinder.search_for_jobs.model.Jobs;
import com.jobfinder.search_for_jobs.service.JobsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/jobs")
public class JobsController {

    private final JobsService jobsService;
    private final Gupy gupy;
    private final JobMapper jobMapper;

    public JobsController(JobsService jobsService, JobMapper jobMapper, Gupy gupy, JobMapper jobMapper1) {
        this.jobsService = jobsService;
        this.gupy = gupy;
        this.jobMapper = jobMapper1;
    }

    @GetMapping("/searchJobs")
    public List<Jobs> saveJobs(){

        return jobsService.saveJob();
    }

    @GetMapping("/searchData")
    public List<Jobs> findAll(){

       return jobsService.findAll();
    }

}
