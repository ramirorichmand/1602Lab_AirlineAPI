package com.example.airline_api;

import com.example.airline_api.models.Flight;
import com.example.airline_api.models.Passenger;
import com.example.airline_api.services.FlightService;
import com.example.airline_api.services.PassengerService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class AirlineApiApplication<PassengerService> {

	public static void main(String[] args) {
		SpringApplication.run(AirlineApiApplication.class, args);
	}

	@RestController
	public class PassengerController {

		private final PassengerService passengerService;

		public PassengerController(PassengerService passengerService) {
			this.passengerService = passengerService;
		}

		// Define a GET request to return all passengers
		@GetMapping("/passengers")
		public List<Passenger> getAllPassengers() {
			return passengerService.getAllPassengers();
		}

		// Define a GET request to return a specific passenger by ID
		@GetMapping("/passengers/{id}")
		public Optional<Passenger> getPassengerById(@PathVariable Long id) {
			return passengerService.getPassengerById(id);
		}

		// Define a POST request to create a new passenger
		@PostMapping("/passengers")
		public Passenger createPassenger(@RequestBody Passenger passenger) {
			return passengerService.createPassenger(passenger);
		}

		// Define a PUT request to update an existing passenger
		@PutMapping("/passengers/{id}")
		public Passenger updatePassenger(@PathVariable Long id, @RequestBody Passenger passenger) {
			return passengerService.updatePassenger(id, passenger);
		}

		// Define a DELETE request to delete a passenger by ID
		@DeleteMapping("/passengers/{id}")
		public void deletePassenger(@PathVariable Long id) {
			passengerService.deletePassenger(id);
		}
	}

	@RestController
	public class FlightController {

		private final FlightService flightService;

		public FlightController(FlightService flightService) {
			this.flightService = flightService;
		}

		// Define a GET request to return all flights
		@GetMapping("/flights")
		public List<Flight> getAllFlights() {
			return flightService.getAllFlights();
		}

		// Define a GET request to return a specific flight by ID
		@GetMapping("/flights/{id}")
		public Flight getFlightById(@PathVariable Long id) {
			return flightService.getFlightById(id);
		}

		// Define a POST request to create a new flight
		@PostMapping("/flights")
		public Flight createFlight(@RequestBody Flight flight) {
			return flightService.createFlight(flight);
		}

		// Define a PUT request to update an existing flight
		@PutMapping("/flights/{id}")
		public Flight updateFlight(@PathVariable Long id, @RequestBody Flight flight) {
			return flightService.updateFlight(id, flight);
		}

		// Define a DELETE request to delete a flight by ID
		@DeleteMapping("/flights/{id}")
		public void deleteFlight(@PathVariable Long id) {
			flightService.deleteFlight(id);
		}
	}
}
