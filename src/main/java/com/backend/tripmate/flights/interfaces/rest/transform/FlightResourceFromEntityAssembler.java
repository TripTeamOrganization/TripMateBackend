package com.backend.tripmate.flights.interfaces.rest.transform;

import com.backend.tripmate.flights.domain.model.entities.Flight;
import com.backend.tripmate.flights.interfaces.rest.resources.FlightResource;

public class FlightResourceFromEntityAssembler {
    public static FlightResource toResourceFromEntity(Flight flight) {
        FlightResource resource = new FlightResource();
        resource.setIdVuelo(flight.getIdVuelo());
        resource.setNombreAerolinea(flight.getNombreAerolinea());
        resource.setFechaHoraVuelo(flight.getFechaHoraVuelo().toString());
        resource.setNumeroAsiento(flight.getNumeroAsiento());
        resource.setDestino(flight.getDestino());
        resource.setPrecio(flight.getPrecio());
        resource.setDescuento(flight.getDescuento());
        resource.setIdTipoVuelo(flight.getIdTipoVuelo());
        return resource;
    }
}
