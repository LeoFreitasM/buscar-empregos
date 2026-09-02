package com.jobfinder.search_for_jobs.repository;

import com.jobfinder.search_for_jobs.dto.JobResponse;
import com.jobfinder.search_for_jobs.model.Jobs;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobsRepository extends JpaRepository<Jobs, Long> {

    JobResponse existsByLink(String link);

    /*List<Jobs> saveAll(List<Jobs> jobs);*/

}
