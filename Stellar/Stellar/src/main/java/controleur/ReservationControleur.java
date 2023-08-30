package controleur;

import model.Client;
import model.Reservation;
import org.springframework.web.bind.annotation.*;
import service.ReservationService;

import java.sql.SQLException;
import java.util.List;

@RestController
public class ReservationControleur {
    private ReservationService reservationService;
    public ReservationControleur(ReservationService reservationService){
        this.reservationService=reservationService;
    }

    @GetMapping("/reservation")
    public List<Reservation> getAllReservation() throws SQLException {
        return reservationService.getAllReservation();
    }
    @GetMapping("/reservation/{id_reservation}")
    public List<Reservation> getOneReservation (@PathVariable int id_reservation)throws SQLException{
        return reservationService.getOneReservation(id_reservation);
    }
    @PostMapping("/new/reservation")
    public Reservation insertReservation(@RequestBody Reservation toInsert){
        return reservationService.insertReservation(toInsert);
    }
}
