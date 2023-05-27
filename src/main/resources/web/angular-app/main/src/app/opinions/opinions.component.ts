import { Component, OnInit } from '@angular/core';
import { OpinionResponseDTO } from './opinions';
import { OpinionsService } from './opinions.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-opinions',
  templateUrl: './opinions.component.html',
  styleUrls: ['./opinions.component.css']
})
export class OpinionsComponent implements OnInit{

  public opinions: OpinionResponseDTO[] = [];
  constructor(private opinionsService: OpinionsService, private router: Router) { }

  ngOnInit(): void {
    this.getAllOpinions();
  }

  public route(url: string) {
    this.router.navigateByUrl(url).then(() => null);
  }

  public getAllOpinions(): void {
    this.opinionsService.getAllOpinions().subscribe((response: any) =>{
      this.opinions = response;
    })
  }

}
