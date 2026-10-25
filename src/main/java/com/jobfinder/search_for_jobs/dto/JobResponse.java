package com.jobfinder.search_for_jobs.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class JobResponse {

    private String name;
    private String jobUrl;
<<<<<<< Updated upstream

=======
    private String state;
>>>>>>> Stashed changes

    public JobResponse(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name){
        this.name = name;
    }


    public String getJobUrl() {
        return jobUrl;
    }

    public void setJobUrl(String jobUrl) {
        this.jobUrl = jobUrl;
    }

<<<<<<< Updated upstream
=======
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

>>>>>>> Stashed changes
    @Override
    public String toString() {
        return "JobResponse{" +
                "name='" + name + '\'' +
                ", jobUrl='" + jobUrl + '\'' +
<<<<<<< Updated upstream
=======
                ", state='" + state + '\'' +
>>>>>>> Stashed changes
                '}';
    }
}
