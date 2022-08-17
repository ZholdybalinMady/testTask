package com.intexsoft.task.repository;

import com.intexsoft.task.entity.WorkPeriod;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkPeriodRepository extends JpaRepository<WorkPeriod, Long> {

    List<WorkPeriod> findByTeamId(Long teamId);

}
