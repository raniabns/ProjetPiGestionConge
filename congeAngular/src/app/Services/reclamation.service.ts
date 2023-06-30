import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders, HttpResponse} from "@angular/common/http";
import {Observable} from "rxjs";
import {ReclamationConge} from "../Models/ReclamationConge";
@Injectable({
  providedIn: 'root'
})
export class ReclamationService {
  baseUrl ="http://localhost:8080/conge/recalamation";
  constructor(private http: HttpClient) { }
  getAll(): Observable<ReclamationConge[]> {
    return this.http.get<ReclamationConge[]>(`${this.baseUrl}/GetAllReclamations`);
  }
  addReclamation(reclamation: ReclamationConge): Observable<any> {
    return this.http.post(`${this.baseUrl}/AddReclamation`, reclamation);
  }
}
