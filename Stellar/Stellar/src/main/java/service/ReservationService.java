package service;

import model.Client;
import model.Reservation;
import org.springframework.stereotype.Service;
import repository.ReservationDAO;

import java.sql.SQLException;
import java.util.List;
@Service
public class ReservationService {
    private ReservationDAO DAO;

    public ReservationService(ReservationDAO DAO){
        this.DAO=DAO;
    }
    public List<Reservation> getAllReservation() throws SQLException{
        return DAO.getAll();
    }
    public List<Reservation> getOneReservation(int id_reservation)throws SQLException{
        return DAO.getById_reservation(id_reservation);
    }
    public Reservation insertReservation(Reservation toInsert){
        return DAO.insertReservation(toInsert);
    }
}
