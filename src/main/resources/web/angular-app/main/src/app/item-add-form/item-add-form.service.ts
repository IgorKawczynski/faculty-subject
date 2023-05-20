import { Injectable } from '@angular/core';
import {environment} from "../../environments/environment";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {ItemRequestDTO} from "../dtos/item-request-dto";

@Injectable({
  providedIn: 'root'
})
export class ItemAddFormService {

  private apiServerUrl = environment.apiUrl;

  constructor(private http: HttpClient) { }

  public addItem(newItem: ItemRequestDTO): Observable<Object> {
    return this.http.post<ItemRequestDTO>(`${this.apiServerUrl}/api/items`, newItem);
  }
}
