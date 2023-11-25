package com.sirma.academy.webProject.Service;

import com.sirma.academy.webProject.Model.Reservation;
import com.sirma.academy.webProject.Repository.ReservationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService {
    private static ReservationRepository reservationRepository;

    static {
        reservationRepository = null;
    }

    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public Reservation reservationByUser_id(long id) {
        return reservationRepository.getReferenceById(id);
    }

    public void saveReservaton(Reservation reservation) {
        reservationRepository.save(reservation);
    }

    public static List<Reservation> getAllReservationByUser_id(Long userId) {
        return reservationRepository.findAllByUserId(userId);
    }
}
