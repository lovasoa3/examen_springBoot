package controleur;

import model.Client;
import model.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.ClientService;
import service.ReservationService;

import java.sql.SQLException;
import java.util.List;
@RestController
public class ClientControleur {
    @Autowired
    private ClientService clientService;


    public ClientControleur(ClientService clientService) {
        System.out.println("Appel du constructeur de controller");
        this.clientService = clientService;

    }

    @GetMapping("/clients")
    public List<Client> getAllClients() throws SQLException {
        return clientService.getAllClients();
    }
    @GetMapping("/client/{idcliant}")
   public List<Client> getOneClient (@PathVariable int idcliant)throws SQLException{
        return clientService.getOneClient(idcliant);
   }
   @PostMapping("/new/client")
   public Client insert(@RequestBody Client toInsert){
        return clientService.insert(toInsert);

    }
    @DeleteMapping("/delete/{idcliant}")
    public void deleteById(int idcliant){
        clientService.deleteById(idcliant);
    }
    @PatchMapping("/update/client/{idcliant}")
     public Client update(@RequestBody Client toUpdate){
        return clientService.update(toUpdate);
    }
}












