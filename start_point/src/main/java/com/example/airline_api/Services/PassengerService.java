package com.example.airline_api.Services;

import com.example.airline_api.models.Flight;
import com.example.airline_api.models.Passenger;
import com.example.airline_api.repositories.FlightRepository;
import com.example.airline_api.repositories.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PassengerService {
    @Autowired
    PassengerRepository passengerRepository;

    @Autowired
    FlightRepository flightRepository;

    public List<Passenger> getAllPassengers() {
        return passengerRepository.findAll();
    }

    public Optional<Passenger> getPassengerById(Long id) {
        return passengerRepository.findById(id);
    }

    public Passenger savePassenger(Passenger passenger) {
        return passengerRepository.save(passenger);
    }

    public Passenger updatePassenger(Long id, Passenger newPassenger) {
        Optional<Passenger> optionalPassenger = passengerRepository.findById(id);
        if (optionalPassenger.isPresent()) {
            Passenger passenger = optionalPassenger.get();
            passenger.setName(newPassenger.getName());
            passenger.setEmail(newPassenger.getEmail());
            return passengerRepository.save(passenger);
        }
        return null;
    }

    public void deletePassenger(Long id) {
        passengerRepository.deleteById(id);
    }

    public Passenger bookFlight(Long passengerId, Long flightId) {
        Optional<Passenger> optionalPassenger = passengerRepository.findById(passengerId);
        if (optionalPassenger.isPresent()) {
            Passenger passenger = optionalPassenger.get();
            Optional<Flight> optionalFlight = flightRepository.findById(flightId);
            if (optionalFlight.isPresent()) {
                Flight flight = optionalFlight.get();
                if (flight.getPassengers().size() < flight.getCapacity()) {
                    passenger.getFlights().add(flight);
                    return passengerRepository.save(passenger);
                }
            }
        }
        return null;
    }

    public Passenger createPassenger(Passenger passenger) {
        return passenger;
    }
}
