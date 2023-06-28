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
  demandeConge =new DemandeConge();
  constructor(private ac:ActivatedRoute,
              private as:DemadecongeService) { }

  ngOnInit(): void {
    this.as.RetrouverDemandeConge(this.ac.snapshot.params['idConge']).subscribe(
        (d)=>{
          this.demandeConge=d;
        }
    );
    this.ac.params.subscribe(
        (d)=>{
          console.log(d)
        }
    );
    //console.log(d);
    // console.log(this.ac.snapshot.params['test'])

  }
  test(){
    //traitement
  }

  protected readonly DemandeConge = DemandeConge;
}
