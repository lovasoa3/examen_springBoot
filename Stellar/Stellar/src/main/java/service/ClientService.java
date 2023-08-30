package service;

import model.Client;
import org.springframework.stereotype.Service;
import repository.ClientDAO;

import java.sql.SQLException;
import java.util.List;


@Service
public class ClientService {

    private static ClientDAO dao;

    public ClientService(ClientDAO dao) {
        System.out.println("Appel du constructeur de service");
        ClientService.dao = dao;
    }


    // le metier de votre application : tous les traitements de votre theme.
    public List<Client> getAllClients() throws SQLException {
        return dao.getAll();
    }
    public List<Client> getOneClient(int idcliant)throws SQLException{
        return dao.getById(idcliant);
    }
    public Client insert(Client toInsert){
        return dao.insert(toInsert);
    }
    public void deleteById(int idcliant){
        dao.deleteById(idcliant);
    }
    public Client update(Client toUpdate){
        return dao.update(toUpdate);
    };
}
