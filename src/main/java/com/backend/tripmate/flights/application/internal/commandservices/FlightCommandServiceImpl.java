package com.backend.tripmate.flights.application.internal.commandservices;

import com.backend.tripmate.flights.domain.model.commands.CreateFlightCommand;
import com.backend.tripmate.flights.domain.model.entities.Flight;
import com.backend.tripmate.flights.infrastructure.persistence.jpa.repositories.FlightRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class FlightCommandServiceImpl {
    private final FlightRepository flightRepository;

    public FlightCommandServiceImpl(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    public void handle(CreateFlightCommand createFlightCommand) {
        Flight flight = new Flight();
        flight.setNombreAerolinea(createFlightCommand.getNombreAerolinea());
        flight.setFechaHoraVuelo(LocalDateTime.parse(createFlightCommand.getFechaHoraVuelo()));
        flight.setNumeroAsiento(createFlightCommand.getNumeroAsiento());
        flight.setDestino(createFlightCommand.getDestino());
        flight.setPrecio(createFlightCommand.getPrecio());
        flight.setDescuento(createFlightCommand.getDescuento());
        flight.setIdTipoVuelo(createFlightCommand.getIdTipoVuelo());
        flightRepository.save(flight);
    }
}
