package com.jobfinder.search_for_jobs.mapper;

import com.jobfinder.search_for_jobs.client.Gupy;
import com.jobfinder.search_for_jobs.dto.JobResponse;
import com.jobfinder.search_for_jobs.model.Jobs;
import org.springframework.stereotype.Component;

@Component
public class JobMapper {

    private final Gupy gupy;

    public JobMapper(Gupy gupy){
        this.gupy = gupy;
    }

    public Jobs toEntity(JobResponse response){

        Jobs job = new Jobs();

        job.setTitle(response.getName());
        job.setLink(response.getJobUrl());

        return job;
    }
}
