import { Component, OnInit } from '@angular/core';
import {DemandeConge} from "../Models/DemandeConge";
import {ActivatedRoute} from "@angular/router";
import {DemadecongeService} from "../Services/demadeconge.service";

@Component({
  selector: 'app-list-demande',
  templateUrl: './list-demande.component.html',
  styleUrls: ['./list-demande.component.scss']
})
export class ListDemandeComponent implements OnInit {
    demandeConge: DemandeConge;
    idConge: number;
    demandeConges: DemandeConge[] = [];
  constructor(private ac:ActivatedRoute,
              private as:DemadecongeService) { }

  ngOnInit(): void {
      this.demandeConge = new DemandeConge();
      this.idConge = null;
      this.fetchDemandeConges()}
    rechercherDemandeConge(): void {
        if (this.idConge) {
            this.as.retrouverDemandeConge(this.idConge).subscribe(
                (demandeConge: DemandeConge) => {
                    this.demandeConge = demandeConge;
                },
                (error) => {
                    console.error(error);
                    // Gérer l'erreur
                }
            );
        }
    }
    fetchDemandeConges(): void {
        this.as.getAllDemandeConge().subscribe(
            (demandes: DemandeConge[]) => {
                this.demandeConges = demandes;
            },
            (error) => {
                console.error(error);
            }
        );
    }
}