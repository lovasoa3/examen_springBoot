package repository;

import model.Client;
import java.sql.SQLException;
import java.util.List;

public  interface CliantDAOInterface {

    Client insert(Client toInsert);

    List<Client> getAll() throws SQLException;

    List<Client> getById(int idcliant) throws SQLException;

    void deleteById(int idcliant);

    Client update(Client toUpdate);
}