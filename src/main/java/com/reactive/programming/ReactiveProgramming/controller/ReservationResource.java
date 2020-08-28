package com.reactive.programming.ReactiveProgramming.controller;

import com.reactive.programming.ReactiveProgramming.model.Reservation;
import com.reactive.programming.ReactiveProgramming.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(ReservationResource.ROOM_V_1_RESERVATION)
@CrossOrigin
public class ReservationResource {
    public static final String ROOM_V_1_RESERVATION = "/room/v1/reservation/";

    private  ReservationService reservationService;

    @Autowired
    public ReservationResource(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping(path= "{roomId}",produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<Reservation> getReservationById(@PathVariable String roomId){
        return reservationService.getReservation(roomId);
    }

    @PostMapping(path="",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public Mono<Reservation> createReservation(@RequestBody Mono<Reservation> reservation){
        return reservationService.createReservation(reservation);
    }

    @PutMapping(path="{roomId}",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public Mono<Reservation> updatePrice(@RequestBody Mono<Reservation> reservation,@PathVariable String roomId){
        return reservationService.updateReservation(roomId,reservation);
    }

    @DeleteMapping(path="{roomId}")
    public Mono<Boolean> deleteReservation(@PathVariable String roomId){
        return reservationService.deleteReservation(roomId);
    }
}
