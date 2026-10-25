package com.jobfinder.search_for_jobs.dto;

import com.jobfinder.search_for_jobs.model.Jobs;

public record JobResponseData(String title, String link, String stateJob) {

    public JobResponseData(Jobs jobs){
        this(jobs.getTitle(), jobs.getLink(), jobs.getStateJob());
    }

}
