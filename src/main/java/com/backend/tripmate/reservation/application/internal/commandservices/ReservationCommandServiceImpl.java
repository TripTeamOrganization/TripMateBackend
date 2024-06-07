package com.backend.tripmate.reservation.application.internal.commandservices;

import com.backend.tripmate.reservation.domain.model.commands.ReservationCommandService;
import com.backend.tripmate.reservation.domain.model.entities.Reservation;
import com.backend.tripmate.reservation.domain.model.commands.CreateReservationCommand;
import com.backend.tripmate.reservation.infrastructure.persistence.jpa.repositories.ReservationRepository;
import com.backend.tripmate.user.infrastructure.persistence.jpa.repositories.UserRepository;
import com.backend.tripmate.reservation.infrastructure.persistence.jpa.repositories.PaymentMethodRepository;
import com.backend.tripmate.reservation.infrastructure.persistence.jpa.repositories.PriceDetailsRepository;
import com.backend.tripmate.reservation.domain.model.entities.PaymentMethod;
import com.backend.tripmate.reservation.domain.model.entities.PriceDetails;
import com.backend.tripmate.user.domain.model.entities.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationCommandServiceImpl implements ReservationCommandService {
    private final ReservationRepository reservationRepository;
    private final UserRepository userRepository;
    private final PaymentMethodRepository paymentMethodRepository;
    private final PriceDetailsRepository priceDetailsRepository;
    private static final Logger logger = LoggerFactory.getLogger(ReservationCommandServiceImpl.class);

    @Autowired
    public ReservationCommandServiceImpl(ReservationRepository reservationRepository, UserRepository userRepository, PaymentMethodRepository paymentMethodRepository, PriceDetailsRepository priceDetailsRepository) {
        this.reservationRepository = reservationRepository;
        this.userRepository = userRepository;
        this.paymentMethodRepository = paymentMethodRepository;
        this.priceDetailsRepository = priceDetailsRepository;
    }

    @Override
    public void handle(CreateReservationCommand command) {
        User user = userRepository.findById(command.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        PaymentMethod paymentMethod = new PaymentMethod();
        paymentMethod.setId(command.getPaymentMethod().getId());
        paymentMethod.setNombreTarjeta(command.getPaymentMethod().getNombreTarjeta());
        paymentMethod.setNumeroTarjeta(command.getPaymentMethod().getNumeroTarjeta());
        paymentMethod.setMesExpiracion(command.getPaymentMethod().getMesExpiracion());
        paymentMethod.setAnoExpiracion(command.getPaymentMethod().getAnoExpiracion());
        paymentMethod.setCodigoSeguridad(command.getPaymentMethod().getCodigoSeguridad());
        paymentMethod.setCodigoPostal(command.getPaymentMethod().getCodigoPostal());
        paymentMethod = paymentMethodRepository.save(paymentMethod);

        PriceDetails priceDetails = new PriceDetails();
        priceDetails.setId(command.getPriceDetails().getId());
        priceDetails.setTotal(command.getPriceDetails().getTotal());
        priceDetails.setCuponDescuento(command.getPriceDetails().getCuponDescuento());

        logger.info("Total value: " + command.getPriceDetails().getTotal());
        priceDetails = priceDetailsRepository.save(priceDetails);

        Reservation reservation = new Reservation();
        reservation.setUser(user);
        reservation.setPaymentMethod(paymentMethod);
        reservation.setPriceDetails(priceDetails);

        reservationRepository.save(reservation);
    }
}