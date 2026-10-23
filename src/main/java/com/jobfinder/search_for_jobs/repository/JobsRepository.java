package com.jobfinder.search_for_jobs.repository;

import com.jobfinder.search_for_jobs.model.Jobs;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobsRepository extends JpaRepository<Jobs, Long> {

    boolean  existsByLink(String link);

    /*boolean verifyDate (LocalDate dataCadastro);*/

   //List<Jobs> findByTitle(String jobs);

    /*List<Jobs> saveAll(List<Jobs> jobs);*/

}
