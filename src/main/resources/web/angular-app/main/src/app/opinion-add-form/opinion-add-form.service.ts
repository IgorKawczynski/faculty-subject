import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { OpinionRequestDTO } from '../dtos/opinion-request.dto';
import { Observable } from 'rxjs';
import {environment} from "../../environments/environment";

@Injectable({
  providedIn: 'root'
})
export class OpinionAddFormService {

  private apiServerUrl = environment.apiUrl;

  constructor(private http: HttpClient) { }

  public addOpinion(newOpinion: OpinionRequestDTO): Observable<Object>{
    return this.http.post<OpinionRequestDTO>(`${this.apiServerUrl}/api/opinions`, newOpinion);
  }

}
