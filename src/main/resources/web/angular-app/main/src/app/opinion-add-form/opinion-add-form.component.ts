import { Component } from '@angular/core';
import { OpinionRequestDTO } from '../dtos/opinion-request.dto';
import { OpinionAddFormService } from './opinion-add-form.service';
import { MessageService, PrimeNGConfig } from 'primeng/api';
import { Router } from '@angular/router';

@Component({
  selector: 'app-opinion-add-form',
  templateUrl: './opinion-add-form.component.html',
  styleUrls: ['./opinion-add-form.component.css']
})
export class OpinionAddFormComponent {

  opinionRequestDto: OpinionRequestDTO = new OpinionRequestDTO();

  constructor(
    private opinionAddFormService: OpinionAddFormService,
    private primengConfig: PrimeNGConfig,
    private router: Router,
    private messageService: MessageService
  ) { }

  ngOnInit(): void {

  }

  btnAddOpinion(): void {
    this.addOpinion();
  }

  public addOpinion() {
    this.opinionAddFormService
      .addOpinion(this.opinionRequestDto).subscribe(
      (response: any) => {
        this.messageService.add({
          life: 3000,
          severity: 'success',
          summary: 'Opinion added',
          detail: 'You have successfully added an opinion!'
        })
      },
      (error) => {
        this.messageService.add({
          severity: 'error',
          summary: 'Error',
          detail: error?.error
        });
      });
  }

}
