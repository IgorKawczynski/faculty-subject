import { Injectable } from '@angular/core';
import {environment} from "../../environments/environment";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {ItemResponseDTO} from "./items";

@Injectable({
  providedIn: 'root'
})
export class ItemsService {

  private apiServerUrl = environment.apiUrl;

  constructor(private http: HttpClient) { }

  public getAllItems(): Observable<ItemResponseDTO[]>{
    return this.http.get<ItemResponseDTO[]>(`${this.apiServerUrl}/api/items/all`)
  }

}
