import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders, HttpResponse} from "@angular/common/http";
import {Observable} from "rxjs";
import {DemandeConge} from "../Models/DemandeConge";

@Injectable({
  providedIn: 'root'
})
export class DemadecongeService {

  baseUrl ="http://localhost:8080/conge/swagger-ui/index.html#/DemandeConge/";

  constructor(private http: HttpClient) { }

  faireDemandeConge(demandeConge: DemandeConge, idUser: number, idEquipe: number): Observable<HttpResponse<any>> {
    const url = `${this.baseUrl}/demandes/${idUser}/${idEquipe}`;
    const headers = new HttpHeaders({ 'Content-Type': 'application/json' });

    return this.http.post<any>(url, demandeConge, { headers, observe: 'response' });
  }
}
