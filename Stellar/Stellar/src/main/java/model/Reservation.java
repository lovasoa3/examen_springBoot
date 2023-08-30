package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class Reservation {
    private Long id_reservation;
    private String date_reservation;
    private String date_sejour;
    private String fin_sejour;
    private String numero_chambre;
    private String type_chambre;
    private float tarif_chambre;
}
