package com.sirma.academy.webProject.Controller;

import com.sirma.academy.webProject.Model.Reservation;
import com.sirma.academy.webProject.Service.ReservationService;
import com.sirma.academy.webProject.Validation.ReservationValidation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<String> makeReservation(@RequestBody Reservation reservation) {
        if(ReservationValidation.reservationValidation(reservation)){
            reservationService.saveReservaton(reservation);
        }else {
            return new ResponseEntity<>("Invalid data format", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>("Successfully reservation", HttpStatus.OK);
    }

    @GetMapping("/allReservationByID/{id}")
    public List<Reservation> allReservationByID(@PathVariable long id) {
        return ReservationService.getAllReservationByUser_id(id);
    }
}
