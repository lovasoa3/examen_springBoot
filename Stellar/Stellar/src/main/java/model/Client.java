package model;

import lombok.*;


@AllArgsConstructor
@Getter
@Setter
@ToString
public class Client {
        private long idClient;
        private String nom;
        private String prenom;
        private String email;
        private String genre;
}
