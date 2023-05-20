import { Injectable } from '@angular/core';
import {environment} from "../../environments/environment";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {UserRequestDTO} from "../dtos/user-request-dto";

@Injectable({
  providedIn: 'root'
})
export class UserAddFormService {

  private apiServerUrl = environment.apiUrl;

  constructor(private http: HttpClient) { }

  public registerUser(newUser: UserRequestDTO): Observable<Object> {
    return this.http.post<UserRequestDTO>(`${this.apiServerUrl}/api/users`, newUser);
  }
}
