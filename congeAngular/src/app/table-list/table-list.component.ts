import { Component, OnInit } from '@angular/core';
import {ReclamationConge} from "../Models/ReclamationConge";
import {ReclamationService} from "../Services/reclamation.service";
import {DemandeConge} from "../Models/DemandeConge";


@Component({
  selector: 'app-table-list',
  templateUrl: './table-list.component.html',
  styleUrls: ['./table-list.component.css']
})
export class TableListComponent implements OnInit {
  reclamations?: ReclamationConge[];
  newReclamation: ReclamationConge = new ReclamationConge();

  constructor(private reclamationService: ReclamationService) { }

  ngOnInit() {
    this.retrieveAllReclamations();

  }


  retrieveAllReclamations(): void {
    this.reclamationService.getAll()
        .subscribe({
          next: (data) => {
            this.reclamations = data;
            console.log(data);
          },
          error: (e) => console.error(e)
        });
  }

    // ... Previous code ...

    addReclamation(reclamation: ReclamationConge): void {
        const currentTime = new Date().toLocaleTimeString([], { hour: '2-digit', minute: '2-digit' });
        reclamation.dateReclamation = new Date(); // Set the current date and time
        this.reclamationService.addReclamation(reclamation).subscribe({
            next: (response) => {
                console.log('Reclamation added successfully:', response);
                this.retrieveAllReclamations(); // Refresh the list of reclamations
                // Optionally, you can reset the newReclamation object
                this.newReclamation = new ReclamationConge();
            },
            error: (e) => console.error('Failed to add reclamation:', e)
        });
    }

    getCurrentTime(): string {
        const now = new Date();
        return now.toLocaleTimeString([], { hour: '2-digit', minute: '2-digit' });
    }

}
