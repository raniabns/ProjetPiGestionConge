import { Injectable } from '@angular/core';
import {HttpClient, HttpErrorResponse, HttpHeaders, HttpResponse} from "@angular/common/http";
import {map, Observable, throwError} from "rxjs";
import {DemandeConge} from "../Models/DemandeConge";
import { catchError } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class DemadecongeService {


  private baseUrl = 'http://localhost:8080/conge/DemandeConge';




  constructor(private http: HttpClient) { }






    faireDemandeConge(demandeConge: any, idUser: number, idEquipe: number): Observable<string> {
        const url = `${this.baseUrl}/demandes/${idUser}/${idEquipe}`;
        return this.http.post(url, demandeConge, { responseType: 'text' }).pipe(
            map((response: any) => {
                try {
                    const jsonResponse = JSON.parse(response);
                    return jsonResponse.message || response;
                } catch (error) {
                    return response;
                }
            })
        );
    }



    retrouverDemandeConge(idConge: number): Observable<DemandeConge> {
        return this.http.get<DemandeConge>(`${this.baseUrl}/TrouverUnedemandeConge/${idConge}`);
    }
    getAllDemandeConge(): Observable<DemandeConge[]> {
        const url = `${this.baseUrl}/allDemandeConge`;
        return this.http.get<DemandeConge[]>(url);
    }
}
