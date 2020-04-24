package com.cg.sprint.fms.service;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.lvg.fms.dao.FlightDAO;
import com.lvg.fms.dto.Flight;

@Service
public class FlightService 
{
   @Autowired
   FlightDAO fdao;
   public void setFdao(FlightDAO fdao) { this.fdao=fdao; }
   
   @Transactional(readOnly=true)
   public Optional<Flight> getFlight(String flightNo)
   {
	   return fdao.findById(flightNo);
   }
   
   @Transactional(readOnly=true)
   public List<Flight> getFlights()
   {
	   return fdao.findAll();
   }
   
   @Transactional
   public Flight addFlight(Flight flight)
   {
	   return fdao.save(flight);
   }
   
   @Transactional
   public void deleteFlight(String flightNo)
   {
	   fdao.deleteById(flightNo);
   }
}
