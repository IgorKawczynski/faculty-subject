import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { HttpClient } from "@angular/common/http";
import { Observable } from 'rxjs';
import { UserResponseDTO } from "./users";

@Injectable({
  providedIn: 'root'
})
export class UsersService {

  private apiServerUrl = environment.apiUrl;

  constructor(private http: HttpClient) { }

  public getAllUsers(): Observable<UserResponseDTO[]>{
    return this.http.get<UserResponseDTO[]>(`${this.apiServerUrl}/api/users`)
  }
}
