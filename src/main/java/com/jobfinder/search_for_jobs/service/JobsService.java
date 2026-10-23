package com.jobfinder.search_for_jobs.service;


import com.jobfinder.search_for_jobs.client.Gupy;
import com.jobfinder.search_for_jobs.dto.JobResponse;

import com.jobfinder.search_for_jobs.dto.JobResponseData;
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


    public JobsService(JobsRepository jobRepository, JobMapper jobMapper, Gupy gupy) {
        this.jobsRepository = jobRepository;
        this.jobMapper = jobMapper;
        this.gupy = gupy;

    }

    public List<Jobs> saveJob() {

        List<Jobs> jobs = new ArrayList<>();

        List<JobResponse> jobResponse = new ArrayList<>();

        JobsResponse jobsResponse = new JobsResponse();
        jobsResponse.setData(gupy.searchForJob().getData());

        jobResponse = jobsResponse.getData();


        System.out.println(jobsResponse.getData());
        int i = 0;
        while (i < jobsResponse.getData().size()) {

            //if (jobResponse.get(i).getCity().equals("São Paulo")) {
            jobs.add(jobsRepository.save(jobMapper.toEntity(jobResponse.get(i))));
            //}
            i++;
        }
        return jobs;
    }

    public List<JobResponseData> findAll() {

        return jobsRepository.findAll().stream().map(JobResponseData::new).toList();


    }

}
