import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { OpinionResponseDTO } from './opinions';

@Injectable({
  providedIn: 'root'
})
export class OpinionsService {

  private apiServerUrl = environment.apiUrl;

  constructor(private http: HttpClient) { }

  public getAllOpinions(): Observable<OpinionResponseDTO[]>{
    return this.http.get<OpinionResponseDTO[]>(`${this.apiServerUrl}/api/opinions/all`)
  }

}
