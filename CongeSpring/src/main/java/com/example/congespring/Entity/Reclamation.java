package com.example.congespring.Entity;



import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
public class Reclamation  implements Serializable
{

 private static final long serialVersionUID = 1L ;

@Id
@GeneratedValue (strategy = GenerationType.IDENTITY)
private Long idReclamation;
private String titre;
private String  description;
@Enumerated(EnumType.STRING)
private categorieReclamation  categoriereclamation;

    /**@JsonIgnore
    @OneToMany(mappedBy = "client")
    private  List <Facture> Factures;**/

}











