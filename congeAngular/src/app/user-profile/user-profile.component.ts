import { Component, OnInit } from '@angular/core';
import {DemandeConge} from "../Models/DemandeConge";
import {DemadecongeService} from "../Services/demadeconge.service";
import {forms} from "@angular/core/schematics/migrations/typed-forms/util";

@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.css']
})
export class UserProfileComponent implements OnInit {
    demandeConge!: DemandeConge;
  idUser: number;
  idEquipe: number;
    successMessage: string;
    errorMessage: string;

  constructor(private demandeCongeService: DemadecongeService) {}

  ngOnInit() {
    // Initialisez ici les valeurs dynamiques des variables idUser et idEquipe
    this.idUser = 1/* Logique pour obtenir l'ID de l'utilisateur dynamiquement */;
    this.idEquipe = 1/* Logique pour obtenir l'ID de l'équipe dynamiquement */;
  }

    onSubmit() {
        this.demandeCongeService.faireDemandeConge(this.demandeConge, this.idUser, this.idEquipe)
            .subscribe(
                (response) => {
                    // La demande de congé a été acceptée
                    console.log('Demande de congé créée avec succès.', response.body);
                    this.successMessage = 'Congé créé avec succès.';
                    this.errorMessage = null;
                    // Effectuez ici les actions nécessaires après la création de la demande de congé réussie
                },
                (error) => {
                    // Une erreur s'est produite lors de la demande de congé
                    console.error('Impossible de créer la demande de congé.', error.error);
                    this.successMessage = null;
                    this.errorMessage = 'Erreur lors de la création du congé.';
                    // Effectuez ici les actions nécessaires en cas d'échec de la demande de congé
                }
            );
    }
}


