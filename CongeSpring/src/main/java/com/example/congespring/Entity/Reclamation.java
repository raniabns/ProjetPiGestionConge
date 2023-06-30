package com.example.congespring.Entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.UUID;

import org.springframework.web.multipart.MultipartFile;

@Entity
@Getter
@Setter
@ToString
public class Reclamation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idReclamation;
    private String titre;
    @Enumerated(EnumType.STRING)
    CategorieReclamation categorie;
    private String  description;
    @Temporal (TemporalType.DATE)
    private Date dateReclamation;
    @Enumerated(EnumType.STRING)
    TypeConge type;



    @ManyToOne
    private User user;



}