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
    demandeConge: any = {};
    idUser: number = 1; // Remplacez par l'ID de l'utilisateur
    idEquipe: number = 1; // Remplacez par l'ID de l'équipe
    successMessage: string = '';
    errorMessage: string | undefined;
    constructor(private demandeCongeService: DemadecongeService) { }

    ngOnInit() {
        // Initialiser le formulaire ou effectuer toute autre opération lors de l'initialisation du composant
    }

    ajouterDemandeConge() {
        this.demandeCongeService.faireDemandeConge(this.demandeConge, this.idUser, this.idEquipe).subscribe(
            () => {
                this.successMessage = 'La demande de congé a été ajoutée avec succès.';
                this.demandeConge = new DemandeConge();
                this.errorMessage = undefined; // Réinitialise le message d'erreur
            },
            (error) => {
                console.error(error);
                this.successMessage = undefined; // Réinitialise le message de succès
                this.errorMessage = "le solde de conge est insuffisant "; // Affiche le message d'erreur
            }
        );
    }

}


