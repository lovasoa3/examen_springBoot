package repository;

import model.Reservation;
import java.sql.SQLException;
import java.util.List;

public interface ReservationDAOInterface {
    List<Reservation> getAll() throws SQLException;
    List<Reservation> getById_reservation(int id_reservation) throws SQLException;
    Reservation insertReservation(Reservation toInsert);

}
