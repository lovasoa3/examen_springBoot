package repository;

import model.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ReservationDAO implements ReservationDAOInterface {
    private Connection connection;

    @Autowired
    public ReservationDAO(Connection connection) {
        this.connection = connection;
    }

    private void convertToList(List<Reservation> allReservations, ResultSet result) throws SQLException {
        allReservations.add(new Reservation(
                result.getLong("id_reservation"),
                result.getString("date_reservation"),
                result.getString("date_sejour"),
                result.getString("fin_sejour"),
                result.getString("numero_chambre"),
                result.getString("type_chambre"),
                result.getFloat("tarif_chambre")
        ));
    }

    @Override
    public List<Reservation> getAll() throws SQLException {
        List<Reservation> allReservations = new ArrayList<>();
        String sql = "SELECT * FROM \"reservation\"";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            ResultSet result = preparedStatement.executeQuery();

            while (result.next()) {
                convertToList(allReservations, result);
            }
        }

        return allReservations;
    }

    @Override
    public List<Reservation> getById_reservation(int id_reservation) {
        List<Reservation> allReservations = new ArrayList<>();
        String sql = "SELECT * FROM \"reservation\" WHERE id_reservation = ? ";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id_reservation);

            try (ResultSet result = preparedStatement.executeQuery()) {
                while (result.next()) {
                    convertToList(allReservations, result);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return allReservations;
    }
    @Override
    public Reservation insertReservation(Reservation toInsert) {
        try {
            String sql ="INSERT INTO reservation('date_reservation','date_sejour','fin_sejour','numero_chambre','type_chambre','tarif_chambre')VALUE (?,?,?,?,?,?)";

            try( PreparedStatement preparedStatement=connection.prepareStatement(sql)){
                        preparedStatement.setString(1,toInsert.getDate_reservation());
                        preparedStatement.setString(2,toInsert.getDate_sejour());
                        preparedStatement.setString(3,toInsert.getFin_sejour());
                        preparedStatement.setString(4,toInsert.getNumero_chambre());
                        preparedStatement.setString(5,toInsert.getType_chambre());
                        preparedStatement.setFloat(6,toInsert.getTarif_chambre());

                        preparedStatement.executeUpdate();

          }
        }  catch (SQLException e) {
            System.out.println(e);;
        }
        return toInsert;
    }
}