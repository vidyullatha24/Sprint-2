package com.cg.sprint.fms.service;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.lvg.fms.dao.FlightScheduleDAO;
import com.lvg.fms.dto.FlightSchedule;

@Service
public abstract class FlightScheduleService 
{
	FlightScheduleDAO fsdao;
	public void setFsdao(FlightScheduleDAO fsdao) { this.fsdao=fsdao; }

	@Transactional(readOnly=true)
	public Optional<FlightSchedule> getFlightSchedule(String scheduleId)
	{
		return fsdao.findById(scheduleId);
	}

	@Transactional(readOnly=true)
	public List<FlightSchedule> getAllFlightSchedules()
	{
		return fsdao.findAll();
	}

	@Transactional
	public FlightSchedule addFlightSchedule(FlightSchedule flightSchedule)
	{
		return fsdao.save(flightSchedule);
	}

	@Transactional
	public void updateFlightSchedule(FlightSchedule flightschedule)
	{
		fsdao.save(flightschedule);
	}

	@Transactional
	public void deleteFlightSchedule(String scheduleId)
	{
		fsdao.deleteById(scheduleId);
	}
}
