package com.jobfinder.search_for_jobs.dto;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class JobsResponse {

    List<JobResponse> data;

    public JobsResponse() {

    }

    public List<JobResponse> getData() {
        return data;
    }

    public void setData(List<JobResponse> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "JobsResponse{" +
                "data=" + data +
                '}';
    }
}
