import { Component, OnInit } from '@angular/core';
import {DemandeConge} from "../Models/DemandeConge";
import {DemadecongeService} from "../Services/demadeconge.service";
import {forms} from "@angular/core/schematics/migrations/typed-forms/util";

@Component({
  selector: 'app-user-profile',
  templateUrl: './Demandeconge.component.html',
  styleUrls: ['./Demandeconge.component.css']
})
export class Demandeconge implements OnInit {
    demandeConge: any = {};
    idUser: number = 1; // Remplacez par l'ID de l'utilisateur
    idEquipe: number = 1; // Remplacez par l'ID de l'équipe
    successMessage: string = '';
    errorMessage: string | undefined;
    idConge: number;
    succesMessage: string = '';
    errMessage: string | undefined;
    constructor(private demandeCongeService: DemadecongeService) {
    }

    ngOnInit() {
        this.demandeConge = new DemandeConge();

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

    chargerDemandeConge() {
        if (this.idConge) {
            this.demandeCongeService.retrouverDemandeConge(this.idConge).subscribe(
                (demandeConge: DemandeConge) => {
                    this.demandeConge = demandeConge;
                },
                (error) => {
                    console.error(error);
                }
            );
        }}

    modifierDemandeConge() {
        this.demandeCongeService.modifierDemandeConge(this.idConge, this.demandeConge).subscribe(
            () => {
                // Succès de la modification de la demande de congé
                this.succesMessage = 'La demande de congé a été modifiée avec succès.';
                this.errMessage = undefined; // Réinitialise le message d'erreur
            },
            (error) => {
                console.error(error);
                this.succesMessage = undefined; // Réinitialise le message de succès
                this.errMessage = 'Une erreur s\'est produite lors de la modification de la demande de congé.'; // Affiche le message d'erreur
            }
        );
    }
}


