package com.sirma.academy.webProject.Service;

import com.sirma.academy.webProject.Model.Reservation;
import com.sirma.academy.webProject.Repository.ReservationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService {
    private final ReservationRepository reservationRepository;

    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public Reservation reservationByUser_id(long id){
        return reservationRepository.getReferenceById(id);
    }

    public void saveReservaton(Reservation reservation){
        reservationRepository.save(reservation);
    }

    /*public List<Reservation> getAllReservationByUser_id(long id){
        List<Reservation> reservationList = null;
        System.out.println(reservationRepository.getReferenceById(id));
        while (reservationRepository.getReferenceById(id)!= null){
            reservationList.add(reservationRepository.getReferenceById(id));
        }
        return reservationList;
    }*/
}
