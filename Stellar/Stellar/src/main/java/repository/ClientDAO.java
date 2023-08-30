package repository;

import model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
    public class ClientDAO implements CliantDAOInterface {
    private Connection connection;

    @Autowired
    public ClientDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Client> getAll() throws SQLException {
        List<Client> allClients = new ArrayList<>();
        String sql = "SELECT * FROM \"cliant\"";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            ResultSet result = preparedStatement.executeQuery();

            while (result.next()) {
                convertToList(allClients, result);
            }
        }

        return allClients;
    }

    @Override
    public List<Client> getById(int idcliant) {
        List<Client> allClients = new ArrayList<>();
        String sql = "SELECT * FROM \"cliant\" WHERE idcliant = ? ";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, idcliant);

            try (ResultSet result = preparedStatement.executeQuery()) {
                while (result.next()) {
                    convertToList(allClients, result);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return allClients;
    }


    @Override
    public Client insert(Client toInsert) {
        try {
            String sql = "INSERT INTO cliant ('nom', 'prenom', 'email', 'genre') VALUES (?, ?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, toInsert.getNom());
                preparedStatement.setString(2, toInsert.getPrenom());
                preparedStatement.setString(3, toInsert.getEmail());
                preparedStatement.setString(4, toInsert.getGenre());

                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        return toInsert;
    }


    private void convertToList(List<Client> allClients, ResultSet result) throws SQLException {
        allClients.add(new Client(
                result.getInt("idCliant"),
                result.getString("nom"),
                result.getString("prenom"),
                result.getString("email"),
                result.getString("genre")
        ));
    }

    public void deleteById(int idCliant) {

        String SQL = "DELETE FROM client WHERE idcliant = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL)) {
            preparedStatement.setInt(1, idCliant);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Client update(Client toUpdate) {
        String sql = "UPDATE cliant SET nom = ?, prenom = ?, email = ?, genre = ? WHERE idcliant = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, toUpdate.getNom());
            preparedStatement.setString(2, toUpdate.getPrenom());
            preparedStatement.setString(3, toUpdate.getEmail());
            preparedStatement.setString(4, toUpdate.getGenre());
            preparedStatement.setInt(5, (int) toUpdate.getIdClient());

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Mise à jour effectuée avec succès !");
            } else {
                System.out.println("Aucune mise à jour effectuée.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return toUpdate;
    }

}

