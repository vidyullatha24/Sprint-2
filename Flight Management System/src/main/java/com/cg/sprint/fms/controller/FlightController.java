package com.cg.sprint.fms.controller;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.lvg.fms.dto.Flight;
import com.lvg.fms.service.FlightService;

@RestController
public class FlightController 
{
	@Autowired
	FlightService flightService;
	public void setFlightService(FlightService flightService)
	{
		this.flightService = flightService;
	}
	@GetMapping(value="/getFlight/{flightNo}",produces="application/json")
	public ResponseEntity<Optional<Flight>> getFlight(@PathVariable String flightNo)
	{
		Optional<Flight> flight =  flightService.getFlight(flightNo);
		if(flight.isPresent())
			return new ResponseEntity<Optional<Flight>>(flight,HttpStatus.OK);
		return new ResponseEntity<Optional<Flight>>(flight,HttpStatus.NOT_FOUND);
	}
	@GetMapping(value="/getFlights",produces="application/json")
	public List<Flight> getFlights()
	{
		return flightService.getFlights();
	}
	@PostMapping(value="/addFlight",consumes="application/json")
	public ResponseEntity<String> addFlight(@RequestBody()Flight flight)
	{
		try
		{
			flightService.addFlight(flight);
			return new ResponseEntity<String>("Flight details added",HttpStatus.OK);
		}
		catch (Exception ex) 
		{
			return new ResponseEntity<String>(ex.getMessage()+"Failed to add",HttpStatus.BAD_REQUEST);
		}

	}

	/*@PutMapping(value="/updateFlight",consumes="application/json")
     public void updateFlight(@RequestBody() Flight flight)
     {
   	    flightService.updateFlight(flight);
     } */
	@DeleteMapping("/deleteFlight/{flightNo}")
	public ResponseEntity<String> deleteFlight(@PathVariable String flightNo)
	{
		try
		{
			flightService.deleteFlight(flightNo);
			return new ResponseEntity<String>("Flight Details Deleted Successfully",HttpStatus.OK);
		}
		catch(Exception ex)
		{
			return new ResponseEntity<String>("Deletion Failed",HttpStatus.BAD_REQUEST);
		}
	}

}

