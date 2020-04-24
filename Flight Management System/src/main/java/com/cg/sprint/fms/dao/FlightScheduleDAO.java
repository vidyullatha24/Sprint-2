package com.cg.sprint.fms.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.sprint.fms.dto.FlightSchedule;
@Repository
public interface FlightScheduleDAO  extends JpaRepository<FlightSchedule,String>
{

}
