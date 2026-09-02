package com.jobfinder.search_for_jobs.service;


import com.jobfinder.search_for_jobs.client.Gupy;
import com.jobfinder.search_for_jobs.dto.JobResponse;

import com.jobfinder.search_for_jobs.dto.JobsResponse;
import com.jobfinder.search_for_jobs.mapper.JobMapper;
import com.jobfinder.search_for_jobs.model.Jobs;
import com.jobfinder.search_for_jobs.repository.JobsRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class JobsService {

    private final JobsRepository jobsRepository;
    private final JobMapper jobMapper;
    private final Gupy gupy;


    public JobsService (JobsRepository jobRepository, JobMapper jobMapper, Gupy gupy){
        this.jobsRepository = jobRepository;
        this.jobMapper = jobMapper;
        this.gupy = gupy;

    }


  /* public Jobs saveJob (JobResponse jobResponse){

        Jobs job = new Jobs();

        JobsResponse jobsResponse = new JobsResponse();
        jobsResponse.setData(gupy.searchForJob().getData());

        int sized = jobsResponse.getData().size();

        for (int i = 0; i < sized; i++) {

            jobResponse = jobsResponse.getData().get(i);
        }

        job = jobsRepository.save(jobMapper.toEntity(jobResponse));

        return job;

   }*/

    public List<Jobs> saveJob (){

        List<Jobs> jobs = new ArrayList<>();

        List<JobResponse> jobResponse = new ArrayList<>();

        JobsResponse jobsResponse = new JobsResponse();
        jobsResponse.setData(gupy.searchForJob().getData());

        int sized = jobsResponse.getData().size();

        int i = 0;
        while(i < sized){

            // Verificar se a vaga existe ou não para poder salva-lá

            jobs.add(jobsRepository.save(jobMapper.toEntity(jobsResponse.getData().get(i))));
            i++;
        }


        return jobs;


    }

   public List<Jobs> findAll() {

       List<Jobs> jobs = new ArrayList<>();
       jobsRepository.findAll();

       return jobs;

   }

}
