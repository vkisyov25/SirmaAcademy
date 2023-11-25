package com.sirma.academy.webProject.Controller;

import com.sirma.academy.webProject.Model.Reservation;
import com.sirma.academy.webProject.Service.ReservationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.regex.Pattern;

@RestController
@RequestMapping("/reservation")
public class ReservationController {
    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @PostMapping("/make")
    public void makeReservation(@RequestBody Reservation reservation) {
        reservationService.saveReservaton(reservation);
    }

    @GetMapping("/allReservationByID/{id}")
    public List<Reservation> allReservationByID(@PathVariable long id) {
        return ReservationService.getAllReservationByUser_id(id);
    }
}
